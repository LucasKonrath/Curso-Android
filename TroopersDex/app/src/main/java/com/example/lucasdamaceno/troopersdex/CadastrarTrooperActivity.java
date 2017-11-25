package com.example.lucasdamaceno.troopersdex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lucasdamaceno.troopersdex.R;
import com.example.lucasdamaceno.troopersdex.model.Affiliation;
import com.example.lucasdamaceno.troopersdex.model.Trooper;
import com.example.lucasdamaceno.troopersdex.repository.TrooperRepository;
import com.example.lucasdamaceno.troopersdex.utils.Constants;
import com.example.lucasdamaceno.troopersdex.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class CadastrarTrooperActivity extends AppCompatActivity {

    private EditText trooperNameTextView, trooperDescriptionTextView, trooperImageUrlTextView;

    private Spinner trooperAffiliationSpinnerType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_trooper);
        initializeComponents();
    }

    public void initializeComponents(){

        trooperNameTextView = (EditText) findViewById(R.id.nomeTrooperCadastrar);

        trooperDescriptionTextView = (EditText) findViewById(R.id.descricaoTrooperNovo);

        trooperImageUrlTextView = (EditText) findViewById(R.id.urlImagemTrooperNovo);

        trooperAffiliationSpinnerType = (Spinner) findViewById(R.id.spinnerAffiliationType);

    }

    public void saveTrooper(View view) {

        String trooperName = trooperNameTextView.getText().toString();

        String trooperDescription = trooperDescriptionTextView.getText().toString();

        String trooperImageUrl = trooperImageUrlTextView.getText().toString();

        String trooperAffiliationString = trooperAffiliationSpinnerType.getSelectedItem().toString();
        Affiliation affiliation;
        final String firstOrder = getResources().getString(R.string.first_order);
        final String galacticEmpire = getResources().getString(R.string.galactic_empire);
        final String galacticRepublic = getResources().getString(R.string.galactic_republic);

        if(firstOrder.equals(trooperAffiliationString)){
            affiliation = Affiliation.FIRST_ORDER;
        }
        else if(galacticEmpire.equals(trooperAffiliationString)){
            affiliation = Affiliation.GALACTIC_EMPIRE;
        }
        else{
            affiliation = Affiliation.GALACTIC_REPUBLIC;
        }

        ArrayList<Trooper> troopers = TrooperRepository.tryGettingFromSharedPreferences(getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));

        Trooper trooper = new Trooper(troopers.size()+1,trooperName,trooperImageUrl,trooperDescription
                ,affiliation);

        troopers.add(trooper);

        TrooperRepository.saveToSharedPreferences(troopers, getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
