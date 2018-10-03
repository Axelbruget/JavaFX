package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Chambre;
import model.CollectionChambre;
import model.Patient;
import vm.ChambreVM;
import vm.CollectionChambreVM;
import vm.PatientVM;

public class mainView {

    @FXML private ListView<Chambre> listeChambres;
    @FXML private ListView<Patient> listePatients;
    @FXML private Label labelNomPatient;
    @FXML private TextField textFieldNomPatient;
    @FXML private Button clicValider;

    private PatientVM patientVM = new PatientVM();
    private ChambreVM chambreVM = new ChambreVM();
    private CollectionChambreVM collectionChambreVM = new CollectionChambreVM();


    public void initialize(){

        labelNomPatient.textProperty().bind(patientVM.nomPropertyProperty());
        textFieldNomPatient.textProperty().bindBidirectional(patientVM.nomPropertyProperty());


    }

    public void clicBoutton(){

    }
}
