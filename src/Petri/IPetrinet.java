package Petri;
import java.util.LinkedList;

public interface IPetrinet {
	
	public void addPlace(int n);
	
	public void addTransitition();
	
	public void createArc(Place place, String type, int nb_jetons, boolean sens, Transition t) throws TypeException,ImpossibleAction ;
				
	public void removeTransition(Transition transition);

	public void removeArc(IArc arc);

	public void removePlace(Place place);

	public void triggerTransition(Transition transition);
	
	
	
}
