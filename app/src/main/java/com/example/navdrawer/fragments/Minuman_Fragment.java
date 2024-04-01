package com.example.navdrawer.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navdrawer.Info;
import com.example.navdrawer.Item;
import com.example.navdrawer.MyAdapter;
import com.example.navdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class Minuman_Fragment extends Fragment implements MyAdapter.OnItemClickListener{

    RecyclerView recyclerView;
    List<Item> listData;
    MyAdapter adapter;

    public Minuman_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_minuman, container, false);
        recyclerView = rootView.findViewById(R.id.rvMinuman);
        listData = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("Wedang Uwuh");
        item1.setDesc("this is Desc wedang");
        item1.setImage("https://cdn.idntimes.com/content-images/post/20210706/wedang-uwuh-48fe8f7479a6ecc09f4b3425eb4add59.jpg");
        listData.add(item1);

        Item item2 = new Item();
        item2.setName("Es Semlo");
        item2.setDesc("this is Desc Es");
        item2.setImage("https://cdn.idntimes.com/content-images/community/2020/11/25016012-169005777187038-7152227309372571648-n-c81ddb9dc663a299485efc307f0b05d9.jpg");
        listData.add(item2);

        Item item3 = new Item();
        item3.setName("Kopi Joss");
        item3.setDesc("this is Desc Kopi");
        item3.setImage("https://awsimages.detik.net.id/community/media/visual/2021/06/24/kopi-joss-populer-di-yogyakarta-1.jpeg?w=1080");
        listData.add(item3);

        Item item4 = new Item();
        item4.setName("Es Jaipong");
        item4.setDesc("this is Desc Es 2");
        item4.setImage("https://cdn.idntimes.com/content-images/community/2022/08/fromandroid-ca2275a7fee3963c0210a0f915c3554c.jpg");
        listData.add(item4);

        adapter = new MyAdapter(getContext(), listData);
        adapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onItemClick(int position) {
        String name = listData.get(position).getName();
        String desc = listData.get(position).getDesc();
        Intent intent = new Intent(requireContext(), Info.class);
        intent.putExtra("nameInfo", name);
        intent.putExtra("descInfo", desc);
        String imageLink = listData.get(position).getImage();
        intent.putExtra("imageInfo", imageLink);
        startActivity(intent);
    }
}
