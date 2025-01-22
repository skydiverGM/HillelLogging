package ua.hillel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        logger.info("Application started");

        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.addOrder("Jack");
        board.addOrder("Jill");
        board.addOrder("Bob");
        board.deliver();
        board.deliver(3);

        logger.info("Application ended");
    }
}
