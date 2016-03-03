/*
Created by Helm  3/3/16.
*/


/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.entities.mapper;
import cat.helm.basearchitecture.entities.DummyViewEntity;
import cat.helm.basearchitecture.model.Dummy;

import javax.inject.Inject;

public class DummyViewEntityMapper extends Mapper<DummyViewEntity, Dummy> {

    @Inject
    public DummyViewEntityMapper() {
        //DIP purposes
    }

    @Override
    public DummyViewEntity map(Dummy entity) {
        return new DummyViewEntity(entity.getString());
    }


}