package primitives;

public class Point3D {

    Coordinate x;
    Coordinate y;
    Coordinate z;
    public final static Point3D ZERO= new Point3D(0.0,0.0,0.0);
    public Point3D(Coordinate x,Coordinate y,Coordinate z)
    {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public Point3D(double x,double y,double z)
    {
        this(new Coordinate(x),new Coordinate(y),new Coordinate(z));
    }
    public Point3D(Point3D p)
    {
        this.x=p.x;
        this.y=p.y;
        this.z=p.z;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point3D)) return false;
        Point3D other = (Point3D)obj;
        return this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z);
    }

    @Override
    public String toString()
    {
        return "(" +x +"," +y+"," +z+")";
    }

    public Vector substract(Point3D other)
    {
        return new Vector(new Point3D(this.x.coord - other.x.coord, this.y.coord - other.y.coord,this.z.coord - other.z.coord));
    }
    public Point3D add(Vector v)
    {
        return new Point3D(this.x.coord+v.head.x.coord,this.y.coord+v.head.y.coord,this.z.coord+v.head.z.coord);
    }
    public double distance(Point3D other)
    {
        return (this.x.coord-other.x.coord)*(this.x.coord-other.x.coord)+(this.x.coord-other.x.coord)*(this.x.coord-other.x.coord)+(this.y.coord-other.y.coord)*(this.z.coord-other.z.coord);
    }
    public double distancesquared(Point3D other)
    {
        return Math.sqrt(distance(other));
    }

}