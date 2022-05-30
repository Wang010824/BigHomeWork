package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.Fragment.Fragment_FirstPage;
import com.example.Fragment.Fragment_HomePage_Wallet;
import com.example.Fragment.PayDetailFragment;
import com.example.myapplication.R;

public class PayActivity extends AppCompatActivity {

    private Button mButton;
    private ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pay);
        initView();
    }

    private void initView() {
        mButton= (Button) this.findViewById(R.id.btn_pay);
        mImageButton= (ImageButton) this.findViewById(R.id.ib_return);
        mButton.setOnClickListener(view -> {
            PayDetailFragment payDetailFragment=new PayDetailFragment();
            payDetailFragment.show(getSupportFragmentManager(),"payDetailFragment");
        });
        mImageButton.setOnClickListener(view -> finish());
    }
}
