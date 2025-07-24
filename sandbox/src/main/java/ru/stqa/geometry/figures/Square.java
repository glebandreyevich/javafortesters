package ru.stqa.geometry.figures;

public class Square {
   public static void printSquareArea(double side)
  {
      String text = (String.format("Area of a square %f =%f", side,squareArea(side)));
      System.out.println(text);
  }

    public static double squareArea(double a) {
      return a * a;
  }
}
