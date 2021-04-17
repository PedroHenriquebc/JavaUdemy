package secao13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYY): ");
		String date = sc.next();
		Date birthDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		birthDate = sdf.parse(date);
		
		Client c1 = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: " + OrderStatus.PROCESSING);
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		Date moment = new Date();
		Order order = new Order(moment, OrderStatus.PROCESSING, c1);
		System.out.println("Enter #1 item data:");
		for(int i = 0; i < items; i++) {
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + c1);
		System.out.println("Order items:");
		for(OrderItem i : order.getListaItem()) {
			System.out.printf(i.getProduct() + ", Quantity: " + i.getQuantity() + ", Subtotal:  $%.2f%n", i.subTotal() );
		}
		System.out.printf("Total price: $%.2f", order.total());
		sc.close();
	}

}
