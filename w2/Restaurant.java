//1
import java.util.Scanner;
public class Restaurant {
      //1. attribute bersifat private
      private String[] nama_makanan;
      private double[] harga_makanan;
      private int[] menu_id;
      private int[] stok;
      private static byte id = 0;

      public Restaurant() {
            nama_makanan = new String[10];
            harga_makanan = new double[10];
            menu_id = new int[10];
            stok = new int[10];
      }

      public void tambahMenuMakanan( int menu_id, String nama, double harga, int stok) {
            this.setMenuId(id, menu_id);
            this.setNamaMakanan(id, nama);
            this.setHargaMakanan(id, harga);
            this.setStok(id, stok);
            nextId(); 
      }

      public void tampilMenuMakanan() {
            for (int i = 0; i < id; i++) { 
                  if (!isOutOfStock(i)) {
                        System.out.printf("%-5s %-25s %-20s %-10s%n",
                              this.getMenuId(i) + ".",
                              this.getNamaMakanan(i),
                              "Rp. " + this.getHargaMakanan(i),
                              this.getStok(i)
                        );
                  }
            }
      }
      //3. validasi stok
      public boolean isOutOfStock(int id) {
            return stok[id] < 0; 
      }

      public static void nextId() {
            id++;
      }

      // 4. fitur pemesanan menu
      public void OrderMakanan(Runnable tampilMenu){
            Scanner order = new Scanner(System.in);
            
            int[] keranjangId = new int[10];
            int[] keranjangJumlah = new int[10];
            int totalItem = 0;
      
            String pilihan = "";
            
            while (!pilihan.equals("0")) {
                // clear terminal
                  System.out.print("\033[H\033[2J");
                  System.out.flush();
                  tampilMenu.run();
                // tampil keranjang kalau ada
                  if (totalItem > 0) {
                        System.out.println("\n=== Keranjang ===");
                        double total = 0;
                        for (int i = 0; i < totalItem; i++) {
                        int idx = keranjangId[i] - 1; // -1 karena menu_id mulai dari 1
                        double subtotal = harga_makanan[idx] * keranjangJumlah[i];
                        total += subtotal;
                        System.out.printf("%-25s x%-5d Rp. %.1f%n",
                              getNamaMakanan(idx),
                              keranjangJumlah[i],
                              subtotal
                        );
                        }
                        System.out.println("-----------------------------");
                        System.out.printf("%-25s %s%.1f%n", "Total", "Rp. ", total);
                  }
            
                // input
                  System.out.println("\n=====================================");
                  System.out.println("[1-" + id + "] Pesan  [0] Selesai"); // id disesuaikan dengan jumlah menu
                  System.out.print("Pilihan: ");
                  pilihan = order.nextLine();
            
                  if (pilihan.equals("0")) {
                        break;
                  } else {
                        try {
                        int pilihanId = Integer.parseInt(pilihan);
                        int idx = pilihanId - 1;
                        
                        // validasi id
                        if (idx < 0 || idx >= id) {
                              System.out.println("Menu tidak ada!");
                              order.nextLine();
                              continue;
                        }
                        
                        // cek stok
                        if (isOutOfStock(idx)) {
                              System.out.println("Stok habis!");
                              order.nextLine();
                              continue;
                        }
                        
                        // input jumlah
                        System.out.print("Jumlah: ");
                        try {
                              int jumlah = Integer.parseInt(order.nextLine());
                              if (jumlah >0){ 
                                    // cek jumlah tidak melebihi stok
                                    if (jumlah > stok[idx]) {
                                          System.out.println("Jumlah melebihi stok! Stok tersisa: " + stok[idx]);
                                          order.nextLine();
                                          continue;
                                    }
                                    
                                    // tambah ke keranjang
                                    keranjangId[totalItem] = pilihanId;
                                    keranjangJumlah[totalItem] = jumlah;
                                    totalItem++;
                                    
                                    // kurangi stok
                                    setStok(idx, getStok(idx) - jumlah);
                              }
                              else{
                                    System.out.println("Jumlah tidak valid!");
                                    order.nextLine();
                              }
                        } catch (Exception e) {
                              System.out.println("Jumlah tidak valid!");
                              order.nextLine();
                              
                        }
                        
                        } catch (NumberFormatException e) {
                        System.out.println("Pilihan tidak valid!");
                        order.nextLine();
                        }
                  }
            }
            
            // tampil ringkasan akhir
            if (totalItem > 0) {
                  System.out.println("\n=== Ringkasan Pesanan ===");
                  double total = 0;
                  for (int i = 0; i < totalItem; i++) {
                        int idx = keranjangId[i] - 1;
                        double subtotal = getHargaMakanan(idx) * keranjangJumlah[i];
                        total += subtotal;
                        System.out.printf("%-25s x%-5d Rp. %.1f%n",
                        getNamaMakanan(idx),
                        keranjangJumlah[i],
                        subtotal
                        );
                  }
                  System.out.println("-----------------------------");
                  System.out.printf("Total: Rp. %.1f%n", total);
                  System.out.println("Terima kasih!");
            } else {
                  System.out.println("Tidak ada pesanan.");
            }
            order.close();
      }

      //2. access data dilakukan oleh getter dan setter

      public String getNamaMakanan(int index) {
            return nama_makanan[index];
      }

      public void setNamaMakanan(int index, String nama) {
            this.nama_makanan[index] = nama;
      }

      public double getHargaMakanan(int index) {
            return harga_makanan[index];
      }

      public void setHargaMakanan(int index, double harga) {
            this.harga_makanan[index] = harga;
      }

      public int getStok(int index) {
            return stok[index];
      }

      public void setStok(int index, int stok) {
            this.stok[index] = stok;
      }

      public int getMenuId(int index) {
            return menu_id[index];
      }
      public void setMenuId(int index, int menu_id) {
            this.menu_id[index] = menu_id;
      }
}

/*

*/
