package Petri;

import Exception.ImpossibleAction;

public class Place {
	private int nombre_jetons;
	
	public Place(int n) throws ImpossibleAction {
		if (n<0) {
			throw new ImpossibleAction("nb_jetons can't be negative");
		}
		this.nombre_jetons = n;
	}
	
	public int get_nb_jetons() {
		return nombre_jetons;
	}
	
	public void modify_nb_jetons(int n) {
		nombre_jetons = n;
	}
}
