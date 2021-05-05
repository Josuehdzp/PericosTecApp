package com.Pericos.ITSVC.App.Chat.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Chat.Adaptadores.MensajeriaAdaptador;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Mensaje;
import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Usuario;
import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LMensaje;
import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LUsuario;
import com.Pericos.ITSVC.App.Chat.Notificaciones.Datos;
import com.Pericos.ITSVC.App.Chat.Notificaciones.Sender;
import com.Pericos.ITSVC.App.Chat.Notificaciones.Token;
import com.Pericos.ITSVC.App.Chat.Persistencia.MensajeriaDAO_ISIC;
import com.Pericos.ITSVC.App.Chat.Persistencia.UsuarioDAO;
import com.Pericos.ITSVC.App.Chat.Utilidades.Constantes;
import com.Pericos.ITSVC.App.R;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarGravity;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.kbeanie.multipicker.api.CameraImagePicker;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.Picker;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;


public class MensajeriaActivityIndividual extends AppCompatActivity {

    private CircleImageView fotoPerfilReceptor;
    private CircleImageView fotoPerfilEmisor;
    private TextView nombreReceptor;
    private TextView nombreEmisor;
    private TextView carreraEstado;
    private RecyclerView rvMensajes;
    private RelativeLayout entradaMensaje;
    private EditText txtMensaje;
    private FloatingActionButton btnEnviar;
    private MensajeriaAdaptador adapter;
    private ImageButton btnEnviarFoto;
    private ImageView restriccion;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private static final int PHOTO_SEND = 1;
    private static final int PHOTO_PERFIL = 2;
    private String fotoPerfilCadena;
    private Uri fotoPerfilUri;

    private ImagePicker imagePicker;
    private CameraImagePicker cameraPicker;


    private String pickerPath;
    private long fechaDeNacimiento;


    private FirebaseAuth mAuth;
    private String NOMBRE_USUARIO;
    private DatabaseReference CARRERA;
    private String CARRERITAS;

    public String uNombre;
    public String uCorreo;
    public String uMatricula;
    public String uCarrera;
    public long uFecha ;
    public String uGenero;
    public String uFotoPerfil;
    private String KEY_USUARIO;
    private String KEY_RECEPTOR;
    private String hisUID;
    private String NOMBRE_RECEPTOR;
    private String CARRERA_RECEPTOR;
    private String FOTO_RECEPTOR;
    private String COREO_RECEPTOR;
    private String MATRICULA_RECEPTOR;
    private String GENERO_RECEPTOR;

    String USER;

    Toolbar mensajeriaToolbar;
    private AVLoadingIndicatorView gProgressBar;

    String mUID; //Notificaciones

