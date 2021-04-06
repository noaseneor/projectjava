package geometries;

import primitives.*;

public class Sphere {

    private double radius;
    private Point3D center;
    public Sphere( double r, Point3D c)
    {
        this.radius=r;
        this.center=c;
    }
    public double getRadius()
    {
        return this.radius;
    }
    public Point3D getCenter()
    {
        return this.center;
    }
    public void setRadius(double r)
    {
        this.radius=r;
    }
    public void setCenter(Point3D c)
    {
        this.center=c;
    }
    public Vector getNormal(Point3D p)

    {
       Vector n= p.substract(this.center);
       return n.normalize();
    }

}
