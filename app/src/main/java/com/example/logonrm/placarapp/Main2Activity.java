package com.example.logonrm.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText edtTime1;
    private EditText edtTime2;
    private Button btInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtTime1 = (EditText) findViewById(R.id.edtt1);
        edtTime2 = (EditText) findViewById(R.id.edtt2);
        btInicio = (Button) findViewById(R.id.btcomecar);

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTime1.getText().toString().trim().length() == 0) {
                    Toast.makeText(Main2Activity.this, R.string.time_da_casa, Toast.LENGTH_SHORT).show();
                    edtTime1.requestFocus();
                    return;
                }

                if (edtTime2.getText().toString().trim().length() == 0) {
                    Toast.makeText(Main2Activity.this, R.string.time_visitante, Toast.LENGTH_SHORT).show();
                    edtTime2.requestFocus();
                    return;
                }

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra(Constantes.TIME1, edtTime1.getText().toString());
                intent.putExtra(Constantes.TIME2, edtTime2.getText().toString());
                startActivity(intent);
                finish();

            }
        });


    }
}
