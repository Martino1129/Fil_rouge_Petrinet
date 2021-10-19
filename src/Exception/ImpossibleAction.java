package Exception;

public class ImpossibleAction extends Exception{
	
	// This exception is thrown when an impossible action is made at the creation of the Petrinet

	public ImpossibleAction(String message) {
		super(message);
	}
}
