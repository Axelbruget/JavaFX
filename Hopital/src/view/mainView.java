package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import vm.ChambreVM;
import vm.CollectionChambreVM;
import vm.PatientVM;

public class mainView {

    @FXML public Button clicAjouterChambre;
    @FXML private ListView<ChambreVM> listeChambres;
    @FXML private ListView<PatientVM> listePatients;
    @FXML private TextField textFieldNomPatient;
    @FXML private Button clicValider;

    private CollectionChambreVM collectionChambreVM = new CollectionChambreVM();

    public void initialize(){

        listeChambres.itemsProperty().bind(collectionChambreVM.listProperty());

        cellFactoryChambreVM();
        cellFactoryPatientVM();

        listeChambres.getSelectionModel().selectedItemProperty().addListener((obs,oldV,newV) -> {
            if (newV != null){
                listePatients.itemsProperty().bind(newV.listProperty());
            }
        });
    }

    private void cellFactoryChambreVM() {
        listeChambres.setCellFactory(__ -> new ListCell<ChambreVM>(){
            @Override
            protected void updateItem(ChambreVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty){
                    textProperty().bind(item.getNumeroProperty().asString().concat(" - ").concat(item.listProperty().size()).concat(" patients"));
                }
                else{
                    textProperty().unbind();
                    setText("");
                }

            }
        });
    }

    private void cellFactoryPatientVM() {
        listePatients.setCellFactory(__ -> new ListCell<PatientVM>(){
            @Override
            protected void updateItem(PatientVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty){
                    textProperty().bind(item.nomPropertyProperty());
                }
                else{
                    textProperty().unbind();
                    setText("");
                }
            }
        });
    }

    public void clicAjouterPatient(){
        if (listeChambres.getSelectionModel().getSelectedIndex() == -1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Vous devez selectionner une chambre");
            alert.showAndWait();
        }
        else{
            listeChambres.getSelectionModel().getSelectedItem().addPatientVM(textFieldNomPatient.getText());
            textFieldNomPatient.setText("");
        }

    }

    public void clicAjouterChambre() {
        ChambreVM chambreVm = new ChambreVM();
        chambreVm.setNumero(collectionChambreVM.getList().size() + 1);
        collectionChambreVM.addChambreVM(chambreVm);
    }
}
