/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.ui.di;


import android.app.Activity;
import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                ViewModule.class,
        }
)
public class ActivityModule {

        private final Activity activity;

        public ActivityModule(Activity activity) {
                this.activity = activity;
        }

        @Provides
        public Activity provideActivity() {
                return activity;
        }
}
