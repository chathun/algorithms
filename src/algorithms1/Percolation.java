package algorithms1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//import java.lang.Exception;

public class Percolation {
	boolean[][] grid;
	int[] quickFind;
	int[] weightedArray;


	public Percolation(int n) {
		// create n-by-n grid, with all sites blocked
		if (n < 0) {
			throw new IllegalArgumentException();
		} 
		//blocked=1
		grid = new boolean[n][n];
		for(int row=0;row<n;row++){
			for(int column=0;column<n;column++){
				grid[row][column]=false;
			}
		}
		quickFind=new int[n*n+2];
		weightedArray=new int[n*n+2];
		for(int index=0;index<quickFind.length;index++){
			quickFind[index]=index;
		}
		for(int head=1;head<n;head++){
			quickFind[head]=0;
			weightedArray[head]++;
		}
		for(int tail=quickFind.length-1;tail>=quickFind.length-n;tail--){
			quickFind[tail]=quickFind.length-1;
			weightedArray[tail]++;
		}
	}

	public void open(int i, int j) {
		int row=i-1;
		int column=j-1;
		// open site (row i, column j) if it is not open already
		if (row < 1 || row > grid[0].length || column < 1 || column > grid[0].length) {
			throw new IllegalArgumentException();
		}
		
	}

	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
		if (i < 1 || i > grid[0].length || j < 1 || j > grid[0].length) {
			throw new IllegalArgumentException();
		}
		int row=i-1;
		int column=j-1;
		return grid[row][column]==true;
	}

	public boolean isFull(int i, int j) {
		// is site (row i, column j) full?
		if (i < 1 || i > grid[0].length || j < 1 || j > grid[0].length) {
			throw new IllegalArgumentException();
		}
		//call is connected
		return false;
	}

	public boolean percolates() {
		// does the system percolate?
		return false;
	}
	
	private int getRoot(int position){
		while(position!=quickFind[position]){
			quickFind[position]=quickFind[quickFind[position]];
			position=quickFind[position];
		}
		return position;
	}
	
	private boolean isConected(int position1, int position2){
		return getRoot(position1)==getRoot(position2);
	}
	
	private void union(int position1, int position2){
		
		
	}

}
