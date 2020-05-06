/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;


@Component
@Path("/user")
public class UserWebService {

    @Autowired
    UserService userService;
    User user = new User();

    @Path("/getAlll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getll(User user) {
        user.setName("Alshimaaaa");
        user.setSalary(6000);
        user.setBouns(100);
        user.setDeduction(2);
        return userService.getAllSalary(user);
         
    }

    @Path("/getAll")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalary(@RequestBody User user) {
        user.setName("ALshimaa");
        user.setSalary(6000);
        user.setBouns(100);
        System.out.println(userService.getAllSalary(user));
        return Response.status(200).
                entity("{\"netSalary\":" + userService.getAllSalary(user) + "}").build();
//  return user;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        User user = new User();
        user.setName("Alshimaaaaaaaa");
        user.setSalary(10000);
        user.setBouns(2000);
        System.out.println("ddd");
        return user;
    }
}
