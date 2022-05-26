package ayaog.game;

import java.util.ArrayList;
import java.util.Random;

public class Classmate {
    private String answer;
    
    public Classmate(QuestionType type, QuestionManager qMan){ //66 percent or 47 percent, 60 percent to be 66 percent
        selectAnswer(type, qMan);
    }

    private void selectAnswer(QuestionType type, QuestionManager qMan){
        Random rand = new Random();
        int randNum = rand.nextInt(100);
        int bound1 = 7, bound2 = 3, bound3 = 17; //44 percent

        if(randNum%2==0 || randNum%5==0){
            bound2 = 2;
            bound3 = 5;
        }
        randNum = rand.nextInt(100);

        if(randNum%bound1==0
            || randNum%bound2==0
            || randNum%bound3==0)
            selectCorrect(type, qMan);
        else
            selectOther(type, qMan);
    }

    private void selectCorrect(QuestionType type, QuestionManager qMan){
        if(type==QuestionType.TRUEFALSE)
            answer = String.valueOf(qMan.getBooleanAnswer());
        else
            answer = qMan.getStringAnswer();
    }

    private void selectOther(QuestionType type, QuestionManager qMan){
        if(type==QuestionType.TRUEFALSE)
            answer = String.valueOf(!qMan.getBooleanAnswer());
        else{
            ArrayList<String> otherChoices = new ArrayList<>();
            for(String s : qMan.getChoices())
                if(!s.equalsIgnoreCase(qMan.getStringAnswer()))
                    otherChoices.add(s);

            answer = otherChoices.get(new Random().nextInt(otherChoices.size()));
        }
    }

    public String getAnswer(){
        return this.answer;
    }
}
