package exeptions;

public class UnfoundObjectException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Cultivo no encontrado";

	public UnfoundObjectException(String message){
        super(message);
    }
	
}
