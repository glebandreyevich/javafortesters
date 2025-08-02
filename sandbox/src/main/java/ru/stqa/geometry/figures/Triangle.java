package ru.stqa.geometry.figures;

import java.util.Arrays;
import java.util.Objects;

public class Triangle {
    double side1;
    double side2;
    double side3;
    double [] sides;
    public Triangle(double side1,double side2,double side3)
    {
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
        this.sides= new double[]{side1,side2,side3};
        Arrays.sort(this.sides);

        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("All sides of triangle should be non-negative");
        }

        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side3 + side2 <= side1) {
            throw new IllegalArgumentException("Triangle inequality is violated");
        }
    }
    public double calculatePerimeter(){
        return side1+side2+side3;
    }
    public double calculateArea(){
        double perimeter = calculatePerimeter() / 2;
        return Math.sqrt(perimeter*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(sides,triangle.sides);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
