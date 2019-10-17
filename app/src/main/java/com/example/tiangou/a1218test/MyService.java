package com.example.tiangou.a1218test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.tiangou.a1218test.aidl.IMyBinder;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    private void methodInMyService() {
        Toast.makeText(getApplicationContext(), "服务里的方法执行了。。", Toast.LENGTH_SHORT).show();
    }

    private class MyBinder extends IMyBinder.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void invokeMethodInMyService() throws RemoteException {

            methodInMyService();
        }
    }

}
