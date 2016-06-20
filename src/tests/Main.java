package tests;

import exact.BranchBound;
import exact.MethodeExact;
import metaheuristique.MethodeDescente;
import metaheuristique.MethodeTaboo;
import metaheuristique.Population;
import metaheuristique.RecuitSimule;
import pvc.VC;

public class Main {
	/**
	 * LA methode descente
	 * @param vc
	 * @throws CloneNotSupportedException
	 */
	public static void testdescente(VC vc) throws CloneNotSupportedException {
		//
		MethodeDescente desc = new MethodeDescente(vc);
		System.out.println("=====================> Solution Initiale <============================");
		System.out.println(desc.getSolution().toString());
		System.out.println("Cout : "+desc.getSolution().getCout(vc));
		System.out.println("======================================================================");
		long start = System.nanoTime();
		desc.resoudre();
		long end = System.nanoTime(); 
		System.out.println("=======================> Solution Finale <============================");
		System.out.println(desc.getSolution().toString());
		System.out.println("Cout : "+desc.getSolution().getCout(vc));
		System.out.println("======================================================================");
		System.out.println("=========================> Temps Ecoulé <=============================");
		System.out.println((end-start)/1000+" us");
		//
	}
	/**
	 * LA methode tabo
	 * @param vc
	 * @throws CloneNotSupportedException
	 */
	public static void testtaboo(VC vc) throws CloneNotSupportedException {
		//
		MethodeTaboo taboo = new MethodeTaboo(vc);
		System.out.println("=====================> Solution Initiale <============================");
		System.out.println(taboo.getSolution().toString());
		System.out.println("Cout : "+taboo.getSolution().getCout(vc));
		System.out.println("======================================================================");
		long start = System.nanoTime();
		taboo.resoudre();
		long end = System.nanoTime(); 
		System.out.println("=======================> Solution Finale <============================");
		System.out.println(taboo.getSolution().toString());
		System.out.println("Cout : "+taboo.getSolution().getCout(vc));
		System.out.println("======================================================================");
		System.out.println("=========================> Temps Ecoulé <=============================");
		System.out.println((end-start)/1000+" us");
		//
	}
	/**
	 * LA methode recuit simule
	 * @param vc
	 * @throws CloneNotSupportedException
	 */
	public static void testRS(VC vc) throws CloneNotSupportedException {
		//
		RecuitSimule rs = new RecuitSimule(vc);
		System.out.println("=====================> Solution Initiale <============================");
		System.out.println(rs.getSolution().toString());
		System.out.println("Cout : "+rs.getSolution().getCout(vc));
		System.out.println("======================================================================");
		long start = System.nanoTime();
		rs.resoudre();
		long end = System.nanoTime(); 
		System.out.println("=======================> Solution Finale <============================");
		System.out.println(rs.getSolution().toString());
		System.out.println("Cout : "+rs.getSolution().getCout(vc));
		System.out.println("======================================================================");
		System.out.println("=========================> Temps Ecoulé <=============================");
		System.out.println((end-start)/1000+" us");
		//
	}
	/**
	 * L'algorithme genetique
	 * @param vc
	 * @throws CloneNotSupportedException
	 */
	public static void testgenetique(VC vc) throws CloneNotSupportedException {
		//
		Population pop = new Population(vc, vc.getTaille());
		System.out.println("=====================> Solution Initiale <============================");
		System.out.println(pop.getSolution().toString());
		System.out.println("Cout : "+pop.getSolution().getCout(vc));
		System.out.println("======================================================================");
		long start = System.nanoTime();
		pop.resoudre();
		long end = System.nanoTime(); 
		System.out.println("=======================> Solution Finale <============================");
		System.out.println(pop.getSolution().toString());
		System.out.println("Cout : "+pop.getSolution().getCout(vc));
		System.out.println("======================================================================");
		System.out.println("=========================> Temps Ecoulé <=============================");
		System.out.println((end-start)/1000+" us");
		//
	}
	/**
	 * 
	 * @param vc
	 * @throws CloneNotSupportedException
	 */
	public static void testbranchboundlimite(VC vc) throws CloneNotSupportedException {
		//
		BranchBound branch = new BranchBound(vc);
		System.out.println("=====================> Solution trouvée <=============================");
		long start = System.nanoTime();
		branch.resoudre();
		long end = System.nanoTime(); 
		System.out.println(branch.getSolution().toString());
		System.out.println("Cout : "+branch.getSolution().getCout(vc));
		System.out.println("======================================================================");
		System.out.println("=========================> Temps Ecoulé <=============================");
		System.out.println((end-start)/1000+" us");
		//
	}
	/**
	 * La methode exact
	 * @param vc
	 * @throws CloneNotSupportedException
	 */
	public static void testexact(VC vc) throws CloneNotSupportedException {
		//
		MethodeExact exact = new MethodeExact(vc);
		System.out.println("=====================> Solution trouvée <=============================");
		long start = System.nanoTime();
		exact.resoudre();
		long end = System.nanoTime(); 
		System.out.println(exact.getSolution().toString());
		System.out.println("Cout : "+exact.getSolution().getCout(vc));
		System.out.println("======================================================================");
		System.out.println("=========================> Temps Ecoulé <=============================");
		System.out.println((end-start)/1000+" us");
		//
	}
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int taille = (int)((Math.random()*500));
		System.out.println("l ordre de graphe : "+5);
		VC vc = new VC(5);
		vc.remplirMatrice();
		System.out.println(vc.toString());
		
		
		try {
			System.out.println("\n\n# Methode exact :");
			testexact(vc);
			System.out.println("\n\n# Branch and Bound limité :");
			testbranchboundlimite(vc);
			System.out.println("\n\n# Methode Descente :");
			testdescente(vc);
			System.out.println("\n\n# Methode Taboo :");
			testtaboo(vc);
			System.out.println("\n\n# Methode Recuit Simule :");
			testRS(vc);
			System.out.println("\n\n# Algorithme Génétique :");
			testgenetique(vc);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
