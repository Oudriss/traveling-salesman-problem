package metaheuristique;

import java.util.Random;

import pvc.Solution;
import pvc.VC;

public class RecuitSimule extends AbstractMethode {

	int TEMPERATURE = 1000;
	private Solution lastBestSolution;
	
	public RecuitSimule(VC vc) {
		super(vc);
	}

	/**
	 * Renvoi un voision aléatoire
	 * @throws CloneNotSupportedException 
	 */
	public Solution randomVoisin() throws CloneNotSupportedException{
		int j = (int)((Math.random()*(vc.getTaille()-1)));
		return this.solution.getVoisin(j);
	}
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private double P(int s1, int s2){
		return Math.exp(((s1-s2)/TEMPERATURE));
	}
	/**
	 * Resoudre PVC en utilisant la methode recuit simule
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public void resoudre() throws CloneNotSupportedException {
		Solution s = null;
		double r = 0;
		lastBestSolution = (Solution) solution.clone();
		do {
			s = this.randomVoisin();
			r = new Random().nextDouble();
			if( r < P(this.solution.getCout(vc),s.getCout(vc)) ){
				if( s.getCout(vc) < lastBestSolution.getCout(vc)) lastBestSolution = (Solution) s.clone();
				solution = (Solution)s.clone();
			}
			TEMPERATURE--;
		} while( TEMPERATURE > 1 );
		if( solution.getCout(vc) > lastBestSolution.getCout(vc)) solution = (Solution) lastBestSolution.clone();
	}
	
	

}
