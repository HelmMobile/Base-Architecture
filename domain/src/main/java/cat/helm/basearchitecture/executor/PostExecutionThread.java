
package cat.helm.basearchitecture.executor;


public interface PostExecutionThread {

  void post(Runnable runnable);
}
