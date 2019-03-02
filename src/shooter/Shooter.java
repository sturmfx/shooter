/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooter;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class Shooter extends Application {
application.Game g;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			HBox root = new HBox();
			VBox labels = new VBox();
			Canvas can = new Canvas(1000,1000);
			g = new application.Game(can);
			Button button = new Button("New Game");
			button.setPrefSize(200.0, 100.0);
			button.setOnAction(new EventHandler<ActionEvent>() 
			{
			    @Override public void handle(ActionEvent e) 
			    {
			        labels.getChildren().add(new Label("Points: " + g.points + " | Lifes: " + g.lifes));
			        g.reset(can);
			    }
			});
			
			
			
			
			labels.getChildren().add(button);
			root.getChildren().add(can);
			root.getChildren().add(labels);
			Scene scene = new Scene(root,1200,1000);
			
			scene.setOnKeyPressed
	        (
	            new EventHandler<KeyEvent>()
	            {
	                @Override
	                public void handle(KeyEvent e)
	                {
	                   if(KeyCode.A == e.getCode())
	                   {
	                       g.player.left = true;
	                       e.consume();
	                   }
	                   if(KeyCode.D == e.getCode())
	                   {
	                	   g.player.right = true;
	                       e.consume();
	                   }
	                   if(KeyCode.W == e.getCode())
	                   {
	                       g.player.up = true;
	                       e.consume();
	                   }
	                   if(KeyCode.S == e.getCode())
	                   {
	                	   g.player.down = true;
	                       e.consume();
	                   }
	                   e.consume();
	                }
	            }
	        );
	        scene.setOnKeyReleased
	        (
	            new EventHandler<KeyEvent>()
	            {
	                @Override
	                public void handle(KeyEvent e)
	                {
	                   if(KeyCode.A == e.getCode())
	                   {
	                	   g.player.left = false;
	                       e.consume();
	                   }
	                   if(KeyCode.D == e.getCode())
	                   {
	                	   g.player.right = false;
	                       e.consume();
	                   }
	                   if(KeyCode.W == e.getCode())
	                   {
	                	   g.player.up = false;
	                       e.consume();
	                   }
	                   if(KeyCode.S == e.getCode())
	                   {
	                	   g.player.down = false;
	                       e.consume();
	                   }
	                   e.consume();
	                }
	            }
	        );
	        scene.setOnMousePressed(new EventHandler<MouseEvent>() 
	        {
	            public void handle(MouseEvent me) 
	            {
	            	
	            		if(g.player.can_fire)
	            		{
	            		g.player.ticks_from_fire = 0;
	            		application.Bullet bullet = new application.Bullet(g.player.x, g.player.y,me.getSceneX(),me.getSceneY());
	            		
	            		System.out.println(bullet);
	            		g.bullets_to_add.add(bullet);
	            		me.consume();
	            		}
	            		else
	            		{
	            			me.consume();
	            		}
	            	
	              
	            }
	        });
	        /*scene.setOnMousePressed(new EventHandler<MouseEvent>() 
	        {
	            public void handle(MouseEvent me) 
	            {
	            	if(g.player.can_fire)
	            	{
	            		g.player.ticks_from_fire = 0;
	            		g.b = new Bullet(g.player.x, g.player.y,me.getSceneX(),me.getSceneY());
	            		System.out.println(g.b.toString());
	            		g.bullets_to_add.add(g.b);
	            		me.consume();
	            	}
	            	else
	            	{
	            		  me.consume();
	            	}
	              
	            }
	        });*/
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}