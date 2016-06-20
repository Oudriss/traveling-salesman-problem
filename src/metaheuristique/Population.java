package metaheuristique;

import java.util.ArrayList;
import java.util.Collections;

import pvc.Solution;
import pvc.VC;

public class Population extends AbstractMethode{

	/**
	 * Nombre d'individus 
	 */
	protected int nombreIndividus;
	/**
	 * Population
	 */
	protected ArrayList<Solution> population;
	/**
	 * Constructeur
	 * @param vc
	 * @param nombreIndividus
	 */
	public Population(VC vc, int nombreIndividus) {
		super(vc);
		this.nombreIndividus = nombreIndividus;
	}
	/**
	 * Initialiser poputlation
	 * @throws CloneNotSupportedException 
	 */
	public void initialiserPopulation() throws CloneNotSupportedException{
		Solution s = new Solution(vc.getTaille(),this);
		s.randomSolution();
		population = s.getVoisins();
	}
	/**
	 * Operateur mutation
	 * @throws CloneNotSupportedException 
	 */
	public void mutation() throws CloneNotSupportedException{
		int j = 0;
		for( int i = 0 ; i < nombreIndividus ; i++){
			j = (int)((Math.random()*(vc.getTaille()-1)));
			population.add(population.get(i).getVoisin(j));
		}
	}
	/**
	 * cross-over
	 * @throws CloneNotSupportedException 
	 */
	public Solution cross_over(Solution s1,Solution s2) throws CloneNotSupportedException{
		Solution s3 = (Solution) s1.clone();
		int k = (int)((Math.random()*(vc.getTaille()-1))),l = k;
		while( k == l)	
			l = (int)((Math.random()*(vc.getTaille()-1)));
		
		
		return null;
	}
	/**
	 * Cross-overs
	 */
	public void cross_overs(){
		int size = population.size();
		for( int i = 0 ; i < size ; i++){
		
		}
	}
	/**
	 * Selectionner les meilleurs
	 */
	public void selectionner(){
		while( population.size() > nombreIndividus - 1) {
			population.remove(population.indexOf(Collections.max(population)));
		}
	}
	/**
	 * Resoudre en utilisant l'algorithme genetique
	 */
	@Override
	public void resoudre() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		int compteur = 0;
		this.initialiserPopulation();
		Solution min = Collections.min(population);
		solution = (Solution) min.clone();
		do{
			this.mutation();
			this.selectionner();
			if( solution.getCout(this.vc) <= min.getCout(vc) ){
				compteur++;
			}
			else{
				solution = (Solution) min.clone();
				compteur = 0;
			}
		}while( compteur < 10);
	}
	/*
	 * Getters et Setters 
	 */
	public int getNombreIndividus() {
		return nombreIndividus;
	}
	public void setNombreIndividus(int nombreIndividus) {
		this.nombreIndividus = nombreIndividus;
	}
	public ArrayList<Solution> getPopulation() {
		return population;
	}
	public void setPopulation(ArrayList<Solution> population) {
		this.population = population;
	}
	
	
	
}
