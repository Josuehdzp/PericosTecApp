package com.Pericos.ITSVC.App.PantallaMain.Estudiantes;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Chat.Activity.LoginActivity;
import com.Pericos.ITSVC.App.Chat.Activity.MenuActivity;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Usuario;
import com.Pericos.ITSVC.App.Chat.Persistencia.UsuarioDAO;
import com.Pericos.ITSVC.App.Horarios.DatabaseHelper;
import com.Pericos.ITSVC.App.Horarios.HorarioPersonalizado;
import com.Pericos.ITSVC.App.Notas.NotasMain;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wang.avi.AVLoadingIndicatorView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import de.hdodenhof.circleimageview.CircleImageView;


public class Estudiantes extends AppCompatActivity {

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private String FOTO_USUARIO;
    private String NOMBRE_USUARIO;
    private String CARRERA_USUARIO;
    private String CORREO_USUARIO;
    private String MATRICULA_USUARIO;
    private String GENERO_USUARIO;

    private String SISTEMAS = "Ing. Sistemas Computacionales";
    private String ALIMENTARIAS = "Ing. Industias Alimentarias";
    private String FORESTAL = "Ing. Forestal";
    private String GEOCIENCIAS = "Ing. Geociencias";
    private String GESTION = "Ing. Gestión Empresarial";


    Toolbar estudiantestoolbar;
    RelativeLayout CardChat, CardNotas, CardHorario;
    RelativeLayout cerrarSesion;
    ImageView headerImagen;
    TextView nombreUsuario;
    TextView correoUsuario;
    TextView matriculaUsuario;
    TextView carreraUsuario;
    TextView toolbarTexto;
    ImageView iconoCarrera;
    AVLoadingIndicatorView gProgresBarEstudiantes;
    AVLoadingIndicatorView gProgresBarEstudiantesNombre;
    AVLoadingIndicatorView gProgresBarEstudiantesCorreo;
    AVLoadingIndicatorView gProgresBarEstudiantesMatricula;
    AVLoadingIndicatorView gProgresBarEstudiantesCarrera;


