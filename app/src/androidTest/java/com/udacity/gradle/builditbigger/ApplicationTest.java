package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.TestCase.assertNotNull;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest {
    private String jokeResponse = null;
    private CountDownLatch signal = null;

    public ApplicationTest() {
        super();
    }

    protected void setUp() {
        signal = new CountDownLatch(1);
    }

    protected void tearDown() {
        signal.countDown();
    }

    public void testEndpointsAsyncTask() throws InterruptedException {
        new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                if (!output.isEmpty()) {
                    jokeResponse = output;
                    signal.countDown();
                }
            }
        }).execute();
        signal.await();


        assertNotNull(jokeResponse);
    }
}