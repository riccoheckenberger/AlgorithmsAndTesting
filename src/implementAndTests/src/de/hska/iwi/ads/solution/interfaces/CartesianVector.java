package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;

public class CartesianVector implements Vector {

	private double x, y;

	public CartesianVector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void scale(double factor) {
		this.x *= factor;
		this.y *= factor;

	}

	@Override
	public double getDimension() {
		double variable = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
		return variable;
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public double getDirection() {
		return Math.atan2(getY(), getX());
	}

	@Override
	public Vector add(Vector addend) {
		this.x += addend.getX();
		this.y += addend.getY();

		return this;
	}

}
