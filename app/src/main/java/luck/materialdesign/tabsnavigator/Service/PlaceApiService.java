package luck.materialdesign.tabsnavigator.Service;




import luck.materialdesign.tabsnavigator.Model.DirectionMapModels.DirectionModel;
import luck.materialdesign.tabsnavigator.Model.PlaceApiModels.PlaceApiModel;
import luck.materialdesign.tabsnavigator.Model.PlaceDetailsModel.PlaceDetailsModelResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by prince on 2/10/2017.
 */

public interface PlaceApiService {

        @GET()
        Call<PlaceApiModel>getAllNearByPlaces(@Url String changedUrl);

        @GET()
        Call<PlaceDetailsModelResponse>getNearByDetails(@Url String changedUrl);

        @GET()
        Call<DirectionModel>getRoutes(@Url String changedUrl);

}
