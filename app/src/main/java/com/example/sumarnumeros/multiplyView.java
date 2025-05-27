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

public class multiplyView extends AppCompatActivity {
    private Button backBtn, nextBtn, multiBtn;
    private EditText num1, num2;
    private TextView rstView;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiply_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Conexion del mPlayer
                mPlayer = MediaPlayer.create(this, R.raw.minecraft_click); // Se llama un sonido para cada boton
//        Conexion de fieldtext con atributos
        num1 = findViewById(R.id.editTextNumber);
        num2 = findViewById(R.id.editTextNumber2);
//        Conexion de botones con atributos
        backBtn = findViewById(R.id.button2);
        nextBtn = findViewById(R.id.button3);
        multiBtn = findViewById(R.id.button);
//        Conexion del display tipo texto
        rstView = findViewById(R.id.textView2);

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.start();
                String numb1 = num1.getText().toString();
                String numb2 = num2.getText().toString();
                if (numb2 != null && numb2 != null){
                    int n1 = Integer.parseInt(numb1);
                    int n2 = Integer.parseInt(numb2);
                    int rst = n1 * n2;
                    rstView.setText("Resultado: " + rst);
                }else{
                    rstView.setText("Debes primero ingresar los numeros");
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mPlayer.start();
                Intent backView = new Intent(multiplyView.this, mainView.class);
                startActivity(backView);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.start();
                Intent nextView = new Intent(multiplyView.this, sumView.class);
                startActivity(nextView);
            }
        });
    }
}