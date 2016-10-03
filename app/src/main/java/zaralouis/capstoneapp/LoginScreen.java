package zaralouis.capstoneapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by zaralouis on 4/16/16.
 */
public class LoginScreen extends Activity{
    private Button loginButton;
    private EditText username;
    private EditText password;
    private Firebase myFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_screen);
        myFirebaseRef = new Firebase("https://radiant-torch-5237.firebaseio.com/");
        loginButton = (Button) findViewById(R.id.loginButton);
        username = (EditText) findViewById(R.id.username_editText);
        password = (EditText) findViewById(R.id.password_editText);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFirebaseRef.authWithPassword(username.getText().toString(), password.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        //TODO
                        Toast.makeText(loginButton.getContext(), "Cheers!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        Toast.makeText(loginButton.getContext(), "You done fucked up!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
