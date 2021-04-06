package unittests;

import org.junit.jupiter.api.Test;
import primitives.Util;
import primitives.Vector;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============
        try {
            new Vector(0,0,1);
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct Vector");
        }
        try {
            new Vector(0,0,0);
            fail("Constructed a Vector with an invalid argument");
        } catch (IllegalArgumentException e) {}
    }
    @Test
    void add() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        try{
       Vector v2= v1.add(new Vector(-1, -2, -3));
            fail("Add() created a Vector with an invalid argument");
        } catch (IllegalArgumentException e) {}
        // ============ Equivalence Partitions Tests ==============
        Vector v2= new Vector(4,5,6);
        assertEquals(new Vector(5,7,9), v1.add(v2),  "add() wrong result ");


    }

    @Test
    void substract() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        try{
            Vector v2= v1.substract(new Vector(1, 2, 3));
            fail("Substract() created a Vector with an invalid argument");
        } catch (IllegalArgumentException e) {}
        // ============ Equivalence Partitions Tests ==============
        Vector v2= new Vector(4,5,6);
        assertEquals(new Vector(-3,-3,-3), v1.substract(v2),  "substract() wrong result ");

    }

    @Test
    void scale() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        try{
            v1.scale(0);
            fail("scale() created a Vector with an invalid argument");
        } catch (IllegalArgumentException e) {}
        // ============ Equivalence Partitions Tests ==============
        assertEquals(new Vector(3,6,9), v1.scale(3),  "scale() wrong result");

    }

    @Test
    void dotProduct() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(3, 2, 1);
        assertEquals(10, v1.dotProduct(v2),  "dotProduct() wrong result");

    }

    @Test
    void crossProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        // assertEquals("crossProduct() wrong result length", v1.length() * v2.length(), vr.length(), 0.00001);
        assertEquals(v1.length() * v2.length(), vr.length(), 0.00001, "crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(Util.isZero(vr.dotProduct(v1)), "crossProduct() result is not orthogonal to 1st operand");
        assertTrue(Util.isZero(vr.dotProduct(v2)), "crossProduct() result is not orthogonal to 1st operand");
        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        //assertThrows("crossProduct() for parallel vectors does not throw an exception",IllegalArgumentException.class, () -> v1.crossProduct(v3));
        assertThrows(IllegalArgumentException.class,
                () -> v1.crossProduct(v3), "crossProduct() for parallel vectors does not throw an exception");
        // try {
        //     v1.crossProduct(v2);
        //     fail("crossProduct() for parallel vectors does not throw an exception");
        // } catch (Exception e) {}


    }

    @Test
    void lengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(1, 2, 3);
        assertEquals(14,v.lengthSquared(), 0.00001, "lengthSquared() wrong value");
    }

    @Test
    void length() {
        // ============ Equivalence Partitions Tests ==============
        assertEquals(5,new Vector(0, 3, 4).length(), 0.00001, "length() wrong value");
    }

    @Test
    void normalize() {
        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(1, 2, 3);
        Vector vCopy = new Vector(v.getHead());
        Vector vCopyNormalize = vCopy.normalize();
        assertEquals(vCopy,vCopyNormalize,"ERROR: normalize() function creates a new vector");
        assertEquals(1,vCopyNormalize.length(),"normalize() result is not a unit vector");
        assertEquals(new Vector(1/Math.sqrt(14), 2/Math.sqrt(14), 3/Math.sqrt(14)),vCopyNormalize,"normalize() wrong value");

    }

    @Test
    void normalized() {
        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalized();
        assertNotEquals(u,v,"normalizated() function does not create a new vector");
    }
}