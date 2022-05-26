package ayaog.game;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

import gen.GameButton;
import gen.MenuPanel;
import gen.QuestionCategory;

public class CategoryPanel extends MenuPanel implements ActionListener{
    private AYAOG ayaog;

    public CategoryPanel(AYAOG ayaog){
        this.ayaog = ayaog;
        this.path = "ayaog/src/selectionPanel.png";
        this.srcPath = "ayaog/";
        loadElements("select");
        setBounds(
            ayaog.getWidth()/2-277,
            ayaog.getHeight()/2-175,
            553,
            350
        );

        GameButton overview = new GameButton(this.getWidth()/2-111, 57, 222, 60);
        GameButton pManage = new GameButton(this.getWidth()/2-230, 143, 222, 60);
        GameButton mManage = new GameButton(this.getWidth()/2+8, 143, 222, 60);
        GameButton sManage = new GameButton(this.getWidth()/2-230, 231, 222, 60);
        GameButton secAndPro = new GameButton(this.getWidth()/2+8, 231, 222, 60);

        autoSetIcons(overview, "overview");
        autoSetIcons(pManage, "processman");
        autoSetIcons(mManage, "memoryman");
        autoSetIcons(sManage, "storageman");
        autoSetIcons(secAndPro, "secprotect");

        overview.addActionListener(this);
        pManage.addActionListener(this);
        mManage.addActionListener(this);
        sManage.addActionListener(this);
        secAndPro.addActionListener(this);

        add(overview);
        add(pManage);
        add(mManage);
        add(sManage);
        add(secAndPro);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if qManager question are empty report an error
        if(ayaog.getQuestionManager().getQuestionGenerator().isQuestionsNull()){
            System.out.println("No questions availabel");
            return;
        }

        QuestionCategory categ;
        if(e.getActionCommand().equals("PMANAGE"))
            categ = QuestionCategory.PROCESS_MANAGEMENT;
        else if(e.getActionCommand().equals("MMANAGE"))
            categ = QuestionCategory.MEMORY_MANAGEMENT;
        else if(e.getActionCommand().equals("SMANAGE"))
            categ = QuestionCategory.STORAGE_MANAGEMENT;
        else if(e.getActionCommand().equals("SECANDPRO"))
            categ = QuestionCategory.SECURITY_AND_PROTECTION;
        else
            categ = QuestionCategory.OVERVIEW;

        Random rand = new Random();
        QuestionType type = QuestionType.MULTIPLE;

        if((rand.nextInt(100)+1)%5==0)
            type = QuestionType.TRUEFALSE;
        
        ayaog.getQuestionManager().formulateQuestion(categ, type);
        ayaog.remove(getPanel());
        ayaog.setAllBtnEnable(true);
        ayaog.loadGameScreen(type);
        ayaog.updateUI();
    }
    
}
