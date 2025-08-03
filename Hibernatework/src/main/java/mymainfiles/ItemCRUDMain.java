package mymainfiles;

import mydaofiles.ItemDAO;
import mypojos.Item;

import java.util.List;
import java.util.Scanner;

public class ItemCRUDMain {
    public static void main(String[] args) {
        ItemDAO dao = new ItemDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------------------------------");
            System.out.println("Hibernate Item CRUD");
            System.out.println("------------------------------");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    dao.addItem(name, price);
                    break;

                case 2:
                    List<Item> items = dao.getAllItems();
                    items.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    dao.updateItem(uid, newName, newPrice);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteItem(did);
                    break;

                case 5:
                    System.out.print("Enter ID to fetch: ");
                    int fid = sc.nextInt();
                    Item fetched = dao.getItemById(fid);
                    System.out.println(fetched != null ? fetched : "Item not found.");
                    break;

                case 0:
                    dao.close();
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        sc.close();
    }
}
