package cfranc.hanoi;

public class Hanoi {
	
	Tour tourInit;
	Tour tourInter;
	Tour tourDest;

	public Hanoi(int n){
		tourInit = new Tour(n);
		tourInter = new Tour(n);
		tourDest = new Tour(n);

		for (int i=1; i<=n; i++) {
			Disque disque = new Disque(i);
			tourInit.empiler(disque);
		}
	}

	
	public Hanoi(){
		tourInit = new Tour();
		tourInter = new Tour();
		tourDest = new Tour();
		Disque petit = new Disque(1);
		Disque moyen = new Disque(2);
		Disque grand = new Disque(3);
		tourInit.empiler(grand);
		tourInit.empiler(moyen);
		tourInit.empiler(petit);
	}
	
	public void bougerSommet(Tour from, Tour to) {
		if (from.taille()>0){
			Disque temp = from.depiler();
			to.empiler(temp);
		}
	}

	public void deplacer(int nbDisque, Tour from, Tour to, Tour by){
		if (nbDisque > 0) {
			deplacer(nbDisque-1, from, to, by);
			bougerSommet(from, to);
			deplacer(nbDisque-1, by, to, from);
		}
	}

	public void jouer() {
		deplacer(tourInit.taille(), tourInit, tourDest, tourInter);
	}

	public static void main(String[] args) {
		// Compléter la classe Hanoi pour résoudre le jeux avec 3 disques :
		Hanoi game = new Hanoi();
		System.out.println(game.tourInit.estVide());
		System.out.println(game.tourDest.estVide());
		game.jouer();
		System.out.println("Start Game");
		System.out.println(game.tourInit.estVide());
		System.out.println(game.tourDest.estVide());
		
		//Compléter la classe Hanoi pour résoudre le jeux avec n disques :
		System.out.println("///////////");
		int n =100;
		Hanoi gameN = new Hanoi(n);
		System.out.println(gameN.tourInit.estVide());
		System.out.println(gameN.tourDest.estVide());
		gameN.jouer();
		System.out.println(gameN.tourInit.estVide());
		System.out.println(gameN.tourDest.estVide());
		
	}

}