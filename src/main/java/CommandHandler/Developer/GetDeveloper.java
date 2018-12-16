package Hibernate.CommandHandler.Developer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Developer;
import Hibernate.Storage.AbstractDao;

public class GetDeveloper implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных");
                return;
            }
            AbstractDao<Developer> developerDao = new AbstractDao<>(Developer.class);
            Developer developer = developerDao.getDaoById(id);
            if (developer == null) System.out.println("Developer not found");
            else System.out.println("\n" + developer);
        } else System.out.println("Неверное число параметров");
    }
}
