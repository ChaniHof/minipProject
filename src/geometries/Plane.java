package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * 
 */
public final class Plane extends Geometry {
	
//Variables	
	private Point q;
	private Vector normal;
	
//Functions	
	
	/**
	 * builder with parameters that are Point, and finds the normal
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Plane(Point p1, Point p2, Point p3) {
	    this.q = p1;
	    Vector v1 = p2.subtract(p1);
	    Vector v2 = p3.subtract(p1);
	    this.normal = v1.crossProduct(v2).normalize();
	}

		
	
	/**
	 * builder with parameters of Point and normal6 
	 * 
	 * @param q
	 * @param normal
	 */
	public Plane(Point q, Vector normal) {
		super();
		this.q = q;
		this.normal = normal;
	}
	//public abstract Vector getNormal(); 
	public abstract Vector getNormal(Point p);
}
