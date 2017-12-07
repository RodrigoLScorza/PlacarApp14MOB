package com.example.logonrm.placarapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, TextWatcher {

    private TextView tvTime1;
    private TextView tvTime2;
    private TextView tvNomeTime1;
    private TextView tvNomeTime2;
   /* private Spinner sp1;
    private Button btMais;
    private Button btMenos;
*/

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime1 = (TextView) findViewById(R.id.tv1);
        tvTime2 = (TextView) findViewById(R.id.tv2);

        tvNomeTime1 = (TextView) findViewById(R.id.time1);
        tvNomeTime2 = (TextView) findViewById(R.id.time2);


        tvNomeTime1.setText(getIntent().getStringExtra(Constantes.TIME1));
        tvNomeTime2.setText(getIntent().getStringExtra(Constantes.TIME2));


        tvTime1.addTextChangedListener(this);
        tvTime1.setOnClickListener(this);
        tvTime2.setOnClickListener(this);
        tvTime2.addTextChangedListener(this);

        if (savedInstanceState != null) {
            tvTime1.setText(savedInstanceState.getString(Constantes.TIME1));
            tvTime2.setText(savedInstanceState.getString(Constantes.TIME2));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv1:
                tvTime1 = calc(tvTime1);
                break;

            case R.id.tv2:
                tvTime2 = calc(tvTime2);
                break;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constantes.TIME1, tvTime1.getText().toString());
        outState.putString(Constantes.TIME2, tvTime2.getText().toString());
    }

    private TextView calc(TextView tv) {
        int i = Integer.parseInt(tv.getText().toString());
        i++;
        tv.setText(String.valueOf(i));
        return tv;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Main2Activity.class));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (Integer.parseInt(s.toString()) < 0) {
            s.replace(0, s.length(), "0");
        }
    }
}
