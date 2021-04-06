package unittests;

import org.junit.jupiter.api.Test;
import primitives.*;
import geometries.*;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getNormal() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1= new Point3D(1,1,1);
        Point3D p2= new Point3D(2,3,2);
        Point3D p3= new Point3D(3,1,2);
        Point3D p4= new Point3D(p2);
        Triangle t = new Triangle(p1,p2,p3);
        assertEquals(new Vector(2,1,-4), t.getNormal(p4),"getNormal() doesn't work properly");
    }
}