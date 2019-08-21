package com.allan.laptopgaming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.allan.laptopgaming.Adapter.ListLaptopAdapter;
import com.allan.laptopgaming.Model.Laptop;
import com.allan.laptopgaming.Model.LaptopData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_laptop;
    private ArrayList<Laptop> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_laptop = findViewById(R.id.rv_laptop);
        rv_laptop.setHasFixedSize(true);

        list.addAll(LaptopData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rv_laptop.setLayoutManager(new LinearLayoutManager(this));
        ListLaptopAdapter listLaptopAdapter = new ListLaptopAdapter(this, list);
        rv_laptop.setAdapter(listLaptopAdapter);

        listLaptopAdapter.setOnItemClickListener(new ListLaptopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Laptop obj, int position) {
                Intent intent = new Intent(MainActivity.this, LaptopDetail.class);
                intent.putExtra("DATA",obj);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my_profile:
                Intent intent = new Intent(MainActivity.this, MyProfile.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
