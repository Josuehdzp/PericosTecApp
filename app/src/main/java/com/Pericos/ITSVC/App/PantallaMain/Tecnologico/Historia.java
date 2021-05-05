package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;


import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.View;
import android.widget.ImageView;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;

public class Historia extends AppCompatActivity {

    ImageView fotoTec;
    Toolbar historiatoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        historiatoolbar = findViewById(R.id.idHistoriaToolbar);

        fotoTec = findViewById(R.id.idHistoriaFotoTec);
        Glide.with(getApplicationContext()).load(R.drawable.itsvclogo).into(fotoTec);
        fotoTec.setImageDrawable(null);

        setSupportActionBar(historiatoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}