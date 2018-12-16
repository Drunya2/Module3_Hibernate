package Hibernate.CommandHandler.Skill;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Skill;
import Hibernate.Storage.AbstractDao;

import java.util.List;

public class GetSkillList implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            AbstractDao<Skill> skillDao = new AbstractDao<>(Skill.class);
            List<Skill> skills = skillDao.getAllDao();
            System.out.println();
            if (skills.isEmpty()) System.out.println("This table is clear!");
            else for (Skill skill : skills) System.out.println(skill);
        } else System.out.println("Неверное число параметров!");
    }
}
