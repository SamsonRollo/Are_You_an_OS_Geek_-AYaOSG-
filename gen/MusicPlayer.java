package gen;

public class MusicPlayer implements Runnable{
    private String path;

    public MusicPlayer(){}

    public void setMusicPath(String path){
        this.path = path;
    }

    @Override
    public void run() {

    }
    
}

// import java.applet.AudioClip;
// import java.net.MalformedURLException;

// public class Tunog{
// 	private AudioClip sample;
// 	Tunog(String fname){
// 		try{
// 			sample = java.applet.Applet.newAudioClip(new java.net.URL("file:"+fname));
// 		    }
// 		 catch(MalformedURLException e){
// 		 	e.printStackTrace();
// 			 }
// 		}
// 	public void play(){
// 		sample.stop();
// 		sample.play();
// 		}
// 	public void stop(){
// 		sample.stop();
// 		}
// 	public void loop(){
// 		sample.stop();
// 		sample.loop();
// 		}
// 	}
