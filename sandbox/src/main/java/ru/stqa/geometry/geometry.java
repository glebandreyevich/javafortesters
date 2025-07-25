package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(2.0));
        var side=7.0;
        System.out.println("Area of a square " + side + " = " + Square.Area(side));
        Rectangle.printRectangleArea(3.0,5.0);
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("P" + triangle.calculatePerimeter());
        System.out.println("S"+ triangle.calculateArea());


    }

}
