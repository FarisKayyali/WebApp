//package com.example.demo;
//
//import java.sql.*;
//
//public class DB {
//
//    public static DB instance = new DB();
//    Connection connection = null;
//    private DB() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "faris");
//            System.out.println("connected");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public ResultSet executeSelect(String selectQuery){
//        try{
//            Statement stmt = connection.createStatement();
//            return stmt.executeQuery(selectQuery);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public char userType(String id, String password) {
//        try {
//
//
//
//            String sqlQuery = "select * from students where id = ? and password = ?;";
//            PreparedStatement ps = connection.prepareStatement(sqlQuery);
//            ps.setString(1, id);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()){
//                return 'S';
//            }
//
//            String sqlQuery2 = "select * from instructors where id = ? and password = ?;";
//            PreparedStatement ps2 = connection.prepareStatement(sqlQuery2);
//            ps2.setString(1, id);
//            ps2.setString(2, password);
//            rs = ps2.executeQuery();
//            if (rs.next()){
//                return 'I';
//            }
//
//            String sqlQuery3 = "select * from admins where id = ? and password = ?";
//            PreparedStatement ps3 = connection.prepareStatement(sqlQuery3);
//            ps3.setString(1, id);
//            ps3.setString(2, password);
//            rs = ps3.executeQuery();
//            if (rs.next()){
//                return 'A';
//            }
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 'N';
//    }
//
//    public boolean executeAdminQuery(String sqlStmt){
//        Connection connection = null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "faris");
//            System.out.println("connected");
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(sqlStmt);
//            connection.close();
//        } catch(Exception e){
//            e.printStackTrace();
//            try {
//                connection.close();
//            } catch (Exception ee){
//                ee.printStackTrace();
//            }
//            return false;
//        }
//        return true;
//    }
//}
