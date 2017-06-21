package Main;

public class Vector {
    private double[] coordinates;
    private int size;

    public Vector(int size) {
        this.coordinates = new double[size];
        if (size <= 0) throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        for (int i = 0; i < size; ++i) {
            coordinates[i] = 0;
        }
    }

    public Vector(Vector copy) {
        this.coordinates = new double[copy.getSize()];
        for (int i = 0; i < copy.getSize(); ++i) {
            this.coordinates[i] = copy.coordinates[i];
        }
    }

    public Vector(double[] coordinates) {
        this.coordinates = new double[coordinates.length];
        for (int i = 0; i < coordinates.length; ++i) {
            this.coordinates[i] = coordinates[i];
        }
    }

    public Vector(int size, double[] coordinates) {
        this.coordinates = new double[size];
        if (size <= 0) throw new IllegalArgumentException("Размерность вектора = 0 или отрицательна");
        for (int i = 0; i < coordinates.length; ++i) {
            this.coordinates[i] = coordinates[i];
        }
        if (coordinates.length < size) {
            for (int i = coordinates.length; i < size; i++) {
                this.coordinates[i] = 0;
            }
        }
    }

    public int getSize() {
        return coordinates.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < getSize() - 1; ++i) {
            sb.append(coordinates[i]);
            sb.append(", ");
        }
        sb.append(coordinates[getSize() - 1]);
        sb.append("}");
        return sb.toString();
    }

    public Vector additionToVector (Vector second) {

        return this;
    }

}
