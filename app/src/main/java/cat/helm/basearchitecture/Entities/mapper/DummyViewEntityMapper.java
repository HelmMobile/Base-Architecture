/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.Entities.mapper;
import cat.helm.basearchitecture.Entities.DummyViewEntity;
import cat.helm.basearchitecture.entities.mapper.Mapper;
import cat.helm.basearchitecture.model.Dummy;

public class DummyViewEntityMapper extends Mapper<DummyViewEntity, Dummy> {

    @Override
    public DummyViewEntity map(Dummy entity) {
        return new DummyViewEntity(entity.getString());
    }


}
