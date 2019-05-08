package com.porducer.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final TextView userid=(TextView) findViewById(R.id.username);
        final TextView userpassword=(TextView) findViewById(R.id.password);

        Button regisowner = (Button) findViewById(R.id.owner);
        regisowner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentownerregis = new Intent(mainActivity.this, ownerRegis.class);
                    intentownerregis.putExtra("Username",userid.getText().toString());
                    intentownerregis.putExtra("Password",userpassword.getText().toString());

                    //String temp = userid.getText().toString()+userpassword.getText().toString();
                    //Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();  Toast for debug Test

                    startActivity(intentownerregis);
                }
            });
    }

}
