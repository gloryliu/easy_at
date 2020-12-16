package com.liu.easyat.method;


import android.text.Spannable;
import android.widget.EditText;

import com.liu.easyat.User;

/**
 * @author liuzhenrong
 * @date 12/16/20 11:14 AM
 * @desc
 */
public class MethodContext implements Method {
    public Method method;

    @Override
    public void init(EditText editText) {
        if(method!=null){
            method.init(editText);
        }
    }

    @Override
    public Spannable newSpannable(User user) {
        if(method!=null){
            return method.newSpannable(user);
        }else {
            throw new NullPointerException("method null");
        }
    }
}
