package Hibernate.CommandHandler.Skill;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Skill;
import Hibernate.Storage.AbstractDao;

public class GetSkill implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных!");
                return;
            }
            AbstractDao<Skill> skillDao = new AbstractDao<>(Skill.class);
            Skill skill = skillDao.getDaoById(id);
            if (skill == null) System.out.println("Skill not found");
            else System.out.println("\n" + skill);
        } else System.out.println("Неверное число параметров!");
    }
}
