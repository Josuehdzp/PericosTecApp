package com.Pericos.ITSVC.App.PantallaMain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.Pericos.ITSVC.App.R;

public class Departamentos extends AppCompatActivity {
    CardView cardProcesos, cardVinculacion, cardExtraescolares;
    RelativeLayout contenedorProcesos, contenedorVinculacion, contenedorExtraescolares;

    CardView cardProcesosInscripcion, cardProcesosCurso, cardProcesosActividades, cardProcesosResidencia, cardProcesosTitulacion;
    CardView cardVinculacionServicio, cardVinculacionResidencia;
    Toolbar departamentostoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departamentos_activity);

        departamentostoolbar = findViewById(R.id.idDepartamentosToolbar);

        cardProcesos = findViewById(R.id.idCardDptoProcesosTitulo);
        cardVinculacion = findViewById(R.id.idCardDptoVinculacionTitulo);
        cardExtraescolares = findViewById(R.id.idCardDptoExtraescolaresTitulo);

        contenedorProcesos = findViewById(R.id.idCardDptoProcesosContenedor);
        contenedorVinculacion = findViewById(R.id.idCardDptoVinculacionContenedor);
        contenedorExtraescolares = findViewById(R.id.idCardDptoExtraescolaresContenedor);


        cardProcesosInscripcion = findViewById(R.id.idCardDptoProcesosInscripcion);
        cardProcesosCurso = findViewById(R.id.idCardDptoProcesosCurso);
        cardProcesosActividades = findViewById(R.id.idCardDptoProcesosActividades);
        cardProcesosResidencia = findViewById(R.id.idCardDptoProcesosResidencia);
        cardProcesosTitulacion = findViewById(R.id.idCardDptoProcesosTitulacion);

        cardVinculacionServicio = findViewById(R.id.idCardDptoVinculacionServicio);
        cardVinculacionResidencia = findViewById(R.id.idCardDptoVinculacionResidencia);


        setSupportActionBar(departamentostoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        cardProcesos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenedorProcesos.getVisibility()==View.GONE){
                    contenedorProcesos.setVisibility(View.VISIBLE);
                    contenedorProcesos.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.popup_flyout_show));
                    cardProcesos.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (contenedorProcesos.getVisibility()==View.VISIBLE) {
                                contenedorProcesos.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out_fast));
                                contenedorProcesos.setVisibility(View.GONE);
                            } else{
                                contenedorProcesos.setVisibility(View.VISIBLE);
                                contenedorProcesos.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.popup_flyout_show));
                            }
                        }
                    });
                }
            }
        });



        cardVinculacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenedorVinculacion.getVisibility()==View.GONE){
                    contenedorVinculacion.setVisibility(View.VISIBLE);
                    contenedorVinculacion.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.popup_flyout_show));
                    cardVinculacion.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (contenedorVinculacion.getVisibility()==View.VISIBLE) {
                                contenedorVinculacion.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out_fast));
                                contenedorVinculacion.setVisibility(View.GONE);
                            } else{
                                contenedorVinculacion.setVisibility(View.VISIBLE);
                                contenedorVinculacion.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.popup_flyout_show));
                            }
                        }
                    });
                }
            }
        });


        cardProcesosInscripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/diagrams/Proceso%20de%20Inscripci%C3%B3n,%20SGI.pdf";
                Intent PInscripcion = new Intent(Intent.ACTION_VIEW);
                PInscripcion.setData(Uri.parse(url));
                startActivity(PInscripcion);
            }
        });

        cardProcesosCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/diagrams/Proceso%20de%20Gesti%C3%B3n%20del%20Curso,%20SGI.pdf";
                Intent PCurso = new Intent(Intent.ACTION_VIEW);
                PCurso.setData(Uri.parse(url));
                startActivity(PCurso);

            }
        });

        cardProcesosActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/diagrams/Proceso%20de%20Actividades%20Complementarias,%20Manual%202015.pdf";
                Intent PActividades = new Intent(Intent.ACTION_VIEW);
                PActividades.setData(Uri.parse(url));
                startActivity(PActividades);

            }
        });

        cardProcesosResidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/diagrams/Residencia%20Profesional,%20Version%201.0.pdf";
                Intent PResidencia = new Intent(Intent.ACTION_VIEW);
                PResidencia.setData(Uri.parse(url));
                startActivity(PResidencia);

            }
        });

        cardProcesosTitulacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/diagrams/Proceso%20de%20Titulaci%C3%B3n,%20version%201.0.pdf";
                Intent PTitulacion = new Intent(Intent.ACTION_VIEW);
                PTitulacion.setData(Uri.parse(url));
                startActivity(PTitulacion);

            }
        });

        cardVinculacionServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/vinculacion_files/FORMATOS%20PARA%20SERVICIO%20SOCIAL.docx";
                Intent VServicio = new Intent(Intent.ACTION_VIEW);
                VServicio.setData(Uri.parse(url));
                startActivity(VServicio);

            }
        });


        cardVinculacionResidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs/vinculacion_files/FORMATOS%20PARA%20RESIDENCIA.docx";
                Intent VResidencia = new Intent(Intent.ACTION_VIEW);
                VResidencia.setData(Uri.parse(url));
                startActivity(VResidencia);

            }
        });



    }
}
