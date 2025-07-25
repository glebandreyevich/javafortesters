package ru.stqa.geometry.figures;

public class Triangle {
    double side1;
    double side2;
    double side3;
    public Triangle(double side1,double side2,double side3)
    {
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    public double calculatePerimeter(){
        return side1+side2+side3;
    }
    public double calculateArea(){
        double perimeter = calculatePerimeter() / 2;
        return Math.sqrt(perimeter*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
    }
}
