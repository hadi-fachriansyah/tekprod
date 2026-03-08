public class Commission extends Hourly{
      private double totalSales;
      private double CommissionRate;

      public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double ComRate) {

            super (eName, eAddress, ePhone, socSecNumber, rate);
            CommissionRate = ComRate;
      }

      public void addSales (double totalSales) {
            this.totalSales += totalSales;
      }
      
      @Override
            public double pay() {
            double payment = super.pay();
            payment += totalSales * CommissionRate;
            totalSales = 0;
            return payment;
      }

      @Override
      public String toString() {
            String result = super.toString();
            result += "\nTotal Sales: " + totalSales;
            return result;
      }
}
