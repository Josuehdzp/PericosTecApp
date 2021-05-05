package com.Pericos.ITSVC.App.Horarios;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.Pericos.ITSVC.App.R;
import com.danimahardhika.cafebar.CafeBar;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import yuku.ambilwarna.AmbilWarnaDialog;

public class DialogoHorario extends DialogFragment {

    private HorarioPersonalizado personalizado;

    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";

    //Calendario para obtener fecha & hora
    public final Calendar calendario = Calendar.getInstance();

    //Variables para obtener la hora hora
    final int hora = calendario.get(Calendar.HOUR_OF_DAY);
    final int minuto = calendario.get(Calendar.MINUTE);

    EditText HEntrada, HSalida;
    EditText EMateria;
    EditText EProfesor;
    EditText EAula;
    TextView EColor;
    TextView EColorinvisible;
    CardView Colorcard;
    LinearLayout SeleccionarColor;

    NestedScrollView layoutPicker;
    public int gDefaultColor;

    String tabla;
    String materia;
    String profe;
    String hraE;
    String hraS;
    String aula;
    String colorsote;
    String colorsitoSelect;
    Button btnaceptar, btncancelar;

    HorarioPersonalizado horarioPersonalizado;
    DatabaseHelper myDbHelper;
    SQLiteDatabase dby;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_horario_agregar, null);



        layoutPicker = view.findViewById(R.id.contenedorDialog);
        gDefaultColor = ContextCompat.getColor(getContext(), R.color.colorPrimary);


        myDbHelper = new DatabaseHelper(getContext(), "HorarioDos.db", 1);



        HEntrada = view.findViewById(R.id.ETHoraEntrada);
        HSalida = view.findViewById(R.id.ETHoraSalida);
        EMateria = view.findViewById(R.id.ETMateria);
        EProfesor = view.findViewById(R.id.ETProfesor);
        EAula = view.findViewById(R.id.ETAula);
        EColor = view.findViewById(R.id.ETColor);
        EColorinvisible = view.findViewById(R.id.ETColorInvisible);
        Colorcard = view.findViewById(R.id.CardColorSelec);
        SeleccionarColor = view.findViewById(R.id.LinearColor);
        btnaceptar = view.findViewById(R.id.idDialogoHorarioAceptar);
        btncancelar = view.findViewById(R.id.idDialogoHorarioCancelar);



        // jalar datos de un activity
        Bundle bundle = getArguments();
        tabla = bundle.getString("tabla","");
        materia = bundle.getString("materia","");
        profe= bundle.getString("profesor","");
        hraE= bundle.getString("horaE","");
        hraS= bundle.getString("horaS","");
        aula= bundle.getString("aula","");
        colorsote= bundle.getString("color","");

        //EMateria.setText(Culo);
            ///

        EColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
        Colorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
        EColorinvisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });


        HEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerHoraEntrada();
            }
        });

        HSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerHoraSalida();
            }
        });

        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editar();
                onButtonPushed(getView());
                dismiss();
                CafeBar.builder(getContext())
                        .content("Cambios Guardados ;)")
                        .floating(true)
                        .duration(CafeBar.Duration.SHORT)
                        .neutralColor(getResources().getColor(R.color.negroprincipal))
                        .show();

            }
        });

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoHorario.this.getDialog().cancel();
            }
        });


        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            personalizado = (HorarioPersonalizado) context;
        } catch (Exception e){
            throw new ClassCastException(context.toString() + " Algo no se");
        }
    }

    private void onButtonPushed(View view) {
        personalizado.recreate();
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
                Colorcard.setCardBackgroundColor(gDefaultColor);
                layoutPicker.setBackgroundColor(gDefaultColor);
                EColorinvisible.setText(String.format("#%08x", gDefaultColor));

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
                HEntrada.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }

    private void obtenerHoraSalida(){
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
                HSalida.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }

    private void Editar() {

        dby = myDbHelper.getWritableDatabase();

        try {
            dby.execSQL
                    ("UPDATE "+tabla+" set "+materia+EMateria.getText().toString()+"',"
                    +profe+EProfesor.getText().toString()+"',"
                    +hraE+HEntrada.getText().toString()+"',"
                    +hraS+HSalida.getText().toString()+"',"
                    +aula+EAula.getText().toString()+"',"
                    +colorsote+EColorinvisible.getText().toString()+"'");



        } catch (Exception eMostrar) {
            Toast.makeText(getContext(), eMostrar.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
}