package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TriangleTest {
    Triangle triangle = new Triangle(3.0, 4.0, 5.0);
    Triangle triangle1 = new Triangle(3.0,4.0,5.0);
    Triangle triangle2 = new Triangle (4.0,5.0,3.0);
    @Test
    void calculateArea(){
        Assertions.assertEquals(6.0,triangle.calculateArea());
    }
    @Test
    void calculatePerimetr(){
        Assertions.assertEquals(12.0,triangle.calculatePerimeter());
    }
    @Test
    void testTriangle(){
        Assertions.assertEquals(triangle1,triangle2);
    }
    @Test
    void TriangleZeroSide(){
        {
            try {
                new Triangle(1.0,-2.0,5.0);
                Assertions.fail();
            }
            catch (IllegalArgumentException exception) {
                Assertions.assertEquals("All sides of triangle should be non-negative",exception.getMessage());
            }
        }

    }
    @Test
    void InvalidTriangleInequality()
    {
        try {
            new Triangle(1.0,2.0,5.0);
            Assertions.fail();
        }
        catch (IllegalArgumentException exception) {
            Assertions.assertEquals("Triangle inequality is violated",exception.getMessage());

        }
    }
}
