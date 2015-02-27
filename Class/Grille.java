
public class Grille {
	
	private Cube[] Field = new Cube[16];
	private int Final;
	
	//Constructeur d'initalisation
	public Grille(){
		for (int i=0; i<16 ;i++)
			Field[i] = new Cube(0);
	}
	
	//Constructeur de copie
	public void builder(Grille other){
		this.copy(other);
	}
	
	//Procédure de copie
	public void copy(Grille other)
	{
		for (int i=0;i<16;i++)
			this.Field[i] = other.Field[i];
	}
	
	//Get d'un champs du tableau de Cube Field
	public Cube getField(int position){
		return this.Field[position];
	}
	
	public void setFinal(int nombre){
		this.Final = nombre;
	}
	
	//Génère le cube aléatoire
	public void setRandomCube(){
		int Alea = (int) (Math.random() * this.getCubeEmpty().length);
		this.Field[Alea].setValue(4) ;	
	}
	
	//Retourne un tableau contenant tous les cubes vides
	private int[] getCubeEmpty(){
		int[] returning = new int[this.getNbrEmptyCube()];
		int cpt = 0;
				
		for(int i = 0; i < 16; i++)
			if (this.Field[i].getValue() == 0)
				returning[cpt] = i;
				cpt++;
				
		return returning;		
	}
	
	//Retourne le nombre de cube vide
	public int getNbrEmptyCube(){
		int cpt = 0;
		for(int i = 0; i < 16; i++)
			if (this.Field[i].getValue() == 0)
				cpt++;
		
		return cpt;
	}
	
	//Procédure gérant la phase de mouvement
	public int move(int direction){
		switch (direction){
		case 8 : return this.moveUp();
		case 2 : return this.moveDown();
		case 4 : return this.moveLeft();
		case 6 : return this.moveRight();
		default : return 0;
		}
	}
	
	//Procédure de mouvement vers le haut des cubes
	private int moveUp(){
		int score = 0;
		
		for (int j=0;j<4;j++)
			for (int i=0; i<12; i++)
				score += Field[i].receiveCube(Field[i+4]);
		
		return score;
	}
	
	//Procédure de mouvement vers le bas des cubes
	private int moveDown(){
		int score = 0;
		
		for (int j=0;j<4;j++)
			for (int i=15; i>3; i--)
				score += Field[i].receiveCube(Field[i-4]);
		
		return score;
	}
	
	//Procédure de mouvement vers la gauche des cubes
	private int moveLeft(){
		int score = 0;
		
		for (int j=0;j<4;j++){
			for (int i=12; i<15; i++)
				score += Field[i].receiveCube(Field[i+1]);
			for (int i=8; i<11; i++)
				score += Field[i].receiveCube(Field[i+1]);
			for (int i=4; i<7; i++)
				score += Field[i].receiveCube(Field[i+1]);
			for (int i=0; i<3; i++)
				score += Field[i].receiveCube(Field[i+1]);
		}
		return score;
	}

	
	//Procédure de mouvement vers la droite des cubes
	private int moveRight(){
		int score = 0;
		
		for (int j=0;j<4;j++){
			for (int i=15; i>12; i--)
				score +=  Field[i].receiveCube(Field[i-1]);
			for (int i=11; i>8; i--)
				score += Field[i].receiveCube(Field[i-1]);
			for (int i=7; i>4; i--)
				score += Field[i].receiveCube(Field[i-1]);
			for (int i=3; i>0; i--)
				score += Field[i].receiveCube(Field[i-1]);
		}
		return score;
	}
	
	//Fonction de test sur les conditions d'arrêt du jeu
	public boolean isOver(){
		for(int i=0; i<16;i++){
			if (this.getField(i).getValue() == this.Final){
				System.out.println("");
				System.out.println("                               .--.          ");
				System.out.println("                     ::\\`--._,'.::.`._.--'/:: ");
				System.out.println("                     ::::.  ` __::__ '  .:::: ");
				System.out.println("                     ::::::-:.`'..`'.:-::::::");
				System.out.println("                     ::::::::\\ `--' /:::::::: ");
				System.out.println("");
				System.out.println("");
				System.out.println("                     VAINCU TU AS, JEUNE PADAWAN");
				return true;
			}
		}
		if (this.getNbrEmptyCube() == 0){
			System.out.println("     PERDU TU AS, JEUNE PADAWAN ");
			return true;
		}
		
		return false;
	}
	
	//Affiche le tableau en ligne (uniquement pour le developpement)
	public String toString(){
		String returning = "";
		
		for (int i=0; i<16;i++)
			returning += this.Field[i].getValue() + ".";
		
		return returning;
	}
}
