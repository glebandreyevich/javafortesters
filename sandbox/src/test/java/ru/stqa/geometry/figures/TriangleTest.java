package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TriangleTest {
    Triangle triangle = new Triangle(3.0, 4.0, 5.0);
    @Test
    void calculateArea(){
        Assertions.assertEquals(6.0,triangle.calculateArea());
    }
    @Test
    void calculatePerimetr(){
        Assertions.assertEquals(12.0,triangle.calculatePerimeter());
    }
}
