package com.vladprn.java.complexmatrixdeterminator;

public class Matrix {
	private Complex[][] mat;
	private int size;
	
	public Matrix(Complex[][] mat) {
		this.size = mat.length;
		this.mat = mat;
	}
	
	public Matrix(String str) throws Exception {
		Parser ps = new Parser(str);
		this.mat = ps.getArray();
		if (this.mat == null) {
			throw new Exception();
		}
		this.size = mat.length;
	}
	
	public Complex determinate() {
		Complex res = new Complex();
		
		if (size == 1) {
			return mat[0][0];
		}
		
		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				res = res.plus(this.drop(i, 0).determinate().times(mat[i][0]));
			} else {
				res = res.minus(this.drop(i, 0).determinate().times(mat[i][0]));
			}
		}
		
		return res;
	}
	
	public Matrix drop(int y, int x) {
		Complex[][] mat = new Complex[size - 1][size - 1];
		int it = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j  < size; j++) {
				if (i != y && j != x) {
					mat[it / (size - 1)][it % (size - 1)] = this.mat[i][j];
					it++;
				}
			}
		}
		return new Matrix(mat);
	}
}
