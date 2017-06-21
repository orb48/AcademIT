package Main;

public class Main {
    public static void main(String[] args) {
        Vector coordinates = new Vector(new double[] {1.0, 2.0, 6.0, 5.0}) ;
        System.out.println(coordinates.getSize());
        System.out.println(coordinates.toString());

        Vector coordinatesCopy = new Vector(coordinates);
        System.out.println(coordinatesCopy.getSize());
        System.out.println(coordinatesCopy.toString());

        Vector coordinates2 = new Vector(6, new double[] {6, 2, 13, 5, 1});
        System.out.println(coordinates2.getSize());
        System.out.println(coordinates2.toString());

    }
}
