public abstract class Shape {
      private String shapeName;
      abstract public double area();

      Shape(String shapeName){
            this.shapeName = shapeName;
      }
      
      @Override
      public String toString() {
            return "A "+shapeName;
      }

      
}
