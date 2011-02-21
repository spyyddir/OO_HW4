import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Icon;

public abstract class Sprite {

  public enum Direction {
    NONE, NORTH, EAST, SOUTH, WEST
  }

  private int  x;
  private int  y;
  private Direction direction;
  protected boolean isHighlighted = false;

  protected List<Icon> images;
  protected int  current;
  
  MoveBehavior moveBehavior;

  public Sprite(int x, int y) {
    this.x  = x;
    this.y  = y;
    current = 0;
  }
  
  public void setMoveBehavior(MoveBehavior mb) {
	  this.moveBehavior = mb;
  }
  
  public void move(Canvas c) {
	  moveBehavior.move(c, this);
  }

  public void draw(Component c, Graphics g) {
	Icon icon = images.get(current);
    icon.paintIcon(c, g, x, y);
    
    if (isHighlighted) {
        int  height = icon.getIconHeight();
        int  width  = icon.getIconWidth();
    	
    	g.setColor(Color.red);
    	g.draw3DRect(x,y,width,height,true);
    }
  }
  
  public void setHighlight(boolean highlight) {
	  this.isHighlighted = highlight;
  }

  public void highlight(Component c, Graphics g) {
    Icon icon   = images.get(current);
    int  height = icon.getIconHeight();
    int  width  = icon.getIconWidth();

    g.setColor(Color.red);
    g.draw3DRect(x, y, width, height, true);

  }

  public abstract void animate(Canvas c);

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Icon getCurrentImage() {
    return images.get(current);
  }

}
