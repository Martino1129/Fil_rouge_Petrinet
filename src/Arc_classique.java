
public class Arc_classique implements IArc{
	private int nb_jetons;
	private Place place_a;
	
	public Arc_classique(Place p, int n) {
		this.place_a = p;
		this.nb_jetons = n;
		
	}
	public boolean arc_valide() {
		if (this.nb_jetons <= this.place_a.get_nb_jetons()) {
			return true; 
			//test 
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
	
	public String getType() {
		return "classique";
	}

}
