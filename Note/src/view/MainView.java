package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import bind.MoyenneBinding;
import vm.MatiereVM;
import vm.NoteVM;
import vm.UECollectionVM;
import java.io.IOException;

public class MainView {

    private UECollectionVM collectionVM = new UECollectionVM("testing");

    @FXML private Label labelNombreMatiere;
    @FXML private Spinner spinnerChoixNote;
    @FXML private ListView<NoteVM> listeNoteVM;
    @FXML private ListView<MatiereVM> listeMatiereVM;

    public void initialize(){
        listeMatiereVM.itemsProperty().bind(collectionVM.listProperty());

        setCellFactoryMatiere();
        setCellFactoryNote();

        listeMatiereVM.getSelectionModel().selectedItemProperty().addListener((obs,oldV,newV) -> {
            if (oldV != null){
                listeNoteVM.itemsProperty().unbind();
            }
            if (newV != null){
                listeNoteVM.itemsProperty().bind(newV.listProperty());
            }
        });


        labelNombreMatiere.textProperty().bind(Bindings.concat("Moyenne :").concat(new MoyenneBinding(collectionVM.getList()).asString()));
    }



    private void setCellFactoryNote() {
        listeNoteVM.setCellFactory(__ -> new ListCell<NoteVM>(){
            @Override
            protected void updateItem(NoteVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty){
                    textProperty().bind(item.notePropertyProperty().asString());
                }
                else{
                    textProperty().unbind();
                    setText("");
                }
            }
        });
    }


    private void setCellFactoryMatiere(){
        listeMatiereVM.setCellFactory(__ -> new ListCell<MatiereVM>(){
            @Override
            protected void updateItem(MatiereVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty){
                    textProperty().bind(item.nomPropertyProperty().concat(" - ").concat(item.moyennePropertyProperty()));
                }
                else{
                    textProperty().unbind();
                    setText("");
                }
            }
        });
    }

    @FXML
    private void clicAjouterMatiere(){
        Stage stageFenetreCreation = new Stage();
        stageFenetreCreation.initOwner(spinnerChoixNote.getScene().getWindow());
        stageFenetreCreation.initModality(Modality.WINDOW_MODAL);
        CreationView controller = initFenetreCreation(stageFenetreCreation);
        if (controller.getNomMatiere() != null){
            collectionVM.addMatiereVM(controller.getNomMatiere());
        }
    }

    private CreationView initFenetreCreation(Stage stageFenetreCreation) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/creationView.fxml"));
        CreationView controller = new CreationView();
        loader.setController(controller);
        try{
            stageFenetreCreation.setScene(new Scene(loader.load()));
            stageFenetreCreation.showAndWait();
        } catch (IOException e) {
            Alert err = new Alert(Alert.AlertType.ERROR,"erreur à l'ouverture",ButtonType.OK);
            err.setHeaderText(null);
            err.show();
        }
        return controller;
    }

    @FXML
    private void clicSupprimerMatiere() {
        collectionVM.removeMatiereVM(listeMatiereVM.getSelectionModel().getSelectedItem());
        listeMatiereVM.getSelectionModel().clearSelection();
    }

    @FXML
    private void clicAjouterNote() {
        int choix = Integer.valueOf(spinnerChoixNote.getValue().toString());
        listeMatiereVM.getSelectionModel().getSelectedItem().addNote(choix);
    }

    @FXML
    private void clicSupprimerNote() {
        listeMatiereVM.getSelectionModel().getSelectedItem().removeNote(listeNoteVM.getSelectionModel().getSelectedItem());
    }
}
