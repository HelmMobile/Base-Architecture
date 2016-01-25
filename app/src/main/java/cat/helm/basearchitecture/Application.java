/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture;

import cat.helm.basearchitecture.di.ApplicationComponent;
import cat.helm.basearchitecture.di.ApplicationModule;
import cat.helm.basearchitecture.di.DaggerApplicationComponent;

public class Application extends android.app.Application {

    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjection();
    }

    private void initializeInjection() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
