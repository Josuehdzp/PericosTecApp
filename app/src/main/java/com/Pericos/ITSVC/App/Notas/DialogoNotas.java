package com.Pericos.ITSVC.App.Notas;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import yuku.ambilwarna.AmbilWarnaDialog;

public class DialogoNotas extends DialogFragment {

    private NotasMain notasMain;

    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private long fechaNota;


    //Calendario para obtener fecha & hora
    public final Calendar calendario = Calendar.getInstance();

    //Variables para obtener la hora hora
    final int hora = calendario.get(Calendar.HOUR_OF_DAY);
    final int minuto = calendario.get(Calendar.MINUTE);

    EditText ETAgregarTitulo;
    EditText ETAgregarCuerpo;
    EditText ETAgregarFecha;
    EditText ETAgregarHora;
    CardView ETAgregarColor;
    CardView fondoAgregarColorCompleto;
    Button fabGuardar, fabCancelar;
    TextView colorInvisible;

    NestedScrollView layoutVista;
    public int gDefaultColor;

    String colorsitoSelect;

    DatabaseHelper myDbHelper;
    SQLiteDatabase dby;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.notas_dialog_agregar, null);

        layoutVista = view.findViewById(R.id.dialogoAgregarNotas);
        gDefaultColor = ContextCompat.getColor(getContext(), R.color.colorPrimary);

        myDbHelper = new DatabaseHelper(getContext(), "HorarioDos.db", 1);

        ETAgregarTitulo = view.findViewById(R.id.idAgregaretTitulo);
        ETAgregarCuerpo = view.findViewById(R.id.idAgregaretCuerpo);
        ETAgregarFecha = view.findViewById(R.id.idAgregaretFecha);
        ETAgregarHora = view.findViewById(R.id.idAgregaretHora);
        ETAgregarColor = view.findViewById(R.id.idAgregaretColor);
        fabGuardar = view.findViewById(R.id.idAgregarfabAceptar);
        fabCancelar = view.findViewById(R.id.idAgregarfabCancelar);
        colorInvisible = view.findViewById(R.id.idAgregartxtColorInvisible);
        fondoAgregarColorCompleto = view.findViewById(R.id.idAgregarLayoutPrincipal);

        colorInvisible.setText("#016A6D");

            // jalar datos de un activity
        /*Bundle bundle = getArguments();
        tabla = bundle.getString("tabla","");
        materia = bundle.getString("materia","");
        profe= bundle.getString("profesor","");
        hraE= bundle.getString("horaE","");
        hraS= bundle.getString("horaS","");
        aula= bundle.getString("aula","");
        colorsote= bundle.getString("color","");*/



        ETAgregarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });

        ETAgregarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerHoraEntrada();
            }
        });

        ETAgregarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha();
            }
        });

        fabGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CafeBar.builder(getContext())
                        .content("Nota guardada")
                        .swipeToDismiss(true)
                        .floating(true)
                        .duration(CafeBar.Duration.SHORT)
                        .theme(CafeBarTheme.Custom(getResources().getColor(R.color.verdeicono)))
                        .show();
                EditarNota();
                onButtonPushed(getView());
                dismiss();
            }
        });

        fabCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CafeBar.builder(getContext())
                        .content("Nota descartada")
                        .swipeToDismiss(true)
                        .floating(true)
                        .duration(CafeBar.Duration.SHORT)
                        .theme(CafeBarTheme.Custom(getResources().getColor(R.color.rojo_bajo)))
                        .show();
                dismiss();
            }
        });


        builder.setView(view);
        return builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            notasMain = (NotasMain) context;
        } catch (Exception e){
            throw new ClassCastException(context.toString() + " Algo no se");
        }
    }

    private void onButtonPushed(View view) {

        notasMain.recreate();
        //Toast.makeText(personalizado, "recreado", Toast.LENGTH_SHORT).show();
    }

    private void openColorPicker(){

        AmbilWarnaDialog coloPicker = new AmbilWarnaDialog(getContext(), gDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                gDefaultColor = color;
                //layoutPicker.setBackgroundColor(gDefaultColor);
                colorsitoSelect= String.valueOf(gDefaultColor);
                //Toast.makeText(getContext(), String.format("#%08x", gDefaultColor), Toast.LENGTH_SHORT).show();
                ETAgregarColor.setCardBackgroundColor(gDefaultColor);
                colorInvisible.setText(String.format("#%08x", gDefaultColor));
                layoutVista.setBackgroundColor(gDefaultColor);
                fondoAgregarColorCompleto.setCardBackgroundColor(gDefaultColor);

            }
        });
        coloPicker.show();
    }

    private void obtenerHoraEntrada(){
        TimePickerDialog recogerHora = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
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
                ETAgregarHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }

    private void obtenerFecha(){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
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
                ETAgregarFecha.setText(fechaDeNacimientoTexto);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void EditarNota() {

        dby = myDbHelper.getWritableDatabase();

        try {

            dby.execSQL
                    ("INSERT INTO Notas (TituloNota, CuerpoNota, FechaNota, HoraNota, FondoNota) VALUES ('"+ETAgregarTitulo.getText().toString()+"', '"+ETAgregarCuerpo.getText().toString()+"', '"+ETAgregarFecha.getText().toString()+"', '"+ETAgregarHora.getText().toString()+"', '"+colorInvisible.getText().toString()+"')");

        } catch (Exception eMostrar) {
            Toast.makeText(getContext(), eMostrar.getMessage(), Toast.LENGTH_LONG).show();

        }
    }




}


