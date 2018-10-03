package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import vm.ChambreVM;
import vm.CollectionChambreVM;
import vm.PatientVM;

public class mainView {

    @FXML private ListView<ChambreVM> listeChambres;
    @FXML private ListView<PatientVM> listePatients;
    @FXML private Label labelNomPatient;
    @FXML private TextField textFieldNomPatient;
    @FXML private Button clicValider;

    private PatientVM patientVM = new PatientVM();
    private ChambreVM chambreVM = new ChambreVM();
    private CollectionChambreVM collectionChambreVM = new CollectionChambreVM();


    public void initialize(){

        labelNomPatient.textProperty().bind(patientVM.nomPropertyProperty());
        textFieldNomPatient.textProperty().bindBidirectional(patientVM.nomPropertyProperty());

        listeChambres.itemsProperty().bind(collectionChambreVM.listProperty());

        listeChambres.setCellFactory(__ -> new ListCell<ChambreVM>(){
            @Override
            protected void updateItem(ChambreVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty){
                    textProperty().bind(item.numeroProperty().asString());
                }
                else{
                    textProperty().unbind();
                    setText("");
                }

            }
        });
    }

    public void clicBoutton(){
        collectionChambreVM.addChambreVM(new ChambreVM());
    }
}
