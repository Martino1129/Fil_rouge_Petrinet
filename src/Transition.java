import java.util.LinkedList;

public class Transition {
        private LinkedList arc_e;
        private LinkedList arc_s;
        
        public Transition(LinkedList arc_e, LinkedList arc_s) {
                super();
                this.arc_e = arc_e;
                this.arc_s = arc_s;
        }
        
        public boolean trigger_transition() {
                        if (!arc.arc_valide()) {
                                return false;
                        }
                }
                for (Arc arc : arc_e) {
                        arc.apply_transition(false);
                }
                for (Arc arc : arc_s) {
                        arc.apply_transition(true);
                }
                
                return true;
        }
}