package com.example.practicousbstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class LlamadaEmergencia extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        String cambioEstado = "android.hardware.usb.action.USB_STATE";

        String action = intent.getAction();
        //Log.d("estado", "Received Broadcast: "+action);
        //Log.d("estado", String.valueOf(intent.getExtras().getBoolean("connected")));


        if(action.equalsIgnoreCase(cambioEstado)) {
            if(intent.getExtras().getBoolean("connected")) {
                Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "2664565685"));

                // Log.d("estado", intent.getAction().toString());


                // Para que llame descomentar la siguiente linea

               // context.startActivity(intent1);


                Toast.makeText(context, "Llamada activada", Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, "conectado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "desconectado", Toast.LENGTH_SHORT).show();
            }
        }




        //Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "2664565685"));




       // Log.d("estado", intent.getAction().toString());
        //context.startActivity(intent1);
        //Toast.makeText(context, "Llamada activada", Toast.LENGTH_SHORT).show();

}
}
