package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private Button btn_icon;
    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btn_icon=findViewById(R.id.btn_icon);
        drawable=getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        Button btn_left=findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_icon.setCompoundDrawables(drawable,null,null,null);
            }
        });
        Button btn_right=findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_icon.setCompoundDrawables(null,null,drawable,null);
            }
        });
        /*
        LinearLayout linearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView textView=new TextView(this);
        LinearLayout.LayoutParams textViewParam=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        textView.setLayoutParams(textViewParam);
        textView.setText("我是这本书的作者");
        textView.setTextSize(30);
        linearLayout.addView(textView);
        super.addContentView(linearLayout,params);
        */
    }
}
