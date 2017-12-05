package com.example.logonrm.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTime1;
    private TextView tvTime2;
    private TextView tvNomeTime1;
    private TextView tvNomeTime2;
    private Spinner sp1;
    private Button btMais;
    private Button btMenos;

    private String[] times = {"Time 1", "Time 2"};


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime1 = (TextView) findViewById(R.id.tv1);
        tvTime2 = (TextView) findViewById(R.id.tv2);

        tvNomeTime1 = (TextView) findViewById(R.id.time1);
        tvNomeTime2 = (TextView) findViewById(R.id.time2);


        sp1 = (Spinner) findViewById(R.id.sp1);
        btMais = (Button) findViewById(R.id.btmais);
        btMenos = (Button) findViewById(R.id.btmenos);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                times);
        sp1.setAdapter(spinnerArrayAdapter);

        tvNomeTime1.setText(getIntent().getStringExtra("time1"));
        tvNomeTime2.setText(getIntent().getStringExtra("time2"));

        btMais.setOnClickListener(this);
        btMenos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int ponto = 0;
        switch (v.getId()) {
            case R.id.btmais:
                if (sp1.getSelectedItem().toString().contentEquals("Time 1")) {
                    ponto = Integer.parseInt(tvTime1.getText().toString());
                    ponto++;
                    tvTime1.setText(String.valueOf(ponto));
                } else {
                    ponto = Integer.parseInt(tvTime2.getText().toString());
                    ponto++;
                    tvTime2.setText(String.valueOf(ponto));
                }
                break;


            case R.id.btmenos:
                if (sp1.getSelectedItem().toString().contentEquals("Time 1")) {
                    ponto = Integer.parseInt(tvTime1.getText().toString());
                    ponto--;
                    tvTime1.setText(String.valueOf(ponto));
                } else {
                    ponto = Integer.parseInt(tvTime2.getText().toString());
                    ponto--;
                    tvTime2.setText(String.valueOf(ponto));
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Main2Activity.class));
    }
}
