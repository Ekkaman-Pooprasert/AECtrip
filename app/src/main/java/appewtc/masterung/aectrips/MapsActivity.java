package appewtc.masterung.aectrips;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latCenterADouble, lngCenterADouble;
    private LatLng centerLatLng;
    private int countryAnInt; //กำหนด ถูกเลือกมาจากประเทศอะไร?
    private CountryTABLE objCountryTABLE;
    private LatLng[] markerLatLngs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get Lat&Lng to Center
        getCenterLatLng();

        //Create LatLng for Marker
        createLatLngForMarker();

    }   // oncreate

    private void createLatLngForMarker() {

        objCountryTABLE = new CountryTABLE(this);

        String[] strLat = objCountryTABLE.readAllCountry(4);
        String[] strLng = objCountryTABLE.readAllCountry(5);

        Double[] latDoubles = new Double[strLat.length];
        Double[] lngDoubles = new Double[strLng.length];
        markerLatLngs = new LatLng[strLat.length];

        for (int i = 0; i < strLat.length; i++) {

            latDoubles[i] = Double.parseDouble(strLat[i]);
            lngDoubles[i] = Double.parseDouble(strLng[i]);

            markerLatLngs[i] = new LatLng(latDoubles[i], lngDoubles[i]);

        }

    }   //createLatLngForMarker

    private void getCenterLatLng() {
        latCenterADouble = getIntent().getDoubleExtra("Lat", 0);
        lngCenterADouble = getIntent().getDoubleExtra("Lng", 0);
        centerLatLng = new LatLng(latCenterADouble,lngCenterADouble);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Assign Center Map Zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLatLng, 6));


        //Create All Marker
        for (int i = 0; i < markerLatLngs.length; i++) {

            mMap.addMarker(new MarkerOptions().position(markerLatLngs[i]));
        }

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(latCenterADouble, lngCenterADouble);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }   // onMapsReady
}   //Main Class
