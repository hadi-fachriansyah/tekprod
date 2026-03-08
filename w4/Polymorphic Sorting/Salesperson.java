
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// *******************************************************
public class Salesperson implements Comparable{
      private String firstName, lastName;
      private int totalSales;
      //------------------------------------------------------
      // Constructor: Sets up the sales person object with
      // the given data.
      //------------------------------------------------------
      public Salesperson (String first, String last, int sales){
            firstName = first;
            lastName = last;
            totalSales = sales;
      }
      //-------------------------------------------
      // Returns the sales person as a string.
      //-------------------------------------------
      @Override
      public String toString(){
            return lastName + ", " + firstName + ": \t" + totalSales;
      }
      //-------------------------------------------
      // Returns true if the sales people have
      // the same name.
      //-------------------------------------------
      @Override
      public boolean equals (Object other){
            return (lastName.equals(((Salesperson)other).getLastName()) &&
            firstName.equals(((Salesperson)other).getFirstName()));
      }
      //--------------------------------------------------
      // Order is based on total sales with the name
      // (last, then first) breaking a tie.
      //--------------------------------------------------
      @Override
      public int compareTo(Object other){
            int result = -1;
            Integer sales = totalSales;
            Salesperson sales2= (Salesperson) other; //biar ga ribet

            if (sales >(sales2.getSales())) {
                  result = 1;
            }
            if (sales.equals(sales2.getSales())) {
                  if (lastName.equals((sales2).getLastName())){
                        result = firstName.compareTo(sales2.getFirstName());
                  }
                  else {
                        result = lastName.compareTo(sales2.getLastName());
                  }
            }
            result = (result == 0) ? -1 : result; //kalo duplikat, probs never
            return result;
      }
      //-------------------------
      // First name accessor.
      //-------------------------
      public String getFirstName(){
            return firstName;
      }
      //-------------------------
      // Last name accessor.
      //-------------------------
      public String getLastName(){
            return lastName;
      }
      //-------------------------
      // Total sales accessor.
      //-------------------------
      public int getSales(){
            return totalSales;
      }
}
