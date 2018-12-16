package Hibernate.CommandHandler.Skill;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Skill;
import Hibernate.Storage.AbstractDao;

public class DeleteSkill implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный формат введенных данных!");
                return;
            }
            AbstractDao<Skill> skillDao = new AbstractDao<>(Skill.class);
            Skill skill = skillDao.getDaoById(id);
            skillDao.deleteDao(skill);
        } else System.out.println("Неверное число параметров!");
    }
}
