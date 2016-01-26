/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.di;

import cat.helm.basearchitecture.interactor.main.DummyInteractor;
import cat.helm.basearchitecture.interactor.main.DummyUseCase;
import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    DummyUseCase providesDummyUseCase(DummyInteractor dummyInteractor){
        return dummyInteractor;
    }
}
