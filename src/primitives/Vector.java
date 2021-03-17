package primitives;

public class Vector {
    Point3D head;

    public Vector(Coordinate _x, Coordinate _y, Coordinate _z )
    {
        Point3D p;
        p=new Point3D(_x,_y,_z);
        if(p.equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("invalid argument (0,0,0) cannot be head");
        }
        head =new Point3D(_x,_y,_z);
    }
    public Vector(double _x , double _y, double _z)
    {
        Point3D p;
        p=new Point3D(_x,_y,_z);
        if(p.equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("invalid argument (0,0,0) cannot be head");
        }
        head = new Point3D(_x , _y, _z);
    }
    public Vector(Point3D p)
    {
        if(p.equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("invalid argument (0,0,0) cannot be head");
        }
        head = new Point3D(p);
    }
    public Vector( Vector v)
    {
        if(v.head.equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("invalid argument (0,0,0) cannot be head");
        }
        head = new Point3D(v.head);
    }
    public Point3D getHead()
    {
        return this.head;
    }
    public Vector add(Vector v)
    {
        return new Vector(this.head.x.coord+v.head.x.coord,this.head.y.coord+v.head.y.coord,this.head.z.coord+v.head.z.coord);
    }
    public Vector substract(Vector v)
    {
        return new Vector(this.head.x.coord-v.head.x.coord,this.head.y.coord-v.head.y.coord,this.head.z.coord-v.head.z.coord);
    }
    public Vector substract(Point3D p)
    {
        return new Vector(this.head.x.coord-p.x.coord,this.head.y.coord-p.y.coord,this.head.z.coord-p.z.coord);
    }
    public Vector scale(int scalar)
    {
        return new Vector((this.head.x.coord)*scalar,(this.head.y.coord)*scalar,(this.head.z.coord)*scalar);
    }
    public double dotProduct(Vector v)
    {
        return (this.head.x.coord)*(v.head.x.coord) + (this.head.y.coord)*(v.head.y.coord)+ (this.head.z.coord)*(v.head.z.coord);
    }
    public Vector crossProduct(Vector v)
    {
        return new Vector((this.head.y.coord)*(v.head.z.coord)-(this.head.z.coord)*(v.head.y.coord),(this.head.z.coord)*(v.head.x.coord)-(this.head.x.coord)*(v.head.z.coord), (this.head.x.coord)*(v.head.y.coord)-(this.head.y.coord)*(v.head.x.coord));
    }
    public double lengthSquared()
    {
        return this.head.x.coord*this.head.x.coord + this.head.y.coord*this.head.y.coord +this.head.z.coord*this.head.z.coord;
    }
    public double length()
    {
        return Math.sqrt(lengthSquared());
    }
    public Vector normalize()
    {
        if(this.length()==0)
        {
            throw new ArithmeticException("cannot divide by 0");
        }
        this.head= new Point3D((this.head.x.coord)/this.length(),(this.head.y.coord)/this.length(),(this.head.z.coord)/this.length());
        return this;
    }
    public Vector normalized()
    {
        Vector v = new Vector(this);
        v.normalize();
        return v;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Vector)) return false;
        Vector other = (Vector)obj;
        return this.head.equals(other.head);
    }

    @Override
    public String toString()
    {
        return head.toString();
    }

}
