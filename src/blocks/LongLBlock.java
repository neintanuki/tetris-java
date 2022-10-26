package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class LongLBlock extends TetrisBlock {
    
    public LongLBlock(int columns) {
        this(columns, 20);
    }
    
    public LongLBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, true, true, true}
        };
        
        this.setColor(Color.CYAN);
        this.initVariations();
    }
}
