package cat.helm.basearchitecture.ui.main;

import android.util.Log;
import cat.helm.basearchitecture.Application;
import cat.helm.basearchitecture.entities.DummyViewEntity;
import cat.helm.basearchitecture.R;
import cat.helm.basearchitecture.ui.base.BaseActivity;
import cat.helm.basearchitecture.di.ActivityModule;
import cat.helm.basearchitecture.di.DaggerActivityComponent;
import cat.helm.basearchitecture.di.ViewModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView{

    @Inject MainPresenter presenter;
    @Override
    protected void onInitializeInjection() {
        Application application = (Application) getApplication();
        DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent(application))
                .activityModule(new ActivityModule(this))
                .viewModule(new ViewModule(this))
                .build()
                .inject(this);
    }


    @Override
    protected int onRequestLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewLoaded() {
        presenter.onStart();
    }

    @Override
    public void showLog(DummyViewEntity map) {
        Log.e("MainActivity", map.getString());
    }
}
