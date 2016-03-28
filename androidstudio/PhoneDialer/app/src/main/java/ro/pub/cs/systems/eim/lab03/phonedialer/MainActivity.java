package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.net.Uri;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText phone_number = null;
    private NumberButtonListener numberButtonListener = new NumberButtonListener();
    private BackspaceButtonClickListener backspaceListener = new BackspaceButtonClickListener();
    private HangupButtonClickListener hangupButtonClickListener = new HangupButtonClickListener();
    private CallButtonClickListener callButtonClickListener = new CallButtonClickListener();

    private class CallButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String phoneNumberString = phone_number.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+phoneNumberString));
            startActivity(intent);

            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                ActivityCompat.requestPermissions((Activity) getApplicationContext(), new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }
    }

    private class HangupButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            phone_number.setText("");
            finish();
        }
    }

    private class NumberButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            phone_number.setText(phone_number.getText().toString()+((Button)view).getText().toString());
        }
    }

    private class BackspaceButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String phoneNumberString = phone_number.getText().toString();
            if (phoneNumberString.length() > 0) {
                phoneNumberString = phoneNumberString.substring(0, phoneNumberString.length() - 1);
                phone_number.setText(phoneNumberString);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        phone_number= (EditText)findViewById(R.id.phone_number_edit_text);


        button = (Button)findViewById(R.id.number_0_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_1_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_2_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_3_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_4_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_5_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_6_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_7_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_8_button);
        button.setOnClickListener(numberButtonListener);

        button = (Button)findViewById(R.id.number_9_button);
        button.setOnClickListener(numberButtonListener);

        ImageButton imageButton = (ImageButton)findViewById(R.id.backspace);
        imageButton.setOnClickListener(backspaceListener);

         imageButton = (ImageButton)findViewById(R.id.call_button);
        imageButton.setOnClickListener(callButtonClickListener);

         imageButton = (ImageButton)findViewById(R.id.hangup_utton);
        imageButton.setOnClickListener(hangupButtonClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

