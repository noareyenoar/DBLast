package com.porducer.test3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ownerRegis extends AppCompatActivity {
    public TextView Username, Password, PetName, PetBirth, PetBreed;
    public Spinner PetSpecies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_regis);
        Bundle intentbundle = getIntent().getExtras();
        final String usernameintent = intentbundle.getString("Username");
        final String passwordintent = intentbundle.getString("Password");

        Username = (TextView) findViewById(R.id.username);
        Password = (TextView) findViewById(R.id.password);
        PetName = (TextView) findViewById(R.id.PetName);
        PetBirth = (TextView) findViewById(R.id.Pet_birth);
        PetSpecies = (Spinner) findViewById(R.id.PetSpecies);
        PetBreed = (TextView) findViewById(R.id.Pet_breed);


        if(usernameintent!=null){Username.setText(usernameintent);}
        if(passwordintent!=null){Password.setText(usernameintent);}

        final DBConnect DB = new DBConnect(this);

        Button regis = (Button) findViewById(R.id.regisbotton);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Username!=null&&Password!=null&&PetName!=null&&PetBirth!=null&&PetSpecies!=null){
                    DB.Regis(Username.getText().toString(),Password.getText().toString(),"DATE('now')",
                            PetName.getText().toString(), PetBirth.getText().toString(),PetSpecies.getSelectedItem().toString(),PetBreed.getText().toString());
                }
                else{Toast.makeText(getApplicationContext(),"Data to register can't be Left blank",Toast.LENGTH_LONG).show();}

            }
        });

    }


}



