package com.joule.stepviewapp.coor;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.text.Spannable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.joule.stepviewapp.R;

import java.util.ArrayList;

public class CoordinatorActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    RecyclerView recyclerView;
    AdapterSlider adapterSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        appBarLayout = findViewById(R.id.app_bar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("");
        }
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0){
                    Log.d("yy", "onOffsetChanged:  collapsed");
                    toolBarLayout.setTitle("haha titel");
                }else{
                    Log.d("yy", "onOffsetChanged: ");
                    toolBarLayout.setTitle("");
                }
            }
        });



        ArrayList<DataClass> dataClasses = new ArrayList<>();
        for (int i =0; i < 5; i++){
            DataClass dataClass = new DataClass();
            dataClass.setUrl("https://www.gstatic.com/webp/gallery/1.jpg");
            dataClass.setName("name" +i);
            dataClasses.add(dataClass);
        }

        recyclerView = findViewById(R.id.rc_slider);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        adapterSlider = new AdapterSlider(dataClasses, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapterSlider);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}