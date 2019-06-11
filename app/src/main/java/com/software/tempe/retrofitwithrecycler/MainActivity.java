package com.software.tempe.retrofitwithrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.software.tempe.retrofitwithrecycler.adapter.RecyclerViewAdapter;
import com.software.tempe.retrofitwithrecycler.model.Post;
import com.software.tempe.retrofitwithrecycler.service.ServiceAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private RecyclerViewAdapter adapter;



    private ServiceAPI serviceAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createApi();

        populateData();

    }

    private void createApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceAPI = retrofit.create(ServiceAPI.class);
    }

    private void populateData() {
        Call<List<Post>> call = serviceAPI.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful())   {
                    Toast.makeText(MainActivity.this, "Message: " + response.code(), Toast.LENGTH_SHORT).show();
                }


                List<Post> postList = response.body();

                // Log.e("Error saya: ", response.body().toString());

                recycler_view = findViewById(R.id.recycler_view);

                adapter = new RecyclerViewAdapter(postList, MainActivity.this);

                recycler_view.setAdapter(adapter);
                recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
