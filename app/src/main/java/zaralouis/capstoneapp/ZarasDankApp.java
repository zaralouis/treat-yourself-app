package zaralouis.capstoneapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by zaralouis on 4/20/16.
 */
public class ZarasDankApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
