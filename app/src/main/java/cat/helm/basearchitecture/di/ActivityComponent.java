/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.di;

import cat.helm.basearchitecture.di.scope.PerActivity;
import cat.helm.basearchitecture.ui.main.MainActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
