import java.util.LinkedList;

public interface IPetrinet {
	
	public void createPlace(int n);
	
	public void createTransitition(LinkedList arc_e, LinkedList arc_s);
	
	public void createArc(Place place, String type, int nb_jetons) throws TypeException ;
				
	public void removeTransition(Transition transition);

	void removeArc(IArc arc);

	void removePlace(Place place);
	
	
}
