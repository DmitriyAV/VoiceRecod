/*
package main;

import com.voicerecoder.VoiceRecogniz;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main extends VoiceRecogniz {
    private static Main instance;

    private Main() throws IOException {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        LiveSpeechRecognizer live = new LiveSpeechRecognizer(config);

        live.startRecognition(true);
        SpeechResult speech = live.getResult();
        command = speech.getHypothesis();

    }
    public static synchronized Main getInstance() throws IOException, ParseException {
        if (instance==null){
            instance = new Main();
            getNewURL();
            getJsonStringFromFile();
            getValuesForGivenKey();
        }
        return instance;
    }
}
*/
