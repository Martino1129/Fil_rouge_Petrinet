
public class Place {
	private int nombre_jetons;
	
	public Place(int n) {
		this.nombre_jetons = n;
	}
	
	public int get_nb_jetons() {
		return nombre_jetons;
	}
	
	public void modify_nb_jetons(int n) {
		nombre_jetons = n;
	}
	
	public static void main(String[] args) {
		
		Place p = new Place(4);
		System.out.println(p.get_nb_jetons());
		p.modify_nb_jetons(5);
		System.out.println(p.get_nb_jetons());
		
	}
}