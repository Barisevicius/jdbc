package program;

import program.Entity.Employee;
import program.db.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {

        List<Employee> empl = DBUtils.showEmployee();
        for(int i =0; i < empl.size(); i++){
            System.out.println(empl.get(i));
        }




    }
}
