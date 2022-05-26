package gen;

import java.util.ArrayList;
import java.util.Random;

public class QuestionGenerator {
    private ArrayList<Question> questions;

    public QuestionGenerator(ArrayList<Question> questions){
        this.questions = questions;
    }

    public Question generate(){
        Question q;
        do{
            q =  questions.get(new Random().nextInt(questions.size()));
        }while(q.isTaken() || q.getAnswer()==null);

        return q;
    }

    public Question generate(QuestionCategory categ){ //make throwable
        ArrayList<Question> categQuestions = new ArrayList<Question>();

        for(Question q : questions){
            if(q.getCategory()==categ && !q.isTaken() && q.getAnswer()!=null)
                categQuestions.add(q);

            }
        return categQuestions.get(new Random().nextInt(categQuestions.size()));
    }

    public void updateQuestions(ArrayList<Question> questions){
        this.questions = questions;
    }

    public boolean isQuestionsNull(){
        if(questions==null)
            return true;
        if(questions.size()==0)
            return true;
        return false;
    }

}
