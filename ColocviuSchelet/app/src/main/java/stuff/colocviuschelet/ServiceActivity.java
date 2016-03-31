package stuff.colocviuschelet;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    private StartedServiceBroadcastReceiver startedServiceBroadcastReceiver;
    private IntentFilter startedServiceIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Start broadcast receiver
        startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver();

        // Intents for actions
        startedServiceIntentFilter = new IntentFilter();
        startedServiceIntentFilter.addAction(Constants.ACTION_1);
        startedServiceIntentFilter.addAction(Constants.ACTION_2);
        startedServiceIntentFilter.addAction(Constants.ACTION_3);

        // Start service
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("stuff.colocviuschelet", "stuff.colocviuschelet.MyService"));

        // SAU
        // Intent intent = new Intent(getApplicationContext(), MyService.class);

        startService(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(startedServiceBroadcastReceiver, startedServiceIntentFilter);
    }


    @Override
    protected void onPause() {
        unregisterReceiver(startedServiceBroadcastReceiver);
        super.onPause();
    }


    @Override
    protected void onDestroy() {

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("stuff.colocviuschelet", "stuff.colocviuschelet.MyService"));
        stopService(intent);

        super.onDestroy();
    }

}
