package stuff.colocviuschelet;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {

        @Override
        public void onCreate() {
            super.onCreate();
            Log.d(Constants.TAG, "onCreate() method was invoked");
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Log.d(Constants.TAG, "onStartCommand() method was invoked");

            ProcessingThread processingThread = new ProcessingThread(this);
            processingThread.start();

            return START_REDELIVER_INTENT;
        }

        @Override
        public IBinder onBind(Intent intent) {
            Log.d(Constants.TAG, "onBind() method was invoked");
            return null;
        }

        @Override
        public boolean onUnbind(Intent intent) {
            Log.d(Constants.TAG, "onUnbind() method was invoked");
            return true;
        }

        @Override
        public void onRebind(Intent intent) {
            Log.d(Constants.TAG, "onRebind() method was invoked");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d(Constants.TAG, "onDestroy() method was invoked");
        }


   private class ProcessingThread extends Thread {

        private Context context;

        public ProcessingThread(Context context) {
            this.context = context;
        }

        @Override
        public void run() {
            sendMessage();
            sleep();
        }

        private void sleep() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        private void sendMessage() {
            Intent intent = new Intent();

            Random rand = new Random();
            int messageType = rand.nextInt() % 3;

            switch(messageType) {
                case Constants.MESSAGE_1:
                    intent.setAction(Constants.ACTION_1);
                    break;
                case Constants.MESSAGE_2:
                    intent.setAction(Constants.ACTION_2);
                    break;
                case Constants.MESSAGE_3:
                    intent.setAction(Constants.ACTION_3);
                    break;
            }

            intent.putExtra(Constants.DATA, "Some data");
            context.sendBroadcast(intent);
        }

    }
}
