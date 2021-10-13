import java.util.LinkedList;

public interface IPetrinet {
	
	public void createPlace(int n);
	
	public void createTransitition(LinkedList arc_e, LinkedList arc_s);
	
	public void createArc(Place place, String type, int nb_jetons, boolean sens, Transition t) throws TypeException,ImpossibleAction ;
				
	public void removeTransition(Transition transition);

	public void removeArc(IArc arc);

	public void removePlace(Place place);

  public void triggerTransition(Transition transition);
	
	
}
