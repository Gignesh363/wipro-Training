package com.traing;
import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "pass123");

            // Step 3: Create statement
            Statement stmt = con.createStatement();

            // Step 4: Execute UPDATE query
            String updateQuery1 = "UPDATE employee SET name = 'Ravi Kumar' WHERE id = 1";
            
            int rowsAffected1 = stmt.executeUpdate(updateQuery1);
            String updateQuery2 = "UPDATE employee SET name = 'Ramesh' WHERE id = 2";
            int rowsAffected2 = stmt.executeUpdate(updateQuery2);
            System.out.println("Rows updated: " + rowsAffected1);
            System.out.println("Rows updated: " + rowsAffected2);


            // Step 5: Execute SELECT query to verify update
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            // Step 6: Process results
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }

            // Step 7: Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
