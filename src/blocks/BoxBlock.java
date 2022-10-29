package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class BoxBlock extends TetrisBlock {
    
    public BoxBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public BoxBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, true},
            {true, true}
        };
        
        // this keyword
        this.setColor(Color.YELLOW);
        this.initVariations();
    }
}
