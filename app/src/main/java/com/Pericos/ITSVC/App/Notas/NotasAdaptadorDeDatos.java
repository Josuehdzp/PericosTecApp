package com.Pericos.ITSVC.App.Notas;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NotasAdaptadorDeDatos extends RecyclerView.Adapter<NotasAdaptadorDeDatos.ViewHolderDatos> {


    public static final String TITULO = "TituloNota";
    public static final String CUERPO = "CuerpoNota";
    public static final String FECHA = "FechaNota";
    public static final String HORA = "HoraNota";
    public static final String COLOR = "FondoNota";
    public static final String COMBINACION = "";


    ArrayList<StringsNotas> listaNotasDatos;

    public NotasAdaptadorDeDatos(ArrayList<StringsNotas> listaNotasDatos) {
        this.listaNotasDatos = listaNotasDatos;
    }

    @NonNull
    @Override
    public NotasAdaptadorDeDatos.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notas_items,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(NotasAdaptadorDeDatos.ViewHolderDatos holder, final int position) {
        //holder.asignarDatos(listaNotasDatos.get(position));

        holder.txtNotas1.setText(listaNotasDatos.get(position).getTituloNota());
        holder.txtNotas2.setText(listaNotasDatos.get(position).getCuerpoNota());
        holder.txtNotas3.setText(listaNotasDatos.get(position).getFechaNota());
        holder.txtNotas4.setText(listaNotasDatos.get(position).getHoraNota());
        holder.txtNotas5.setText(listaNotasDatos.get(position).getColorNota());



        //holder.contenedordeNotas.setCardBackgroundColor(Color.parseColor(listaNotasDatos.get(position).getColorNota().toString()));
        holder.contenedordeNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringsNotas datosAmandar = listaNotasDatos.get(position);
                Intent skipIntent = new Intent(v.getContext(), NotasCompleta.class);

                skipIntent.putExtra(TITULO, datosAmandar.getTituloNota());
                skipIntent.putExtra(CUERPO, datosAmandar.getCuerpoNota());
                skipIntent.putExtra(FECHA, datosAmandar.getFechaNota());
                skipIntent.putExtra(HORA, datosAmandar.getHoraNota());
                skipIntent.putExtra(COLOR, datosAmandar.getColorNota());

                v.getContext().startActivity(skipIntent);


                //Toast.makeText(v.getContext(), "Tu nota: "+listaNotasDatos.get(position).getCuerpoNota(), Toast.LENGTH_LONG).show();

                ((Activity)v.getContext()).finish();

            }
        });

        try {
            holder.imagenNotas.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(listaNotasDatos.get(position).getColorNota())));
            holder.padreFondoNotas.setBackgroundColor((Color.parseColor(listaNotasDatos.get(position).getColorNota())));
            holder.contenedordeNotas.setCardBackgroundColor((Color.parseColor(listaNotasDatos.get(position).getColorNota())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listaNotasDatos.size();
    }




    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txtNotas1, txtNotas2, txtNotas3, txtNotas4, txtNotas5;
        CardView contenedordeNotas;
        ImageView imagenNotas;
        LinearLayout padreFondoNotas;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            txtNotas1 = itemView.findViewById(R.id.idNotasTitulo);
            txtNotas2 = itemView.findViewById(R.id.idNotasCuerpo);
            txtNotas3 = itemView.findViewById(R.id.idNotasFecha);
            txtNotas4 = itemView.findViewById(R.id.idNotasHora);
            txtNotas5 = itemView.findViewById(R.id.idNotasColor);
            imagenNotas= itemView.findViewById(R.id.idNotasImagenColor);
            contenedordeNotas = itemView.findViewById(R.id.idNotasContenedor);
            padreFondoNotas = itemView.findViewById(R.id.idLayoutPadreFondoNotas);


        }

        public void asignarDatos(String palabra) {
            txtNotas1.setText(palabra);
        }
    }
}
