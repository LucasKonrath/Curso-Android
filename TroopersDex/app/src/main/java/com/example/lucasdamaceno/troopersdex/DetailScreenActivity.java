package com.example.lucasdamaceno.troopersdex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucasdamaceno.troopersdex.model.Trooper;
import com.example.lucasdamaceno.troopersdex.utils.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by lucas.damaceno on 18/11/2017.
 */

public class DetailScreenActivity extends AppCompatActivity{

    private TextView tvTrooperDescription;

    private ImageView imvTrooperImage, imvTrooperAffiliation;

    private Trooper trooper;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_detail_trooper);
        initializeComponents();
        bindTrooper();
    }

    private void initializeComponents(){
        tvTrooperDescription = findViewById(R.id.trooper_description_tv);
        imvTrooperImage = findViewById(R.id.trooper_image);
    }

    private void bindTrooper(){
        trooper = (Trooper) getIntent().getSerializableExtra(Constants.EXTRA_TROOPER);
        tvTrooperDescription.setText(trooper.getDescription());

        Picasso.with(this)
                .load(trooper.getImageUrl())
                .into(imvTrooperImage);
    }

}
