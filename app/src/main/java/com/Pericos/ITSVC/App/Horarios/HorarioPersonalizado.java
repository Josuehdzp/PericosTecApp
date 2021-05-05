package com.Pericos.ITSVC.App.Horarios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Pericos.ITSVC.App.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HorarioPersonalizado extends AppCompatActivity {

public LinearLayout mContenedorHorario;

    public LinearLayout linelunes, linemartes, linemiercoles, linejueves, lineviernes, linesabado;
    public LinearLayout linelunes2, linemartes2, linemiercoles2, linejueves2, lineviernes2, linesabado2;
    public LinearLayout linelunes3, linemartes3, linemiercoles3, linejueves3, lineviernes3, linesabado3;
    public LinearLayout linelunes4, linemartes4, linemiercoles4, linejueves4, lineviernes4, linesabado4;
    public LinearLayout linelunes5, linemartes5, linemiercoles5, linejueves5, lineviernes5, linesabado5;
    public LinearLayout linelunes6, linemartes6, linemiercoles6, linejueves6, lineviernes6, linesabado6;
    public LinearLayout linelunes7, linemartes7, linemiercoles7, linejueves7, lineviernes7, linesabado7;
    public LinearLayout linelunes8, linemartes8, linemiercoles8, linejueves8, lineviernes8, linesabado8;

    public TextView mLunMateria,mLunProfe,mLunHrE,mLunHrS,mLunAula, mLunColor;
    public TextView mLunMateria2,mLunProfe2,mLunHrE2,mLunHrS2,mLunAula2, mLunColor2;
    public TextView mLunMateria3,mLunProfe3,mLunHrE3,mLunHrS3,mLunAula3, mLunColor3;
    public TextView mLunMateria4,mLunProfe4,mLunHrE4,mLunHrS4,mLunAula4, mLunColor4;
    public TextView mLunMateria5,mLunProfe5,mLunHrE5,mLunHrS5,mLunAula5, mLunColor5;
    public TextView mLunMateria6,mLunProfe6,mLunHrE6,mLunHrS6,mLunAula6, mLunColor6;
    public TextView mLunMateria7,mLunProfe7,mLunHrE7,mLunHrS7,mLunAula7, mLunColor7;
    public TextView mLunMateria8,mLunProfe8,mLunHrE8,mLunHrS8,mLunAula8, mLunColor8;

    public TextView mMarMateria,mMarProfe,mMarHrE,mMarHrS,mMarAula,mMarColor;
    public TextView mMarMateria2,mMarProfe2,mMarHrE2,mMarHrS2,mMarAula2,mMarColor2;
    public TextView mMarMateria3,mMarProfe3,mMarHrE3,mMarHrS3,mMarAula3,mMarColor3;
    public TextView mMarMateria4,mMarProfe4,mMarHrE4,mMarHrS4,mMarAula4,mMarColor4;
    public TextView mMarMateria5,mMarProfe5,mMarHrE5,mMarHrS5,mMarAula5,mMarColor5;
    public TextView mMarMateria6,mMarProfe6,mMarHrE6,mMarHrS6,mMarAula6,mMarColor6;
    public TextView mMarMateria7,mMarProfe7,mMarHrE7,mMarHrS7,mMarAula7,mMarColor7;
    public TextView mMarMateria8,mMarProfe8,mMarHrE8,mMarHrS8,mMarAula8,mMarColor8;

    public TextView mMieMateria,mMieProfe,mMieHrE,mMieHrS,mMieAula,mMieColor;
    public TextView mMieMateria2,mMieProfe2,mMieHrE2,mMieHrS2,mMieAula2,mMieColor2;
    public TextView mMieMateria3,mMieProfe3,mMieHrE3,mMieHrS3,mMieAula3,mMieColor3;
    public TextView mMieMateria4,mMieProfe4,mMieHrE4,mMieHrS4,mMieAula4,mMieColor4;
    public TextView mMieMateria5,mMieProfe5,mMieHrE5,mMieHrS5,mMieAula5,mMieColor5;
    public TextView mMieMateria6,mMieProfe6,mMieHrE6,mMieHrS6,mMieAula6,mMieColor6;
    public TextView mMieMateria7,mMieProfe7,mMieHrE7,mMieHrS7,mMieAula7,mMieColor7;
    public TextView mMieMateria8,mMieProfe8,mMieHrE8,mMieHrS8,mMieAula8,mMieColor8;

    public TextView mJueMateria,mJueProfe,mJueHrE,mJueHrS,mJueAula,mJueColor;
    public TextView mJueMateria2,mJueProfe2,mJueHrE2,mJueHrS2,mJueAula2,mJueColor2;
    public TextView mJueMateria3,mJueProfe3,mJueHrE3,mJueHrS3,mJueAula3,mJueColor3;
    public TextView mJueMateria4,mJueProfe4,mJueHrE4,mJueHrS4,mJueAula4,mJueColor4;
    public TextView mJueMateria5,mJueProfe5,mJueHrE5,mJueHrS5,mJueAula5,mJueColor5;
    public TextView mJueMateria6,mJueProfe6,mJueHrE6,mJueHrS6,mJueAula6,mJueColor6;
    public TextView mJueMateria7,mJueProfe7,mJueHrE7,mJueHrS7,mJueAula7,mJueColor7;
    public TextView mJueMateria8,mJueProfe8,mJueHrE8,mJueHrS8,mJueAula8,mJueColor8;

    public TextView mVieMateria,mVieProfe,mVieHrE,mVieHrS,mVieAula,mVieColor;
    public TextView mVieMateria2,mVieProfe2,mVieHrE2,mVieHrS2,mVieAula2,mVieColor2;
    public TextView mVieMateria3,mVieProfe3,mVieHrE3,mVieHrS3,mVieAula3,mVieColor3;
    public TextView mVieMateria4,mVieProfe4,mVieHrE4,mVieHrS4,mVieAula4,mVieColor4;
    public TextView mVieMateria5,mVieProfe5,mVieHrE5,mVieHrS5,mVieAula5,mVieColor5;
    public TextView mVieMateria6,mVieProfe6,mVieHrE6,mVieHrS6,mVieAula6,mVieColor6;
    public TextView mVieMateria7,mVieProfe7,mVieHrE7,mVieHrS7,mVieAula7,mVieColor7;
    public TextView mVieMateria8,mVieProfe8,mVieHrE8,mVieHrS8,mVieAula8,mVieColor8;

    public TextView mSabMateria,mSabProfe,mSabHrE,mSabHrS,mSabAula,mSabColor;
    public TextView mSabMateria2,mSabProfe2,mSabHrE2,mSabHrS2,mSabAula2,mSabColor2;
    public TextView mSabMateria3,mSabProfe3,mSabHrE3,mSabHrS3,mSabAula3,mSabColor3;
    public TextView mSabMateria4,mSabProfe4,mSabHrE4,mSabHrS4,mSabAula4,mSabColor4;
    public TextView mSabMateria5,mSabProfe5,mSabHrE5,mSabHrS5,mSabAula5,mSabColor5;
    public TextView mSabMateria6,mSabProfe6,mSabHrE6,mSabHrS6,mSabAula6,mSabColor6;
    public TextView mSabMateria7,mSabProfe7,mSabHrE7,mSabHrS7,mSabAula7,mSabColor7;
    public TextView mSabMateria8,mSabProfe8,mSabHrE8,mSabHrS8,mSabAula8,mSabColor8;


    DatabaseHelper myDbHelper;

    SQLiteDatabase dby;
    Cursor miCursorLunes;
    Cursor miCursorMartes;
    Cursor miCursorMiercoles;
    Cursor miCursorJueves;
    Cursor miCursorViernes;
    Cursor miCursorSabado;
    Toolbar horariotoolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horario_principal);

        horariotoolbar = findViewById(R.id.idHorarioToolbar);

        setSupportActionBar(horariotoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myDbHelper = new DatabaseHelper(getApplicationContext(), "HorarioDos.db", 1);
        try {
            myDbHelper.CheckDb();
        }catch (Exception e){
        }

        dby = myDbHelper.getWritableDatabase();

        mContenedorHorario = findViewById(R.id.contenedorHorario);

        mLunMateria = findViewById(R.id.lunmateria);
        mLunProfe = findViewById(R.id.lunprofe);
        mLunHrE = findViewById(R.id.lunhrae);
        mLunHrS = findViewById(R.id.lunhras);
        mLunAula = findViewById(R.id.lunaula);
        mLunColor = findViewById(R.id.luncolor);

        mLunMateria2 = findViewById(R.id.lunmateria2);
        mLunProfe2 = findViewById(R.id.lunprofe2);
        mLunHrE2 = findViewById(R.id.lunhrae2);
        mLunHrS2 = findViewById(R.id.lunhras2);
        mLunAula2 = findViewById(R.id.lunaula2);
        mLunColor2 = findViewById(R.id.luncolor2);

        mLunMateria3 = findViewById(R.id.lunmateria3);
        mLunProfe3 = findViewById(R.id.lunprofe3);
        mLunHrE3 = findViewById(R.id.lunhrae3);
        mLunHrS3 = findViewById(R.id.lunhras3);
        mLunAula3 = findViewById(R.id.lunaula3);
        mLunColor3 = findViewById(R.id.luncolor3);

        mLunMateria4 = findViewById(R.id.lunmateria4);
        mLunProfe4 = findViewById(R.id.lunprofe4);
        mLunHrE4 = findViewById(R.id.lunhrae4);
        mLunHrS4 = findViewById(R.id.lunhras4);
        mLunAula4 = findViewById(R.id.lunaula4);
        mLunColor4 = findViewById(R.id.luncolor4);

        mLunMateria5 = findViewById(R.id.lunmateria5);
        mLunProfe5 = findViewById(R.id.lunprofe5);
        mLunHrE5 = findViewById(R.id.lunhrae5);
        mLunHrS5 = findViewById(R.id.lunhras5);
        mLunAula5 = findViewById(R.id.lunaula5);
        mLunColor5 = findViewById(R.id.luncolor5);

        mLunMateria6 = findViewById(R.id.lunmateria6);
        mLunProfe6 = findViewById(R.id.lunprofe6);
        mLunHrE6 = findViewById(R.id.lunhrae6);
        mLunHrS6 = findViewById(R.id.lunhras6);
        mLunAula6 = findViewById(R.id.lunaula6);
        mLunColor6 = findViewById(R.id.luncolor6);

        mLunMateria7 = findViewById(R.id.lunmateria7);
        mLunProfe7 = findViewById(R.id.lunprofe7);
        mLunHrE7 = findViewById(R.id.lunhrae7);
        mLunHrS7 = findViewById(R.id.lunhras7);
        mLunAula7 = findViewById(R.id.lunaula7);
        mLunColor7 = findViewById(R.id.luncolor7);

        mLunMateria8 = findViewById(R.id.lunmateria8);
        mLunProfe8 = findViewById(R.id.lunprofe8);
        mLunHrE8 = findViewById(R.id.lunhrae8);
        mLunHrS8 = findViewById(R.id.lunhras8);
        mLunAula8 = findViewById(R.id.lunaula8);
        mLunColor8 = findViewById(R.id.luncolor8);

//

        mMarMateria = findViewById(R.id.marmateria);
        mMarProfe = findViewById(R.id.marprofe);
        mMarHrE = findViewById(R.id.marhrae);
        mMarHrS = findViewById(R.id.marhras);
        mMarAula = findViewById(R.id.maraula);
        mMarColor = findViewById(R.id.marcolor);

        mMarMateria2 = findViewById(R.id.marmateria2);
        mMarProfe2 = findViewById(R.id.marprofe2);
        mMarHrE2 = findViewById(R.id.marhrae2);
        mMarHrS2 = findViewById(R.id.marhras2);
        mMarAula2 = findViewById(R.id.maraula2);
        mMarColor2 = findViewById(R.id.marcolor2);


        mMarMateria3 = findViewById(R.id.marmateria3);
        mMarProfe3 = findViewById(R.id.marprofe3);
        mMarHrE3 = findViewById(R.id.marhrae3);
        mMarHrS3 = findViewById(R.id.marhras3);
        mMarAula3 = findViewById(R.id.maraula3);
        mMarColor3 = findViewById(R.id.marcolor3);


        mMarMateria4 = findViewById(R.id.marmateria4);
        mMarProfe4 = findViewById(R.id.marprofe4);
        mMarHrE4 = findViewById(R.id.marhrae4);
        mMarHrS4 = findViewById(R.id.marhras4);
        mMarAula4 = findViewById(R.id.maraula4);
        mMarColor4 = findViewById(R.id.marcolor4);


        mMarMateria5 = findViewById(R.id.marmateria5);
        mMarProfe5 = findViewById(R.id.marprofe5);
        mMarHrE5 = findViewById(R.id.marhrae5);
        mMarHrS5 = findViewById(R.id.marhras5);
        mMarAula5 = findViewById(R.id.maraula5);
        mMarColor5 = findViewById(R.id.marcolor5);

        mMarMateria6 = findViewById(R.id.marmateria6);
        mMarProfe6 = findViewById(R.id.marprofe6);
        mMarHrE6 = findViewById(R.id.marhrae6);
        mMarHrS6 = findViewById(R.id.marhras6);
        mMarAula6 = findViewById(R.id.maraula6);
        mMarColor6 = findViewById(R.id.marcolor6);

        mMarMateria7 = findViewById(R.id.marmateria7);
        mMarProfe7 = findViewById(R.id.marprofe7);
        mMarHrE7 = findViewById(R.id.marhrae7);
        mMarHrS7 = findViewById(R.id.marhras7);
        mMarAula7 = findViewById(R.id.maraula7);
        mMarColor7 = findViewById(R.id.marcolor7);

        mMarMateria8 = findViewById(R.id.marmateria8);
        mMarProfe8 = findViewById(R.id.marprofe8);
        mMarHrE8 = findViewById(R.id.marhrae8);
        mMarHrS8 = findViewById(R.id.marhras8);
        mMarAula8 = findViewById(R.id.maraula8);
        mMarColor8 = findViewById(R.id.marcolor8);

///

        mMieMateria = findViewById(R.id.miemateria);
        mMieProfe = findViewById(R.id.mieprofe);
        mMieHrE = findViewById(R.id.miehrae);
        mMieHrS = findViewById(R.id.miehras);
        mMieAula = findViewById(R.id.mieaula);
        mMieColor = findViewById(R.id.miecolor);

        mMieMateria2 = findViewById(R.id.miemateria2);
        mMieProfe2 = findViewById(R.id.mieprofe2);
        mMieHrE2 = findViewById(R.id.miehrae2);
        mMieHrS2 = findViewById(R.id.miehras2);
        mMieAula2 = findViewById(R.id.mieaula2);
        mMieColor2 = findViewById(R.id.miecolor2);

        mMieMateria3 = findViewById(R.id.miemateria3);
        mMieProfe3 = findViewById(R.id.mieprofe3);
        mMieHrE3 = findViewById(R.id.miehrae3);
        mMieHrS3 = findViewById(R.id.miehras3);
        mMieAula3 = findViewById(R.id.mieaula3);
        mMieColor3 = findViewById(R.id.miecolor3);

        mMieMateria4 = findViewById(R.id.miemateria4);
        mMieProfe4 = findViewById(R.id.mieprofe4);
        mMieHrE4 = findViewById(R.id.miehrae4);
        mMieHrS4 = findViewById(R.id.miehras4);
        mMieAula4 = findViewById(R.id.mieaula4);
        mMieColor4 = findViewById(R.id.miecolor4);

        mMieMateria5 = findViewById(R.id.miemateria5);
        mMieProfe5 = findViewById(R.id.mieprofe5);
        mMieHrE5 = findViewById(R.id.miehrae5);
        mMieHrS5 = findViewById(R.id.miehras5);
        mMieAula5 = findViewById(R.id.mieaula5);
        mMieColor5 = findViewById(R.id.miecolor5);

        mMieMateria6 = findViewById(R.id.miemateria6);
        mMieProfe6 = findViewById(R.id.mieprofe6);
        mMieHrE6 = findViewById(R.id.miehrae6);
        mMieHrS6 = findViewById(R.id.miehras6);
        mMieAula6 = findViewById(R.id.mieaula6);
        mMieColor6 = findViewById(R.id.miecolor6);

        mMieMateria7 = findViewById(R.id.miemateria7);
        mMieProfe7 = findViewById(R.id.mieprofe7);
        mMieHrE7 = findViewById(R.id.miehrae7);
        mMieHrS7 = findViewById(R.id.miehras7);
        mMieAula7 = findViewById(R.id.mieaula7);
        mMieColor7 = findViewById(R.id.miecolor7);

        mMieMateria8 = findViewById(R.id.miemateria8);
        mMieProfe8 = findViewById(R.id.mieprofe8);
        mMieHrE8 = findViewById(R.id.miehrae8);
        mMieHrS8 = findViewById(R.id.miehras8);
        mMieAula8 = findViewById(R.id.mieaula8);
        mMieColor8 = findViewById(R.id.miecolor8);
////
        mJueMateria = findViewById(R.id.juemateria);
        mJueProfe = findViewById(R.id.jueprofe);
        mJueHrE = findViewById(R.id.juehrae);
        mJueHrS = findViewById(R.id.juehras);
        mJueAula = findViewById(R.id.jueaula);
        mJueColor = findViewById(R.id.juecolor);

        mJueMateria2 = findViewById(R.id.juemateria2);
        mJueProfe2 = findViewById(R.id.jueprofe2);
        mJueHrE2 = findViewById(R.id.juehrae2);
        mJueHrS2 = findViewById(R.id.juehras2);
        mJueAula2 = findViewById(R.id.jueaula2);
        mJueColor2 = findViewById(R.id.juecolor2);

        mJueMateria3 = findViewById(R.id.juemateria3);
        mJueProfe3 = findViewById(R.id.jueprofe3);
        mJueHrE3 = findViewById(R.id.juehrae3);
        mJueHrS3 = findViewById(R.id.juehras3);
        mJueAula3 = findViewById(R.id.jueaula3);
        mJueColor3 = findViewById(R.id.juecolor3);

        mJueMateria4 = findViewById(R.id.juemateria4);
        mJueProfe4 = findViewById(R.id.jueprofe4);
        mJueHrE4 = findViewById(R.id.juehrae4);
        mJueHrS4 = findViewById(R.id.juehras4);
        mJueAula4 = findViewById(R.id.jueaula4);
        mJueColor4 = findViewById(R.id.juecolor4);

        mJueMateria5 = findViewById(R.id.juemateria5);
        mJueProfe5 = findViewById(R.id.jueprofe5);
        mJueHrE5 = findViewById(R.id.juehrae5);
        mJueHrS5 = findViewById(R.id.juehras5);
        mJueAula5 = findViewById(R.id.jueaula5);
        mJueColor5 = findViewById(R.id.juecolor5);

        mJueMateria6 = findViewById(R.id.juemateria6);
        mJueProfe6 = findViewById(R.id.jueprofe6);
        mJueHrE6 = findViewById(R.id.juehrae6);
        mJueHrS6 = findViewById(R.id.juehras6);
        mJueAula6 = findViewById(R.id.jueaula6);
        mJueColor6 = findViewById(R.id.juecolor6);

        mJueMateria7 = findViewById(R.id.juemateria7);
        mJueProfe7 = findViewById(R.id.jueprofe7);
        mJueHrE7 = findViewById(R.id.juehrae7);
        mJueHrS7 = findViewById(R.id.juehras7);
        mJueAula7 = findViewById(R.id.jueaula7);
        mJueColor7 = findViewById(R.id.juecolor7);

        mJueMateria8 = findViewById(R.id.juemateria8);
        mJueProfe8 = findViewById(R.id.jueprofe8);
        mJueHrE8 = findViewById(R.id.juehrae8);
        mJueHrS8 = findViewById(R.id.juehras8);
        mJueAula8 = findViewById(R.id.jueaula8);
        mJueColor8 = findViewById(R.id.juecolor8);
        ///

        mVieMateria = findViewById(R.id.viemateria);
        mVieProfe = findViewById(R.id.vieprofe);
        mVieHrE = findViewById(R.id.viehrae);
        mVieHrS = findViewById(R.id.viehras);
        mVieAula = findViewById(R.id.vieaula);
        mVieColor = findViewById(R.id.viecolor);

        mVieMateria2 = findViewById(R.id.viemateria2);
        mVieProfe2 = findViewById(R.id.vieprofe2);
        mVieHrE2 = findViewById(R.id.viehrae2);
        mVieHrS2 = findViewById(R.id.viehras2);
        mVieAula2 = findViewById(R.id.vieaula2);
        mVieColor2 = findViewById(R.id.viecolor2);

        mVieMateria3 = findViewById(R.id.viemateria3);
        mVieProfe3 = findViewById(R.id.vieprofe3);
        mVieHrE3 = findViewById(R.id.viehrae3);
        mVieHrS3 = findViewById(R.id.viehras3);
        mVieAula3 = findViewById(R.id.vieaula3);
        mVieColor3 = findViewById(R.id.viecolor3);

        mVieMateria4 = findViewById(R.id.viemateria4);
        mVieProfe4 = findViewById(R.id.vieprofe4);
        mVieHrE4 = findViewById(R.id.viehrae4);
        mVieHrS4 = findViewById(R.id.viehras4);
        mVieAula4 = findViewById(R.id.vieaula4);
        mVieColor4 = findViewById(R.id.viecolor4);

        mVieMateria5 = findViewById(R.id.viemateria5);
        mVieProfe5 = findViewById(R.id.vieprofe5);
        mVieHrE5 = findViewById(R.id.viehrae5);
        mVieHrS5 = findViewById(R.id.viehras5);
        mVieAula5 = findViewById(R.id.vieaula5);
        mVieColor5 = findViewById(R.id.viecolor5);

        mVieMateria6 = findViewById(R.id.viemateria6);
        mVieProfe6 = findViewById(R.id.vieprofe6);
        mVieHrE6 = findViewById(R.id.viehrae6);
        mVieHrS6 = findViewById(R.id.viehras6);
        mVieAula6 = findViewById(R.id.vieaula6);
        mVieColor6 = findViewById(R.id.viecolor6);

        mVieMateria7 = findViewById(R.id.viemateria7);
        mVieProfe7 = findViewById(R.id.vieprofe7);
        mVieHrE7 = findViewById(R.id.viehrae7);
        mVieHrS7 = findViewById(R.id.viehras7);
        mVieAula7 = findViewById(R.id.vieaula7);
        mVieColor7 = findViewById(R.id.viecolor7);

        mVieMateria8 = findViewById(R.id.viemateria8);
        mVieProfe8 = findViewById(R.id.vieprofe8);
        mVieHrE8 = findViewById(R.id.viehrae8);
        mVieHrS8 = findViewById(R.id.viehras8);
        mVieAula8 = findViewById(R.id.vieaula8);
        mVieColor8 = findViewById(R.id.viecolor8);
/////////

        mSabMateria = findViewById(R.id.sabmateria);
        mSabProfe = findViewById(R.id.sabprofe);
        mSabHrE = findViewById(R.id.sabhrae);
        mSabHrS = findViewById(R.id.sabhras);
        mSabAula = findViewById(R.id.sabaula);
        mSabColor = findViewById(R.id.sabcolor);

        mSabMateria2 = findViewById(R.id.sabmateria2);
        mSabProfe2 = findViewById(R.id.sabprofe2);
        mSabHrE2 = findViewById(R.id.sabhrae2);
        mSabHrS2 = findViewById(R.id.sabhras2);
        mSabAula2 = findViewById(R.id.sabaula2);
        mSabColor2 = findViewById(R.id.sabcolor2);

        mSabMateria3 = findViewById(R.id.sabmateria3);
        mSabProfe3 = findViewById(R.id.sabprofe3);
        mSabHrE3 = findViewById(R.id.sabhrae3);
        mSabHrS3 = findViewById(R.id.sabhras3);
        mSabAula3 = findViewById(R.id.sabaula3);
        mSabColor3 = findViewById(R.id.sabcolor3);

        mSabMateria4 = findViewById(R.id.sabmateria4);
        mSabProfe4 = findViewById(R.id.sabprofe4);
        mSabHrE4 = findViewById(R.id.sabhrae4);
        mSabHrS4 = findViewById(R.id.sabhras4);
        mSabAula4 = findViewById(R.id.sabaula4);
        mSabColor4 = findViewById(R.id.sabcolor4);

        mSabMateria5 = findViewById(R.id.sabmateria5);
        mSabProfe5 = findViewById(R.id.sabprofe5);
        mSabHrE5 = findViewById(R.id.sabhrae5);
        mSabHrS5 = findViewById(R.id.sabhras5);
        mSabAula5 = findViewById(R.id.sabaula5);
        mSabColor5 = findViewById(R.id.sabcolor5);

        mSabMateria6 = findViewById(R.id.sabmateria6);
        mSabProfe6 = findViewById(R.id.sabprofe6);
        mSabHrE6 = findViewById(R.id.sabhrae6);
        mSabHrS6 = findViewById(R.id.sabhras6);
        mSabAula6 = findViewById(R.id.sabaula6);
        mSabColor6 = findViewById(R.id.sabcolor6);

        mSabMateria7 = findViewById(R.id.sabmateria7);
        mSabProfe7 = findViewById(R.id.sabprofe7);
        mSabHrE7 = findViewById(R.id.sabhrae7);
        mSabHrS7 = findViewById(R.id.sabhras7);
        mSabAula7 = findViewById(R.id.sabaula7);
        mSabColor7 = findViewById(R.id.sabcolor7);

        mSabMateria8 = findViewById(R.id.sabmateria8);
        mSabProfe8 = findViewById(R.id.sabprofe8);
        mSabHrE8 = findViewById(R.id.sabhrae8);
        mSabHrS8 = findViewById(R.id.sabhras8);
        mSabAula8 = findViewById(R.id.sabaula8);
        mSabColor8 = findViewById(R.id.sabcolor8);


////////

        linelunes = findViewById(R.id.LineLunes);
        linelunes2 = findViewById(R.id.LineLunes2);
        linelunes3 = findViewById(R.id.LineLunes3);
        linelunes4 = findViewById(R.id.LineLunes4);
        linelunes5 = findViewById(R.id.LineLunes5);
        linelunes6 = findViewById(R.id.LineLunes6);
        linelunes7 = findViewById(R.id.LineLunes7);
        linelunes8 = findViewById(R.id.LineLunes8);

        linemartes = findViewById(R.id.LineMar);
        linemartes2 = findViewById(R.id.LineMar2);
        linemartes3 = findViewById(R.id.LineMar3);
        linemartes4 = findViewById(R.id.LineMar4);
        linemartes5 = findViewById(R.id.LineMar5);
        linemartes6 = findViewById(R.id.LineMar6);
        linemartes7 = findViewById(R.id.LineMar7);
        linemartes8 = findViewById(R.id.LineMar8);

        linemiercoles = findViewById(R.id.LineMie);
        linemiercoles2 = findViewById(R.id.LineMie2);
        linemiercoles3 = findViewById(R.id.LineMie3);
        linemiercoles4 = findViewById(R.id.LineMie4);
        linemiercoles5 = findViewById(R.id.LineMie5);
        linemiercoles6 = findViewById(R.id.LineMie6);
        linemiercoles7 = findViewById(R.id.LineMie7);
        linemiercoles8 = findViewById(R.id.LineMie8);

        linejueves = findViewById(R.id.LineJue);
        linejueves2 = findViewById(R.id.LineJue2);
        linejueves3 = findViewById(R.id.LineJue3);
        linejueves4 = findViewById(R.id.LineJue4);
        linejueves5 = findViewById(R.id.LineJue5);
        linejueves6 = findViewById(R.id.LineJue6);
        linejueves7 = findViewById(R.id.LineJue7);
        linejueves8 = findViewById(R.id.LineJue8);

        lineviernes = findViewById(R.id.LineVie);
        lineviernes2 = findViewById(R.id.LineVie2);
        lineviernes3 = findViewById(R.id.LineVie3);
        lineviernes4 = findViewById(R.id.LineVie4);
        lineviernes5 = findViewById(R.id.LineVie5);
        lineviernes6 = findViewById(R.id.LineVie6);
        lineviernes7 = findViewById(R.id.LineVie7);
        lineviernes8 = findViewById(R.id.LineVie8);

        linesabado = findViewById(R.id.LineSab);
        linesabado2 = findViewById(R.id.LineSab2);
        linesabado3 = findViewById(R.id.LineSab3);
        linesabado4 = findViewById(R.id.LineSab4);
        linesabado5 = findViewById(R.id.LineSab5);
        linesabado6 = findViewById(R.id.LineSab6);
        linesabado7 = findViewById(R.id.LineSab7);
        linesabado8 = findViewById(R.id.LineSab8);

        /////

        myDbHelper = new DatabaseHelper(this, "HorarioDos.db", 1);
        try {
            myDbHelper.CheckDb();
        }catch (Exception e){}

        dby = myDbHelper.getWritableDatabase();

        //usarDB();
        invisibleLunes();
        invisibleMartes();
        invisibleMiercoles();
        invisibleJueves();
        invisibleViernes();
        invisibleSabado();


        MostrarDBLunes();
        MostrarDBMartes();
        MostrarDBMiercoles();
        MostrarDBJueves();
        MostrarDBViernes();
        MostrarDBSabado();

    }


    public void invisibleLunes(){
        mLunMateria.setVisibility(View.INVISIBLE);
        mLunProfe.setVisibility(View.INVISIBLE);
        mLunHrE.setVisibility(View.INVISIBLE);
        mLunHrS.setVisibility(View.INVISIBLE);
        mLunAula.setVisibility(View.INVISIBLE);
        mLunColor.setVisibility(View.GONE);

        mLunMateria2.setVisibility(View.INVISIBLE);
        mLunProfe2.setVisibility(View.INVISIBLE);
        mLunHrE2.setVisibility(View.INVISIBLE);
        mLunHrS2.setVisibility(View.INVISIBLE);
        mLunAula2.setVisibility(View.INVISIBLE);
        mLunColor2.setVisibility(View.GONE);

        mLunMateria3.setVisibility(View.INVISIBLE);
        mLunProfe3.setVisibility(View.INVISIBLE);
        mLunHrE3.setVisibility(View.INVISIBLE);
        mLunHrS3.setVisibility(View.INVISIBLE);
        mLunAula3.setVisibility(View.INVISIBLE);
        mLunColor3.setVisibility(View.GONE);

        mLunMateria4.setVisibility(View.INVISIBLE);
        mLunProfe4.setVisibility(View.INVISIBLE);
        mLunHrE4.setVisibility(View.INVISIBLE);
        mLunHrS4.setVisibility(View.INVISIBLE);
        mLunAula4.setVisibility(View.INVISIBLE);
        mLunColor4.setVisibility(View.GONE);

        mLunMateria5.setVisibility(View.INVISIBLE);
        mLunProfe5.setVisibility(View.INVISIBLE);
        mLunHrE5.setVisibility(View.INVISIBLE);
        mLunHrS5.setVisibility(View.INVISIBLE);
        mLunAula5.setVisibility(View.INVISIBLE);
        mLunColor5.setVisibility(View.GONE);

        mLunMateria6.setVisibility(View.INVISIBLE);
        mLunProfe6.setVisibility(View.INVISIBLE);
        mLunHrE6.setVisibility(View.INVISIBLE);
        mLunHrS6.setVisibility(View.INVISIBLE);
        mLunAula6.setVisibility(View.INVISIBLE);
        mLunColor6.setVisibility(View.GONE);

        mLunMateria7.setVisibility(View.INVISIBLE);
        mLunProfe7.setVisibility(View.INVISIBLE);
        mLunHrE7.setVisibility(View.INVISIBLE);
        mLunHrS7.setVisibility(View.INVISIBLE);
        mLunAula7.setVisibility(View.INVISIBLE);
        mLunColor7.setVisibility(View.GONE);

        mLunMateria8.setVisibility(View.INVISIBLE);
        mLunProfe8.setVisibility(View.INVISIBLE);
        mLunHrE8.setVisibility(View.INVISIBLE);
        mLunHrS8.setVisibility(View.INVISIBLE);
        mLunAula8.setVisibility(View.INVISIBLE);
        mLunColor8.setVisibility(View.GONE);

        linelunes.setVisibility(View.VISIBLE);
        linelunes2.setVisibility(View.VISIBLE);
        linelunes3.setVisibility(View.VISIBLE);
        linelunes4.setVisibility(View.VISIBLE);
        linelunes5.setVisibility(View.VISIBLE);
        linelunes6.setVisibility(View.VISIBLE);
        linelunes7.setVisibility(View.VISIBLE);
        linelunes8.setVisibility(View.VISIBLE);

        lunesMateriasLay();


    }

    public void invisibleMartes(){
        mMarMateria.setVisibility(View.INVISIBLE);
        mMarProfe.setVisibility(View.INVISIBLE);
        mMarHrE.setVisibility(View.INVISIBLE);
        mMarHrS.setVisibility(View.INVISIBLE);
        mMarAula.setVisibility(View.INVISIBLE);
        mMarColor.setVisibility(View.GONE);

        mMarMateria2.setVisibility(View.INVISIBLE);
        mMarProfe2.setVisibility(View.INVISIBLE);
        mMarHrE2.setVisibility(View.INVISIBLE);
        mMarHrS2.setVisibility(View.INVISIBLE);
        mMarAula2.setVisibility(View.INVISIBLE);
        mMarColor2.setVisibility(View.GONE);

        mMarMateria3.setVisibility(View.INVISIBLE);
        mMarProfe3.setVisibility(View.INVISIBLE);
        mMarHrE3.setVisibility(View.INVISIBLE);
        mMarHrS3.setVisibility(View.INVISIBLE);
        mMarAula3.setVisibility(View.INVISIBLE);
        mMarColor3.setVisibility(View.GONE);

        mMarMateria4.setVisibility(View.INVISIBLE);
        mMarProfe4.setVisibility(View.INVISIBLE);
        mMarHrE4.setVisibility(View.INVISIBLE);
        mMarHrS4.setVisibility(View.INVISIBLE);
        mMarAula4.setVisibility(View.INVISIBLE);
        mMarColor4.setVisibility(View.GONE);

        mMarMateria5.setVisibility(View.INVISIBLE);
        mMarProfe5.setVisibility(View.INVISIBLE);
        mMarHrE5.setVisibility(View.INVISIBLE);
        mMarHrS5.setVisibility(View.INVISIBLE);
        mMarAula5.setVisibility(View.INVISIBLE);
        mMarColor5.setVisibility(View.GONE);

        mMarMateria6.setVisibility(View.INVISIBLE);
        mMarProfe6.setVisibility(View.INVISIBLE);
        mMarHrE6.setVisibility(View.INVISIBLE);
        mMarHrS6.setVisibility(View.INVISIBLE);
        mMarAula6.setVisibility(View.INVISIBLE);
        mMarColor6.setVisibility(View.GONE);

        mMarMateria7.setVisibility(View.INVISIBLE);
        mMarProfe7.setVisibility(View.INVISIBLE);
        mMarHrE7.setVisibility(View.INVISIBLE);
        mMarHrS7.setVisibility(View.INVISIBLE);
        mMarAula7.setVisibility(View.INVISIBLE);
        mMarColor7.setVisibility(View.GONE);

        mMarMateria8.setVisibility(View.INVISIBLE);
        mMarProfe8.setVisibility(View.INVISIBLE);
        mMarHrE8.setVisibility(View.INVISIBLE);
        mMarHrS8.setVisibility(View.INVISIBLE);
        mMarAula8.setVisibility(View.INVISIBLE);
        mMarColor8.setVisibility(View.GONE);

        linemartes.setVisibility(View.VISIBLE);
        linemartes2.setVisibility(View.VISIBLE);
        linemartes3.setVisibility(View.VISIBLE);
        linemartes4.setVisibility(View.VISIBLE);
        linemartes5.setVisibility(View.VISIBLE);
        linemartes6.setVisibility(View.VISIBLE);
        linemartes7.setVisibility(View.VISIBLE);
        linemartes8.setVisibility(View.VISIBLE);

        martesMateriasLay();


    }

    public void invisibleMiercoles(){
        mMieMateria.setVisibility(View.INVISIBLE);
        mMieProfe.setVisibility(View.INVISIBLE);
        mMieHrE.setVisibility(View.INVISIBLE);
        mMieHrS.setVisibility(View.INVISIBLE);
        mMieAula.setVisibility(View.INVISIBLE);
        mMieColor.setVisibility(View.GONE);

        mMieMateria2.setVisibility(View.INVISIBLE);
        mMieProfe2.setVisibility(View.INVISIBLE);
        mMieHrE2.setVisibility(View.INVISIBLE);
        mMieHrS2.setVisibility(View.INVISIBLE);
        mMieAula2.setVisibility(View.INVISIBLE);
        mMieColor2.setVisibility(View.GONE);

        mMieMateria3.setVisibility(View.INVISIBLE);
        mMieProfe3.setVisibility(View.INVISIBLE);
        mMieHrE3.setVisibility(View.INVISIBLE);
        mMieHrS3.setVisibility(View.INVISIBLE);
        mMieAula3.setVisibility(View.INVISIBLE);
        mMieColor3.setVisibility(View.GONE);

        mMieMateria4.setVisibility(View.INVISIBLE);
        mMieProfe4.setVisibility(View.INVISIBLE);
        mMieHrE4.setVisibility(View.INVISIBLE);
        mMieHrS4.setVisibility(View.INVISIBLE);
        mMieAula4.setVisibility(View.INVISIBLE);
        mMieColor4.setVisibility(View.GONE);

        mMieMateria5.setVisibility(View.INVISIBLE);
        mMieProfe5.setVisibility(View.INVISIBLE);
        mMieHrE5.setVisibility(View.INVISIBLE);
        mMieHrS5.setVisibility(View.INVISIBLE);
        mMieAula5.setVisibility(View.INVISIBLE);
        mMieColor5.setVisibility(View.GONE);

        mMieMateria6.setVisibility(View.INVISIBLE);
        mMieProfe6.setVisibility(View.INVISIBLE);
        mMieHrE6.setVisibility(View.INVISIBLE);
        mMieHrS6.setVisibility(View.INVISIBLE);
        mMieAula6.setVisibility(View.INVISIBLE);
        mMieColor6.setVisibility(View.GONE);

        mMieMateria7.setVisibility(View.INVISIBLE);
        mMieProfe7.setVisibility(View.INVISIBLE);
        mMieHrE7.setVisibility(View.INVISIBLE);
        mMieHrS7.setVisibility(View.INVISIBLE);
        mMieAula7.setVisibility(View.INVISIBLE);
        mMieColor7.setVisibility(View.GONE);

        mMieMateria8.setVisibility(View.INVISIBLE);
        mMieProfe8.setVisibility(View.INVISIBLE);
        mMieHrE8.setVisibility(View.INVISIBLE);
        mMieHrS8.setVisibility(View.INVISIBLE);
        mMieAula8.setVisibility(View.INVISIBLE);
        mMieColor8.setVisibility(View.GONE);

        linemiercoles.setVisibility(View.VISIBLE);
        linemiercoles2.setVisibility(View.VISIBLE);
        linemiercoles3.setVisibility(View.VISIBLE);
        linemiercoles4.setVisibility(View.VISIBLE);
        linemiercoles5.setVisibility(View.VISIBLE);
        linemiercoles6.setVisibility(View.VISIBLE);
        linemiercoles7.setVisibility(View.VISIBLE);
        linemiercoles8.setVisibility(View.VISIBLE);

        miercolesMateriasLay();


    }

    public void invisibleJueves(){
        mJueMateria.setVisibility(View.INVISIBLE);
        mJueProfe.setVisibility(View.INVISIBLE);
        mJueHrE.setVisibility(View.INVISIBLE);
        mJueHrS.setVisibility(View.INVISIBLE);
        mJueAula.setVisibility(View.INVISIBLE);
        mJueColor.setVisibility(View.GONE);

        mJueMateria2.setVisibility(View.INVISIBLE);
        mJueProfe2.setVisibility(View.INVISIBLE);
        mJueHrE2.setVisibility(View.INVISIBLE);
        mJueHrS2.setVisibility(View.INVISIBLE);
        mJueAula2.setVisibility(View.INVISIBLE);
        mJueColor2.setVisibility(View.GONE);

        mJueMateria3.setVisibility(View.INVISIBLE);
        mJueProfe3.setVisibility(View.INVISIBLE);
        mJueHrE3.setVisibility(View.INVISIBLE);
        mJueHrS3.setVisibility(View.INVISIBLE);
        mJueAula3.setVisibility(View.INVISIBLE);
        mJueColor3.setVisibility(View.GONE);

        mJueMateria4.setVisibility(View.INVISIBLE);
        mJueProfe4.setVisibility(View.INVISIBLE);
        mJueHrE4.setVisibility(View.INVISIBLE);
        mJueHrS4.setVisibility(View.INVISIBLE);
        mJueAula4.setVisibility(View.INVISIBLE);
        mJueColor4.setVisibility(View.GONE);

        mJueMateria5.setVisibility(View.INVISIBLE);
        mJueProfe5.setVisibility(View.INVISIBLE);
        mJueHrE5.setVisibility(View.INVISIBLE);
        mJueHrS5.setVisibility(View.INVISIBLE);
        mJueAula5.setVisibility(View.INVISIBLE);
        mJueColor5.setVisibility(View.GONE);

        mJueMateria6.setVisibility(View.INVISIBLE);
        mJueProfe6.setVisibility(View.INVISIBLE);
        mJueHrE6.setVisibility(View.INVISIBLE);
        mJueHrS6.setVisibility(View.INVISIBLE);
        mJueAula6.setVisibility(View.INVISIBLE);
        mJueColor6.setVisibility(View.GONE);

        mJueMateria7.setVisibility(View.INVISIBLE);
        mJueProfe7.setVisibility(View.INVISIBLE);
        mJueHrE7.setVisibility(View.INVISIBLE);
        mJueHrS7.setVisibility(View.INVISIBLE);
        mJueAula7.setVisibility(View.INVISIBLE);
        mJueColor7.setVisibility(View.GONE);

        mJueMateria8.setVisibility(View.INVISIBLE);
        mJueProfe8.setVisibility(View.INVISIBLE);
        mJueHrE8.setVisibility(View.INVISIBLE);
        mJueHrS8.setVisibility(View.INVISIBLE);
        mJueAula8.setVisibility(View.INVISIBLE);
        mJueColor8.setVisibility(View.GONE);

        linejueves.setVisibility(View.VISIBLE);
        linejueves2.setVisibility(View.VISIBLE);
        linejueves3.setVisibility(View.VISIBLE);
        linejueves4.setVisibility(View.VISIBLE);
        linejueves5.setVisibility(View.VISIBLE);
        linejueves6.setVisibility(View.VISIBLE);
        linejueves7.setVisibility(View.VISIBLE);
        linejueves8.setVisibility(View.VISIBLE);

        juevesMateriasLay();


    }

    public void invisibleViernes(){
        mVieMateria.setVisibility(View.INVISIBLE);
        mVieProfe.setVisibility(View.INVISIBLE);
        mVieHrE.setVisibility(View.INVISIBLE);
        mVieHrS.setVisibility(View.INVISIBLE);
        mVieAula.setVisibility(View.INVISIBLE);
        mVieColor.setVisibility(View.GONE);

        mVieMateria2.setVisibility(View.INVISIBLE);
        mVieProfe2.setVisibility(View.INVISIBLE);
        mVieHrE2.setVisibility(View.INVISIBLE);
        mVieHrS2.setVisibility(View.INVISIBLE);
        mVieAula2.setVisibility(View.INVISIBLE);
        mVieColor2.setVisibility(View.GONE);

        mVieMateria3.setVisibility(View.INVISIBLE);
        mVieProfe3.setVisibility(View.INVISIBLE);
        mVieHrE3.setVisibility(View.INVISIBLE);
        mVieHrS3.setVisibility(View.INVISIBLE);
        mVieAula3.setVisibility(View.INVISIBLE);
        mVieColor3.setVisibility(View.GONE);

        mVieMateria4.setVisibility(View.INVISIBLE);
        mVieProfe4.setVisibility(View.INVISIBLE);
        mVieHrE4.setVisibility(View.INVISIBLE);
        mVieHrS4.setVisibility(View.INVISIBLE);
        mVieAula4.setVisibility(View.INVISIBLE);
        mVieColor4.setVisibility(View.GONE);

        mVieMateria5.setVisibility(View.INVISIBLE);
        mVieProfe5.setVisibility(View.INVISIBLE);
        mVieHrE5.setVisibility(View.INVISIBLE);
        mVieHrS5.setVisibility(View.INVISIBLE);
        mVieAula5.setVisibility(View.INVISIBLE);
        mVieColor5.setVisibility(View.GONE);

        mVieMateria6.setVisibility(View.INVISIBLE);
        mVieProfe6.setVisibility(View.INVISIBLE);
        mVieHrE6.setVisibility(View.INVISIBLE);
        mVieHrS6.setVisibility(View.INVISIBLE);
        mVieAula6.setVisibility(View.INVISIBLE);
        mVieColor6.setVisibility(View.GONE);

        mVieMateria7.setVisibility(View.INVISIBLE);
        mVieProfe7.setVisibility(View.INVISIBLE);
        mVieHrE7.setVisibility(View.INVISIBLE);
        mVieHrS7.setVisibility(View.INVISIBLE);
        mVieAula7.setVisibility(View.INVISIBLE);
        mVieColor7.setVisibility(View.GONE);

        mVieMateria8.setVisibility(View.INVISIBLE);
        mVieProfe8.setVisibility(View.INVISIBLE);
        mVieHrE8.setVisibility(View.INVISIBLE);
        mVieHrS8.setVisibility(View.INVISIBLE);
        mVieAula8.setVisibility(View.INVISIBLE);
        mVieColor8.setVisibility(View.GONE);

        lineviernes.setVisibility(View.VISIBLE);
        lineviernes2.setVisibility(View.VISIBLE);
        lineviernes3.setVisibility(View.VISIBLE);
        lineviernes4.setVisibility(View.VISIBLE);
        lineviernes5.setVisibility(View.VISIBLE);
        lineviernes6.setVisibility(View.VISIBLE);
        lineviernes7.setVisibility(View.VISIBLE);
        lineviernes8.setVisibility(View.VISIBLE);

        viernesMateriasLay();


    }

    public void invisibleSabado(){
        mSabMateria.setVisibility(View.INVISIBLE);
        mSabProfe.setVisibility(View.INVISIBLE);
        mSabHrE.setVisibility(View.INVISIBLE);
        mSabHrS.setVisibility(View.INVISIBLE);
        mSabAula.setVisibility(View.INVISIBLE);
        mSabColor.setVisibility(View.GONE);

        mSabMateria2.setVisibility(View.INVISIBLE);
        mSabProfe2.setVisibility(View.INVISIBLE);
        mSabHrE2.setVisibility(View.INVISIBLE);
        mSabHrS2.setVisibility(View.INVISIBLE);
        mSabAula2.setVisibility(View.INVISIBLE);
        mSabColor2.setVisibility(View.GONE);

        mSabMateria3.setVisibility(View.INVISIBLE);
        mSabProfe3.setVisibility(View.INVISIBLE);
        mSabHrE3.setVisibility(View.INVISIBLE);
        mSabHrS3.setVisibility(View.INVISIBLE);
        mSabAula3.setVisibility(View.INVISIBLE);
        mSabColor3.setVisibility(View.GONE);

        mSabMateria4.setVisibility(View.INVISIBLE);
        mSabProfe4.setVisibility(View.INVISIBLE);
        mSabHrE4.setVisibility(View.INVISIBLE);
        mSabHrS4.setVisibility(View.INVISIBLE);
        mSabAula4.setVisibility(View.INVISIBLE);
        mSabColor4.setVisibility(View.GONE);

        mSabMateria5.setVisibility(View.INVISIBLE);
        mSabProfe5.setVisibility(View.INVISIBLE);
        mSabHrE5.setVisibility(View.INVISIBLE);
        mSabHrS5.setVisibility(View.INVISIBLE);
        mSabAula5.setVisibility(View.INVISIBLE);
        mSabColor5.setVisibility(View.GONE);

        mSabMateria6.setVisibility(View.INVISIBLE);
        mSabProfe6.setVisibility(View.INVISIBLE);
        mSabHrE6.setVisibility(View.INVISIBLE);
        mSabHrS6.setVisibility(View.INVISIBLE);
        mSabAula6.setVisibility(View.INVISIBLE);
        mSabColor6.setVisibility(View.GONE);

        mSabMateria7.setVisibility(View.INVISIBLE);
        mSabProfe7.setVisibility(View.INVISIBLE);
        mSabHrE7.setVisibility(View.INVISIBLE);
        mSabHrS7.setVisibility(View.INVISIBLE);
        mSabAula7.setVisibility(View.INVISIBLE);
        mSabColor7.setVisibility(View.GONE);

        mSabMateria8.setVisibility(View.INVISIBLE);
        mSabProfe8.setVisibility(View.INVISIBLE);
        mSabHrE8.setVisibility(View.INVISIBLE);
        mSabHrS8.setVisibility(View.INVISIBLE);
        mSabAula8.setVisibility(View.INVISIBLE);
        mSabColor8.setVisibility(View.GONE);

        linesabado.setVisibility(View.VISIBLE);
        linesabado2.setVisibility(View.VISIBLE);
        linesabado3.setVisibility(View.VISIBLE);
        linesabado4.setVisibility(View.VISIBLE);
        linesabado5.setVisibility(View.VISIBLE);
        linesabado6.setVisibility(View.VISIBLE);
        linesabado7.setVisibility(View.VISIBLE);
        linesabado8.setVisibility(View.VISIBLE);

        sabadoMateriasLay();


    }


    public void MostrarDBLunes() {

        try {
            miCursorLunes = dby.rawQuery("PRAGMA journal_mode=DELETE", null);

            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria.setText(miCursorLunes.getString(0));
            mLunProfe.setText(miCursorLunes.getString(1));
            mLunHrE.setText(miCursorLunes.getString(2));
            mLunHrS.setText(miCursorLunes.getString(3));
            mLunAula.setText(miCursorLunes.getString(4));
            if (mLunColor!=null) {
                mLunColor.setText(miCursorLunes.getString(5));
                linelunes.setBackgroundColor(Color.parseColor(miCursorLunes.getString(5)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria2.setText(miCursorLunes.getString(6));
            mLunProfe2.setText(miCursorLunes.getString(7));
            mLunHrE2.setText(miCursorLunes.getString(8));
            mLunHrS2.setText(miCursorLunes.getString(9));
            mLunAula2.setText(miCursorLunes.getString(10));
            if (mLunColor2!=null) {
                mLunColor2.setText(miCursorLunes.getString(11));
                linelunes2.setBackgroundColor(Color.parseColor(miCursorLunes.getString(11)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria3.setText(miCursorLunes.getString(12));
            mLunProfe3.setText(miCursorLunes.getString(13));
            mLunHrE3.setText(miCursorLunes.getString(14));
            mLunHrS3.setText(miCursorLunes.getString(15));
            mLunAula3.setText(miCursorLunes.getString(16));
            if (mLunColor3!=null) {
                mLunColor3.setText(miCursorLunes.getString(17));
                linelunes3.setBackgroundColor(Color.parseColor(miCursorLunes.getString(17)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria4.setText(miCursorLunes.getString(18));
            mLunProfe4.setText(miCursorLunes.getString(19));
            mLunHrE4.setText(miCursorLunes.getString(20));
            mLunHrS4.setText(miCursorLunes.getString(21));
            mLunAula4.setText(miCursorLunes.getString(22));
            if (mLunColor4!=null) {
                mLunColor4.setText(miCursorLunes.getString(23));
                linelunes4.setBackgroundColor(Color.parseColor(miCursorLunes.getString(23)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria5.setText(miCursorLunes.getString(24));
            mLunProfe5.setText(miCursorLunes.getString(25));
            mLunHrE5.setText(miCursorLunes.getString(26));
            mLunHrS5.setText(miCursorLunes.getString(27));
            mLunAula5.setText(miCursorLunes.getString(28));
            if (mLunColor5!=null) {
                mLunColor5.setText(miCursorLunes.getString(29));
                linelunes5.setBackgroundColor(Color.parseColor(miCursorLunes.getString(29)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria6.setText(miCursorLunes.getString(30));
            mLunProfe6.setText(miCursorLunes.getString(31));
            mLunHrE6.setText(miCursorLunes.getString(32));
            mLunHrS6.setText(miCursorLunes.getString(33));
            mLunAula6.setText(miCursorLunes.getString(34));

            if (mLunColor6!=null) {
                mLunColor6.setText(miCursorLunes.getString(35));
                linelunes6.setBackgroundColor(Color.parseColor(miCursorLunes.getString(35)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria7.setText(miCursorLunes.getString(36));
            mLunProfe7.setText(miCursorLunes.getString(37));
            mLunHrE7.setText(miCursorLunes.getString(38));
            mLunHrS7.setText(miCursorLunes.getString(39));
            mLunAula7.setText(miCursorLunes.getString(40));
            if (mLunColor7!=null) {
                mLunColor7.setText(miCursorLunes.getString(41));
                linelunes7.setBackgroundColor(Color.parseColor(miCursorLunes.getString(41)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorLunes = dby.rawQuery("SELECT * from LunesUno", null);
            miCursorLunes.moveToFirst();
            mLunMateria8.setText(miCursorLunes.getString(42));
            mLunProfe8.setText(miCursorLunes.getString(43));
            mLunHrE8.setText(miCursorLunes.getString(44));
            mLunHrS8.setText(miCursorLunes.getString(45));
            mLunAula8.setText(miCursorLunes.getString(46));
            if (mLunColor8!=null) {
                mLunColor8.setText(miCursorLunes.getString(47));
                linelunes8.setBackgroundColor(Color.parseColor(miCursorLunes.getString(47)));
            }

        } catch (Exception ex) {

        }


    }

    public void MostrarDBMartes() {
        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria.setText(miCursorMartes.getString(0));
            mMarProfe.setText(miCursorMartes.getString(1));
            mMarHrE.setText(miCursorMartes.getString(2));
            mMarHrS.setText(miCursorMartes.getString(3));
            mMarAula.setText(miCursorMartes.getString(4));
            if (mMarColor!=null) {
                mMarColor.setText(miCursorMartes.getString(5));
                linemartes.setBackgroundColor(Color.parseColor(miCursorMartes.getString(5)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria2.setText(miCursorMartes.getString(6));
            mMarProfe2.setText(miCursorMartes.getString(7));
            mMarHrE2.setText(miCursorMartes.getString(8));
            mMarHrS2.setText(miCursorMartes.getString(9));
            mMarAula2.setText(miCursorMartes.getString(10));
            if (mMarColor2!=null) {
                mMarColor2.setText(miCursorMartes.getString(11));
                linemartes2.setBackgroundColor(Color.parseColor(miCursorMartes.getString(11)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria3.setText(miCursorMartes.getString(12));
            mMarProfe3.setText(miCursorMartes.getString(13));
            mMarHrE3.setText(miCursorMartes.getString(14));
            mMarHrS3.setText(miCursorMartes.getString(15));
            mMarAula3.setText(miCursorMartes.getString(16));
            if (mMarColor3!=null) {
                mMarColor3.setText(miCursorMartes.getString(17));
                linemartes3.setBackgroundColor(Color.parseColor(miCursorMartes.getString(17)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria4.setText(miCursorMartes.getString(18));
            mMarProfe4.setText(miCursorMartes.getString(19));
            mMarHrE4.setText(miCursorMartes.getString(20));
            mMarHrS4.setText(miCursorMartes.getString(21));
            mMarAula4.setText(miCursorMartes.getString(22));
            if (mMarColor4!=null) {
                mMarColor4.setText(miCursorMartes.getString(23));
                linemartes4.setBackgroundColor(Color.parseColor(miCursorMartes.getString(23)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria5.setText(miCursorMartes.getString(24));
            mMarProfe5.setText(miCursorMartes.getString(25));
            mMarHrE5.setText(miCursorMartes.getString(26));
            mMarHrS5.setText(miCursorMartes.getString(27));
            mMarAula5.setText(miCursorMartes.getString(28));
            if (mMarColor5!=null) {
                mMarColor5.setText(miCursorMartes.getString(29));
                linemartes5.setBackgroundColor(Color.parseColor(miCursorMartes.getString(29)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria6.setText(miCursorMartes.getString(30));
            mMarProfe6.setText(miCursorMartes.getString(31));
            mMarHrE6.setText(miCursorMartes.getString(32));
            mMarHrS6.setText(miCursorMartes.getString(33));
            mMarAula6.setText(miCursorMartes.getString(34));
            if (mMarColor6!=null) {
                mMarColor6.setText(miCursorMartes.getString(35));
                linemartes6.setBackgroundColor(Color.parseColor(miCursorMartes.getString(35)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria7.setText(miCursorMartes.getString(36));
            mMarProfe7.setText(miCursorMartes.getString(37));
            mMarHrE7.setText(miCursorMartes.getString(38));
            mMarHrS7.setText(miCursorMartes.getString(39));
            mMarAula7.setText(miCursorMartes.getString(40));
            if (mMarColor7!=null) {
                mMarColor7.setText(miCursorMartes.getString(41));
                linemartes7.setBackgroundColor(Color.parseColor(miCursorMartes.getString(41)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMartes = dby.rawQuery("SELECT * from Martes", null);
            miCursorMartes.moveToFirst();
            mMarMateria8.setText(miCursorMartes.getString(42));
            mMarProfe8.setText(miCursorMartes.getString(43));
            mMarHrE8.setText(miCursorMartes.getString(44));
            mMarHrS8.setText(miCursorMartes.getString(45));
            mMarAula8.setText(miCursorMartes.getString(46));
            if (mMarColor8!=null) {
                mMarColor8.setText(miCursorMartes.getString(47));
                linemartes8.setBackgroundColor(Color.parseColor(miCursorMartes.getString(47)));
            }

        } catch (Exception ex) {
        }


    }

    public void MostrarDBMiercoles() {

        try {

            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria.setText(miCursorMiercoles.getString(0));
            mMieProfe.setText(miCursorMiercoles.getString(1));
            mMieHrE.setText(miCursorMiercoles.getString(2));
            mMieHrS.setText(miCursorMiercoles.getString(3));
            mMieAula.setText(miCursorMiercoles.getString(4));
            if (mMieColor!=null) {
                mMieColor.setText(miCursorMiercoles.getString(5));
                linemiercoles.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(5)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria2.setText(miCursorMiercoles.getString(6));
            mMieProfe2.setText(miCursorMiercoles.getString(7));
            mMieHrE2.setText(miCursorMiercoles.getString(8));
            mMieHrS2.setText(miCursorMiercoles.getString(9));
            mMieAula2.setText(miCursorMiercoles.getString(10));
            if (mMieColor2!=null) {
                mMieColor2.setText(miCursorMiercoles.getString(11));
                linemiercoles2.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(11)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria3.setText(miCursorMiercoles.getString(12));
            mMieProfe3.setText(miCursorMiercoles.getString(13));
            mMieHrE3.setText(miCursorMiercoles.getString(14));
            mMieHrS3.setText(miCursorMiercoles.getString(15));
            mMieAula3.setText(miCursorMiercoles.getString(16));
            if (mMieColor3!=null) {
                mMieColor3.setText(miCursorMiercoles.getString(17));
                linemiercoles3.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(17)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria4.setText(miCursorMiercoles.getString(18));
            mMieProfe4.setText(miCursorMiercoles.getString(19));
            mMieHrE4.setText(miCursorMiercoles.getString(20));
            mMieHrS4.setText(miCursorMiercoles.getString(21));
            mMieAula4.setText(miCursorMiercoles.getString(22));
            if (mMieColor4!=null) {
                mMieColor4.setText(miCursorMiercoles.getString(23));
                linemiercoles4.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(23)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria5.setText(miCursorMiercoles.getString(24));
            mMieProfe5.setText(miCursorMiercoles.getString(25));
            mMieHrE5.setText(miCursorMiercoles.getString(26));
            mMieHrS5.setText(miCursorMiercoles.getString(27));
            mMieAula5.setText(miCursorMiercoles.getString(28));
            if (mMieColor5!=null) {
                mMieColor5.setText(miCursorMiercoles.getString(29));
                linemiercoles5.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(29)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria6.setText(miCursorMiercoles.getString(30));
            mMieProfe6.setText(miCursorMiercoles.getString(31));
            mMieHrE6.setText(miCursorMiercoles.getString(32));
            mMieHrS6.setText(miCursorMiercoles.getString(33));
            mMieAula6.setText(miCursorMiercoles.getString(34));
            if (mMieColor6!=null) {
                mMieColor6.setText(miCursorMiercoles.getString(35));
                linemiercoles6.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(35)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria7.setText(miCursorMiercoles.getString(36));
            mMieProfe7.setText(miCursorMiercoles.getString(37));
            mMieHrE7.setText(miCursorMiercoles.getString(38));
            mMieHrS7.setText(miCursorMiercoles.getString(39));
            mMieAula7.setText(miCursorMiercoles.getString(40));
            if (mMieColor7!=null) {
                mMieColor7.setText(miCursorMiercoles.getString(41));
                linemiercoles7.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(41)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorMiercoles = dby.rawQuery("SELECT * from Miercoles", null);
            miCursorMiercoles.moveToFirst();
            mMieMateria8.setText(miCursorMiercoles.getString(42));
            mMieProfe8.setText(miCursorMiercoles.getString(43));
            mMieHrE8.setText(miCursorMiercoles.getString(44));
            mMieHrS8.setText(miCursorMiercoles.getString(45));
            mMieAula8.setText(miCursorMiercoles.getString(46));
            if (mMieColor8!=null) {
                mMieColor8.setText(miCursorMiercoles.getString(47));
                linemiercoles8.setBackgroundColor(Color.parseColor(miCursorMiercoles.getString(47)));
            }

        } catch (Exception ex) {

        }


    }

    public void MostrarDBJueves() {

        try {

            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria.setText(miCursorJueves.getString(0));
            mJueProfe.setText(miCursorJueves.getString(1));
            mJueHrE.setText(miCursorJueves.getString(2));
            mJueHrS.setText(miCursorJueves.getString(3));
            mJueAula.setText(miCursorJueves.getString(4));
            if (mJueColor!=null) {
                mJueColor.setText(miCursorJueves.getString(5));
                linejueves.setBackgroundColor(Color.parseColor(miCursorJueves.getString(5)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria2.setText(miCursorJueves.getString(6));
            mJueProfe2.setText(miCursorJueves.getString(7));
            mJueHrE2.setText(miCursorJueves.getString(8));
            mJueHrS2.setText(miCursorJueves.getString(9));
            mJueAula2.setText(miCursorJueves.getString(10));
            if (mJueColor2!=null) {
                mJueColor2.setText(miCursorJueves.getString(11));
                linejueves2.setBackgroundColor(Color.parseColor(miCursorJueves.getString(11)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria3.setText(miCursorJueves.getString(12));
            mJueProfe3.setText(miCursorJueves.getString(13));
            mJueHrE3.setText(miCursorJueves.getString(14));
            mJueHrS3.setText(miCursorJueves.getString(15));
            mJueAula3.setText(miCursorJueves.getString(16));
            if (mJueColor3!=null) {
                mJueColor3.setText(miCursorJueves.getString(17));
                linejueves3.setBackgroundColor(Color.parseColor(miCursorJueves.getString(17)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria4.setText(miCursorJueves.getString(18));
            mJueProfe4.setText(miCursorJueves.getString(19));
            mJueHrE4.setText(miCursorJueves.getString(20));
            mJueHrS4.setText(miCursorJueves.getString(21));
            mJueAula4.setText(miCursorJueves.getString(22));
            if (mJueColor4!=null) {
                mJueColor4.setText(miCursorJueves.getString(23));
                linejueves4.setBackgroundColor(Color.parseColor(miCursorJueves.getString(23)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria5.setText(miCursorJueves.getString(24));
            mJueProfe5.setText(miCursorJueves.getString(25));
            mJueHrE5.setText(miCursorJueves.getString(26));
            mJueHrS5.setText(miCursorJueves.getString(27));
            mJueAula5.setText(miCursorJueves.getString(28));
            if (mJueColor5!=null) {
                mJueColor5.setText(miCursorJueves.getString(29));
                linejueves5.setBackgroundColor(Color.parseColor(miCursorJueves.getString(29)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria6.setText(miCursorJueves.getString(30));
            mJueProfe6.setText(miCursorJueves.getString(31));
            mJueHrE6.setText(miCursorJueves.getString(32));
            mJueHrS6.setText(miCursorJueves.getString(33));
            mJueAula6.setText(miCursorJueves.getString(34));
            if (mJueColor6!=null) {
                mJueColor6.setText(miCursorJueves.getString(35));
                linejueves6.setBackgroundColor(Color.parseColor(miCursorJueves.getString(35)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria7.setText(miCursorJueves.getString(36));
            mJueProfe7.setText(miCursorJueves.getString(37));
            mJueHrE7.setText(miCursorJueves.getString(38));
            mJueHrS7.setText(miCursorJueves.getString(39));
            mJueAula7.setText(miCursorJueves.getString(40));
            if (mJueColor7!=null) {
                mJueColor7.setText(miCursorJueves.getString(41));
                linejueves7.setBackgroundColor(Color.parseColor(miCursorJueves.getString(41)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorJueves = dby.rawQuery("SELECT * from Jueves", null);
            miCursorJueves.moveToFirst();
            mJueMateria8.setText(miCursorJueves.getString(42));
            mJueProfe8.setText(miCursorJueves.getString(43));
            mJueHrE8.setText(miCursorJueves.getString(44));
            mJueHrS8.setText(miCursorJueves.getString(45));
            mJueAula8.setText(miCursorJueves.getString(46));
            if (mJueColor8!=null) {
                mJueColor8.setText(miCursorJueves.getString(47));
                linejueves8.setBackgroundColor(Color.parseColor(miCursorJueves.getString(48)));
            }

        } catch (Exception ex) {

        }


    }

    public void MostrarDBViernes() {

        try {

            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria.setText(miCursorViernes.getString(0));
            mVieProfe.setText(miCursorViernes.getString(1));
            mVieHrE.setText(miCursorViernes.getString(2));
            mVieHrS.setText(miCursorViernes.getString(3));
            mVieAula.setText(miCursorViernes.getString(4));
            if (mVieColor!=null) {
                mVieColor.setText(miCursorViernes.getString(5));
                lineviernes.setBackgroundColor(Color.parseColor(miCursorViernes.getString(5)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria2.setText(miCursorViernes.getString(6));
            mVieProfe2.setText(miCursorViernes.getString(7));
            mVieHrE2.setText(miCursorViernes.getString(8));
            mVieHrS2.setText(miCursorViernes.getString(9));
            mVieAula2.setText(miCursorViernes.getString(10));
            if (mVieColor2!=null) {
                mVieColor2.setText(miCursorViernes.getString(11));
                lineviernes2.setBackgroundColor(Color.parseColor(miCursorViernes.getString(11)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria3.setText(miCursorViernes.getString(12));
            mVieProfe3.setText(miCursorViernes.getString(13));
            mVieHrE3.setText(miCursorViernes.getString(14));
            mVieHrS3.setText(miCursorViernes.getString(15));
            mVieAula3.setText(miCursorViernes.getString(16));
            if (mVieColor3!=null) {
                mVieColor3.setText(miCursorViernes.getString(17));
                lineviernes3.setBackgroundColor(Color.parseColor(miCursorViernes.getString(17)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria4.setText(miCursorViernes.getString(18));
            mVieProfe4.setText(miCursorViernes.getString(19));
            mVieHrE4.setText(miCursorViernes.getString(20));
            mVieHrS4.setText(miCursorViernes.getString(21));
            mVieAula4.setText(miCursorViernes.getString(22));
            if (mVieColor4!=null) {
                mVieColor4.setText(miCursorViernes.getString(23));
                lineviernes4.setBackgroundColor(Color.parseColor(miCursorViernes.getString(23)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria5.setText(miCursorViernes.getString(24));
            mVieProfe5.setText(miCursorViernes.getString(25));
            mVieHrE5.setText(miCursorViernes.getString(26));
            mVieHrS5.setText(miCursorViernes.getString(27));
            mVieAula5.setText(miCursorViernes.getString(28));
            if (mVieColor5!=null) {
                mVieColor5.setText(miCursorViernes.getString(29));
                lineviernes5.setBackgroundColor(Color.parseColor(miCursorViernes.getString(29)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria6.setText(miCursorViernes.getString(30));
            mVieProfe6.setText(miCursorViernes.getString(31));
            mVieHrE6.setText(miCursorViernes.getString(32));
            mVieHrS6.setText(miCursorViernes.getString(33));
            mVieAula6.setText(miCursorViernes.getString(34));
            if (mVieColor6!=null) {
                mVieColor6.setText(miCursorViernes.getString(35));
                lineviernes6.setBackgroundColor(Color.parseColor(miCursorViernes.getString(35)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria7.setText(miCursorViernes.getString(36));
            mVieProfe7.setText(miCursorViernes.getString(37));
            mVieHrE7.setText(miCursorViernes.getString(38));
            mVieHrS7.setText(miCursorViernes.getString(39));
            mVieAula7.setText(miCursorViernes.getString(40));
            if (mVieColor7!=null) {
                mVieColor7.setText(miCursorViernes.getString(41));
                lineviernes7.setBackgroundColor(Color.parseColor(miCursorViernes.getString(41)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorViernes = dby.rawQuery("SELECT * from Viernes", null);
            miCursorViernes.moveToFirst();
            mVieMateria8.setText(miCursorViernes.getString(42));
            mVieProfe8.setText(miCursorViernes.getString(43));
            mVieHrE8.setText(miCursorViernes.getString(44));
            mVieHrS8.setText(miCursorViernes.getString(45));
            mVieAula8.setText(miCursorViernes.getString(46));
            if (mVieColor8!=null) {
                mVieColor8.setText(miCursorViernes.getString(47));
                lineviernes8.setBackgroundColor(Color.parseColor(miCursorViernes.getString(47)));
            }

        } catch (Exception ex) {

        }


    }

    public void MostrarDBSabado() {

        try {

            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria.setText(miCursorSabado.getString(0));
            mSabProfe.setText(miCursorSabado.getString(1));
            mSabHrE.setText(miCursorSabado.getString(2));
            mSabHrS.setText(miCursorSabado.getString(3));
            mSabAula.setText(miCursorSabado.getString(4));
            if (mSabColor!=null) {
                mSabColor.setText(miCursorSabado.getString(5));
                linesabado.setBackgroundColor(Color.parseColor(miCursorSabado.getString(5)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria2.setText(miCursorSabado.getString(6));
            mSabProfe2.setText(miCursorSabado.getString(7));
            mSabHrE2.setText(miCursorSabado.getString(8));
            mSabHrS2.setText(miCursorSabado.getString(9));
            mSabAula2.setText(miCursorSabado.getString(10));
            if (mSabColor2!=null) {
                mSabColor2.setText(miCursorSabado.getString(11));
                linesabado2.setBackgroundColor(Color.parseColor(miCursorSabado.getString(11)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria3.setText(miCursorSabado.getString(12));
            mSabProfe3.setText(miCursorSabado.getString(13));
            mSabHrE3.setText(miCursorSabado.getString(14));
            mSabHrS3.setText(miCursorSabado.getString(15));
            mSabAula3.setText(miCursorSabado.getString(16));
            if (mSabColor3!=null) {
                mSabColor3.setText(miCursorSabado.getString(17));
                linesabado3.setBackgroundColor(Color.parseColor(miCursorSabado.getString(17)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria4.setText(miCursorSabado.getString(18));
            mSabProfe4.setText(miCursorSabado.getString(19));
            mSabHrE4.setText(miCursorSabado.getString(20));
            mSabHrS4.setText(miCursorSabado.getString(21));
            mSabAula4.setText(miCursorSabado.getString(22));
            if (mSabColor4!=null) {
                mSabColor4.setText(miCursorSabado.getString(23));
                linesabado4.setBackgroundColor(Color.parseColor(miCursorSabado.getString(23)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria5.setText(miCursorSabado.getString(24));
            mSabProfe5.setText(miCursorSabado.getString(25));
            mSabHrE5.setText(miCursorSabado.getString(26));
            mSabHrS5.setText(miCursorSabado.getString(27));
            mSabAula5.setText(miCursorSabado.getString(28));
            if (mSabColor5!=null) {
                mSabColor5.setText(miCursorSabado.getString(29));
                linesabado5.setBackgroundColor(Color.parseColor(miCursorSabado.getString(29)));
            }

        } catch (Exception ex) {
        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria6.setText(miCursorSabado.getString(30));
            mSabProfe6.setText(miCursorSabado.getString(31));
            mSabHrE6.setText(miCursorSabado.getString(32));
            mSabHrS6.setText(miCursorSabado.getString(33));
            mSabAula6.setText(miCursorSabado.getString(34));
            if (mSabColor6!=null) {
                mSabColor6.setText(miCursorSabado.getString(35));
                linesabado6.setBackgroundColor(Color.parseColor(miCursorSabado.getString(35)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria7.setText(miCursorSabado.getString(36));
            mSabProfe7.setText(miCursorSabado.getString(37));
            mSabHrE7.setText(miCursorSabado.getString(38));
            mSabHrS7.setText(miCursorSabado.getString(39));
            mSabAula7.setText(miCursorSabado.getString(40));
            if (mSabColor7!=null) {
                mSabColor7.setText(miCursorSabado.getString(41));
                linesabado7.setBackgroundColor(Color.parseColor(miCursorSabado.getString(41)));
            }

        } catch (Exception ex) {

        }

        try {
            miCursorSabado = dby.rawQuery("SELECT * from Sabado", null);
            miCursorSabado.moveToFirst();
            mSabMateria8.setText(miCursorSabado.getString(42));
            mSabProfe8.setText(miCursorSabado.getString(43));
            mSabHrE8.setText(miCursorSabado.getString(44));
            mSabHrS8.setText(miCursorSabado.getString(45));
            mSabAula8.setText(miCursorSabado.getString(46));
            if (mSabColor8!=null) {
                mSabColor8.setText(miCursorSabado.getString(47));
                linesabado8.setBackgroundColor(Color.parseColor(miCursorSabado.getString(47)));
            }

        } catch (Exception ex) {

        }


    }


/*
    public void Insertar(View insertar) {


        try {
            dby.execSQL("INSERT into tablita values ");

            MostrarDB();
        } catch (Exception eInsert) {
            Toast.makeText(HorarioPersonalizado.this, eInsert.getMessage(), Toast.LENGTH_LONG).show();

        }

    }
*/



    public void lunesMateriasLay(){

        mLunMateria.setVisibility(View.VISIBLE);
        mLunProfe.setVisibility(View.VISIBLE);
        mLunHrE.setVisibility(View.VISIBLE);
        mLunHrS.setVisibility(View.VISIBLE);
        mLunAula.setVisibility(View.VISIBLE);

        mLunMateria2.setVisibility(View.VISIBLE);
        mLunProfe2.setVisibility(View.VISIBLE);
        mLunHrE2.setVisibility(View.VISIBLE);
        mLunHrS2.setVisibility(View.VISIBLE);
        mLunAula2.setVisibility(View.VISIBLE);


        mLunMateria3.setVisibility(View.VISIBLE);
        mLunProfe3.setVisibility(View.VISIBLE);
        mLunHrE3.setVisibility(View.VISIBLE);
        mLunHrS3.setVisibility(View.VISIBLE);
        mLunAula3.setVisibility(View.VISIBLE);

        mLunMateria4.setVisibility(View.VISIBLE);
        mLunProfe4.setVisibility(View.VISIBLE);
        mLunHrE4.setVisibility(View.VISIBLE);
        mLunHrS4.setVisibility(View.VISIBLE);
        mLunAula4.setVisibility(View.VISIBLE);

        mLunMateria5.setVisibility(View.VISIBLE);
        mLunProfe5.setVisibility(View.VISIBLE);
        mLunHrE5.setVisibility(View.VISIBLE);
        mLunHrS5.setVisibility(View.VISIBLE);
        mLunAula5.setVisibility(View.VISIBLE);

        mLunMateria6.setVisibility(View.VISIBLE);
        mLunProfe6.setVisibility(View.VISIBLE);
        mLunHrE6.setVisibility(View.VISIBLE);
        mLunHrS6.setVisibility(View.VISIBLE);
        mLunAula6.setVisibility(View.VISIBLE);

        mLunMateria7.setVisibility(View.VISIBLE);
        mLunProfe7.setVisibility(View.VISIBLE);
        mLunHrE7.setVisibility(View.VISIBLE);
        mLunHrS7.setVisibility(View.VISIBLE);
        mLunAula7.setVisibility(View.VISIBLE);

        mLunMateria8.setVisibility(View.VISIBLE);
        mLunProfe8.setVisibility(View.VISIBLE);
        mLunHrE8.setVisibility(View.VISIBLE);
        mLunHrS8.setVisibility(View.VISIBLE);
        mLunAula8.setVisibility(View.VISIBLE);


        linelunes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura1='");
                bundle.putString("profesor", "Profesor1='");
                bundle.putString("horaE", "HrE1='");
                bundle.putString("horaS", "HrS1='");
                bundle.putString("aula", "Aula1='");
                bundle.putString("color", "Color1='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura2='");
                bundle.putString("profesor", "Profesor2='");
                bundle.putString("horaE", "HrE2='");
                bundle.putString("horaS", "HrS2='");
                bundle.putString("aula", "Aula2='");
                bundle.putString("color", "Color2='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura3='");
                bundle.putString("profesor", "Profesor3='");
                bundle.putString("horaE", "HrE3='");
                bundle.putString("horaS", "HrS3='");
                bundle.putString("aula", "Aula3='");
                bundle.putString("color", "Color3='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura4='");
                bundle.putString("profesor", "Profesor4='");
                bundle.putString("horaE", "HrE4='");
                bundle.putString("horaS", "HrS4='");
                bundle.putString("aula", "Aula4='");
                bundle.putString("color", "Color4='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura5='");
                bundle.putString("profesor", "Profesor5='");
                bundle.putString("horaE", "HrE5='");
                bundle.putString("horaS", "HrS5='");
                bundle.putString("aula", "Aula5='");
                bundle.putString("color", "Color5='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura6='");
                bundle.putString("profesor", "Profesor6='");
                bundle.putString("horaE", "HrE6='");
                bundle.putString("horaS", "HrS6='");
                bundle.putString("aula", "Aula6='");
                bundle.putString("color", "Color6='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura7='");
                bundle.putString("profesor", "Profesor7='");
                bundle.putString("horaE", "HrE7='");
                bundle.putString("horaS", "HrS7='");
                bundle.putString("aula", "Aula7='");
                bundle.putString("color", "Color7='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linelunes8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","LunesUno");

                bundle.putString("materia", "Asignatura8='");
                bundle.putString("profesor", "Profesor8='");
                bundle.putString("horaE", "HrE8='");
                bundle.putString("horaS", "HrS8='");
                bundle.putString("aula", "Aula8='");
                bundle.putString("color", "Color8='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });
    }

    public void martesMateriasLay(){

        mMarMateria.setVisibility(View.VISIBLE);
        mMarProfe.setVisibility(View.VISIBLE);
        mMarHrE.setVisibility(View.VISIBLE);
        mMarHrS.setVisibility(View.VISIBLE);
        mMarAula.setVisibility(View.VISIBLE);

        mMarMateria2.setVisibility(View.VISIBLE);
        mMarProfe2.setVisibility(View.VISIBLE);
        mMarHrE2.setVisibility(View.VISIBLE);
        mMarHrS2.setVisibility(View.VISIBLE);
        mMarAula2.setVisibility(View.VISIBLE);

        mMarMateria3.setVisibility(View.VISIBLE);
        mMarProfe3.setVisibility(View.VISIBLE);
        mMarHrE3.setVisibility(View.VISIBLE);
        mMarHrS3.setVisibility(View.VISIBLE);
        mMarAula3.setVisibility(View.VISIBLE);

        mMarMateria4.setVisibility(View.VISIBLE);
        mMarProfe4.setVisibility(View.VISIBLE);
        mMarHrE4.setVisibility(View.VISIBLE);
        mMarHrS4.setVisibility(View.VISIBLE);
        mMarAula4.setVisibility(View.VISIBLE);

        mMarMateria5.setVisibility(View.VISIBLE);
        mMarProfe5.setVisibility(View.VISIBLE);
        mMarHrE5.setVisibility(View.VISIBLE);
        mMarHrS5.setVisibility(View.VISIBLE);
        mMarAula5.setVisibility(View.VISIBLE);

        mMarMateria6.setVisibility(View.VISIBLE);
        mMarProfe6.setVisibility(View.VISIBLE);
        mMarHrE6.setVisibility(View.VISIBLE);
        mMarHrS6.setVisibility(View.VISIBLE);
        mMarAula6.setVisibility(View.VISIBLE);

        mMarMateria7.setVisibility(View.VISIBLE);
        mMarProfe7.setVisibility(View.VISIBLE);
        mMarHrE7.setVisibility(View.VISIBLE);
        mMarHrS7.setVisibility(View.VISIBLE);
        mMarAula7.setVisibility(View.VISIBLE);

        mMarMateria8.setVisibility(View.VISIBLE);
        mMarProfe8.setVisibility(View.VISIBLE);
        mMarHrE8.setVisibility(View.VISIBLE);
        mMarHrS8.setVisibility(View.VISIBLE);
        mMarAula8.setVisibility(View.VISIBLE);


        linemartes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura1='");
                bundle.putString("profesor", "Profesor1='");
                bundle.putString("horaE", "HrE1='");
                bundle.putString("horaS", "HrS1='");
                bundle.putString("aula", "Aula1='");
                bundle.putString("color", "Color1='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura2='");
                bundle.putString("profesor", "Profesor2='");
                bundle.putString("horaE", "HrE2='");
                bundle.putString("horaS", "HrS2='");
                bundle.putString("aula", "Aula2='");
                bundle.putString("color", "Color2='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura3='");
                bundle.putString("profesor", "Profesor3='");
                bundle.putString("horaE", "HrE3='");
                bundle.putString("horaS", "HrS3='");
                bundle.putString("aula", "Aula3='");
                bundle.putString("color", "Color3='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura4='");
                bundle.putString("profesor", "Profesor4='");
                bundle.putString("horaE", "HrE4='");
                bundle.putString("horaS", "HrS4='");
                bundle.putString("aula", "Aula4='");
                bundle.putString("color", "Color4='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura5='");
                bundle.putString("profesor", "Profesor5='");
                bundle.putString("horaE", "HrE5='");
                bundle.putString("horaS", "HrS5='");
                bundle.putString("aula", "Aula5='");
                bundle.putString("color", "Color5='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura6='");
                bundle.putString("profesor", "Profesor6='");
                bundle.putString("horaE", "HrE6='");
                bundle.putString("horaS", "HrS6='");
                bundle.putString("aula", "Aula6='");
                bundle.putString("color", "Color6='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura7='");
                bundle.putString("profesor", "Profesor7='");
                bundle.putString("horaE", "HrE7='");
                bundle.putString("horaS", "HrS7='");
                bundle.putString("aula", "Aula7='");
                bundle.putString("color", "Color7='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemartes8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Martes");

                bundle.putString("materia", "Asignatura8='");
                bundle.putString("profesor", "Profesor8='");
                bundle.putString("horaE", "HrE8='");
                bundle.putString("horaS", "HrS8='");
                bundle.putString("aula", "Aula8='");
                bundle.putString("color", "Color8='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });
    }

    public void miercolesMateriasLay(){

        mMieMateria.setVisibility(View.VISIBLE);
        mMieProfe.setVisibility(View.VISIBLE);
        mMieHrE.setVisibility(View.VISIBLE);
        mMieHrS.setVisibility(View.VISIBLE);
        mMieAula.setVisibility(View.VISIBLE);

        mMieMateria2.setVisibility(View.VISIBLE);
        mMieProfe2.setVisibility(View.VISIBLE);
        mMieHrE2.setVisibility(View.VISIBLE);
        mMieHrS2.setVisibility(View.VISIBLE);
        mMieAula2.setVisibility(View.VISIBLE);


        mMieMateria3.setVisibility(View.VISIBLE);
        mMieProfe3.setVisibility(View.VISIBLE);
        mMieHrE3.setVisibility(View.VISIBLE);
        mMieHrS3.setVisibility(View.VISIBLE);
        mMieAula3.setVisibility(View.VISIBLE);

        mMieMateria4.setVisibility(View.VISIBLE);
        mMieProfe4.setVisibility(View.VISIBLE);
        mMieHrE4.setVisibility(View.VISIBLE);
        mMieHrS4.setVisibility(View.VISIBLE);
        mMieAula4.setVisibility(View.VISIBLE);

        mMieMateria5.setVisibility(View.VISIBLE);
        mMieProfe5.setVisibility(View.VISIBLE);
        mMieHrE5.setVisibility(View.VISIBLE);
        mMieHrS5.setVisibility(View.VISIBLE);
        mMieAula5.setVisibility(View.VISIBLE);

        mMieMateria6.setVisibility(View.VISIBLE);
        mMieProfe6.setVisibility(View.VISIBLE);
        mMieHrE6.setVisibility(View.VISIBLE);
        mMieHrS6.setVisibility(View.VISIBLE);
        mMieAula6.setVisibility(View.VISIBLE);

        mMieMateria7.setVisibility(View.VISIBLE);
        mMieProfe7.setVisibility(View.VISIBLE);
        mMieHrE7.setVisibility(View.VISIBLE);
        mMieHrS7.setVisibility(View.VISIBLE);
        mMieAula7.setVisibility(View.VISIBLE);

        mMieMateria8.setVisibility(View.VISIBLE);
        mMieProfe8.setVisibility(View.VISIBLE);
        mMieHrE8.setVisibility(View.VISIBLE);
        mMieHrS8.setVisibility(View.VISIBLE);
        mMieAula8.setVisibility(View.VISIBLE);


        linemiercoles.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura1='");
                bundle.putString("profesor", "Profesor1='");
                bundle.putString("horaE", "HrE1='");
                bundle.putString("horaS", "HrS1='");
                bundle.putString("aula", "Aula1='");
                bundle.putString("color", "Color1='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemiercoles2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura2='");
                bundle.putString("profesor", "Profesor2='");
                bundle.putString("horaE", "HrE2='");
                bundle.putString("horaS", "HrS2='");
                bundle.putString("aula", "Aula2='");
                bundle.putString("color", "Color2='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog


            }
        });

        linemiercoles3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura3='");
                bundle.putString("profesor", "Profesor3='");
                bundle.putString("horaE", "HrE3='");
                bundle.putString("horaS", "HrS3='");
                bundle.putString("aula", "Aula3='");
                bundle.putString("color", "Color3='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemiercoles4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura4='");
                bundle.putString("profesor", "Profesor4='");
                bundle.putString("horaE", "HrE4='");
                bundle.putString("horaS", "HrS4='");
                bundle.putString("aula", "Aula4='");
                bundle.putString("color", "Color4='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemiercoles5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura5='");
                bundle.putString("profesor", "Profesor5='");
                bundle.putString("horaE", "HrE5='");
                bundle.putString("horaS", "HrS5='");
                bundle.putString("aula", "Aula5='");
                bundle.putString("color", "Color5='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemiercoles6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura6='");
                bundle.putString("profesor", "Profesor6='");
                bundle.putString("horaE", "HrE6='");
                bundle.putString("horaS", "HrS6='");
                bundle.putString("aula", "Aula6='");
                bundle.putString("color", "Color6='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemiercoles7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura7='");
                bundle.putString("profesor", "Profesor7='");
                bundle.putString("horaE", "HrE7='");
                bundle.putString("horaS", "HrS7='");
                bundle.putString("aula", "Aula7='");
                bundle.putString("color", "Color7='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linemiercoles8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Miercoles");

                bundle.putString("materia", "Asignatura8='");
                bundle.putString("profesor", "Profesor8='");
                bundle.putString("horaE", "HrE8='");
                bundle.putString("horaS", "HrS8='");
                bundle.putString("aula", "Aula8='");
                bundle.putString("color", "Color8='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });
    }

    public void juevesMateriasLay(){

        mJueMateria.setVisibility(View.VISIBLE);
        mJueProfe.setVisibility(View.VISIBLE);
        mJueHrE.setVisibility(View.VISIBLE);
        mJueHrS.setVisibility(View.VISIBLE);
        mJueAula.setVisibility(View.VISIBLE);

        mJueMateria2.setVisibility(View.VISIBLE);
        mJueProfe2.setVisibility(View.VISIBLE);
        mJueHrE2.setVisibility(View.VISIBLE);
        mJueHrS2.setVisibility(View.VISIBLE);
        mJueAula2.setVisibility(View.VISIBLE);


        mJueMateria3.setVisibility(View.VISIBLE);
        mJueProfe3.setVisibility(View.VISIBLE);
        mJueHrE3.setVisibility(View.VISIBLE);
        mJueHrS3.setVisibility(View.VISIBLE);
        mJueAula3.setVisibility(View.VISIBLE);

        mJueMateria4.setVisibility(View.VISIBLE);
        mJueProfe4.setVisibility(View.VISIBLE);
        mJueHrE4.setVisibility(View.VISIBLE);
        mJueHrS4.setVisibility(View.VISIBLE);
        mJueAula4.setVisibility(View.VISIBLE);

        mJueMateria5.setVisibility(View.VISIBLE);
        mJueProfe5.setVisibility(View.VISIBLE);
        mJueHrE5.setVisibility(View.VISIBLE);
        mJueHrS5.setVisibility(View.VISIBLE);
        mJueAula5.setVisibility(View.VISIBLE);

        mJueMateria6.setVisibility(View.VISIBLE);
        mJueProfe6.setVisibility(View.VISIBLE);
        mJueHrE6.setVisibility(View.VISIBLE);
        mJueHrS6.setVisibility(View.VISIBLE);
        mJueAula6.setVisibility(View.VISIBLE);

        mJueMateria7.setVisibility(View.VISIBLE);
        mJueProfe7.setVisibility(View.VISIBLE);
        mJueHrE7.setVisibility(View.VISIBLE);
        mJueHrS7.setVisibility(View.VISIBLE);
        mJueAula7.setVisibility(View.VISIBLE);

        mJueMateria8.setVisibility(View.VISIBLE);
        mJueProfe8.setVisibility(View.VISIBLE);
        mJueHrE8.setVisibility(View.VISIBLE);
        mJueHrS8.setVisibility(View.VISIBLE);
        mJueAula8.setVisibility(View.VISIBLE);


        linejueves.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura1='");
                bundle.putString("profesor", "Profesor1='");
                bundle.putString("horaE", "HrE1='");
                bundle.putString("horaS", "HrS1='");
                bundle.putString("aula", "Aula1='");
                bundle.putString("color", "Color1='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura2='");
                bundle.putString("profesor", "Profesor2='");
                bundle.putString("horaE", "HrE2='");
                bundle.putString("horaS", "HrS2='");
                bundle.putString("aula", "Aula2='");
                bundle.putString("color", "Color2='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura3='");
                bundle.putString("profesor", "Profesor3='");
                bundle.putString("horaE", "HrE3='");
                bundle.putString("horaS", "HrS3='");
                bundle.putString("aula", "Aula3='");
                bundle.putString("color", "Color3='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura4='");
                bundle.putString("profesor", "Profesor4='");
                bundle.putString("horaE", "HrE4='");
                bundle.putString("horaS", "HrS4='");
                bundle.putString("aula", "Aula4='");
                bundle.putString("color", "Color4='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura5='");
                bundle.putString("profesor", "Profesor5='");
                bundle.putString("horaE", "HrE5='");
                bundle.putString("horaS", "HrS5='");
                bundle.putString("aula", "Aula5='");
                bundle.putString("color", "Color5='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura6='");
                bundle.putString("profesor", "Profesor6='");
                bundle.putString("horaE", "HrE6='");
                bundle.putString("horaS", "HrS6='");
                bundle.putString("aula", "Aula6='");
                bundle.putString("color", "Color6='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura7='");
                bundle.putString("profesor", "Profesor7='");
                bundle.putString("horaE", "HrE7='");
                bundle.putString("horaS", "HrS7='");
                bundle.putString("aula", "Aula7='");
                bundle.putString("color", "Color7='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linejueves8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Jueves");

                bundle.putString("materia", "Asignatura8='");
                bundle.putString("profesor", "Profesor8='");
                bundle.putString("horaE", "HrE8='");
                bundle.putString("horaS", "HrS8='");
                bundle.putString("aula", "Aula8='");
                bundle.putString("color", "Color8='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });
    }

    public void viernesMateriasLay(){

        mVieMateria.setVisibility(View.VISIBLE);
        mVieProfe.setVisibility(View.VISIBLE);
        mVieHrE.setVisibility(View.VISIBLE);
        mVieHrS.setVisibility(View.VISIBLE);
        mVieAula.setVisibility(View.VISIBLE);

        mVieMateria2.setVisibility(View.VISIBLE);
        mVieProfe2.setVisibility(View.VISIBLE);
        mVieHrE2.setVisibility(View.VISIBLE);
        mVieHrS2.setVisibility(View.VISIBLE);
        mVieAula2.setVisibility(View.VISIBLE);


        mVieMateria3.setVisibility(View.VISIBLE);
        mVieProfe3.setVisibility(View.VISIBLE);
        mVieHrE3.setVisibility(View.VISIBLE);
        mVieHrS3.setVisibility(View.VISIBLE);
        mVieAula3.setVisibility(View.VISIBLE);

        mVieMateria4.setVisibility(View.VISIBLE);
        mVieProfe4.setVisibility(View.VISIBLE);
        mVieHrE4.setVisibility(View.VISIBLE);
        mVieHrS4.setVisibility(View.VISIBLE);
        mVieAula4.setVisibility(View.VISIBLE);

        mVieMateria5.setVisibility(View.VISIBLE);
        mVieProfe5.setVisibility(View.VISIBLE);
        mVieHrE5.setVisibility(View.VISIBLE);
        mVieHrS5.setVisibility(View.VISIBLE);
        mVieAula5.setVisibility(View.VISIBLE);

        mVieMateria6.setVisibility(View.VISIBLE);
        mVieProfe6.setVisibility(View.VISIBLE);
        mVieHrE6.setVisibility(View.VISIBLE);
        mVieHrS6.setVisibility(View.VISIBLE);
        mVieAula6.setVisibility(View.VISIBLE);

        mVieMateria7.setVisibility(View.VISIBLE);
        mVieProfe7.setVisibility(View.VISIBLE);
        mVieHrE7.setVisibility(View.VISIBLE);
        mVieHrS7.setVisibility(View.VISIBLE);
        mVieAula7.setVisibility(View.VISIBLE);

        mVieMateria8.setVisibility(View.VISIBLE);
        mVieProfe8.setVisibility(View.VISIBLE);
        mVieHrE8.setVisibility(View.VISIBLE);
        mVieHrS8.setVisibility(View.VISIBLE);
        mVieAula8.setVisibility(View.VISIBLE);


        lineviernes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura1='");
                bundle.putString("profesor", "Profesor1='");
                bundle.putString("horaE", "HrE1='");
                bundle.putString("horaS", "HrS1='");
                bundle.putString("aula", "Aula1='");
                bundle.putString("color", "Color1='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura2='");
                bundle.putString("profesor", "Profesor2='");
                bundle.putString("horaE", "HrE2='");
                bundle.putString("horaS", "HrS2='");
                bundle.putString("aula", "Aula2='");
                bundle.putString("color", "Color2='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura3='");
                bundle.putString("profesor", "Profesor3='");
                bundle.putString("horaE", "HrE3='");
                bundle.putString("horaS", "HrS3='");
                bundle.putString("aula", "Aula3='");
                bundle.putString("color", "Color3='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura4='");
                bundle.putString("profesor", "Profesor4='");
                bundle.putString("horaE", "HrE4='");
                bundle.putString("horaS", "HrS4='");
                bundle.putString("aula", "Aula4='");
                bundle.putString("color", "Color4='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura5='");
                bundle.putString("profesor", "Profesor5='");
                bundle.putString("horaE", "HrE5='");
                bundle.putString("horaS", "HrS5='");
                bundle.putString("aula", "Aula5='");
                bundle.putString("color", "Color5='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura6='");
                bundle.putString("profesor", "Profesor6='");
                bundle.putString("horaE", "HrE6='");
                bundle.putString("horaS", "HrS6='");
                bundle.putString("aula", "Aula6='");
                bundle.putString("color", "Color6='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura7='");
                bundle.putString("profesor", "Profesor7='");
                bundle.putString("horaE", "HrE7='");
                bundle.putString("horaS", "HrS7='");
                bundle.putString("aula", "Aula7='");
                bundle.putString("color", "Color7='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        lineviernes8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Viernes");

                bundle.putString("materia", "Asignatura8='");
                bundle.putString("profesor", "Profesor8='");
                bundle.putString("horaE", "HrE8='");
                bundle.putString("horaS", "HrS8='");
                bundle.putString("aula", "Aula8='");
                bundle.putString("color", "Color8='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });
    }

    public void sabadoMateriasLay(){

        mSabMateria.setVisibility(View.VISIBLE);
        mSabProfe.setVisibility(View.VISIBLE);
        mSabHrE.setVisibility(View.VISIBLE);
        mSabHrS.setVisibility(View.VISIBLE);
        mSabAula.setVisibility(View.VISIBLE);

        mSabMateria2.setVisibility(View.VISIBLE);
        mSabProfe2.setVisibility(View.VISIBLE);
        mSabHrE2.setVisibility(View.VISIBLE);
        mSabHrS2.setVisibility(View.VISIBLE);
        mSabAula2.setVisibility(View.VISIBLE);


        mSabMateria3.setVisibility(View.VISIBLE);
        mSabProfe3.setVisibility(View.VISIBLE);
        mSabHrE3.setVisibility(View.VISIBLE);
        mSabHrS3.setVisibility(View.VISIBLE);
        mSabAula3.setVisibility(View.VISIBLE);

        mSabMateria4.setVisibility(View.VISIBLE);
        mSabProfe4.setVisibility(View.VISIBLE);
        mSabHrE4.setVisibility(View.VISIBLE);
        mSabHrS4.setVisibility(View.VISIBLE);
        mSabAula4.setVisibility(View.VISIBLE);

        mSabMateria5.setVisibility(View.VISIBLE);
        mSabProfe5.setVisibility(View.VISIBLE);
        mSabHrE5.setVisibility(View.VISIBLE);
        mSabHrS5.setVisibility(View.VISIBLE);
        mSabAula5.setVisibility(View.VISIBLE);

        mSabMateria6.setVisibility(View.VISIBLE);
        mSabProfe6.setVisibility(View.VISIBLE);
        mSabHrE6.setVisibility(View.VISIBLE);
        mSabHrS6.setVisibility(View.VISIBLE);
        mSabAula6.setVisibility(View.VISIBLE);

        mSabMateria7.setVisibility(View.VISIBLE);
        mSabProfe7.setVisibility(View.VISIBLE);
        mSabHrE7.setVisibility(View.VISIBLE);
        mSabHrS7.setVisibility(View.VISIBLE);
        mSabAula7.setVisibility(View.VISIBLE);

        mSabMateria8.setVisibility(View.VISIBLE);
        mSabProfe8.setVisibility(View.VISIBLE);
        mSabHrE8.setVisibility(View.VISIBLE);
        mSabHrS8.setVisibility(View.VISIBLE);
        mSabAula8.setVisibility(View.VISIBLE);


        linesabado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura1='");
                bundle.putString("profesor", "Profesor1='");
                bundle.putString("horaE", "HrE1='");
                bundle.putString("horaS", "HrS1='");
                bundle.putString("aula", "Aula1='");
                bundle.putString("color", "Color1='");

                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura2='");
                bundle.putString("profesor", "Profesor2='");
                bundle.putString("horaE", "HrE2='");
                bundle.putString("horaS", "HrS2='");
                bundle.putString("aula", "Aula2='");
                bundle.putString("color", "Color2='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura3='");
                bundle.putString("profesor", "Profesor3='");
                bundle.putString("horaE", "HrE3='");
                bundle.putString("horaS", "HrS3='");
                bundle.putString("aula", "Aula3='");
                bundle.putString("color", "Color3='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura4='");
                bundle.putString("profesor", "Profesor4='");
                bundle.putString("horaE", "HrE4='");
                bundle.putString("horaS", "HrS4='");
                bundle.putString("aula", "Aula4='");
                bundle.putString("color", "Color4='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura5='");
                bundle.putString("profesor", "Profesor5='");
                bundle.putString("horaE", "HrE5='");
                bundle.putString("horaS", "HrS5='");
                bundle.putString("aula", "Aula5='");
                bundle.putString("color", "Color5='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura6='");
                bundle.putString("profesor", "Profesor6='");
                bundle.putString("horaE", "HrE6='");
                bundle.putString("horaS", "HrS6='");
                bundle.putString("aula", "Aula6='");
                bundle.putString("color", "Color6='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura7='");
                bundle.putString("profesor", "Profesor7='");
                bundle.putString("horaE", "HrE7='");
                bundle.putString("horaS", "HrS7='");
                bundle.putString("aula", "Aula7='");
                bundle.putString("color", "Color7='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });

        linesabado8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle containing data you are passing to the dialog
                bundle.putString("tabla","Sabado");

                bundle.putString("materia", "Asignatura8='");
                bundle.putString("profesor", "Profesor8='");
                bundle.putString("horaE", "HrE8='");
                bundle.putString("horaS", "HrS8='");
                bundle.putString("aula", "Aula8='");
                bundle.putString("color", "Color8='");


                DialogoHorario dialog = new DialogoHorario(); //Create a new Dialog
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflate the dialog
            }
        });
    }


}
