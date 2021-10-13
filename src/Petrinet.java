import java.util.LinkedList;

public class Petrinet implements IPetrinet{
	
	private LinkedList <Place> places;
	private LinkedList <IArc> arcs;
	private LinkedList <Transition> transitions;
	

	public void createPlace(int n) {
		Place p = new Place(n);
		places.add(p);
		
		
	}
	
	

	public void createArc(Place place, String type, int nb_jetons, boolean sens, Transition t) throws TypeException,ImpossibleAction {
		
		// create a new Arc and add associate it to a Transition
		
		if (type.equals("videur")) {

			IArc arc = new Arc_videur(place);
			arcs.add(arc);
			t.addArc(sens, arc);

		}
		if (type.equals("classique")) {
			IArc arc = new Arc_classique(place , nb_jetons);
			arcs.add(arc);
			t.addArc(sens, arc);

		}
		if (type.equals("zéro")  | type.equals("zero")) {
			IArc arc = new Arc_zero(place);
			arcs.add(arc);
			t.addArc(sens, arc);

		}
		else {
			throw new TypeException();
		}
		
	}
	
	
	public void createTransitition(LinkedList arc_e, LinkedList arc_s) {
		Transition t = new Transition(arc_e, arc_s);
		transitions.add(t);
		
	}


	public void triggerTransition(Transition transition) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void removePlace(Place place) {
		/**
		 *  To remove a Place, we got to remove every arcs linked to it otherwise there will be unconnected
		 * arcs in our list of arcs. 
		 */
		
		for (IArc arc : arcs) {
			if (arc.getPlace().equals(place)) {
				arcs.remove(arc);
			}
		}
		places.remove(place);
		
	}

	@Override
	public void removeArc(IArc arc) {
		arcs.remove(arc);
		
	}

	@Override
	public void removeTransition(Transition transition) {
		/**
		 * To remove a transition, we got to remove every arcs linked to it otherwise there will be unconnected
		 * arcs in our list of arcs.
		 */
		
		
		for (IArc arc : transition.getArc_e() ) {
			removeArc(arc);
		}
		
		for (IArc arc : transition.getArc_s() ) {
			removeArc(arc);
		}
		transitions.remove(transition);
	}



	
	

}
