package com.liu.eastat;

import android.text.Editable;
import android.text.NoCopySpan;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

/**
 * @author liuzhenrong
 * @date 12/16/20 10:47 AM
 * @desc
 */
public class NoCopySpanEditableFactory extends Editable.Factory {
    private NoCopySpan[] spans;

    public NoCopySpanEditableFactory(NoCopySpan... spans) {
        this.spans = spans;
    }

    @Override
    public Editable newEditable(CharSequence source) {
        SpannableStringBuilder ssb = SpannableStringBuilder.valueOf(source);
        for (NoCopySpan span:spans) {
            ssb.setSpan(span,0,source.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return ssb;
    }
}
