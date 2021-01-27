package com.voicerecoder;

import edu.cmu.sphinx.api.*;
import grammars.JSONobject;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;



import java.io.IOException;


public class VoiceRecogniz extends JSONobject {

    private static final Configuration config = new Configuration();


    public static void recod() throws IOException {
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        LiveSpeechRecognizer live = new LiveSpeechRecognizer(config);

        live.startRecognition(true);
        SpeechResult speech;


        while (( speech = live.getResult()) != null) {
            String command = speech.getHypothesis();

            System.out.println(command);

            if (command != null) {
                String newURL = url.replace("love", command);
                System.out.println("New URL is: " + newURL);

                newURLs(newURL);
                start();

            }
            else {
                System.out.println("Say a word: ");

            }
        }
    }

    public static void main(String[] args) throws IOException {
      recod();
    }

}