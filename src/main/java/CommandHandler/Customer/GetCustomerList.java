package Hibernate.CommandHandler.Customer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Customer;
import Hibernate.Storage.AbstractDao;

import java.util.List;

public class GetCustomerList implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            AbstractDao<Customer> customerDao = new AbstractDao<>(Customer.class);
            List<Customer> customers = customerDao.getAllDao();
            System.out.println();
            if (customers.isEmpty()) System.out.println("This table is clear!");
            else for (Customer customer : customers) System.out.println(customer);
        } else System.out.println("Неверное число параметров!");
    }
}
