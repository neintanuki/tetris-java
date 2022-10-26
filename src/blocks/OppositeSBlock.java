package blocks;

import java.awt.Color;
import tetris.TetrisBlock;

public class OppositeSBlock extends TetrisBlock {
    
    public OppositeSBlock(int columns) {
        this(columns, 20);
    }
    
    public OppositeSBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, true, false},
            {false, true, true}
        };
        
        this.setColor(Color.GREEN);
        this.initVariations();
    }
}
