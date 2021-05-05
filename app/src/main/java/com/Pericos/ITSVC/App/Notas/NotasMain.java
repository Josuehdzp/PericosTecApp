package com.Pericos.ITSVC.App.Notas;

import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.Pericos.ITSVC.App.Horarios.DatabaseHelper;
import com.Pericos.ITSVC.App.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class NotasMain extends AppCompatActivity {

    ArrayList<StringsNotas> listaNotasDatos;
    RecyclerView recyclerLayoutPrincipal;
    DatabaseHelper helper;
    FloatingActionButton notasBotonFlotante;
    Toolbar notasToolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas_principal);

        notasBotonFlotante = findViewById(R.id.idNotasFAB);

        notasToolbar = findViewById(R.id.idNotasToolbar);
        setSupportActionBar(notasToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        helper = new DatabaseHelper(getApplicationContext(), "HorarioDos.db", 1);
        try {
            helper.CheckDb();
        }catch (Exception e){
        }
        
        listaNotasDatos = new ArrayList<>();


        recyclerLayoutPrincipal = findViewById(R.id.recyclerNotas);
        recyclerLayoutPrincipal.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerLayoutPrincipal.setHasFixedSize(true);

        consultarListaNotas();

        NotasAdaptadorDeDatos adaptador = new NotasAdaptadorDeDatos(listaNotasDatos);
        recyclerLayoutPrincipal.setAdapter(adaptador);


        notasBotonFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoNotas dialog = new DialogoNotas(); //Create a new Dialog
                //dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

    }

    private void consultarListaNotas() {

        SQLiteDatabase dbNotas = helper.getReadableDatabase();
        StringsNotas notas = null;



        Cursor cursor = dbNotas.rawQuery("SELECT * from Notas", null);
try {

        while (cursor.moveToNext()){
            notas = new StringsNotas();
            notas.setTituloNota(cursor.getString(0));
            notas.setCuerpoNota(cursor.getString(1));
            notas.setFechaNota(cursor.getString(2));
            notas.setHoraNota(cursor.getString(3));
            notas.setColorNota(cursor.getString(4));



            listaNotasDatos.add(notas);
        }

} catch (Exception e) {
    e.printStackTrace();
}

    }

    }
