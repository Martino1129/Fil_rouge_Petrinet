package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import Exception.ImpossibleAction;
import Petri.Arc_classique;
import Petri.Arc_videur;
import Petri.Arc_zero;
import Petri.IArc;
import Petri.Place;
import Petri.Transition;


public class IArcTest {
	
	static Place p1 = null; 
	static Place p2 = null;
	static Place p3 = null;
	static Place p4 = null;
	static IArc a1 = null; 
	static IArc a2 = null; 
	static IArc a3 = null; 
	static IArc a4 = null;
	
	
	static void setup() throws ImpossibleAction {
		
		p1 = new Place(3);
		p2 = new Place(2);
		p3 = new Place(0);
		p4 = new Place(3);
		
		a1 = new Arc_classique(p1,3);
		a2 = new Arc_classique(p3,3);
		a3 = new Arc_videur(p2);
		a4 = new Arc_zero(p4);
		
		
	}
	
	@Test 
	public void arc_valideTest() throws ImpossibleAction {
		this.setup();
		
		Assertions.assertEquals(a1.arc_valide(),true);
		Assertions.assertEquals(a2.arc_valide(), false);
		Assertions.assertEquals(a3.arc_valide(),true);
		Assertions.assertEquals(a4.arc_valide(),false);
	}
	
	@Test
	public void apply_transitionTest() {
		
		a1.apply_transition(true);
		Assertions.assertEquals(p1.get_nb_jetons(), 6);
		a1.apply_transition(false);
		Assertions.assertEquals(p1.get_nb_jetons(), 3);
		a3.apply_transition(false);
		Assertions.assertEquals(p2.get_nb_jetons(), 0);
		a4.apply_transition(false);
		Assertions.assertEquals(p4.get_nb_jetons(),3);
		
		
		
		
	}
	
	@Test
	public void getTypeTest() {
		
		Assertions.assertEquals(a1.getType(),"classique");
		Assertions.assertEquals(a3.getType(), "videur");
		Assertions.assertEquals(a4.getType(), "zero");
	}

}
