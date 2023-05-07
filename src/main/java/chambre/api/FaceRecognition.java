package chambre.api;

import io.reactivex.rxjava3.core.Observable;
import json.Face;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FaceRecognition {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.cloudmersive.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();
    // ??? CreateAPI service = retrofit.create(FaceRecognition.class);

    @POST("/image/face/locate-with-landmarks")
    Observable<CreateAPI> getCurrentFace();
}
