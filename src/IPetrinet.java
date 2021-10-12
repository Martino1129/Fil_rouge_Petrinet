import java.util.LinkedList;

public interface IPetrinet {
	
	public void createPlace(int n);
	
	public void createTransitition(LinkedList arc_e, LinkedList arc_s);
	
	public void createArc(Place place, String type, int nb_jetons) throws TypeException ;
	
	public void triggerTransition();
	
	public void removePlace();
	
	public void removeArc();
	
	public void removeTransition();
	
	
}
