/*
Created by Helm  25/2/16.
*/


package cat.helm.basearchitecture.di;

import cat.helm.basearchitecture.ui.main.MainPresenter;
import cat.helm.basearchitecture.ui.main.MainView;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    MainView.ViewInteractionListener providesUserInteractionListener(MainPresenter presenter) {
        return presenter;
    }

}
