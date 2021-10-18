package Petri;

public class Arc_classique implements IArc{
	private int nb_jetons;
	private Place place_a;
	
	public Arc_classique(Place p, int n) {
		this.place_a = p;
		this.nb_jetons = n;
		
	}
	public boolean arc_valide() {
		// return true if the transition is possible for this place
		if (this.nb_jetons <= this.place_a.get_nb_jetons()) {
			return true; 
			//test
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		//apply the modification due to the transition to the place
		
		if (sens == true) { // the arc points the transition
			this.place_a.modify_nb_jetons(this.place_a.get_nb_jetons()+this.nb_jetons);
		}
		else { 
			this.place_a.modify_nb_jetons(this.place_a.get_nb_jetons()-this.nb_jetons);
		}
	}
	
	public String getType() {
		// return the type of the arc
		return "classique";
	}
	public Place getPlace() {
		// return the place associated to the arc
		return place_a;
	}
}
