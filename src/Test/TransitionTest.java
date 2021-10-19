package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Exception.ImpossibleAction;

import java.util.LinkedList;

import Petri.Arc_classique;
import Petri.IArc;
import Petri.Place;
import Petri.Transition;
import Petri.Arc_zero;
import Petri.Arc_videur;
public class TransitionTest {

    public static Transition setup(int jetons1, int jetons2, int weight1, int weight2, String type) throws ImpossibleAction {
    	
    	Place p1 = new Place(jetons1);
		Place p2 = new Place(jetons2);
		IArc a_e = null;
    	if (type.equals("classique")) {
    		a_e = new Arc_classique(p1,weight1);
    		
    	}
    	if (type.equals("videur")) {
    		a_e = new Arc_videur(p1);
    	}
    	
    	if (type.equals("zero")) {
    		a_e = new Arc_zero(p1);
    	}
    	
    	
    	IArc a_s = new Arc_classique(p2,weight2);
		LinkedList<IArc> e = new LinkedList<IArc>();
		LinkedList<IArc> s = new LinkedList<IArc>();
		e.add(a_e);
		s.add(a_s);
        
        return new Transition(e,s);  
    }
    
    @Test
    public void constructorTest() {
    	Transition t = new Transition(null,null);
    	Assertions.assertEquals(t.getArc_e(), null);
    	Assertions.assertEquals(t.getArc_s(),null);
    }
    
    public static int getNbJetons(LinkedList<IArc>arc_e, int i) {
    	return arc_e.get(i).getPlace().get_nb_jetons();
    }
    
    @Test
    public void triggerTransitionTest() throws ImpossibleAction {
    	
    	//test with classic arc
    	
    	//case 1: transition is possible
    	
    	Transition t1 = this.setup(4,1,2,2,"classique");
    	t1.trigger_transition();
    	
    	LinkedList<IArc> arc_e = t1.getArc_e();
    	LinkedList<IArc> arc_s = t1.getArc_s();
    	
    	Assertions.assertEquals(this.getNbJetons(t1.getArc_e(), 0),2);
    	Assertions.assertEquals(this.getNbJetons(t1.getArc_s(), 0),3);
    	
    	arc_e.clear();
    	arc_s.clear();
    	
    	//case 2: transition is not possible 
    	
    	Transition t2 = this.setup(2,1,3,2,"classique");
    	Assertions.assertEquals(t2.trigger_transition(),false);
    	//test with arc zero
    	
    	//case 1: p1 is empty
    	Transition t3 = this.setup(0,1,2,2,"zero");
    	t3.trigger_transition();
    	
    	Assertions.assertEquals(this.getNbJetons(t3.getArc_e(), 0),0);
    	Assertions.assertEquals(this.getNbJetons(t3.getArc_s(), 0),3);
    	
    	//case 2: p1 is not empty 
    	
    	Transition t4 = this.setup(3,1,2,2,"zero");
    	Assertions.assertEquals(t4.trigger_transition(),false);
    	
    	//test arc videur
    	
    	//case 1: the place is not empty
    	
    	Transition t5 = this.setup(4, 3, 0, 6,"videur");
    	t5.trigger_transition();
    	Assertions.assertEquals(this.getNbJetons(t5.getArc_e(), 0),0);
    	Assertions.assertEquals(this.getNbJetons(t5.getArc_s(), 0),9);
    	
    	//case 2: the place is empty
    	
    	Transition t6 = this.setup(0, 4, 0, 3, "videur");
    	Assertions.assertEquals(t6.trigger_transition(),false);
    	
    	//test transition with more than 2 places
    	
    	Place p1 = new Place(2);
    	Place p2 = new Place(3);
    	Place p3 = new Place(4);
    	Place p4 = new Place(2);
    	
    	IArc a1 = new Arc_classique(p1,2);
    	IArc a2 = new Arc_classique(p2,2);
    	IArc a3 = new Arc_classique(p3,2);
    	IArc a4 = new Arc_classique(p4,2);
    	
    	LinkedList<IArc> a_e = new LinkedList<IArc>();
    	a_e.add(a1);
    	a_e.add(a2);
    	
    	LinkedList<IArc> a_s = new LinkedList<IArc>();
    	a_s.add(a3);
    	a_s.add(a4);
    	
    	Transition t = new Transition(a_e,a_s);
    	t.trigger_transition();
    	Assertions.assertEquals(this.getNbJetons(t.getArc_e(), 0),0);
    	Assertions.assertEquals(this.getNbJetons(t.getArc_e(), 1),1);
    	Assertions.assertEquals(this.getNbJetons(t.getArc_s(), 0),6);
    	Assertions.assertEquals(this.getNbJetons(t.getArc_s(), 1),4);
    	
    	

    }
    
    @Test
    public void addArcTest() throws ImpossibleAction {
    	Transition t = setup(4,2,2,2,"classique");
    	
    	// add a classic arc at the end
    	
    	Place p1 = new Place(2);
    	IArc a1 = new Arc_classique(p1,3);
    	t.addArc(false, a1);
    	Assertions.assertEquals(t.getArc_s().size(), 2);
    	
    	
    	// add a classic arc at the beginning
    	
    	Place p2 = new Place(3);
    	IArc a2 = new Arc_classique(p2,4);
    	t.addArc(true, a2);
    	Assertions.assertEquals(t.getArc_e().size(), 2);
    	
    	// we can't put an arc zero or arc videur at the end of the transition 
    	
    	Place p3 = new Place(1);
    	IArc a3 = new Arc_videur(p3);
    	
    	ImpossibleAction exception = Assertions.assertThrows(ImpossibleAction.class, ()->{t.addArc(false, a3);});
    	Assertions.assertEquals("this kind of arc can't be at the end of a transition",exception.getMessage());
    	
    }	
    
 
}