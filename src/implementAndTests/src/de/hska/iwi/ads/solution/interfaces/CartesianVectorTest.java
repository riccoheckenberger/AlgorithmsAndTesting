package de.hska.iwi.ads.solution.interfaces;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.interfaces.Vector;
import de.hska.iwi.ads.interfaces.VectorTest;

class CartesianVectorTest extends VectorTest {

	@Override
	public Vector createVector(double x, double y) {
		CartesianVector vector = new CartesianVector (x,y);
		return vector;
	}

}
