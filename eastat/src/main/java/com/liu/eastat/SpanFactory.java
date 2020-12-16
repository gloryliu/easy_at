package com.liu.eastat;

import android.text.Spannable;
import android.text.SpannableString;

/**
 * @author liuzhenrong
 * @date 12/16/20 10:58 AM
 * @desc
 */
public class SpanFactory {
    public static Spannable newSpannable(CharSequence source,Object... spans){
        SpannableString ss = SpannableString.valueOf(source);
        for (Object obj:spans) {
            ss.setSpan(obj,0,ss.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return ss;
    }
}
