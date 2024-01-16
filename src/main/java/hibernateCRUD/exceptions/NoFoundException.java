package hibernateCRUD.exceptions;

public class NoFoundException extends Exception{
    public NoFoundException(){

    }
    public NoFoundException(String message){
        super(message);
    }
}
