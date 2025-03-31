package primitives;

/**
 * The {@code Vector} class represents a vector in 3D space.
 * It extends the {@code Point} class but ensures that a vector cannot be the zero vector.
 */
public class Vector extends Point {

    /**
     * Constructs a new vector with the given coordinates.
     * 
     * @param d1 the x-coordinate
     * @param d2 the y-coordinate
     * @param d3 the z-coordinate
     * @throws IllegalArgumentException if the vector is the zero vector
     */
    public Vector(double d1, double d2, double d3) {
        super(d1, d2, d3);
        if (this.equals(ZERO)) { // Ensuring the vector is not a zero vector
            throw new IllegalArgumentException("Invalid coordinates for a vector: cannot be the zero vector");
        }
    }

    /**
     * Constructs a new vector from an existing {@code Double3} object.
     * 
     * @param d the {@code Double3} object representing the vector
     * @throws IllegalArgumentException if the vector is the zero vector
     */
    public Vector(Double3 d) {    
        super(d);
        if (this.equals(ZERO)) {
        	throw new IllegalArgumentException("Invalid coordinates for a vector: cannot be the zero vector");
        }
    }

    /**
     * Checks whether this vector is equal to another object.
     * Two vectors are considered equal if they have the same coordinates.
     * 
     * @param o the object to compare with this vector
     * @return {@code true} if the given object is equal to this vector, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Vector) && super.equals(o);
    }

    /**
     * Returns a string representation of the vector.
     * 
     * @return a string describing the vector's coordinates
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Calculates the squared length (magnitude) of this vector.
     * This is a more efficient calculation than {@code length} since it avoids computing the square root.
     * 
     * @return the squared length of the vector
     */
    public double lengthSquared() {
        return (this.xyz.d1() * this.xyz.d1()) + (this.xyz.d2() * this.xyz.d2()) + (this.xyz.d3() * this.xyz.d3());
    }

    /**
     * Calculates the length (magnitude) of this vector.
     * 
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Adds another vector to this vector and returns a new vector representing the result.
     * 
     * @param v the vector to add
     * @return a new {@code Vector} resulting from the addition
     */
    public Vector add(Vector v) {
        return new Vector(super.xyz.add(v.xyz));
    }

    /**
     * Scales this vector by a scalar value and returns the resulting vector.
     * 
     * @param num the scalar value to multiply by
     * @return a new {@code Vector} scaled by the given value
     */
    public Vector scale(double num) {
        return new Vector(super.xyz.scale(num));
    }

    /**
     * Computes the dot product of this vector and another vector.
     * 
     * @param v the vector to compute the dot product with
     * @return the dot product as a {@code Vector} (incorrect return type; should be a double)
     */
    public double dotProduct(Vector v) { 
        return this.xyz.d1() * v.xyz.d1() +
               this.xyz.d2() * v.xyz.d2() + 
               this.xyz.d3() * v.xyz.d3();
    }

    /**
     * Computes the cross product of this vector and another vector. 
     * The cross product is a vector perpendicular to both input vectors.
     * 
     * @param v the vector to compute the cross product with
     * @return a new {@code Vector} representing the cross product
     */
    public Vector crossProduct(Vector v) {
        return new Vector(
            this.xyz.d2() * v.xyz.d3() - this.xyz.d3() * v.xyz.d2(),
            this.xyz.d3() * v.xyz.d1() - this.xyz.d1() * v.xyz.d3(),
            this.xyz.d1() * v.xyz.d2() - this.xyz.d2() * v.xyz.d1());
    }

    /**
     * Normalizes this vector, returning a unit vector in the same direction.
     * 
     * @return a new {@code Vector} representing the normalized vector
     */
    public Vector normalize() {
        double len = this.length();
        return new Vector(this.xyz.d1() / len, this.xyz.d2() / len, this.xyz.d3() / len);
    }
}