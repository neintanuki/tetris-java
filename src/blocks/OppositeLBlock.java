package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class OppositeLBlock extends TetrisBlock {
    
    public OppositeLBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public OppositeLBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {false, true},
            {false, true},
            {true, true}
        };
        
        // this keyword
        this.setColor(Color.BLUE);
        this.initVariations();
    }
}
