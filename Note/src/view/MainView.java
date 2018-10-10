package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import vm.MatiereVM;
import vm.NoteVM;
import vm.UECollectionVM;

public class MainView {

    private UECollectionVM collectionVM = new UECollectionVM("testing");

    @FXML private Spinner spinnerChoixNote;
    @FXML private ListView<NoteVM> listeNoteVM;
    @FXML private TextField textFieldNomMatiere;
    @FXML private ListView<MatiereVM> listeMatiereVM;

    public void initialize(){
        listeMatiereVM.itemsProperty().bind(collectionVM.listProperty());


        setCellFactoryItem();
        setCellFactoryNote();

        listeMatiereVM.getSelectionModel().selectedItemProperty().addListener((obs,oldV,newV) -> {
            if (oldV != null){
                //listeNoteVM.itemsProperty().unbind(oldV.listProperty());
            }
            if (newV != null ){
                listeNoteVM.itemsProperty().bind(newV.listProperty());
            }
        });
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


    private void setCellFactoryItem(){
        listeMatiereVM.setCellFactory(__ -> new ListCell<MatiereVM>(){
            @Override
            protected void updateItem(MatiereVM item, boolean empty) {
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

    public void clicAjouterMatiere() {
        collectionVM.addMatiereVM(textFieldNomMatiere.getText());
    }

    public void clicSupprimerMatiere() {
        collectionVM.removeMatiereVM(listeMatiereVM.getSelectionModel().getSelectedItem());
    }

    public void clicAjouterNote() {
        int choix = Integer.valueOf(spinnerChoixNote.getValue().toString());
        listeMatiereVM.getSelectionModel().getSelectedItem().addNote(choix);
    }

    public void clicSupprimerNote() {
        listeMatiereVM.getSelectionModel().getSelectedItem().removeNote(listeNoteVM.getSelectionModel().getSelectedItem());
    }
}
