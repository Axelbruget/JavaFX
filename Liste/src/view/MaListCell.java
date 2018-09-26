package view;

import model.Personne;

/**
 * Classe MaListCell qui est une fabrique de cellule pour déterminer comment les cellules de la liste doivent s'afficher
 */
public class MaListCell extends javafx.scene.control.ListCell<model.Personne> {
    @Override
    protected void updateItem(Personne item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty ){
            textProperty().bind(item.nomProperty().concat(" - ").concat(item.ageProperty().asString()));
        }
        else{
            textProperty().unbind();
            setText("");
        }
    }
}
