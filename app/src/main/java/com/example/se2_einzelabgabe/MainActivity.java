package com.example.se2_einzelabgabe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sent;
        sent = findViewById(R.id.button);
        sent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText MatNr = (EditText) findViewById(R.id.Eingabefeld);
                TextView result = (TextView) findViewById((R.id.textView));

                String num = MatNr.getText().toString();

                Client TCP = new Client(num);
                TCP.start();

                try {
                    TCP.join();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                result.setText(TCP.modifiedSentence);

                char[] array = new char[num.length()];

                for (int i = 0; i < array.length; i++) {
                    array[i] = num.charAt(i);
                    for (int j = 1; j < array.length; j += 2) {
                        if (array[j] == '0') {
                            array[j] = 'j';
                        } else if (array[j] == '1') {
                            array[j] = 'a';
                        } else if (array[j] == '2') {
                            array[j] = 'b';
                        } else if (array[j] == '3') {
                            array[j] = 'c';
                        } else if (array[j] == '4') {
                            array[j] = 'd';
                        } else if (array[j] == '5') {
                            array[j] = 'e';
                        } else if (array[j] == '6') {
                            array[j] = 'f';
                        } else if (array[j] == '7') {
                            array[j] = 'g';
                        } else if (array[j] == '8') {
                            array[j] = 'h';
                        } else if (array[j] == '9') {
                            array[j] = 'i';
                        }
                        String solution = String.valueOf(array);
                        result.setText(solution);

                    }
                }
            }
        });
    }
}
