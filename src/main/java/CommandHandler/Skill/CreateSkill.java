package Hibernate.CommandHandler.Skill;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Skill;
import Hibernate.Entity.SkillLevel;
import Hibernate.Storage.AbstractDao;

public class CreateSkill implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2) {
            String language = parameters[0];
            SkillLevel skillLevel = null;
            try {
                skillLevel = SkillLevel.valueOf(parameters[1]);
            } catch (IllegalArgumentException iea) {
                System.out.println("Level must be junior/middle/senior");
                return;
            }
            AbstractDao<Skill> skillDao = new AbstractDao<>(Skill.class);
            Skill skill = new Skill();
            skill.setSkill(language);
            skill.setSkillLevel(skillLevel);
            skillDao.createDao(skill);
        } else System.out.println("Неверное число параметров!");
    }
}
