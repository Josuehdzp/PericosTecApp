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


public class IIAL extends Fragment {

    private RelativeLayout btnReticulaIial;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_iial, container, false);

        btnReticulaIial = view.findViewById(R.id.idOfertaAlimentariasReticula);

        btnReticulaIial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.itsvc.edu.mx/content/docs/iial.pdf");
                Intent reticulaIial = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(reticulaIial);
            }
        });


       /* ImageView imgFONDOIIAL = view.findViewById(R.id.imageViewFondoIIAL);
        Glide.with(this).load(R.drawable.fondocarreras).into(imgFONDOIIAL);
        imgFONDOIIAL.setImageDrawable(null);*/

        ImageView imgLOGOIIAL = (ImageView) view.findViewById(R.id.imageLogoALIMENTARIAS );
        Glide.with(this).load(R.drawable.alimentarias).into(imgLOGOIIAL);

        ImageView appbarIIAL = (ImageView) view.findViewById(R.id.imageViewAppBarIIAL);
        Glide.with(this).load(R.drawable.promo_iial).into(appbarIIAL);


        return view;
    }
}