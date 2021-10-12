public interface IPetrinet {
	
	public void createPlace(int n);
	public void createTransitition();
	public void createArc();
	public void triggerTransition();
	public void removePlace();
	public void removeArc();
	public void removeTransition();
	
	
}
