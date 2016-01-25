/*
Created by Helm  13/3/15.
*/


package cat.helm.basearchitecture.exception;

public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (exception != null) {
            message = exception.getMessage();
        }
        return message;
    }
}
