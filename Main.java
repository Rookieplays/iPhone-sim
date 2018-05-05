import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.*;
import javafx.stage.Stage;
 

public class Main extends Application
{
	Stage window;
	Scene scene1, scene2;
	public static void main(String[] args) 
	{
		launch(args);	
	}
	@Override 
	public void start(Stage primaryStage)throws Exception
	{
		window=primaryStage;
		Label label1= new Label("Welcome To The Fisrt Scene!");
		Button button1=new Button("Go To Scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		//Layout= children are laid out in vertical column
		VBox layout=new VBox(20);
		layout.getChildren().addAll(label1, button1);
		scene1=new Scene(layout,310,500);

		//Button 2
		Button button2=new Button("Go To Scene 1");
		button2.setOnAction(e -> window.setScene(scene1));

		HBox layout2=new HBox();
		layout2.getChildren().addAll(button2);

		scene2=new Scene(layout2,310,500);

		window.setScene(scene1);
		window.setTitle("iPhone");
		window.show();
	}
}


   

   
       

