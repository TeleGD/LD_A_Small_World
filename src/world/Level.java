package world;


public class Level {
	
	
	//Variables
	private int id;
	private int length;
	private int width;//length et width correspondent au nombre de cases de longueur et de largeur.
	private int rooms;
	public Cell grid[][];
	
	
	//Constructeur
	public Level(int id, int l, int w, int r){
		this.id=id;
		this.length=l;
		this.width=w; 
		this.rooms=r;
		this.grid=initLevel(l,w);
	}
	
	
	//Permet de créer une matrice de Cell
	private Cell[][] initLevel(int maxRows, int maxCols){
		Cell level[][] = new Cell[maxRows][maxRows];
		for(int i = 0; i<maxRows; i++)//init row
			for(int j=0;j<maxCols;j++) //init column
				level[i][j] = new Cell(i,j);
		return level;
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
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

}
