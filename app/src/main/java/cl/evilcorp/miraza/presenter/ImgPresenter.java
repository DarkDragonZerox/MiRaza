package cl.evilcorp.miraza.presenter;

import java.util.List;

import cl.evilcorp.miraza.fragmentsAndAdapters.ImageFragment;
import cl.evilcorp.miraza.model.BreedModel;
import cl.evilcorp.miraza.model.IBreedModel;

public class ImgPresenter implements IBreedModel {
    private IBreedPresenter viewImg;
    private BreedModel breedModel;
    private String breed;

    public ImgPresenter(IBreedPresenter viewImg, BreedModel breedModel, String pBreed) {
        this.viewImg = viewImg;
        this.breedModel = breedModel;
        this.breed = pBreed;
        breedModel.setImgPresenter(this);
        breedModel.loadBreedImg(breed);

    }

    @Override
    public void showBreed(List<String> breeds) {
        viewImg.showBreed(breeds);
    }
}
