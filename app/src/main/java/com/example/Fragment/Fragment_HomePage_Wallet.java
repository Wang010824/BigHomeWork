package com.example.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Fragment_HomePage_Wallet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_wallet);
        Button myrecharge = (Button)findViewById(R.id.myrecharge);
        Button mywithdraw = (Button)findViewById(R.id.mywithdraw);
        TextView myback = (TextView)findViewById(R.id.myback);
        //返回上一级
        myback.setOnClickListener(view -> finish());

        //充值
        myrecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //提现
        mywithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
