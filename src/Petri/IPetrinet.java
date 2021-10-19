package Petri;
<<<<<<< HEAD
<<<<<<< HEAD:src/Petri/IPetrinet.java
import java.util.LinkedList;

=======
>>>>>>> mdev:src/IPetrinet.java
=======

import Exception.ImpossibleAction;
import Exception.TypeException;

>>>>>>> mdev
public interface IPetrinet {
	
	public void createPlace(int n) throws ImpossibleAction;
	
	public void createTransitition();
	
	public void createArc(Place place, String type, int nb_jetons, boolean sens, Transition t) throws TypeException,ImpossibleAction ;
				
	public void removeTransition(Transition transition);

	public void removeArc(IArc arc);

	public void removePlace(Place place);

  public void triggerTransition(Transition transition);
	
	
}
