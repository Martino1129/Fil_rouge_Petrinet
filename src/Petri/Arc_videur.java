package Petri;

public class Arc_videur implements IArc{
	private Place place_a;
	
	public Arc_videur(Place p){
		this.place_a= p;
	}
	
	public boolean arc_valide() {
		// return true if the transition is possible for this place
		if (this.place_a.get_nb_jetons()>0) {
			return true;
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		//apply the modification due to the transition to the place
		if (sens == false) { // the arc points the transition if sens equals true 
			this.place_a.modify_nb_jetons(0);
		}
		return;
	}

	public String getType() {
		// return the type of the arc
		return "videur";
  }
  
  public Place getPlace() {
	// return the place associated to the arc
    return place_a;
	}
}
