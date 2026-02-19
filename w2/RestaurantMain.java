//2
public class RestaurantMain {
      
      public static void main(String[] args) {
            Restaurant menu = new Restaurant();
            menu.tambahMenuMakanan(1, "Pizza", 250000, 2);
            menu.tambahMenuMakanan(2,"Spaghetti", 80000, 20);
            menu.tambahMenuMakanan(3,"Tenderloin Steak", 60000, 30);
            menu.tambahMenuMakanan(4, "Chicken Steak", 45000, 30);
            menu.tampilMenuMakanan();
            Runnable tampilMenu = () -> {
                  System.out.println("\n===================== Menu Makanan =====================");
                  System.out.printf("%-5s %-25s %-20s %-10s%n", "Id.", "Nama Makanan", "Harga", "Stok");
                  menu.tampilMenuMakanan();
                  System.out.println("=========================================================");
            };
            
            menu.OrderMakanan(tampilMenu);
      }
}
