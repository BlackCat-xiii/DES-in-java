package swe314des;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class IO {

    private static String[] filenames = {
            "kp1.txt", "keys.txt", "c.txt", "d.txt",
            "ip.txt", "fp.txt", "l.txt", "r.txt", "ep.txt", "xored.txt", "fxored.txt", "f.txt",
            "s0.txt", "s1.txt", "s2.txt", "s3.txt", "s4.txt", "s5.txt", "s6.txt", "s7.txt"
    };

    private static HashMap<String, BufferedWriter> bufferedWriters;
    private static HashMap<String, File> files;


    private static File wParentDir;


    private static void init() {
        wParentDir = new File("results");
        wParentDir.mkdir();

        BufferedWriter bw;
        File file;

        bufferedWriters = new HashMap<>();
        files = new HashMap<>();
        try {
            for (String fn : filenames) {
                file = new File(wParentDir, fn);
                files.put(fn, file);
                bufferedWriters.put(fn,new BufferedWriter(new FileWriter(file)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void write(BufferedWriter bw, String str) {
        try {
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write (String fname, String str){
        write(bufferedWriters.get(fname), str);
    }

    static {
        init();
    }
}
