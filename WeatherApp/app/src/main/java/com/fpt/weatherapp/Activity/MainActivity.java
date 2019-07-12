package com.fpt.weatherapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.fpt.weatherapp.Adapter.HourAdapter;
import com.fpt.weatherapp.Model.Wheather;
import com.fpt.weatherapp.Network.ApiManager;
import com.fpt.weatherapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem =  findViewById(R.id.tvTem);
        tvStatus =  findViewById(R.id.tvStatus);


        getHours();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);




        rvHour = findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);


    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager service = retrofit.create(ApiManager.class);

        service.gethour().enqueue(new Callback<List<Wheather>>() {
            @Override
            public void onResponse(Call<List<Wheather>> call, Response<List<Wheather>> response) {

                if (response.body() == null) return;

                List<Wheather> listWheather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this,listWheather);
                rvHour.setAdapter(adapter);

                Wheather wheather = listWheather.get(0);
                tvTem.setText(wheather.getTemperature().getValue().intValue()+"°");
                tvStatus.setText(wheather.getIconPhrase());

            }

            @Override
            public void onFailure(Call<List<Wheather>> call, Throwable t) {

            }
        });
    }
}

