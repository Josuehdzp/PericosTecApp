package com.Pericos.ITSVC.App.PantallaMain.Estudiantes;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Chat.Activity.LoginActivity;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Usuario;
import com.Pericos.ITSVC.App.Chat.Persistencia.UsuarioDAO;
import com.Pericos.ITSVC.App.Horarios.DatabaseHelper;
import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.kbeanie.multipicker.api.CameraImagePicker;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenImage;

import java.io.File;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import de.hdodenhof.circleimageview.CircleImageView;


public class EstudiantesPerfil extends AppCompatActivity {

    DatabaseHelper myDbHelper;

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    private String NOMBRE_USUARIO;
    private String CARRERA_USUARIO;
    private String CORREO_USUARIO;
    private String MATRICULA_USUARIO;
    private String GENERO_USUARIO;
    private String FECHA_USUARIO;

    private String SISTEMAS = "Ing. Sistemas Computacionales";
    private String ALIMENTARIAS = "Ing. Industias Alimentarias";
    private String FORESTAL = "Ing. Forestal";
    private String GEOCIENCIAS = "Ing. Geociencias";
    private String GESTION = "Ing. Gestión Empresarial";

    private ImagePicker imagePicker;
    private CameraImagePicker cameraPicker;

    CircleImageView fotoUsuario;
    RelativeLayout btnfotoUsuario;
    private String pickerPath;
    private Uri fotoPerfilUri;
    private String fotoPerfilCadena;
    public String uNombre;
    public String uCorreo;
    public String uMatricula;
    public String uCarrera;
    public long uFecha ;
    public String uGenero;
    public String uFotoPerfil;


    RelativeLayout fotoUsuarioAceptar;
    RelativeLayout fotoUsuarioCancelar;

    Toolbar estudiantesToolbar;
    TextView textoToolbar;

