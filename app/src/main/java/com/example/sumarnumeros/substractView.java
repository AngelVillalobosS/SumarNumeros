package com.example.sumarnumeros;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class substractView extends AppCompatActivity {

    private Button backbtn, nextBtn, minusBtn;
    private EditText num1, num2;
    private TextView rstView;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_substract);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        Conexion de fieldtext con atributos
        num1 = findViewById(R.id.firstNumber2);
        num2 = findViewById(R.id.secondNumber2);
//        Conexion de botones con atributos
        backbtn = findViewById(R.id.backBtn2);
        nextBtn = findViewById(R.id.nextBtn2);
        minusBtn = findViewById(R.id.minusBtn);
//        Conexion del display tipo texto
        rstView = findViewById(R.id.resultTxt);

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.start();
                String numb1 = num1.getText().toString();
                String numb2 = num2.getText().toString();
                int n1 = Integer.parseInt(numb1);
                int n2 = Integer.parseInt(numb2);
                int rst = n1 - n2;

                rstView.setText("Resultado: " + rst);


            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mPlayer.start();
                Intent backView = new Intent(substractView.this, mainView.class);
                startActivity(backView);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.start();
                Intent nextView = new Intent(substractView.this, multiplyView.class);
                startActivity(nextView);
            }
        });
    }
}