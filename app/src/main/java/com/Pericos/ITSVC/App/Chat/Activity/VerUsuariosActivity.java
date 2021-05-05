package com.Pericos.ITSVC.App.Chat.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Usuario;
import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LUsuario;
import com.Pericos.ITSVC.App.Chat.Holder.UsuarioViewHolder;
import com.Pericos.ITSVC.App.R;
import com.Pericos.ITSVC.App.Chat.Utilidades.Constantes;
import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VerUsuariosActivity extends AppCompatActivity {


    private RecyclerView rvUsuarios;
    private FirebaseRecyclerAdapter adapter;
    LUsuario lUsuario;
    String ukey_usuario;
    String ukey_receptor;
    String unombre_usuario;
    String uCarrera;
    String ufoto_usuario;
    String ucorreo_usuario;
    String umatricula_usuario;
    String ugenero_usuario;

    Toolbar verusuariostoolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_ver_usuarios);

        verusuariostoolbar = findViewById(R.id.idVerUsuariosToolbar);

        setSupportActionBar(verusuariostoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        ukey_usuario = bundle.getString("key_usuario");
        ukey_receptor = bundle.getString("key_receptor");
        unombre_usuario = bundle.getString("nombre_usuario");
        uCarrera = bundle.getString("carrera_usuario");
        ufoto_usuario = bundle.getString("foto_usuario");
        ucorreo_usuario = bundle.getString("correo_usuario");
        umatricula_usuario= bundle.getString("matricula_usuario");
        ugenero_usuario = bundle.getString("genero_usuario");

        rvUsuarios = findViewById(R.id.rvUsuarios);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvUsuarios.setLayoutManager(linearLayoutManager);


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child(Constantes.NODO_USUARIOS);

        FirebaseRecyclerOptions<Usuario> options =
                new FirebaseRecyclerOptions.Builder<Usuario>()
                        .setQuery(query, Usuario.class)
                        .build();


        adapter = new FirebaseRecyclerAdapter<Usuario, UsuarioViewHolder>(options) {
            @Override
            public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_cardview_usuario, parent, false);

                return new UsuarioViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(final UsuarioViewHolder holder, int position, Usuario model) {

                final LUsuario lUsuario = new LUsuario(getSnapshots().getSnapshot(position).getKey(), model);
                if (!lUsuario.getKey().equals(ukey_usuario)){
                    Glide.with(getApplicationContext())
                            .load(model.getFotoPerfilURL())
                            .into(holder.getCivFotoPerfil());

                    holder.getNombreUsuario().setText(model.getNombre());
                    holder.getCarreraUsuario().setText(model.getCarrera());
                    holder.getMatriculaUsuario().setText(model.getMatricula());
                    holder.getCorreoUsuario().setText(model.getCorreo());
                    holder.getGeneroUsuario().setText(model.getGenero());
                    holder.getLayoutPrincipal().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            DialogoPerfil dialog = new DialogoPerfil(); //Create a new Dialog
                            Bundle bundle = new Bundle(); //Bundle cotiene los datos a mandar a el dialog
                            bundle.putString("key_usuario",ukey_usuario);

                            bundle.putString("key_receptor",lUsuario.getKey());
                            bundle.putString("nombre_usuario",lUsuario.getUsuario().getNombre());
                            bundle.putString("carrera_usuario",lUsuario.getUsuario().getCarrera());
                            bundle.putString("foto_usuario",lUsuario.getUsuario().getFotoPerfilURL());
                            bundle.putString("correo_usuario",lUsuario.getUsuario().getCorreo());
                            bundle.putString("matricula_usuario",lUsuario.getUsuario().getMatricula());
                            bundle.putString("genero_usuario",lUsuario.getUsuario().getGenero());

                            dialog.setArguments(bundle);
                            dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog
                        }
                    });


                } else {
                    Glide.with(getApplicationContext())
                            .load(model.getFotoPerfilURL())
                            .into(holder.getCivFotoPerfil());

                    holder.getNombreUsuario().setText(model.getNombre());
                    holder.getCarreraUsuario().setText(model.getCarrera());
                    holder.getMatriculaUsuario().setText(model.getMatricula());
                    holder.getCorreoUsuario().setText(model.getCorreo());
                    holder.getGeneroUsuario().setText(model.getGenero());
                    holder.getLayoutPrincipal().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CafeBar.builder(VerUsuariosActivity.this)
                                    .content("No disponible :/")
                                    .swipeToDismiss(true)
                                    .floating(true)
                                    .duration(CafeBar.Duration.SHORT)
                                    .theme(CafeBarTheme.Custom(getResources().getColor(R.color.rojo_bajo)))
                                    .show();
                        }
                    });

                }

                switch (model.getCarrera()) {
                    case "ISIC":
                        Glide.with(getApplicationContext()).load(R.drawable.isic_icon_nice).into(holder.getCivFotoCarrera());
                        break;
                    case "IIAL":
                        Glide.with(getApplicationContext()).load(R.drawable.icono_iial_nice).into(holder.getCivFotoCarrera());
                        break;
                    case "IFOR":
                        Glide.with(getApplicationContext()).load(R.drawable.icon_ifor_nice).into(holder.getCivFotoCarrera());
                        break;
                    case "IGEO":
                        Glide.with(getApplicationContext()).load(R.drawable.icon_igeo_nice).into(holder.getCivFotoCarrera());
                        break;
                    default:
                        Glide.with(getApplicationContext()).load(R.drawable.icon_igem_nice).into(holder.getCivFotoCarrera());
                        break;
                }

            }
        };
        rvUsuarios.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
