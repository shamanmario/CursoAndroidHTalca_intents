package com.example.claseconintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistrarUsuario extends AppCompatActivity {

    private TextView entradaNombre, entradaApellido, entradaContraseña;
    private Contacto contactoNuevo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        entradaNombre = findViewById(R.id.entradaNombre);
        entradaApellido = findViewById(R.id.entradaApellido);
        entradaContraseña = findViewById(R.id.entradaContraseña);
    }

    public void CrearUsuario(View view){
        contactoNuevo = new Contacto(entradaNombre.getText().toString(), entradaApellido.getText().toString());

        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra("contacto", contactoNuevo);

        startActivity(intent);

    }

}