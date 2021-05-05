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



public class ISIC extends Fragment {

    private RelativeLayout btnReticulaIsic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_isic, container, false);

        btnReticulaIsic = view.findViewById(R.id.idOfertaSistemasReticula);

        btnReticulaIsic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.itsvc.edu.mx/content/docs/isic.pdf");
                Intent reticulaIsic = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(reticulaIsic);
            }
        });

       /* ImageView imgFONDOCARRERAS = view.findViewById(R.id.imageViewFONDOCARRERAS);
        Glide.with(this).load(R.drawable.fondocarreras).into(imgFONDOCARRERAS);
        imgFONDOCARRERAS.setImageDrawable(null);*/


        ImageView imgLOGOISIC = view.findViewById(R.id.imageLogoSISTEMAS);
        Glide.with(this).load(R.drawable.sistemas).into(imgLOGOISIC);
        imgLOGOISIC.setImageDrawable(null);


        ImageView appbarISIC = view.findViewById(R.id.imageViewAppBarISIC);
        Glide.with(this).load(R.drawable.promo_isic).into(appbarISIC);
        appbarISIC.setImageDrawable(null);



        return view;
    }
}