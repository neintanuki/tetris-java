package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class SBlock extends TetrisBlock {
    
    public SBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public SBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {false, true, true},
            {true, true, false}
        };
        
        // this keyword
        this.setColor(Color.RED);
        this.initVariations();
    }
}
