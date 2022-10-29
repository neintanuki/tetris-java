package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class TBlock extends TetrisBlock {
    
    public TBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public TBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {false, true, false},
            {true, true, true}
        };
        
        // this keyword
        this.setColor(Color.ORANGE);
        this.initVariations();
    }
}
