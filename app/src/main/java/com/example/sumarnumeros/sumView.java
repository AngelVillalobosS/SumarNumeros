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

public class sumView extends AppCompatActivity {
    private EditText num1, num2;
    private Button btn, backBtn, nextBtn;
    private TextView txtView;

    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sum);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//      Conexion entre las variables y los elementos graficos
        num1 = findViewById(R.id.firstNumber2);
        num2 = findViewById(R.id.secondNumber2);
//        Conexion para boton y texto
        btn = findViewById(R.id.btnSum);
        backBtn = findViewById(R.id.backBtn2);
        nextBtn = findViewById(R.id.nextBtn2);
        txtView = findViewById(R.id.txtresultado);
//        Se llama al sonido
        mPlayer = MediaPlayer.create(this, R.raw.minecraft_click);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Reproducir el sonido del boton
                mPlayer.start();
//                Se obtiene el valor de los textos

                String val1 = num1.getText().toString();
                String val2 = num2.getText().toString();
                int number1 = Integer.parseInt(val1);
                int number2 = Integer.parseInt(val2);
                int result = number1 + number2;

                txtView.setText("Resultado: " + result);

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mPlayer.start();
                Intent backView = new Intent(sumView.this, mainView.class);
                startActivity(backView);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.start();
                Intent nextView = new Intent(sumView.this, substractView.class);
                startActivity(nextView);
            }
        });

    }
}