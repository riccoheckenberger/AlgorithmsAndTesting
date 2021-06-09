package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.AbstractCircle;
import de.hska.iwi.ads.interfaces.Vector;

public class Circle extends AbstractCircle{

    public Circle(Vector middlePoint, double radius) {
        super(middlePoint, radius);
    }

    public Circle (double radius) {
        super (null,radius);
    }

    @Override
    public void scale(double factor) {
        if (factor >=0) {
            this.radius = radius*factor;
        }

    }

    @Override
    public double getDimension() {
        return this.radius;
    }

    @Override
    public double area() {
        return Math.PI * this.getRadius()* this.getRadius();
    }



}