    RelativeLayout cerrarSesion;
    ImageView headerImagen;
    TextView nombreUsuario;
    TextView correoUsuario;
    TextView matriculaUsuario;
    TextView carreraUsuario;
    //TextView generoUsuario;
    ImageView iconoCarrera;


    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estudiantes_activity_usuario_perfil);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        //Copiar la Base de datos interna
        myDbHelper = new DatabaseHelper(this, "HorarioDos.db", 1);
        try {
            myDbHelper.CheckDb();
        }catch (Exception e){}
        //////////////////

        estudiantesToolbar = findViewById(R.id.idPerfilEstudiantesToolbar);
        textoToolbar = findViewById(R.id.idPerfilEstudiantesToolbarTexto);
        headerImagen = findViewById(R.id.idPerfilEstudiantesFotoHeader);

        cerrarSesion = findViewById(R.id.idPerfilEstudiantescardCerrarSesion);

        fotoUsuarioAceptar =findViewById(R.id.idEstudiantesFotoUsuarioAceptar);
        fotoUsuarioCancelar = findViewById(R.id.idEstudiantesFotoUsuarioCancelar);
        nombreUsuario = findViewById(R.id.idPerfilEstudiantesNombreUsuario);
        correoUsuario = findViewById(R.id.idPerfilEstudiantesCorreoUsuario);
        matriculaUsuario= findViewById(R.id.idPerfilEstudiantesMatriculaUsuario);
        fotoUsuario = findViewById(R.id.idPerfilEstudiantesFotoUsuarioCircle);
        btnfotoUsuario = findViewById(R.id.idPerfilEstudiantesFotoUsuario);
        carreraUsuario = findViewById(R.id.idPerfilEstudiantesCarreraUsuario);
        fotoPerfilCadena = "";

        iconoCarrera = findViewById(R.id.idPerfilEstudiantesIconoCarreraUsuario);

        setSupportActionBar(estudiantesToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int Permisos_necesarios = 1;

        String[] Permisos = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if (!tienePermiso(this, Permisos)){
            ActivityCompat.requestPermissions(this, Permisos, Permisos_necesarios);
        }


        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                returnLogin();
            }
        });
        //////////////////////////////////////////////////7

        imagePicker = new ImagePicker(this);
        cameraPicker = new CameraImagePicker(this);

        imagePicker.setImagePickerCallback(new ImagePickerCallback() {
            @Override
            public void onImagesChosen(List<ChosenImage> list) {
                if(!list.isEmpty()){
                    String path = list.get(0).getOriginalPath();
                    fotoPerfilUri = Uri.fromFile(new File(path));
                    headerImagen.setImageURI(fotoPerfilUri);
                    fotoUsuario.setImageURI(fotoPerfilUri);
                }
            }

            @Override
            public void onError(String s) {
                Toast.makeText(EstudiantesPerfil.this, "Error: "+s, Toast.LENGTH_SHORT).show();
            }
        });

        cameraPicker.setImagePickerCallback(new ImagePickerCallback() {
            @Override
            public void onImagesChosen(List<ChosenImage> list) {
                String path = list.get(0).getOriginalPath();
                fotoPerfilUri = Uri.fromFile(new File(path));
                headerImagen.setImageURI(fotoPerfilUri);
                fotoUsuario.setImageURI(fotoPerfilUri);
            }

            @Override
            public void onError(String s) {
                Toast.makeText(EstudiantesPerfil.this, "Error: "+s, Toast.LENGTH_SHORT).show();
            }
        });

        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        fotoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fotoUsuarioAceptar.setVisibility(View.VISIBLE);
                fotoUsuarioCancelar.setVisibility(View.VISIBLE);

                fotoUsuarioAceptar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up));
                fotoUsuarioCancelar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up));


                AlertDialog.Builder dialog = new AlertDialog.Builder(EstudiantesPerfil.this);
                dialog.setTitle("Elige una foto de perfil");

                String[] items = {"Galeria","Camara"};

                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                imagePicker.pickImage();
                                break;
                            case 1:
                                pickerPath = cameraPicker.pickImage();
                                break;
                        }
                    }
                });

                AlertDialog dialogConstruido = dialog.create();
                dialogConstruido.show();

            }
        });

        btnfotoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fotoUsuarioAceptar.setVisibility(View.VISIBLE);
                fotoUsuarioCancelar.setVisibility(View.VISIBLE);

                fotoUsuarioAceptar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up));
                fotoUsuarioCancelar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up));


                AlertDialog.Builder dialog = new AlertDialog.Builder(EstudiantesPerfil.this);
                dialog.setTitle("Elige una foto de perfil");

                String[] items = {"Galeria","Camara"};

                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                imagePicker.pickImage();
                                break;
                            case 1:
                                pickerPath = cameraPicker.pickImage();
                                break;
                        }
                    }
                });

                AlertDialog dialogConstruido = dialog.create();
                dialogConstruido.show();

            }
        });

        fotoUsuarioAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirPerfilFoto();
                fotoUsuarioAceptar.setVisibility(View.GONE);
                fotoUsuarioCancelar.setVisibility(View.GONE);

                fotoUsuarioAceptar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down));
                fotoUsuarioCancelar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down));
            }
        });

        fotoUsuarioCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
                fotoUsuarioAceptar.setVisibility(View.GONE);
                fotoUsuarioCancelar.setVisibility(View.GONE);

                fotoUsuarioAceptar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down));
                fotoUsuarioCancelar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down));
            }
        });


        //verifyStoragePermissions(this);
    }

