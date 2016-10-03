package zaralouis.capstoneapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.android.*;

import java.util.Map;


/**
 * Created by zaralouis on 4/16/16.
 */
public class SignUpScreen extends Activity{

    private Button newUserButton;
    private EditText newUsername;
    private EditText newPassword;
    private EditText newEmail;
    private Firebase myFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        newUsername = (EditText)findViewById(R.id.newUsername);
        newPassword = (EditText)findViewById(R.id.newPassword);
        newEmail = (EditText) findViewById(R.id.newEmail);
        newUserButton = (Button) findViewById(R.id.newUserButton);
        myFirebaseRef = new Firebase("https://radiant-torch-5237.firebaseio.com/");

        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFirebaseRef.createUser(newEmail.getText().toString(), newPassword.getText().toString(), new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        //TODO
                        Toast.makeText(newUserButton.getContext(), "Cheers!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {

                        Toast.makeText(newUserButton.getContext(), "Error with creating an account", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
    }
}
