package sprav;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;

public class Controller {

    protected PhonesHandler ph;
    protected DBHandler dbh;

    private ObservableList<Subscriber> subscribersData = FXCollections.observableArrayList();

    @FXML
    public TableView<Subscriber> tableSubscriber;

    @FXML
    public TableColumn<Subscriber, Integer> idColumn;

    @FXML
    public TableColumn<Subscriber, String> fioColumn;

    @FXML
    public TableColumn<Subscriber, String> doljnostColumn;

    @FXML
    public TableColumn<Subscriber, String> obColumn;

    @FXML
    public TableColumn<Subscriber, String> otdelColumn;

    @FXML
    public TableColumn<Subscriber, String> kabColumn;

    @FXML
    public TableColumn<Subscriber, String> zsColumn;

    @FXML
    public TableColumn<Subscriber, String> osColumn;

    @FXML
    public TableColumn<Subscriber, String> mobileColumn;

    @FXML
    public TableColumn<Subscriber, String> otherColumn;

    @FXML
    public TextField obField;

    @FXML
    public TextField podrazdelenieField;

    @FXML
    public TextField zsField;

    @FXML
    public TextField osField;

    @FXML
    public TextField mobileField;

    @FXML
    public TextField kabField;

    @FXML
    public TextField otherField;

    public Controller() {
        ph = new PhonesHandler();
        dbh = new DBHandler();
    }

    @FXML
    public TextArea textArea;

    @FXML
    public TextField searchField;

    public void clearForm(){

        /*idColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, Integer>("id"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("fio"));
        doljnostColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("doljnost"));
        obColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("ob"));
        otdelColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("otdel"));
        kabColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("kab"));
        zsColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("zs"));
        osColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("os"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("mobile"));
        otherColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("other"));*/

        tableSubscriber.setItems(dbh.selectAllPhonesInBase());
        obField.setText("");
        podrazdelenieField.setText("");
        zsField.setText("");
        osField.setText("");
        mobileField.setText("");
        kabField.setText("");
        otherField.setText("");
        searchField.setText("");
    }

    public void initTableView(){

        //idColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, Integer>("id"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("FIO"));
        doljnostColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("Podrazdelenie"));
        obColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("OrganBezopasnosti"));
/*        otdelColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("otdel"));
        kabColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("kab"));
        zsColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("zs"));
        osColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("os"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("mobile"));
        otherColumn.setCellValueFactory(new PropertyValueFactory<Subscriber, String>("other"));*/

        tableSubscriber.setItems(dbh.selectAllPhonesInBase());
    }

    public void searchPhones(){
        String searchText = searchField.getText();
        if (!searchText.equals(""))
        tableSubscriber.setItems(dbh.searchPhones(searchText));
    }

    public void disconnect(){
        dbh.disconnect();
    }

    public void initListener(){
        TableView.TableViewSelectionModel<Subscriber> selectionModel = tableSubscriber.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Subscriber>(){
            public void changed(ObservableValue<? extends Subscriber> val, Subscriber oldVal, Subscriber newVal){
                if(newVal != null) {
                    obField.setText(newVal.getOrganBezopasnosti());
                    podrazdelenieField.setText(newVal.getPodrazdelenie());
                    zsField.setText(newVal.getZS());
                    osField.setText(newVal.getNS());
                    mobileField.setText(newVal.getOtherTEL());
                    kabField.setText(newVal.getKabinet());
                    otherField.setText(newVal.getPM());
                    searchField.setText(newVal.getFIO());
                }
            }
        });
    }
}
