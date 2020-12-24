package com.example.Listviewproject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Listview> listview=new ArrayList<>();
    private Listviewadapter listviewAdapter;
    private RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.listview_recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getRepoList();
    }

    private void getRepoList() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Listviewinterface repoInteface=retrofit.create(Listviewinterface.class);
        Call<List<Listview>> call=repoInteface.getRepoList();



        call.enqueue(new Callback<List<Listview>>() {
            @Override
            public void onResponse(Call<List<Listview>> call, Response<List<Listview>> response) {
                listview=new ArrayList<>(response.body());
                listviewAdapter=new Listviewadapter(MainActivity.this,listview);
                recyclerview.setAdapter(listviewAdapter);
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Listview>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}