package exceptions;


public class NumberNegativeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NumberNegativeException(String message){
        super(message);
    }
}
