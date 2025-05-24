package com.example.sumarnumeros;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mainView extends AppCompatActivity {

    private Button btn_sum, btn_sub, btn_mult, btn_div;
    private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //    Conexion de variables a vista
        btn_sum = findViewById(R.id.btnViewSuma);
        btn_sub = findViewById(R.id.btnSubView);
        btn_mult = findViewById(R.id.btnMultView);
        btn_div = findViewById(R.id.btnDivView);

        mPlayer = MediaPlayer.create(this, R.raw.minecraft_click); // Se llama un sonido para cada boton

        btn_sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Crear el Intent
                Intent sumView = new Intent(mainView.this, sumView.class);
                // Reproducir el sonido
                mPlayer.start();
                startActivity(sumView);
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subView = new Intent(mainView.this, substractView.class);
                mPlayer.start();
                startActivity(subView);
            }
        });

        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent multView = new Intent(mainView.this, multiplyView.class);
                mPlayer.start();
                startActivity(multView);
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent divView = new Intent(mainView.this, divView.class);
                mPlayer.start();
                startActivity(divView);
            }
        });
    }
}