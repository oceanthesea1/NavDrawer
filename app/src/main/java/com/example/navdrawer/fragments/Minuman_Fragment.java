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

public class Minuman_Fragment extends Fragment {

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
        item1.setDesc("Minuman Enak 1");
        item1.setImage("https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/10/03032633/7-Manfaat-Minuman-Wedang-Uwuh-untuk-Kesehatan-Tubuh.jpg");
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
