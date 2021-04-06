package unittests;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
class Point3DTest {

    @Test
    void equals() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1 = new Point3D(1, 2, 3);
        assertTrue(p1.equals(new Point3D(1, 2, 3)), "equals() does not work correctly");
    }


    @Test
    void substract() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1 = new Point3D(1, 2, 3);
        assertEquals(new Vector(1, 1, 1),p1.substract(new Point3D(0, 1, 2)),"substract() does not work correctly");
    }

    @Test
    void add() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1 = new Point3D(1, 2, 3);
        assertEquals(Point3D.ZERO, p1.add(new Vector(-1, -2, -3)), " add() does not work correctly");

    }

    @Test
    void distance() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1 = new Point3D(1, 2, 3);
        assertEquals(9, p1.distance(new Point3D(3, 0, 2)), " distance() does not work correctly");


    }

    @Test
    void distancesquared() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1 = new Point3D(1, 2, 3);
        assertEquals(3, p1.distancesquared(new Point3D(3, 0, 2)), " distancesquared() does not work correctly");
    }
}
