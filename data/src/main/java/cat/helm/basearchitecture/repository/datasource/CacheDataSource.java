/*
Created by Helm  28/4/16.
*/


package cat.helm.basearchitecture.repository.datasource;

public interface CacheDataSource<K,V> extends ReadableDataSource<K,V>, WritableDataSource<K,V> {

    boolean isValid(V value);
}
