package cl.evilcorp.miraza.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cl.evilcorp.miraza.presenter.BreedPresenter;
import cl.evilcorp.miraza.presenter.ImgPresenter;
import cl.evilcorp.miraza.data.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedModel {
    private static final String TAG = "InfoLog";
    private BreedPresenter breedPresenter;
    private ImgPresenter imgPresenter;

    private List<String> breedImage = new ArrayList<>();


    public void setImgPresenter(ImgPresenter imgPresenter) {
        this.imgPresenter = imgPresenter;
    }


    public void setBreedPresenter(BreedPresenter breedPresenter) {
        this.breedPresenter = breedPresenter;
    }


    public void loadBreedList() {
        RetrofitClient.getRetrofitInstance().getAllBreeds().enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                List<String> breeds = new ArrayList<String>();
                breeds.addAll(response.body().getMessage().keySet());
                breedPresenter.showBreed(breeds);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {
                Log.d(TAG, "onFailure: Fallo de Conexión" + t.toString());


            }
        });
    }

    public void loadBreedImg(String pBreed) {
        RetrofitClient.getRetrofitInstance().getBreedDetail(pBreed).enqueue(new Callback<BreedImg>() {
            @Override
            public void onResponse(Call<BreedImg> call, Response<BreedImg> response) {
                breedImage.addAll(Collections.singleton(response.body().getMessage().toString()));
                imgPresenter.showBreed(breedImage);
            }

            @Override
            public void onFailure(Call<BreedImg> call, Throwable t) {


            }
        });
    }


}
