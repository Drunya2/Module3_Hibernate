package Hibernate.CommandHandler.Customer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Customer;
import Hibernate.Storage.AbstractDao;

public class CreateCustomer implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2) {
            AbstractDao<Customer> customerDao = new AbstractDao<>(Customer.class);
            Customer customer = new Customer();
            customer.setName(parameters[0]);
            customer.setCountry(parameters[1]);
            customerDao.createDao(customer);
        } else System.out.println("Неверное число параметров!");
    }
}
