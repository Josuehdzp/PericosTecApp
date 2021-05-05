package com.Pericos.ITSVC.App.Chat.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.Pericos.ITSVC.App.BuildConfig;
import com.Pericos.ITSVC.App.IntroEstudiantes;
import com.Pericos.ITSVC.App.PantallaMain.Estudiantes.Estudiantes;
import com.Pericos.ITSVC.App.R;
import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wang.avi.AVLoadingIndicatorView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;


public class LoginActivity extends AppCompatActivity {

    private EditText txtCorreo,txtContraseña;
    private Button btnLogin,btnRegistro;
    private FirebaseAuth mAuth;
    private CheckBox mostrarContraseña;
    private Toolbar loginToolbar;
    private AVLoadingIndicatorView gProgressBarLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_login);

        loginToolbar = findViewById(R.id.idLoginToolbar);
        txtCorreo = findViewById(R.id.idCorreoLogin);
        txtContraseña = findViewById(R.id.idContraseñaLogin);
        btnLogin = findViewById(R.id.idLoginLogin);
        btnRegistro = findViewById(R.id.idRegistroLogin);
        mostrarContraseña = findViewById(R.id.idContraseñaLoginVisible);
        gProgressBarLogin = findViewById(R.id.idLoginProgressBar);

        setSupportActionBar(loginToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int Permisos_necesarios = 1;

        String[] Permisos = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if (!tienePermiso(this, Permisos)){
            ActivityCompat.requestPermissions(this, Permisos, Permisos_necesarios);
        }

////////////Verifica si es la primera vez que se inicia la app/////////////////
        switch(getFirstTimeRun(this)) {
            case 0:
                //Toast.makeText(this, "Es la primera vez!", Toast.LENGTH_SHORT).show();
                // acá haces el intent a tu activity especial
                Intent intento= new Intent(LoginActivity.this, IntroEstudiantes.class);
                startActivity(intento);
                break;
            case 1:
                //Toast.makeText(this, "Ya has iniciado la app alguna vez", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //Toast.makeText(this, "Es una versión nueva", Toast.LENGTH_SHORT).show();
                break;
        }
/////////////////////////////////////////////////////////////////////////////////


        mAuth = FirebaseAuth.getInstance();


        mostrarContraseña.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked) {
                    // mostrar contraseña
                    txtContraseña.setTransformationMethod(PasswordTransformationMethod.getInstance());


                } else {
                    // esconder contraseña
                    txtContraseña.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startProgresAnimacion();

                String correo = txtCorreo.getText().toString();
                if(isValidEmail(correo) && validarContraseña()){
                    String contraseña = txtContraseña.getText().toString();
                    mAuth.signInWithEmailAndPassword(correo, contraseña)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        stopProgresAnimacion();

                                        CafeBar.builder(LoginActivity.this)
                                                .content("Se logeo correctamente.")
                                                .floating(true)
                                                .duration(CafeBar.Duration.MEDIUM)
                                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.verde)))
                                                .show();

                                        nextActivity();
                                    } else {
                                        stopProgresAnimacion();

                                        // If sign in fails, display a message to the user.

                                        CafeBar.builder(LoginActivity.this)
                                                .content("Error, verifica tu correo o contraseña.")
                                                .floating(true)
                                                .duration(CafeBar.Duration.MEDIUM)
                                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.rojo_bajo)))
                                                .show();

                                    }

                                }
                            });
                }else{
                    stopProgresAnimacion();


                    CafeBar.builder(LoginActivity.this)
                            .content("Error, escribe correctamente tu correo o contraseña.")
                            .floating(true)
                            .duration(CafeBar.Duration.MEDIUM)
                            .theme(CafeBarTheme.Custom(getResources().getColor(R.color.rojo_bajo)))
                            .show();
                }
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopProgresAnimacion();

                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });
        //UsuarioDAO.getInstancia().añadirFotoDePerfilALosUsuariosQueNoTienenFoto();
        //verifyStoragePermissions(this);
    }



    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean validarContraseña(){
        String contraseña;
        contraseña = txtContraseña.getText().toString();
        return contraseña.length() >= 6 && contraseña.length() <= 16;
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            nextActivity();
            finish();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void nextActivity(){
        startActivity(new Intent(LoginActivity.this, Estudiantes.class));
        finish();
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

    //Retorna: 0 primera vez / 1 no es primera vez / 2 nueva versión
    public static int getFirstTimeRun(Context contexto) {
        SharedPreferences sp = contexto.getSharedPreferences("MYAPP", 0);
        int result, currentVersionCode = BuildConfig.VERSION_CODE;
        int lastVersionCode = sp.getInt("FIRSTTIMERUN", -1);
        if (lastVersionCode == -1) result = 0; else
            result = (lastVersionCode == currentVersionCode) ? 1 : 2;
        sp.edit().putInt("FIRSTTIMERUN", currentVersionCode).apply();
        return result;
    }

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


    void startProgresAnimacion(){
        gProgressBarLogin.show();

        txtCorreo.setFocusableInTouchMode(false);
        txtContraseña.setFocusableInTouchMode(false);
    }
    void stopProgresAnimacion(){
        gProgressBarLogin.hide();

        txtCorreo.setFocusableInTouchMode(true);
        txtContraseña.setFocusableInTouchMode(true);

    }
}
