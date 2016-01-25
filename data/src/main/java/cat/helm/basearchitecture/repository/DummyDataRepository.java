/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.repository;

import cat.helm.basearchitecture.DummyRepository;
import cat.helm.basearchitecture.entities.DummyDataEntity;
import cat.helm.basearchitecture.entities.mapper.DummyDataEntityMapper;
import cat.helm.basearchitecture.repository.datasource.dummy.DiskDummyDataStore;
import cat.helm.basearchitecture.repository.datasource.dummy.DummyDataStoreFactory;

import javax.inject.Inject;

public class DummyDataRepository implements DummyRepository {

    private final DummyDataStoreFactory dataStoreFactory;
    private final DummyDataEntityMapper dummyMapper;

    @Inject
    public DummyDataRepository(DummyDataStoreFactory dataStoreFactory, DummyDataEntityMapper dummyMapper) {
        this.dataStoreFactory = dataStoreFactory;
        this.dummyMapper = dummyMapper;
    }

    @Override
    public void getDummyString(DummyCallback dataCallback) {

        DiskDummyDataStore diskDummyDataStore = dataStoreFactory.create();
        DummyDataEntity dummy = diskDummyDataStore.getDummy();
        dataCallback.onSuccess(dummyMapper.map(dummy));
    }
}
