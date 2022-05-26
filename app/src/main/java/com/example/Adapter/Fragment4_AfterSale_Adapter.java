package com.example.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.optimization.AfterSales;
import com.example.optimization.Tasks;

import org.w3c.dom.Text;

import java.util.List;

public class Fragment4_AfterSale_Adapter extends ArrayAdapter<AfterSales> {
    private int resourceId;

    public Fragment4_AfterSale_Adapter(Context context, int textViewResourceId, List<AfterSales> objects){
        super(context , textViewResourceId ,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AfterSales sales = getItem(position);
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        }else {
            view = convertView;
        }
        TextView name = (TextView) view.findViewById(R.id.afterSalesName);
        ImageView img = (ImageView) view.findViewById(R.id.afterSalesPhoto);
        TextView text = (TextView) view.findViewById(R.id.Aftersalemytextview);
        TextView text1 = (TextView) view.findViewById(R.id.Aftersalemytextview1);
        TextView text2 = (TextView) view.findViewById(R.id.Aftersalemytextview2);
        name.setText(sales.getName());
        text.setText(sales.getText());
        text1.setText(sales.getText1());
        text2.setText(sales.getText2());
        img.setImageResource(sales.getPhoto());
        return view;
    }
}