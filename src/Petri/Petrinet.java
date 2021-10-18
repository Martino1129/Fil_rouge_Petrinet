package Petri;
import java.util.LinkedList;

public class Petrinet implements IPetrinet{
	
	private LinkedList <Place> places;
	private LinkedList <IArc> arcs;
	private LinkedList <Transition> transitions;
	

	public void createPlace(int n) throws ImpossibleAction{
		if (n<0) {
			throw new ImpossibleAction("nb_jetons can't be negative");
		}
		Place p = new Place(n);
		places.add(p);
		
		
	}
	
	
	/**
	 * This method creates an Arc: 
	 * sens True => transiton-->place, False => place --> transition
	 * There are 3 differents types of arc, the type is defined by the string "type"
	 */
	public void createArc(Place place, String type, int nb_jetons, boolean sens, Transition t) throws TypeException,ImpossibleAction {
		if (sens) {
			for (IArc arc : t.getArc_s()) {
				if (arc.getPlace().equals(place)) {
					throw new ImpossibleAction("An arc with the same direction, place and transition is already created");
				}
			}
		}
		else for (IArc arc : t.getArc_e()) {
				if (arc.getPlace().equals(place)) {
					throw new ImpossibleAction("An arc with the same direction, place and transition is already created");
			}
		}
		
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
	
	/**
	 * This method creates a Transition not connected with any arcs
	 */
	public void createTransitition() {
		Transition t = new Transition(new LinkedList<IArc>(), new LinkedList<IArc>());
		transitions.add(t);
		
	}


	public void triggerTransition(Transition transition) {
		transition.trigger_transition();
		
		
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
