package com.example.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class Fragment_PublishPage extends Fragment  {
    private Button btn;
    private String mDatas;
    private EditText et01,et02,et03,et04,et05,et06,et07;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView=inflater.inflate(R.layout.fragment2,container,false);
        btn = fragmentView.findViewById(R.id.fragment2_btn_pull);

        et01 = fragmentView.findViewById(R.id.fragment2_et_01);
        et02 = fragmentView.findViewById(R.id.fragment2_et_02);
        et03 = fragmentView.findViewById(R.id.fragment2_et_03);
        et04 = fragmentView.findViewById(R.id.fragment2_et_04);
        et05 = fragmentView.findViewById(R.id.fragment2_et_05);
        et06 = fragmentView.findViewById(R.id.fragment2_et_06);
        et07 = fragmentView.findViewById(R.id.fragment2_et_07);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1=et01.getText().toString().trim();
                String text2=et02.getText().toString().trim();
                String text3=et03.getText().toString().trim();
                String text4=et04.getText().toString().trim();
                String text5=et05.getText().toString().trim();
                String text6=et06.getText().toString().trim();
                String text7=et07.getText().toString().trim();

                if(        text1.length() == 0
                        || text2.length() == 0
                        || text3.length() == 0
                        || text4.length() == 0
                        || text5.length() == 0
                        || text6.length() == 0
                        || text7.length() == 0
                ){
                    Toast.makeText(getActivity(),"请检查输入",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"发布成功",Toast.LENGTH_SHORT).show();
                    Bundle bundle_name = new Bundle();
                    Bundle bundle_info = new Bundle();
                    Bundle bundle_money = new Bundle();
                    bundle_name.putString("vname", text1);
                    bundle_info.putString("vinfo", text2);
                    bundle_money.putString("vmoney", text7);
                    getParentFragmentManager().setFragmentResult("rname", bundle_name);
                    getParentFragmentManager().setFragmentResult("rinfo", bundle_info);
                    getParentFragmentManager().setFragmentResult("rmoney", bundle_money);
                }
            }
        });
        return fragmentView;
    }
}
