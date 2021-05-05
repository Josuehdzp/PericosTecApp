package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoNvoIngreso extends DialogFragment {

    RelativeLayout layoutVista;
    PhotoView photoView;
    String urldelaImagen;
    ImageView btnSalir;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.DialogTema);

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialogo_nvoingreso, null);

        photoView = view.findViewById(R.id.idFeedDialogImage);
        btnSalir = view.findViewById(R.id.idDialogImagenSalir);

        Bundle bundle = getArguments();
        urldelaImagen = bundle.getString("nvo_ingreso_picture","");

        switch (urldelaImagen) {
            case "2020":
                Glide.with(getContext())
                        .load(R.drawable.admision_2020_post_covid19)
                        .into(photoView);

                break;
            case "nvo_ingreso_picture_isic":
                Glide.with(getContext())
                        .load(R.drawable.nuevo_ingreso_isic)
                        .into(photoView);
                break;
            case "nvo_ingreso_picture_iial":
                Glide.with(getContext())
                        .load(R.drawable.nuevo_ingreso_iial)
                        .into(photoView);
                break;
            case "nvo_ingreso_picture_ifor":
                Glide.with(getContext())
                        .load(R.drawable.nuevo_ingreso_ifor)
                        .into(photoView);
                break;
            case "nvo_ingreso_picture_igeo":
                Glide.with(getContext())
                        .load(R.drawable.nuevo_ingreso_igeo)
                        .into(photoView);
                break;
            default:
                Glide.with(getContext())
                        .load(R.drawable.nuevo_ingreso_igem)
                        .into(photoView);
                break;
        }



        layoutVista = view.findViewById(R.id.idVistaDialogoNvoIngreso);

        builder.setView(view);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        builder.setView(view);
        return builder.create();
    }
}


