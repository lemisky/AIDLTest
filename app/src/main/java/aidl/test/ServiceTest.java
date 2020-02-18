package aidl.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServiceTest extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new AIDLTest.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public String Test() throws RemoteException {
                return "Hello Android AIDL";
            }
        };
    }

    String TAG = "AIDLTest";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ServiceTest.onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ServiceTest.onDestroy");
    }
}
