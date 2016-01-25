/*
Created by Helm  16/6/15.
*/


package cat.helm.basearchitecture.interactor;


import cat.helm.basearchitecture.exception.ErrorBundle;

public interface DefaultCallback<T> {

    void onError(ErrorBundle errorBundle);
    void onSuccess(T returnParam);
}
