
public class Arc_zero extends Arc{
	
	
	public Arc_zero(Place p) {
		super(p);
	}
	
	public boolean Arc_valide() {
		if (this.place_a.get_nb_jetons()==0) {
			return true;
		}
		return false;
	}
	
	public void apply_transition(boolean sens) {
		return; 
	}
	
	
}
