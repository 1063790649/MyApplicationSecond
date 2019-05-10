package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pojo.User;

public class MainActivity extends AppCompatActivity {
    private int RequestCode=1023;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=(Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSecondActivity();
            }
        });
        Button btn2=findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button2){
                    //Toast.makeText(MainActivity.this,"你点击了控件:"+((TextView)v).getText(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(v.getId()==R.id.button2){
                    Toast.makeText(MainActivity.this,"你长按了控件:"+((TextView)v).getText(),Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
    private void gotoSecondActivity(){
        Intent intent=new Intent();
        //intent.setClass(this,SecondActivity.class);
        intent.setAction("com.example.myapplication.SecondActivity");
        //intent.putExtra("string","Rick");
        //intent.putExtra("int",25);
        User user=new User();
        Bundle bundle=new Bundle();
        user.setName("Android");
        user.setAge(10);
        bundle.putSerializable("user",user);
        intent.putExtras(bundle);
        //startActivity(intent);
        startActivityForResult(intent,RequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RequestCode && resultCode==SecondActivity.RESULT_CODE){
            Bundle bundle=data.getExtras();
            String name=bundle.getString("name");
            String string=bundle.getString("string");
            int age=bundle.getInt("int");
            Toast.makeText(MainActivity.this,"onCreate:string :"+string+",int:"+age+",name:"+name,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }
}
