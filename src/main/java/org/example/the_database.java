package org.example;

import java.sql.*;

public class the_database {
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String USER = "samuel";  // Change if necessary
    private static final String PASSWORD = "samuel";

    public static boolean isRegisteredUser(String name, String password) {

            String url = "jdbc:mysql://localhost:3306/login";
            String dbUser = "samuel";
            String dbPassword = "samuel";


            String query = "SELECT * FROM usersc WHERE name = ? AND password = ?";

            try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {


                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);


                ResultSet resultSet = preparedStatement.executeQuery();


                if (resultSet.next()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }


    public static void insertUser(String name, String password) throws SQLException {
        String sql = "INSERT INTO usersc (name, password) VALUES (?, ?)";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, password);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            }


    }

    }

