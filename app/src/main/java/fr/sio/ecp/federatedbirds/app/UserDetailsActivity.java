package fr.sio.ecp.federatedbirds.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fr.sio.ecp.federatedbirds.R;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Intent i = getIntent();
        long idUser = i.getLongExtra("userId", 0);
        Toast.makeText(this,"id"+idUser, Toast.LENGTH_LONG).show();
    }
}
