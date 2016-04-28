/*
Created by Helm  28/4/16.
*/


package cat.helm.basearchitecture.repository.datasource;

import java.util.Collection;

public interface ReadableDataSource<K,V> {

    V getByKey(K key) throws Exception;
    Collection<V> getAll() throws Exception;
}
