package com.example.assignment_3;

import static com.example.assignment_3.R.id.list_covid_rv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView covidListRV;

    private List<Covid> covidList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        covidListRV = findViewById(R.id.list_covid_rv);
        getAllcovidinfo();
    }

    private void getAllcovidinfo() {
        Call<List<Covid>> call = RetrofitClient.getInstance().getMyApi().getAllcovidinfo();
        call.enqueue(new Callback<List<Covid>>() {
            @Override
            public void onResponse(Call<List<Covid>> call, Response<List<Covid>> response) {
                covidList = response.body();
                buildAdapter();

            }

            @Override
            public void onFailure(Call<List<Covid>> call, Throwable t) {

            }
        });
    }
    private void buildAdapter() {
        CovidAdapter covidAdapter = new CovidAdapter(MainActivity.this, covidList);
        covidListRV.setAdapter(covidAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        covidListRV.setLayoutManager(layoutManager);
    }

}