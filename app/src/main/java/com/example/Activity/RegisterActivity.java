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
    public Button resgister_button;
    public EditText resgister_password1;
    public EditText resgister_password2;
    public EditText resgister_username;
    public EditText resgister_phone;
    public RadioButton resgister_radiobutton;
    public DBUtil dbutil = new DBUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        resgister_button = findViewById(R.id.resgister_button);
        resgister_password1 = findViewById(R.id.resgister_password1);
        resgister_password2 = findViewById(R.id.resgister_password2);
        resgister_username = findViewById(R.id.resgister_username);
        resgister_phone = findViewById(R.id.resgister_phone);
        resgister_radiobutton=findViewById(R.id.resgister_radiobutton);

        resgister_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonusername = resgister_username.getText().toString();
                String buttonpassword1 = resgister_password1.getText().toString();
                String buttonpassword2 = resgister_password2.getText().toString();
                String buttonphone = resgister_phone.getText().toString();
                if (buttonusername.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "用户名不可为空", Toast.LENGTH_SHORT).show();
                } else if (buttonphone.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                } else if (buttonpassword1.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "密码不可为空", Toast.LENGTH_SHORT).show();
                } else if (buttonpassword2.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                } else if(!resgister_radiobutton.isChecked()){
                    Toast.makeText(RegisterActivity.this, "请阅读并同意用户服务协议", Toast.LENGTH_SHORT).show();
                }else if (buttonpassword1.equals(buttonpassword2)) {
                    if (dbutil.register(buttonusername, buttonphone, buttonpassword1)) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
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
