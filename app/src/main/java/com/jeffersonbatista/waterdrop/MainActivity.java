package com.jeffersonbatista.waterdrop;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private EditText editMinutes;
    private TimePicker timePicker;

    private int hour;
    private int minute;
    private int interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        editMinutes = findViewById(R.id.edit_txt_number_interval);
        timePicker = findViewById(R.id.time_picker);
        //Muda o relógio para o formato 24h
        timePicker.setIs24HourView(true);

        btnStart.setOnClickListener(clickStart);

        /* 3 maneiras de capturar eventos de touch
        1° Eventos de click direto pelo XML na activity - Criar uma id de função no XML e chamar ela na activity
        2° setOnclickListener sobrepondo não sendo necessário alterar no XML:
        3° Evento de Click com Objeto Anônimo - Incluir o método criado na segunda maneira dentro do setOnClickListener(3° maneira):
            btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    String sInterval = editMinutes.getText().toString();

                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();

                    interval = Integer.parseInt(sInterval);

                    Log.d("Teste","Hora: " + hour + " Minuto: " + minute +" Intervalo: "+ interval);
        }
    };);
        2° e 3° Maneira não é necessário alterar o XML
         */
    }
    // 2° Maneira - Intermediária - Evento de Click com variável anônima
    public View.OnClickListener clickStart = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String sInterval = editMinutes.getText().toString();

            hour = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();

            interval = Integer.parseInt(sInterval);

            Log.d("Teste","Hora: " + hour + " Minuto: " + minute +" Intervalo: "+ interval);
        }
    };
    // 1° Maneira - Mais fácil - Evento de Click via XML
    public void clickStart(View view){
        String sInterval = editMinutes.getText().toString();

        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();

        interval = Integer.parseInt(sInterval);

        Log.d("Teste","Hora: " + hour + " Minuto: " + minute +" Intervalo: "+ interval);
    }
}