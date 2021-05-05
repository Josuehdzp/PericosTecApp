package com.Pericos.ITSVC.App;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Feeds.FeedMainRecycler;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OneSignal;
import com.thefinestartist.finestwebview.FinestWebView;

import org.json.JSONObject;

import java.util.List;

public class NotificacionesOneSignal2 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializacion de OneSignal
        OneSignal.startInit(this)
                //.setNotificationReceivedHandler(new ExampleNotificationReceivedHandler())
                .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }

    //Evento al pulsar el boton de notificación
    private class ExampleNotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {

        @Override
        public void notificationReceived(OSNotification notification) {
            JSONObject data = notification.payload.additionalData;
            String notificationID = notification.payload.notificationID;
            String title = notification.payload.title;
            String body = notification.payload.body;
            String smallIcon = notification.payload.smallIcon;
            String largeIcon = notification.payload.largeIcon;
            String bigPicture = notification.payload.bigPicture;
            String smallIconAccentColor = notification.payload.smallIconAccentColor;
            String sound = notification.payload.sound;
            String ledColor = notification.payload.ledColor;
            int lockScreenVisibility = notification.payload.lockScreenVisibility;
            String groupKey = notification.payload.groupKey;
            String groupMessage = notification.payload.groupMessage;
            String fromProjectNumber = notification.payload.fromProjectNumber;
            String rawPayload = notification.payload.rawPayload;

            String customKey;

            Log.i("OneSignalExample", "NotificationID received: " + notificationID);

            if (data != null) {
                customKey = data.optString("customkey", null);
                if (customKey != null)
                    Log.i("OneSignalExample", "customkey set with value: " + customKey);
            }
        }
    }

    private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            OSNotificationAction.ActionType actionType = result.action.type;
            JSONObject data = result.notification.payload.additionalData;
            String launchUrl = result.notification.payload.launchURL; // update docs launchUrl

            String customKey;
            String openURL = "";
            Object activityToLaunch = FeedMainRecycler.class;
            String titulo = result.notification.payload.title;
            String color = result.notification.payload.smallIconAccentColor;
            String boton = result.action.actionID;


            if (data != null) {
                customKey = data.optString("customkey", null);
                openURL = data.optString("openURL", null);

                if (customKey != null)
                    Log.i("OneSignalExample", "customkey set with value: " + customKey);

                if (openURL != null)
                    Log.i("OneSignalExample", "openURL to webview with URL value: " + openURL);
            }

            //// Acciones al presionar los botones de las notificaciones, solo se permiten 3 con el id: Boton1, Boton2 y Boton3
            if (actionType == OSNotificationAction.ActionType.ActionTaken) {
                //// Boton1
                if (boton.endsWith("1") ) {
                    Toast.makeText(NotificacionesOneSignal2.this, "Abriendo aplicación", Toast.LENGTH_SHORT).show();
                    Intent verAvisos = new Intent(getApplicationContext(), FeedMainRecycler.class);
                    verAvisos.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(verAvisos);
                }

                else if (boton.endsWith("2") && launchUrl==null){
                    Toast.makeText(NotificacionesOneSignal2.this, "Abriendo aplicación", Toast.LENGTH_SHORT).show();
                    Intent verAvisos = new Intent(getApplicationContext(), FeedMainRecycler.class);
                    verAvisos.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(verAvisos);
                }
                else if (boton.endsWith("2") && launchUrl!=null){
                    Toast.makeText(NotificacionesOneSignal2.this, "Redirigiendo...", Toast.LENGTH_LONG).show();
                    /*Intent irLink = new Intent(Intent.ACTION_VIEW);
                    irLink.setData(Uri.parse(launchUrl));
                    irLink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(irLink);*/

                    new FinestWebView.Builder(NotificacionesOneSignal2.this)
                            .titleDefault("Cargando...")
                            .titleColor(getResources().getColor(R.color.blanco))
                            .toolbarColor(getResources().getColor(R.color.colorPrimary))
                            .urlColor(getResources().getColor(R.color.grisclaro))
                            .swipeRefreshColorRes(R.color.colorPrimaryDark)
                            .swipeRefreshColor(getResources().getColor(R.color.colorAccent))
                            .progressBarColor(getResources().getColor(R.color.colorAccent))
                            .showProgressBar(true)
                            .progressBarHeight(3)
                            .showIconBack(true)
                            .backPressToClose(false)
                            .iconDefaultColor(getResources().getColor(R.color.blanco))
                            .statusBarColor(getResources().getColor(R.color.colorPrimaryDark))
                            .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
                            .webViewSupportZoom(true)
                            .webViewMediaPlaybackRequiresUserGesture(true)

                            .show(launchUrl);
                }


                //// Boton2
/*
                else if (actionType==OSNotificationAction.ActionType.ActionTaken) {
                    if (launchUrl!= null) {
                        Intent irLink = new Intent(Intent.ACTION_VIEW);
                        irLink.setData(Uri.parse(launchUrl));
                        startActivity(irLink);
                        Toast.makeText(NotificacionesOneSignal2.this, "Redirigiendo...", Toast.LENGTH_LONG).show();
                    } else{
                        Intent intent = new Intent(getApplicationContext(), FeedMainRecycler.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("openURL", openURL);
                        Log.i("OneSignalExample", "openURL = " + openURL);
                        startActivity(intent);
                    }
                }
*/

                //// Boton3
 /*               if (result.action.actionID.equals("Boton3")) {
                    if (launchUrl!= null) {
                        Intent irLink = new Intent(Intent.ACTION_VIEW);
                        irLink.setData(Uri.parse(launchUrl));
                        startActivity(irLink);
                        Toast.makeText(NotificacionesOneSignal2.this, "Redirigiendo...", Toast.LENGTH_LONG).show();
                    } else{
                        Intent intent = new Intent(getApplicationContext(), FeedMainRecycler.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("openURL", openURL);
                        Log.i("OneSignalExample", "openURL = " + openURL);
                        startActivity(intent);
                    }
                } else
                    Log.i("OneSignalExample", "button id called: " + result.action.actionID);
            } else {
                Intent intent = new Intent(getApplicationContext(), FeedMainRecycler.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("launchUrl", launchUrl);
                Log.i("OneSignalExample", "launchUrl = " + launchUrl);
                startActivity(intent);
            }*/


            }
        }
    }
}