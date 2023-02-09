package eliascregard.vectors;

public class Vector3 extends Vector{

    public Vector3(double x, double y, double z) {
        super(x, y, z);
    }

    public Vector3(Vector point1, Vector point2) {
        super(point2, point1);
    }
    public Vector3() {
        this(0, 0, 0);
    }

    public double getX() {
        return getParameter(1);
    }

    public double getY() {
        return getParameter(2);
    }

    public double getZ() {
        return getParameter(3);
    }

    public void setX(double x) {
        setParameter(1, x);
    }

    public void setY(double y) {
        setParameter(2, y);
    }

    public void setZ(double z) {
        setParameter(3, z);
    }

    public void set(double x, double y, double z) {
        setX(x); setY(y); setZ(z);
    }

    public void set(Vector3 vector) {
        set(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Vector3 sum(Vector vector1, Vector vector2) {
        return (Vector3) Vector.sum(vector1, vector2);
    }

    public static Vector3 difference(Vector vector1, Vector vector2) {
        return (Vector3) Vector.difference(vector1, vector2);
    }

    public static Vector3 normalizedVector(Vector vector) {
        return (Vector3) Vector.normalizedVector(vector);
    }

    public static Vector3 scalarProduct(Vector vector1, double scalar) {
        return (Vector3) Vector.scalarProduct(vector1, scalar);
    }

    public static Vector3 crossProduct(Vector3 vector1, Vector3 vector2) {
        double x = vector1.getY() * vector2.getZ() - vector1.getZ() * vector2.getY();
        double y = vector1.getZ() * vector2.getX() - vector1.getX() * vector2.getZ();
        double z = vector1.getX() * vector2.getY() - vector1.getY() * vector2.getX();
        return new Vector3(x, y, z);
    }

    public static Vector3 orthogonalProjection(Vector vector1, Vector vector2) {
        return (Vector3) Vector.orthogonalProjection(vector1, vector2);
    }


}
