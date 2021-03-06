package cl.evilcorp.miraza.presenter;



import java.util.List;

import cl.evilcorp.miraza.model.BreedModel;
import cl.evilcorp.miraza.model.IBreedModel;

public class BreedPresenter implements IBreedModel {

    private IBreedPresenter viewBreed;
    private BreedModel breedModel;

    public BreedPresenter(IBreedPresenter viewBreed, BreedModel breedModel) {
        this.viewBreed = viewBreed;
        this.breedModel=breedModel;
        breedModel.setBreedPresenter(this);
        breedModel.loadBreedList();

    }


    @Override
    public void showBreed(List<String> breeds) {
        viewBreed.showBreed(breeds);
    }
}
