import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Shut the Box
 *
 * @author Rodney Breslin
 * @version 3/25/2020
 */
public class GameLogic extends Application
{
    //Declare Global Variables
    int sum = 0;
    int roll1 = 0;
    int roll2 = 0;
    int total = 0;
    int gameEnd = 0;
    int finalScore = 45;
    private Label myLabel = new Label("0");
    private Label dieLabel1 = new Label();
    private Label dieLabel2 = new Label();
    Label rollCount = new Label();
    private ImageView die1 = new ImageView();
    private ImageView die2 = new ImageView();
    private boolean r1IsFlipped = false;
    private boolean r2IsFlipped = false;
    @Override
    public void start (Stage primaryStage)
    {
        
        //Create two new Die objects
        Die dice1 = new Die();
        Die dice2 = new Die();
        //Create BorderPane
        BorderPane pane = new BorderPane();
        //Create seperate panes for each "Tile"
        Pane stackPane = new StackPane();
        Pane stackPane2 = new StackPane();
        Pane stackPane3 = new StackPane();
        Pane stackPane4 = new StackPane();
        Pane stackPane5 = new StackPane();
        Pane stackPane6 = new StackPane();
        Pane stackPane7 = new StackPane();
        Pane stackPane8 = new StackPane();
        Pane stackPane9 = new StackPane();
        //Create a GridPane for Tiles
        GridPane gPane = new GridPane();
        HBox hPane = new HBox(20);
        //Create 9 Rectangles to represent tiles
        Rectangle r1 = new Rectangle(100, 100, 60, 180);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.ORANGE);
        r1.setArcWidth(15);
        r1.setArcHeight(25);
        Label label = new Label("1");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r2 = new Rectangle(100, 100, 60, 180);
        r2.setStroke(Color.BLACK);
        r2.setFill(Color.ORANGE);
        r2.setArcWidth(15);
        r2.setArcHeight(25);
        Label label2 = new Label("2");
        label2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r3 = new Rectangle(100, 100, 60, 180);
        r3.setStroke(Color.BLACK);
        r3.setFill(Color.ORANGE);
        r3.setArcWidth(15);
        r3.setArcHeight(25);
        Label label3 = new Label("3");
        label3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r4 = new Rectangle(100, 100, 60, 180);
        r4.setStroke(Color.BLACK);
        r4.setFill(Color.ORANGE);
        r4.setArcWidth(15);
        r4.setArcHeight(25);
        Label label4 = new Label("4");
        label4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r5 = new Rectangle(100, 100, 60, 180);
        r5.setStroke(Color.BLACK);
        r5.setFill(Color.ORANGE);
        r5.setArcWidth(15);
        r5.setArcHeight(25);
        Label label5 = new Label("5");
        label5.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r6 = new Rectangle(100, 100, 60, 180);
        r6.setStroke(Color.BLACK);
        r6.setFill(Color.ORANGE);
        r6.setArcWidth(15);
        r6.setArcHeight(25);
        Label label6 = new Label("6");
        label6.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r7 = new Rectangle(100, 100, 60, 180);
        r7.setStroke(Color.BLACK);
        r7.setFill(Color.ORANGE);
        r7.setArcWidth(15);
        r7.setArcHeight(25);
        Label label7 = new Label("7");
        label7.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r8 = new Rectangle(100, 100, 60, 180);
        r8.setStroke(Color.BLACK);
        r8.setFill(Color.ORANGE);
        r8.setArcWidth(15);
        r8.setArcHeight(25);
        Label label8 = new Label("8");
        label8.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));

        Rectangle r9 = new Rectangle(100, 100, 60, 180);
        r9.setStroke(Color.BLACK);
        r9.setFill(Color.ORANGE);
        r9.setArcWidth(15);
        r9.setArcHeight(25);
        Label label9 = new Label("9");
        label9.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
        //Create a check button 
        Button btCheck = new Button("Check");
        //Create a roll button
        Button btRoll = new Button("Roll");
        gPane.getChildren().remove(dieLabel1);
        r9.setStroke(Color.BLACK);

        //Set the initial position for the die
        die1.setImage(new Image("img/die1.png"));
        dieLabel1.setGraphic(die1);
        gPane.add(dieLabel1, 3, 7);

        die2.setImage(new Image("img/die2.png"));
        dieLabel2.setGraphic(die2);
        gPane.add(dieLabel2, 4, 7);

        
        //Event Handlers
        btRoll.setOnAction(e -> {

                //ROll dice
                roll1 = dice1.roll();
                roll2 = dice2.roll();
                total = roll1 + roll2;

        
                //Create label to tell user what they rolled
                myLabel.setText(Integer.toString(total));
                gPane.add(myLabel, 3, 8);
                myLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
                //Each time bt.Roll is pressed, change the image of the dice
                die1.setImage(new Image("img/die"+roll1 +".png"));
                dieLabel1.setGraphic(die1);
                gPane.add(dieLabel1, 3, 7);

                die2.setImage(new Image("img/die"+roll2 +".png"));
                dieLabel2.setGraphic(die2);
                gPane.add(dieLabel2, 4, 7);

            });

        
        r1.setOnMousePressed(e -> {
                //Add one to the global variable sum, which represents a 1 for tile 1
                sum = sum + 1;
                stackPane.getChildren().remove(label);
                gameEnd += 1;
                r1.setMouseTransparent(true);
                finalScore -= 1;
                r1IsFlipped = true;
            });
        r2.setOnMousePressed(e -> {
                sum = sum + 2;
                stackPane2.getChildren().remove(label2);
                gameEnd += 1;
                r2.setMouseTransparent(true);
                finalScore -=2;
                r2IsFlipped = true;
            });
        r3.setOnMousePressed(e -> {
                sum = sum + 3;
                stackPane3.getChildren().remove(label3);
                gameEnd += 1;
                r3.setMouseTransparent(true);
                finalScore -= 3;
            });

        r4.setOnMousePressed(e -> {
                sum = sum + 4;
                gameEnd += 1;
                stackPane4.getChildren().remove(label4);
                r4.setMouseTransparent(true);
                finalScore -= 4;

            });

        r5.setOnMousePressed(e -> {
                sum = sum + 5;
                stackPane5.getChildren().remove(label5);
                gameEnd += 1;
                r5.setMouseTransparent(true);
                finalScore -=5;
            });
        r6.setOnMousePressed(e -> {
                sum = sum + 6;
                stackPane6.getChildren().remove(label6);
                gameEnd += 1;
                r6.setMouseTransparent(true);
                finalScore-=6;
            });
        r7.setOnMousePressed(e -> {
                sum = sum + 7;
                stackPane7.getChildren().remove(label7);
                gameEnd += 1;
                r7.setMouseTransparent(true);
                finalScore-=7;
            });
        r8.setOnMousePressed(e -> {
                sum = sum + 8;
                stackPane8.getChildren().remove(label8);
                gameEnd += 1;
                r8.setMouseTransparent(true);
                finalScore-=8;
            });
        r9.setOnMousePressed(e -> {
                sum = sum + 9;
                stackPane9.getChildren().remove(label9);
                gameEnd += 1;
                r9.setMouseTransparent(true);
                finalScore-=9;
            });

        btCheck.setOnAction(e -> {

        
                if(total == sum){
                    sum = 0;
                    myLabel.setText("Valid Move");
                    myLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
                    gPane.add(myLabel, 3, 8);
                    sum = 0;
                }

                else if(gameEnd >= 9){
                    HBox hBox2 = new HBox(20);
                    Label gameEnd = new Label("Game Over, You Won");
                    gameEnd.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
                    hBox2.getChildren().add(gameEnd);

                    pane.setRight(hBox2);
                }
                else if(gameEnd == 8 && total != sum){
                    HBox hBox3 = new HBox(20);
                    Label gameEnd2 = new Label("Game Over, Your score was: "+ finalScore);
                    gameEnd2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
                    hBox3.getChildren().add(gameEnd2);
                    pane.setRight(hBox3);

       
                }

                else{
                    sum = 0;
               
                    myLabel.setText("Invalid Move Try Again");
                    myLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
                    gPane.add(myLabel, 3, 6);
                    if(r1IsFlipped == true){
                        r1.setMouseTransparent(false);
                        stackPane.getChildren().removeAll(r1, label);
                    stackPane.getChildren().addAll(r1, label);
                    r1IsFlipped = false;
                    gPane.add(stackPane, 0, 0);
                    }
                    else if(r2IsFlipped == true){
                    stackPane2.getChildren().add(label2);
                    r2IsFlipped = false;
                    }
                }
                sum = 0;
            });

        //Add buttons to hPane
        hPane.getChildren().addAll(btCheck, btRoll);
        //Add labels to stack pane for each tile
        stackPane.getChildren().addAll(r1,label);
        stackPane2.getChildren().addAll(r2, label2);
        stackPane3.getChildren().addAll(r3, label3);
        stackPane4.getChildren().addAll(r4, label4);
        stackPane5.getChildren().addAll(r5, label5);
        stackPane6.getChildren().addAll(r6, label6);
        stackPane7.getChildren().addAll(r7, label7);
        stackPane8.getChildren().addAll(r8, label8);
        stackPane9.getChildren().addAll(r9, label9);
        //Add all the tiles into a stackpane
        gPane.add(stackPane, 0, 0);
        gPane.add(stackPane2, 1, 0);
        gPane.add(stackPane3, 2, 0);
        gPane.add(stackPane4, 3, 0);
        gPane.add(stackPane5, 4, 0);
        gPane.add(stackPane6, 5, 0);
        gPane.add(stackPane7, 6, 0);
        gPane.add(stackPane8, 7, 0);
        gPane.add(stackPane9, 8, 0);
        //Add the grid pane to the center of the borderpane
        pane.setCenter(gPane);
        pane.setBottom(hPane);
        Scene scene = new Scene(pane,1000, 600);
        primaryStage.setTitle("ShutTheBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
}
