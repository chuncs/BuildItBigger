package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest {

    @Test
    public void verifyJokeTest() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        Context mContext = InstrumentationRegistry.getContext();
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertTrue(result.length() > 0);
                latch.countDown();
            }
        };
        asyncTask.execute(mContext);
        latch.await();
    }
}
