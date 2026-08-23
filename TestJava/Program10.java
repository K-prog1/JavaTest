import java.util.ArrayList;

abstract class Shape{

    abstract double getVolume();
}

abstract class SolidOfRevolution extends Shape{
    protected double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
}

class Ball extends SolidOfRevolution{
    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }

    public Ball(double radius){
        super(radius);
    }
}

class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }
    @Override
    public double getVolume(){
        return Math.PI * radius * radius * height;
    }
}

class Pyramid extends Shape{
    private double s;
    private double h;

    public Pyramid(double s, double h){
        this.s = s;
        this.h = h;
    }
    @Override
    public double getVolume(){
        return h * s * 4 / 3;
    }
}

class Box extends Shape{
    private ArrayList<Shape> shapes = new ArrayList<>(); 
    private double available;
    private double volume;

    public Box(double available){
        this.available = available;
        this.volume = available;

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

    @Override
        public double getVolume(){
            return volume;
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

