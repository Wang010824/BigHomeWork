package com.example.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Fragment_HomePage_Set_Safe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_set_safe);
        TextView myback_safe = (TextView)findViewById(R.id.myback_safe);
        myback_safe.setOnClickListener(view -> finish());
    }
}
