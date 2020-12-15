package com.liu.eastat.span;

import android.text.Spannable;

/**
 * @author liuzhenrong
 * @date 12/15/20 6:07 PM
 * @desc
 */
public interface DirtySpan {
    boolean isDirty(Spannable text);
}