    CircleImageView fotoUsuario;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estudiantes_activity);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        //////////////////

        gProgresBarEstudiantes = findViewById(R.id.idEstudiantesProgressBar);
        gProgresBarEstudiantesNombre = findViewById(R.id.idEstudiantesProgressBarNombre);
        gProgresBarEstudiantesCorreo = findViewById(R.id.idEstudiantesProgressBarCorreo);
        gProgresBarEstudiantesMatricula = findViewById(R.id.idEstudiantesProgressBarMatricula);
        gProgresBarEstudiantesCarrera = findViewById(R.id.idEstudiantesProgressBarCarrera);

        estudiantestoolbar = findViewById(R.id.idEstudiantesToolbar);
        toolbarTexto = findViewById(R.id.idEstudiantesToolbarTexto);
        headerImagen = findViewById(R.id.idEstudiantesFotoHeader);
        CardChat = findViewById(R.id.cardchat);
        CardHorario = findViewById(R.id.cardhorario);
        CardNotas = findViewById(R.id.cardnotas);
        cerrarSesion = findViewById(R.id.idEstudiantescardCerrarSesion);

        nombreUsuario = findViewById(R.id.idEstudiantesNombreUsuario);
        correoUsuario = findViewById(R.id.idEstudiantesCorreoUsuario);
        matriculaUsuario = findViewById(R.id.idEstudiantesMatriculaUsuario);
        fotoUsuario = findViewById(R.id.idEstudiantesFotoUsuario);
        carreraUsuario = findViewById(R.id.idEstudiantesCarreraUsuario);
        iconoCarrera = findViewById(R.id.idEstudiantesIconoCarreraUsuario);

        nombreUsuario.setVisibility(View.VISIBLE);
        correoUsuario.setVisibility(View.VISIBLE);
        matriculaUsuario.setVisibility(View.VISIBLE);
        carreraUsuario.setVisibility(View.VISIBLE);

        setSupportActionBar(estudiantestoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));


        fotoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPerfil = new Intent(Estudiantes.this, EstudiantesPerfil.class);
                startActivity(intentPerfil);
            }
        });


        CardHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHorario = new Intent(Estudiantes.this, HorarioPersonalizado.class);
                startActivity(intentHorario);
            }
        });

        CardNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotas = new Intent(Estudiantes.this, NotasMain.class);
                startActivity(intentNotas);
            }
        });

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                returnLogin();
            }
        });

        verifyStoragePermissions(this);
        startProgresAnimacion();
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


    @Override
    protected void onStart() {
        super.onStart();
        startProgresAnimacion();
        try {
            UsuarioDAO.getInstancia().getKeyUsuario();

            final FirebaseUser currentUser = mAuth.getCurrentUser();
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
                        Usuario genero = dataSnapshot.getValue(Usuario.class);

                        assert perfil != null;
                        FOTO_USUARIO = perfil.getFotoPerfilURL();
                        Glide.with(getApplicationContext()).load(FOTO_USUARIO).into(fotoUsuario);
                        Glide.with(getApplicationContext()).load(FOTO_USUARIO).into(headerImagen);
                        fotoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                        headerImagen.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        assert genero != null;
                        GENERO_USUARIO = genero.getGenero();

                        assert usuario != null;
                        NOMBRE_USUARIO = usuario.getNombre();
                        nombreUsuario.setText(NOMBRE_USUARIO);
                        nombreUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        toolbarTexto.setText(NOMBRE_USUARIO);

                        stopProgresAnimacion();

                        CafeBar.builder(Estudiantes.this)
                                .content("Hola! " + NOMBRE_USUARIO)
                                .swipeToDismiss(true)
                                .floating(true)
                                .duration(CafeBar.Duration.SHORT)
                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.verdeicono)))
                                .show();

                        assert correo != null;
                        CORREO_USUARIO = correo.getCorreo();
                        correoUsuario.setText(CORREO_USUARIO);
                        correoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        assert matricula != null;
                        MATRICULA_USUARIO = matricula.getMatricula();
                        matriculaUsuario.setText(MATRICULA_USUARIO);
                        matriculaUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        assert carrera != null;
                        CARRERA_USUARIO = carrera.getCarrera();

                        switch (CARRERA_USUARIO) {
                            case "ISIC":
                                carreraUsuario.setText(SISTEMAS);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.isic_icon_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));


                                break;
                            case "IIAL":
                                carreraUsuario.setText(ALIMENTARIAS);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icono_iial_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            case "IFOR":
                                carreraUsuario.setText(FORESTAL);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icon_ifor_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            case "IGEO":
                                carreraUsuario.setText(GEOCIENCIAS);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icon_igeo_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            case "IGEM":
                                carreraUsuario.setText(GESTION);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icon_igem_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            default:
                                carreraUsuario.setText(CARRERA_USUARIO);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.itsvclogo).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                break;
                        }

                        CardChat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intentChat = new Intent(Estudiantes.this, MenuActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("key_usuario",currentUser.getUid());
                                bundle.putString("nombre_usuario",NOMBRE_USUARIO);
                                bundle.putString("carrera_usuario",CARRERA_USUARIO);
                                bundle.putString("foto_usuario",FOTO_USUARIO);
                                bundle.putString("correo_usuario",CORREO_USUARIO);
                                bundle.putString("matricula_usuario",MATRICULA_USUARIO);
                                bundle.putString("genero_usuario",GENERO_USUARIO);

                                intentChat.putExtras(bundle);
                                startActivity(intentChat);

                            }
                        });

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }


            else {
                stopProgresAnimacion();
                returnLogin();
            }

        } catch (Exception error) {
            stopProgresAnimacion();
            Toast.makeText(this, "Error: " + error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        startProgresAnimacion();

        try {
            UsuarioDAO.getInstancia().getKeyUsuario();

            final FirebaseUser currentUser = mAuth.getCurrentUser();
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
                        Usuario genero = dataSnapshot.getValue(Usuario.class);

                        assert perfil != null;
                        FOTO_USUARIO = perfil.getFotoPerfilURL();
                        Glide.with(getApplicationContext()).load(FOTO_USUARIO).into(fotoUsuario);
                        Glide.with(getApplicationContext()).load(FOTO_USUARIO).into(headerImagen);
                        fotoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                        headerImagen.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        assert genero != null;
                        GENERO_USUARIO = genero.getGenero();

                        assert usuario != null;
                        NOMBRE_USUARIO = usuario.getNombre();
                        nombreUsuario.setText(NOMBRE_USUARIO);
                        nombreUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        toolbarTexto.setText(NOMBRE_USUARIO);

                        stopProgresAnimacion();

                        assert correo != null;
                        CORREO_USUARIO = correo.getCorreo();
                        correoUsuario.setText(CORREO_USUARIO);
                        correoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        assert matricula != null;
                        MATRICULA_USUARIO = matricula.getMatricula();
                        matriculaUsuario.setText(MATRICULA_USUARIO);
                        matriculaUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                        assert carrera != null;
                        CARRERA_USUARIO = carrera.getCarrera();

                        switch (CARRERA_USUARIO) {
                            case "ISIC":
                                carreraUsuario.setText(SISTEMAS);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.isic_icon_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));


                                break;
                            case "IIAL":
                                carreraUsuario.setText(ALIMENTARIAS);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icono_iial_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            case "IFOR":
                                carreraUsuario.setText(FORESTAL);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icon_ifor_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            case "IGEO":
                                carreraUsuario.setText(GEOCIENCIAS);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icon_igeo_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            case "IGEM":
                                carreraUsuario.setText(GESTION);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.icon_igem_nice).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));

                                break;
                            default:
                                carreraUsuario.setText(CARRERA_USUARIO);
                                carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                Glide.with(getApplicationContext()).load(R.drawable.itsvclogo).into(iconoCarrera);
                                iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fragment_open_enter));
                                break;
                        }

                        CardChat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intentChat = new Intent(Estudiantes.this, MenuActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("key_usuario",currentUser.getUid());
                                bundle.putString("nombre_usuario",NOMBRE_USUARIO);
                                bundle.putString("carrera_usuario",CARRERA_USUARIO);
                                bundle.putString("foto_usuario",FOTO_USUARIO);
                                bundle.putString("correo_usuario",CORREO_USUARIO);
                                bundle.putString("matricula_usuario",MATRICULA_USUARIO);
                                bundle.putString("genero_usuario",GENERO_USUARIO);

                                intentChat.putExtras(bundle);
                                startActivity(intentChat);

                            }
                        });

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }


            else {
                stopProgresAnimacion();
                returnLogin();
            }

        } catch (Exception error) {
            stopProgresAnimacion();
            Toast.makeText(this, "Error: " + error, Toast.LENGTH_SHORT).show();
        }
    }

    private void returnLogin() {
        startActivity(new Intent(Estudiantes.this, LoginActivity.class));
        finish();
    }



    void startProgresAnimacion(){
        gProgresBarEstudiantes.show();
        gProgresBarEstudiantesNombre.show();
        nombreUsuario.setVisibility(View.INVISIBLE);
        gProgresBarEstudiantesCorreo.show();
        correoUsuario.setVisibility(View.INVISIBLE);
        gProgresBarEstudiantesMatricula.show();
        matriculaUsuario.setVisibility(View.INVISIBLE);
        gProgresBarEstudiantesCarrera.show();
        carreraUsuario.setVisibility(View.INVISIBLE);

    }
    void stopProgresAnimacion(){
        gProgresBarEstudiantes.hide();
        gProgresBarEstudiantesNombre.hide();
        nombreUsuario.setVisibility(View.VISIBLE);
        gProgresBarEstudiantesCorreo.hide();
        correoUsuario.setVisibility(View.VISIBLE);
        gProgresBarEstudiantesMatricula.hide();
        matriculaUsuario.setVisibility(View.VISIBLE);
        gProgresBarEstudiantesCarrera.hide();
        carreraUsuario.setVisibility(View.VISIBLE);
    }



}
