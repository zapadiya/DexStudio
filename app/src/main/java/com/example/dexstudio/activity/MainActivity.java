package com.example.dexstudio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import com.example.dexstudio.R;
import com.example.dexstudio.adapter.UserDataAdapter;
import com.example.dexstudio.model.UserDataResponse;
import com.example.dexstudio.model.UserData;
import com.example.dexstudio.rest.ApiClient;
import com.example.dexstudio.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private  ImageView imgRefresh;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imgRefresh=findViewById(R.id.imgRefresh);
        //Method for get data
        setUserData();
        //refresh and get the data
        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserData();
            }
        });

    }

    private void setUserData() {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<UserDataResponse> call = apiService.getTopRatedMovies();
        call.enqueue(new Callback<UserDataResponse>() {
            @Override
            public void onResponse(Call<UserDataResponse> call, Response<UserDataResponse> response) {
                int statusCode = response.code();
                System.out.println("statusCode:"+statusCode+", Title:"+response.body().gettitle());
                getSupportActionBar().setTitle(response.body().gettitle()); // or getActionBar();
                List<UserData> movies = response.body().getResults();
                recyclerView.setAdapter(new UserDataAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<UserDataResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
