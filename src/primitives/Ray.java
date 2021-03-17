package primitives;

public class Ray {

    Point3D p0;
    Vector dir;

    public Ray (Point3D p, Vector d)
    {
        this.p0=new Point3D(p);
        this.dir=d.normalized();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray other = (Ray)obj;
        return this.p0.equals(other.p0) && this.dir.equals(other.dir);
    }

}
