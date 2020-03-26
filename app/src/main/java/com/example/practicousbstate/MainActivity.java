package com.example.practicousbstate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {

    private LlamadaEmergencia llamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Ya Tiene permisos", Toast.LENGTH_LONG).show();
        } else {
            requestPermissions(new String[]{CALL_PHONE}, 1);
        }

        llamada = new LlamadaEmergencia();
        registerReceiver(llamada, new IntentFilter("android.hardware.usb.action.USB_STATE"));



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(llamada);
    }
}
