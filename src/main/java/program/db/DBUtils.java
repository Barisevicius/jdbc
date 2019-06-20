package program.db;

import program.DataSource;
import program.Entity.Department;
import program.Entity.Employee;
import program.Entity.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DBUtils {

    public DBUtils(){}

    public static void executeStmt(String sql, Consumer<PreparedStatement> cmd){
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            cmd.accept(preparedStatement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Employee> showEmployee() {
        List<Employee> listas = new ArrayList<>();
        try {
            Connection connection = DataSource.getConnection();


        String sql ="SELECT * FROM  employees INNER JOIN salaries ON salaries.emp_no = employees.emp_no LIMIT 10";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Employee employee;
        while(rs.next()){

        employee = new Employee();

        employee.setEmp_no(rs.getInt("emp_no"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setBirthDate(rs.getDate("birth_date").toLocalDate());
        employee.setHireDate(rs.getDate("hire_date").toLocalDate());
        employee.setSalary(new Salary());
        employee.getSalary().setFromDate(rs.getDate("from_date").toLocalDate());
        employee.getSalary().setToDate(rs.getDate("to_date").toLocalDate());
        employee.getSalary().setSalary(rs.getInt("salary"));
        listas.add(employee);

        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listas;
    }
}
