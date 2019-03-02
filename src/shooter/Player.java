package application;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player 
{
	public double x = 500.0;
	public double y = 800.0;
	public double radius = 20;
	public double speed = 0.1;;
	public int rate_of_fire = 1000;
	public int ticks_from_fire = rate_of_fire;
	public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    public boolean can_fire = true;
    public int width = 0;
    public int height = 0;
    public String direction = "NO";
    public Color color = Color.BLUE;
    int level  = 500;
    
    public Player(int width, int height)
    {
    	this.width = width;
    	this.height = height;
    	level = height/2;
    }
    
    public void update_direction()
    {
        String dircode = "";
        
        if(up)dircode = dircode + "1";
        if(!up)dircode = dircode + "0";
        
        if(down)dircode = dircode + "1";
        if(!down)dircode = dircode + "0";
        
        if(left)dircode = dircode + "1";
        if(!left)dircode = dircode + "0";
        
        if(right)dircode = dircode + "1";
        if(!right)dircode = dircode + "0";
        
        switch(dircode)
        {
        case "0000":
        direction = "NO";
        break;
        
        case "0001":
        direction = "RIGHT";
        break;
        
        case "0010":
        direction = "LEFT";
        break;
        
        case "0011":
        direction = "NO";
        break;
        
        case "0100":
        direction = "DOWN";
        break;
        
        case "0101":
        direction = "DOWNRIGHT";
        break;
        
        case "0110":
        direction = "DOWNLEFT";
        break;
        
        case "0111":
        direction = "DOWN";
        break;
        
        case "1000":
        direction = "UP";
        break;
        
        case "1001":
        direction = "UPRIGHT";
        break;
        
        case "1010":
        direction = "UPLEFT";
        break;
        
        case "1011":
        direction = "UP";
        break;
        
        case "1100":
        direction = "NO";
        break;
        
        case "1101":
        direction = "RIGHT";
        break;
        
        case "1110":
        direction = "LEFT";
        break;
        
        case "1111":
        direction = "NO";
        break;
        
        default:
        direction = "NO";
        }
       
    }
    
    public void update_coordinates()
    {
    	switch(direction)
        {
        case "UP":
        	y -= speed;
        	break;
        
        case "DOWN":
            y += speed;
            break;
            
        case "LEFT":
            x -= speed;
            break;
            
        case "RIGHT":
            x += speed;
            break;
            
        case "NO":
            
            break;
        case "UPLEFT":
            x -= speed;
            y -= speed;
            break;
        case "UPRIGHT":
            x += speed;
            y -= speed;
            break;
            
        case "DOWNLEFT":
            x -= speed;
            y += speed;
            break;
            
        case "DOWNRIGHT":
            x += speed;
            y += speed;
            break;
        
        default:
        
        }
    	if(x > this.width)x = (double)this.width;
    	if(x < 0)x = 0.0;
    	if(y > this.height)y = (double)this.height;
    	if(y < 0)y = 0.0;
    }
    
    public void update()
    {
    	update_direction();
    	update_coordinates();
    	ticks_from_fire++;
    	if(ticks_from_fire > rate_of_fire)
    	{
    		can_fire = true;
    		
    	}
    	else
    	{
    		can_fire = false;
    	}
    	
    }
    
    public void draw(GraphicsContext gc)
	{
		gc.setFill(color);
        gc.fillOval(x-radius, y-radius, 2*radius, 2*radius);
        //gc.strokeText(b.speed_x + " " + b.speed_y, 100, 100);
	}

}
