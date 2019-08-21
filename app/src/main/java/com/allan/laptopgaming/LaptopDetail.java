package com.allan.laptopgaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.allan.laptopgaming.Model.Laptop;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class LaptopDetail extends AppCompatActivity {
    private ImageView imageViewLaptop;
    private TextView tv_laptop_name, tv_laptop_price, tv_laptop_spec, tv_laptop_comment;
    private Button btn_beli;
    Laptop laptop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_detail);

        //Get Intent
        laptop = (Laptop) getIntent().getExtras().getSerializable("DATA");
        getSupportActionBar().setTitle("Laptop-Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_laptop_name = findViewById(R.id.tv_laptop_name);
        tv_laptop_name.setText(laptop.getLaptopName());
        imageViewLaptop = findViewById(R.id.laptop_image);
        Glide.with(this)//With: Memasukkan Context
                .load(laptop.getLaptopImage())  //Load: memasukkan Sumber Gambar
                .apply(new RequestOptions().override(1000, 1000))//Apply: Mengatur tinggi dan lebar gambar
                .into(imageViewLaptop); // Memasukan ImageView
        tv_laptop_price = findViewById(R.id.tv_laptop_price);
        tv_laptop_spec = findViewById(R.id.tv_spec);
        tv_laptop_comment = findViewById(R.id.tv_laptop_comment);
        tv_laptop_price.setText(laptop.getLaptopPrice());
        tv_laptop_spec.setText(laptop.getLaptopSpec());
        tv_laptop_comment.setText(laptop.getLaptopComment());
        btn_beli = findViewById(R.id.btn_beli);
        btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.tokopedia.com/search?st=product&q="+laptop.getLaptopName()));
                startActivity(intent);
            }
        });
    }
}
