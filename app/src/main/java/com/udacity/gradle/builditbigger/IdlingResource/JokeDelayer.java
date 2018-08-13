package com.udacity.gradle.builditbigger.IdlingResource;

import android.os.Handler;
import android.support.annotation.Nullable;

public class JokeDelayer {

    private static final int DELAY_MILLIS = 3000;

    public interface DelayerCallback {
        void onDone();
    }

    public static void downloadJoke(final DelayerCallback callback,
                                      @Nullable final JokeIdlingResource idlingResource) {
        if (idlingResource != null) {
            idlingResource.setIdleState(false);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onDone();
                    if (idlingResource != null) {
                        idlingResource.setIdleState(true);
                    }
                }
            }
        }, DELAY_MILLIS);
    }
}
