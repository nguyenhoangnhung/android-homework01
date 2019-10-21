package com.thiennd.as001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String MAIN_TAG = "MAIN_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(MAIN_TAG, "on create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = findViewById(R.id.btnAdd);

        EditText et1 = findViewById(R.id.number1);
        EditText et2 = findViewById(R.id.number2);
        TextView answer = findViewById(R.id.answer);

        MyOnClick moc = new MyOnClick();
        moc.setMocTextView(answer);
        moc.setEt1(et1);
        moc.setEt2(et2);

        btnAdd.setOnClickListener(moc);




        Button btnLower = findViewById(R.id.btnLower);
        Button btnUpper = findViewById(R.id.btnUpper);
        final EditText content = findViewById(R.id.content);
        content.setText("okel;af");
        btnLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setText(content.getText().toString().toLowerCase());
            }
        });
        btnUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setText(content.getText().toString().toUpperCase());
            }
        });

        ((Button) findViewById(R.id.btnOpen)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondActivity);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(MAIN_TAG, "on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MAIN_TAG, "on destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MAIN_TAG, "on start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MAIN_TAG, "on stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MAIN_TAG, "on resume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MAIN_TAG, "on pause");
    }

}

class MyOnClick implements View.OnClickListener {
    TextView mocTextView;
    EditText et1;
    EditText et2;

    @Override
    public void onClick(View v) {
        int a = Integer.valueOf(et1.getText().toString());
        int b = Integer.valueOf(et2.getText().toString());
        mocTextView.setText(String.valueOf(a+b));
    }

    public void setMocTextView(TextView mocTextView) {
        this.mocTextView = mocTextView;
    }

    public void setEt1(EditText et1) {
        this.et1 = et1;
    }

    public void setEt2(EditText et2) {
        this.et2 = et2;
    }
}