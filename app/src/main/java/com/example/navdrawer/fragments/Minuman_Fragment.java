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
        item1.setDescShort("Wedang dengan bahan yang berupa dedaunan mirip dengan rempah");
        item1.setDescLong("Wedang Uwuh adalah minuman dengan bahan-bahan yang berupa dedaunan mirip dengan rempah. Dalam bahasa Jawa, Wedang berarti minuman yang diseduh, sedangkan Uwuh berarti sampah. Wedang Uwuh disajikan panas atau hangat memiliki rasa manis dan pedas dengan warna merah cerah dan aroma harum. Rasa pedas karena bahan Jahe, sedangkan warna merah karena adanya Secang. ");
        item1.setImage("https://cdn.idntimes.com/content-images/post/20210706/wedang-uwuh-48fe8f7479a6ecc09f4b3425eb4add59.jpg");
        listData.add(item1);

        Item item2 = new Item();
        item2.setName("Es Semlo");
        item2.setDescShort("Minuman yang diolah dari bahan rempah dengan tambahan buah pisang");
        item2.setDescLong("Es Semlo terdiri dari campuran gula pasir, pisang, beragam rempah, dan sedikit perasan air jeruk nipis. Es ini juga diberi warna merah alami dari kayu secang. Es Semlo adalah perpaduan sederhana namun kaya cita rasa yang bersumber dari kearifan lokal. Es Semlo menawarkan pengalaman rasa yang autentik dan mencerminkan warisan kuliner yang masih terus hidup. ");
        item2.setImage("https://cdn.idntimes.com/content-images/community/2020/11/25016012-169005777187038-7152227309372571648-n-c81ddb9dc663a299485efc307f0b05d9.jpg");
        listData.add(item2);

        Item item3 = new Item();
        item3.setName("Kopi Joss");
        item3.setDescShort("Kopi yang disajikan bersama arang panas");
        item3.setDescLong("Kopi Joss adalah minuman kopi khas Yogyakarta yang disajikan bersama arang panas. Arang panas dimasukkan ke dalam seduhan kopi hitam dan gula untuk kemudian dihidangkan. Kopi Joss bermula di Angkringan Lek Man");
        item3.setImage("https://awsimages.detik.net.id/community/media/visual/2021/06/24/kopi-joss-populer-di-yogyakarta-1.jpeg?w=1080");
        listData.add(item3);

        Item item4 = new Item();
        item4.setName("Es Jaipong");
        item4.setDescShort("Es dengan bubur sumsum, santan, dan berbagai tambahan lainnya");
        item4.setDescLong("Es Jaipong adalah minuman segar khas Yogyakarta yang terkenal dengan cita rasa manis dan segarnya. Terdiri dari bubur sumsum hijau, cincau hitam, tape, mutiara merah kemudian kemudian diberi santan dan es batu ditaburi irisan nangka memberikan rasa lezat dan menyegarkan. Es Jaipong seringkali disajikan dalam mangkuk besar atau gelas besar dengan hiasan daun pisang di pinggirnya untuk memberikan sentuhan tradisional. Minuman ini menjadi pilihan favorit bagi banyak orang, terutama saat cuaca panas di Yogyakarta. ");
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
        String descLong = listData.get(position).getDescLong();
        Intent intent = new Intent(requireContext(), Info.class);
        intent.putExtra("nameInfo", name);
        intent.putExtra("descInfo", descLong);
        String imageLink = listData.get(position).getImage();
        intent.putExtra("imageInfo", imageLink);
        startActivity(intent);
    }
}
