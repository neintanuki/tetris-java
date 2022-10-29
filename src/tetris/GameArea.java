package tetris;

import blocks.BlockList;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameArea extends javax.swing.JPanel {
    private int rows, columns, cellSize;
    private BlockList blockList;
    private TetrisBlock block;
    private Color[][] background;
    private GameFrame gf;

    public GameArea(JPanel placeholder, GameFrame gf) {
        // constructor chaining
        this(placeholder, 20, gf);
    }
    
    // constructor overloading
    public GameArea(JPanel placeholder, int cellSize, GameFrame gf) {
        // initialize properties
        placeholder.setVisible(false);
        
        // this keyword
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        this.setBounds(placeholder.getBounds());
        
        this.gf = gf;
        this.cellSize = cellSize;
        this.rows = this.getHeight() / cellSize;
        this.columns = this.getWidth() / cellSize;
        this.blockList = new BlockList(this.columns, this.cellSize);
        
        this.background = new Color[this.rows][this.columns];
    }
    
    // controls
    public boolean moveBlockDown() {
           if (!this.isCollidingBottomEdge()) {
               this.block.moveBlockDown();
               repaint();
               return true;
           }

           return false;
    }
    
    public boolean moveBlockLeft() {
        if (this.block == null) return false;
        if (!this.isCollidingLeftEdge() && !this.isCollidingBottomEdge()) {
            this.block.moveBlockLeft();
            repaint();
            return true;
        }
        
        return false;
    }
    
    public boolean moveBlockRight() {
        if (this.block == null) return false;
        if (!this.isCollidingRightEdge() && !this.isCollidingBottomEdge()) {
            this.block.moveBlockRight();
            repaint();
            return true;
        }
        
        return false;
    }
    
    public void dropBlock() {
        if (this.block == null) return;
        while (!this.isCollidingBottomEdge()) {
            this.moveBlockDown();
        }
        
        repaint();
    }
    
    public void rotateBlock() {
        if (this.block == null) return;

        this.block.rotate();
        if (this.block.getOffsetX() < 0) block.setOffsetX(0);
        if (this.block.getOffsetX() + block.getShapeColumnLength() >= this.columns) block.setOffsetX(this.columns - block.getShapeColumnLength());
        if (this.block.getOffsetY() + block.getShapeRowLength() >= this.rows) block.setOffsetY(this.rows - block.getShapeRowLength());

        repaint();
    }
    
    // collision detection
    private boolean isCollidingRightEdge() {
        if ((this.block.getOffsetX() + this.block.getShapeColumnLength()) == this.columns) return  true;
        
        boolean[][] shape = this.block.getShape();
        for (int i = 0; i < this.block.getShapeRowLength(); i++) {
            for (int j = this.block.getShapeColumnLength() - 1; j >= 0; j--) {
                if (shape[i][j]) {
                    int x = (j + this.block.getOffsetX()) + 1;
                    int y = i + this.block.getOffsetY();
                    if (y < 0) break;
                    if (background[y][x] != null) {
                        return true;
                    }
                    break;
                }
            }
        }
        
        return false;
    }
    
    private boolean isCollidingLeftEdge() {
        if (this.block.getOffsetX() == 0) return true;
        
        boolean[][] shape = this.block.getShape();
        for (int i = 0; i < this.block.getShapeRowLength(); i++) {
            for (int j = 0; j < this.block.getShapeColumnLength(); j++) {
                if (shape[i][j]) {
                    int x = (j + this.block.getOffsetX()) - 1;
                    int y = i + this.block.getOffsetY();
                    if (y < 0) break;
                    if (background[y][x] != null) {
                        return true;
                    }
                    break;
                }
            }
        }
        
        return false;
    }
    
    private boolean isCollidingBottomEdge() {
        if (this.block.getOffsetY() + this.block.getShapeRowLength() == this.rows) return true;
        
        boolean[][] shape = this.block.getShape();
        for (int i = 0; i < this.block.getShapeColumnLength(); i++) {
            for (int j = this.block.getShapeRowLength() - 1; j >= 0; j--) {
                if (shape[j][i]) {
                    int x = i + this.block.getOffsetX();
                    int y = (j + this.block.getOffsetY()) + 1;
                    if (y < 0) break;
                    if (background[y][x] != null) {
                        return true;
                    }
                    break;
                }
            }
        }
        
        return false;
    }
    
    public boolean isOutOfBounds() {
        if (this.block.getOffsetY() < 0) {
            this.block = null;
            return true;
        }
        
        return false;
    }
    
    public void clearLines() {
        boolean isLineFilled;
        
        for (int i = this.rows - 1; i >= 0; i--) {
            isLineFilled = true;
            for (int j = 0; j < this.columns; j++) {
                if (background[i][j] == null) {
                    isLineFilled = false;
                    break;
                }
            }

            if (isLineFilled) {
                this.clearLine(i);
                this.shiftDown(i);
                this.clearLine(0);
                i++;
                gf.incLines();
                gf.incScore();
                gf.setLevel(gf.getLines() / 10);
                repaint();
            }
        }
    }
    
    private void clearLine(int row) {
        for (int i = 0; i < this.columns; i++) {
            background[row][i] = null;
        }
    }
    
    private void shiftDown(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 0; j < this.columns; j++) {
                background[i][j] = background[i - 1][j];
            }
        }
    }
    
    // setter
    public void setRandBlock() {
        this.block = this.blockList.getRandBlock();
        this.block.setOffsetX((int) (columns / 2));
        this.block.setOffsetY(-this.block.getShapeRowLength());
    }
    
    private void drawBackground(Graphics g) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                Color color = background[i][j];
                
                if (color != null) {
                    drawGridSquare(g, j, i, color);
                }
            }
        }
    }
    
    public void moveToBackground() {
        int rows = this.block.getShapeRowLength();
        int columns = this.block.getShapeColumnLength();
    
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if (this.block.getShape()[i][j]) {
                    background[i + this.block.getOffsetY()][j + this.block.getOffsetX()] = this.block.getColor();
                }
            }
        }
        
        repaint();
    }
    
    private void drawBlock(Graphics g) {
        if (this.block == null) return;
        int x = block.getOffsetX();
        int y = block.getOffsetY();
        
        for (int i = 0; i < block.getShapeRowLength(); i++) {
            for (int j = 0; j < block.getShapeColumnLength(); j++) {
                if (block.getShape()[i][j]) {
                    drawGridSquare(g, x + j, y + i, this.block.getColor());
                }
            }
        }
    }
    
    private void drawGridSquare(Graphics g, int x, int y, Color color) {
        
        g.setColor(color);
        g.fillRoundRect(x * cellSize, y * cellSize, cellSize, cellSize, 5, 5);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x * cellSize, y * cellSize, cellSize, cellSize, 5, 5);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
        
        drawBackground(g);
        drawBlock(g);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
