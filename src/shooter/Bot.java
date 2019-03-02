package application;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bot 
{
public static Random r = new Random();
public Color color = Color.GREEN;
public double x;
public double y = 0.0;
public int radius;
public double speed;
public double dx;
public double dy;
public boolean alive = true;
public boolean win = false;
public boolean lost = false;
public int width = 0;
public int height = 0;
public Bot(int width, int height)
{
	this.width = width;
	this.height = height;
	x = (double)r.nextInt(width);
	int x1 = r.nextInt(width);
	double gipot = Math.sqrt(height*height + (x1-x)*(x1-x));
	dy = height/gipot;
	dx = (x1-x)/gipot;
	speed = r.nextDouble()*0.4+0.1;
	radius = r.nextInt(40) + 20;
	int color1 = 0;
	color1 = r.nextInt(5);
	 switch(color1)
        {
        case 0:
        color = Color.RED;
        break;
        
        case 1:
	        color = Color.BROWN;
	        break;
	        
        case 2:
	        color = Color.PURPLE;
	        break;
	        
        case 3:
	        color = Color.GREEN;
	        break;
	        
        case 4:
	        color = Color.GOLD;
	        break;
        }
	
}

public void update(CopyOnWriteArrayList<Bullet> bullets)
{
	update_hp(bullets);
	if(alive)
	{
	x += speed*dx;
	y += speed*dy;
	if(y>height)
	{
		win = true;
		
	}
	}
	
}

public void draw(GraphicsContext gc)
{
	if(alive)
	{
	gc.setFill(color);
    gc.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
    
}
public void update_hp(CopyOnWriteArrayList<Bullet> bullets)
{
	for(Bullet b: bullets)
	{
		
		if(Math.sqrt((b.x-x)*(b.x-x)+(b.y-y)*(b.y-y))<(b.radius+this.radius))
		{
			lost = true;
			this.alive = false;
			
			//b.alive = false;
		}
		
	}
}
}
