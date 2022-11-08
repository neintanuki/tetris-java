package tetris;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class TetrisBlock {
    protected int offsetX, offsetY;
    protected boolean[][] shape;
    protected Color color;
    protected boolean[][][] shapes = new boolean[4][][];
    protected int currentRotation = 0;
    
    protected void initVariations() {
        
        for (int i = 0; i < 4; i++) {
            int c = this.getShapeRowLength();
            int r = this.getShapeColumnLength();

            this.shapes[i] = new boolean[r][c];
            
            for (int j= 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    this.shapes[i][j][k] = this.shape[c - k - 1][j];
                }
            }
            
            this.shape = this.shapes[i];
        }

        this.shape = this.shapes[currentRotation];
    }
    
    public void rotate() {
        currentRotation++;
        if (currentRotation >= 4) {
            currentRotation = 0;
        }
        this.shape = this.shapes[currentRotation];
    }
    
    public void undoRotate() {
        currentRotation--;
        if (currentRotation < 0) {
            currentRotation = 3;
        }
        System.err.println(currentRotation);
        this.shape = this.shapes[currentRotation];
    }

    // accessor
    public Color getColor() {
        return color;
    }

    // mutator
    public void setColor(Color color) {
        this.color = color;
    }

    // accessor
    public int getOffsetX() {
        return offsetX;
    }

    // mutator
    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    // accessor
    public int getOffsetY() {
        return offsetY;
    }

    // mutator
    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
    
    // accessor
    public boolean[][] getShape() {
        return shape;
    }
    
    // accessor
    public int getShapeRowLength() {
        return this.shape.length;
    }
    
    // accessor
    public int getShapeColumnLength() {
        return this.shape[0].length;
    }
    
    public void moveBlockDown() {
        this.offsetY++;
    }
    
    public void moveBlockLeft() {
        this.offsetX--;
    }
    
    public void moveBlockRight() {
        this.offsetX++;
    }
     
    

}
