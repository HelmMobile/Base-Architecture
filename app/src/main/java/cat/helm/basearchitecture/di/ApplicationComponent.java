/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.di;

import cat.helm.basearchitecture.Application;
import cat.helm.basearchitecture.executor.PostExecutionThread;
import cat.helm.basearchitecture.executor.ThreadExecutor;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application getApplication();
    ThreadExecutor getThreadExecutor();
    PostExecutionThread getPostExecutionThread();

    void inject(Application application);
}
