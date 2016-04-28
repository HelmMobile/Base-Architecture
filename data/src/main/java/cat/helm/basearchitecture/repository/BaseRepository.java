/*
Created by Helm  28/4/16.
*/


package cat.helm.basearchitecture.repository;

import cat.helm.basearchitecture.repository.datasource.CacheDataSource;
import cat.helm.basearchitecture.repository.datasource.ReadableDataSource;
import cat.helm.basearchitecture.repository.datasource.WritableDataSource;
import cat.helm.basearchitecture.repository.policy.ReadPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class BaseRepository<K, V> {

    private final Collection<WritableDataSource<K, V>> writableDataSources = new ArrayList<>();

    private final Collection<ReadableDataSource<K,V>> readableDataSources = new ArrayList<>();

    private final Collection<CacheDataSource<K,V>> cacheDataSources = new ArrayList<>();

    protected final <R extends WritableDataSource<K, V>> void addWritableDataSource(R... writableDataSources) {
        this.writableDataSources.addAll(Arrays.asList(writableDataSources));
    }

    protected final <R extends ReadableDataSource<K,V>> void addReadableDataSource(R... readableDataSources){
        this.readableDataSources.addAll(Arrays.asList(readableDataSources));
    }

    protected final <R extends CacheDataSource<K,V>> void addCacheDataSource(R... cacheDataSources){
        this.cacheDataSources.addAll(Arrays.asList(cacheDataSources));
    }


    public V getByKey(K key)throws Exception{
        return null;
    }

    public V getByKey(K key, ReadPolicy policy)throws Exception{

        V value = null;

        if(policy.useCache()){
            value = getValueFromCacheDataStores(key);
        }

        if(value != null){
            value = getValueFromReadableDataStores(key);
        }

        if(value != null){
            populateCaches(value);
        }

        return value;
    }

    public Collection<V> getAll() throws Exception {
        return getAll(ReadPolicy.READ_ALL);
    }


    public Collection<V> getAll(ReadPolicy policy) throws Exception {
        Collection<V> values = null;

        if (policy.useCache()) {
            values = getValuesFromCacheDataSources();
        }

        if (values == null && policy.useReadable()) {
            values = getValuesFromReadableDataSources();
        }

        if (values != null) {
            populateCaches(values);
        }

        return values;
    }

    private Collection<V> getValuesFromReadableDataSources() throws Exception {
        Collection<V> values = null;

        for (ReadableDataSource<K, V> readableDataSource : readableDataSources) {
            values = readableDataSource.getAll();

            if (values != null) {
                break;
            }
        }

        return values;
    }

    private void populateCaches(Collection<V> values) {

    }


    private void populateCaches(V value) {

    }

    private V getValueFromCacheDataStores(K key) throws Exception {
        V value = null;
        for (CacheDataSource<K, V> cacheDataSource : cacheDataSources) {
            value = cacheDataSource.getByKey(key);

            if(cacheDataSource.isValid(value)){
                break;
            }else {
                cacheDataSource.deleteByKey(key);
                value = null;
            }
        }
        return value;
    }

    private Collection<V> getValuesFromCacheDataSources() throws Exception {
        Collection<V> values = null;
        for (CacheDataSource<K, V> cacheDataSource : cacheDataSources) {
            values = cacheDataSource.getAll();

            if(areValidValues(values, cacheDataSource)){
                break;
            }else {
                cacheDataSource.deleteAll();
                values = null;
            }
        }
        return values;
    }



    public V getValueFromReadableDataStores(K key) throws Exception {
        V value = null;
        for (ReadableDataSource<K, V> readableDataSource : readableDataSources) {
            value = readableDataSource.getByKey(key);
            if(value != null){
                break;
            }
        }

        return value;

    }

    private boolean areValidValues(Collection<V> values, CacheDataSource<K, V> cacheDataSource) {
        boolean areValidValues = false;
        for (V value : values) {
            areValidValues |= cacheDataSource.isValid(value);
        }
        return areValidValues;
    }
}
