package exact;

import java.util.ArrayList;
import java.util.Collections;

import metaheuristique.AbstractMethode;
import pvc.Solution;
import pvc.VC;

public class MethodeExact extends AbstractMethode{
	/**
	 * La liste qui va contenir toutes les solutions possible
	 */
	private ArrayList<Solution> solutions;
	/**
	 * Constructeur
	 */
	public MethodeExact(VC vc) {
		super(vc);
		solutions = new ArrayList<Solution>();
		// TODO Auto-generated constructor stub
	}
	/**
	 * get toutes les permutations possibles
	 * @param arr
	 * @param k
	 * @throws CloneNotSupportedException
	 */
	public void permute(java.util.List<Integer> arr, int k) throws CloneNotSupportedException {
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	Solution s = (Solution) solution.clone();
        	s.setSolution(arr.toArray());
        	solutions.add(s);
        }
    }

	/**
	 * Envoyer la solution optimale
	 */
	@Override
	public void resoudre() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ArrayList<Integer> sol1 = new ArrayList<Integer>();
		int[] sol2 = this.solution.getSolution();
		for( int i = 0 ; i < sol2.length ; i++)
			sol1.add(Integer.valueOf(sol2[i]));
		this.permute(sol1, 0);
		solution = Collections.min(solutions);
	}
   

}
