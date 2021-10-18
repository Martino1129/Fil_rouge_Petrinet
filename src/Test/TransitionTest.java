package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.LinkedList;

import Petri.Arc_classique;
import Petri.IArc;
import Petri.Place;
import Petri.Transition;
import Petri.Arc_zero;
import Petri.Arc_videur;

public class TransitionTest {

    public static Transition setup(int jetons1, int jetons2, int weight1, int weight2, String type) {
    	
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
    
    public static int getNbJetons(LinkedList<IArc>arc_e, int i) {
    	return arc_e.get(i).getPlace().get_nb_jetons();
    }
    
    @Test
    public void triggerTransitionTest() {
    	
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
    	
    	

    }
    

}