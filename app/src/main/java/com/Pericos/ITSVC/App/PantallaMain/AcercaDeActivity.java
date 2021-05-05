package com.Pericos.ITSVC.App.PantallaMain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.BuildConfig;
import com.Pericos.ITSVC.App.R;
import com.onesignal.OneSignal;

import java.io.IOException;
import java.io.InputStream;

public class AcercaDeActivity extends AppCompatActivity {

    LinearLayout licencia;
    LinearLayout playerIdLayout;
    Toolbar acercaToolbar;
    TextView tvVersion;
    TextView tvPlayerId;
    TextView tvTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_app);
        acercaToolbar = findViewById(R.id.idAcercaToolbar);

        playerIdLayout = findViewById(R.id.idAcercadePlayeridLayout);
        tvPlayerId = findViewById(R.id.idAcercadePlayerid);
        tvVersion = findViewById(R.id.idTVnombreVersion);
        tvTitulo = findViewById(R.id.idAcercadeTitulo);
        licencia = findViewById(R.id.idAcercaLicencia);

        tvVersion.setText(BuildConfig.VERSION_NAME);

        setSupportActionBar(acercaToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

/*
        tvTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UsuarioOneSignalID = OneSignal.getPermissionSubscriptionState().getSubscriptionStatus().getUserId();
                tvPlayerId.setText("Player ID: "+UsuarioOneSignalID);
                playerIdLayout.setVisibility(View.VISIBLE);
                Toast.makeText(AcercaDeActivity.this, "Se ha mostrado su id", Toast.LENGTH_SHORT).show();
            }
        });
*/

        tvTitulo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String UsuarioOneSignalID = OneSignal.getPermissionSubscriptionState().getSubscriptionStatus().getUserId();
                tvPlayerId.setText("Player ID: "+UsuarioOneSignalID);
                playerIdLayout.setVisibility(View.VISIBLE);
                Toast.makeText(AcercaDeActivity.this, "Se ha mostrado su Player ID", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        licencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogoAcercaDe dialog = new DialogoAcercaDe(); //Create a new Dialog
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog
            }
        });

    }
}
