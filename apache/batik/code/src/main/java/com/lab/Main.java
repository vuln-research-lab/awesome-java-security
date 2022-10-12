package com.lab;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TranscoderException, IOException {
        String svg_path = Main.class.getClassLoader().getResource("").getPath() + "/svg_js.svg";
        try{
            JPEGTranscoder t = new JPEGTranscoder();
            t.addTranscodingHint(JPEGTranscoder.KEY_EXECUTE_ONLOAD, Boolean.TRUE);
            t.addTranscodingHint(JPEGTranscoder.KEY_ALLOWED_SCRIPT_TYPES, "text/ecmascript");

            FileInputStream stream = new FileInputStream(svg_path);
            TranscoderInput input = new TranscoderInput(stream);

            FileOutputStream fos = new FileOutputStream("out.jpg");
            TranscoderOutput output = new TranscoderOutput(fos);

            t.transcode(input, output);

            fos.close();
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}