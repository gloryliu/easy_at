package com.liu.easyat;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import com.liu.eastat.span.DataBindingSpan;
import com.liu.eastat.span.DirtySpan;

/**
 * @author liuzhenrong
 * @date 12/16/20 11:07 AM
 * @desc
 */
public class User implements DataBindingSpan, DirtySpan {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spannable getSpannableName(){
        SpannableString ss = new SpannableString(name);
        ss.setSpan(new ForegroundColorSpan(Color.CYAN),0,ss.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    @Override
    public boolean isDirty(Spannable text) {
        int spanStart = text.getSpanStart(this);
        int spanEnd = text.getSpanEnd(this);
        return spanStart >= 0 && spanEnd >= 0 && !String.format("@%s",name).equals(text.subSequence(spanStart,spanEnd));
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}















