package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class LongLBlock extends TetrisBlock {
    
    public LongLBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public LongLBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, true, true, true}
        };
        
        // this keyword
        this.setColor(Color.CYAN);
        this.initVariations();
    }
    
    // method overloading
    @Override
    public void rotate() {
        super.rotate();
        
        if (this.getShapeColumnLength() == 1) {
            this.setOffsetX(this.getOffsetX() + 1);
            this.setOffsetY(this.getOffsetY() - 1);
        } else {
            this.setOffsetX(this.getOffsetX() - 1);
            this.setOffsetY(this.getOffsetY() + 1);            
        }
    }
    
    // method overloading
    @Override
    public void undoRotate() {
        super.rotate();
        
        if (this.getShapeColumnLength() == 1) {
            this.setOffsetX(this.getOffsetX() - 1);
            this.setOffsetY(this.getOffsetY() + 1);
        } else {
            this.setOffsetX(this.getOffsetX() + 1);
            this.setOffsetY(this.getOffsetY() - 1);            
        }        
    }
}
