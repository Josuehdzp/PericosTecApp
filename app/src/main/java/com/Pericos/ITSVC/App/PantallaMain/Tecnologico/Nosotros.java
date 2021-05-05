package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.Pericos.ITSVC.App.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.material.appbar.AppBarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Nosotros extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    AppBarLayout appBarLayout;

    YouTubePlayerView youTubePlayerView1;
    String claveYoutube = "AIzaSyB3LaY2EwT_Uh6dcwJ4cIrDUcl4oDcw-mQ";
    Toolbar toolbarNosotros;
    AppCompatActivity appCompatActivity;
    Activity activity;
    KenBurnsView appbarNOSOTROS;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);

        appBarLayout = findViewById(R.id.app_bar_Nosotros);
        youTubePlayerView1 = findViewById(R.id.reproYT);
        youTubePlayerView1.initialize(claveYoutube,this);



        appbarNOSOTROS = findViewById(R.id.imageViewAppBarNOSOTROS);
        Glide.with(getApplicationContext()).load(R.drawable.fotoprincipal).into(appbarNOSOTROS);
        appbarNOSOTROS.setImageDrawable(null);
/*
        ImageView banerMision = findViewById(R.id.imageButtonmISION);
        Glide.with(this).load(R.drawable.figtitulopequeno).into(banerMision);
        banerMision.setImageDrawable(null);

        ImageView banerVision = findViewById(R.id.imageButtonVision);
        Glide.with(this).load(R.drawable.figtitulopequeno).into(banerVision);
        banerVision.setImageDrawable(null);
*/


   /*     ImageView imgFONDONOSOTROS = findViewById(R.id.imageViewFONDONOSOTROS);
        Glide.with(this).load(R.drawable.fondoengranes).into(imgFONDONOSOTROS);
        imgFONDONOSOTROS.setImageDrawable(null);
*/

        // codigo para que la appbar collapsing no tenga scroll
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        params.setBehavior(new AppBarLayout.Behavior());

        CoordinatorLayout.LayoutParams mparams = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });

        ///////////////////////////////////////

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {
        if(!fueRestaurado){
            youTubePlayer.cueVideo("rpNc2JUIh2c");
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this,1).show();
        } else {
            String error = "Error al inicializar Youtube: " + youTubeInitializationResult.toString();
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }

    }

    protected void onActivityResult(int requestCode, int resultcode, Intent data){

        if(resultcode==1){
            getYoutubePlayerProvider().initialize(claveYoutube,this);
        }

    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){
        return  youTubePlayerView1;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }


}
