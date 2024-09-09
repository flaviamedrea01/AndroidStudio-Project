package com.example.move;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button logOutBtn;
    SearchView searchView;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        List<SetData> setData;
        setData = new ArrayList<>();
        setData.add(new SetData(getString(R.string.title1),getString(R.string.description1), "https://www.sensiblu.com/_i/-2112815620.jpg?path=https%3A%2F%2Fbackend.drmax.ro%2Fmedia%2Fwysiwyg%2Fkike-vega-F2qh3yjz6Jk-unsplash.jpg"));
        setData.add(new SetData(getString(R.string.title2),getString(R.string.description2), "https://pilates4life.ro/wp-content/uploads/2020/10/Pilates_Timisoara_Pilates4Life1.jpg"));
        setData.add(new SetData(getString(R.string.title3),getString(R.string.description3), "https://www.outsideonline.com/wp-content/uploads/2022/01/iStock_89170989_SMALL.jpg"));
        setData.add(new SetData(getString(R.string.title4),getString(R.string.description4), "https://lifestyleandhealth.com.au/wp-content/uploads/2020/06/skipping-4.jpg"));
        MyAdapter customAdapter = new MyAdapter(this,R.layout.list_items, setData);
        listView.setAdapter(customAdapter);


        logOutBtn = findViewById(R.id.logoutBtn);

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
                finish();
            }
        });


        searchView =findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                uri = Uri.parse("https://www.google.com/search?q="+query);
                Intent newIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(newIntent);
                finish();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });







}


}