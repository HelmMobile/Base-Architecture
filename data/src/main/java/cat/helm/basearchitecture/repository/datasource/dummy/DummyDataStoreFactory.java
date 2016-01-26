/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.repository.datasource.dummy;

import javax.inject.Inject;

public class DummyDataStoreFactory {

    @Inject
    public DummyDataStoreFactory() {
        //DIP purposes
    }

    public DiskDummyDataStore create() {
        return new DiskDummyDataStore();
    }
}
