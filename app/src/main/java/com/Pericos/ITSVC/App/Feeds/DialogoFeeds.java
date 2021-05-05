package com.Pericos.ITSVC.App.Feeds;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;

public class DialogoFeeds extends DialogFragment {

    RelativeLayout layoutVista;
    PhotoView photoView;
    String urldelaImagen;
    RelativeLayout btnDescargar;
    ImageView btnSalir;
    Bitmap bitmap;
    OutputStream outputStream;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.DialogTema);


        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.feed_dialogo, null);

        photoView = view.findViewById(R.id.idFeedDialogImage);
        btnDescargar = view.findViewById(R.id.idDialogImagenGuardarImagen);
        btnSalir = view.findViewById(R.id.idDialogImagenSalir);

        Bundle bundle = getArguments();
        urldelaImagen = bundle.getString("full_picture","");

        Glide.with(getContext())
                .load(urldelaImagen)
                .into(photoView);

        layoutVista = view.findViewById(R.id.idVistaFeedDialogo);

        builder.setView(view);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable drawable =(BitmapDrawable) photoView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();

                String path = Environment.getExternalStorageDirectory().toString();
                File direccion = new File(path+"/PericosApp/Imagenes guardadas/");
                direccion.mkdirs();

                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String nombre = "IMG - "+timeStamp+".jpg";

                File file = new File(direccion,nombre);
                try {
                    outputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    Toast.makeText(getContext(), "Imagen Guardada!", Toast.LENGTH_SHORT).show();
                    outputStream.flush();
                    outputStream.close();
                    //MediaStore.Images.Media.insertImage(getContext().getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }



                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));

                MediaScannerConnection.scanFile(getContext(), new String[]{file.toString()}, new String[]{file.getName()}, null);
            }

            private void sendBroadcast(Intent intent) {
            }
        });

        verifyStoragePermissions(((AppCompatActivity) getContext()));
        return builder.create();

    }

    public static boolean verifyStoragePermissions(AppCompatActivity activity) {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int REQUEST_EXTERNAL_STORAGE = 1;
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
            return false;
        } else {
            return true;
        }
    }


}


