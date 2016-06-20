package metaheuristique;

import pvc.Solution;
import pvc.VC;

public abstract class AbstractMethode {
		/**
		 * Problème Voyageur de Commerce : les distances entre les villes
		 */
		protected VC vc;
		/**
		 * La solution courrante du problème
		 */
		protected Solution solution;
		/**
		 * Constructeur en utilisant les attributs de la classe
		 * @param vc
		 */
		public AbstractMethode(VC vc) {
			super();
			this.vc = vc;
			this.solution = new Solution(vc.getTaille(),this);
			solution.randomSolution();
		}
		/**
		 * Methode qui va resoudre le problème à redefinir dans chaque methode
		 * @throws CloneNotSupportedException 
		 */
		public abstract void resoudre() throws CloneNotSupportedException;
		public VC getVc() {
			return vc;
		}
		public void setVc(VC vc){
			this.vc = vc;
		}
		public Solution getSolution() {
			return solution;
		}
		public void setSolution(Solution solution) {
			this.solution = solution;
		}
		
		
		
}
