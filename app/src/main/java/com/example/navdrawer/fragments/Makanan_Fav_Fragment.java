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

public class Makanan_Fav_Fragment extends Fragment implements MyAdapter.OnItemClickListener{

    RecyclerView recyclerView;
    List<Item> listData;
    MyAdapter adapter;

    public Makanan_Fav_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_makananfav, container, false);
        recyclerView = rootView.findViewById(R.id.rvMakananFav);
        listData = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("French Fries");
        item1.setDesc("this is Desc Fries");
        item1.setImage("https://cdn.icon-icons.com/icons2/562/PNG/512/rounded-corners-square_icon-icons.com_53894.png");
        listData.add(item1);

        Item item2 = new Item();
        item2.setName("Gudeg");
        item2.setDesc("this is Desc Gudeg");
        item2.setImage("https://cdn.icon-icons.com/icons2/562/PNG/512/rounded-corners-square_icon-icons.com_53894.png");
        listData.add(item2);

        Item item3 = new Item();
        item3.setName("Gudeg");
        item3.setDesc("this is Desc Gudeg");
        item3.setImage("https://cdn.icon-icons.com/icons2/562/PNG/512/rounded-corners-square_icon-icons.com_53894.png");
        listData.add(item3);

        Item item4 = new Item();
        item4.setName("Gudeg");
        item4.setDesc("this is Desc Gudeg");
        item4.setImage("https://cdn.icon-icons.com/icons2/562/PNG/512/rounded-corners-square_icon-icons.com_53894.png");
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
