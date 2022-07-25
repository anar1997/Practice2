/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author anarq
 */
public class FileUtility {

    public static boolean writeObjectToFile(Serializable object, String name) throws RuntimeException {
        try (FileOutputStream fout = new FileOutputStream(name);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(object);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Object readFileDeserialize(String name) throws Exception {
        Object obj = null;

        FileInputStream fi = new FileInputStream(name);
        try (ObjectInputStream ni = new ObjectInputStream(fi)) {
            obj = ni.readObject();
        } finally {
        }
        return obj;
    }
}
