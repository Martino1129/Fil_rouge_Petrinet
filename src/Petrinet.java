import java.util.LinkedList;

public class Petrinet implements IPetrinet{
	
	private LinkedList <Place> places;
	private LinkedList <IArc> arcs;
	private LinkedList <Transition> transitions;
	

	public void createPlace(int n) {
		Place p = new Place(n);
		places.add(p);
		
		
	}
	
	
	public void createArc(Place place, String type, int nb_jetons) throws TypeException {
		if (type=="videur") {
			IArc arc = new Arc_videur(place);
			arcs.add(arc);

		}
		if (type=="classique") {
			IArc arc = new Arc_classique(place , nb_jetons);
			arcs.add(arc);

		}
		if (type=="zéro"  | type=="zero") {
			IArc arc = new Arc_zero(place);
			arcs.add(arc);

		}
		else {
			throw new TypeException();
		}
		
	}
	
	
	public void createTransitition(LinkedList arc_e, LinkedList arc_s) {
		Transition t = new Transition(arc_e, arc_s);
		transitions.add(t);
		
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
	public void removeTransition(Transition transition) {
		// TODO Auto-generated method stub
		for (IArc arc : transition.getArc_e() ) {
			arc.removeArc();
		}
	}

	
	

}
