package fr.sio.ecp.federatedbirds.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import fr.sio.ecp.federatedbirds.R;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        TextView usernameText = (TextView) findViewById(R.id.usernameUserDetail);
        TextView userEmailText = (TextView) findViewById(R.id.emailUserDetail);
        ImageView userAvatarView = (ImageView) findViewById(R.id.avatarUserDetail);

        Intent i = getIntent();
        long idUser = i.getLongExtra("userId", -1);
        if(idUser> -1) {
            String userAvatar = i.getStringExtra("userAvatar");
            String userEmail = i.getStringExtra("userEmail");
            String username = i.getStringExtra("username");

            usernameText.setText(username);
            userEmailText.setText(userEmail);
            Picasso.with(this)
                    .load(userAvatar)
                    .into(userAvatarView);

            Bundle arg = new Bundle();
            arg.putLong("idUser", idUser);
            UserMessagesFragment fragment = new UserMessagesFragment();
            fragment.setArguments(arg);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.messages_container_UserDetail, fragment)
                    .commit();
        }
        else
        {
            Toast.makeText(this, "Error occured !", Toast.LENGTH_LONG).show();
        }
    }
}
