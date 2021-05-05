package com.Pericos.ITSVC.App;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.Pericos.ITSVC.App.Horarios.DatabaseHelper;
import com.bumptech.glide.Glide;

public class PantallaBienvenida extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_bienvenida);


        //////////////Temporizador de Pantalla inicial////////////////////////
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

               Intent intent = new Intent(PantallaBienvenida.this, DashBoard.class);
               startActivity(intent);
               finish();
           }
       }, 1250);

        ///////////////////////////////////////////////////////////////////////

        ImageView imgPantallaBienvenida = findViewById(R.id.imageViewFONDOBIENV);
        Glide.with(this).load(R.drawable.fondopericosjpeg).into(imgPantallaBienvenida);
        imgPantallaBienvenida.setImageDrawable(null);
        imgPantallaBienvenida.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in));

        ImageView imgLogoPantallaBienvenida = findViewById(R.id.imageViewBienvenida);
        Glide.with(this).load(R.drawable.pericocontituloyfondo2sombra).into(imgLogoPantallaBienvenida);
        imgLogoPantallaBienvenida.setImageDrawable(null);

        imgLogoPantallaBienvenida.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_transition_animation_up));





    }

}
