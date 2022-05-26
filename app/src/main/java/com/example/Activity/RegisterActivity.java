package com.example.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    public RadioButton radioButton;
    public DBUtil dbutil = new DBUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rsgister_button = findViewById(R.id.rsgister_button);
        rsgister_password1 = findViewById(R.id.rsgister_password1);
        rsgister_password2 = findViewById(R.id.rsgister_password2);
        rsgister_username = findViewById(R.id.rsgister_username);
        rsgister_phone = findViewById(R.id.rsgister_phone);
        radioButton = findViewById(R.id.radio_btn);

        rsgister_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonusername = rsgister_username.getText().toString();
                String buttonpassword1 = rsgister_password1.getText().toString();
                String buttonpassword2 = rsgister_password2.getText().toString();
                String buttonphone = rsgister_phone.getText().toString();
                if (buttonusername.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "用户名不可为空", Toast.LENGTH_SHORT).show();
                } else if (buttonphone.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                } else if (buttonpassword1.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "密码不可为空", Toast.LENGTH_SHORT).show();
                } else if (buttonpassword2.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                } else if (buttonpassword1.equals(buttonpassword2)) {
                    if (dbutil.register(buttonusername, buttonphone, buttonpassword1)) {
                        if(!radioButton.isChecked()){
                            Toast.makeText(RegisterActivity.this,"请勾选用户协议",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    } else {
                        Toast.makeText(RegisterActivity.this, "该用户已存在", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
