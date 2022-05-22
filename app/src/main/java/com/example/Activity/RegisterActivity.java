package com.example.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.DataBase.DBUtil;
import com.example.myapplication.R;
//注册页面
public class RegisterActivity extends AppCompatActivity {
    public Button rsgister_button;
    public EditText rsgister_password1;
    public EditText rsgister_password2;
    public EditText rsgister_username;
    public EditText rsgister_phone;
    public DBUtil dbutil=new DBUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rsgister_button=findViewById(R.id.rsgister_button);
        rsgister_password1=findViewById(R.id.rsgister_password1);
        rsgister_password2=findViewById(R.id.rsgister_password2);
        rsgister_username=findViewById(R.id.rsgister_username);
        rsgister_phone=findViewById(R.id.rsgister_phone);

        rsgister_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonusername=rsgister_username.getText().toString();
                String buttonpassword1=rsgister_password1.getText().toString();
                String buttonpassord2=rsgister_password2.getText().toString();
                String buttonphone=rsgister_phone.getText().toString();
                if(buttonpassword1==buttonpassord2){
                    if(dbutil.register(buttonusername,buttonphone,buttonpassword1)){
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this,"该用户已存在",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
