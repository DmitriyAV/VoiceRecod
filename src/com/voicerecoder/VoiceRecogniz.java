package com.voicerecoder;

import edu.cmu.sphinx.api.*;
import edu.cmu.sphinx.result.WordResult;
import grammars.JSONobject;

import edu.cmu.sphinx.api.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VoiceRecogniz extends JSONobject {

    private static String url = "https://api.unsplash.com/search/photos?page=1&query=love&client_id=pSYNveFhMc6_0fkxhBff_jYb3J9lMatQp76-soivrGA";

    /*public static String newURL = "";
*/
    private static final Configuration config = new Configuration();
  /*  private static LiveSpeechRecognizer live;
    private static SpeechResult speech;
    private static String command = "";
    private static List<String> words;
    private static List<WordResult> results;*/


    public static void recod() throws IOException {
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        config.setGrammarPath("resource:/edu/cmu/sphinx/demo/dialog/");
        config.setSampleRate(8000);

        LiveSpeechRecognizer live = new LiveSpeechRecognizer(config);


        live.startRecognition(true);
        SpeechResult speech;

        while ((speech = live.getResult()) != null) {
            System.out.println("<<<<<< Start talk...");
            String command = speech.getHypothesis();
            String work = null;

            live.stopRecognition();
            System.out.println("<<<<<Talking Done...");
            System.out.println("Input command is: " + command);

            String newURL = url.replace("love", command);
            System.out.println("New URL is: " + newURL);

            newURLs(url);
            start(newURL);


            if (work != null) {
                continue;
            }
            Runtime.getRuntime().exec(work);
        }
    }


/*
    public static void newLink() throws IOException {


        while ((speech = live.getResult()) != null) {

            recod();
            System.out.println(command);


            if (command != null) {
                newURL = url.replace("love", command);
                System.out.println("New URL is: " + newURL);

                newURLs(newURL);
                start();

            } else {
                System.out.println("Say a word: ");

            }
        }
    }*/


    public static void main(String[] args) throws IOException {
        recod();

       /* start(url);*/

    }
}
