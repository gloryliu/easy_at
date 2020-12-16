package com.liu.easyat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liu.easyat.method.Method;
import com.liu.easyat.method.MethodContext;
import com.liu.easyat.method.Weibo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnAppend;
    private Button btnSwitch;
    private Button btnPrint;
    private EditText normalEdit;
    private TextView txtLogs;

    private List<Method> methods = Arrays.asList(new Weibo());
    private Iterator<Method> iterator = methods.iterator();
    private MethodContext methodContext = new MethodContext();
    private List<User> users = Arrays.asList(
            new User("1", "激浊扬清"),
            new User("2", "清风引佩下瑶台"),
            new User("3", "浊泾清渭"),
            new User("4", "刀光掩映孔雀屏"),
            new User("5", "清风徐来"),
            new User("6", "英雄无双风流婿"),
            new User("7", "源清流洁"),
            new User("8", "占断人间天上福"),
            new User("9", "清音幽韵"),
            new User("10", "碧箫声里双鸣凤"),
            new User("11", "风清弊绝"),
            new User("12", "天教艳质为眷属"),
            new User("13", "独清独醒"),
            new User("14", "千金一刻庆良宵"),
            new User("15", "必须要\\n\n，不然不够长")
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAppend = findViewById(R.id.btnAppend);
        btnSwitch = findViewById(R.id.btnSwitch);
        btnPrint = findViewById(R.id.btnPrint);
        normalEdit = findViewById(R.id.normalEdit);
        txtLogs = findViewById(R.id.txtLogs);

        btnAppend.setOnClickListener(v -> {
            if(methodContext.method == null){
                switchMethod();
            }
            User user = users.get(new Random().nextInt(15));
            ((SpannableStringBuilder)normalEdit.getText())
                    .insert(normalEdit.getSelectionStart(),methodContext.newSpannable(user));
        });
        btnSwitch.setOnClickListener(v->{
            switchMethod();
        });
        btnPrint.setOnClickListener(v->{
            Editable editable = normalEdit.getText();
           User[] users =  editable.getSpans(0,normalEdit.length(),User.class);
            StringBuffer sb = new StringBuffer();
            for (User user:users){
                sb.append(user.toString());
                sb.append(editable.getSpanStart(user));
                sb.append(",");
                sb.append(editable.getSpanEnd(user));
                sb.append("\n");
            }
            txtLogs.setText(sb.toString());
            txtLogs.scrollTo(0,0);
        });
        txtLogs.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    private void switchMethod(){
        Method method = circularMethod();
        methodContext.method = method;
        btnSwitch.setText(method.getClass().getSimpleName());
        methodContext.init(normalEdit);
    }

    private Method circularMethod(){
        if(iterator.hasNext()){
            return iterator.next();
        }else {
            iterator = methods.iterator();
            return circularMethod();
        }
    }
}
















