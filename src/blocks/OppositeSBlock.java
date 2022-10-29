package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class OppositeSBlock extends TetrisBlock {
    
    public OppositeSBlock(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
    public OppositeSBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, true, false},
            {false, true, true}
        };
        
        // this keyword
        this.setColor(Color.GREEN);
        this.initVariations();
    }
}
