/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import bean.Config;
import service.menu.MenuAddStudentService;
import service.menu.MenuAddTeacherService;
import service.menu.MenuLoginService;
import service.menu.MenuRegisterService;
import service.menu.MenuShowAllStudentService;
import service.menu.MenuShowAllTeacherService;
import static util.MenuUtil.showMenu;
import service.inter.Process;

/**
 *
 * @author anarq
 */
public enum Menu {
    LOGIN(1, "Login", new MenuLoginService()),//enumlar
    REGISTER(2, "Register", new MenuRegisterService()),
    ADD_TEACHER(3, "Add teacher", new MenuAddTeacherService()),
    ADD_STUDENT(4, "Add Student", new MenuAddStudentService()),
    SHOW_ALL_TEACHER(5, "Show all teachers", new MenuShowAllTeacherService()),
    SHOW_ALL_STUDENT(6, "Show all students", new MenuShowAllStudentService()),
    UNKNOWN;

    private String label;
    private Process service;//bunu process metodunu yazandan sonra yazdiq
    private int number;

    Menu() {
    }

    Menu(int number, String label, Process service) {//enumlardaki stringker bura oturulur
        this.label = label;
        this.service = service;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return number + "." + label;
    }

    public void process() {
        service.process();
        MenuUtil.showMenu();
    }

    public int getNumber() {
        return this.number;
    }

    public static Menu find(int number) {
        Menu[] menus = Menu.values();
        for (int i = 0; i < menus.length; i++) {
            if (menus[i].getNumber() == number) {
                return menus[i];
            }
        }
        return Menu.UNKNOWN;
    }

    public static void showAllMenu() {
        Menu[] menus = Menu.values();
        for (int i = 0; i < menus.length; i++) {
            if (menus[i] != UNKNOWN) {
                if (menus[i] == LOGIN || menus[i] == REGISTER) {//bunu sonradan elave eledik
                    if (!Config.isLoggedIn()) {
                        System.out.println(menus[i]);
                    }
                } else if (Config.isLoggedIn()) {//bunu da
                    System.out.println(menus[i]);
                }
            }
        }
    }
}
