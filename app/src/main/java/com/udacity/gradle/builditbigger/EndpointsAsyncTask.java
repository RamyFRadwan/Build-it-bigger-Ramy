package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.ramyfradwan.app.myapplication.backend.MyEndpoint;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private AsyncResponse delegate = null;

    public EndpointsAsyncTask(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-udacity-ramy.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        MyEndpoint myEndpoint = new MyEndpoint();
        String joke = myEndpoint.tellJoke().getData();
        try {
            return myApiService.sayHi(joke).getName();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);

    }

    public interface AsyncResponse {
        void processFinish(String output);
    }
}