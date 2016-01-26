/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.di;

import cat.helm.basearchitecture.Application;
import cat.helm.basearchitecture.UIThread;
import cat.helm.basearchitecture.executor.JobExecutor;
import cat.helm.basearchitecture.executor.PostExecutionThread;
import cat.helm.basearchitecture.executor.ThreadExecutor;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
@Module(
        includes = {
                DataModule.class,
        }
)
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public ThreadExecutor provideThreadExecutor(JobExecutor executor) {
        return executor;
    }

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread() {
        return new UIThread();
    }

}
