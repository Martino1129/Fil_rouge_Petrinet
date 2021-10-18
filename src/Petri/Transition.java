package Petri;
import java.util.LinkedList;

public class Transition {
        private LinkedList<IArc> arc_e;
        private LinkedList<IArc> arc_s;
        
        public Transition(LinkedList<IArc> arc_e, LinkedList<IArc> arc_s) {
                super();
                this.arc_e = arc_e;
                this.arc_s = arc_s;
        }
        
        public boolean trigger_transition() {
        		for (IArc arc : arc_e) {
                        if (!arc.arc_valide()) {
                                return false;
                        }
        		}
                for (IArc arc : arc_e) {
                        arc.apply_transition(false);
                }
                for (IArc arc : arc_s) {
                        arc.apply_transition(true);
                }
                
                return true;
        }

        public void addArc(boolean sens, IArc a) throws ImpossibleAction{
        	// add an arc to the transition if sens is true, the arc is at the beginning of the transition 
        	if (sens) {
        		this.arc_e.add(a);
        	} else {
        		if (a.getType().equals("videur")||a.getType().equals("zero")) {
        			throw new ImpossibleAction("ce type d'arc ne peut pas �tre en sortie d'une transition");
        		}
        		this.arc_s.add(a);
        	}
        }

		  public LinkedList<IArc> getArc_e() {
			  return arc_e;
		  }

		  public void setArc_e(LinkedList<IArc> arc_e) {
			  this.arc_e = arc_e;
		  }

		  public LinkedList<IArc> getArc_s() {
			  return arc_s;
		  }

		  public void setArc_s(LinkedList<IArc> arc_s) {
			  this.arc_s = arc_s;
		  }
        

}