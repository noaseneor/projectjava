package unittests;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;
import geometries.*;
import static org.junit.jupiter.api.Assertions.*;
class PlaneTest {

    @Test
    public void testConstructor(){
        // ============ Equivalence Partitions Tests ==============

        //TC01: regular values
        try {
            new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct plane");
        }

        // =============== Boundary Values Tests ==================

        //TC10 : the first and second point are the same point
        try {
            new Plane(new Point3D(0, 0, 1), new Point3D(0, 1, 0),new Point3D(0, 0, 1));
            fail("Constructed a plane with two same points");

        } catch (IllegalArgumentException e) {}

        //TC11 : third points are on the same line
        try {
            new Plane(new Point3D(0, 0, 1), new Point3D(0, 0, 2),
                    new Point3D(0, 0, 4));
            fail("Constructed a plane three points on the same line");

        } catch (IllegalArgumentException e) {}

    }
    @Test
    void getNormal() {
        Vector v= new Vector(2,1,2);
        Point3D p= new Point3D(1,1,1);
        Plane plane= new Plane(p,v);
        assertEquals(new Vector(2,0,-2),plane.getNormal(new Point3D(1,2,1)), " getNormal() doesn't work properly");

    }
}