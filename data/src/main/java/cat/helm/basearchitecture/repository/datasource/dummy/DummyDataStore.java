/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.repository.datasource.dummy;

import cat.helm.basearchitecture.entities.DummyDataEntity;

public interface DummyDataStore {
    DummyDataEntity getDummy();
}
