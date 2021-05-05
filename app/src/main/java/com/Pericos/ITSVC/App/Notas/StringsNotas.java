package com.Pericos.ITSVC.App.Notas;

public class StringsNotas {

    private String TituloNota;
    private String CuerpoNota;
    private String FechaNota;
    private String HoraNota;
    private String ColorNota;


    public StringsNotas(String tituloNota, String cuerpoNota, String fechaNota, String horaNota, String colorNota) {
        this.TituloNota = tituloNota;
        this.CuerpoNota = cuerpoNota;
        this.FechaNota = fechaNota;
        this.HoraNota = horaNota;
        this.ColorNota = colorNota;
    }

    public StringsNotas() {

    }

    public String getTituloNota() {
        return TituloNota;
    }

    public void setTituloNota(String tituloNota) {
        TituloNota = tituloNota;
    }

    public String getCuerpoNota() {
        return CuerpoNota;
    }

    public void setCuerpoNota(String cuerpoNota) {
        CuerpoNota = cuerpoNota;
    }

    public String getFechaNota() {
        return FechaNota;
    }

    public void setFechaNota(String fechaNota) {
        FechaNota = fechaNota;
    }

    public String getHoraNota() {
        return HoraNota;
    }

    public void setHoraNota(String horaNota) {
        HoraNota = horaNota;
    }

    public String getColorNota() {
        return ColorNota;
    }

    public void setColorNota(String colorNota) {
        ColorNota = colorNota;
    }
}
