package cl.evilcorp.miraza.data;

public class RetrofitClient {
    private static final  String BASE_URL="https://dog.ceo/api/";
    private static Retrofit retrofit=null;


    private RetrofitClient (){

    }

    public static ApiDog getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiDog.class);
    }
}
