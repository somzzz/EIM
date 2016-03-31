package stuff.colocviuschelet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class InvokedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoked);

        /*
        Intent intent = getIntent();
        if (intent != null) {
            String toCompute = intent.getStringExtra(Constants.SOME_STRING,);
            int result = 0;
            intent.putExtra("computed_result", result);
        }
        */
    }

    private SaveButtonClickListener saveButtonClickListener = new SaveButtonClickListener();
    private class SaveButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
    }

    private CancelButtonClickListener cancelButtonClickListener = new CancelButtonClickListener();
    private class CancelButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(Activity.RESULT_CANCELED, new Intent());
            finish();
        }
    }

}
