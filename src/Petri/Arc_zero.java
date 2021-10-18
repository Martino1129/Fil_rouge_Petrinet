package Petri;

public class Arc_zero implements IArc{
	private Place place_a;
	
	public Arc_zero(Place p) {
		this.place_a = p;
	}
	
	public boolean arc_valide() {
		// return true if the transition is possible for this place
		if (this.place_a.get_nb_jetons()==0) {
			return true;
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		//apply the modification due to the transition to the place
		return; 
	}
	

	public String getType() {
		// return the type of the arc
		return "zero";
	}

	public Place getPlace() {
		// return the place associated to the arc
		return place_a;
	}
	
}
