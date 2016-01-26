/*
Created by Helm  26/1/16.
*/


package cat.helm.basearchitecture.di;

import cat.helm.basearchitecture.DummyRepository;
import cat.helm.basearchitecture.repository.DummyDataRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
@Module
public class DataModule {

    @Provides
    @Singleton
    DummyRepository providesDummyRepository(DummyDataRepository dummyDataRepository){
        return dummyDataRepository;
    }
}
