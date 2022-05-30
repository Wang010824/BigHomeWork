package com.example.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Activity.FindPasswordActivity;
import com.example.DataBase.DBUtil;
import com.example.myapplication.R;
import com.example.optimization.CircleImage;

import java.io.ByteArrayOutputStream;

public class Fragment_HomePage extends Fragment {
    CircleImage circleimage;
    Uri uri;
    String imageString;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment4, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton myset = (ImageButton) getActivity().findViewById(R.id.myset);
        myset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragment_homepage_set=new Intent();
                fragment_homepage_set.setClass(getActivity(),Fragment_HomePage_Set.class);
                startActivity(fragment_homepage_set);
            }
        });

        TextView mywallet = (TextView)getActivity().findViewById(R.id.mywallet);
        mywallet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fragment_homepage_wallet=new Intent();
                fragment_homepage_wallet.setClass(getActivity(),Fragment_HomePage_Wallet.class);
                startActivity(fragment_homepage_wallet);
            }
        });

        TextView mytask = (TextView)getActivity().findViewById(R.id.mytask);
        mytask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fragment_homepage_task=new Intent();
                fragment_homepage_task.setClass(getActivity(),Fragment_HomePage_Task.class);
                startActivity(fragment_homepage_task);
            }
        });

        //评价
        TextView mycomment = (TextView)getActivity().findViewById(R.id.mycomment);
        mycomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragment_homepage_evaluation=new Intent();
                fragment_homepage_evaluation.setClass(getActivity(),Fragment_HomePage_Evaluation.class);
                startActivity(fragment_homepage_evaluation);
            }
        });

        //售后
        TextView myAfterSale = (TextView)getActivity().findViewById(R.id.myaftersale);
        myAfterSale.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fragment_homepage_aftersale=new Intent();
                fragment_homepage_aftersale.setClass(getActivity(), Fragment_HomePage_AfterSale.class);
                startActivity(fragment_homepage_aftersale);
            }
        });

        DBUtil dbUtil=new DBUtil();
        circleimage=(CircleImage)getActivity().findViewById(R.id.wode_touxiang);
        getimage(dbUtil.id,R.id.wode_touxiang);
        circleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.addCategory(Intent.CATEGORY_OPENABLE);
                galleryIntent.setType("image/*");//图片
                startActivityForResult(galleryIntent, 0);
            }
        });


    }

    public void getimage(int id_image,int imageview_id){
        CircleImage a =(CircleImage)getActivity().findViewById(imageview_id);;
        String imageString;
        DBUtil dbutil=new DBUtil();

        imageString=dbutil.getImage(id_image);
        if(imageString!=null) {
            byte[] imageBytes = Base64.decode(imageString, Base64.DEFAULT);
            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            a.setImageBitmap(decodedImage);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // TODO Auto-generated method stub
        if (requestCode == 0 && resultCode == -1) {
            uri = data.getData();
            circleimage.setImageURI(uri);


            //将图片转换成Base64编码
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] imageBytes = baos.toByteArray();
                imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

            } catch (Exception e) {
            }
            DBUtil dbutil=new DBUtil();
            dbutil.setImage(imageString);
        }
    }
}
