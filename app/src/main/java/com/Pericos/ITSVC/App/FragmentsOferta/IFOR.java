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


public class IFOR extends Fragment {

    private RelativeLayout btnReticulaIfor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_ifor, container, false);

        btnReticulaIfor = view.findViewById(R.id.idOfertaForestalReticula);

        btnReticulaIfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.itsvc.edu.mx/content/docs/ifor.pdf");
                Intent reticulaIfor = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(reticulaIfor);
            }
        });


        /*ImageView imgFONDOIFOR = view.findViewById(R.id.imageViewFondoIFOR);
        Glide.with(this).load(R.drawable.fondocarreras).into(imgFONDOIFOR);
        imgFONDOIFOR.setImageDrawable(null);*/

        ImageView imgLOGOIFOR = (ImageView) view.findViewById(R.id.imageLogoFORESTAL);
        Glide.with(this).load(R.drawable.forestal).into(imgLOGOIFOR);

        ImageView appbarIFOR = (ImageView) view.findViewById(R.id.imageViewAppBarIFOR);
        Glide.with(this).load(R.drawable.promo_ifor).into(appbarIFOR);



        return view;
    }
}