package Hibernate.CommandHandler.Customer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Customer;
import Hibernate.Storage.AbstractDao;

public class UpdateCustomer implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных!");
                return;
            }
            AbstractDao<Customer> customerDao = new AbstractDao<>(Customer.class);
            Customer customer = customerDao.getDaoById(id);
            if (customer != null) {
                customer.setName(parameters[1]);
                customer.setCountry(parameters[2]);
                customerDao.updateDao(customer);
            } else System.out.println("Customer not found");
        } else System.out.println("Неверное число параметров!");
    }
}
