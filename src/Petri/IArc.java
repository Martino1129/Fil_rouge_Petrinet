package Petri;

public interface IArc {
	
	public boolean arc_valide();
	public void apply_transition(boolean sens);

	public String getType();

	public Place getPlace();

	
}
