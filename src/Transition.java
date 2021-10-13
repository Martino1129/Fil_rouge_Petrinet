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