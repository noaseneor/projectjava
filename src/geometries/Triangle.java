package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Triangle extends Polygon {

    public Point3D p1;
    public Point3D p2;
    public Point3D p3;

    public Triangle(Point3D a, Point3D b , Point3D c )
    {
        super(a,b,c);
    }

    public Vector getNormal(Point3D p)
    {
       return super.getNormal(p);
    }

}
