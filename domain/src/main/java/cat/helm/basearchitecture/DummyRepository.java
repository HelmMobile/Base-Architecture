/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture;

import cat.helm.basearchitecture.interactor.DefaultCallback;
import cat.helm.basearchitecture.model.Dummy;

public interface DummyRepository {


    interface DummyCallback extends DefaultCallback<Dummy> {};

    void getDummyString(DummyCallback dataCallback);
}
