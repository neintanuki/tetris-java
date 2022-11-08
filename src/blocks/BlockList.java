package blocks;

import java.util.ArrayList;
import tetris.TetrisBlock;

public class BlockList {
    // static declaration
    private static ArrayList<TetrisBlock> blocks = new ArrayList<TetrisBlock>();
    private static TetrisBlock prevBlock;
    
    public BlockList(int columns) {
        // constructor chaining
        this(columns, 20);
    }
    
    // constructor overloading
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
    
    // accessor
    public TetrisBlock getRandBlock() {
        TetrisBlock newBlock = blocks.get((int) (Math.random() * blocks.size()));

        if (prevBlock != null) {
            while (true) {
                if (newBlock.getClass().equals(prevBlock.getClass())) {
                    newBlock = blocks.get((int) (Math.random() * blocks.size()));
                } else {
                    break;
                }
            }
        }
        
        prevBlock = newBlock;
        
        return newBlock;
    }
    
}
