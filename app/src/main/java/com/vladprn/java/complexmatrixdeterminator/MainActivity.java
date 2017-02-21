package com.vladprn.java.complexmatrixdeterminator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputE;
    private TextView determinatorT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputE = (EditText) findViewById(R.id.input);
        determinatorT = (TextView) findViewById(R.id.determinator);
    }

    public void runClick(View v) {

        Matrix mx;
        try {
            mx = new Matrix(inputE.getText().toString());
            determinatorT.setText(mx.determinate().toString());
        } catch (Exception ex) {
            determinatorT.setText("Что за * ты мне подсунул?");
        }
    }
}
