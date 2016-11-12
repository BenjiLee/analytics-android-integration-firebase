package android.integrations.google.firebase;

/**
 * Created by cleeedx on 11/11/16.
 */

public class DefaultGoogleFirebaseAnalytics implements GoogleFirebaseAnalytics {

    final com.google.firebase.FirebaseOptions.Builder builder;

    public DefaultGoogleFirebaseAnalytics(com.google.firebase.FirebaseOptions.Builder builder) {
        this.builder = builder;
    }


}
