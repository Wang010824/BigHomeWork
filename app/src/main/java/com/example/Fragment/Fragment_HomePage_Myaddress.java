package com.example.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Fragment_HomePage_Myaddress extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_set_address);
        TextView myback_address = (TextView)findViewById(R.id.myback_address);
        myback_address.setOnClickListener(view -> finish());
    }
}
