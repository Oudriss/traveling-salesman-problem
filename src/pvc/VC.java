package pvc;

import java.util.Random;

public class VC {

	/**
	 * Le nombre de villes du problème
	 */
	private  int taille;
	/**
	 * La distance entre les villes, la valeur de la case distances[i][j] est la distance entre la ville i et j
	 */
	private int[][] distances;
	/**
	 * Constructeur par defaut
	 */
	public VC() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructeur en utilisant l'attribut 'taille'
	 * @param taille
	 */
	public VC(int taille) {
		super();
		this.taille = taille;
	}
	/**
	 * Constructeur en utilisant les attributs de la classe
	 * @param taille
	 * @param distances
	 */
	public VC(int taille, int[][] distances) {
		super();
		this.taille = taille;
		this.distances = distances;
	}
	/*
	 * Getters et Setters
	 */
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int[][] getDistances() {
		return distances;
	}
	public void setDistances(int[][] distances) {
		this.distances = distances;
	}
	/**
	 * Générer une instance aléatoire
	 */
	public void remplirMatrice(){
		distances = new int[taille][taille];
		for(int i=0; i<taille; i++){
			for(int j=0; j<taille; j++){
				if(i == j) distances[i][j] = 0;
				else distances[i][j] = (int)(new Random().nextDouble()*100);
			}
		}
	}
	/**
	 * Renvoi la distance entre ville i et ville j
	 */
	public int getDistance(int i , int j){
		return distances[i][j];
	}
	
	@Override
	public String toString() {
		String s = "";
		for( int i = 0 ; i < distances.length ; i++ ){
			for( int j = 0 ; j < distances[i].length ; j++ )
				s += distances[i][j]+"\t";
			s += "\n";
		}
		return s;
	}
	/**
	 * Revoi true si la valeur i est dans le tableau tab,false sinon 
	 * @param i
	 * @param tab
	 * @return
	 */
	private boolean exists(int i , int[] tab){
		for( int j = 0 ; j < tab.length ; j++ ){
			if( tab[j] == i) return true;
		}
		return false;
	}
	/**
	 * Renvoi le minimum du ligne i
	 * @param i
	 * @return
	 */
	private int getMinLigne(int i, int[] tab){
		int minDistance1 = -1, minDistance1Indice = -1;
		while(true){
			if(!exists(minDistance1Indice, tab) && minDistance1Indice != i){
				minDistance1 = distances[i][minDistance1Indice];
				break;
			}else if( minDistance1Indice == taille ) break;
			else minDistance1Indice++;	
		}
		for( int j = 0 ; j < taille ; j++ ){
			if( i != j  && !exists(i,tab) && distances[i][j] < minDistance1){
				minDistance1 = distances[i][j];
				minDistance1Indice = j;
			}
		}
		return minDistance1Indice;
	}
	/**
	 * Renvoi le minimum du colonne j
	 * @param j
	 * @return
	 */
	private int getMinColonne(int j, int[] tab){
		int minDistance1 = -1,minDistance1Indice = 0 ;
		while(true){
			if(!exists(minDistance1Indice, tab) && minDistance1Indice != j){
				minDistance1 = distances[minDistance1Indice][j];
				break;
			}else if( minDistance1Indice == taille ) break;
			else minDistance1Indice++;	
		}
		for( int i = 0 ; i < taille ; i++ ){
			if( i != j && !exists(j, tab) && distances[i][j] < minDistance1){
				minDistance1 = distances[i][j];
				minDistance1Indice = i ;
			}
		}
		return minDistance1Indice;
	}
	/**
	 * Renvoi la ville la plus proche à la ville i
	 * @param i
	 * @param tab
	 * @return
	 */
	public int plusProcheVille(int i,int[] tab){
		int minColonne = getMinColonne(i,tab), minLigne = getMinLigne(i, tab); 
		if( distances[minLigne][i] < distances[i][minColonne]) 
			return minLigne;
		else return minColonne;
	}
}
