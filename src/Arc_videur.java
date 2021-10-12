
public class Arc_videur extends Arc{
	
	public Arc_videur(Place p) {
		super(p);
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
}
