
import java.util.Scanner; 
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Game();
	}
	
	//Affiche le texte d'aide
	public static void afficheHelp(){
		System.out.println("             Saisir \"2\" pour bouger la grille vers le bas");
		System.out.println("             Saisir \"4\" pour bouger la grille vers la droite");
		System.out.println("             Saisir \"8\" pour bouger la grille vers le haut");
		System.out.println("             Saisir \"6\" pour bouger la grille vers la droite");
		System.out.println("             Saisir \"Sith\" pour embrasser le coté obscure avec la triche ");
		System.out.println("             Saisir \"Force-\" pour revenir dans le temps");
		System.out.println("                  QUE LA FORCE SOIT AVEC TOI PETIT PADAWAN");
		System.out.println("");
	}
	
	//Gestion de la triche
	public static void triche(Turn Tour){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("        Choisi le numero du cube a changer (de 0 à 15)");
		String saisieCube = sc.nextLine();
		if (Integer.parseInt(saisieCube) >15 || Integer.parseInt(saisieCube) < 0){
			System.out.println("");
			System.out.println("    Concentre toi jeune padawan !");
			triche(Tour);
		}
		System.out.println("        Choisi la nouvelle valeur pour ce cube");
		String saisieValeur = sc.nextLine();
		Tour.getGrilleTurn().getField(Integer.parseInt(saisieCube)).setValue(Integer.parseInt(saisieValeur));
		Tour.generateGrille();
		sc.close();
		
	}
	
	//Gestion des tours de jeu
	public static void Game(){
		Turn Tour = new Turn();
		 ArrayList<Turn> ListTour = new ArrayList<Turn>();
		boolean Fin = false;
		Scanner sc1 = new Scanner(System.in);
		
		Tour.printIntro();
		
		System.out.println("        Choisi la valeur a atteindre pour ne faire qu'un avec la FORCE");
		String saisieNombre = sc1.nextLine();
		Tour.getGrilleTurn().setFinal(Integer.parseInt(saisieNombre));
		
		Tour.iniTurn();
		
		while (!Fin){
			System.out.println("    Choisi où faire feu, jeune JEDI ! (ou \"Que la force soit avec moi\" pour l'aide)");
			
			String saisie = sc1.nextLine();
			
			switch (saisie){
				case "2" : case "4" : case "6" : case "8":
					Fin = Tour.action(Integer.parseInt(saisie));
					ListTour.add(Tour);
					break;
				case "Que la force soit avec moi":
					afficheHelp();
					Tour.generateGrille();
					break;
				case "Sith":
					triche(Tour);
					Fin = Tour.getGrilleTurn().isOver();
					break;
				case "Force-":
					if (Tour.getNumero() != 0){
						Tour.getGrilleTurn().copy(ListTour.get(Tour.getNumero()-1).getGrilleTurn());
					}
					Tour.generateGrille();
					break;
				default :
					System.out.println("");
					System.out.println("        Concentre toi PADAWAN, c'est une saisie incorrecte !");
					break;
			}
		}
		sc1.close();
	}
}
