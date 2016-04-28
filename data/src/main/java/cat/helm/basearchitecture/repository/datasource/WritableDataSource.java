/*
Created by Helm  28/4/16.
*/


package cat.helm.basearchitecture.repository.datasource;

public interface WritableDataSource<K,V> {

    void deleteByKey(K key) throws Exception;


    void deleteAll() throws Exception;
}
