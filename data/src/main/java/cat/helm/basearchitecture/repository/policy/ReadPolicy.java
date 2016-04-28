package cat.helm.basearchitecture.repository.policy;

/**
 * Created by Borja on 28/4/16.
 */
public enum ReadPolicy {
    CACHE_ONLY,
    READABLE_ONLY,
    READ_ALL;

    public boolean useCache() {
        return this == CACHE_ONLY || this == READ_ALL;
    }

    public boolean useReadable() {
        return this == READABLE_ONLY || this == READ_ALL;
    }
}
