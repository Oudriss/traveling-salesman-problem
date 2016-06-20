package metaheuristique;

import java.util.Collections;

import pvc.Solution;
import pvc.VC;

public class MethodeDescente extends AbstractMethode {

	public MethodeDescente(VC vc) {
		super(vc);
	}

	/**
	 * Renvoi un voision qui minimise
	 * @throws CloneNotSupportedException 
	 */
	public Solution getMinVoisin() throws CloneNotSupportedException{
		return Collections.min(solution.getVoisins());
	}
	/**
	 * Resoudre PVC en utilisant la methode descente
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public void resoudre() throws CloneNotSupportedException {
		
		do {
			Solution newS = this.getMinVoisin();
			if(newS.compareTo(solution) < 0) {
				solution = newS;
			} else break;
		} while(true);
	}
	
	

}
