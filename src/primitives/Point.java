package primitives;
import java.lang.Math;


/**
 * The {@code Point} class represents a point in 3D space.
 * It is defined by three coordinates (x, y, z) encapsulated in a {@code Double3} object.
 */
public class Point {
    protected Double3 xyz;
    /**
     * A constant representing the origin point (0,0,0) in 3D space.
     */
    public static final Point ZERO = new Point(0, 0, 0);

    /**
     * Constructs a new Point with given x, y, and z coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    /**
     * Constructs a new Point from an existing {@code Double3} object.
     *
     * @param d3 the {@code Double3} object representing the coordinates
     */
    public Point(Double3 d3) {
        xyz = d3;
    }

    /**
     * Checks whether this point is equal to another object.
     * Two points are considered equal if they have the same coordinates.
     *
     * @param o the object to compare with this point
     * @return {@code true} if the given object is equal to this point, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Point) && this.xyz.equals(((Point) o).xyz);
    }

    /**
     * Returns a string representation of the Point.
     *
     * @return a string describing the point's coordinates
     */
    @Override
    public String toString() {
        return xyz.toString();
    }

    /**
     * Adds a vector to this point and returns a new point representing the result.
     *
     * @param v the vector to add
     * @return a new {@code Point} resulting from the addition
     */
    public Point add(Vector v) {
        return new Point(this.xyz.add(v.xyz));
    }

    /**
     * Subtracts another point from this point and returns the resulting vector.
     *
     * @param v the point to subtract
     * @return a new {@code Vector} representing the difference
     */
    public Vector subtract(Point v) {
        return new Vector(v.xyz.subtract(this.xyz));
    }

    /**
     * Calculates the Euclidean distance between this point and another point.
     *
     * @param p the other point
     * @return the distance between this point and the given point
     */
    public double distance(Point p) {
        return Math.sqrt(distanceSquared(p));
    }

    /**
     * Calculates the squared distance between this point and another point.
     * This method is more efficient than {@code distance} as it avoids the square root computation.
     *
     * @param p the other point
     * @return the squared distance between this point and the given point
     */
    public double distanceSquared(Point p) {
        return (this.xyz.d1() - p.xyz.d1()) * (this.xyz.d1() - p.xyz.d1()) +
               (this.xyz.d2() - p.xyz.d2()) * (this.xyz.d2() - p.xyz.d2()) +
               (this.xyz.d3() - p.xyz.d3()) * (this.xyz.d3() - p.xyz.d3());
    }
}