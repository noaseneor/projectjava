package unittests;

import geometries.Sphere;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
class SphereTest {

    @Test
    void getNormal() {
        // ============ Equivalence Partitions Tests ==============
        Sphere s = new Sphere(2, new Point3D(1,2,3));
        Point3D p= new Point3D(2,3,2);
        assertEquals(new Vector(1/Math.sqrt(3),1/Math.sqrt(3),-1/Math.sqrt(3)),s.getNormal(p),"getNormal() doesn't work properly");

    }
}