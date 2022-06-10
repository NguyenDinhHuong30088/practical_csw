package com.example.practicalcswrestful.model;

import com.example.practicalcswrestful.entity.Employees;
import com.example.practicalcswrestful.util.ConnectionHelper;
import com.example.practicalcswrestful.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeesModel implements EmployeesModel{
    //    private static List<Product> products = new ArrayList<>();

    @Override
    public boolean save(Employees obj) {
        try
        {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATABASE_EMPLOYEES_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setDouble(2, obj.getSalary());
            preparedStatement.execute();
            return true;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
//        products.add(product);
//        return product;
    }

    @Override
    public boolean update(Employees updateObj, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_EMPLOYEES_UPDATE);
            statement.setString(1, updateObj.getName());
            statement.setDouble(2, updateObj.getSalary());
            statement.setInt(3, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
//        int foundIndex = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                foundIndex = i;
//            }
//        }
//        if (foundIndex != -1){
//            products.get(foundIndex).setPrice(product.getPrice());
//            products.get(foundIndex).setName(product.getName());
//        }
//        return  products.get(foundIndex);
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_EMPLOYEES_DELETE);
            statement.setInt(1,id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
//        int foundIndex = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                foundIndex = i;
//            }
//        }
//        if (foundIndex != -1){
//            products.remove(foundIndex);
//            return true;
//        }
//        return false;
    }

    @Override
    public List<Employees> findAll() {
        List<Employees> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.DATABASE_EMPLOYEES_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                Employees obj = new Employees(id, name, salary);
                listObj.add(obj);
            }
        }catch (Exception e){

        }
        return listObj;
//        return products;
    }

    @Override
    public Employees findById(int id) {
        Employees obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_EMPLOYEES_SELECT2);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                obj = new Employees(id, name, salary);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
        //        int foundIndex = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                foundIndex = i;
//            }
//        }
//        if (foundIndex != -1){
//            return  products.get(foundIndex);
//        }
//        return null;
    }
}
