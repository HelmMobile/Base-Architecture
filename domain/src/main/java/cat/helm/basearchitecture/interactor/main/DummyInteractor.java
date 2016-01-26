/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.interactor.main;

import cat.helm.basearchitecture.DummyRepository;
import cat.helm.basearchitecture.exception.ErrorBundle;
import cat.helm.basearchitecture.executor.PostExecutionThread;
import cat.helm.basearchitecture.executor.ThreadExecutor;
import cat.helm.basearchitecture.interactor.BaseUseCase;
import cat.helm.basearchitecture.interactor.DefaultCallback;
import cat.helm.basearchitecture.model.Dummy;

import javax.inject.Inject;

public class DummyInteractor extends BaseUseCase<Dummy> implements DummyUseCase{

    private final ThreadExecutor executor;
    private final DummyRepository repository;
    private DummyCallback callback;

    DummyRepository.DummyCallback dataCallback = new DummyRepository.DummyCallback() {
        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyOnError(errorBundle);
        }

        @Override
        public void onSuccess(Dummy returnParam) {
            notifyOnSuccess(returnParam);
        }
    };

    @Inject
    public DummyInteractor(PostExecutionThread postExecutionThread, ThreadExecutor executor, DummyRepository repository) {
        super(postExecutionThread);
        this.executor = executor;
        this.repository = repository;
    }

    @Override
    public void execute(DummyCallback callback) {
        this.callback = callback;
        executor.execute(this);
    }

    @Override
    public void run() {
        repository.getDummyString(dataCallback);
    }

    @Override
    public DefaultCallback<Dummy> getCallback() {
        return callback;
    }
}
