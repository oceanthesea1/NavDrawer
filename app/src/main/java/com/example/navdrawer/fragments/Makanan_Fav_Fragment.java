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
        item1.setName("Tempura");
        item1.setDescShort("Makanan dengan tekstur yang memikat dan kulit yang krispy");
        item1.setDescLong("Tempura adalah hidangan Jepang yang terkenal akan kelezatannya di seluruh dunia. Hidangan ini terdiri dari bahan-bahan seperti udang, sayuran, telur, atau ikan yang dicelupkan ke dalam adonan tepung yang ringan dan kemudian digoreng hingga menjadi renyah dan berwarna keemasan. Proses penggorengan ini menjadikan Tempura memiliki tekstur renyah di luar namun tetap lembut di dalam. ");
        item1.setImage("https://umamidays.com/wp-content/uploads/2022/08/ebi-tempura.jpg");
        listData.add(item1);

        Item item2 = new Item();
        item2.setName("Gyoza");
        item2.setDescShort("Hidangan dengan kulit tipis berisi daging cincang");
        item2.setDescLong("Gyoza adalah hidangan Jepang yang terdiri dari kulit tipis yang dibungkuskan mengelilingi isian daging cincang atau sayuran, kemudian digoreng atau direbus. Dengan rasa gurih dan tekstur renyah di luar serta juicy di dalamnya, Gyoza sering disajikan dengan saus spesial yang memberikan sentuhan khas. Isian Gyoza bisa beragam, mulai dari daging ayam, udang, hingga campuran sayuran, membuatnya cocok untuk berbagai selera. ");
        item2.setImage("https://assets.epicurious.com/photos/628ba0d3fa016bab2139efa2/1:1/w_4546,h_4546,c_limit/Gyoza_RECIPE_051922_34332.jpg");
        listData.add(item2);

        Item item3 = new Item();
        item3.setName("Ice Cream");
        item3.setDescShort("Hidangan menyegarkan dengan tekstur yang beragam");
        item3.setDescLong("Es Krim adalah makanan pencuci mulut yang populer yang terbuat dari campuran susu, gula, dan berbagai bahan lainnya yang kemudian dibekukan. Biasanya tersedia dalam berbagai rasa dan tekstur, mulai dari yang lembut dan krimi hingga yang keras dan mengandung potongan-potongan berbagai jenis tambahan seperti buah, kacang-kacangan, atau cokelat. Es Krim sering disajikan dalam cone atau cangkir dan seringkali dihiasi dengan berbagai topping seperti saus, kacang, atau krim. ");
        item3.setImage("https://static01.nyt.com/images/2017/06/12/dining/00Icecream12/00Icecream12-square640.jpg");
        listData.add(item3);

        Item item4 = new Item();
        item4.setName("Pineapple Pizza");
        item4.setDescShort("The Greatest Pizza");
        item4.setDescLong("Pineapple Pizza adalah varian pizza yang terkenal dengan tambahan potongan nanas sebagai salah satu toppingnya. Ini merupakan kombinasi dari rasa manis nanas yang segar dan gurihnya keju dan saus tomat pada pizza. Meskipun ada perdebatan tentang apakah kombinasi ini enak atau tidak, banyak orang menikmati rasa unik dan kontras yang ditawarkan oleh pineapple pizza. ");
        item4.setImage("https://thecozycook.com/wp-content/uploads/2023/10/Hawaiian-Pizza-f.jpg");
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
        String descLong = listData.get(position).getDescLong();
        Intent intent = new Intent(requireContext(), Info.class);
        intent.putExtra("nameInfo", name);
        intent.putExtra("descInfo", descLong);
        String imageLink = listData.get(position).getImage();
        intent.putExtra("imageInfo", imageLink);
        startActivity(intent);
    }
}
