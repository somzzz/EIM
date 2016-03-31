package stuff.colocviuschelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    public StartedServiceBroadcastReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (Constants.ACTION_1.equals(action)) {

        }
        if (Constants.ACTION_2.equals(action)) {

        }
        if (Constants.ACTION_3.equals(action)) {

        }
    }

}
