/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.ui.main;

import cat.helm.basearchitecture.entities.mapper.DummyViewEntityMapper;
import cat.helm.basearchitecture.exception.ErrorBundle;
import cat.helm.basearchitecture.interactor.main.DummyUseCase;
import cat.helm.basearchitecture.model.Dummy;
import cat.helm.basearchitecture.ui.base.BaseView;

import javax.inject.Inject;

public class MainPresenter implements MainView.ViewInteractionListener {

    private final BaseView view;
    private final DummyUseCase dummyUseCase;
    private final DummyViewEntityMapper mapper;

    @Inject
    public MainPresenter(MainView view, DummyViewEntityMapper mapper, DummyUseCase dummyUseCase) {
        this.view = view;
        this.mapper = mapper;
        this.dummyUseCase = dummyUseCase;
    }


    @Override
    public void onStart() {
        dummyUseCase.execute(new DummyUseCase.DummyCallback() {
            @Override
            public void onError(ErrorBundle errorBundle) {
                //empty
            }

            @Override
            public void onSuccess(Dummy returnParam) {

                view.showLog(mapper.map(returnParam));
            }
        });
    }
}
