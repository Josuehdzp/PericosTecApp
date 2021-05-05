package com.Pericos.ITSVC.App.PantallaMain;

import android.app.Dialog;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Pericos.ITSVC.App.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;

public class DialogoAcercaDe extends DialogFragment {

    LinearLayout layoutVista;
    TextView texto;
    Button btnsalir;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.DialogTema);

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialogo_licencia, null);

        layoutVista = view.findViewById(R.id.idLicenciaVista);
        texto = view.findViewById(R.id.idTextoLicencia);
        btnsalir = view.findViewById(R.id.idBotonLicencia);


        String str = "";
        try {
            InputStream inputStream = getContext().getAssets().open("License.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);

            str = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        texto.setText(str);


               /* try {
                    InputStream is = getContext().getAssets().open("License.txt");

                    // We guarantee that the available method returns the total
                    // size of the asset...  of course, this does mean that a single
                    // asset can't be more than 2 gigs.
                    int size = is.available();

                    // Read the entire asset into a local byte buffer.
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();

                    // Convert the buffer into a string.
                    String text = new String(buffer);

                    // Finally stick the string into the text view.
                    TextView tv = (TextView)view.findViewById(R.id.text);
                    tv.setText(text);
                } catch (IOException e) {
                    // Should never happen!
                    throw new RuntimeException(e);
                }*/


        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        builder.setView(view);
        return builder.create();
    }
}


