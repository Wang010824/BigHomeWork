package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.DataBase.DBUtil;
import com.example.Fragment.Fragment_FirstPage;
import com.example.Fragment.Fragment_HomePage;
import com.example.Fragment.Fragment_MessagePage;
import com.example.Fragment.Fragment_PublishPage;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    public Button home_button_signin;
    public Button register_button;
    public Button findback_password_button;
    public EditText edittext_password;
    public EditText edittext_username;
    public DBUtil dbutil=new DBUtil();
    Fragment_FirstPage Fragment_FirstPage = new Fragment_FirstPage();
    Fragment_PublishPage Fragment_PublishPage = new Fragment_PublishPage();
    Fragment_MessagePage Fragment_MessagePage = new Fragment_MessagePage();
    Fragment_HomePage Fragment_HomePage = new Fragment_HomePage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_button_signin=findViewById(R.id.home_button_signin);
        register_button = findViewById(R.id.myregister);
        findback_password_button = findViewById(R.id.myfindbackpassword);
        edittext_password=findViewById(R.id.edittext_password);
        edittext_username =findViewById(R.id.edittext_username);


        home_button_signin.setOnClickListener(view -> {
            String username;
            String password;

            username=edittext_username.getText().toString();
            password=edittext_password.getText().toString();
            if(username.equals("")){
                Toast.makeText(MainActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
            }
            else if(password.isEmpty()){
                Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
            }
            else if(dbutil.SignIn(username,password)){
            Intent home_intent=new Intent(MainActivity.this,FunctionActivity.class);
            startActivity(home_intent);
            }else{
                Toast.makeText(MainActivity.this,"帐号密码错误！",Toast.LENGTH_SHORT).show();
            }

        });

        register_button.setOnClickListener(view -> {
            Intent register = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(register);
        });

        findback_password_button.setOnClickListener(view -> {
            Intent findbackPassword = new Intent(MainActivity.this, FindPasswordActivity.class);
            startActivity(findbackPassword);
        });
    }
}