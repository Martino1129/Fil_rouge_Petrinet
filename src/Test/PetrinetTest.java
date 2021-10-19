package Test;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import Petri.Arc_classique;
import Petri.Arc_videur;
import Petri.Arc_zero;
import Petri.IArc;
import Petri.ImpossibleAction;
import Petri.Petrinet;
import Petri.Place;
import Petri.Transition;
import Petri.TypeException;

@TestMethodOrder(OrderAnnotation.class)

public class PetrinetTest {
	
	static Petrinet petrinet = null;
	static Place P1 = null;
	static Place P2 = null;
	static IArc T1P1 = null;
	static IArc T2P1 = null;
	static IArc P1T3 = null;
	static IArc T3P2 = null;
	static IArc P2T1 = null;
	static IArc P2T3 = null;
	static IArc P2T2 = null;
	static Transition T1 = null;
	static Transition T2 = null;
	static Transition T3 = null;

	
	@BeforeAll
	static void setup() throws TypeException, ImpossibleAction {
		
		System.out.println("Implementation de petrinet");
		/**
		 * Firstly we create a pretri diagram, then 2 places , 3 Transitions and 7 arcs
		 */
		petrinet = new Petrinet(new LinkedList <Place>(), new LinkedList <IArc>(),new  LinkedList <Transition>());
		
		P1 = new Place(2);
		P2 = new Place(5);
		
		petrinet.addPlace(P1);
		petrinet.addPlace(P2);

		
		T1P1 = new Arc_classique(P1,2);
		T2P1 = new Arc_classique(P1,2);
		P1T3 = new Arc_classique(P1,1);
		T3P2 = new Arc_classique(P2, 4);
		P2T1 = new Arc_classique(P2,4);
		P2T3 = new Arc_videur(P2);
		P2T2 = new Arc_zero(P2);

		T1 = new Transition(new LinkedList<IArc>(),new LinkedList<IArc>());
		T2 = new Transition(new LinkedList<IArc>(),new LinkedList<IArc>());
		T3 = new Transition(new LinkedList<IArc>(),new LinkedList<IArc>());


		petrinet.addArc(T1P1, "classique", false, T1);
		petrinet.addArc(T2P1, "classique", false, T2);
		petrinet.addArc(P1T3, "classique", true, T3);
		petrinet.addArc(T3P2, "classique", false, T3);
		petrinet.addArc(P2T1, "classique", true, T1);
		petrinet.addArc(P2T3, "videur", true, T3);
		petrinet.addArc(P2T2, "zero", true, T2);
	
		petrinet.addTransition(T1);
		petrinet.addTransition(T2);
		petrinet.addTransition(T3);
		System.out.println();

	}
	@Order(1)
	@Test
	public void testPlaces() throws TypeException, ImpossibleAction {

		Assertions.assertEquals(petrinet.getPlaces().size(),2);
		
		Assertions.assertEquals(petrinet.getPlaces().get(0), P1);
		Assertions.assertEquals(petrinet.getPlaces().get(1), P2);
		
		System.out.println("Places: OK");
	}
	
	@Order(2)
	@Test
	public void testTransitions() throws TypeException, ImpossibleAction {

		Assertions.assertEquals(petrinet.getTransitions().size(),3);
		
		Assertions.assertEquals(petrinet.getTransitions().get(0), T1);
		Assertions.assertEquals(petrinet.getTransitions().get(1), T2);
		System.out.println("Transitions: OK");
	}
	
	@Order(3)
	@Test
	public void testArcs() throws TypeException, ImpossibleAction {

		Assertions.assertEquals(petrinet.getArcs().size(),7);
		Assertions.assertEquals(petrinet.getArcs().get(1), T2P1);
		Assertions.assertEquals(petrinet.getArcs().get(5), P2T3);
		Assertions.assertTrue(petrinet.getArcs().contains(T1P1));
		Assertions.assertTrue(petrinet.getArcs().contains(P1T3));

		
		Assertions.assertEquals(T1.getArc_e().size(),1);
		Assertions.assertTrue(T1.getArc_e().contains(P2T1));
		Assertions.assertEquals(T1.getArc_s().size(),1);
		Assertions.assertTrue(T1.getArc_s().contains(T1P1));
		
		Assertions.assertEquals(T3.getArc_e().size(),2);
		Assertions.assertEquals(T3.getArc_s().size(),1);
		Assertions.assertTrue(T3.getArc_e().contains(P2T3));
		Assertions.assertTrue(T3.getArc_e().contains(P1T3));
		Assertions.assertTrue(T3.getArc_s().contains(T3P2));
		

		System.out.println("Arcs: OK");

	}
	
	@Order(4)
	@Test
	public void testT1() throws TypeException, ImpossibleAction {
		petrinet.triggerTransition(T1);
		System.out.println("T1 Triggered, checking if petrinet is not damaged");
		testPlaces();
		testTransitions();
		testArcs();
	}
	@Order(5)
	@Test
	public void testT1x5() throws TypeException, ImpossibleAction {
		petrinet.triggerTransition(T1);
		petrinet.triggerTransition(T1);
		petrinet.triggerTransition(T1);
		petrinet.triggerTransition(T1);
		petrinet.triggerTransition(T1);

		System.out.println("T1 Triggered, checking if petrinet is not damaged");
		testPlaces();
		testTransitions();
		testArcs();
	}
	@Order(6)
	@Test
	public void testT2() throws TypeException, ImpossibleAction {
		petrinet.triggerTransition(T2);
		System.out.println("T2 Triggered, checking if petrinet is not damaged");
		testPlaces();
		testTransitions();
		testArcs();
	}
	
	@Order(7)
	@Test
	public void testT3() throws TypeException, ImpossibleAction {
		petrinet.triggerTransition(T3);
		System.out.println("T3 Triggered, checking if petrinet is not damaged");
		testPlaces();
		testTransitions();
		testArcs();
	}
	
	@Order(7)
	@Test
	public void testremoveArc() throws TypeException, ImpossibleAction {
		petrinet.removeArc(P2T3);
/*		Assertions.assertTrue(T3.getArc_e().contains(P2T3)); */
		Assertions.assertEquals(petrinet.getArcs().size(), 6);
		System.out.println("");

	}
}
