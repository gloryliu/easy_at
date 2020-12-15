package com.liu.eastat.watcher;

import android.text.Spannable;

import com.liu.eastat.span.DirtySpan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhenrong
 * @date 12/15/20 6:10 PM
 * @desc
 */
public class DirtySpanWatcher extends SpanWatcherAdapter{
    @Override
    public void onSpanChanged(Spannable text, Object what, int ostart, int oend, int nstart, int nend) {
        if(what instanceof DirtySpan && ((DirtySpan) what).isDirty(text)){
            int spanStart = text.getSpanStart(what);
            int spanEnd = text.getSpanEnd(what);
            Object[] spans = text.getSpans(spanStart,spanEnd,Object.class);
            List<Object> temp = new ArrayList<>();
            for (Object obj:spans) {
                if(obj instanceof DirtySpan){
                    temp.add(obj);
                }
            }
            for (Object obj:temp) {
                text.removeSpan(obj);
            }
        }
    }
}
























