import java.io.*;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {

        String s = "E:\\Java_4_Module\\forTest\\src";
        String mkdir = mkdir(s, "readme.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mkdir, true))) {
            for (int i = 0; i < 60; i++) {
                LocalTime time = LocalTime.now();
                writer.write(time + "\n");
                Thread.sleep(1000);
            }
        }


        BufferedReader reader = new BufferedReader(new FileReader(mkdir));
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }


    }

    public static String mkdir(String path, String fileName) throws IOException {
        File file = new File(path, fileName);
        if (!file.exists()) file.createNewFile();
        return file.getPath();
    }
}