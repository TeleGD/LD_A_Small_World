package world;


public class Room {

	
	//Variables
	private int length;
	private int width;//length et width correspondent au nombre de cases de longueur et de largeur.
	private int entry;//correspond aux nombres de tunnels débouchant sur la salle
	private int sizeMin;//borne sur la taille minimale de la salle
	private int lwMin; //borne sur la taille minimale de la longueur et de la largeur.
	
	
	//Constructeur
	public Room(int l, int w, int e){
		sizeMin=6;
		lwMin=2;
		this.length=l;
		this.width=w;
		this.entry=e;
	}
	
	
	//Getters et Setters
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getEntry() {
		return entry;
	}
	public void setEntry(int entry) {
		this.entry = entry;
	}
	
	
}
