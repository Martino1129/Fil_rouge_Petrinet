
public class Arc_classique extends Arc{
	private int nb_jetons;
	
	public Arc_classique(Place p, int n) {
		super(p);
		this.nb_jetons = n;
		
	}
	
	public boolean arc_valide() {
		if (this.nb_jetons <= this.place_a.get_nb_jetons()) {
			return true; 
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		// si sens == true, la place est après la transition 
		if (sens == true) { 
			this.place_a.modify_nb_jetons(this.place_a.get_nb_jetons()+this.nb_jetons);
		}
		else { 
			this.place_a.modify_nb_jetons(this.place_a.get_nb_jetons()-this.nb_jetons);
		}
		
		
	}

}
