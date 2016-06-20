package metaheuristique;

import java.util.ArrayList;
import java.util.Collections;

import pvc.Solution;
import pvc.VC;

public class MethodeTaboo extends AbstractMethode {

	ArrayList<Solution> listeTaboo;
	
	public MethodeTaboo(VC vc) {
		super(vc);
		this.listeTaboo = new ArrayList<>();
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
	 * Renvoi un voision qui minimise f
	 * @throws CloneNotSupportedException 
	 */
	public Solution getMinVoisin() throws CloneNotSupportedException{
		return Collections.min(solution.getVoisins());
	}
	@Override
	public void resoudre() throws CloneNotSupportedException {
		int cmpt = this.getVc().getTaille()*10;
		Solution s1 = solution, newS;
		this.listeTaboo.add(s1);
		do {
			newS = this.getMinVoisin();
			if(newS.compareTo(s1) < 0) {
				s1 = newS;
				solution = newS;
				this.listeTaboo.add(newS);
				cmpt = this.getVc().getTaille()*10;
			}
			else cmpt--;
		} while(cmpt>0);
	}
	
	

}
