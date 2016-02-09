package fr.sio.ecp.federatedbirds.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fr.sio.ecp.federatedbirds.R;
import fr.sio.ecp.federatedbirds.utils.ValidationUtils;

public class SubscriptionActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SubscriptionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);

        //button s'inscrire
        findViewById(R.id.Sinscrire).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscription();
            }
        });

        //button annuler
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void subscription() {

        // Get form views
        EditText usernameText = (EditText) findViewById(R.id.usernameSub);
        EditText passwordText = (EditText) findViewById(R.id.passwordSub);
        EditText emailText = (EditText) findViewById(R.id.emailSub);

        String login = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String email = emailText.getText().toString();

        if (!ValidationUtils.validateLogin(login)) {
            usernameText.setError(getString(R.string.invalid_format));
            usernameText.requestFocus();
            return;
        }

        if (!ValidationUtils.validatePassword(password)) {
            passwordText.setError(getString(R.string.invalid_format));
            passwordText.requestFocus();
            return;
        }

        if (!ValidationUtils.validateEmail(email)) {
            emailText.setError(getString(R.string.invalid_format));
            emailText.requestFocus();
            return;
        }

        SubscriptionTaskFragment taskFragment = new SubscriptionTaskFragment();
        taskFragment.setArguments(login, password, email);
        taskFragment.show(getSupportFragmentManager(), "subscription_task");

    }

    private void reset() {
        // Get form views
        EditText usernameText = (EditText) findViewById(R.id.usernameSub);
        usernameText.setText("");
        EditText passwordText = (EditText) findViewById(R.id.passwordSub);
        passwordText.setText("");
        EditText emailText = (EditText) findViewById(R.id.emailSub);
        emailText.setText("");
        usernameText.requestFocus();
    }
}
