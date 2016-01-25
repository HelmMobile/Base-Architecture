/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.ui;

import cat.helm.basearchitecture.ui.base.BaseView;

import javax.inject.Inject;

public class MainPresenter {

    private final BaseView view;

    @Inject
    public MainPresenter(MainView view) {
        this.view = view;
    }


}
