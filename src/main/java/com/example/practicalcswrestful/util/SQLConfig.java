package com.example.practicalcswrestful.util;

public class SQLConfig {

    public static final String DATABASE_EMPLOYEES_INSERT = "insert into employees ( name, price ) values (?,?)";
    public static final String DATABASE_EMPLOYEES_SELECT = "select * from employees";
    public static final String DATABASE_EMPLOYEES_SELECT2 = "select * from employees where id = ?";
    public static final String DATABASE_EMPLOYEES_UPDATE = "update employees set name = ?, salary = ? where id = ?";
    public static final String DATABASE_EMPLOYEES_DELETE = "delete from employees where id = ?";
}
