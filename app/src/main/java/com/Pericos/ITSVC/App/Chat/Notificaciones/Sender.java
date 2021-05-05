package com.Pericos.ITSVC.App.Chat.Notificaciones;

public class Sender {

    public Datos datos;
    public  String to;

    public Sender(){
    }

    public Sender(Datos datos, String to) {
        this.datos = datos;
        this.to = to;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
