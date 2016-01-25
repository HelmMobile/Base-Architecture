package cat.helm.basearchitecture.exception;

public interface ErrorBundle {
  Exception getException();

  String getErrorMessage();
}