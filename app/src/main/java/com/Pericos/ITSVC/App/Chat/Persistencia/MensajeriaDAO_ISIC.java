package com.Pericos.ITSVC.App.Chat.Persistencia;

import com.Pericos.ITSVC.App.Chat.Entidades.Firebase.Mensaje;
import com.Pericos.ITSVC.App.Chat.Entidades.Logica.LUsuario;
import com.Pericos.ITSVC.App.Chat.Utilidades.Constantes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MensajeriaDAO_ISIC {

    private FirebaseDatabase database;
    private DatabaseReference referenciaMensajeria;
    private String nombre;

    private static MensajeriaDAO_ISIC mensajeriaDAO_isic;

    public static MensajeriaDAO_ISIC getInstance(){
        if(mensajeriaDAO_isic==null) mensajeriaDAO_isic = new MensajeriaDAO_ISIC();
        return mensajeriaDAO_isic;

    }

    private MensajeriaDAO_ISIC(){
        UsuarioDAO.getInstancia().obtenerInformacionDeUsuarioPorLLave(UsuarioDAO.getInstancia().getKeyUsuario(), new UsuarioDAO.IDevolverUsuario() {
            @Override
            public void devolverUsuario(LUsuario lUsuario) {
                nombre = lUsuario.getUsuario().getNombre();
            }

            @Override
            public void devolverError(String error) {

            }
        });

        database = FirebaseDatabase.getInstance();
        referenciaMensajeria = database.getReference(Constantes.NODO_MENSAJES_INDIVIDUALES);



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
