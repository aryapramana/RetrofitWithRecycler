package com.software.tempe.retrofitwithrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView dataTitleTxtView;
    private TextView dataDescTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        dataTitleTxtView = findViewById(R.id.dataTitleTxtView);
        dataDescTxtView = findViewById(R.id.dataDescTxtView);

        getActivityIntent();
    }

    private void getActivityIntent() {
        if (getIntent().hasExtra("title_data") && getIntent().hasExtra("body_data"))    {
            String title_data = getIntent().getStringExtra("title_data");
            String body_data = getIntent().getStringExtra("body_data");

            getData(title_data, body_data);
        }
    }

    private void getData(String title_data, String body_data) {
        dataTitleTxtView.setText(title_data);
        dataDescTxtView.setText(body_data);
    }
}
