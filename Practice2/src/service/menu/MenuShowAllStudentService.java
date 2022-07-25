/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.menu;

import bean.Config;
import bean.Student;
import service.inter.menu.MenuShowAllStudentServiceInter;

/**
 *
 * @author anarq
 */
public class MenuShowAllStudentService implements MenuShowAllStudentServiceInter {

    @Override
    public void processLogic() {
        Student[] allStudent = Config.instance().getStudents();

        for (int i = 0; i < allStudent.length; i++) {
            System.out.println(allStudent[i]);
        }
    }
}
