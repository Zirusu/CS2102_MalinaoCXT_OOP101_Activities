import java.util.Scanner;

public class Canteen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int total_items = 0;
        double subtotal = 0;
        double totalDiscount = 0;
        double discount = 0;
        double checkout = 0;
        double price = 0;

        System.out.println("=====   M E N U    =====");
        System.out.println("1. Burger\t - $80.00");
        System.out.println("2. Pizza\t - $120.00");
        System.out.println("3. Pasta\t - $100.00");
        System.out.println("4. Sandwich\t - $70.00");   
        System.out.println("5. Latte\t - $90.00"); 
        System.out.println();

        do{
            System.out.print("Enter item number: ");
            int item = sc.nextInt();
            System.out.print("Enter quantity: ");
            double quantity = sc.nextDouble();

            if (!((quantity > 0 && quantity <= 10) && (item > 0 && item <= 5))){
                System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
                continue;
            }

            if (item == 1){
                price = 80;
            } else if(item == 2){
                price = 120;
            } else if(item == 3){
                price = 100;
            } else if(item == 4){
                price = 70;
            } else if (item == 5){
                price = 90;
            }

            double currentTotal = price * quantity;

            System.out.print("Are you a student? (Y/N): ");
            char student = Character.toUpperCase(sc.next().charAt(0));
            System.out.println();

            while (student != 'Y' && student != 'N') {
                System.out.println("Invalid input! Enter a valid input.\n");
                System.out.print("Are you a student? (Y/N): ");
                student = Character.toUpperCase(sc.next().charAt(0));
                System.out.println();
            }
            if (student =='Y'){
                discount = (currentTotal >= 500) ? 0.15 : 0.10 ;
            } else {
                discount = (currentTotal >= 500) ? 0.05 : 0.0 ;
            }
            

            double currentDiscount = discount * currentTotal;
            double currentOrderTotal = currentTotal - currentDiscount;

            total_items += quantity;
            subtotal += currentTotal;
            totalDiscount += currentDiscount;
            checkout += currentOrderTotal;

            System.out.printf("Subtotal: $%.2f\n" , currentTotal);
            System.out.printf("Discount: $%.2f\n"  , currentDiscount);
            System.out.printf("Order total: $%.2f\n"  , currentOrderTotal);
            System.out.println();

            System.out.print("Do you want to order again? (Y/N): ");
            char cont = Character.toUpperCase(sc.next().charAt(0));
            while (cont != 'Y' && cont != 'N') {
                System.out.println("Enter a valid input.\n");
                System.out.print("Do you want to order again? (Y/N): ");
                cont = Character.toUpperCase(sc.next().charAt(0));
                System.out.println();
                }
            if(cont == 'N'){
                System.out.println();
                break;
            }
            
        }while(true);

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + total_items);
        System.out.printf("Total before discount: $%.2f\n" , subtotal);
        System.out.printf("Total discount: $%.2f\n" , totalDiscount);
        System.out.printf("Final amount: $%.2f\n" , checkout);
        System.out.println("Thank you for ordering!");
        System.out.println();
        sc.close();
}
}