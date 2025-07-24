public class geometry {
    public static void main(String[] args) {
        printSquareArea(2.0);
        var side=7.0;
        System.out.println("Area of a square " + side + " = " + squareArea(side));
        printRectangleArea(3.0,5.0);
    }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Area of a rectangle " + a + " and " + b +" = " + rectangleArea(a,b));
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }

    static void printSquareArea(double side)
  {
      System.out.println("Area of a square " + side + " = " + squareArea(side));
  }

    private static double squareArea(double a) {
        return a * a;
    }
}
