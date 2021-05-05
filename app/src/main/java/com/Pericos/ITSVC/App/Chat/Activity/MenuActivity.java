package com.Pericos.ITSVC.App.Chat.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Usuario;
import com.Pericos.ITSVC.App.Chat.Persistencia.UsuarioDAO;
import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.github.florent37.arclayout.ArcLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;


public class MenuActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private String KEY_USUARIO;
    private String KEY_USUARIO_RECEPTOR;
    private String NOMBRE_USUARIO;
    private String CARRERA_USUARIO;
    private String CORREO_USUARIO;
    private String MATRICULA_USUARIO;

    String NOMBRE_RECEPTOR;
    String CARRERA_RECEPTOR;
    String FOTO_RECEPTOR;
    String COREO_RECEPTOR;
    String MATRICULA_RECEPTOR;
    String GENERO_RECEPTOR;


    private ArcLayout btnChatCarrera;
    private ArcLayout btnChatIndividual;

    private TextView nombreCarrera;
    private ImageView imagenCarrera;

    Toolbar menuChatsToolbar;

    private Button BtnChatISIC;
    private Button BtnChatIIAL;
    private Button BtnChatIFOR;
    private Button BtnChatIGEO;
    private Button BtnChatIGEM;
    private Button BtnVerUsuarios;

    private Button BtnCerrarSesion;
    String keyUsuarioReceptor;
    LinearLayout contAbajo;
    LinearLayout contArriba;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_menu_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        menuChatsToolbar = findViewById(R.id.idChatMenuChatToolbar);
        btnChatCarrera = findViewById(R.id.idChatMenuChatCarrera);
        btnChatIndividual = findViewById(R.id.idChatMenuChatIndividual);
        imagenCarrera = findViewById(R.id.idChatMenuChatImagenCarrera);
        nombreCarrera = findViewById(R.id.idChatMenuChatNombreCarrera);
        contAbajo = findViewById(R.id.idChatMenuChatcontAbajo);
        contArriba = findViewById(R.id.idChatMenuChatcontArriba);


        setSupportActionBar(menuChatsToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();

        KEY_USUARIO_RECEPTOR = bundle.getString("key_receptor","");
        KEY_USUARIO = bundle.getString("key_usuario", "");
        NOMBRE_RECEPTOR = bundle.getString("nombre_usuario", "");
        CARRERA_RECEPTOR = bundle.getString("carrera_usuario", "");
        FOTO_RECEPTOR = bundle.getString("foto_usuario", "");
        COREO_RECEPTOR = bundle.getString("correo_usuario", "");
        MATRICULA_RECEPTOR = bundle.getString("matricula_usuario", "");
        GENERO_RECEPTOR = bundle.getString("genero_usuario", "");




        switch (CARRERA_RECEPTOR) {
            case "ISIC":
                nombreCarrera.setText(R.string.titulo_sistemas);
                Glide.with(getApplicationContext()).load(R.drawable.sistemas).into(imagenCarrera);
                contArriba.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                contAbajo.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                btnChatCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

                btnChatCarrera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MenuActivity.this, MensajeriaActivitySistemas.class);
                        intent.putExtra("carrera_usuario",CARRERA_USUARIO);
                        startActivity(intent);
                    }
                });
                break;
            case "IIAL":
                nombreCarrera.setText(R.string.titulo_alimentarias);
                Glide.with(getApplicationContext()).load(R.drawable.alimentarias).into(imagenCarrera);
                contArriba.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                contAbajo.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                btnChatCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

                btnChatCarrera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MenuActivity.this, MensajeriaActivityAlimentarias.class);
                        intent.putExtra("carrera_usuario",CARRERA_USUARIO);
                        startActivity(intent);
                    }
                });
                break;
            case "IFOR":
                nombreCarrera.setText(R.string.titulo_forestal);
                Glide.with(getApplicationContext()).load(R.drawable.forestal).into(imagenCarrera);
                contArriba.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                contAbajo.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                btnChatCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

                btnChatCarrera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MenuActivity.this, MensajeriaActivityForestal.class);
                        intent.putExtra("carrera_usuario",CARRERA_USUARIO);
                        startActivity(intent);
                    }
                });
                break;
            case "IGEO":
                nombreCarrera.setText(R.string.titulo_geociencias);
                Glide.with(getApplicationContext()).load(R.drawable.geocienciaslogo).into(imagenCarrera);
                contArriba.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                contAbajo.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                btnChatCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

                btnChatCarrera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MenuActivity.this, MensajeriaActivityGeociencias.class);
                        intent.putExtra("carrera_usuario",CARRERA_USUARIO);
                        startActivity(intent);
                    }
                });
                break;
            default:
                nombreCarrera.setText(R.string.titulo_gestion);
                Glide.with(getApplicationContext()).load(R.drawable.gestionlogo).into(imagenCarrera);
                contArriba.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                contAbajo.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                btnChatCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

                btnChatCarrera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MenuActivity.this, MensajeriaActivityGestion.class);
                        intent.putExtra("carrera_usuario",CARRERA_USUARIO);
                        startActivity(intent);
                    }
                });
                break;
        }

        btnChatIndividual.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        btnChatIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,VerUsuariosActivity.class);
                intent.putExtra("key_usuario",KEY_USUARIO);

                intent.putExtra("key_receptor",KEY_USUARIO_RECEPTOR);
                intent.putExtra("nombre_usuario", NOMBRE_RECEPTOR);
                intent.putExtra("carrera_usuario", CARRERA_RECEPTOR);
                intent.putExtra("foto_usuario", FOTO_RECEPTOR);
                intent.putExtra("correo_usuario", COREO_RECEPTOR);
                intent.putExtra("matricula_usuario",MATRICULA_RECEPTOR);
                intent.putExtra("genero_usuario",GENERO_RECEPTOR);
                startActivity(intent);
            }
        });

    }

    private void returnLogin(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (UsuarioDAO.getInstancia().isUsuarioLogeado()){
            //El usuario esta logeado
        } else {
            returnLogin();
            finish();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        try {

            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                DatabaseReference reference = database.getReference("Usuarios/" + currentUser.getUid());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Usuario usuario = dataSnapshot.getValue(Usuario.class);
                        Usuario correo = dataSnapshot.getValue(Usuario.class);
                        Usuario matricula = dataSnapshot.getValue(Usuario.class);
                        Usuario carrera = dataSnapshot.getValue(Usuario.class);
                        Usuario perfil = dataSnapshot.getValue(Usuario.class);

                        assert usuario != null;
                        NOMBRE_USUARIO = usuario.getNombre();

                        assert correo != null;
                        CORREO_USUARIO = correo.getCorreo();

                        assert matricula != null;
                        MATRICULA_USUARIO = matricula.getMatricula();

                        assert carrera != null;
                        CARRERA_USUARIO = carrera.getCarrera();

                        assert perfil != null;
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            } else {
                returnLogin();
            }

        } catch (Exception error) {
            Toast.makeText(this, "Error: " + error, Toast.LENGTH_SHORT).show();
        }
    }



}
