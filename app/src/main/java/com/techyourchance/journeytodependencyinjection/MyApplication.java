package com.techyourchance.journeytodependencyinjection;

import android.app.Application;

import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.CompositionRoot;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application.ApplicationComponent;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application.ApplicationModule;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application.DaggerApplicationComponent;

public class MyApplication extends Application {

    //private CompositionRoot mCompositionRoot;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //mCompositionRoot = new CompositionRoot();
        //applicationComponent = null; // need to be instantiated like CompositionRoot. However since it is an interface that can't be instantiated,
                                     // thus we need to click "build" in order to make dagger generate this for us

        // below is example of using the generated ApplicationComponent by Dagger called DaggerApplicationComponent
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule()) // here is our responsibility to instantiate the ApplicationModule
                .build();
    }

    // add getter ApplicationComponent to be accessible from outside
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    // old
//    public CompositionRoot getCompositionRoot() {
//        return mCompositionRoot;
//    }
}
