package by.prokhorenko.shapes.exception;

public class RepositoryException extends Exception {

    public RepositoryException(){
        super();
    }

    public RepositoryException(String mes, Throwable cause){
        super(mes,cause);
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

}
