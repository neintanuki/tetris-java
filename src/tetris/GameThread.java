package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread {
    private GameArea ga;
    private GameFrame gf;
    
    public GameThread(GameArea ga, GameFrame gf) {
        this.ga = ga;
        this.gf = gf;
    }
    
    @Override
    public void run() {
        while (true) {
            ga.setRandBlock();
            
            while (ga.moveBlockDown()) {
                int newSpeed = gf.getSpeed() - (gf.getLevel() * 100);
                if (newSpeed > 100) {
                    gf.setSpeed(newSpeed);
                } else {
                    gf.setSpeed(100);
                }
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ga.isOutOfBounds()) {
                gf.dispose();
                new GameOver().setVisible(true);
                break;
            }
            
            ga.moveToBackground();
            ga.clearLines();
        }
    }
    
}
