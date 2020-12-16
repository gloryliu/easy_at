package com.liu.eastat.watcher;

import android.text.Selection;
import android.text.Spannable;

/**
 * @author liuzhenrong
 * @date 12/15/20 6:21 PM
 * @desc
 */
public class SelectionSpanWatcher<T> extends SpanWatcherAdapter{
    private Class<T> kClass;
    private int selStart = 0;
    private int selEnd = 0;

    public SelectionSpanWatcher(Class<T> kClass) {
        this.kClass = kClass;
    }

    @Override
    public void onSpanChanged(Spannable text, Object what, int ostart, int oend, int nstart, int nend) {
        if(Selection.SELECTION_END.equals(what) && selEnd != nstart){
            selEnd = nstart;
            T[] spans = text.getSpans(nstart,nend,kClass);
            if(spans!=null && spans.length>0){
                T tag = spans[0];
                int spanStart = text.getSpanStart(tag);
                int spanEnd = text.getSpanEnd(tag);
                int index = (Math.abs(selEnd - spanEnd) > Math.abs(selEnd - spanStart))? spanStart:spanEnd;
                Selection.setSelection(text,Selection.getSelectionStart(text),index);
            }
        }
        if(Selection.SELECTION_START.equals(what) && selStart != nstart){
            selStart = nstart;
            T[] spans = text.getSpans(nstart,nend,kClass);
            if(spans!=null && spans.length>0){
                T tag = spans[0];
                int spanStart = text.getSpanStart(tag);
                int spanEnd = text.getSpanEnd(tag);
                int index = (Math.abs(spanStart - spanEnd) > Math.abs(selStart - spanStart))? spanStart:spanEnd;
                Selection.setSelection(text,Selection.getSelectionStart(text),index);
            }
        }
    }
}



