/*
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
        }else{
            return true;
        }
    }
*/
    public static boolean tienePermiso(Context context, String... permisos){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && context!=null && permisos!=null){
            for(String permiso: permisos){
                if (ActivityCompat.checkSelfPermission(context, permiso)!=PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //////////////

        if(requestCode == Picker.PICK_IMAGE_DEVICE && resultCode == RESULT_OK){
            imagePicker.submit(data);
        }else if(requestCode == Picker.PICK_IMAGE_CAMERA && resultCode == RESULT_OK){
            cameraPicker.reinitialize(pickerPath);
            cameraPicker.submit(data);
        }


        /*else if(requestCode == PHOTO_PERFIL && resultCode == RESULT_OK){
            Uri u = data.getData();
            storageReference = storage.getReference("foto_perfil");//imagenes_chat
            final StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());

            fotoReferencia.putFile(u).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return fotoReferencia.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful()){
                        Uri uri = task.getResult();
                        fotoPerfilCadena = uri.toString();
                        MensajeEnviar m = new MensajeEnviar(NOMBRE_USUARIO+" ha actualizado su foto de perfil",uri.toString(),NOMBRE_USUARIO,fotoPerfilCadena,"2",ServerValue.TIMESTAMP);
                        databaseReference.push().setValue(m);
                        Glide.with(MensajeriaActivitySistemas.this).load(uri.toString()).into(fotoPerfil);
                    }
                }
            });
        }*/
    }


    private void subirPerfilFoto() {

        if (fotoPerfilUri != null) {

            UsuarioDAO.getInstancia().subirFotoUri(fotoPerfilUri, new UsuarioDAO.IDevolverUrlFoto() {
                @Override
                public void devolerUrlString(String url) {
                    Usuario usuario = new Usuario();

                    usuario.setNombre(uNombre);
                    usuario.setCorreo(uCorreo);
                    usuario.setCarrera(uCarrera);
                    usuario.setFechaDeNacimiento(uFecha);
                    usuario.setGenero(uGenero);
                    usuario.setMatricula(uMatricula);

                    usuario.setFotoPerfilURL(url);
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    DatabaseReference reference = database.getReference("Usuarios/" + currentUser.getUid());
                    reference.setValue(usuario);
                }
            });
        } else{
            Usuario usuario = new Usuario();

            usuario.setNombre(uNombre);
            usuario.setCorreo(uCorreo);
            usuario.setCarrera(uCarrera);
            usuario.setFechaDeNacimiento(uFecha);
            usuario.setGenero(uGenero);
            usuario.setMatricula(uMatricula);
            usuario.setFotoPerfilURL(uFotoPerfil);
            FirebaseUser currentUser = mAuth.getCurrentUser();
            DatabaseReference reference = database.getReference("Usuarios/" + currentUser.getUid());
            reference.setValue(usuario);
        }
    }



    @Override
    protected void onStop() {
        super.onStop();

        try {

            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser!=null){
                DatabaseReference reference = database.getReference("Usuarios/"+currentUser.getUid());
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
                        Usuario fecha = dataSnapshot.getValue(Usuario.class);

                        uNombre = usuario.getNombre();
                        uCorreo = correo.getCorreo();
                        uMatricula = matricula.getMatricula();
                        uCarrera = usuario.getCarrera();
                        uGenero = genero.getGenero();
                        uFecha = fecha.getFechaDeNacimiento();
                        uFotoPerfil = perfil.getFotoPerfilURL();

                        assert usuario != null;
                        NOMBRE_USUARIO = usuario.getNombre();
                        nombreUsuario.setText(NOMBRE_USUARIO);
                        textoToolbar.setText(NOMBRE_USUARIO);
                        nombreUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));


                        assert correo != null;
                        CORREO_USUARIO = usuario.getCorreo();
                        correoUsuario.setText(CORREO_USUARIO);
                        correoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));


                        assert matricula != null;
                        MATRICULA_USUARIO = usuario.getMatricula();
                        matriculaUsuario.setText(MATRICULA_USUARIO);
                        matriculaUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        assert carrera != null;
                        CARRERA_USUARIO = carrera.getCarrera();

                        if (CARRERA_USUARIO.equals("ISIC")){
                            carreraUsuario.setText(SISTEMAS);
                            carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                            Glide.with(getApplicationContext()).load(R.drawable.sistemas).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));


                        }

                        else if (CARRERA_USUARIO.equals("IIAL")){
                            carreraUsuario.setText(ALIMENTARIAS);
                            carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                            Glide.with(getApplicationContext()).load(R.drawable.alimentarias).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else if (CARRERA_USUARIO.equals("IFOR")){
                            carreraUsuario.setText(FORESTAL);
                            carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                            Glide.with(getApplicationContext()).load(R.drawable.forestal).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else if (CARRERA_USUARIO.equals("IGEO")){
                            carreraUsuario.setText(GEOCIENCIAS);
                            carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                            Glide.with(getApplicationContext()).load(R.drawable.geocienciaslogo).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else if (CARRERA_USUARIO.equals("IGEM")){
                            carreraUsuario.setText(GESTION);
                            carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                            Glide.with(getApplicationContext()).load(R.drawable.gestionlogo).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else {
                            carreraUsuario.setText(CARRERA_USUARIO);
                            carreraUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                            Glide.with(getApplicationContext()).load(R.drawable.itsvclogo).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                        }

                        assert perfil != null;
                        Glide.with(getApplicationContext()).load(perfil.getFotoPerfilURL()).into(fotoUsuario);
                        Glide.with(getApplicationContext()).load(perfil.getFotoPerfilURL()).into(headerImagen);
                        fotoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                        headerImagen.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));


                        //carreraUsuario.setText(CARRERA_USUARIO);

                        //Snackbar.make(findViewById(R.id.linearMensajeria), CARRERA.toString(), Snackbar.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }else{
                returnLogin();
            }

        } catch (Exception error) {
            Toast.makeText(this, "Error: "+ error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        try {

            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser!=null){
                DatabaseReference reference = database.getReference("Usuarios/"+currentUser.getUid());
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
                        Usuario fecha = dataSnapshot.getValue(Usuario.class);

                        uNombre = usuario.getNombre();
                        uCorreo = correo.getCorreo();
                        uMatricula = matricula.getMatricula();
                        uCarrera = usuario.getCarrera();
                        uGenero = genero.getGenero();
                        uFecha = fecha.getFechaDeNacimiento();
                        uFotoPerfil = perfil.getFotoPerfilURL();

                        assert usuario != null;
                        NOMBRE_USUARIO = usuario.getNombre();
                        nombreUsuario.setText(NOMBRE_USUARIO);
                        textoToolbar.setText(NOMBRE_USUARIO);
                        nombreUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_transition_animation_up));

                        assert correo != null;
                        CORREO_USUARIO = usuario.getCorreo();
                        correoUsuario.setText(CORREO_USUARIO);
                        correoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_transition_animation_up));


                        assert matricula != null;
                        MATRICULA_USUARIO = usuario.getMatricula();
                        matriculaUsuario.setText(MATRICULA_USUARIO);
                        matriculaUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_transition_animation_up));

                        assert carrera != null;
                        CARRERA_USUARIO = carrera.getCarrera();

                        if (CARRERA_USUARIO.equals("ISIC")){
                            carreraUsuario.setText(SISTEMAS);
                            Glide.with(getApplicationContext()).load(R.drawable.sistemas).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));


                        }

                        else if (CARRERA_USUARIO.equals("IIAL")){
                            carreraUsuario.setText(ALIMENTARIAS);
                            Glide.with(getApplicationContext()).load(R.drawable.alimentarias).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else if (CARRERA_USUARIO.equals("IFOR")){
                            carreraUsuario.setText(FORESTAL);
                            Glide.with(getApplicationContext()).load(R.drawable.forestal).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else if (CARRERA_USUARIO.equals("IGEO")){
                            carreraUsuario.setText(GEOCIENCIAS);
                            Glide.with(getApplicationContext()).load(R.drawable.geocienciaslogo).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else if (CARRERA_USUARIO.equals("IGEM")){
                            carreraUsuario.setText(GESTION);
                            Glide.with(getApplicationContext()).load(R.drawable.gestionlogo).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));

                        }

                        else {
                            carreraUsuario.setText(CARRERA_USUARIO);
                            Glide.with(getApplicationContext()).load(R.drawable.itsvclogo).into(iconoCarrera);
                            iconoCarrera.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                        }

                        assert perfil != null;
                        Glide.with(getApplicationContext()).load(perfil.getFotoPerfilURL()).into(fotoUsuario);
                        Glide.with(getApplicationContext()).load(perfil.getFotoPerfilURL()).into(headerImagen);
                        fotoUsuario.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                        headerImagen.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));


                        //carreraUsuario.setText(CARRERA_USUARIO);

                        //Snackbar.make(findViewById(R.id.linearMensajeria), CARRERA.toString(), Snackbar.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }else{
                returnLogin();
            }

        } catch (Exception error) {
            Toast.makeText(this, "Error: "+ error, Toast.LENGTH_SHORT).show();
        }
    }

    private void returnLogin(){
        startActivity(new Intent(EstudiantesPerfil.this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // You have to save path in case your activity is killed.
        // In such a scenario, you will need to re-initialize the CameraImagePicker
        outState.putString("picker_path", pickerPath);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // After Activity recreate, you need to re-intialize these
        // two values to be able to re-intialize CameraImagePicker
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("picker_path")) {
                pickerPath = savedInstanceState.getString("picker_path");
            }
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

}
