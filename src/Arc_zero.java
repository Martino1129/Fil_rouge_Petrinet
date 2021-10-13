
public class Arc_zero implements IArc{
	private Place place_a;
	
	public Arc_zero(Place p) {
		this.place_a = p;
	}
	
	public boolean arc_valide() {
		if (this.place_a.get_nb_jetons()==0) {
			return true;
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		return; 
	}
	
	public Place getPlace() {
		return place_a;
	}
	
}
