package project.pkg6;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import static javafx.scene.shape.StrokeType.INSIDE;

/**
 * Main class tests the Fish Class. Also creates a tank for the fish.
 * @author harmanjeetdhillon
 */
public class Tank extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        // Tank Bounds Color
        Color tankBounds = Color.rgb(125,125,123);
        
        // The pane everything gets added to "Main Pane"
        Pane root = new Pane();
        Scene scene = new Scene(root, 860, 680);
        double y = scene.getHeight();
        double x = scene.getWidth();
        
        //Image used as water background
        ImageView iv2 = new ImageView(new Image
        ("https://arlingtonvoice.com/sites/default/files/reports/2017/Feb/06/water-17.jpg"));
        iv2.setTranslateY(0); // Start Y position for the image
        iv2.setPreserveRatio(true);// Keeping image unskewed
        root.getChildren().add(iv2); // Adding to the main pane
        
        //Image used as sandy bottom
        ImageView iv = new ImageView(new Image
        ("http://www.few.vu.nl/~nva800/Multimedia%20Authoring/fish/img/sand.png"));
        iv.setTranslateY(400);// Start Y position for the image
        iv.setFitWidth(860);
        iv.setPreserveRatio(true); // Keeping image unskewed
        root.getChildren().add(iv); // Adding to the main pane
        
        // Tank borders drawn with a polygon
        Polygon tank = new Polygon(0,0,x,0,x,y,0,y);
        tank.setFill(Color.TRANSPARENT); // inside of the Tanks polygon is transparent
        // Inside stroke palced on the borders of the tank, width 10 pt
        tank.setStrokeType(INSIDE);
        tank.setStroke(tankBounds);
        tank.setStrokeWidth(10);
        root.getChildren().add(tank); // Adding to the main pane
        
        // Fish
        Fish f = new Fish(); // creating a new fish
        root.getChildren().add(f); // Fish added to main pane
        
        Fish f2 = new Fish();
        root.getChildren().add(f2);
        
        Fish f3 = new Fish();
        root.getChildren().add(f3);
        
        Fish f4 = new Fish();
        root.getChildren().add(f4);
        
        Fish f5 = new Fish();
        root.getChildren().add(f5);

        Fish f6 = new Fish();
        root.getChildren().add(f6);

        Fish f7 = new Fish();
        root.getChildren().add(f7);

        Fish f8 = new Fish();
        root.getChildren().add(f8);

       
        // Creating a the with a runnable class, then starting the thread
        Thread t1 = new Thread(f);
        t1.start();
        Thread t2 = new Thread(f2);
        t2.start();
        Thread t3 = new Thread(f3);
        t3.start();
        Thread t4 = new Thread(f4);
        t4.start();
        Thread t5 = new Thread(f5);
        t5.start();
        Thread t6 = new Thread(f6);
        t6.start();
        Thread t7 = new Thread(f7);
        t7.start();
        Thread t8 = new Thread(f8);
        t8.start();
        

        //Creating the scene to add to the primaryStage
        primaryStage.setTitle("FISHY BUSINESS");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Method runs launches the primary Stage
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}