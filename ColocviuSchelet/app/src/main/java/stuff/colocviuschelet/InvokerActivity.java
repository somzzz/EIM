package stuff.colocviuschelet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class InvokerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoker);

        // Init a button to start the invoked activity
        // ...
    }

    private class ContactsButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(Constants.INVOKED_ACTIVITY);
            intent.putExtra(Constants.SOME_STRING, "La Cucaracha");
            startActivityForResult(intent, Constants.INVOKED_REQUEST_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case Constants.INVOKED_REQUEST_CODE:
                Toast.makeText(getApplication(), "Contacts Manager Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
