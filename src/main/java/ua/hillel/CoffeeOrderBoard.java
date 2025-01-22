package ua.hillel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final List<Order> orders;
    private int ordersCount;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
        this.ordersCount = 0;
        logger.info("Coffee Order Board initialized");
    }

    public void addOrder(String guestName) {
        if (guestName == null || guestName.isEmpty()) {
            logger.error("Failed to add order: guest name is missing");
            throw new CoffeeOrderBoardException("Enter guest name");
        }
        ordersCount++;
        Order order = new Order(ordersCount, guestName);
        orders.add(order);
        logger.info("Order added: {}", order);
        logger.debug("Total orders count: {}", orders.size());
    }

    public void deliver() {
        if (orders.isEmpty()) {
            logger.error("Failed to deliver order: Orders list is empty");
            throw new CoffeeOrderBoardException("Orders list is empty");
        }
        Order order = orders.remove(0);
        logger.info("Deliver order {}", order);
    }

    public void deliver(int orderNum) {
        logger.debug("Attempting to deliver order: {}", orderNum);
        boolean removed = orders.removeIf(order -> order.getOrderNum() == orderNum);
        if (!removed) {
            logger.error("Failed to deliver order: {}", orderNum);
            throw new CoffeeOrderBoardException("Order not found");
        }
        logger.info("Delivered order: {}", orderNum);
    }

    public String draw() {
        logger.info("Drawing Coffee Order Board");
        StringBuilder sb = new StringBuilder();
        sb.append("No. | Name\n");
        orders.forEach(order -> sb.append(order.toString()).append("\n"));
        logger.debug("Board contents:\n{}", sb);
        return sb.toString();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getOrdersCount() {
        return ordersCount;
    }
}
