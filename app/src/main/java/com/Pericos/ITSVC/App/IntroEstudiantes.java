package com.Pericos.ITSVC.App;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;


public class IntroEstudiantes extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);


        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorPrimaryDark)
                        .buttonsColor(R.color.colorAccent)
                        .image(R.drawable.pericocontituloyfondo2sombra)
                        .title("Hola! Bienvenido a la sección Estudiantes")
                        .description("Vamos  a empezar, esto sera facil ;)")
                        .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.negroprincipal)
                .buttonsColor(R.color.verdeicono)
                .image(R.drawable.icono_materiales)
                .title("Diferentes funciones")
                .description("En esta seccion encontraras funciones interesantes.")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.cafe)
                .buttonsColor(R.color.rojo_bajo)
                .image(R.drawable.icono_escencial_horario)
                .title("Horario")
                .description("Podras guardar tu actual horario escolar para no olvidar tus clases ;)")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.azulnotas)
                .buttonsColor(R.color.verdeicono)
                .image(R.drawable.icono_escencial_notas_color)
                .title("Notas")
                .description("Crea notas sencillas para no olvidar tus pendientes, podras agregar, editar y borrarlas cuando quieras.")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.startblue)
                .image(R.drawable.icono_escencial_chat)
                .title("Chat institucional")
                .description("Comunicate con tus compañeros de carrera o con cualquier otro alumno registrado en la app.")
                .build());

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.verdeicono)
                        .buttonsColor(R.color.colorPrimaryDark)
                        .possiblePermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                        .neededPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE })
                        .image(R.drawable.icono_escencial_nota)
                        .title("Necesito de tus permisos")
                        .description("Para poder acceder a estas funciones, es necesario que concedas algunos permisos.")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Gracias!");
                    }
                }, "Listo!"));

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.negroprincipal)
                .buttonsColor(R.color.colorPrimary)
                .image(R.drawable.icono_correccion)
                .title("Esos es todo")
                .description("Ahora solo completa tu registro o inicia sesión")
                .build());
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Termina la demostracion :)", Toast.LENGTH_SHORT).show();
        recreate();
    }

    @Override
    public void onFinish() {
        super.onFinish();
        finish();

    }
}
