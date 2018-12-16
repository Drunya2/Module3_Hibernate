package Hibernate.CommandHandler.Company;

        import Hibernate.CommandHandler.CommandHandler;
        import Hibernate.Entity.Company;
        import Hibernate.Storage.AbstractDao;

public class GetCompany implements CommandHandler {
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
            AbstractDao<Company> companyDao = new AbstractDao<>(Company.class);
            Company company = companyDao.getDaoById(id);
            if (company == null) System.out.println("Company not found!");
            else System.out.println("\n" + company);
        } else System.out.println("Неверное число параметров!");
    }
}
