package com.joule.stepviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.joule.stepviewapp.coor.CoordinatorActivity;
import com.joule.stepviewapp.modal.DetailModalFragment;
import com.joule.stepviewapp.modal.itemListDialogFragment;
import com.joule.stepviewapp.plan.PlanATripActivity;
import com.stepstone.stepper.StepperLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnGo);
        Button buttonCor = findViewById(R.id.btncordi);
        constraintLayout = findViewById(R.id.bs);

        button.setOnClickListener(this);
        buttonCor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        switch (v.getId()){
            case R.id.btnGo:
                i = new Intent(this, PlanATripActivity.class);
                startActivity(i);
                break;
            case R.id.btncordi:
                DetailModalFragment modalFragment = new DetailModalFragment();
                modalFragment.show(getSupportFragmentManager(), "sss");
                break;
        }
    }
}