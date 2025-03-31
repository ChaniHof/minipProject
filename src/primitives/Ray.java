package primitives;

/**
 * The {@code Ray} class represents a ray in 3D space, defined by a starting point and a direction vector.
 * The direction vector is always normalized.
 */
public final class Ray {
    private final Point head;
    private final Vector direction;

    /**
     * Constructs a new Ray with a given starting point and direction vector.
     * The direction vector is normalized upon creation.
     *
     * @param p the starting point of the ray
     * @param v the direction vector of the ray (will be normalized)
     */
    public Ray(Point p, Vector v) {
        head = p;
        direction = v.normalize();
    }

    /**
     * Checks whether this ray is equal to another object. 
     * Two rays are considered equal if they have the same head and direction.
     *
     * @param o the object to compare with this ray
     * @return {@code true} if the given object is equal to this ray, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Ray) && this.head.xyz.equals(((Ray) o).head.xyz) && this.direction.equals(((Ray) o).direction);
    }

    @Override
    public String toString() {
        return "head: " + head.toString() + " direction: " + direction.toString();
    }
}