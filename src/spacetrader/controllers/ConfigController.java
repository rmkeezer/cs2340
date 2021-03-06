package spacetrader.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import spacetrader.Main;
import spacetrader.api.SoundPlayer;
import spacetrader.database.DbMethods;
import spacetrader.models.Player;
import spacetrader.models.Universe;

import java.net.URL;
import java.util.ResourceBundle;
import spacetrader.models.Skill;

/**
 * Configuration screen controller.
 *
 * @author Bao
 */
public class ConfigController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="FXML objects">
    @FXML
    Label p0, p1, p2, p3, p4;
    @FXML
    Button p0_up, p1_up, p2_up, p3_up, p4_up;
    @FXML
    Button p0_down, p1_down, p2_down, p3_down, p4_down;
    @FXML
    Label remain;
    @FXML
    Pane messagePane;
    @FXML
    TextField name;
    @FXML
    Label name_error;
//</editor-fold>

    private Main application;
    private Player myPlayer;
    private Universe myUniverse;
    private final int[] points = new int[Skill.values().length];
    private final int MAX_POINTS = 15;


    /**
     * Links to main application.
     *
     * @param application
     */
    public void setApp(Main application) {
        this.application = application;
    }

    /**
     * "OK" button is pressed.
     *
     * @param event
     */
    @FXML
    private void handleOKAction(ActionEvent event) {
        SoundPlayer.playClick();
        if (name.getText().equals("")) {
            name_error.setText("Name field is blank.");
        } else {
            myPlayer = new Player(name.getText(), points);
            DbMethods db = new DbMethods();
            db.save(myPlayer);

            messagePane.setVisible(true);
            myUniverse = Universe.generateUniverse(100, 100, application.NUMBER_OF_SOLAR_SYSTEMS);
            System.out.println(myUniverse.toString());
            //System.out.println(newPlayer);
        }
    }

    /**
     * "Cancel" button is pressed.
     *
     * @param ActionEvent event
     */
    @FXML
    private void handleCancelAction(ActionEvent event) {
        SoundPlayer.playClick();
        application.closeConfig();
    }

    /**
     * "Up" button is pressed.
     *
     * @param ActionEvent event
     */
    @FXML
    private void handleUp(ActionEvent event) {
        if (getRemainingPoints() > 0) {
            if (event.getSource().equals(p0_up)) {
                p0.setText(++points[0] + "");
            } else if (event.getSource().equals(p1_up)) {
                p1.setText(++points[1] + "");
            } else if (event.getSource().equals(p2_up)) {
                p2.setText(++points[2] + "");
            } else if (event.getSource().equals(p3_up)) {
                p3.setText(++points[3] + "");
            } else if (event.getSource().equals(p4_up)) {
                p4.setText(++points[4] + "");
            }
            //Show current remaining points (one less)
            showRemainingPoints();
        }
        //Debug
        //System.out.printf("%d %d %d %d %d - %d%n", points[0], points[1],
        //points[2], points[3], points[4], sum);
    }

    /**
     * "Down" button is pressed.
     *
     * @param ActionEvent event
     */
    @FXML
    private void handleDown(ActionEvent event) {
        if (event.getSource().equals(p0_down)) {
            p0.setText((points[0] == 0) ? "0" : --points[0] + "");
        } else if (event.getSource().equals(p1_down)) {
            p1.setText((points[1] == 0) ? "0" : --points[1] + "");
        } else if (event.getSource().equals(p2_down)) {
            p2.setText((points[2] == 0) ? "0" : --points[2] + "");
        } else if (event.getSource().equals(p3_down)) {
            p3.setText((points[3] == 0) ? "0" : --points[3] + "");
        } else if (event.getSource().equals(p4_down)) {
            p4.setText((points[4] == 0) ? "0" : --points[4] + "");
        }
        showRemainingPoints();
    }

    /**
     * "Play" is pressed.
     *
     * @param ActionEvent event
     */
    @FXML
    private void handlePlay(ActionEvent event) {
        SoundPlayer.playClick();
        application.gotoGame(myPlayer, myUniverse);
    }

    /**
     * "Go to Home Screen" is pressed.
     *
     * @param ActionEvent event
     */
    @FXML
    private void handleGoToHomeScreen(ActionEvent event) {
        SoundPlayer.playClick();
        application.closeConfig();
    }

    /**
     * Return remaining skill points.
     *
     * @return remaining points
     */
    private int getRemainingPoints() {
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return MAX_POINTS - sum;
    }

    /**
     * Show remaining points in Label remain.
     */
    private void showRemainingPoints() {
        remain.setText(getRemainingPoints() + "");
    }

    /**
     * Initializes the controller class.
     * @param URL url
     * @param ResourceBundle rb
     */
    @Override
    public final void initialize(URL url, ResourceBundle rb) {
        messagePane.setVisible(false);
        showRemainingPoints();
    }

}
