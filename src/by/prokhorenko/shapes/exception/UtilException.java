package by.prokhorenko.shapes.exception;

public class UtilException extends Exception {

    public UtilException(){
        super();
    }

    public UtilException(String mes, Throwable cause){
        super(mes,cause);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(Throwable cause) {
        super(cause);
    }
}
