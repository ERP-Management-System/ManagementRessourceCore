/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web.error;
 
import org.springframework.boot.web.servlet.error.ErrorController; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 
  
@Controller
public class MyErrorController implements ErrorController { 
  
    @GetMapping("/error") 
    public String handleError() { 
        return "error_page"; 
    } 
     
} 