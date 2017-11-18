package com.example.lucasdamaceno.troopersdex;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lucasdamaceno.troopersdex.adapter.TrooperAdapter;
import com.example.lucasdamaceno.troopersdex.model.Trooper;
import com.example.lucasdamaceno.troopersdex.repository.TrooperRepository;
import com.example.lucasdamaceno.troopersdex.utils.Constants;
import com.example.lucasdamaceno.troopersdex.utils.SharedPreferencesUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TrooperAdapter.OnItemClickListener, View.OnLongClickListener {

    private RecyclerView rvTroopers;
    private ArrayList<Trooper> troopers;
    private TrooperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTroopers = findViewById(R.id.troopers_rv);
        populateRecyclerView();
    }

    private void populateRecyclerView() {

        troopers = TrooperRepository.tryGettingFromSharedPreferences(getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));

        rvTroopers.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TrooperAdapter(troopers, this, this);

        rvTroopers.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Trooper trooper) {
        Intent intent = new Intent(MainActivity.this, DetailScreenActivity.class);
        intent.putExtra(Constants.EXTRA_TROOPER, trooper);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(final View v) {
        new AlertDialog.Builder(this)
                .setMessage("Tem certeza de que deseja excluir esse trooper?")
                .setCancelable(true)
                .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = rvTroopers.getChildLayoutPosition(v);
                        troopers.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Trooper Excluído", Toast.LENGTH_SHORT).show();
                    }
                })
                .setTitle("Excluir Trooper")
                .show();

        return true;
    }
}
