
public class Cube {
	
	private int value;
	
	//Constructeur
	public Cube(int value){
		this.value = value;
	}
	
	//Get de la value
	public int getValue() {
		return value;
	}
	
	//Set de la Value
	public void setValue(int value) {
		this.value = value;
	}
	
	//Procédure de reception d'un cube par un autre
	public int receiveCube(Cube other){
		if (this.AreAddable(other))
			return this.addCube(other);

		if (other.getValue() != 0 && this.value == 0){
			this.setValue(other.getValue());
			other.setValue(0);
		}
		return 0;
	}
	
	//Procédure d'ajout des valeurs des cubes
	private int addCube(Cube other){
		this.value += other.value;
		other.setValue(0);
		return this.value;
	}
	
	//Procédure vérifiant la compatibilité des cubes lors d'une eventuellement addition
	private boolean AreAddable(Cube other){
		if (this.getValue() != other.getValue() || other.getValue() == 0 && this.getValue() == 0)
			return false;
		else 
			return true;
	}
	
}
