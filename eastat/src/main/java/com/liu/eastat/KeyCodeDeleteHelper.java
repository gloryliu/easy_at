package com.liu.eastat;

import android.text.Selection;
import android.text.Spannable;

import com.liu.eastat.span.DataBindingSpan;

/**
 * @author liuzhenrong
 * @date 12/16/20 10:37 AM
 * @desc
 */
public class KeyCodeDeleteHelper {
    public static boolean onDelDown(Spannable text){
        int selectionStart = Selection.getSelectionStart(text);
        int selectionEnd = Selection.getSelectionEnd(text);
        DataBindingSpan[] spans = text.getSpans(selectionStart,selectionEnd,DataBindingSpan.class);
        DataBindingSpan firstSpan = null;
        for (DataBindingSpan span:spans) {
            if(text.getSpanEnd(span) == selectionStart){
                firstSpan = span;
                break;
            }
        }
        if(firstSpan != null){
            int spanStart = text.getSpanStart(firstSpan);
            int spanEnd = text.getSpanEnd(firstSpan);
            Selection.setSelection(text,spanStart,spanEnd);
            return selectionStart == selectionEnd;
        }
        return false;
    }
}













