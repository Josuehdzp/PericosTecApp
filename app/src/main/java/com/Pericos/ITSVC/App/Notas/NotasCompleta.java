package com.Pericos.ITSVC.App.Notas;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Horarios.DatabaseHelper;
import com.Pericos.ITSVC.App.R;
import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarTheme;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import yuku.ambilwarna.AmbilWarnaDialog;

public class NotasCompleta extends AppCompatActivity {

    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private long fechaNota;


    //Calendario para obtener fecha & hora
    public final Calendar calendario = Calendar.getInstance();

    //Variables para obtener la hora hora
    final int hora = calendario.get(Calendar.HOUR_OF_DAY);
    final int minuto = calendario.get(Calendar.MINUTE);
    public int gDefaultColor;

    private NotasMain notasMain;

    DatabaseHelper myDbHelper;
    SQLiteDatabase dby;

    String colorsitoSelect;
    TextView colorInvisible;
    TextView tvTitulo, tvCuerpo, tvFecha, tvHora, tvColor;
    EditText etTitulo, etCuerpo, etFecha, etHora;
    CardView etColor;
    CardView fondoDeNotas;
    Button botonAceptar, botonCancelar;
    Button botonEditar, botonBorrar;
    NestedScrollView layoutCompleto;
    LinearLayout layoutLinear;
    String stitulo;
    String scuerpo;
    String sfecha;
    String shora;
    String scolor;

