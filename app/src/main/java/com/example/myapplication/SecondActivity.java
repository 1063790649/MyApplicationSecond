package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pojo.User;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private Handler mHandler=new Handler();
    private ImageView iv=null;
    public static final int RESULT_CODE=2003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final TextView tv1=(TextView) findViewById(R.id.textView4);
        final TextView tv2=(TextView) findViewById(R.id.textView5);
        iv=(ImageView) findViewById(R.id.imageView4);
        iv.setDrawingCacheEnabled(true);
        Button btn1=(Button) findViewById(R.id.button3);
        Button btn2=(Button) findViewById(R.id.button4);
        tv2.setGravity(Gravity.LEFT|Gravity.BOTTOM);
        tv2.setLines(8);
        tv2.setMaxLines(8);
        tv2.setMovementMethod(new ScrollingMovementMethod());
        final String[] attr={"你吃饭了吗？","今天天气真好啊！","我中奖啦！","我们去看电影吧","晚上干什么好昵"};
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random=(int)(Math.random()*5);
                String newStr=String.format("%s\n%s",
                        tv2.getText().toString(),attr[random]);
                tv2.setText(newStr);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv2.setText("");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap=iv.getDrawingCache();
                iv.setImageBitmap(bitmap);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iv.setDrawingCacheEnabled(false);
                        iv.setDrawingCacheEnabled(true);
                    }
                }, 200);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String string=bundle.getString("string");
        int age=bundle.getInt("int");
        User  user=(User)bundle.get("user");
        intent.putExtra("name","XIAOMING");
        Toast.makeText(SecondActivity.this,"onCreate:string :"+string+",int:"+age+",name:"+user.getName()+",age:"+user.getAge(),Toast.LENGTH_LONG).show();
        Log.i("SecondActivity.class", "onCreate:string :"+string+",int:"+age);
        setResult(RESULT_CODE,intent);
    }
}
