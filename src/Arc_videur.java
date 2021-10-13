
public class Arc_videur implements IArc{
	private Place place_a;
	
	public Arc_videur(Place p){
		this.place_a= p;
	}
	
	public boolean arc_valide() {
		if (this.place_a.get_nb_jetons()>0) {
			return true;
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		if (sens == false) {
			this.place_a.modify_nb_jetons(0);
		}
		return;
	}
	
	public Place getPlace() {
		return place_a;
	}
}
