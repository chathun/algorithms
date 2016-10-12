package algorithms1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//import java.lang.Exception;

public class Percolation {
	int[][] grid;

	public Percolation(int n) {
		// create n-by-n grid, with all sites blocked
		if (n < 0) {
			throw new IllegalArgumentException();
		} 
		//full=0
		grid = new int[n][n];
		for(int row=0;row<n;row++){
			for(int column=0;column<n;column++){
				grid[row][column]=0;
			}
		}
		
	}

	public void open(int i, int j) {
		int row=i-1;
		int column=j-1;
		// open site (row i, column j) if it is not open already
		if (row < 1 || row > grid[0].length || column < 1 || column > grid[0].length) {
			throw new IllegalArgumentException();
		}
		int value=(i)*grid.length+(j);
		grid[row][column]=value;
	}

	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
		if (i < 1 || i > grid[0].length || j < 1 || j > grid[0].length) {
			throw new IllegalArgumentException();
		}
		int row=i-1;
		int column=j-1;
		return grid[row][column]!=0;
	}

	public boolean isFull(int i, int j) {
		// is site (row i, column j) full?
		if (i < 1 || i > grid[0].length || j < 1 || j > grid[0].length) {
			throw new IllegalArgumentException();
		}
		int row=i-1;
		int column=j-1;
		return grid[row][column]==0;
	}

	public boolean percolates() {
		// does the system percolate?
		return false;
	}

}
