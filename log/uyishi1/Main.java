package uyishi1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class Main {

    static String name = "java.util.logging.config.file";
    static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        String file = Objects.requireNonNull(Main.class.getClassLoader().getResource("logging.properties")).getFile();
        System.setProperty(name, file);
    }

    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty(name));

        String pattern = "E:\\Java_4_Module\\forTest\\log\\uyishi1\\file.txt";
        FileHandler handler = new FileHandler(pattern, true);
        handler.setLevel(Level.WARNING);
        handler.setFormatter(new SimpleFormatter());

        logger.addHandler(handler);

        logger.finest("Finest Massage!");
        logger.finer("Finer Massage!");
        logger.fine("Fine Massage!");
        logger.config("Config Massage!");
        logger.info("Info Massage!");
        logger.warning("Warning Massage!");
        logger.severe("Severe Massage!");

        try (BufferedReader reader = new BufferedReader(new FileReader(pattern))) {
            while (reader.ready()) {
                System.out.println("\033[1;92m" + reader.readLine());
            }
        }

    }
}