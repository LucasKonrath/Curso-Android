package com.example.lucasdamaceno.primeiraaplicacao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView meuTextView;
    private EditText editTextUrl;
    private Button buttonSegundaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaComponentes();

        buttonSegundaActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String urlDestino = editTextUrl.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+ urlDestino));
        startActivity(intent);
    }

    private void inicializaComponentes(){
        this.meuTextView = findViewById(R.id.textView);
        buttonSegundaActivity = findViewById(R.id.button);
        editTextUrl = findViewById(R.id.editText2);
    }
}
