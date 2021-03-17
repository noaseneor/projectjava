package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry {

    Point3D q0;
    Vector normal;
    public Plane(Point3D a, Point3D b, Point3D c)
    {
        this.q0= new Point3D(a);
        Vector v1 = b.substract(a);
        normal = (v1.crossProduct(c.substract(a))).normalize();
        //normal=null;

    }
    public Plane(Point3D p, Vector v)
    {
        this.q0=new Point3D(p);
        this.normal=v;
    }
    @Override
    public Vector getNormal(Point3D p)
    {
        return null;
    }
    public Vector getNormal()
    {
        return getNormal(null);
    }



}

