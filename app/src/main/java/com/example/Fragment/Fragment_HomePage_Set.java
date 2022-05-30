package com.example.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Fragment_HomePage_Set extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_set);

        TextView myback = (TextView)findViewById(R.id.myback);
        myback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView myaddress = (TextView)findViewById(R.id.myaddress);
        myaddress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent();
                intent.setClass(view.getContext(),Fragment_HomePage_Myaddress.class);
                startActivity(intent);
            }



        });
        TextView mysafe = (TextView)findViewById(R.id.mysafe);
        mysafe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent();
                intent.setClass(view.getContext(),Fragment_HomePage_Set_Safe.class);
                startActivity(intent);
            }


        });
        TextView myset_hide = (TextView)findViewById(R.id.myset_hide);
        myset_hide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent();
                intent.setClass(view.getContext(),Fragment_HomePage_Set_hide.class);
                startActivity(intent);
            }


        });
        TextView myset_mes = (TextView)findViewById(R.id.myset_mes);
        myset_mes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent();
                intent.setClass(view.getContext(),Fragment_HomePage_Set_mes.class);
                startActivity(intent);
            }


        });
    }
}
