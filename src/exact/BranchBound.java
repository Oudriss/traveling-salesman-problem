package exact;

import java.util.ArrayList;
import java.util.Collections;

import metaheuristique.AbstractMethode;
import pvc.Solution;
import pvc.VC;

public class BranchBound extends AbstractMethode {

	public BranchBound(VC vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}
	 
	
	private int[] demarrer(int i){
		int[] tab = new int[vc.getTaille()];
		tab[0] = i;
		for( int j = 1 ; j < tab.length ; j++ )
			tab[j] = -1;
		for( int j = 1 ; j < tab.length ; j++){
			tab[j] = vc.plusProcheVille(tab[j-1], tab);
		}
		return tab;
	}
	
	@Override
	public void resoudre() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		for( int i = 0 ; i < vc.getTaille() ; i++ ){
			Solution s =(Solution) solution.clone();
			s.setSolution(this.demarrer(i));
			solutions.add(s);
		}
		this.solution = Collections.min(solutions);
	}

}
