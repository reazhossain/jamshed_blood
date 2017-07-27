package luck.materialdesign.tabsnavigator.tabs;

/**
 * Created by prince on 7/23/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import luck.materialdesign.tabsnavigator.Adapter.RecycleViewAdapter_PlacesList;
import luck.materialdesign.tabsnavigator.Model.PlaceApiModels.Geometry;
import luck.materialdesign.tabsnavigator.Model.PlaceApiModels.Location;
import luck.materialdesign.tabsnavigator.Model.PlaceApiModels.PlaceApiModel;
import luck.materialdesign.tabsnavigator.Model.PlaceApiModels.Result;
import luck.materialdesign.tabsnavigator.Model.PlacesListModel;
import luck.materialdesign.tabsnavigator.R;
import luck.materialdesign.tabsnavigator.Service.PlaceApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tab3 extends Fragment {

    private GoogleMap mMap;
    MapView mMapView;
    private static final String TAG = "Nearby";
    PlaceApiService placeApiService;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_maps, container, false);

        ///// getNearbyPlaces();

        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        mapIn();


        return v;
    }

    public void mapIn() {
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap x) {
                mMap = x;
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                getNearbyPlaces();

            }
        });
    }

    public void getNearbyPlaces() {

        ////Toast.makeText(PlaceListActivity.this, ""+type, Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        placeApiService = retrofit.create(PlaceApiService.class);

        String dynamicUrl = "json?location=23.7948722,90.4232836&radius=2000&types=hospital&key=AIzaSyAzX-acRCZFSbD51D2234KjCuOBbZZlvsc";
        Call<PlaceApiModel> nearByPlacesCall = placeApiService.getAllNearByPlaces(dynamicUrl);


        Log.d(TAG, "" + dynamicUrl);
        nearByPlacesCall.enqueue(new Callback<PlaceApiModel>() {
            @Override
            public void onResponse(Call<PlaceApiModel> call, Response<PlaceApiModel> response) {


                PlaceApiModel nearByPlaces = response.body();

                if (nearByPlaces.getStatus().equals("OK")) {

                    List<Result> results = nearByPlaces.getResults();
                    LatLng latLng = null;
                    for (Result result : results) {

                        Geometry geo = result.getGeometry();
                        Location location = geo.getLocation();


                        String name = result.getName();

                        Log.d(TAG, "" + name);
                        if (location.getLat() != null && location.getLng() != null) {

                            latLng = new LatLng(location.getLat(), location.getLng());
                            Log.d(TAG, "Lat" + latLng);
                            addMarker(latLng, name);


                        }


                    }

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(14));


                } else {
                    Log.d(TAG, "" + nearByPlaces.getStatus());
                    Toast.makeText(getActivity(), "No Place Found", Toast.LENGTH_LONG).show();


                }


            }

            @Override
            public void onFailure(Call<PlaceApiModel> call, Throwable t) {

                Log.d(TAG, "Connection fail");
                Toast.makeText(getActivity(), "Connection to server failed.", Toast.LENGTH_LONG).show();


            }
        });

    }


    public void addMarker(LatLng latLng, String name) {

        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(name)
                /// .snippet("Distance \n"+totalDistanceBetweenTwoPosition)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        marker.showInfoWindow();


    }
}
