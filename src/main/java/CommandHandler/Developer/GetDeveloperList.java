package Hibernate.CommandHandler.Developer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Developer;
import Hibernate.Storage.AbstractDao;


import java.util.List;

public class GetDeveloperList implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            AbstractDao<Developer> developerDao = new AbstractDao<>(Developer.class);
            List<Developer> developers = developerDao.getAllDao();
            System.out.println();
            if (developers.isEmpty()) System.out.println("This table is clear!");
            else for (Developer developer : developers) System.out.println(developer);
        } else System.out.println("Неверное число параметров!");
    }
}
