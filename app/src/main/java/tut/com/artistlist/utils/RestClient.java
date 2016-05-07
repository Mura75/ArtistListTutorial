package tut.com.artistlist.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;
import tut.com.artistlist.models.Artist;

/**
 * Created by Murager on 07.05.2016.
 */
public class RestClient {

    private static final String BASE_URL = "http://cache-kz01.cdn.yandex.net/download.cdn.yandex.net/mobilization-2016/artists.json";

    private ApiInterface api;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApi() {
        return api;
    }

    public interface ApiInterface {
        @GET
        Call<List<Artist>> getAllArtists(@Url String url);
    }
}
