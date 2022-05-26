package com.example.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Adapter.Fragment4_AfterSale_Adapter;
import com.example.myapplication.R;
import com.example.optimization.AfterSales;

import java.util.ArrayList;
import java.util.List;

public class Fragment_HomePage_AfterSale extends AppCompatActivity {

    private ListView mylistviews;
    private List<AfterSales> datas= new ArrayList<>();
    private Fragment4_AfterSale_Adapter adapter4;

    private String[] message_name = {
            "彤雨晴",
            "萧南莲",
            "宋宝宝",
            "影伴人久",
            "弘香薇",
            "祁玲玲",
            "李念瑶",
            "席振华",
            "藏怀幕",
    };

    public String[] text = {
            "送快递",
            "送外卖",
            "送花",
            "送电脑",
            "送充电器",
            "送充电宝",
            "送蜜雪冰城",
            "送手机",
            "送校园卡"
    };
    public String[] text1 = {
            "将包裹送到河南大学东苑宿舍",
            "将外卖送到东苑宿舍20号楼",
            "将花送到东苑宿舍19号楼",
            "将电脑送到东苑宿舍18号楼",
            "将充电器送到今明综合楼1101",
            "将充电宝送到今明综合楼2104",
            "将蜜雪冰城送到计算机学院201",
            "将手机送到计算机学院512",
            "将校园卡送到计算机学院114"
    };
    public String[] text2 = {
            "费用：10元",
            "费用：2元",
            "费用：5元",
            "费用：10元",
            "费用：7元",
            "费用：14元",
            "费用：25元",
            "费用：31元",
            "费用：17元"
    };
    public int[] photo = {
            R.drawable.photo,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_aftersale);
        TextView myback = (TextView)findViewById(R.id.myback);
        myback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initDatas();//初始化数据
        Fragment4_AfterSale_Adapter adapter = new Fragment4_AfterSale_Adapter(Fragment_HomePage_AfterSale.this,
                R.layout.fragment4_aftersale_listview, datas);
        mylistviews = (ListView)findViewById(R.id.listview_aftersale);
        mylistviews.setAdapter(adapter);
    }

    private void initDatas() {
        for(int i=0;i<text.length;i++){
            AfterSales afterSales=new AfterSales(message_name[i],text[i],text1[i],text2[i],photo[i]);
            datas.add(afterSales);
        }
    }
}