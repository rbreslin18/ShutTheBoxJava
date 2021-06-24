package Breslin_ShutTheBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Die Class
 *
 * @author Rodney Breslin
 * @version 3/24/2020
 */
public class Die 
{
    int dieRoll;
    public Die(){
        dieRoll = 0;

    }

    public int roll(){
        int diceSides = 6;
        dieRoll = (int) (Math.random() * diceSides) + 1;
        return dieRoll;

    }
    
}
