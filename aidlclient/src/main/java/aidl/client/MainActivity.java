package aidl.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import aidl.test.AIDLTest;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent();
        intent.setPackage("aidl.test");
        intent.setAction("aidl.test.ServiceTest");
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    String TAG = "AIDLTest";

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        AIDLTest aidlTest = AIDLTest.Stub.asInterface(service);
        try {
            Log.i(TAG, "onServiceConnected: :" + "MainActivity.onServiceConnected:" + aidlTest.Test());
        } catch (Exception e) {
            Log.i(TAG, "onServiceConnected: :" + e.toString());
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("MainActivity.onServiceDisconnected");
    }
}
