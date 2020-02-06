package exeptions;

public class UnfoundObject extends Exception{

	private static final long serialVersionUID = 1L;

	public UnfoundObject(String message){
        super(message);
    }
}
