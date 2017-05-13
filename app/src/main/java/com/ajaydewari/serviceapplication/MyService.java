package com.ajaydewari.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;

import java.util.Random;

public class MyService extends Service {

    int randomNumber;
    private final static int MAX=100;
    private final static int MIN=0;
    private boolean isGenerater;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, /*@IntDef(value = {Service.START_FLAG_REDELIVERY, Service.START_FLAG_RETRY}, flag = true) */int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
            generateRandomNum();
            }
        });
        return START_STICKY;
    }
private void generateRandomNum(){
    while(isGenerater){
        randomNumber=new Random().nextInt(MIN)+MAX;
    }

}

private int getRandomNumber(){

        return randomNumber;
    }
}
