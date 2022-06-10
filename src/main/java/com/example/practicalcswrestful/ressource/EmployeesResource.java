package com.example.practicalcswrestful.ressource;

import com.example.practicalcswrestful.entity.Employees;
import com.example.practicalcswrestful.model.EmployeesModel;
import com.example.practicalcswrestful.model.InMemoryEmployeesModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/employeess")
@Produces("application/json")
@Consumes("application/json")
public class EmployeesResource {
    EmployeesModel employeesModel;
    public  EmployeesResource(){
        employeesModel = new InMemoryEmployeesModel();
    }

    @GET
    public List<Employees> fillAll(){
        return employeesModel.findAll();
    }

    @GET
    @Path("{id}")
    public Employees findById(@PathParam("id") int id){
        return employeesModel.findById(id);
    }

    @POST
    public boolean create(Employees employees){
        return employeesModel.save(employees);
    }

    @PUT
    @Path("{id}")
    public boolean update(@PathParam("id") int id, Employees updateEmployees){
        return employeesModel.update(updateEmployees, id);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") int id){
        return employeesModel.delete(id);
    }
}
