package uz.pdp.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.pdp.userservice.entity.UserEntity;
import uz.pdp.userservice.payload.DTOs.UserDTO;
import uz.pdp.userservice.payload.responce.ApiResponce;
import uz.pdp.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public HttpEntity addUser(@RequestBody UserDTO user){
        ApiResponce apiResponce = userService.addUser(user);
        return ResponseEntity.status(apiResponce.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(apiResponce);
    }

    @PostMapping("/edit/{id}")
    public HttpEntity editUser(@PathVariable Long id, @RequestBody UserDTO user){
        ApiResponce responce = userService.editUser(user, id);
        return ResponseEntity.status(responce.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(responce);
    }

    @GetMapping("/all")
    public HttpEntity getAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{userName}")
    public HttpEntity getUserByUserName(@PathVariable String userName){
        UserDetails userDetails = userService.loadUserByUsername(userName);
        return ResponseEntity.ok(userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity deleteUser(@PathVariable Long id){
        ApiResponce apiResponce = userService.deleteUser(id);
        return ResponseEntity.status(apiResponce.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(apiResponce);
    }


}
