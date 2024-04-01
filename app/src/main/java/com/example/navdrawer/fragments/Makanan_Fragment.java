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

public class Makanan_Fragment extends Fragment implements MyAdapter.OnItemClickListener{

    RecyclerView recyclerView;
    List<Item> listData;
    MyAdapter adapter;

    public Makanan_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_makanan, container, false);
        recyclerView = rootView.findViewById(R.id.rvMakanan);
        listData = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("Gudeg");
        item1.setDesc("this is Desc Gudeg");
        item1.setImage("https://img-global.cpcdn.com/recipes/a8d0ffc50429e676/400x400cq70/photo.jpg");
        listData.add(item1);

        Item item2 = new Item();
        item2.setName("Bakpia Pathok");
        item2.setDesc("this is Desc Bakpia");
        item2.setImage("https://harianejogja.com/file/2023/01/4-11.webp");
        listData.add(item2);

        Item item3 = new Item();
        item3.setName("Sate Klathak");
        item3.setDesc("this is Desc Sate");
        item3.setImage("https://www.warisankuliner.com/gfx/recipes/1362118604.jpg");
        listData.add(item3);

        Item item4 = new Item();
        item4.setName("Mie Lethek");
        item4.setDesc("this is Desc Mie");
        item4.setImage("https://img.kurio.network/BxQdyJ2Ry5KcSeyeLstleIlAkt4=/320x320/filters:quality(80)/https://kurio-img.kurioapps.com/21/12/02/36af7dfc-7448-4f88-ae9b-a795b6a341a1.jpe");
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
        intent.putExtra("fragmentBack", "makananFragment");
        startActivity(intent);
    }
}
