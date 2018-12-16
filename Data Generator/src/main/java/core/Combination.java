package core;

import java.util.ArrayList;

public class Combination {
	
	private static ArrayList<String> storage = new ArrayList<String>();
	
	
	private static void combinationUtil(String [] arr, String [] data, int start, int end, int index, int r){ 
		
		String tempString = "";
		
		if (index == r) { 
			for (int j=0; j<r; j++) {
				//System.out.print(data[j] +" "); 
				tempString += data[j] + " ";
			}
			
			storage.add(tempString);
			tempString = "";
			
			//System.out.println(""); 
			return; 
			} 
		
		for (int i=start; i<=end && end-i+1 >= r-index; i++) { 
				data[index] = arr[i];
				combinationUtil(arr, data, i+1, end, index+1, r); 
			} 
	} 
	
	private static void Combination(String [] arr, int n, int r) { 
		String [] data = new String [r];
		
		combinationUtil(arr, data, 0, n-1, 0, r); 
	} 
	

	//returns the a list of all the subsets size r
	public static ArrayList<String> getCombination(ArrayList<String> list, int r) {
		
		storage.removeAll(storage);

		String [] tempArr = new String[list.size()];
		
		for(int i = 0; i < tempArr.length; i++) {
			tempArr[i] = list.get(i);
		}
		
		Combination(tempArr, list.size(), r);
		
		
		ArrayList<String> rList = new ArrayList<String>();
		rList.addAll(storage);
		
		storage.removeAll(storage);
		
		
		return rList;
	}

}
