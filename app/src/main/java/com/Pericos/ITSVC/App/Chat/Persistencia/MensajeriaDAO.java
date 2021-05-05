package com.Pericos.ITSVC.App.Chat.Persistencia;

import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Mensaje;
import com.Pericos.ITSVC.App.Chat.Utilidades.Constantes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MensajeriaDAO {

    private FirebaseDatabase database;
    private DatabaseReference referenciaMensajeria;

    private static MensajeriaDAO mensajeriaDAO;

    public static MensajeriaDAO getInstance(){
        if(mensajeriaDAO==null) mensajeriaDAO = new MensajeriaDAO();
        return mensajeriaDAO;

    }

    private MensajeriaDAO(){

        database = FirebaseDatabase.getInstance();
        referenciaMensajeria = database.getReference(Constantes.NODO_MENSAJES);



//        referenciaMensajeria = database.getReference(Constantes.NODO_MENSAJES_SISTEMAS);
//        storage = FirebaseStorage.getInstance();
//        referenciaUsuarios = database.getReference(Constantes.NODO_USUARIOS);
//        referenciaFotoDePerfil = storage.getReference("Fotos/FotoPerfil/"+getKeyUsuario());

    }

    public void nuevoMenaje(String keyEmisor, String keyReceptor,  Mensaje mensaje){
        DatabaseReference referenceEmisor = referenciaMensajeria.child(keyEmisor).child(keyReceptor);
        DatabaseReference referenceReceptor = referenciaMensajeria.child(keyReceptor).child(keyEmisor);

        referenceEmisor.push().setValue(mensaje);
        referenceReceptor.push().setValue(mensaje);
    }


}
