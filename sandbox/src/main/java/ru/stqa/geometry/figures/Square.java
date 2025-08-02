package ru.stqa.geometry.figures;

public record Square(double side) {

    public Square{
        if (side<0){
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }
    public static void printSquareArea(Square s)
  {
      String text = (String.format("Area of a square %f =%f", s.side, s.Area()));
      System.out.println(text);
  }

    public static double Area(double a) {
      return a * a;
  }



    public double Area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
