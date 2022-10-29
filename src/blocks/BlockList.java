package blocks;

import java.util.ArrayList;
import tetris.TetrisBlock;

public class BlockList {
    private static ArrayList<TetrisBlock> blocks = new ArrayList<TetrisBlock>();
    
    public BlockList(int columns) {
        this(columns, 20);
    }
    
    public BlockList(int columns, int cellSize) {
        // list blocks
        blocks.add(new LBlock(columns, cellSize));
        blocks.add(new OppositeLBlock(columns, cellSize));
        blocks.add(new LongLBlock(columns, cellSize));
        blocks.add(new SBlock(columns, cellSize));
        blocks.add(new OppositeSBlock(columns, cellSize));
        blocks.add(new TBlock(columns, cellSize));
        blocks.add(new BoxBlock(columns, cellSize));
    }
    
    public TetrisBlock getRandBlock() {
        System.out.println((int) (Math.random() * blocks.size()));
        return blocks.get((int) (Math.random() * blocks.size()));
    }
    
}
