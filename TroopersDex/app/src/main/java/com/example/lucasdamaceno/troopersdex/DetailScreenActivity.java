package com.example.lucasdamaceno.troopersdex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucasdamaceno.troopersdex.model.Trooper;
import com.example.lucasdamaceno.troopersdex.repository.TrooperRepository;
import com.example.lucasdamaceno.troopersdex.utils.Constants;
import com.example.lucasdamaceno.troopersdex.utils.ResourceUtils;
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
        imvTrooperAffiliation = findViewById(R.id.trooper_detail_affiliation_imv);
    }

    private void bindTrooper(){
        trooper = (Trooper) getIntent().getSerializableExtra(Constants.EXTRA_TROOPER);
        tvTrooperDescription.setText(trooper.getDescription());
        imvTrooperAffiliation.setImageResource(ResourceUtils.getResourceBasedOnAffiliation(trooper.getAffiliation()));

        Picasso.with(this)
                .load(trooper.getImageUrl())
                .into(imvTrooperImage);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (TrooperRepository.isTrooperFavorite(trooper.getId(), getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE))){
            getMenuInflater().inflate(R.menu.favorited_trooper_detail, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.unfavorited_trooper_detail, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.star_item:
                if(item.getIcon().getConstantState().equals(getResources().getDrawable(R.drawable.ic_white_star).getConstantState())){
                    Toast.makeText(this, "Favoritar Trooper", Toast.LENGTH_LONG).show();
                    item.setIcon(R.drawable.ic_star_full);
                    TrooperRepository.saveTrooperIdToFavorites(trooper.getId(), getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));
                }
                else {
                    Toast.makeText(this, "Trooper Desfavoritado", Toast.LENGTH_LONG).show();
                    item.setIcon(R.drawable.ic_white_star);
                    TrooperRepository.removeTrooperIdFromFavorites(trooper.getId(), getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
