package phonedialer.lab03.eim.systems.cs.pub.ro.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PhoneDialer extends AppCompatActivity {

    final public static int     CONTACTS_MANAGER_REQUEST_CODE = 2015;

    private final NumberButtonListener keyListener =  new NumberButtonListener();
    private final int [] keyIds = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                    R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8,
                    R.id.button_9, R.id.button_diez, R.id.button_star};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        ImageButton b;

        b= (ImageButton)findViewById(R.id.back_image_button);
        b.setOnClickListener(new BackButtonListener());

        b = (ImageButton)findViewById(R.id.call_image_button);
        b.setOnClickListener(new CallButtonListener());

        b = (ImageButton)findViewById(R.id.hangup_image_button);
        b.setOnClickListener(new HangupButtonListener());

        b = (ImageButton)findViewById(R.id.contacts_button);
        b.setOnClickListener(new ContactsButtonListener());

        for (int i = 0; i < keyIds.length; ++i) {
            Button button = (Button) findViewById(keyIds[i]);
            button.setOnClickListener(keyListener);
        }
    }

    private class NumberButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Button key = (Button)v;
            EditText phoneNumber = (EditText)findViewById(R.id.phone_number_edit_text);

            StringBuffer sb = new StringBuffer(phoneNumber.getText());
            sb.append(key.getText());
            phoneNumber.setText(sb.toString());
        }
    }

    private class BackButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText phoneNumber = (EditText) findViewById(R.id.phone_number_edit_text);

            StringBuffer sb = new StringBuffer(phoneNumber.getText());
            sb.deleteCharAt(sb.length() - 1);
            phoneNumber.setText(sb.toString());
        }
    }

    private class CallButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText phoneNumber = (EditText) findViewById(R.id.phone_number_edit_text);

            if (ContextCompat.checkSelfPermission(getApplication(),
                    Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        }
    }

    private class HangupButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }

    private class ContactsButtonListener implements  View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent;
            EditText phoneET = (EditText) findViewById(R.id.phone_number_edit_text);
            String phoneNumber = phoneET.getText().toString();

            if (phoneNumber.length() > 0) {
                intent = new Intent("ro.pub.cs.systems.eim.lab04.contactsmanager.intent.action.ContactsManagerActivity");
                intent.putExtra("ro.pub.cs.systems.eim.lab04.contactsmanager.PHONE_NUMBER_KEY", phoneNumber);
                startActivityForResult(intent, CONTACTS_MANAGER_REQUEST_CODE);
            } else {
                Toast.makeText(getApplication(), getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
            }
        }
    }

}
