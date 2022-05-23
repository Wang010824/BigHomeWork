package com.example.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activity.EvaluationActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment_HomePage_Evaluation extends AppCompatActivity {
    private ListView eva_listView;
    private List<Map<String, Object>> eva_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment4_evaluation);
        eva_datas = new ArrayList<Map<String, Object>>();
        eva_listView = (ListView) findViewById(R.id.eva_listview);

        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        Map<String, Object> map4 = new HashMap<String, Object>();
        Map<String, Object> map5 = new HashMap<String, Object>();

        map1.put("con", "搬家");
        map1.put("picture", R.drawable.emp1);
        eva_datas.add(map1);
        map2.put("con", "送充电宝");
        map2.put("picture", R.drawable.emp2);
        eva_datas.add(map2);
        map3.put("con", "送电脑");
        map3.put("picture", R.drawable.emp3);
        eva_datas.add(map3);
        map4.put("con", "送奶茶");
        map4.put("picture", R.drawable.emp4);
        eva_datas.add(map4);
        map5.put("con", "送花");
        map5.put("picture", R.drawable.emp5);
        eva_datas.add(map5);
        MyAdapter adapter = new MyAdapter(this, eva_datas, R.layout.evaluation_adapter);
        eva_listView.setAdapter(adapter);

    }
    class MyAdapter extends BaseAdapter {
        private Context context;
        private int resource;
        private List<Map<String, Object>> eva_datas;
        public MyAdapter(Context context, List<Map<String, Object>> eva_datas, int resource) {
            this.context = context;
            this.eva_datas = eva_datas;
            this.resource = resource;
        }

        @Override
        public int getCount() {
            return eva_datas.size();
        }

        @Override
        public Object getItem(int i) {
            return eva_datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // 声明内部类
            Util util = null;

            final int flag = i;

            if (view == null) {
                util = new Util();
                // 给xml布局文件创建java对象
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(resource, null);
                util.picture = (ImageView) view.findViewById(R.id.picture);
                util.con = (TextView) view.findViewById(R.id.con);
                util.btnn = (Button) view.findViewById(R.id.btnn);
                // 增加额外变量
                view.setTag(util);
            } else {
                util = (Util) view.getTag();
            }
            // 获取数据显示在各组件
            Map<String, Object> map = eva_datas.get(i);
            util.con.setText((String) map.get("con"));
            util.picture.setImageResource((Integer) map.get("picture"));
            util.btnn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent eva_intent=new Intent();
                    eva_intent.setClass(context, EvaluationActivity.class);
                    startActivity(eva_intent);
                }
            });
            LinearLayout parent = (LinearLayout) view.findViewById(R.id.parent1);
            return view;
        }
        class Util {
            TextView con;
            ImageView picture;
            Button btnn;
        }
    }
}
