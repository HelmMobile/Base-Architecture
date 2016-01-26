/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import cat.helm.basearchitecture.Application;
import cat.helm.basearchitecture.di.ApplicationComponent;

public abstract class BaseActivity  extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onRequestLayout());
        initializeInjection();
        initializeViewsInjection();
    }
    protected ApplicationComponent getApplicationComponent(Application application) {
        return application.getApplicationComponent();
    }

    private void initializeInjection() {
        onInitializeInjection();
    }

    private void initializeViewsInjection() {
        ButterKnife.bind(this);
        onViewLoaded();
    }

    protected abstract int onRequestLayout();

    protected abstract void onInitializeInjection();

    protected abstract void onViewLoaded();


}
