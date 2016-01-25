/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.ui.di;

import cat.helm.basearchitecture.di.ApplicationComponent;
import cat.helm.basearchitecture.di.PerActivity;
import cat.helm.basearchitecture.ui.MainActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
