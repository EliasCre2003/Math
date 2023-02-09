package eliascregard.vectors;

class Vector {

    private double[] parameters;
    private final int order;
    private double length;

    public Vector(double... parameters) {
        if (parameters.length < 2) {
            throw new IllegalArgumentException("The number of parameters must be greater than or equal to 2.");
        }
        this.parameters = parameters;
        this.order = parameters.length;
        this.length = calculateLength();
    }

    private Vector(Vector vector) {
        this.parameters = vector.parameters;
        this.order = vector.order;
        this.length = vector.length;
    }

    public Vector(Vector point1, Vector point2) {
        this(Vector.difference(point2, point1));
    }

    public void setParameters(double... parameters) {
        if (parameters.length != order) {
            throw new IllegalArgumentException("The number of parameters must be equal to the order of the vector.");
        }
        this.parameters = parameters;
        this.length = calculateLength();
    }

    public double[] getParameters() {
        return parameters;
    }

    public void setParameter(int index, double value) {
        if (index < 1 || index > order) {
            throw new IllegalArgumentException(
                    "The index must be greater than or equal to 1 and less than or equal the order of the vector."
            );
        }
        parameters[index - 1] = value;
        length = calculateLength();
    }

    public double getParameter(int index) {
        if (index < 1 || index > order) {
            throw new IllegalArgumentException(
                    "The index must be greater than or equal to 1 and less than or equal the order of the vector."
            );
        }
        return parameters[index - 1];
    }

    public double getOrder() {
        return order;
    }

    private double calculateLength() {
        return Math.sqrt(dotProduct(this, this));
    }

    public double getLength() {
        return length;
    }

    public double getAngle(Vector vector) {
        if (this.order != vector.order) {
            throw new IllegalArgumentException("The order of the vectors must be equal.");
        }
        return Math.acos(dotProduct(this, vector) / (this.length * vector.length));
    }

    public void scale(double scalar) {
        for (int i = 0; i < order; i++) {
            parameters[i] *= scalar;
        }
        length *= scalar;
    }

    public static Vector sum(Vector vector1, Vector vector2) {
        if (vector1.order != vector2.order) {
            throw new IllegalArgumentException("The order of the vectors must be equal.");
        }
        double[] parameters = new double[vector1.order];
        for (int i = 0; i < vector1.order; i++) {
            parameters[i] = vector1.parameters[i] + vector2.parameters[i];
        }
        return new Vector(parameters);
    }

    public static Vector difference(Vector vector1, Vector vector2) {
        if (vector1.order != vector2.order) {
            throw new IllegalArgumentException("The order of the vectors must be equal.");
        }
        double[] parameters = new double[vector1.order];
        for (int i = 0; i < vector1.order; i++) {
            parameters[i] = vector1.parameters[i] - vector2.parameters[i];
        }
        return new Vector(parameters);
    }

    public static Vector normalizedVector(Vector vector) {
        return scalarProduct(vector, 1 / vector.length);
    }

    public static Vector scalarProduct(Vector vector, double scalar) {
        double[] parameters = new double[vector.order];
        for (int i = 0; i < vector.order; i++) {
            parameters[i] = vector.parameters[i] * scalar;
        }
        return new Vector(parameters);
    }

    public static double dotProduct(Vector vector1, Vector vector2) {
        if (vector1.order != vector2.order) {
            throw new IllegalArgumentException("The order of the vectors must be equal.");
        }
        double dotProduct = vector1.parameters[0] * vector2.parameters[0];
        for (int i = 1; i < vector1.order; i++) {
            dotProduct += vector1.parameters[i] * vector2.parameters[i];
        }
        return dotProduct;
    }

    public static Vector orthogonalProjection(Vector vector1, Vector vector2) {
        return scalarProduct(vector2, dotProduct(vector1, vector2) / dotProduct(vector2, vector2));
    }

    public boolean equals(Object object) {
        if (!(object instanceof Vector vector)) return false;
        if (this.order != vector.order) return false;
        for (int i = 0; i < order; i++) {
            if (this.parameters[i] != vector.parameters[i]) return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("(");
        for (int i = 0; i < order - 1; i++) {
            string.append(parameters[i]).append(", ");
        }
        string.append(parameters[order - 1]).append(")");
        return string.toString();
    }


}
