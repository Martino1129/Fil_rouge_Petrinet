package Petri;
import java.util.LinkedList;

public class Petrinet implements IPetrinet{
	
	private LinkedList <Place> places;
	private LinkedList <IArc> arcs;
	private LinkedList <Transition> transitions;
	
	public Petrinet(LinkedList <Place> places, LinkedList <IArc> arcs, LinkedList <Transition> transitions) {
		this.places = places;
		this.arcs = arcs;
		this.transitions = transitions;
	}
	
	public void addPlace(Place p) {
		places.add(p);
		
		
	}
	
	
	/**
	 * This method creates an Arc: 
	 * sens True => transiton-->place, False => place --> transition
	 * There are 3 differents types of arc, the type is defined by the string "type"
	 */
	public void addArc(IArc arc, String type, boolean sens, Transition t) throws TypeException,ImpossibleAction {
		if (sens) {
			for (IArc existing_arc : t.getArc_s()) {
				if (existing_arc.getPlace().equals(arc.getPlace())) {
					throw new ImpossibleAction("An arc with the same direction, place and transition is already created");
				}
			}
		}
		else for (IArc existing_arc : t.getArc_e()) {
				if (existing_arc.getPlace().equals(arc.getPlace())) {
					throw new ImpossibleAction("An arc with the same direction, place and transition is already created");
			}
		}
		
		// create a new Arc and add associate it to a Transition
		if (arc.getType().equals("videur")) {

			arcs.add(arc);
			t.addArc(sens, arc);

		}
		if (arc.getType().equals("classique")) {
			arcs.add(arc);
			t.addArc(sens, arc);

		}
		if (arc.getType().equals("zéro")  | type.equals("zero")) {
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
	public void addTransitition(Transition t) {
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
