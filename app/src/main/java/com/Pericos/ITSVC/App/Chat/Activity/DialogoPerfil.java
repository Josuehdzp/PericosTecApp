package com.Pericos.ITSVC.App.Chat.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LMensaje;
import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class DialogoPerfil extends DialogFragment {

    private List<LMensaje> listMensaje = new ArrayList<>();

    RelativeLayout layoutVista;
    String keyUsuario;
    String keyUsuarioReceptor;
    String nombreUsuarioReceptor;
    String carreraUsuarioReceptor;
    String correoUsuarioReceptor;
    String fotoUsuarioReceptor;
    String matriculaUsuarioReceptor;
    String generoUsuarioReceptor;

    LinearLayout cardChat;
    CircleImageView fotoPerfil;
    CircleImageView fotoCarrera;
    ImageView fotoPerfilFondo;
    ImageView iconoCarrera;
    TextView nombre;
    TextView carrera;
    TextView correo;
    TextView matricula;
    TextView genero;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.DialogTema);


        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.chat_activity_perfil_usuarios, null);

        layoutVista = view.findViewById(R.id.idVistaFeedDialogo);

        fotoPerfil = view.findViewById(R.id.idEstudiantesClickFotoUsuario);
        fotoCarrera = view.findViewById(R.id.idEstudiantesClickFotoUsuario);
        fotoPerfilFondo = view.findViewById(R.id.idEstudiantesClickFondo);
        iconoCarrera = view.findViewById(R.id.idEstudiantesClickIconoCarrera);
        nombre = view.findViewById(R.id.idEstudiantesClickNombreUsuario);
        carrera = view.findViewById(R.id.idEstudiantesClickCarreraUsuario);
        correo = view.findViewById(R.id.idEstudiantesClickCorreoUsuario);
        matricula = view.findViewById(R.id.idEstudiantesClickMatriculaUsuario);
        genero = view.findViewById(R.id.idEstudiantesClickGeneroUsuario);
        cardChat = view.findViewById(R.id.idEstudiantesClickCardChat);

        Bundle bundle = getArguments();
        keyUsuario= bundle.getString("key_usuario","");
        keyUsuarioReceptor = bundle.getString("key_receptor","");
        nombreUsuarioReceptor = bundle.getString("nombre_usuario","");
        fotoUsuarioReceptor = bundle.getString("foto_usuario","");
        carreraUsuarioReceptor = bundle.getString("carrera_usuario","");
        correoUsuarioReceptor = bundle.getString("correo_usuario","");
        matriculaUsuarioReceptor = bundle.getString("matricula_usuario","");
        generoUsuarioReceptor = bundle.getString("genero_usuario","");

        nombre.setText(nombreUsuarioReceptor);
        carrera.setText(carreraUsuarioReceptor);
        correo.setText(correoUsuarioReceptor);
        matricula.setText(matriculaUsuarioReceptor);
        genero.setText(generoUsuarioReceptor);

        Glide.with(getContext()).load(fotoUsuarioReceptor).into(fotoPerfil);
        Glide.with(getContext()).load(fotoUsuarioReceptor).into(fotoPerfilFondo);

        if (carreraUsuarioReceptor.equals("ISIC")){
            Glide.with(getContext()).load(R.drawable.isic_icon_nice).into(iconoCarrera);
        }
        else if (carreraUsuarioReceptor.equals("IIAL")){
            Glide.with(getContext()).load(R.drawable.icono_iial_nice).into(iconoCarrera);
        }
        else if (carreraUsuarioReceptor.equals("IFOR")){
            Glide.with(getContext()).load(R.drawable.icon_ifor_nice).into(iconoCarrera);
        }
        else if (carreraUsuarioReceptor.equals("IGEO")){
            Glide.with(getContext()).load(R.drawable.icon_igeo_nice).into(iconoCarrera);
        }
        else if (carreraUsuarioReceptor.equals("IGEM")){
            Glide.with(getContext()).load(R.drawable.icon_igem_nice).into(iconoCarrera);
        } else{
            Glide.with(getContext()).load(R.drawable.icono_itsvc_nice).into(iconoCarrera);
        }

        cardChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MensajeriaActivityIndividual.class);
                intent.putExtra("key_usuario",keyUsuario);

                intent.putExtra("key_receptor",keyUsuarioReceptor);
                intent.putExtra("nombre_usuario",nombreUsuarioReceptor);
                intent.putExtra("carrera_usuario",carreraUsuarioReceptor);
                intent.putExtra("foto_usuario",fotoUsuarioReceptor);
                intent.putExtra("correo_usuario",correoUsuarioReceptor);
                intent.putExtra("matricula_usuario",matriculaUsuarioReceptor);
                intent.putExtra("genero_usuario",generoUsuarioReceptor);
                startActivity(intent);
            }
        });

        builder.setView(view);


        return builder.create();

    }



}


