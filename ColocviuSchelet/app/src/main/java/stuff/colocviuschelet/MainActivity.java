package stuff.colocviuschelet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            Log.d(Constants.TAG, "onCreate() method was invoked without a previous state");
        } else {
            Log.d(Constants.TAG, "onCreate() method was invoked with a previous state");

			/*if (savedInstanceState.containsKey(Constants.USERNAME_EDIT_TEXT)) {
				EditText usernameEditText = (EditText)findViewById(R.id.username_edit_text);
				usernameEditText.setText(savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT));
			} */

            /* Visibility example

               switch (x.getVisibility()) {
                case View.VISIBLE:
                    x.setVisibility(View.INVISIBLE);
                    break;
                case View.INVISIBLE:
                    x.setVisibility(View.VISIBLE);
                    break;
            }
            */
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constants.TAG, "onRestart() method was invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constants.TAG, "onStart() method was invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.TAG, "onResume() method was invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constants.TAG, "onPause() method was invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constants.TAG, "onStop() method was invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // savedInstanceState.putString(Constants.USERNAME_EDIT_TEXT, usernameEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /*
        if (savedInstanceState.containsKey(Constants.USERNAME_EDIT_TEXT)) {
            EditText usernameEditText = (EditText)findViewById(R.id.username_edit_text);
            usernameEditText.setText(savedInstanceState.getString(Constants.USERNAME_EDIT_TEXT));
        } */

    }
}
