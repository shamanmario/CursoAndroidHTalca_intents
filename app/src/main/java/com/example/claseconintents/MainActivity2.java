package com.example.claseconintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etiqueta = findViewById(R.id.etiquetaIntent);

        Contacto nuevo = (Contacto) getIntent().getSerializableExtra("contacto");

        //String texto = getIntent().getStringExtra("claveNueva");
        //int numero = getIntent().getIntExtra("contacto", 0);

        etiqueta.setText(nuevo.getNombre()+" "+nuevo.getApellido());

    }
}