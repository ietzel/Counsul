import java.io.*;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class Main extends Application {

    /*
    public static int minIndex(double[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int maxIndex(double[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    */
 
    private static final TableView<Viewpoint> table = new TableView<>();
    private final ObservableList<Viewpoint> data = FXCollections.observableArrayList(
        new Viewpoint("honesty/integrity/transparency", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("compassion/respect", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("responsibility/accountability", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("loyalty/trustworthiness", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("law-abiding", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("fairness", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("leadership", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("anti-discrimination", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("workplace health/safety/security", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("employee code of conduct & anti-harassment", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("attendance & vacation & time-off", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("employee complaint", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("work schedule & rest period", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("substance abuse", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("mobile device management", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("compensation and benefits", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("travel", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("inclement weather", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("remote work", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("conflict of interest", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("acceptable use", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("compensation", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("safety", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("relationships", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("skill discretion", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""),
        new Viewpoint("prospects", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", "")
    );

    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Counsul");
        stage.setWidth(960);
        stage.setHeight(720);
 
        final Label label = new Label("10Core Empathy Matrix, FinTech Artificial Neural Network, JavaFX Complex Typography");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn<Viewpoint, String> factorCol = new TableColumn<>("Factor");
        factorCol.setCellValueFactory(new PropertyValueFactory<>("factor"));
        factorCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        factorCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactor(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> executiveCognitionCol = new TableColumn<>("Executive Cognition");
        executiveCognitionCol.setCellValueFactory(new PropertyValueFactory<>("executive cognition"));
        executiveCognitionCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveCognitionCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveCognition(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> executiveInstinctCol = new TableColumn<>("Executive Instinct");
        executiveInstinctCol.setCellValueFactory(new PropertyValueFactory<>("executive instinct"));
        executiveInstinctCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        executiveInstinctCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveInstinct(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> executiveAffectationCol = new TableColumn<>("Executive Affectation");
        executiveAffectationCol.setCellValueFactory(new PropertyValueFactory<>("executive affectation"));
        executiveAffectationCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveAffectationCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveAffectation(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> executiveRootCol = new TableColumn<>("Executive Root");
        executiveRootCol.setCellValueFactory(new PropertyValueFactory<>("executive root"));
        executiveRootCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveRootCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveRoot(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> executiveSacralCol = new TableColumn<>("Executive Sacral");
        executiveSacralCol.setCellValueFactory(new PropertyValueFactory<>("executive sacral"));
        executiveSacralCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        executiveSacralCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveInstinct(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> executiveSolarPlexusCol = new TableColumn<>("Executive Solar Plexus");
        executiveSolarPlexusCol.setCellValueFactory(new PropertyValueFactory<>("executive solar plexus"));
        executiveSolarPlexusCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveSolarPlexusCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveSolarPlexus(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> executiveHeartCol = new TableColumn<>("Executive Heart");
        executiveHeartCol.setCellValueFactory(new PropertyValueFactory<>("executive heart"));
        executiveHeartCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        executiveHeartCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveHeart(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> executiveThroatCol = new TableColumn<>("Executive Throat");
        executiveThroatCol.setCellValueFactory(new PropertyValueFactory<>("executive throat"));
        executiveThroatCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveThroatCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveThroat(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> executiveThirdEyeCol = new TableColumn<>("Executive Third Eye");
        executiveThirdEyeCol.setCellValueFactory(new PropertyValueFactory<>("executive third eye"));
        executiveThirdEyeCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveThirdEyeCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveThirdEye(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> executiveCrownCol = new TableColumn<>("Executive Crown");
        executiveCrownCol.setCellValueFactory(new PropertyValueFactory<>("executive crown"));
        executiveCrownCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        executiveCrownCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveCrown(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> salesFinanceCognitionCol = new TableColumn<>("Sales & Finance Cognition");
        salesFinanceCognitionCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance cognition"));
        salesFinanceCognitionCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        salesFinanceCognitionCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceCognition(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> salesFinanceInstinctCol = new TableColumn<>("Sales & Finance Instinct");
        salesFinanceInstinctCol.setCellValueFactory(new PropertyValueFactory<>("executive & instinct"));
        salesFinanceInstinctCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        salesFinanceInstinctCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceInstinct(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> salesFinanceAffectationCol = new TableColumn<>("Sales & Finance Affectation");
        salesFinanceAffectationCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance affectation"));
        salesFinanceAffectationCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        salesFinanceAffectationCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceAffectation(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> salesFinanceRootCol = new TableColumn<>("Sales & Finance Root");
        salesFinanceRootCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance root"));
        salesFinanceRootCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        salesFinanceRootCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceRoot(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> salesFinanceSacralCol = new TableColumn<>("Sales & Finance Sacral");
        salesFinanceSacralCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance sacral"));
        salesFinanceSacralCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        salesFinanceSacralCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceInstinct(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> salesFinanceSolarPlexusCol = new TableColumn<>("Sales & Finance Solar Plexus");
        salesFinanceSolarPlexusCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance solar plexus"));
        salesFinanceSolarPlexusCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        salesFinanceSolarPlexusCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceSolarPlexus(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> salesFinanceHeartCol = new TableColumn<>("Sales & Finance Heart");
        salesFinanceHeartCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance heart"));
        salesFinanceHeartCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        salesFinanceHeartCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceHeart(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> salesFinanceThroatCol = new TableColumn<>("Sales & Finance Throat");
        salesFinanceThroatCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance throat"));
        salesFinanceThroatCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        salesFinanceThroatCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceThroat(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> salesFinanceThirdEyeCol = new TableColumn<>("Sales & Finance Third Eye");
        executiveThirdEyeCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance third eye"));
        executiveThirdEyeCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        executiveThirdEyeCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceThirdEye(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> salesFinanceCrownCol = new TableColumn<>("Sales & Finance Crown");
        salesFinanceCrownCol.setCellValueFactory(new PropertyValueFactory<>("sales & finance crown"));
        salesFinanceCrownCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        salesFinanceCrownCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesFinanceCrown(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> operationsTechnologyCognitionCol = new TableColumn<>("Operations & Technology Cognition");
        operationsTechnologyCognitionCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology cognition"));
        operationsTechnologyCognitionCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        operationsTechnologyCognitionCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyCognition(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> operationsTechnologyInstinctCol = new TableColumn<>("Operations & Technology Instinct");
        operationsTechnologyInstinctCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology instinct"));
        operationsTechnologyInstinctCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        operationsTechnologyInstinctCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyInstinct(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> operationsTechnologyAffectationCol = new TableColumn<>("Operations & Technology Affectation");
        operationsTechnologyAffectationCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology affectation"));
        operationsTechnologyAffectationCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        operationsTechnologyAffectationCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyAffectation(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> operationsTechnologyRootCol = new TableColumn<>("Operations & Technology Root");
        operationsTechnologyRootCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology root"));
        operationsTechnologyRootCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        operationsTechnologyRootCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExecutiveRoot(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> operationsTechnologySacralCol = new TableColumn<>("Operations & Technology Sacral");
        operationsTechnologySacralCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology sacral"));
        operationsTechnologySacralCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        operationsTechnologySacralCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyInstinct(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> operationsTechnologySolarPlexusCol = new TableColumn<>("Operations & Technology Solar Plexus");
        operationsTechnologySolarPlexusCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology solar plexus"));
        operationsTechnologySolarPlexusCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        operationsTechnologySolarPlexusCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologySolarPlexus(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> operationsTechnologyHeartCol = new TableColumn<>("Operations & Technology Heart");
        operationsTechnologyHeartCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology heart"));
        operationsTechnologyHeartCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        operationsTechnologyHeartCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyHeart(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> operationsTechnologyThroatCol = new TableColumn<>("Operations & Technology Throat");
        operationsTechnologyThroatCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology throat"));
        operationsTechnologyThroatCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        operationsTechnologyThroatCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyThroat(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> operationsTechnologyThirdEyeCol = new TableColumn<>("Operations & Technology Third Eye");
        operationsTechnologyThirdEyeCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology cognition"));
        operationsTechnologyThirdEyeCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        operationsTechnologyThirdEyeCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyThirdEye(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> operationsTechnologyCrownCol = new TableColumn<>("Operations & Technology Crown");
        operationsTechnologyCrownCol.setCellValueFactory(new PropertyValueFactory<>("operations & technology crown"));
        operationsTechnologyCrownCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        operationsTechnologyCrownCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsTechnologyCrown(t.getNewValue());
            }
        );
     
        TableColumn<Viewpoint, String> valueCol = new TableColumn<>("Portion (%)");
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        valueCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        valueCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setValue(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> antiCol = new TableColumn<>("Anti");
        antiCol.setCellValueFactory(new PropertyValueFactory<>("anti"));
        antiCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        antiCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAnti(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> proCol = new TableColumn<>("Pro");
        proCol.setCellValueFactory(new PropertyValueFactory<>("pro"));
        proCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        proCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPro(t.getNewValue());
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(
            factorCol, 
            executiveCognitionCol, executiveInstinctCol, executiveAffectationCol, executiveRootCol, executiveSacralCol, executiveSolarPlexusCol, executiveHeartCol, executiveThroatCol, executiveThirdEyeCol, executiveCrownCol, 
            salesFinanceCognitionCol, salesFinanceInstinctCol, salesFinanceAffectationCol, salesFinanceRootCol, salesFinanceSacralCol, salesFinanceSolarPlexusCol, salesFinanceHeartCol, salesFinanceThroatCol, salesFinanceThirdEyeCol, salesFinanceCrownCol, 
            operationsTechnologyCognitionCol, operationsTechnologyInstinctCol, operationsTechnologyAffectationCol, operationsTechnologyRootCol, operationsTechnologySacralCol, operationsTechnologySolarPlexusCol, operationsTechnologyHeartCol, operationsTechnologyThroatCol, operationsTechnologyThirdEyeCol, operationsTechnologyCrownCol, 
            valueCol, antiCol, proCol
        );
 
        final TextField addFactor = new TextField();
        addFactor.setPromptText("Factor");
        addFactor.setMaxWidth(factorCol.getPrefWidth());
 
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Viewpoint(
                addFactor.getText(), "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "", ""
            ));
            addFactor.clear();
        });

        final Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction((ActionEvent e) -> {
            Double[] weights = new Double[26];
            Double total = 0.00;
            Viewpoint viewpoint = new Viewpoint("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpoint = table.getItems().get(i);

                Double weight = Double.parseDouble(viewpoint.executiveCognitionCol.get())+Double.parseDouble(viewpoint.executiveInstinctCol.get())+Double.parseDouble(viewpoint.executiveAffectationCol.get())+Double.parseDouble(viewpoint.executiveRootCol.get())+Double.parseDouble(viewpoint.executiveSacralCol.get())+Double.parseDouble(viewpoint.executiveSolarPlexusCol.get())+Double.parseDouble(viewpoint.executiveHeartCol.get())+Double.parseDouble(viewpoint.executiveThroatCol.get())+Double.parseDouble(viewpoint.executiveThirdEyeCol.get())+Double.parseDouble(viewpoint.executiveCrownCol.get());
                weight += Double.parseDouble(viewpoint.salesFinanceCognitionCol.get())+Double.parseDouble(viewpoint.salesFinanceInstinctCol.get())+Double.parseDouble(viewpoint.salesFinanceAffectationCol.get())+Double.parseDouble(viewpoint.salesFinanceRootCol.get())+Double.parseDouble(viewpoint.salesFinanceSacralCol.get())+Double.parseDouble(viewpoint.salesFinanceSolarPlexusCol.get())+Double.parseDouble(viewpoint.salesFinanceHeartCol.get())+Double.parseDouble(viewpoint.salesFinanceThroatCol.get())+Double.parseDouble(viewpoint.salesFinanceThirdEyeCol.get())+Double.parseDouble(viewpoint.salesFinanceCrownCol.get());
                weight += Double.parseDouble(viewpoint.operationsTechnologyCognitionCol.get())+Double.parseDouble(viewpoint.operationsTechnologyInstinctCol.get())+Double.parseDouble(viewpoint.operationsTechnologyAffectationCol.get())+Double.parseDouble(viewpoint.operationsTechnologyRootCol.get())+Double.parseDouble(viewpoint.operationsTechnologySacralCol.get())+Double.parseDouble(viewpoint.operationsTechnologySolarPlexusCol.get())+Double.parseDouble(viewpoint.operationsTechnologyHeartCol.get())+Double.parseDouble(viewpoint.operationsTechnologyThroatCol.get())+Double.parseDouble(viewpoint.operationsTechnologyThirdEyeCol.get())+Double.parseDouble(viewpoint.operationsTechnologyCrownCol.get()); 
                weights[i] = weight;
                total += weight;
            }
            Viewpoint row = new Viewpoint(
                viewpoint.factor.get(), 
                viewpoint.executiveCognitionCol.get(), viewpoint.executiveInstinctCol.get(), viewpoint.executiveAffectationCol.get(), viewpoint.executiveRootCol.get(), viewpoint.executiveSacralCol.get(), viewpoint.executiveSolarPlexusCol.get(), viewpoint.executiveHeartCol.get(), viewpoint.executiveThroatCol.get(), viewpoint.executiveThirdEyeCol.get(), viewpoint.executiveCrownCol.get(),
                viewpoint.salesFinanceCognitionCol.get(), viewpoint.salesFinanceInstinctCol.get(), viewpoint.salesFinanceAffectationCol.get(), viewpoint.salesFinanceRootCol.get(), viewpoint.salesFinanceSacralCol.get(), viewpoint.salesFinanceSolarPlexusCol.get(), viewpoint.salesFinanceHeartCol.get(), viewpoint.salesFinanceThroatCol.get(), viewpoint.salesFinanceThirdEyeCol.get(), viewpoint.salesFinanceCrownCol.get(),
                viewpoint.operationsTechnologyCognitionCol.get(), viewpoint.operationsTechnologyInstinctCol.get(), viewpoint.operationsTechnologyAffectationCol.get(), viewpoint.operationsTechnologyRootCol.get(), viewpoint.operationsTechnologySacralCol.get(), viewpoint.operationsTechnologySolarPlexusCol.get(), viewpoint.operationsTechnologyHeartCol.get(), viewpoint.operationsTechnologyThroatCol.get(), viewpoint.operationsTechnologyThirdEyeCol.get(), viewpoint.operationsTechnologyCrownCol.get(),
                String.valueOf(0.00), 
                viewpoint.anti.get(),
                viewpoint.pro.get()
            );
            for(int i=0; i<table.getItems().size(); i++) {
                 row = new Viewpoint(
                    viewpoint.factor.get(), 
                    viewpoint.executiveCognitionCol.get(), viewpoint.executiveInstinctCol.get(), viewpoint.executiveAffectationCol.get(), viewpoint.executiveRootCol.get(), viewpoint.executiveSacralCol.get(), viewpoint.executiveSolarPlexusCol.get(), viewpoint.executiveHeartCol.get(), viewpoint.executiveThroatCol.get(), viewpoint.executiveThirdEyeCol.get(), viewpoint.executiveCrownCol.get(),
                    viewpoint.salesFinanceCognitionCol.get(), viewpoint.salesFinanceInstinctCol.get(), viewpoint.salesFinanceAffectationCol.get(), viewpoint.salesFinanceRootCol.get(), viewpoint.salesFinanceSacralCol.get(), viewpoint.salesFinanceSolarPlexusCol.get(), viewpoint.salesFinanceHeartCol.get(), viewpoint.salesFinanceThroatCol.get(), viewpoint.salesFinanceThirdEyeCol.get(), viewpoint.salesFinanceCrownCol.get(),
                    viewpoint.operationsTechnologyCognitionCol.get(), viewpoint.operationsTechnologyInstinctCol.get(), viewpoint.operationsTechnologyAffectationCol.get(), viewpoint.operationsTechnologyRootCol.get(), viewpoint.operationsTechnologySacralCol.get(), viewpoint.operationsTechnologySolarPlexusCol.get(), viewpoint.operationsTechnologyHeartCol.get(), viewpoint.operationsTechnologyThroatCol.get(), viewpoint.operationsTechnologyThirdEyeCol.get(), viewpoint.operationsTechnologyCrownCol.get(),
                    String.valueOf(100*weights[i]/total), 
                    viewpoint.anti.get(),
                    viewpoint.pro.get()
                );
                table.getItems().set(i, row);
            }
            
            Viewpoint viewpointTwo = new Viewpoint("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpointTwo = table.getItems().get(i);
                String[] values = {"Cognition", "Instinct", "Affectation"};
                viewpointTwo.setAnti(values[(/*anti*/0%4)]);
                viewpointTwo.setPro(values[(/*pro*/0%4)]);
            }           
        });

        //typeface/hierarchy/contrast/consistency/alignment/blankspace/color
        TextArea paragraph = new TextArea("The overall allocation of resources could be conceived as a long-term survival train trolley problem. In terms of chemical coring, this is considered similar to political coring; the last 2 columns are for coring. Complex typography conversion may allow for many runs to become similar to an encyclopedia.");
        paragraph.setWrapText(true);

        hb.getChildren().addAll(addFactor, addButton, calculateButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, paragraph, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static class Viewpoint {
 
        protected final SimpleStringProperty factor;
        protected final SimpleStringProperty executiveCognitionCol;
        protected final SimpleStringProperty executiveInstinctCol;
        protected final SimpleStringProperty executiveAffectationCol;
        protected final SimpleStringProperty executiveRootCol;
        protected final SimpleStringProperty executiveSacralCol;
        protected final SimpleStringProperty executiveSolarPlexusCol;
        protected final SimpleStringProperty executiveHeartCol;
        protected final SimpleStringProperty executiveThroatCol;
        protected final SimpleStringProperty executiveThirdEyeCol;
        protected final SimpleStringProperty executiveCrownCol;
        protected final SimpleStringProperty salesFinanceCognitionCol;
        protected final SimpleStringProperty salesFinanceInstinctCol;
        protected final SimpleStringProperty salesFinanceAffectationCol;
        protected final SimpleStringProperty salesFinanceRootCol;
        protected final SimpleStringProperty salesFinanceSacralCol;
        protected final SimpleStringProperty salesFinanceSolarPlexusCol;
        protected final SimpleStringProperty salesFinanceHeartCol;
        protected final SimpleStringProperty salesFinanceThroatCol;
        protected final SimpleStringProperty salesFinanceThirdEyeCol;
        protected final SimpleStringProperty salesFinanceCrownCol;
        protected final SimpleStringProperty operationsTechnologyCognitionCol;
        protected final SimpleStringProperty operationsTechnologyInstinctCol;
        protected final SimpleStringProperty operationsTechnologyAffectationCol;
        protected final SimpleStringProperty operationsTechnologyRootCol;
        protected final SimpleStringProperty operationsTechnologySacralCol;
        protected final SimpleStringProperty operationsTechnologySolarPlexusCol;
        protected final SimpleStringProperty operationsTechnologyHeartCol;
        protected final SimpleStringProperty operationsTechnologyThroatCol;
        protected final SimpleStringProperty operationsTechnologyThirdEyeCol;
        protected final SimpleStringProperty operationsTechnologyCrownCol;
        protected final SimpleStringProperty value;
        protected final SimpleStringProperty anti;
        protected final SimpleStringProperty pro;
 
        public Viewpoint(String factor, String executiveCognitionCol, String executiveInstinctCol, String executiveAffectationCol, String executiveRootCol, String executiveSacralCol, String executiveSolarPlexusCol, String executiveHeartCol, String executiveThroatCol, String executiveThirdEyeCol, String executiveCrownCol, String salesFinanceCognitionCol, String salesFinanceInstinctCol, String salesFinanceAffectationCol, String salesFinanceRootCol, String salesFinanceSacralCol, String salesFinanceSolarPlexusCol, String salesFinanceHeartCol, String salesFinanceThroatCol, String salesFinanceThirdEyeCol, String salesFinanceCrownCol, String operationsTechnologyCognitionCol, String operationsTechnologyInstinctCol, String operationsTechnologyAffectationCol, String operationsTechnologyRootCol, String operationsTechnologySacralCol, String operationsTechnologySolarPlexusCol, String operationsTechnologyHeartCol, String operationsTechnologyThroatCol, String operationsTechnologyThirdEyeCol, String operationsTechnologyCrownCol, String value, String anti, String pro) {
            this.factor = new SimpleStringProperty(factor);
            this.executiveCognitionCol = new SimpleStringProperty(executiveCognitionCol);
            this.executiveInstinctCol = new SimpleStringProperty(executiveInstinctCol);
            this.executiveAffectationCol = new SimpleStringProperty(executiveAffectationCol);
            this.executiveRootCol = new SimpleStringProperty(executiveRootCol);
            this.executiveSacralCol = new SimpleStringProperty(executiveSacralCol);
            this.executiveSolarPlexusCol = new SimpleStringProperty(executiveSolarPlexusCol);
            this.executiveHeartCol = new SimpleStringProperty(executiveHeartCol);
            this.executiveThroatCol = new SimpleStringProperty(executiveThroatCol);
            this.executiveThirdEyeCol = new SimpleStringProperty(executiveThirdEyeCol);
            this.executiveCrownCol = new SimpleStringProperty(executiveCrownCol);
            this.salesFinanceCognitionCol = new SimpleStringProperty(salesFinanceCognitionCol);
            this.salesFinanceInstinctCol = new SimpleStringProperty(salesFinanceInstinctCol);
            this.salesFinanceAffectationCol = new SimpleStringProperty(salesFinanceAffectationCol);
            this.salesFinanceRootCol = new SimpleStringProperty(salesFinanceRootCol);
            this.salesFinanceSacralCol = new SimpleStringProperty(salesFinanceSacralCol);
            this.salesFinanceSolarPlexusCol = new SimpleStringProperty(salesFinanceSolarPlexusCol);
            this.salesFinanceHeartCol = new SimpleStringProperty(salesFinanceHeartCol);
            this.salesFinanceThroatCol = new SimpleStringProperty(salesFinanceThroatCol);
            this.salesFinanceThirdEyeCol = new SimpleStringProperty(salesFinanceThirdEyeCol);
            this.salesFinanceCrownCol = new SimpleStringProperty(salesFinanceCrownCol);
            this.operationsTechnologyCognitionCol = new SimpleStringProperty(operationsTechnologyCognitionCol);
            this.operationsTechnologyInstinctCol = new SimpleStringProperty(operationsTechnologyInstinctCol);
            this.operationsTechnologyAffectationCol = new SimpleStringProperty(operationsTechnologyAffectationCol);
            this.operationsTechnologyRootCol = new SimpleStringProperty(operationsTechnologyRootCol);
            this.operationsTechnologySacralCol = new SimpleStringProperty(operationsTechnologySacralCol);
            this.operationsTechnologySolarPlexusCol = new SimpleStringProperty(operationsTechnologySolarPlexusCol);
            this.operationsTechnologyHeartCol = new SimpleStringProperty(operationsTechnologyHeartCol);
            this.operationsTechnologyThroatCol = new SimpleStringProperty(operationsTechnologyThroatCol);
            this.operationsTechnologyThirdEyeCol = new SimpleStringProperty(operationsTechnologyThirdEyeCol);
            this.operationsTechnologyCrownCol = new SimpleStringProperty(operationsTechnologyCrownCol);
            this.value = new SimpleStringProperty(value);
            this.anti = new SimpleStringProperty(anti);
            this.pro = new SimpleStringProperty(pro);
        }
 
        public String getFactor() {
            return factor.get();
        }
        public void setFactor(String factor) {
            this.factor.set(factor);
        }
            
        public String getExecutiveCognition() {
            return executiveCognitionCol.get();
        }
        public void setExecutiveCognition(String executiveCognitionCol) {
            this.executiveCognitionCol.set(executiveCognitionCol);
        }

        public String getExecutiveInstinct() {
            return executiveInstinctCol.get();
        }
        public void setExecutiveInstinct(String executiveInstinctCol) {
            this.executiveInstinctCol.set(executiveInstinctCol);
        }

        public String getExecutiveAffectation() {
            return executiveAffectationCol.get();
        }
        public void setExecutiveAffectation(String executiveAffectationCol) {
            this.executiveAffectationCol.set(executiveAffectationCol);
        }

        public String getExecutiveRoot() {
            return executiveRootCol.get();
        }
        public void setExecutiveRoot(String executiveRootCol) {
            this.executiveRootCol.set(executiveRootCol);
        }

        public String getExecutiveSacral() {
            return executiveSacralCol.get();
        }
        public void setExecutiveSacral(String executiveSacralCol) {
            this.executiveSacralCol.set(executiveSacralCol);
        }

        public String getExecutiveSolarPlexus() {
            return executiveSolarPlexusCol.get();
        }
        public void setExecutiveSolarPlexus(String executiveSolarPlexusCol) {
            this.executiveSolarPlexusCol.set(executiveSolarPlexusCol);
        }

        public String getExecutiveHeart() {
            return executiveHeartCol.get();
        }
        public void setExecutiveHeart(String executiveHeartCol) {
            this.executiveHeartCol.set(executiveHeartCol);
        }

        public String getExecutiveThroat() {
            return executiveThroatCol.get();
        }
        public void setExecutiveThroat(String executiveThroatCol) {
            this.executiveThroatCol.set(executiveThroatCol);
        }

        public String getExecutiveThirdEye() {
            return executiveThirdEyeCol.get();
        }
        public void setExecutiveThirdEye(String executiveThirdEyeCol) {
            this.executiveThirdEyeCol.set(executiveThirdEyeCol);
        }

        public String getExecutiveCrown() {
            return executiveCrownCol.get();
        }
        public void setExecutiveCrown(String executiveCrownCol) {
            this.executiveCrownCol.set(executiveCrownCol);
        }

        public String getSalesFinanceCognition() {
            return salesFinanceCognitionCol.get();
        }
        public void setSalesFinanceCognition(String salesFinanceCognitionCol) {
            this.salesFinanceCognitionCol.set(salesFinanceCognitionCol);
        }

        public String getSalesFinanceInstinct() {
            return salesFinanceInstinctCol.get();
        }
        public void setSalesFinanceInstinct(String salesFinanceInstinctCol) {
            this.salesFinanceInstinctCol.set(salesFinanceInstinctCol);
        }

        public String getSalesFinanceAffectation() {
            return salesFinanceAffectationCol.get();
        }
        public void setSalesFinanceAffectation(String salesFinanceAffectationCol) {
            this.salesFinanceAffectationCol.set(salesFinanceAffectationCol);
        }

        public String getSalesFinanceRoot() {
            return salesFinanceRootCol.get();
        }
        public void setSalesFinanceRoot(String salesFinanceRootCol) {
            this.salesFinanceRootCol.set(salesFinanceRootCol);
        }

        public String getSalesFinanceSacral() {
            return salesFinanceSacralCol.get();
        }
        public void setSalesFinanceSacral(String salesFinanceSacralCol) {
            this.salesFinanceSacralCol.set(salesFinanceSacralCol);
        }

        public String getSalesFinanceSolarPlexus() {
            return salesFinanceSolarPlexusCol.get();
        }
        public void setSalesFinanceSolarPlexus(String salesFinanceSolarPlexusCol) {
            this.salesFinanceSolarPlexusCol.set(salesFinanceSolarPlexusCol);
        }

        public String getSalesFinanceHeart() {
            return salesFinanceHeartCol.get();
        }
        public void setSalesFinanceHeart(String salesFinanceHeartCol) {
            this.salesFinanceHeartCol.set(salesFinanceHeartCol);
        }

        public String getSalesFinanceThroat() {
            return salesFinanceThroatCol.get();
        }
        public void setSalesFinanceThroat(String salesFinanceThroatCol) {
            this.salesFinanceThroatCol.set(salesFinanceThroatCol);
        }

        public String getSalesFinanceThirdEye() {
            return salesFinanceThirdEyeCol.get();
        }
        public void setSalesFinanceThirdEye(String salesFinanceThirdEyeCol) {
            this.salesFinanceThirdEyeCol.set(salesFinanceThirdEyeCol);
        }

        public String getSalesFinanceCrown() {
            return salesFinanceCrownCol.get();
        }
        public void setSalesFinanceCrown(String salesFinanceCrownCol) {
            this.salesFinanceCrownCol.set(salesFinanceCrownCol);
        }

        public String getOperationsTechnologyCognition() {
            return operationsTechnologyCognitionCol.get();
        }
        public void setOperationsTechnologyCognition(String operationsTechnologyCognitionCol) {
            this.operationsTechnologyCognitionCol.set(operationsTechnologyCognitionCol);
        }

        public String getOperationsTechnologyInstinct() {
            return operationsTechnologyInstinctCol.get();
        }
        public void setOperationsTechnologyInstinct(String operationsTechnologyInstinctCol) {
            this.operationsTechnologyInstinctCol.set(operationsTechnologyInstinctCol);
        }

        public String getOperationsTechnologyAffectation() {
            return operationsTechnologyAffectationCol.get();
        }
        public void setOperationsTechnologyAffectation(String operationsTechnologyAffectationCol) {
            this.operationsTechnologyAffectationCol.set(operationsTechnologyAffectationCol);
        }

        public String getOperationsTechnologyRoot() {
            return operationsTechnologyRootCol.get();
        }
        public void setOperationsTechnologyRoot(String operationsTechnologyRootCol) {
            this.operationsTechnologyRootCol.set(operationsTechnologyRootCol);
        }

        public String getOperationsTechnologySacral() {
            return operationsTechnologySacralCol.get();
        }
        public void setOperationsTechnologySacral(String operationsTechnologySacralCol) {
            this.operationsTechnologySacralCol.set(operationsTechnologySacralCol);
        }

        public String getOperationsTechnologySolarPlexus() {
            return operationsTechnologySolarPlexusCol.get();
        }
        public void setOperationsTechnologySolarPlexus(String operationsTechnologySolarPlexusCol) {
            this.operationsTechnologySolarPlexusCol.set(operationsTechnologySolarPlexusCol);
        }

        public String getOperationsTechnologyHeart() {
            return operationsTechnologyHeartCol.get();
        }
        public void setOperationsTechnologyHeart(String operationsTechnologyHeartCol) {
            this.operationsTechnologyHeartCol.set(operationsTechnologyHeartCol);
        }

        public String getOperationsTechnologyThroat() {
            return operationsTechnologyThroatCol.get();
        }
        public void setOperationsTechnologyThroat(String operationsTechnologyThroatCol) {
            this.operationsTechnologyThroatCol.set(operationsTechnologyThroatCol);
        }

        public String getOperationsTechnologyThirdEye() {
            return operationsTechnologyThirdEyeCol.get();
        }
        public void setOperationsTechnologyThirdEye(String operationsTechnologyThirdEyeCol) {
            this.operationsTechnologyThirdEyeCol.set(operationsTechnologyThirdEyeCol);
        }

        public String getOperationsTechnologyCrown() {
            return operationsTechnologyCrownCol.get();
        }
        public void setOperationsTechnologyCrown(String operationsTechnologyCrownCol) {
            this.operationsTechnologyCrownCol.set(operationsTechnologyCrownCol);
        }
     
        public String getValue() {
            return value.get();
        }
        public void setValue(String value) {
            this.value.set(value);
        }

        public String getAnti() {
            return anti.get();
        }
        public void setAnti(String anti) {
            this.anti.set(anti);
        }

        public String getPro() {
            return pro.get();
        }
        public void setPro(String pro) {
            this.pro.set(pro);
        }    
    }
}
