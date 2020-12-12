package cl.evilcorp.miraza.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDog {
    @GET("breeds/list/all/")
    Call<Breed> getAllBreeds();
    @GET("breed/{breed}/images/")
    Call <BreedImage> getBreedDetail(@Path("breed") String breed);
}
