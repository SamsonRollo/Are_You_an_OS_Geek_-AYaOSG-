package gen;

import java.util.ArrayList;
import java.util.Random;

public class QuestionGenerator {
    private ArrayList<Question> questions;

    public QuestionGenerator(ArrayList<Question> questions){
        this.questions = questions;
    }

    public Question generate(){
        return questions.get(new Random().nextInt(questions.size()));
    }

    

}
