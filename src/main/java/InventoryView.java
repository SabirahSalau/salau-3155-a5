import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryView extends Application {

    Stage window;
    Button button;
    TableView<Items> table;
    TextField nameInput, priceInput, quantityInput;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Inventory Tracker");

        //Name column
        TableColumn<Items, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Items, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Items, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //NameInput
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //NameInput
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        //priceInput.setMinWidth(100);

        //NameInput
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        //quantityInput.setMinWidth(100);

        //Buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10 ,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        VBox layout = new VBox(10);
        layout.getChildren().addAll(table, hBox);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Items> productSelected, allProducts;
        allProducts = table.getItems();
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //AddButton clicked
    public void addButtonClicked(){
        Items product = new Items();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);

        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }


    //Get all products
    public ObservableList<Items> getProducts(){
        ObservableList<Items> products = FXCollections.observableArrayList();
        return products;
    }
}
