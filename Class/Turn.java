
public class Turn {
	
	private Grille GrilleTurn;
	private int Numero;
	private int Score = 0;
	
	//Constructeur d'initialisation
	public Turn(){
		this.GrilleTurn = new Grille();
	}
	
	public Turn(Grille NewGrille){
		this.getGrilleTurn().builder(NewGrille);
	}
	
	//Get de la GrilleTurn
	public Grille getGrilleTurn() {
		return this.GrilleTurn;
	}

	//Get inutile ?
	public void setGrilleTurn(Grille grilleTurn) {
		this.GrilleTurn = grilleTurn;
	}
	
	//Get du numero
	public int getNumero(){
		return this.Numero;
	}
	
	//Get du score
	public int getScore(){
		return this.Score;
	}
	
	//Initialisation du tour avec la grille
	public void iniTurn(){
		this.getGrilleTurn().setRandomCube();
		this.generateGrille();
	}
	
	//Gère le déroulement du tour
	public boolean action(int direction){
		this.Score += this.getGrilleTurn().move(direction);
		this.iniTurn();
		this.Numero++;
		return  this.getGrilleTurn().isOver();
	}
	
	
	//Procédure de générate de la grille en console
	public void generateGrille(){
		
		System.out.println("                 -------------------------------------");
		System.out.print("                 |  ");
		for (int i=0; i<4;i++)
			this.affiche(this.GrilleTurn.getField(i).getValue(),i);
		
		System.out.println("");
		System.out.println("                 -------------------------------------");
		System.out.print("                 |  ");
		for (int j=4; j<8;j++)
			this.affiche(this.GrilleTurn.getField(j).getValue(),j);

		System.out.println("");
		System.out.println("                 -------------------------------------");
		System.out.print("                 |  ");
		for (int k=8; k<12;k++)
			this.affiche(this.GrilleTurn.getField(k).getValue(),k);
		
		System.out.println("");
		System.out.println("                 -------------------------------------");
		System.out.print("                 |  ");
		for (int l=12; l<16;l++)
			this.affiche(this.GrilleTurn.getField(l).getValue(),l);
	
		System.out.println("");
		System.out.println("                 -------------------------------------                         Score : " + this.Score);
		
		System.out.println("");
		//System.out.println(this.getGrilleTurn().toString());
		System.out.println("");			
	}
	
	//Calcul et affiche avec le bon espacement les valeur dans les cases
	private void affiche(int nombre, int i){
		int size = Integer.toString(nombre).length();
		
		if (this.GrilleTurn.getField(i).getValue() != 0)
			switch (size){
				case 1 : System.out.print("  " + nombre  + "   |  ");break;
				case 2 : System.out.print(" " +  nombre  + "   |  ");break;
				case 3 : System.out.print(" "+  nombre + "  |  ");break;
				case 4 : System.out.print(nombre + "  |  "  );break;
		}
		else
			System.out.print("    " + "  |  ");
	}
	
	//Affiche le X-WING de la muerte !
	public void printIntro(){
		System.out.println("");
		System.out.println("                        2048 BAD'ASS JEDI EDITION");
		System.out.println("");
		System.out.println("          .                            .                      .");
		System.out.println("  .                  .             -)------+====+       .");
		System.out.println("                          -)----====    ,'   ,'   .                 .");
		System.out.println("             .                  `.  `.,;___,'                .");
		System.out.println("                                  `, |____l_|");
		System.out.println("                     _,....------c==]\"\"______ |,,,,,,.....____ _");
		System.out.println("    .      .        \"-:_____________  |____l_|]'''''''''''       .     .");
		System.out.println("                                 ,'\"\",'.   `.");
		System.out.println("        .                 -)-----====   `.   `.              ");
		System.out.println("                     .            -)-------+====+       .            .");
		System.out.println("             .                               .");
		System.out.println("");
		System.out.println("             VA CASSER DE L'IMPERIAL DANS TON SUPER X-WING                ");
		System.out.println("                        EN RESOLVANT UN 2048                ");
		System.out.println("               PARCE QUE L'EMPIRE C'EST QUE DES BOUSEUX                ");
		System.out.println("   MONTRE A CES TIE-FIGHTER CE QUE TU SAIS FAIRE AVEC LES PUISSANCES DE 2 !               ");
		System.out.println("");
		System.out.println("");
	}
	
}
