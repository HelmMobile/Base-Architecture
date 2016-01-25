package cat.helm.basearchitecture.ui;

import cat.helm.basearchitecture.R;
import cat.helm.basearchitecture.ui.base.BaseActivity;
import cat.helm.basearchitecture.ui.di.ActivityModule;
import cat.helm.basearchitecture.ui.di.DaggerActivityComponent;
import cat.helm.basearchitecture.ui.di.ViewModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView{

    @Inject MainPresenter presenter;

    @Override
    protected void onInitializeInjection() {
        DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
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
    }
}
