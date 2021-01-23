package application;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton button1;

    @FXML
    private JFXButton button2;

    @FXML
    private JFXButton button3;

    @FXML
    private JFXButton button4;

    @FXML
    private JFXButton button5;

    @FXML
    private JFXButton exitButton;

    @FXML
    private JFXButton showButton;

    @FXML
    void initialize() {
       button1.setGraphic(new ImageView(new Image("/images/ic_alarm_on_white_24.png")));
       button2.setGraphic(new ImageView(new Image("/images/ic_card_travel_white_24.png")));
       button3.setGraphic(new ImageView(new Image("/images/ic_shopping_cart_white_24.png")));
       button4.setGraphic(new ImageView(new Image("/images/ic_work_white_24.png")));
       button5.setGraphic(new ImageView(new Image("/images/ic_payment_white_24.png")));
       exitButton.setGraphic(new ImageView(new Image("/images/ic_clear_white_24.png")));
       
     // showButton.setDisable(true);
       
       exitButton.setOnAction(e->{
    	   hideSideMenu();
    	  // showButton.setDisable(false);
    	   
       });
       
       showButton.setOnAction(e->{
    	   showside();
    	  // showButton.setDisable(true);
       });
      

    }
    
    public void hideSideMenu() {
    	TranslateTransition transition=transition(.2, exitButton, -300, 0);
    	
    	transition.setOnFinished(e->{
    		TranslateTransition transition1=transition(.2, button5, -300, 0);
    		transition1.setOnFinished(e1->{
    			
    			TranslateTransition transition2=transition(.2, button4, -300, 0);
        		transition2.setOnFinished(e2->{
        			TranslateTransition transition3=transition(.2, button3, -300, 0);
            		transition3.setOnFinished(e3->{
            			TranslateTransition transition4=transition(.2, button2, -300, 0);
                		transition4.setOnFinished(e4->{
                			transition(.2, button1, -300, 0);
                    	
                			
                		});
            		});
        		});
    		});
    	});
    }
    public void showside() {
    TranslateTransition transition=transition(.2, button1, 0, 0);
    	
    	transition.setOnFinished(e->{
    		TranslateTransition transition1=transition(.2, button2, 0, 0);
    		transition1.setOnFinished(e1->{
    			
    			TranslateTransition transition2=transition(.2, button3, 0, 0);
        		transition2.setOnFinished(e2->{
        			TranslateTransition transition3=transition(.2, button4, 0, 0);
            		transition3.setOnFinished(e3->{
            			TranslateTransition transition4=transition(.2, button5, 0, 0);
                		transition4.setOnFinished(e4->{
                			transition(.2, exitButton, 0, 0);
                    		
                			
                		});
            		});
        		});
    		});
    	});
		
	}
    public TranslateTransition transition(double duration,Node node,double byX,double byY) {
    	
    	TranslateTransition transition=new TranslateTransition(Duration.seconds(duration),node);
    	transition.setToX(byX);
    	transition.setToY(byY);
    	transition.play();
    	return transition;
    	
		
	}
}
