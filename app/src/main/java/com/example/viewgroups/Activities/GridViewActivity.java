package com.example.viewgroups.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.viewgroups.Adapters.CustomAdapter;
import com.example.viewgroups.R;

public class GridViewActivity extends AppCompatActivity {

    int logos[] = {R.drawable.ind, R.drawable.aus, R.drawable.nz, R.drawable.eng,
            R.drawable.ind, R.drawable.aus, R.drawable.nz, R.drawable.pak, R.drawable.eng,
            R.drawable.ind, R.drawable.aus, R.drawable.nz, R.drawable.eng,R.drawable.pak,
            R.drawable.ind, R.drawable.aus, R.drawable.nz, R.drawable.pak, R.drawable.eng};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = (GridView) findViewById(R.id.grid_list);
        CustomAdapter customAdapter = new CustomAdapter(this, logos);
        gridView.setAdapter(customAdapter);
    }
}
