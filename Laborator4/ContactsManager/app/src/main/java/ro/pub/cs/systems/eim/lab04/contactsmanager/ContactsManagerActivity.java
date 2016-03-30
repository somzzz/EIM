package ro.pub.cs.systems.eim.lab04.contactsmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ContactsManagerActivity extends AppCompatActivity {

    private class ShowHideButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            LinearLayout hiddenContainer = (LinearLayout)findViewById(R.id.hidden_shit);
            Button showHideButton = (Button)findViewById(R.id.show_hide_fields);
            
            if (hiddenContainer.getVisibility() == View.VISIBLE) {
                showHideButton.setText(R.string.show_fields);
                hiddenContainer.setVisibility(View.INVISIBLE);
            } else if (hiddenContainer.getVisibility() == View.INVISIBLE){
                showHideButton.setText(R.string.hide_fields);
                hiddenContainer.setVisibility(View.VISIBLE);
            }
        }
    }

    private class SaveButtonClickListener implements View.OnClickListener {
        //<action android:name="android.intent.action.MAIN" />
        //<category android:name="android.intent.category.LAUNCHER" />
        @Override
        public void onClick(View v) {

            EditText nameET = (EditText) findViewById(R.id.name_edit_text);
            EditText phoneET = (EditText) findViewById(R.id.phone_et);

            String name = nameET.getText().toString();
            String phone = phoneET.getText().toString();

            Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            if (name != null) {
                intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
            }
            if (phone != null) {
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
            }

            //startActivity(intent);
            startActivityForResult(intent, 2015);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case 2015:
                setResult(resultCode, new Intent());
                finish();
                break;
        }
    }

    private class CancelButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            setResult(Activity.RESULT_CANCELED, new Intent());
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button showHideButton = (Button)findViewById(R.id.show_hide_fields);
        showHideButton.setOnClickListener(new ShowHideButtonClickListener());

        Button saveButton = (Button)findViewById(R.id.save_button);
        saveButton.setOnClickListener(new SaveButtonClickListener());

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new CancelButtonClickListener());

        EditText phoneEditText = (EditText)findViewById(R.id.phone_et);

        Intent intent = getIntent();
        if (intent != null) {
            String phone = intent.getStringExtra("ro.pub.cs.systems.eim.lab04.contactsmanager.PHONE_NUMBER_KEY");
            if (phone != null) {
                phoneEditText.setText(phone);
            } else {
                Toast.makeText(this, "SHIT HAPPENED", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
