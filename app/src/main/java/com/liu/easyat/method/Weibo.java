package com.liu.easyat.method;

import android.text.Spannable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.liu.eastat.KeyCodeDeleteHelper;
import com.liu.eastat.NoCopySpanEditableFactory;
import com.liu.eastat.SpanFactory;
import com.liu.eastat.span.DataBindingSpan;
import com.liu.eastat.watcher.SelectionSpanWatcher;
import com.liu.easyat.User;

/**
 * @author liuzhenrong
 * @date 12/16/20 11:22 AM
 * @desc
 */
public class Weibo implements Method{
    @Override
    public void init(EditText editText) {
        editText.setText(null);
        editText.setEditableFactory(new NoCopySpanEditableFactory(new SelectionSpanWatcher(DataBindingSpan.class)));
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN){
                    return KeyCodeDeleteHelper.onDelDown(((EditText)v).getText());
                }
                return false;
            }
        });
    }

    @Override
    public Spannable newSpannable(User user) {
        return SpanFactory.newSpannable(user.getSpannableName(),user);
    }
}
