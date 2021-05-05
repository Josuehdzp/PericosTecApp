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


public class IGEM extends Fragment {

    private RelativeLayout btnReticulaIgem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_igem, container, false);

        btnReticulaIgem = view.findViewById(R.id.idOfertaGestionReticula);

        btnReticulaIgem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.itsvc.edu.mx/content/docs/igem.pdf");
                Intent reticulaIgem = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(reticulaIgem);
            }
        });

      /*  ImageView imgFONDOIGEM = view.findViewById(R.id.imageViewFondoIGEM);
        Glide.with(this).load(R.drawable.fondocarreras).into(imgFONDOIGEM);
        imgFONDOIGEM.setImageDrawable(null);
*/
        ImageView imgLOGOIGEM = (ImageView) view.findViewById(R.id.imageLogoGESTION);
        Glide.with(this).load(R.drawable.gestionlogo).into(imgLOGOIGEM);

        ImageView appbarIGEM = (ImageView) view.findViewById(R.id.imageViewAppBarIGEM);
        Glide.with(this).load(R.drawable.promo_igem).into(appbarIGEM);

        return view;
    }
}