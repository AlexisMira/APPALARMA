package com.clasemoviles.appalarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textoHora, textoFecha;
    String TAC = "DatosAlarma";
    int EXTRA_HOUR, EXTRA_MINUTES;
    int horaAlarma = 5;
    Button btnDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAC, "--- onCreate ---");
        btnDatos = findViewById(R.id.envioDatos);

        textoFecha = findViewById(R.id.DiaAlarma);
        textoHora = findViewById(R.id.Hora);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAC, "--- onStart ---");
        btnDatos.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                textoFecha.setText("20/03/2022");
                textoHora.setText("9:30 PM");

            }
        });
    }

    public void activarAlarma(View view)
    {
        Intent activar = new Intent(AlarmClock.ACTION_SET_ALARM);
        activar.putExtra(AlarmClock.EXTRA_MESSAGE, "ALARMA APP1");
        activar.putExtra(AlarmClock.EXTRA_HOUR, 23);
        activar.putExtra(AlarmClock.EXTRA_MINUTES, 5);

        startActivity(activar);
    }
}