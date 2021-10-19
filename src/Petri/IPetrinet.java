package Petri;

import java.util.LinkedList;



import Exception.ImpossibleAction;
import Exception.TypeException;

public interface IPetrinet {
	

	public void addPlace(Place p);

	public void createPlace(int n) throws ImpossibleAction;

	
	public void addTransition(Transition transition);
	
	public void addArc(IArc arc, String type, boolean sens, Transition t) throws TypeException,ImpossibleAction;
				
	public void removeTransition(Transition transition);

	public void removeArc(IArc arc);

	public void removePlace(Place place);

	public void triggerTransition(Transition transition);
	
	
	
}
