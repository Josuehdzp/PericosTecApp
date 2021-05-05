package com.Pericos.ITSVC.App.PantallaMain.Tecnologico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.Pericos.ITSVC.App.R;
import com.danimahardhika.cafebar.CafeBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;


public class Normatividad extends AppCompatActivity {

    CardView cardNorm1, cardNorm2,cardNorm3,cardNorm4;
    CardView cardNorm5,cardNorm6,cardNorm7,cardNorm8;
    CardView cardNorm9,cardNorm10,cardNorm11,cardNorm12;
    CardView cardNorm13,cardNorm14,cardNorm15,cardNorm16;
    Toolbar normatividadtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normatividad);

        normatividadtoolbar = findViewById(R.id.idNormatividadToolbar);


        cardNorm1 = findViewById(R.id.cardNorma1);
        cardNorm2 = findViewById(R.id.cardNorma2);
        cardNorm3 = findViewById(R.id.cardNorma3);
        cardNorm4 = findViewById(R.id.cardNorma4);
        cardNorm5 = findViewById(R.id.cardNorma5);
        cardNorm6 = findViewById(R.id.cardNorma6);
        cardNorm7 = findViewById(R.id.cardNorma7);
        cardNorm8 = findViewById(R.id.cardNorma8);
        cardNorm9 = findViewById(R.id.cardNorma9);
        cardNorm10 = findViewById(R.id.cardNorma10);
        cardNorm11 = findViewById(R.id.cardNorma11);
        cardNorm12 = findViewById(R.id.cardNorma12);
        cardNorm13 = findViewById(R.id.cardNorma13);
        cardNorm14 = findViewById(R.id.cardNorma14);
        cardNorm15 = findViewById(R.id.cardNorma15);
        cardNorm16 = findViewById(R.id.cardNorma16);

        setSupportActionBar(normatividadtoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        cardNorm1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/REGLAMENTO_INTERIOR_ITSVC.pdf";
                Intent N1 = new Intent(Intent.ACTION_VIEW);
                N1.setType("application/pdf");
                N1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N1.setData(Uri.parse(url));
                startActivity(N1);
            }
        });

        cardNorm2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Eventos_Deportivos.pdf";
                Intent N2 = new Intent(Intent.ACTION_VIEW);
                N2.setType("application/pdf");
                N2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N2.setData(Uri.parse(url));
                startActivity(N2);
            }
        });

        cardNorm3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Estudiante.pdf";
                Intent N3 = new Intent(Intent.ACTION_VIEW);
                N3.setType("application/pdf");
                N3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N3.setData(Uri.parse(url));
                startActivity(N3);
            }
        });

        cardNorm4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Personal_No_Academico.pdf";
                Intent N4 = new Intent(Intent.ACTION_VIEW);
               N4.setType("application/pdf");
               N4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               N4.setData(Uri.parse(url));
                startActivity(N4);
            }
        });

        cardNorm5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Personal_Academico.pdf";
                Intent N5 = new Intent(Intent.ACTION_VIEW);
                N5.setType("application/pdf");
                N5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N5.setData(Uri.parse(url));
                startActivity(N5);
            }
        });

        cardNorm6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                CafeBar.builder(Normatividad.this)
                        .content("Disponible Proximamente!")
                        .floating(true)
                        .swipeToDismiss(true)
                        .duration(CafeBar.Duration.SHORT)
                        .neutralColor(getResources().getColor(R.color.negroprincipal))
                        .show();


               /* String url = "https://www.itsvc.edu.mx/index.php?p=normatividad#";
                Intent N6 = new Intent(Intent.ACTION_VIEW);
                N6.setType("application/pdf");
                N6.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N6.setData(Uri.parse(url));
                startActivity(N6);*/

        }});

        cardNorm7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Actividades_Extraescolares.pdf";
                Intent N7 = new Intent(Intent.ACTION_VIEW);
                N7.setType("application/pdf");
                N7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N7.setData(Uri.parse(url));
                startActivity(N7);
            }
        });

        cardNorm8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/MODELO%20EDUCATIVO%20PARA%20EL%20SIGLO%20XXI.pdf";
                Intent N8 = new Intent(Intent.ACTION_VIEW);
                N8.setType("application/pdf");
                N8.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N8.setData(Uri.parse(url));
                startActivity(N8);
            }
        });

        cardNorm9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/reglamento%20de%20la%20ley%20de%20adquisiciones,%20arrendamientos%20y%20servicios%20del%20sector%20publico.pdf";
                Intent N9 = new Intent(Intent.ACTION_VIEW);
                N9.setType("application/pdf");
                N9.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N9.setData(Uri.parse(url));
                startActivity(N9);
            }
        });

        cardNorm10.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Manual_Procedimientos_ITSVC_MP_42010101012017.pdf";
                Intent N10 = new Intent(Intent.ACTION_VIEW);
                N10.setType("application/pdf");
                N10.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N10.setData(Uri.parse(url));
                startActivity(N10);
            }
        });

        cardNorm11.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Manual_Organizacion_ITSVC_MO_42010101012017.pdf";
                Intent N11 = new Intent(Intent.ACTION_VIEW);
                N11.setType("application/pdf");
                N11.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N11.setData(Uri.parse(url));
                startActivity(N11);
            }
        });

        cardNorm12.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                CafeBar.builder(Normatividad.this)
                        .content("Disponible Proximamente!")
                        .floating(true)
                        .swipeToDismiss(true)
                        .duration(CafeBar.Duration.SHORT)
                        .neutralColor(getResources().getColor(R.color.negroprincipal))
                        .show();
                /*String url = "https://www.itsvc.edu.mx/index.php?p=normatividad#";
                Intent N12 = new Intent(Intent.ACTION_VIEW);
                N12.setType("application/pdf");
                N12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N12.setData(Uri.parse(url));
                startActivity(N12);*/
            }
        });

        cardNorm13.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                CafeBar.builder(Normatividad.this)
                        .content("Disponible Proximamente!")
                        .floating(true)
                        .swipeToDismiss(true)
                        .duration(CafeBar.Duration.SHORT)
                        .neutralColor(getResources().getColor(R.color.negroprincipal))
                        .show();
                /*String url = "https://www.itsvc.edu.mx/index.php?p=normatividad#";
                Intent N13 = new Intent(Intent.ACTION_VIEW);
                N13.setType("application/pdf");
                N13.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N13.setData(Uri.parse(url));
                startActivity(N13);*/
            }
        });

        cardNorm14.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Laboratorio_Quimica.pdf";
                Intent N14 = new Intent(Intent.ACTION_VIEW);
                N14.setType("application/pdf");
                N14.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N14.setData(Uri.parse(url));
                startActivity(N14);
            }
        });

        cardNorm15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Centro_Informacion.pdf";
                Intent N15 = new Intent(Intent.ACTION_VIEW);
                N15.setType("application/pdf");
                N15.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N15.setData(Uri.parse(url));
                startActivity(N15);
            }
        });

        cardNorm16.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                String url = "https://www.itsvc.edu.mx/content/docs_normativa/Reglamento_Laboratorio_Computo.pdf";
                Intent N16 = new Intent(Intent.ACTION_VIEW);
                N16.setType("application/pdf");
                N16.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                N16.setData(Uri.parse(url));
                startActivity(N16);
            }
        });


    }
}
