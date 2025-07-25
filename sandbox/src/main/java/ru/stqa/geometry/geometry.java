package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class geometry {
    public static void main(String[] args) {
        Square.printSquareArea(2.0);
        var side=7.0;
        System.out.println("Area of a square " + side + " = " + Square.Area(side));
        Rectangle.printRectangleArea(3.0,5.0);
    }

}
