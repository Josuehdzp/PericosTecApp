package com.Pericos.ITSVC.App.FragmentsOferta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;


public class IGEO extends Fragment {

    private RelativeLayout btnReticulaIgeo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_igeo, container, false);

        btnReticulaIgeo = view.findViewById(R.id.idOfertaGeocienciasReticula);

        btnReticulaIgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.itsvc.edu.mx/content/docs/igeo.pdf");
                Intent reticulaIgeo = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(reticulaIgeo);
            }
        });


        /*ImageView imgFONDOIGEO = view.findViewById(R.id.imageViewFondoIGEO);
        Glide.with(this).load(R.drawable.fondocarreras).into(imgFONDOIGEO);
        imgFONDOIGEO.setImageDrawable(null);*/

        ImageView imgLOGOIGEO = (ImageView) view.findViewById(R.id.imageLogoGEOCIENCIAS);
        Glide.with(this).load(R.drawable.geocienciaslogo).into(imgLOGOIGEO);

        ImageView appbarIGEO = (ImageView) view.findViewById(R.id.imageViewAppBarIGEO);
        Glide.with(this).load(R.drawable.promo_igeo).into(appbarIGEO);


        return view;

    }
}