    private RequestQueue requestQueue; //Notificaciones||Usar volley para queue de notificaciones
    private boolean notify = false;//Notificaciones


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_mensajeria_individual);

        Intent intentNotificacion = getIntent();//Notificaciones
        KEY_USUARIO = intentNotificacion.getStringExtra("key_usuario");//Notificaciones
        KEY_RECEPTOR= intentNotificacion.getStringExtra("hisUID");//Notificaciones

        Bundle bundle = getIntent().getExtras();
        KEY_USUARIO = bundle.getString("key_usuario");
        KEY_RECEPTOR= bundle.getString("hisUID");//Notificaciones


        NOMBRE_RECEPTOR = bundle.getString("nombre_usuario");
        CARRERA_RECEPTOR = bundle.getString("carrera_usuario");
        FOTO_RECEPTOR = bundle.getString("foto_usuario");
        COREO_RECEPTOR = bundle.getString("correo_usuario");
        MATRICULA_RECEPTOR = bundle.getString("matricula_usuario");
        GENERO_RECEPTOR = bundle.getString("genero_usuario");



        if (bundle != null){
            KEY_RECEPTOR = bundle.getString("key_receptor");
        }else {
            finish();
        }

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        mensajeriaToolbar = findViewById(R.id.idMensajeriaToolbar);
        setSupportActionBar(mensajeriaToolbar);

        fotoPerfilEmisor = findViewById(R.id.fotoPerfilEmisor);
        fotoPerfilReceptor = findViewById(R.id.fotoPerfilReceptor);
        nombreEmisor = findViewById(R.id.nombreEmisor);
        nombreReceptor = findViewById(R.id.nombreReceptor);
        carreraEstado = findViewById(R.id.idMensajeriaCarreraEstado);
        rvMensajes = findViewById(R.id.rvMensajes);
        entradaMensaje = findViewById(R.id.idMensajeriaEntrada);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviarFoto = findViewById(R.id.btnEnviarFoto);
        restriccion = findViewById(R.id.imgRestrccion);
        fotoPerfilCadena = "";
        gProgressBar = findViewById(R.id.idMensajeriaProgressBar);

        restriccion.setVisibility(View.GONE);
        nombreReceptor.setText(NOMBRE_RECEPTOR);
        carreraEstado.setText("Chat de : "+NOMBRE_RECEPTOR);
        Glide.with(getApplicationContext()).load(FOTO_RECEPTOR).into(fotoPerfilReceptor);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(Constantes.NODO_MENSAJES_INDIVIDUALES)
                .child(UsuarioDAO.getInstancia().getKeyUsuario()+"/"+UsuarioDAO.getInstancia().getKeyUsuario()+"/"+KEY_RECEPTOR);//Sala de chat (nombre) version 2

        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser userNotify = mAuth.getCurrentUser();
        USER = userNotify.getUid();
        SharedPreferences sp = getSharedPreferences("SP_USER", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Current_USERID",USER);
        editor.apply();



        adapter = new MensajeriaAdaptador(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        l.setStackFromEnd(true);
        rvMensajes.setHasFixedSize(true);
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapter);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notify = true;//Notificaciones

                final String mensajeEnviar = txtMensaje.getText().toString().trim();
                if(!mensajeEnviar.isEmpty()){
                    Mensaje mensaje = new Mensaje();
                    mensaje.setMensaje(mensajeEnviar);
                    mensaje.setContieneFoto(false);
                    mensaje.setKeyEmisor(UsuarioDAO.getInstancia().getKeyUsuario());
                    MensajeriaDAO_ISIC.getInstance().nuevoMenaje(UsuarioDAO.getInstancia().getKeyUsuario(),KEY_RECEPTOR,mensaje);
                    //databaseReference.push().setValue(mensaje);
                    txtMensaje.setText("");

                    final DatabaseReference database = FirebaseDatabase.getInstance().getReference(Constantes.NODO_USUARIOS).child(KEY_USUARIO);
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Usuario user = dataSnapshot.getValue(Usuario.class);

                            if (notify){
                                sendNotification(KEY_RECEPTOR, Objects.requireNonNull(user).getNombre(),mensajeEnviar);
                            }
                            notify = false;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });


        btnEnviarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto"),PHOTO_SEND);
            }
        });

        fotoPerfilReceptor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        FirebaseDatabase
                .getInstance()
                .getReference(Constantes.NODO_MENSAJES_INDIVIDUALES)
                .child(UsuarioDAO.getInstancia().getKeyUsuario())
                .child(KEY_RECEPTOR)
                .addChildEventListener(new ChildEventListener() {

            //traer la informacion del usuario
            //guardamos la informacion del usuario en una lista temporal
            //obtenemos la informacion guardada  por la llave
            Map<String, LUsuario> mapUsuariosTemporales = new HashMap<>();

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
                final LMensaje lMensaje = new LMensaje(dataSnapshot.getKey(),mensaje);
                final int posicion = adapter.addMensaje(lMensaje);

                if(mapUsuariosTemporales.get(mensaje.getKeyEmisor())!=null){
                    lMensaje.setlUsuario(mapUsuariosTemporales.get(mensaje.getKeyEmisor()));
                    adapter.actualizarMensaje(posicion,lMensaje);
                }else{
                    UsuarioDAO.getInstancia().obtenerInformacionDeUsuarioPorLLave(mensaje.getKeyEmisor(), new UsuarioDAO.IDevolverUsuario() {
                        @Override
                        public void devolverUsuario(LUsuario lUsuario) {
                            mapUsuariosTemporales.put(mensaje.getKeyEmisor(),lUsuario);
                            lMensaje.setlUsuario(lUsuario);
                            adapter.actualizarMensaje(posicion,lMensaje);
                        }

                        @Override
                        public void devolverError(String error) {
                            Toast.makeText(MensajeriaActivityIndividual.this, "Error: "+error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        verifyStoragePermissions(this);
        updateToken(FirebaseInstanceId.getInstance().getToken());//Notificaciones
    }

    private void sendNotification(final String KEY_RECEPTOR, final String nombre, final String mensajeEnviar) {
        DatabaseReference allTokens = FirebaseDatabase.getInstance().getReference(Constantes.NODO_TOKENS);
        Query query = allTokens.orderByKey().equalTo(KEY_RECEPTOR);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    Token token = ds.getValue(Token.class);
                    Datos datos = new Datos(USER, nombre+": "+mensajeEnviar,"Nuevo Mensaje", KEY_RECEPTOR, R.drawable.icono_itsvc_nice);

                    Sender sender = new Sender(datos, token.getToken());
                    // fcm json object request
                    try {
                        JSONObject senderJsonObj = new JSONObject(new Gson().toJson(sender));
                        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://fcm.googleapis.com/fcm/send", senderJsonObj,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        //response of the request
                                        Log.d("JSON_RESONSE","onResponse: Se pudo "+response.toString());

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("JSON_RESONSE","onResponse: No se pudo "+error.toString());

                            }
                        }){
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                //poner parametros
                              Map<String, String> headers = new HashMap<>();
                              headers.put("Content-Type", "application/json");
                              headers.put("Authorization","key=AAAAt3s4wJ4:APA91bEJwpo8DDoXliRzPjYUFWJqi_TRYjURGW6KB0md48pTnzZUKg1_r8wVs0CZWjcaUcG_wzFQ7l84Cq8UGlOkOjjs228J9x9dDdjBmwECn1v6vpVU6iPciW52jnwIegsr_MAyTNxz");

                              return headers;
                            }
                        };

                        //agregar esta request al queue
                        requestQueue.add(jsonObjectRequest);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setScrollbar(){
        rvMensajes.scrollToPosition(adapter.getItemCount()-1);
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
        }else{
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == PHOTO_SEND && resultCode == RESULT_OK){
            startProgresAnimacion();
            CafeBar.builder(MensajeriaActivityIndividual.this)
                    .content("Tu imagen se esta cargando")
                    .swipeToDismiss(true)
                    .floating(true)
                    .duration(CafeBar.Duration.SHORT)
                    .theme(CafeBarTheme.Custom(getResources().getColor(R.color.verde)))
                    .show();

            Uri u = data.getData();
            storageReference = storage.getReference("imagenes_chat_"+Constantes.NODO_MENSAJES_INDIVIDUALES+"/"+UsuarioDAO.getInstancia().getKeyUsuario());//imagenes_chat
            final StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());
            fotoReferencia.putFile(u).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        stopProgresAnimacion();
                        CafeBar.builder(MensajeriaActivityIndividual.this)
                                .content("Tu imagen no se cargo :(")
                                .swipeToDismiss(true)
                                .floating(true)
                                .duration(CafeBar.Duration.SHORT)
                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.rojo_bajo)))
                                .show();
                        throw task.getException();
                    }
                    return fotoReferencia.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful()){
                        stopProgresAnimacion();
                        CafeBar.builder(MensajeriaActivityIndividual.this)
                                .content("Se envio tu imagen ;)")
                                .swipeToDismiss(true)
                                .floating(true)
                                .duration(CafeBar.Duration.SHORT)
                                .gravity(CafeBarGravity.CENTER)
                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.verde)))
                                .show();

                        Uri uri = task.getResult();
                        Mensaje mensaje = new Mensaje();
                        mensaje.setMensaje(NOMBRE_USUARIO+" ha enviado una foto");
                        mensaje.setUrlFoto(uri.toString());
                        mensaje.setContieneFoto(true);
                        mensaje.setKeyEmisor(UsuarioDAO.getInstancia().getKeyUsuario());
                        //databaseReference.push().setValue(mensaje);
                        MensajeriaDAO_ISIC.getInstance().nuevoMenaje(UsuarioDAO.getInstancia().getKeyUsuario(),KEY_RECEPTOR,mensaje);

                    }
                }
            });
        } else {
            stopProgresAnimacion();
        }

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

