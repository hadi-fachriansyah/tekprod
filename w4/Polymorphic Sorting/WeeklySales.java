import java.io.*;
import java.util.*;

public class WeeklySales {
      public static void main(String[] args) {
            ArrayList<Salesperson> salesGang = new ArrayList<>();

            try {
            Scanner fileScan = new Scanner(new File("salesStaff.txt"));

            while (fileScan.hasNextLine()) {
                  String line = fileScan.nextLine(); 
                  String[] data = line.split(","); 
                  String first= data[0];
                  String last = data[1];
                  int sales = Integer.parseInt(data[2]); 
                  salesGang.add(new Salesperson(first, last, sales)); 
            }
            fileScan.close();
            } 

            catch (FileNotFoundException e) {
            System.out.println("File not foundd");
            }

            Salesperson[] salesStaff = new Salesperson[salesGang.size()];
            salesGang.toArray(salesStaff);
            Sorting.insertionSort(salesStaff);
            for (Salesperson s : salesStaff) {
                  System.out.println(s);
            }
      }
}
