package Petri;
import java.util.LinkedList;

import Exception.ImpossibleAction;
import Exception.TypeException;

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
	 * sens False => transiton-->place, True => place --> transition
	 * There are 3 differents types of arc, the type is defined by the string "type"
	 */
	public void addArc(IArc arc, String type, boolean sens, Transition transition) throws TypeException,ImpossibleAction {
		if (sens) {
			for (IArc existing_arc : transition.getArc_e()) {
				if (existing_arc.getPlace().equals(arc.getPlace())) {
					throw new ImpossibleAction("An arc with the same direction, place and transition is already created");
				}
			}
		}
		else for (IArc existing_arc : transition.getArc_s()) {
				if (existing_arc.getPlace().equals(arc.getPlace())) {
					throw new ImpossibleAction("An arc with the same direction, place and transition is already created");
			}
		}
		
		// create a new Arc and add associate it to a Transition
		if (arc.getType().equals("videur")) {

			arcs.add(arc);
			transition.addArc(sens, arc);

		}
		else if (arc.getType().equals("classique")) {
			arcs.add(arc);
			transition.addArc(sens, arc);

		}
		else if (arc.getType().equals("zéro")  | arc.getType().equals("zero")) {
			arcs.add(arc);
			transition.addArc(sens, arc);

		}
		else {
			throw new TypeException();
		}
		
	}
	
	/**
	 * This method creates a Transition not connected with any arcs
	 */
	public void addTransition(Transition t) {
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
				removeArc(arc);
				System.out.println("removing arcccc");

			}
		}
		places.remove(place);
		
	}

	@Override
	public void removeArc(IArc arc) {
		arcs.remove(arc);
		System.out.println("caca");

		System.out.println(transitions.size());

		for (Transition transition : transitions) {
			if (transition.getArc_e().contains(arc)) {
				transition.getArc_e().remove(arc);
				System.out.println("arc e removed");

			}
			if (transition.getArc_s().contains(arc)) {
				transition.getArc_s().remove(arc);
				System.out.println("arc s removed");

			}
		}

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

	public LinkedList<Place> getPlaces() {
		return places;
	}

	public LinkedList<IArc> getArcs() {
		return arcs;
	}

	public LinkedList<Transition> getTransitions() {
		return transitions;
	}

	

}
