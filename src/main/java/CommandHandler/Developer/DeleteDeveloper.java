package Hibernate.CommandHandler.Developer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Developer;
import Hibernate.Storage.AbstractDao;

public class DeleteDeveloper implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            Developer developer = null;
            long idDeveloper = 0;
            try {
                idDeveloper = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных");
                return;
            }
            AbstractDao<Developer> developerDao = new AbstractDao<>(Developer.class);
            developer = developerDao.getDaoById(idDeveloper);

            if (developer == null) {
                System.out.println("Developer not found");
                return;
            }
            developerDao.deleteDao(developer);
        } else System.out.println("Неверное число параметров");
    }
}
