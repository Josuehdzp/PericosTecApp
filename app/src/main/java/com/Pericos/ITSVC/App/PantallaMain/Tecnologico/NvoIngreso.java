package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Pericos.ITSVC.App.PantallaMain.OfertaEducativaActivity;
import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.thefinestartist.finestwebview.FinestWebView;

public class NvoIngreso extends AppCompatActivity{


    CardView btnIsic,btnIial,btnIfor,btnIgeo,btnIgem;
    Toolbar nvoIngresotoolbar;
    ImageView imgISIC,imgIIAL,imgIFOR,imgIGEO,imgIGEM;
    TextView TVNvoIngreso1;
    RelativeLayout btnsolicitud;
    String URLFicha = "https://forms.gle/8nvdZ24MSE6DDYyY8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvo_ingreso);

        nvoIngresotoolbar = findViewById(R.id.idNvoIngresoToolbar);

        TVNvoIngreso1 = findViewById(R.id.idNvoIngresoTexto1);
        btnsolicitud = findViewById(R.id.idNvoIngresoBtnSolicitarFicha);
        btnIsic = findViewById(R.id.idNvoIngresoBtnIsic);
        btnIial = findViewById(R.id.idNvoIngresoBtnIial);
        btnIfor = findViewById(R.id.idNvoIngresoBtnIfor);
        btnIgeo = findViewById(R.id.idNvoIngresoBtnIgeo);
        btnIgem = findViewById(R.id.idNvoIngresoBtnIgem);

        imgISIC = findViewById(R.id.idNvoIngresoImagenIsic);
        imgIIAL = findViewById(R.id.idNvoIngresoImagenIial);
        imgIFOR = findViewById(R.id.idNvoIngresoImagenIfor);
        imgIGEO = findViewById(R.id.idNvoIngresoImagenIgeo);
        imgIGEM = findViewById(R.id.idNvoIngresoImagenIgem);

        TVNvoIngreso1.setMovementMethod(LinkMovementMethod.getInstance());

        setSupportActionBar(nvoIngresotoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        RoundedImageView imgPrimera = findViewById(R.id.imgPrimera);
        Glide.with(getApplicationContext())
                .load(R.drawable.admision_2020_post_covid19)
                .into(imgPrimera);
        imgPrimera.setImageDrawable(null);

        ImageView imgInsLogo = findViewById(R.id.inscripLogo);
        Glide.with(getApplicationContext())
                .load(R.drawable.pericocontituloyfondo2sombra)
                .placeholder(R.drawable.pericocontituloyfondo2sombra)
                .into(imgInsLogo);
        imgInsLogo.setImageDrawable(null);

        ImageView imgOF1 = findViewById(R.id.idNvoIngresoImgIsic);
        Glide.with(getApplicationContext())
                .load(R.drawable.isic_icon_blanco)
                .into(imgOF1);
        imgOF1.setImageDrawable(null);

        ImageView imgOF2 = findViewById(R.id.idNvoIngresoImgIial);
        Glide.with(getApplicationContext())
                .load(R.drawable.icono_iial_blanco)
                .into(imgOF2);
        imgOF2.setImageDrawable(null);

        ImageView imgOF3 = findViewById(R.id.idNvoIngresoImgIfor);
        Glide.with(getApplicationContext())
                .load(R.drawable.icon_ifor_blanco)
                .into(imgOF3);
        imgOF3.setImageDrawable(null);

        ImageView imgOF4 = findViewById(R.id.idNvoIngresoImgIgeo);
        Glide.with(getApplicationContext())
                .load(R.drawable.icon_igeo_blanco)
                .into(imgOF4);
        imgOF4.setImageDrawable(null);

        ImageView imgOF5 = findViewById(R.id.idNvoIngresoImgIgem);
        Glide.with(getApplicationContext())
                .load(R.drawable.icon_igem_blanco)
                .into(imgOF5);
        imgOF5.setImageDrawable(null);

        Glide.with(getApplicationContext())
                .load(R.drawable.nuevo_ingreso_isic)
                .into(imgISIC);
        imgISIC.setImageDrawable(null);

        Glide.with(getApplicationContext())
                .load(R.drawable.nuevo_ingreso_iial)
                .into(imgIIAL);
        imgIIAL.setImageDrawable(null);

        Glide.with(getApplicationContext())
                .load(R.drawable.nuevo_ingreso_ifor)
                .into(imgIFOR);
        imgIFOR.setImageDrawable(null);

        Glide.with(getApplicationContext())
                .load(R.drawable.nuevo_ingreso_igeo)
                .into(imgIGEO);
        imgIGEO.setImageDrawable(null);

        Glide.with(getApplicationContext())
                .load(R.drawable.nuevo_ingreso_igem)
                .into(imgIGEM);
        imgIGEM.setImageDrawable(null);

        btnsolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new FinestWebView.Builder(NvoIngreso.this)
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

                        .show("https://forms.gle/8nvdZ24MSE6DDYyY8");*/
                String url = URLFicha;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });
    }


public void Carreras(View chido){
    switch (chido.getId()) {

        case R.id.idNvoIngresoBtnIsic:
            Intent btnOSis = new Intent(NvoIngreso.this, OfertaEducativaActivity.class);
            startActivity(btnOSis);

            break;
        case R.id.idNvoIngresoBtnIial:
            Intent btnOFor = new Intent(NvoIngreso.this, OfertaEducativaActivity.class);
            startActivity(btnOFor);

            break;
        case R.id.idNvoIngresoBtnIfor:
            Intent btnOAli = new Intent(NvoIngreso.this, OfertaEducativaActivity.class);
            startActivity(btnOAli);

            break;
        case R.id.idNvoIngresoBtnIgeo:
            Intent btnOGeo = new Intent(NvoIngreso.this, OfertaEducativaActivity.class);
            startActivity(btnOGeo);

            break;
        case R.id.idNvoIngresoBtnIgem:
            Intent btnOGes = new Intent(NvoIngreso.this, OfertaEducativaActivity.class);
            startActivity(btnOGes);

            break;
        default:
            break;
    }
}

@SuppressLint("ResourceType")
public void NvoIngresoCarreras(View chido){
    Bundle bundle = new Bundle(); //Bundle cotiene los datos a mandar a el dialog
    DialogoNvoIngreso dialog = new DialogoNvoIngreso(); //Crear un nuevo Dialog
    switch (chido.getId()) {

            case R.id.imgPrimera:
            bundle.putString("nvo_ingreso_picture", "2020");
            dialog.setArguments(bundle);
            dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog

            break;

            case R.id.idNvoIngresoImagenIsic:
                bundle.putString("nvo_ingreso_picture", "nvo_ingreso_picture_isic");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog

                break;
            case R.id.idNvoIngresoImagenIial:
                bundle.putString("nvo_ingreso_picture", "nvo_ingreso_picture_iial");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog

                break;
            case R.id.idNvoIngresoImagenIfor:
                bundle.putString("nvo_ingreso_picture", "nvo_ingreso_picture_ifor");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog

                break;
            case R.id.idNvoIngresoImagenIgeo:
                bundle.putString("nvo_ingreso_picture", "nvo_ingreso_picture_igeo");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog

                break;
            case R.id.idNvoIngresoImagenIgem:
                bundle.putString("nvo_ingreso_picture", "nvo_ingreso_picture_igem");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog

                break;

            default:
                break;
        }
    }


}
