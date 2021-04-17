package secao13;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> listaItem = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}

	public String getMoment() {
		return sdf.format(moment);
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getListaItem() {
		return listaItem;
	}

	public void addItem(OrderItem orderItem) {
		listaItem.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		listaItem.remove(orderItem);
	}

	public double total() {
		double amount = 0;
		for (OrderItem i : listaItem) {
			amount += i.subTotal();
		}
		return amount;
	}

}
