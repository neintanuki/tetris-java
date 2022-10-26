package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class TBlock extends TetrisBlock {
    
    public TBlock(int columns) {
        this(columns, 20);
    }
    
    public TBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {false, true, false},
            {true, true, true}
        };
        
        this.setColor(Color.ORANGE);
        this.initVariations();
    }
}
