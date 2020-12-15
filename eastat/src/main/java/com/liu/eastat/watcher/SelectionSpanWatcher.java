package com.liu.eastat.watcher;

import android.text.Selection;
import android.text.Spannable;

/**
 * @author liuzhenrong
 * @date 12/15/20 6:21 PM
 * @desc
 */
class SelectionSpanWatcher<T> extends SpanWatcherAdapter{
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
            text.getSpans(nstart,nend,kClass);
        }
        if(Selection.SELECTION_START.equals(what) && selStart != nstart){
            selStart = nstart;
            text.getSpans(nstart,nend,kClass);
        }
    }
}



























