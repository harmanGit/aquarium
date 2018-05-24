package project.pkg6;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

/**
 * This class creates a Fish pane with is allowed to move inside another scene.
 * Also the fishes color is set randomly and also there speed is set randomly.
 * Each fish is its own thread.
 * @author harmanjeetdhillon
 */
public class Fish extends Pane implements Runnable
{
    public Random rand = new Random(); // Random number
    public final double set = rand.nextInt(500); // beginning point value
    // The main x point
    private double x = set; // starting x point is 100
    // The main y point
    private double y = set; // starting y point is 100
    private double dx = 1; // modding variable for the x point
    private double dy = 1; // modding variable for the y point
    // Fish object created with a polygon
    private Polygon rFish = new Polygon(
            x, y,
            x + 50.0, y - 35.0,
            x + 150.0, y + 25.0,
            x + 150.0, y - 25.0,
            x + 50.0, y + 35.0);
    // Eye object created with a Ellipse
    private Ellipse eye = new Ellipse(x + 20, y + 20, 7.0, 10.0);
    // Inner Eye object created with a Ellipse
    private Ellipse innerEye = new Ellipse(x + 13, y + 18, 3.0, 5.0);
    // Fin object created with a Ellipse
    private Ellipse fin = new Ellipse(x + 50, y + 40, 15.0, 10.0);
    private final Timeline animation; // animation timeline

    /**
     * This constructor sets the Fishes color randomly. Then adds it to a pane,and
     * places the fish in a animation Timeline. The KeyFrame speed is also set
     * randomly.
     */
    public Fish()
    {
        // Random rgb value generator for the fish
        int RGBValue1 = rand.nextInt(254); // value 1 
        int RGBValue2 = rand.nextInt(254); // value 2
        int RGBValue3 = rand.nextInt(254); // value 3
        int fishSpeed = rand.nextInt(35); // fish speed
        
        // Random rgb value generator for the fin
        int RGBFin1 = rand.nextInt(254); // value 1 
        int RGBFin2 = rand.nextInt(254); // value 2
        int RGBFin3 = rand.nextInt(254); // value 3
        
        // Giving the Fish polygon color
        Color fishColor = Color.rgb(RGBValue1, RGBValue2, RGBValue3);
        rFish.setFill(fishColor);
        // Seting colors to eye, innerEye, and fin
        eye.setFill(Color.WHITE);
        innerEye.setFill(Color.BLACK);
        //Fin has a random color as well
        fin.setFill((Color.rgb(RGBFin1, RGBFin2, RGBFin3)));
        
        getChildren().add(rFish); // Placing the Fish into this pane
        getChildren().add(eye); // Placing the eye into this pane
        getChildren().add(innerEye); // Placing the inner eye into this pane
        getChildren().add(fin); // Placing the fin into this pane
        

        // Creating a animation for moving the Fish, speed is set randomly
        animation = new Timeline(
                new KeyFrame(Duration.millis(fishSpeed + 1), e -> moveFish()));
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Method allows the fish to move by modifying the main x and y points. Also
     * moves the eyes, inner eye, and fin.
     * But does not allow the fish to leave the tank.
     */
    public void moveFish()
    {
        // Check boundaries for the tank
        if (x < 10 || x > 700)
        {
            dx *= -1; // the move
        }
        if (y < 10 || y > 600)
        {
            dy *= -1; // the move
        }
        // Adjust fish position
        x += dx;
        y += dy;
        // Moving the inner eye with the fish polygon
        innerEye.setCenterX(x + 13);
        innerEye.setCenterY(y + 18);
        // Moving the eye with the fish polygon
        eye.setCenterX(x + 20);
        eye.setCenterY(y + 20);
        //Moving the fin with the fish polygon
        fin.setCenterX(x + 50);
        fin.setCenterY(y + 40);
        // Moving the fish polygon
        rFish.setLayoutX(x - rFish.getLayoutBounds().getMinX());
        rFish.setLayoutY(y - rFish.getLayoutBounds().getMinY());
    }


    /**
     * The threads run method is modified, which simply lets the animation play
     */
    @Override
    public void run()
    {
        try
        {
            // Used to update the UI Thread, Also reduces flickering
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    animation.play(); //Start animation
                }
            });
            // putting the thread to sleep
            Thread.sleep(500);

        } catch (InterruptedException e) // catching the sleep exception
        {
            e.printStackTrace();
        }

    }

}
