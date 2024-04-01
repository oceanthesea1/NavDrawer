package com.example.navdrawer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navdrawer.Item;
import com.example.navdrawer.MyAdapter;
import com.example.navdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class Makanan_Fav_Fragment extends Fragment {

    RecyclerView recyclerView;
    List<Item> listData;
    MyAdapter adapter;

    public Makanan_Fav_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_makananfav, container, false);
        recyclerView = rootView.findViewById(R.id.rvMakananFav);
        listData = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("Tempura");
        item1.setDesc("Makanan Fav Enak 1");
        item1.setImage("https://asset.kompas.com/crops/CRWi0TgDppa_BnUiw0v92uJq1EY=/0x0:1000x667/750x500/data/photo/2021/10/29/617b96037f35d.jpg");
        listData.add(item1);

        Item item2 = new Item();
        item2.setName("Gudeg");
        item2.setDesc("Makanan Enak 1");
        item2.setImage("https://cdn-1.timesmedia.co.id/images/2022/12/21/gudeg-2.jpg");
        listData.add(item2);

        Item item3 = new Item();
        item3.setName("Gudeg");
        item3.setDesc("Makanan Enak 1");
        item3.setImage("https://cdn-1.timesmedia.co.id/images/2022/12/21/gudeg-2.jpg");
        listData.add(item3);

        Item item4 = new Item();
        item4.setName("Gudeg");
        item4.setDesc("Makanan Enak 1");
        item4.setImage("https://cdn-1.timesmedia.co.id/images/2022/12/21/gudeg-2.jpg");
        listData.add(item4);

        adapter = new MyAdapter(getContext(), listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
