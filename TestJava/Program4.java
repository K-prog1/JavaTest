class Vector {

    private double x,y,z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double scolar(Vector vector){
        return x*vector.x + y*vector.y + z*vector.z;
    }

    public Vector proizv(Vector vector){
        
        double newx = y*vector.z - z*vector.y;
        double newy = z*vector.x - x*vector.z;
        double newz = x*vector.y - y*vector.x;
        
        return new Vector(newx, newy, newz);
    }

    public double cosinus(Vector vector){
        return scolar(vector)/(length()* vector.length());
    }

    public Vector add(Vector vector){
        double sumx = x + vector.x;
        double sumy = y + vector.y;
        double sumz = z + vector.z;
        return new Vector(sumx, sumy, sumz)
    ;}

    public Vector subtract(Vector vector){
        double minx = x - vector.x;
        double miny = y - vector.y;
        double minz = z - vector.z;
        return new Vector(minx, miny, minz)
    ;}
    public static Vector[] generate(int n){
        Vector[] vectors = new Vector[n];
            for(int i = 0; i<n;i++){
                vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
            }
            return vectors;
    }
    @Override
    public String toString() {
        return "Vector{" +
                "x" + x +
                ", y=" + y +
                ". z=" + z +
                 "}";
    }
}

