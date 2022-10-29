package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class LBlock extends TetrisBlock {
    
    public LBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public LBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, false},
            {true, false},
            {true, true}
        };
        
        // this keyword
        this.setColor(Color.DARK_GRAY);
        this.initVariations();
    }
}
