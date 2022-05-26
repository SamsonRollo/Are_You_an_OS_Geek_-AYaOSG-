package ayaog.game;

import gen.GameButton;
import gen.MenuPanel;

public class CertificatePanel extends MenuPanel{
    private AYAOG ayaog;

    public CertificatePanel(AYAOG ayaog, boolean win){
        this.ayaog = ayaog;
        this.path = "ayaog/src/anti_certificate.png";
        if(win)
            this.path = "ayaog/src/certificate.png";
        this.srcPath = "ayaog/";
        loadElements("select");
        setBounds(
            ayaog.getWidth()/2-219,
            ayaog.getHeight()/2-134,
            439,
            269
        );
    }
    
}
