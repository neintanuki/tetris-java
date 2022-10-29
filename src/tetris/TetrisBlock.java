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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
    
    public boolean[][] getShape() {
        return shape;
    }
    
    public int getShapeRowLength() {
        return this.shape.length;
    }
    
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
