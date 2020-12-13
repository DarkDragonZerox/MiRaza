package cl.evilcorp.miraza.data;

import cl.evilcorp.miraza.model.Breed;
import cl.evilcorp.miraza.model.BreedImg;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDog {
    @GET("breeds/list/all/")
    Call<Breed> getAllBreeds();

    @GET("breed/{breed}/images/")
    Call<BreedImg> getBreedDetail(@Path("breed") String breed);
}
