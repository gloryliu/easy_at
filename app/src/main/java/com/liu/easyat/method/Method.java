package com.liu.easyat.method;

import android.text.Spannable;
import android.widget.EditText;

import com.liu.easyat.User;

/**
 * @author liuzhenrong
 * @date 12/16/20 11:06 AM
 * @desc
 */
public interface Method {
    void init(EditText editText);
    Spannable newSpannable(User user);
}
