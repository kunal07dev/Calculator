package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    ImageView one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,equal,dot,multiply,mod ,clear,division;
    TextView input,output;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        dot=findViewById(R.id.dot);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        mod=findViewById(R.id.mod);
        equal=findViewById(R.id.equal);
        multiply=findViewById(R.id.multiply);
        division=findViewById(R.id.division);
        clear=findViewById(R.id.c);
        input=findViewById(R.id.input);
        output=findViewById(R.id.output);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"9");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"*");
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"%");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+"/");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=input.getText().toString();
                input.setText(data+".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                input.setText("");
                output.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data=input.getText().toString();

               // data=data.replaceAll("")
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalre=" ";
                Scriptable scriptable=rhino.initStandardObjects();
                try {
                    output.setTextSize(70);

                    finalre = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();


                    if(finalre.length()>10){
                        output.setTextSize(60);


                    }
                    output.setText(finalre);

                }
                catch (Exception e){
                    input.setText("");
                    output.setTextSize(30);
                    output.setText("Invalid Syntax");


                }

            }
        });





    }
}