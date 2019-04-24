package com.example.javabridgemonitoring.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.javabridgemonitoring.R;
import com.example.javabridgemonitoring.adapter.SistemAdapter;
import com.example.javabridgemonitoring.model.Sistem;
import com.example.javabridgemonitoring.network.GetDataService;
import com.example.javabridgemonitoring.network.RetrofitClientInstansce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private SistemAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    public List<Sistem> sistemList;
    private final String TAG="Activity Log";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

//
//        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new SistemAdapter(this, sistemList);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        GetDataService sistemService = RetrofitClientInstansce.getRetrofitInstance().create(GetDataService.class);
        Call<List<Sistem>> call=sistemService.getAllSistem();
        call.enqueue(new Callback<List<Sistem>>() {
            @Override
            public void onResponse(Call<List<Sistem>> call, Response<List<Sistem>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
                Log.d(TAG,"Response "+response.body());

            }

            @Override
            public void onFailure(Call<List<Sistem>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void generateDataList(List<Sistem> sistemList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new SistemAdapter(this,sistemList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.dataList=sistemList;
        adapter.notifyDataSetChanged();
    }
}

//        recyclerView = findViewById(R.id.customRecyclerView);
//        recyclerView.setHasFixedSize(true);
//
//        adapter = new SistemAdapter();
//        adapter.notifyDataSetChanged();
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter=new SistemAdapter(,R.layout.row_item_sistem,getApplicationContext());
//
//        recyclerView.setAdapter(adapter);
