package com.Pericos.ITSVC.App.Chat.Holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.Pericos.ITSVC.App.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class UsuarioViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView civFotoPerfil;
    private ImageView civFotoCarrera;
    private TextView nombreUsuario ;
    private TextView carreraUsuario;
    private TextView matriculaUsuario;
    private TextView correoUsuario;
    private TextView generoUsuario;

    private LinearLayout layoutPrincipal;
    private FrameLayout layoutNo;


    public UsuarioViewHolder(@NonNull View itemView) {
        super(itemView);
        civFotoPerfil = itemView.findViewById(R.id.idChatVerUsuarioscivFotoPerfil);
        civFotoCarrera = itemView.findViewById(R.id.idChatVerUsuarioscivFotoCarrera);
        nombreUsuario = itemView.findViewById(R.id.idChatVerUsuariosNombreUsuario);
        layoutPrincipal = itemView.findViewById(R.id.idChatVerUsuarioslayoutPrincipal);
        carreraUsuario = itemView.findViewById(R.id.idChatVerUsuariosCarrera);
        correoUsuario = itemView.findViewById(R.id.idChatVerUsuariosCorreo);
        generoUsuario = itemView.findViewById(R.id.idChatVerUsuariosGenero);
        matriculaUsuario= itemView.findViewById(R.id.idChatVerUsuariosMatricula);
        layoutNo= itemView.findViewById(R.id.idChatVerUsuariosNoDisponible);
    }

    public CircleImageView getCivFotoPerfil() {
        return civFotoPerfil;
    }

    public void setCivFotoPerfil(CircleImageView civFotoPerfil) {
        this.civFotoPerfil = civFotoPerfil;
    }

    public ImageView getCivFotoCarrera() {
        return civFotoCarrera;
    }

    public void setCivFotoCarrera(ImageView civFotoCarrera) {
        this.civFotoCarrera = civFotoCarrera;
    }

    public LinearLayout getLayoutPrincipal() {
        return layoutPrincipal;
    }

    public void setLayoutPrincipal(LinearLayout layoutPrincipal) {
        this.layoutPrincipal = layoutPrincipal;
    }

    public TextView getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(TextView nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public TextView getCarreraUsuario() {
        return carreraUsuario;
    }

    public void setCarreraUsuario(TextView carreraUsuario) {
        this.carreraUsuario = carreraUsuario;
    }

    public TextView getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public void setMatriculaUsuario(TextView matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }

    public TextView getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(TextView correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public TextView getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(TextView generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public FrameLayout getLayoutNo() {
        return layoutNo;
    }

    public void setLayoutNo(FrameLayout layoutNo) {
        this.layoutNo = layoutNo;
    }
}
