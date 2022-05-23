package com.example.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.Fragment.Fragment_HomePage_Evaluation;
import com.example.myapplication.R;

public class EvaluationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        RatingBar ratingBar=findViewById(R.id.ratingbar);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating=ratingBar.getRating();//获取当前的星数
                Toast.makeText(EvaluationActivity.this,
                        "你评价了"+rating+"颗星,感谢您的支持！",Toast.LENGTH_LONG).show();
            }
        });
    }
}