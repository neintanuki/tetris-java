package blocks;

import tetris.TetrisBlock;

public class LBlock extends TetrisBlock {
    
    public LBlock(int columns) {
        this(columns, 20);
    }
    
    public LBlock(int columns, int cellSize) {
        this.shape = new boolean[][] {
            {true, false},
            {true, false},
            {true, true}
        };
        
        this.offsetX =  (int) (Math.random() * columns);
        this.offsetY = this.getShapeRowLength() * -1;
    }
}
