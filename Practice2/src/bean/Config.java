/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.Serializable;
import util.FileUtility;

/**
 *
 * @author anarq
 */
public class Config implements Serializable {

    private static final String fileName = "app.obj";

    public static void initialize() throws Exception{
        Object obj = FileUtility.readFileDeserialize(fileName);
        if (obj == null) {
            return;
        }

        if (obj instanceof Config) {
            config = (Config) obj;
        }
    }

    public static void save() {
        FileUtility.writeObjectToFile(Config.instance(), fileName);

    }

    private Student[] students = new Student[0];
    private Teacher[] teachers = new Teacher[0];
    private static Config config = null;
    private static boolean loggedIn;

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public static Config instance() {//singleton pattern
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public void appendStudent(Student s) {
        Student[] newStudents = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }

        newStudents[newStudents.length - 1] = s;
        students = newStudents;
    }

    public void appendTeacher(Teacher s) {
        Teacher[] newTeachers = new Teacher[teachers.length + 1];

        for (int i = 0; i < students.length; i++) {
            newTeachers[i] = teachers[i];
        }

        newTeachers[newTeachers.length - 1] = s;
        teachers = newTeachers;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        Config.config = config;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Config.loggedIn = loggedIn;
    }

}
