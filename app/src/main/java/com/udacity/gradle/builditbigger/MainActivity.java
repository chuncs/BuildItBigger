package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.IdlingResource.JokeDelayer;
import com.udacity.gradle.builditbigger.IdlingResource.JokeIdlingResource;


public class MainActivity extends AppCompatActivity implements JokeDelayer.DelayerCallback {

    private static final String IDLING_RESOURCE_TESTING = "idlingResourceTesting";
    private JokeIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDone() {
        Log.d(IDLING_RESOURCE_TESTING, "Joke retrieved.");
    }

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new JokeIdlingResource();
        }
        return mIdlingResource;
    }

    public void tellJoke(View view) {
        JokeDelayer.downloadJoke(this, mIdlingResource);
        new EndpointsAsyncTask().execute(this);
    }
}
