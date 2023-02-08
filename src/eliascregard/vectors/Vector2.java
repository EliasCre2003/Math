package eliascregard.vectors;

public class Vector2 extends Vector {

    public Vector2(double x, double y) {
        super(x, y);
    }

    public Vector2(Vector point1, Vector point2) {
        super(point2, point1);
    }

    public double getX() {
        return getParameter(1);
    }

    public double getY() {
        return getParameter(2);
    }

    public void setX(double x) {
        setParameter(1, x);
    }

    public void setY(double y) {
        setParameter(2, y);
    }

    public void set(double x, double y) {
        setX(x); setY(y);
    }

    public void set(Vector2 vector) {
        set(vector.getX(), vector.getY());
    }

    public static Vector2 sum(Vector vector1, Vector vector2) {
        return (Vector2) Vector.sum(vector1, vector2);
    }

    public static Vector2 difference(Vector vector1, Vector vector2) {
        return (Vector2) Vector.difference(vector1, vector2);
    }

    public static Vector2 normalizedVector(Vector vector) {
        return (Vector2) Vector.normalizedVector(vector);
    }

    public static Vector2 scalarProduct(Vector vector1, double scalar) {
        return (Vector2) Vector.scalarProduct(vector1, scalar);
    }

    public static Vector2 orthogonalProjection(Vector vector1, Vector vector2) {
        return (Vector2) Vector.orthogonalProjection(vector1, vector2);
    }

}
