package com.Pericos.ITSVC.App.Chat.Adaptadores;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Chat.Activity.DialogoPerfil;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Mensaje;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Usuario;
import com.Pericos.ITSVC.App.Chat.Utilidades.Constantes;
import com.Pericos.ITSVC.App.Feeds.DialogoFeeds;
import com.Pericos.ITSVC.App.Notas.DialogoNotas;
import com.bumptech.glide.Glide;
import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LMensaje;
import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LUsuario;
import com.Pericos.ITSVC.App.Chat.Holder.MensajeriaHolder;
import com.Pericos.ITSVC.App.Chat.Persistencia.UsuarioDAO;
import com.Pericos.ITSVC.App.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MensajeriaAdaptador extends RecyclerView.Adapter<MensajeriaHolder> {

    private List<LMensaje> listMensaje = new ArrayList<>();
    private Context contexto;
    private FirebaseDatabase database; 
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    String Dao;
    String msj;

    public MensajeriaAdaptador(Context c) {
        this.contexto = c;
    }

    public int addMensaje(LMensaje lMensaje){
        listMensaje.add(lMensaje);
        //3 mensajes
        int posicion = listMensaje.size()-1;//3
        notifyItemInserted(listMensaje.size());
        return posicion;
    }

    public void actualizarMensaje(int posicion,LMensaje lMensaje){
        listMensaje.set(posicion,lMensaje);//2
        notifyItemChanged(posicion);

    }

    @Override
    public MensajeriaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType==1){
            view = LayoutInflater.from(contexto).inflate(R.layout.chat_cardview_mensajes_emisor,parent,false);
            view.setAnimation(AnimationUtils.loadAnimation(contexto,R.anim.fragment_close_enter));



        }else{
            view = LayoutInflater.from(contexto).inflate(R.layout.chat_cardview_mensajes_receptor,parent,false);
            view.setAnimation(AnimationUtils.loadAnimation(contexto,R.anim.activity_open_enter));


        }
        return new MensajeriaHolder(view);
    }

    @Override
    public void onBindViewHolder(final MensajeriaHolder holder, int position) {


        final LMensaje lMensaje = listMensaje.get(position);

        final LUsuario lUsuario = lMensaje.getlUsuario();

        try {
            if (lUsuario != null) {
                holder.getNombre().setText(lUsuario.getUsuario().getNombre());

                Glide.with(contexto)
                        .load(lUsuario.getUsuario().getFotoPerfilURL())
                        .into(holder.getFotoMensajePerfil());
            } else {

                holder.getNombre().setText(R.string.titulo_sistemas);
                Glide.with(contexto)
                        .load(contexto.getResources().getDrawable(R.drawable.perfilpericodefault))
                        .into(holder.getFotoMensajePerfil());
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }

        try {
            holder.getMensaje().setText(lMensaje.getMensaje().getMensaje());
            if (lMensaje.getMensaje().isContieneFoto()) {
                //msj=lMensaje.getMensaje().getMensaje();

                holder.getFotoMensaje().setVisibility(View.VISIBLE);
                holder.getMensaje().setVisibility(View.VISIBLE);
                Glide.with(contexto)
                        .load(lMensaje.getMensaje().getUrlFoto())
                        .into(holder.getFotoMensaje());
            } else {
                //Dao=lMensaje.getMensaje().getMensaje();
                holder.getFotoMensaje().setVisibility(View.GONE);
                holder.getMensaje().setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        try {
            holder.getHora().setText(lMensaje.fechaDeCreacionDelMensaje());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String imagenString = lMensaje.getMensaje().getUrlFoto();
        holder.getFotoMensaje().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle(); //Bundle cotiene los datos a mandar a el dialog
                bundle.putString("full_picture",imagenString);


                DialogoFeeds dialog = new DialogoFeeds();
                dialog.setArguments(bundle);
                dialog.show(((AppCompatActivity) contexto).getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }

    @Override
    public int getItemViewType(int position) {


        if(listMensaje.get(position).getlUsuario()!=null){

            if(listMensaje.get(position).getlUsuario().getKey().equals(UsuarioDAO.getInstancia().getKeyUsuario())){
                return 1;

            }else {

                return -1;
            }

        }else{


            return -1;
        }



        //return super.getItemViewType(position);
    }
}
