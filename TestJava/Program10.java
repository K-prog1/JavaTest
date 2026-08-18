import java.util.ArrayList;

class Shape{
    private double volume;

    public Shape(double volume){
        this.volume = volume;
    }

    public  double getVolume() {
        return volume;
    }
}

class SolidOfRevolution extends Shape{
    private double radius;

    public SolidOfRevolution(double radius, double volume){
        super(volume);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
}

class Ball extends SolidOfRevolution{
    public Ball(double radius){
        super((4.0/3.0) * Math.PI * Math.pow(radius, 3),radius );
    }
}

class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height){
        super(Math.PI*Math.pow(radius, 2)*height, radius);
        this.height = height;
    }
}

class Pyramid extends Shape{
    private double s;
    private double h;

    public Pyramid(double s, double h){
        super(1.0/3.0 * s * h);
        this.s = s;
        this.h = h;
        
    }
}

class Box extends Shape{
    private ArrayList<Shape> shapes = new ArrayList<>(); 
    private double available;

    public Box(double available){
        super(available);
        this.available = available;

    }

    public boolean add(Shape shape){
        if (available >= shape.getVolume()){
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            System.out.print("Опана недостаточно памяти: ");
            return false;
        }
    }

}

public class Program10 {
    public static void main(String[] args){
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(5, 10);
        Pyramid pyramid = new Pyramid(100, 1000);

        Box box = new Box(10000);

        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(pyramid));
    }
}

