package application;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Game 
{
	Random r = new Random();
	int counter = 0;
	public Player player;
	public CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();
	public CopyOnWriteArrayList<Bullet> bullets_to_add = new CopyOnWriteArrayList<Bullet>();
	public CopyOnWriteArrayList<Bullet> bullets_to_remove = new CopyOnWriteArrayList<Bullet>();
	public CopyOnWriteArrayList<Bot> bots = new CopyOnWriteArrayList<>();
	public CopyOnWriteArrayList<Bot> bots_to_remove = new CopyOnWriteArrayList<>();
	int time_between_tick_in_millisecons = 1;
	int start_delay_in_milliseconds = 3000;
	int width = 1000;
    int height = 1000;
    boolean game_continue = true;
    public Timer timer;
    public Canvas can1;
    public int lifes = 5;
    public int points = 0;
    Bullet b;
    
    public Game(Canvas can)
    {
    	player = new Player(1000,1000);
    	this.can1 = can;
    	timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() 
        {
        @Override
        public void run() 
        {
        	counter++;
        	if(lifes>0)
        	{
            if(game_continue)
            {
            	bullets.addAll(bullets_to_add);
            	bullets_to_add.clear();
            	bullets.removeAll(bullets_to_remove);
            	bullets_to_remove.clear();
            	bots.removeAll(bots_to_remove);
            	bots_to_remove.clear();
            	for(Bullet b: bullets)
            	{
            		if(!(b==null))
            		{
            		b.update();
            		if(!b.alive)
            		{
            			bullets_to_remove.add(b);
            		}
            		}
            	}
            	
            		
            		player.update();
            	
            	for(Bot p: bots)
            	{
            		
            		p.update(bullets);
            		if(p.win)
            		{
            			lifes--;
            			p.alive = false;
            		}
            		if(p.lost)
            		{
            			points++;
            			p.alive = false;
            		}
            		if(!p.alive)
            		{
            			bots_to_remove.add(p);
            		}
            		
            		
            	}
            	
            	
            	if(counter % 16 == 0)
            	{
            		
            	
            	GraphicsContext gc = can1.getGraphicsContext2D();
            	
            	
            	gc.clearRect(0, 0, width, height);
            	gc.strokeText("Lifes "+ lifes + " Points " + points , 20, 20);
            	for(Bullet b: bullets)
            	{
            		if(!(b==null))
            		{
            		b.draw(gc);
            		}
            		
            	}
            	for(Bot bo: bots)
            	{
            		
            		bo.draw(gc);
            		
            	}
            	
            	
            		player.draw(gc);
            	}
            	
            	if(counter % 3000 == 0)
            	{
            		bots.add(new Bot(width, height));
            	}
            
        }
        }}},start_delay_in_milliseconds, time_between_tick_in_millisecons);
        
    }
    public void reset(Canvas can)
    {
    	player = new Player(1000,1000);
    	timer.cancel();
    	bullets.clear();
    	bullets_to_remove.clear();
    	bullets_to_add.clear();
    	bots.clear();
    	bots_to_remove.clear();
    	this.can1 = can;
    	game_continue = true;
    	points = 0;
    	lifes = 5;
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new TimerTask() 
        {
        @Override
        public void run() 
        {
        	counter++;
        	if(lifes>0)
        	{
            if(game_continue)
            {
            	bullets.addAll(bullets_to_add);
            	bullets_to_add.clear();
            	bullets.removeAll(bullets_to_remove);
            	bullets_to_remove.clear();
            	bots.removeAll(bots_to_remove);
            	bots_to_remove.clear();
            	for(Bullet b: bullets)
            	{
            		if(!(b==null))
            		{
            		b.update();
            		if(!b.alive)
            		{
            			bullets_to_remove.add(b);
            		}
            		}
            	}
            	
            		
            		player.update();
            	
            	for(Bot p: bots)
            	{
            		
            		p.update(bullets);
            		if(p.win)
            		{
            			lifes--;
            			p.alive = false;
            		}
            		if(p.lost)
            		{
            			points++;
            			p.alive = false;
            		}
            		if(!p.alive)
            		{
            			bots_to_remove.add(p);
            		}
            		
            		
            	}
            	
            	
            	if(counter % 16 == 0)
            	{
            		
            	
            	GraphicsContext gc = can1.getGraphicsContext2D();
            	
            	
            	gc.clearRect(0, 0, width, height);
            	gc.strokeText("Lifes "+ lifes + " Points " + points , 20, 20);
            	for(Bullet b: bullets)
            	{
            		if(!(b==null))
            		{
            		b.draw(gc);
            		}
            		
            	}
            	for(Bot bo: bots)
            	{
            		
            		bo.draw(gc);
            		
            	}
            	
            	
            		player.draw(gc);
            	}
            	
            	if(counter % (3000-points*50) == 0)
            	{
            		bots.add(new Bot(width, height));
            	}
            
        }
        }}},start_delay_in_milliseconds, time_between_tick_in_millisecons);
    }
    
}

