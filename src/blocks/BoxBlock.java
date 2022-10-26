package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class BoxBlock extends TetrisBlock {
    
    public BoxBlock(int columns) {
        this(columns, 20);
    }
    
    public BoxBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, true},
            {true, true}
        };
        
        this.setColor(Color.YELLOW);
        this.initVariations();
    }
}
