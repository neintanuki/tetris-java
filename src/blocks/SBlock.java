package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class SBlock extends TetrisBlock {
    
    public SBlock(int columns) {
        this(columns, 20);
    }
    
    public SBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {false, true, true},
            {true, true, false}
        };
        
        this.setColor(Color.RED);
        this.initVariations();
    }
}
