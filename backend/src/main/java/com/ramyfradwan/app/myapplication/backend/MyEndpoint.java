/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.ramyfradwan.app.myapplication.backend;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.ramyfradwan.JokeWizard;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.app.ramyfradwan.com",
                ownerName = "backend.myapplication.app.ramyfradwan.com",
                packagePath = ""
        )
)
public class MyEndpoint {


    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        JokeWizard jokeWizard = new JokeWizard();
        response.setData(jokeWizard.getJoke());
        return response;
    }

}
