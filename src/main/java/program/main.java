package program;

import program.Entity.Employee;
import program.db.DBUtils;
import program.db.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {

        List<Employee> empl = DBUtils.showEmployee();

      //  empl = DBUtils.updSalaries(empl);
       empl.forEach(System.out::println);





    }
}
