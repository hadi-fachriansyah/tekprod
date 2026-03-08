public class Cylinder extends Shape{
      public double radius;
      public double height;

      public Cylinder(double r,double h) {
            super("Cylinder");
            radius=r;
            height=h;
      }

      @Override
      public double area() {
            return Math.PI*(radius*radius)*height;
      }
      
      @Override
      public String toString(){
            return super.toString() + " with a radius "+radius+" and height "+height+" has a surface area of "+area();
      }
}
