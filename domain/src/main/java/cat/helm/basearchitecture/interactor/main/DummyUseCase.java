/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.interactor.main;

import cat.helm.basearchitecture.interactor.DefaultCallback;
import cat.helm.basearchitecture.interactor.Interactor;
import cat.helm.basearchitecture.model.Dummy;

public interface DummyUseCase extends Interactor {

    interface DummyCallback extends DefaultCallback<Dummy>{}

    void execute(final DummyCallback callback);
}
