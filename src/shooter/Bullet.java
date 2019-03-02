package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet 
{
	public int id = 0;
    public double x = 0.0;
    public double y = 0.0;
    public double radius = 5.0;
    public double speed = 1.0; //pixels per game tick
    public double dx = 1.0;
    public double dy = 1.0;
    public int damage = 100;
    public int life = 3000;
    public Color bullet_color = Color.RED;
    public boolean alive = true;
	
	public Bullet(double x1, double y1, double x2, double y2)
	{
	    this.x = x1;
	    this.y = y1;
	    this.dx = (x2-x1)/Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	    this.dy = (y2-y1)/Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	    
	   
	}
	public Bullet()
	{
	    
	}
	public void update()
	{
		if(alive)
		{
		x += speed*dx;
		y += speed*dy;
		life--;
		if(life < 0)
		{
			alive = false;
		}
		}
	}
	public void draw(GraphicsContext gc)
	{
		if(alive)
		{
		gc.setFill(bullet_color);
        gc.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		}
	}
	public String toString()
	{
		String s = "";
		s = this.x + "   " + this.y;
		return s;
	}

}