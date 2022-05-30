package com.example.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activity.PayActivity;
import com.example.myapplication.R;

public class Fragment_HomePage_Wallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_wallet);
        initView();
    }
    private void initView() {
        Button myrecharge = (Button) this.findViewById(R.id.myrecharge);
        myrecharge.setOnClickListener(view -> {
            startActivity(new Intent(Fragment_HomePage_Wallet.this, PayActivity.class));
            Fragment_HomePage_Wallet.this.finish();
        });
    }

}
