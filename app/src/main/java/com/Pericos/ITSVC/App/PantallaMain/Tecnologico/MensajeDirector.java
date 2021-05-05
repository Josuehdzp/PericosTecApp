package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;

import android.os.Bundle;
import android.widget.ImageView;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MensajeDirector extends AppCompatActivity{

    ImageView imgDirec;
    Toolbar directoolbar;
    KenBurnsView headerDirector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensaje_director_activity);

        headerDirector = findViewById(R.id.idMesjDirecFotoHeader);
        directoolbar = findViewById(R.id.idMesjDirecToolbar);

        imgDirec = findViewById(R.id.idMsjDirectFotoDirec);
        Glide.with(this).load(R.drawable.director_msj).into(imgDirec);
        Glide.with(this).load(R.drawable.edificio_2).into(headerDirector);

        setSupportActionBar(directoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

}
