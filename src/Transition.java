import java.util.LinkedList;

public class Transition {
        private LinkedList<IArc> arc_e;
        private LinkedList<IArc> arc_s;
        
        public Transition(LinkedList arc_e, LinkedList arc_s) {
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
}