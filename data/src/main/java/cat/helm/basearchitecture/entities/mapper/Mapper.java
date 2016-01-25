/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.entities.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T,E> {

    public abstract T map(E entity);


    public List<T> map(List<E> entities){
        List<T> mappedEntities = new ArrayList<>();
        for (E entity : entities) {
            mappedEntities.add(map(entity));
        }
        return mappedEntities;
    }
}
