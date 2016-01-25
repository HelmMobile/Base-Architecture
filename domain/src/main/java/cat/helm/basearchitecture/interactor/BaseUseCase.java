/*
Created by Helm  16/6/15.
*/


package cat.helm.basearchitecture.interactor;


import cat.helm.basearchitecture.exception.ErrorBundle;
import cat.helm.basearchitecture.executor.PostExecutionThread;

public abstract class BaseUseCase<T> {

    private final PostExecutionThread postExecutionThread;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread;
    }

    public void notifyOnError(final ErrorBundle errorBundle) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                getCallback().onError(errorBundle);
            }
        });
    }

    public void notifyOnSuccess(final T param) {
        postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                getCallback().onSuccess(param);
            }
        });
    }

    public abstract DefaultCallback<T> getCallback();
}
