package com.Pericos.ITSVC.App;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.Pericos.ITSVC.App.Chat.Activity.LoginActivity;
import com.Pericos.ITSVC.App.Futuro.FeedsTest2;
import com.Pericos.ITSVC.App.PantallaMain.AcercaDeActivity;
import com.Pericos.ITSVC.App.PantallaMain.OfertaEducativaActivity;
import com.Pericos.ITSVC.App.Feeds.FeedMainRecycler;
import com.Pericos.ITSVC.App.PantallaMain.ContactoActivity;
import com.Pericos.ITSVC.App.PantallaMain.Departamentos;
import com.Pericos.ITSVC.App.PantallaMain.Tecnologico.TecnologicoMenu;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.thefinestartist.finestwebview.FinestWebView;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashBoard extends AppCompatActivity {

    AdaptadorSlider adaptadorSlider;
    SliderView sliderView;
    LinearLayout btnTec, btnOferta, btnAvisos, btnEstudiantes, btnVinculacion, btnPortal, btnContacto, btnAcerca;
    String URL = "https://www.vcarranza.tecnm.mx";
    Toolbar dashboardToolbar;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        crearNotificacion();

        sliderView = findViewById(R.id.dashimageSlider);
        dashboardToolbar = findViewById(R.id.idHistoriaToolbar);

        btnTec = findViewById(R.id.dashbtnTecnologico);
        btnOferta = findViewById(R.id.dashbtnOfertaeducativa);
        btnAvisos = findViewById(R.id.dashbtnAvisos);
        btnEstudiantes = findViewById(R.id.dashbtnEstudiantes);
        btnVinculacion = findViewById(R.id.dashbtnVinculacion);
        btnPortal = findViewById(R.id.dashbtnPortalWeb);
        btnContacto = findViewById(R.id.dashbtnContacto);
        btnAcerca = findViewById(R.id.dashbtnAcercaDe);

        setSupportActionBar(dashboardToolbar);


        final AdaptadorSlider adapter = new AdaptadorSlider(this);
        adapter.setCuenta(7);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        //sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.colorAccent));
        sliderView.setIndicatorUnselectedColor(getResources().getColor(R.color.colorPrimary));
        sliderView.setScrollTimeInSec(5); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });


        btnTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Tecnologico = new Intent(DashBoard.this, TecnologicoMenu.class);
                startActivity(Tecnologico);
            }
        });

        btnOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OfertaEducativa =  new Intent(DashBoard.this, OfertaEducativaActivity.class);
                startActivity(OfertaEducativa);
            }
        });

        btnAvisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar19 = Calendar.getInstance();
                calendar19.setTimeInMillis(System.currentTimeMillis());
                calendar19.set(Calendar.HOUR_OF_DAY, 19);

                Intent intent19 = new Intent(DashBoard.this, Notificacion.class);
                PendingIntent pendingIntent19 = PendingIntent.getBroadcast(DashBoard.this, 0, intent19,0);
                AlarmManager alarmManager19 = (AlarmManager) getSystemService(ALARM_SERVICE);
/*
                long timeAtButtonClick = System.currentTimeMillis();
                long tenSecondsInMillis = 1000 * 10;
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick + tenSecondsInMillis, pendingIntent);
*/
                alarmManager19.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar19.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent19);
                ///////////////////
                Calendar calendar13 = Calendar.getInstance();
                calendar13.setTimeInMillis(System.currentTimeMillis());
                calendar13.set(Calendar.HOUR_OF_DAY, 13);

                Intent intent13 = new Intent(DashBoard.this, Notificacion.class);
                PendingIntent pendingIntent13 = PendingIntent.getBroadcast(DashBoard.this, 0, intent13,0);
                AlarmManager alarmManager13 = (AlarmManager) getSystemService(ALARM_SERVICE);
/*
                long timeAtButtonClick = System.currentTimeMillis();
                long tenSecondsInMillis = 1000 * 10;
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick + tenSecondsInMillis, pendingIntent);
*/
                alarmManager13.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar19.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent13);
                ///////////////////
                Calendar calendar7 = Calendar.getInstance();
                calendar7.setTimeInMillis(System.currentTimeMillis());
                calendar7.set(Calendar.HOUR_OF_DAY, 7);

                Intent intent7 = new Intent(DashBoard.this, Notificacion.class);
                PendingIntent pendingIntent7 = PendingIntent.getBroadcast(DashBoard.this, 0, intent7,0);
                AlarmManager alarmManager7 = (AlarmManager) getSystemService(ALARM_SERVICE);
/*
                long timeAtButtonClick = System.currentTimeMillis();
                long tenSecondsInMillis = 1000 * 10;
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick + tenSecondsInMillis, pendingIntent);
*/
                alarmManager7.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar7.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent7);



                Intent Avisos = new Intent(DashBoard.this, FeedMainRecycler.class);
                startActivity(Avisos);
            }
        });

        btnEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Estudiantes = new Intent(DashBoard.this, LoginActivity.class);
                startActivity(Estudiantes);
            }
        });

        btnVinculacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Vinculacion = new Intent(DashBoard.this, Departamentos.class);
                startActivity(Vinculacion);
            }
        });

        btnPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new FinestWebView.Builder(DashBoard.this)
                        .titleDefault(getResources().getString(R.string.itsvc_titulo))
                        .titleColor(getResources().getColor(R.color.blanco))
                        .toolbarColor(getResources().getColor(R.color.colorPrimary))
                        .urlColor(getResources().getColor(R.color.grisclaro))
                        .swipeRefreshColorRes(R.color.colorPrimaryDark)
                        .swipeRefreshColor(getResources().getColor(R.color.colorAccent))
                        .progressBarColor(getResources().getColor(R.color.colorAccent))
                        .showProgressBar(true)
                        .progressBarHeight(3)
                        .showIconBack(true)
                        .backPressToClose(false)
                        .iconDefaultColor(getResources().getColor(R.color.blanco))
                        .statusBarColor(getResources().getColor(R.color.colorPrimaryDark))
                        .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
                        .webViewSupportZoom(true)
                        .webViewMediaPlaybackRequiresUserGesture(true)

                        .show(URL);
            }
        });

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Contacto = new Intent(DashBoard.this, ContactoActivity.class);
                startActivity(Contacto);
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Acerca = new Intent(DashBoard.this, AcercaDeActivity.class);
                startActivity(Acerca);
            }
        });
    }



    private void crearNotificacion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "NotificacionChannel";
            String descripcion = "Hay noticias nuevas, no te las pierdas!!!";
            int importancia = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notificame", name, importancia);
            channel.setDescription(descripcion);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
