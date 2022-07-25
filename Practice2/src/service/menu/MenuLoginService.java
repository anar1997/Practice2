/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.menu;

import bean.Config;
import java.util.Scanner;
import service.inter.menu.MenuLoginServiceInter;

/**
 *
 * @author anarq
 */
public class MenuLoginService implements MenuLoginServiceInter {
    
    @Override
    public void processLogic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("username:");
        String username = sc.nextLine();
        
        Scanner sc2 = new Scanner(System.in);
        System.out.println("password:");
        String password = sc.nextLine();
        
        if (!(username.equals("user") && password.equals("11111"))) {
            throw new IllegalArgumentException("username or password is invalid");
        }
        Config.setLoggedIn(true);
    }
    
}
