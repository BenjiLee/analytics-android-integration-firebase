package android.integrations.google.firebase;

import android.Manifest;
import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.Analytics;
import com.segment.analytics.ValueMap;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.integrations.TrackPayload;

import static com.segment.analytics.internal.Utils.hasPermission;

public class GoogleFirebaseAnalyticsIntegration extends Integration<Void> {
    public static final Factory FACTORY = new Factory() {
        @Override
        public Integration<?> create(ValueMap settings, Analytics analytics) {
            Logger logger = analytics.logger(GOOGLE_FIREBASE_KEY);
            if (!hasPermission(analytics.getApplication(), Manifest.permission.ACCESS_NETWORK_STATE)) {
                logger.debug("ACCESS_NETWORK_STATE is required for Google Analytics.");
                return null;
            }

            Context context = analytics.getApplication();

            FirebaseAnalytics mFirebaseAnalytics;
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);

            return new GoogleFirebaseAnalyticsIntegration(analytics, settings);
        }
        @Override
        public String key() {
            return GOOGLE_FIREBASE_KEY;
        }
    };

    private static final String GOOGLE_FIREBASE_KEY = "Google Firebase Analytics";

    @Override
    public void track(TrackPayload track) {
        super.track(track);
    }
    GoogleFirebaseAnalyticsIntegration(Analytics analytics, ValueMap settings) {
    }
}
