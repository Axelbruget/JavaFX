package bind;

import javafx.beans.binding.DoubleBinding;
import javafx.collections.ObservableList;
import vm.MatiereVM;

public class MoyenneBinding extends DoubleBinding {


    private ObservableList<MatiereVM> list;

    @Override
    protected double computeValue() {
        return calculMoyenne();
    }

    private double calculMoyenne() {
        double total = 0;
        if (list.size() > 0){
            for (MatiereVM mat : list) {
                total += mat.getMoyenneProperty();
            }
            return total/list.size();
        }
        return 0;
    }

    public MoyenneBinding(ObservableList<MatiereVM> listMoyennes) {
        //listMoyennes.addListener(c -> c.);
        list = listMoyennes;
        super.bind(list);

    }
}
