package com.Pericos.ITSVC.App;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import com.Pericos.ITSVC.App.Feeds.FeedMainRecycler;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notificacion extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Uri sonidoNotificacion = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intentClick = new Intent(context, FeedMainRecycler.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentClick, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notificame")
                .setSmallIcon(R.drawable.icono_itsvc_nice)
                .setContentTitle("¿Ya checaste que hay de nuevo?")
                .setContentText("Hay noticias nuevas, no te las pierdas!!!")
                .setStyle(new NotificationCompat.BigTextStyle().
                        bigText("Hay noticias nuevas, no te las pierdas!!!"))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSound(sonidoNotificacion)
                .setAutoCancel(true);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build());
    }
}
