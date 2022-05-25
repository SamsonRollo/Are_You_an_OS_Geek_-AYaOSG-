package ayaog.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import gen.GameButton;
import gen.ImageLoader;
import gen.Score;

import main.MainClass;
import main.OsirysGame;

public class AYAOG extends OsirysGame implements MouseListener{
    private BufferedImage BG_IMG;
    private Score score;
    private MainClass mainClass;
    private Font font;
    private QuestionType type;
    private boolean start = true;

    public AYAOG(MainClass mainClass, Score score){
        this.mainClass = mainClass;
        this.score = score;
        setCode("ayaog");
        setPreferredSize(new Dimension(700,500));
        setLayout(null);
        setBounds(0,0,700,500);
    }

    public void loadGame(){
        loadElements();
    }

    public void loadElements(){
        ImageLoader il = new ImageLoader(getCode()+"/src/panel.png", "bg");
        BG_IMG = il.getBuffImage();
        il = null;

        font = new Font("sans_serif", Font.BOLD, 20);

        peekBtn = new GameButton(26, 99, 90, 28);
        copyBtn = new GameButton(26, 135, 90, 28);
        saveBtn = new GameButton(26, 205, 90, 28);
        GameButton dropBtn = new GameButton(26, 241, 90, 28);
        GameButton helpBtn = new GameButton(655, 5, 35, 35);
        lockBtn = new GameButton(596, 308, 84, 84);

        setLockEnabled(false);

        autoSetIcons(peekBtn, "peek");
        autoSetIcons(copyBtn, "copy");
        autoSetIcons(saveBtn, "save");
        autoSetIcons(dropBtn, "drop");
        autoSetIcons(helpBtn, "help");
        autoSetIcons(lockBtn, "lockin");
        
        peekBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(btnClickCtr>=1){
                    //peek at the answer but not lock
                }
            }
        });

        copyBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(btnClickCtr>=1){
                    //copy and lock answer
                }
            }
        });

        saveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(btnClickCtr>=1){
                    //show gamecome with be back soon, reminder to be back before quiting the game bundle
                }
            }
        });

        dropBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(btnClickCtr>=1){
                    //show gameover with anti_certificate and exit
                }
            }
        });

        helpBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               generateQuestion();
            }
        });

        lockBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(btnClickCtr>=1){
                    //lock the answer and create drumroll thread and join to main thread
                    //Thread for sound
                    if(answer==selectedChoice){
                        System.out.println("COrrect");
                        //play correct sound
                        //update current winning, and prize pool
                        //show correct panel,
                    //thread for 2.5 sec then generate new question
                    }else{
                        //play wrong sound
                        //show gameOver panel
                    }
                }
            }
        });

        add(peekBtn);
        add(copyBtn);
        add(saveBtn);
        add(dropBtn);
        add(helpBtn);  
        add(lockBtn);     
    }

    public void generateQuestion(){
        if(!start)
            removeChoices();

        start = false;
        setLockEnabled(false);

        Random rand = new Random();
        type = QuestionType.MULTIPLE;

        if((rand.nextInt(100)+1)%5==0)
            type = QuestionType.TRUEFALSE;

        //select from a pool of questions in xlxs

        loadChoicesBtn(type);   
    }

    public void loadChoicesBtn(QuestionType type){
        
        if(type == QuestionType.TRUEFALSE){
            trueBtn = new GameButton(58, 338, 219, 74);
            falseBtn = new GameButton(320, 338, 219, 74);

            autoSetIcons(trueBtn, "truechoice");
            autoSetIcons(falseBtn, "falsechoice");

            trueBtn.addMouseListener(this);
            falseBtn.addMouseListener(this);

            trueBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(btnClickCtr>=1){
                       changeSelected(selectedChoice, trueBtn);
                        //lockansert
                    }
                }
            });

            falseBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(btnClickCtr>=1){
                        changeSelected(selectedChoice, falseBtn);
                    }
                }
            });
            
            getAYAOG().add(trueBtn);
            getAYAOG().add(falseBtn);
        }else{
            int yMul = 49;
            aBtn = new GameButton(17, 305, 553, 41);
            bBtn = new GameButton(17, 305+yMul, 553, 41);
            cBtn = new GameButton(17, 305+yMul*2, 553, 41);
            dBtn = new GameButton(17, 305+yMul*3, 553, 41);

            autoSetIcons(aBtn, "mchoice");
            autoSetIcons(bBtn, "mchoice");
            autoSetIcons(cBtn, "mchoice");
            autoSetIcons(dBtn, "mchoice");

            addBtnChoiceText(aBtn, "HELLO");
            addBtnChoiceText(bBtn, "Hi");
            addBtnChoiceText(cBtn, "Hey");
            addBtnChoiceText(dBtn, "LOOOO");

            aBtn.addMouseListener(this);
            bBtn.addMouseListener(this);
            cBtn.addMouseListener(this);
            dBtn.addMouseListener(this);

            aBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(btnClickCtr>=1){
                       changeSelected(selectedChoice, aBtn);
                    }
                }
            });

            bBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(btnClickCtr>=1){
                       changeSelected(selectedChoice, bBtn);
                    }
                }
            });

            cBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(btnClickCtr>=1){
                        changeSelected(selectedChoice, cBtn);
                    }
                }
            });

            dBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(btnClickCtr>=1){
                        changeSelected(selectedChoice, dBtn);
                        //lockansert
                    }
                }
            });

            
            getAYAOG().add(aBtn);
            getAYAOG().add(bBtn);
            getAYAOG().add(cBtn);
            getAYAOG().add(dBtn);
        }
        getAYAOG().updateUI();
    }
    
    public void removeChoices(){
        if(type==QuestionType.MULTIPLE){
            getAYAOG().remove(aBtn);
            getAYAOG().remove(bBtn);
            getAYAOG().remove(cBtn);
            getAYAOG().remove(dBtn);
        }else{
            getAYAOG().remove(trueBtn);
            getAYAOG().remove(falseBtn);
        }
        selectedChoice = null;
    }

    public void changeSelected(GameButton currentBtn, GameButton newBtn){
        setLockEnabled(true);
        if(currentBtn==newBtn)
            return;
        String newStr = newBtn.getActionCommand().toLowerCase();
        if(currentBtn!=null){
            String curStr = currentBtn.getActionCommand().toLowerCase();
            curStr = curStr.substring(0, curStr.length()-4);
            autoSetIcons(currentBtn, curStr);
            System.out.println(curStr);
        }
        autoSetIcons(newBtn, newStr+"lock");
        System.out.println(newStr);
        this.selectedChoice = newBtn;
        getAYAOG().updateUI();
    }

    public void setLockEnabled(boolean enable){
        this.lockBtn.setEnabled(enable);
    }

    public void addBtnChoiceText(GameButton button, String text){
        button.setText(text);
        button.setHorizontalTextPosition(GameButton.CENTER);
        button.setVerticalTextPosition(GameButton.CENTER);
    }

    public AYAOG getAYAOG(){
        return this;
    }

    public MainClass getMainClass(){
        return this.mainClass;
    }
  
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(BG_IMG, 0, 0, null);

        g.setColor(Color.black);
        g.setFont(font);
        g.drawString(String.valueOf(score.getGameScore()), 61, 43);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        btnClickCtr++;
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {
        btnClickCtr = 0;
    }

    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}

    private GameButton trueBtn, falseBtn, aBtn, bBtn, cBtn, dBtn, peekBtn, copyBtn, saveBtn, lockBtn;
    private GameButton selectedChoice = null;
    private GameButton answer = null;
    private int btnClickCtr = 0;
}
