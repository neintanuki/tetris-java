package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class OppositeLBlock extends TetrisBlock {
    
    public OppositeLBlock(int columns) {
        this(columns, 20);
    }
    
    public OppositeLBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {false, true},
            {false, true},
            {true, true}
        };
        
        this.setColor(Color.BLUE);
        this.initVariations();
    }
}
