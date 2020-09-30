package Serialization;

import java.io.File;

public class Helper {
    public static boolean doesFileExist(String path){
        File temp = new File(path);
        return temp.exists();
    }
}