    Toolbar notaCompletatoolbar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas_completa);

        notaCompletatoolbar = findViewById(R.id.idNotasCompletaToolbar);

        setSupportActionBar(notaCompletatoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvTitulo= findViewById(R.id.idCompNotasTitulo);
        tvCuerpo= findViewById(R.id.idCompNotasCuerpo);
        tvFecha= findViewById(R.id.idCompNotasFecha);
        tvHora = findViewById(R.id.idCompNotasHora);
        tvColor= findViewById(R.id.idCompNotasColor);


        etTitulo = findViewById(R.id.idCompEditNotasTitulo);
        etCuerpo = findViewById(R.id.idCompEditNotasCuerpo);
        etFecha = findViewById(R.id.idCompEditNotasFecha);
        etHora = findViewById(R.id.idCompEditNotasHora);
        etColor = findViewById(R.id.idCompEditNotasColor);
        colorInvisible = findViewById(R.id.idCompNotasColorInvisible);
        fondoDeNotas = findViewById(R.id.idCompNotasContenedor);

        botonAceptar = findViewById(R.id.idCompAgregarfabAceptar);
        botonCancelar = findViewById(R.id.idCompAgregarfabCancelar);
        botonEditar = findViewById(R.id.idCompEditNotasBotonEditar);
        botonBorrar = findViewById(R.id.idCompEditNotasBotonBorras);
        layoutCompleto = findViewById(R.id.idLayoutPadreFondoNotasCompleta);
        layoutLinear = findViewById(R.id.layoutNotasCompletaLinear);

        myDbHelper = new DatabaseHelper(this, "HorarioDos.db", 1);

        final Intent intent = getIntent();
        final String nTitulo = intent.getStringExtra(NotasAdaptadorDeDatos.TITULO);
        final String nCuerpo = intent.getStringExtra(NotasAdaptadorDeDatos.CUERPO);
        final String nFecha = intent.getStringExtra(NotasAdaptadorDeDatos.FECHA);
        final String nHora = intent.getStringExtra(NotasAdaptadorDeDatos.HORA);
        final String nColor = intent.getStringExtra(NotasAdaptadorDeDatos.COLOR);

        etTitulo.setText(nTitulo);
        etCuerpo.setText(nCuerpo);
        etFecha.setText(nFecha);
        etHora.setText(nHora);

        colorInvisible.setText("#016A6D");
        fondoDeNotas.setCardBackgroundColor(Color.parseColor(nColor));
        layoutCompleto.setBackgroundColor(Color.parseColor(nColor));
        layoutLinear.setBackgroundColor(Color.parseColor(nColor));

        stitulo = nTitulo;
        scuerpo = nCuerpo;
        sfecha = nFecha;
        shora = nHora;
        scolor = nColor;
        /// declaracion de los valores al iniciar

        tvTitulo.setVisibility(View.INVISIBLE);
        tvCuerpo.setVisibility(View.INVISIBLE);
        tvFecha.setVisibility(View.INVISIBLE);
        tvHora.setVisibility(View.INVISIBLE);
        tvColor.setVisibility(View.INVISIBLE);

        etTitulo.setFocusableInTouchMode(false);
        etCuerpo.setFocusableInTouchMode(false);
        etFecha.setFocusableInTouchMode(false);
        etHora.setFocusableInTouchMode(false);
        etColor.setFocusableInTouchMode(false);

        botonAceptar.setVisibility(View.GONE);
        botonCancelar.setVisibility(View.GONE);


        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTitulo.setVisibility(View.VISIBLE);
                tvCuerpo.setVisibility(View.VISIBLE);
                tvFecha.setVisibility(View.VISIBLE);
                tvHora.setVisibility(View.VISIBLE);
                tvColor.setVisibility(View.VISIBLE);


                etTitulo.setFocusableInTouchMode(true);
                etCuerpo.setFocusableInTouchMode(true);
                etFecha.setFocusableInTouchMode(false);
                etHora.setFocusableInTouchMode(false);
                etColor.setFocusableInTouchMode(true);

                botonAceptar.setVisibility(View.VISIBLE);
                botonCancelar.setVisibility(View.VISIBLE);

                botonEditar.setVisibility(View.GONE);
                botonBorrar.setVisibility(View.GONE);

                etFecha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        obtenerFechaNotas();
                    }
                });

                etHora.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        obtenerHoraNotas();
                    }
                });

                etColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        obtenerColorNotas();
                    }
                });

                botonAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditarNotaCompleta();
                        finish();
                        Intent regreso = new Intent(NotasCompleta.this, NotasMain.class);
                        startActivity(regreso);
                        CafeBar.builder(NotasCompleta.this)
                                .content("Cambios guardados")
                                .swipeToDismiss(true)
                                .floating(true)
                                .duration(CafeBar.Duration.SHORT)
                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.verdeicono)))
                                .show();
                    }
                });

                botonCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        Intent regreso = new Intent(NotasCompleta.this, NotasMain.class);
                        startActivity(regreso);
                        CafeBar.builder(NotasCompleta.this)
                                .content("Cambios descartados")
                                .swipeToDismiss(true)
                                .floating(true)
                                .duration(CafeBar.Duration.SHORT)
                                .theme(CafeBarTheme.Custom(getResources().getColor(R.color.negroprincipal)))
                                .show();
                    }
                });
            }
        });

        ////BOTON BORRAR
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(NotasCompleta.this);
                dialog.setMessage("¿Quieres eliminar esta nota?")
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                BorrarNotaCompleta();
                                finish();
                                Intent regreso = new Intent(NotasCompleta.this, NotasMain.class);
                                startActivity(regreso);

                                CafeBar.builder(NotasCompleta.this)
                                        .content("Nota eliminada")
                                        .swipeToDismiss(true)
                                        .floating(true)
                                        .duration(CafeBar.Duration.SHORT)
                                        .theme(CafeBarTheme.Custom(getResources().getColor(R.color.rojo_bajo)))
                                        .show();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
               dialog.show();
            }
        });

        ///////////////////////////
        etColor.setCardBackgroundColor(Color.parseColor(nColor));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent regreso = new Intent(NotasCompleta.this, NotasMain.class);
        startActivity(regreso);

    }

    public void obtenerColorNotas(){

        AmbilWarnaDialog coloPicker = new AmbilWarnaDialog(this, gDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                gDefaultColor = color;
                //layoutPicker.setBackgroundColor(gDefaultColor);
                colorsitoSelect= String.valueOf(gDefaultColor);
                //Toast.makeText(getContext(), String.format("#%08x", gDefaultColor), Toast.LENGTH_SHORT).show();
                etColor.setCardBackgroundColor(gDefaultColor);
                colorInvisible.setText(String.format("#%08x", gDefaultColor));
                layoutCompleto.setBackgroundColor(gDefaultColor);
                layoutLinear.setBackgroundColor(gDefaultColor);
                fondoDeNotas.setCardBackgroundColor(gDefaultColor);

            }
        });
        coloPicker.show();
    }

    private void obtenerHoraNotas(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                int horaFormateada = Integer.parseInt((hourOfDay < 10)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay));
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM = "AM";

                if (hourOfDay == 0) {
                    horaFormateada += 12;
                    AM_PM = "AM";
                }
                else if (hourOfDay == 12) {
                    AM_PM = "PM";
                }   else if (hourOfDay > 12) {
                    horaFormateada -= 12;
                    AM_PM = "PM";

                }
                //Muestro la hora con el formato deseado
                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }

    private void obtenerFechaNotas(){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                Calendar calendarResultado = Calendar.getInstance();
                calendarResultado.set(Calendar.YEAR,year);
                calendarResultado.set(Calendar.MONTH,mes);
                calendarResultado.set(Calendar.DAY_OF_MONTH,dia);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date date = calendarResultado.getTime();
                String fechaDeNacimientoTexto = simpleDateFormat.format(date);
                fechaNota = date.getTime();
                etFecha.setText(fechaDeNacimientoTexto);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void EditarNotaCompleta() {

        dby = myDbHelper.getWritableDatabase();

        try {
//Editar la base de datos de notas, usando los datos originales
            dby.execSQL
                    ("UPDATE Notas set TituloNota='"+etTitulo.getText().toString()+"',CuerpoNota='"+etCuerpo.getText().toString()+"'," +"FechaNota='"+etFecha.getText().toString()+"'," + "HoraNota='"+etHora.getText().toString()+"'," + "FondoNota='"+colorInvisible.getText().toString()+"' WHERE TituloNota='"+stitulo+"' AND FondoNota='"+scolor+"'");


        } catch (Exception eMostrar) {
            Toast.makeText(this, eMostrar.getMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public void BorrarNotaCompleta() {

        dby = myDbHelper.getWritableDatabase();

        try {
//Editar la base de datos de notas, usando los datos originales
            dby.execSQL
                    ("DELETE FROM Notas WHERE TituloNota='"+stitulo+"' AND FondoNota='"+scolor+"'");


        } catch (Exception eMostrar) {
            Toast.makeText(this, eMostrar.getMessage(), Toast.LENGTH_LONG).show();

        }
    }


}
