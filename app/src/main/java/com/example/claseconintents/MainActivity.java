package com.example.claseconintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button botonReloj;
    private TextView textoHora;
    private int hora, minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonReloj = findViewById(R.id.botonReloj);
        textoHora = findViewById(R.id.etiquetaHora);
    }

    public void seleccionarHora(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSeleccionada, int minutoSeleccinado) {
                hora = horaSeleccionada;
                minuto = minutoSeleccinado;

                //botonReloj.setText(hora+":"+minuto);
                botonReloj.setText(String.format(Locale.getDefault(), "%02d:%02d", hora, minuto));

                if(hora > 12){
                    textoHora.setText((hora-12)+":"+minuto+" PM");
                } else {
                    textoHora.setText(hora+":"+minuto+" AM");
                }

                Toast.makeText(MainActivity.this, "La hora es: "+hora+":"+minuto, Toast.LENGTH_LONG).show();
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hora, minuto,false);
        timePickerDialog.show();
    }

    public void LanzarActivity(View view){
        Intent intent = new Intent(this, MainActivity2.class);

        Contacto c = new Contacto("Pepe","Pato");

        intent.putExtra("claveNueva", "Hola mundo mundial");
        intent.putExtra("extra2", 200);
        intent.putExtra("contactoNuevo", c);

        startActivity(intent);
    }
}