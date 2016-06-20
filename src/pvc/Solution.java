package pvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import metaheuristique.AbstractMethode;

public class Solution implements Cloneable,Comparable<Object> {

		/**
		 * La taille d'une solution (Generalement le nombre des villes)
		 */
		private int taille;
		/**
		 * La solution du problème voyageur de commerce
		 * Elle est representé sur un tableau du taille 'taille' 
		 */
		private int[] solution;
		/**
		 * Methode de resolution
		 */
		private AbstractMethode methode;
		/**
		 * Constructeur par defaut
		 */
		public Solution() {
			super();
		}
		/**
		 * Constructeur en utilisant les attributs de la classe
		 * @param taille
		 * @param solution
		 */
		public Solution(int taille, AbstractMethode methode) {
			super();
			this.taille = taille;
			this.methode = methode;
			this.solution = new int[taille];
		}
		public Solution(int[] solution,AbstractMethode methode) {
			// TODO Auto-generated constructor stub
			this.solution = solution;
			this.taille = solution.length;
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
		public int[] getSolution() {
			return solution;
		}
		public void setSolution(int[] solution) {
			this.solution = solution;
		}
		
		/**
		 * Initialiser la solution
		 */
		public void initialiserSolution(){
			for( int i = 0 ; i < taille ; i++ )
				solution[i] = i;
		}
		/**
		 * Générer une solution aléatoire
		 */
		public void randomSolution(){
			this.initialiserSolution();
			for( int i=0 ; i < taille ; i++ ){
				int temp = solution[i];
				int j = (int)((Math.random()*taille));
				solution[i] = solution[j];
				solution[j] = temp;
			}
		}
		/**
		 * Renvoi le voision (permutation de la case 'i' et la case 'i+1')
		 * @param indice
		 * @return
		 * @throws CloneNotSupportedException 
		 */
		public Solution getVoisin(int i) throws CloneNotSupportedException{
			Solution voisin = (Solution) this.clone();
			int temp = voisin.solution[i];
			voisin.solution[i] = voisin.solution[i+1];
			voisin.solution[i+1] = temp;
			return voisin;
		}
		/**
		 * renvoi tout les voisins
		 * @throws CloneNotSupportedException 
		 */
		public ArrayList<Solution> getVoisins() throws CloneNotSupportedException{
			ArrayList<Solution> voisins = new ArrayList<Solution>();
			for( int i = 0 ; i < taille-1 ; i++) {
				voisins.add(this.getVoisin(i));
			}
			return voisins;
		}
		/**
		 * Renvoi le cout de la solution (distance total)
		 */
		public int getCout(VC vc){
			int cout = 0;
			for (int i = 0; i < vc.getTaille() - 1; i++){
				cout += vc.getDistance(solution[i], solution[i + 1]);
			}
			cout += vc.getDistance(solution[0], solution[vc.getTaille() - 1]);
			return cout;
		}
		/**
		 * Renvoi l'indice de la valeur i
		 */
		public int getIndice(int i){
			for( int j = 0 ; j < taille ; j++)
				if( i == solution[j]) return j;
			return -1;
		}
		/**
		 * Methode toString
		 */
		@Override
		public String toString() {
			return "Solution [solution=" + Arrays.toString(solution) + "]";
		}
		/**
		 * Methode clone
		 */
		@Override
		public Object clone() throws CloneNotSupportedException {
		    Solution cloned = (Solution)super.clone();
		    cloned.setSolution(cloned.getSolution().clone());
		    return cloned;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Solution s = (Solution) o;
			return this.getCout(methode.getVc())-s.getCout(methode.getVc());
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Solution other = (Solution) obj;
			if (!Arrays.equals(solution, other.solution))
				return false;
			if (taille != other.taille)
				return false;
			return true;
		}
		public void setSolution(Object[] array) {
			// TODO Auto-generated method stub
			for(int i = 0 ; i < solution.length ; i ++){
				solution[i] = (int) array[i];
			}
		}
		
		
}
