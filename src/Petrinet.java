import java.util.LinkedList;

public class Petrinet implements IPetrinet{
	
	private LinkedList <Place> places;
	private LinkedList <Arc> arcs;
	private LinkedList <Transition> transitions;
	

	public void createPlace(int n) {
		Place p = new Place(n);
		places.add(p);
		
		
	}
	
	
	public void createArc(Place place, String type, int nb_jetons) throws TypeException {
		if (type=="videur") {
			IArc arc = new Arc_videur(place);
		}
		if (type=="classique") {
			IArc arc = new Arc_classique(place , nb_jetons);
		}
		if (type=="zéro"  | type=="zero") {
			IArc arc = new Arc_zero(place);
		}
		else {
			throw new TypeException();
		}
	}
	
	
	public void createTransitition(LinkedList arc_e, LinkedList arc_s) {
		Transition t = new Transition(arc_e, arc_s);
		
	}


	public void triggerTransition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTransition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createArc() {
		// TODO Auto-generated method stub
		
	}
	
	

}
