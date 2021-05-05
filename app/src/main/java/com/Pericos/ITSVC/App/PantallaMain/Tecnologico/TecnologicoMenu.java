package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;


public class TecnologicoMenu extends AppCompatActivity {

    CardView cardNosotros, cardMsjDirec, cardNvoIngrs, cardHistoria, cardCert;
    Toolbar tecnologicotoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tecnologico_menu);

        tecnologicotoolbar = findViewById(R.id.idTecnologicoToolbar);

        cardNosotros = findViewById(R.id.cardTecNosotros);
        cardMsjDirec = findViewById(R.id.cardTecMsjDirector);
        cardNvoIngrs = findViewById(R.id.cardTecNvoIngreso);
        cardHistoria = findViewById(R.id.cardTecHistoria);
        cardCert = findViewById(R.id.cardTecCertificaciones);

        setSupportActionBar(tecnologicotoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        RoundedImageView imgnstr = findViewById(R.id.imgTecNosotros);
        Glide.with(this).load(R.drawable.edificio_3).into(imgnstr);
        imgnstr.setImageDrawable(null);

        RoundedImageView imgmsj = findViewById(R.id.imgTecMsjDirector);
        Glide.with(this).load(R.drawable.msj_direc_recortada).into(imgmsj);
        imgmsj.setImageDrawable(null);

        RoundedImageView imghis = findViewById(R.id.imgTecHistoria);
        Glide.with(this).load(R.drawable.edificio_4).into(imghis);
        imghis.setImageDrawable(null);

        RoundedImageView imgnvo = findViewById(R.id.imgTecNuevoIngreso);
        Glide.with(this).load(R.drawable.nuevo_ingreso).into(imgnvo);
        imgnvo.setImageDrawable(null);

        RoundedImageView imgnor = findViewById(R.id.imgTecNormatividad);
        Glide.with(this).load(R.drawable.tecmn).into(imgnor);
        imgnor.setImageDrawable(null);

        cardNosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nosotros = new Intent(TecnologicoMenu.this, Nosotros.class);
                startActivity(nosotros);
            }
        });

        cardMsjDirec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msj = new Intent(TecnologicoMenu.this, MensajeDirector.class);
                startActivity(msj);
            }
        });

        cardNvoIngrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nvo = new Intent(TecnologicoMenu.this, NvoIngreso.class);
                startActivity(nvo);
            }
        });

        cardHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent becas = new Intent(TecnologicoMenu.this, Historia.class);
                startActivity(becas);
            }
        });

        cardCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cert = new Intent(TecnologicoMenu.this, Normatividad.class);
                startActivity(cert);
            }
        });

    }


}
