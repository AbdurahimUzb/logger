package uyishi2;

import java.util.logging.Logger;

public class Test {

    static {
        String file = Test.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }

    static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {

        System.out.println(System.getProperty("java.util.logging.config.file"));

        logger.finest("Finest Massage!");
        logger.finer("Finer Massage!");
        logger.fine("Fine Massage!");
        logger.config("Config Massage!");
        logger.info("Info Massage!");
        logger.warning("Warning Massage!");
        logger.severe("Severe Massage!");

    }
}
