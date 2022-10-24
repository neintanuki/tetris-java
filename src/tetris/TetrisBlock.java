package tetris;

public class TetrisBlock {
    protected int offsetX, offsetY;
    protected boolean[][] shape;

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