/*
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
*/


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){

            btnEnviar.setEnabled(false);

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
                    uCarrera = carrera.getCarrera();
                    uGenero = genero.getGenero();
                    uFecha = fecha.getFechaDeNacimiento();
                    uFotoPerfil = perfil.getFotoPerfilURL();

                    assert usuario != null;
                    NOMBRE_USUARIO = usuario.getNombre();
                    nombreEmisor.setText(NOMBRE_USUARIO);
                    assert perfil != null;
                    Glide.with(getApplicationContext()).load(uFotoPerfil).into(fotoPerfilEmisor);
                    assert carrera != null;
                    CARRERA = database.getReference("Mensajes/"+carrera.getCarrera());
                    CARRERITAS = carrera.getCarrera();
                    //Snackbar.make(findViewById(R.id.linearMensajeria), CARRERA.toString(), Snackbar.LENGTH_LONG).show();

                    btnEnviar.setEnabled(true);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }else{
            returnLogin();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){


            btnEnviar.setEnabled(false);

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
                    uCarrera = carrera.getCarrera();
                    uGenero = genero.getGenero();
                    uFecha = fecha.getFechaDeNacimiento();
                    uFotoPerfil = perfil.getFotoPerfilURL();

                    assert usuario != null;
                    NOMBRE_USUARIO = usuario.getNombre();
                    nombreEmisor.setText(NOMBRE_USUARIO);
                    assert perfil != null;
                    Glide.with(getApplicationContext()).load(uFotoPerfil).into(fotoPerfilEmisor);
                    assert carrera != null;
                    CARRERA = database.getReference("Mensajes/"+carrera.getCarrera());
                    CARRERITAS = carrera.getCarrera();
                    //Snackbar.make(findViewById(R.id.linearMensajeria), CARRERA.toString(), Snackbar.LENGTH_LONG).show();

                    btnEnviar.setEnabled(true);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }else{
            returnLogin();
        }
    }

    private void updateToken(String token){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constantes.NODO_TOKENS);
        Token mToken = new Token(token);
        ref.child(USER).setValue(mToken);
    }


    private void returnLogin(){
        startActivity(new Intent(MensajeriaActivityIndividual.this, LoginActivity.class));
        finish();
    }

    void startProgresAnimacion(){
        gProgressBar.show();
    }
    void stopProgresAnimacion(){
        gProgressBar.hide();
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
