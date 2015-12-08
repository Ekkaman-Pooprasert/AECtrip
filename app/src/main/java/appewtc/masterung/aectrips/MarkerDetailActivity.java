package appewtc.masterung.aectrips;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.squareup.picasso.Picasso;

public class MarkerDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView, myLatTextView, myLngTextView, distantTextView;
    private String titleString, descriptionString, latString, lngString, pictureString;
    private ImageView markerImageView;
    private LocationManager objLocationManager;
    private Criteria objCriteria;
    private Boolean gpsABoolean, networkABoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_detail);

        //Bind Widget
        bindWidget();

        //Get Value From SQLite
        getValueFromSQlite();

        //Get Location Lat,Lng
        getLocation();

        //Show View
        showview();

    }   // Main Method

    @Override
    protected void onStart() {
        super.onStart();

        gpsABoolean = objLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsABoolean) {

            networkABoolean = objLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!networkABoolean) {
                Intent objIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(objIntent);
            }

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        afterResume();
    }

    private void afterResume() {

        objLocationManager.removeUpdates(objLocationListener);
        String strLat = "Unknow";
        String strLng = "Unknow";

        Location networkLocation = requestUpdateFromProvider(LocationManager.NETWORK_PROVIDER, "Not Connected Internet");
        if (networkLocation != null) {
            strLat = String.format("%.7f", networkLocation.getLatitude());
            strLng = String.format("%.7f", networkLocation.getLongitude());
        }

        Location gpsLocation = requestUpdateFromProvider(LocationManager.GPS_PROVIDER, "No Card GPS");
        if (gpsLocation != null) {
            strLat = String.format("%.7f", gpsLocation.getLatitude());
            strLng = String.format("%.7f", gpsLocation.getLongitude());
        }

        myLatTextView.setText(strLat);
        myLngTextView.setText(strLng);


    }   //after Resume

    @Override
    protected void onStop() {
        super.onStop();
        objLocationManager.removeUpdates(objLocationListener);
    }

    public Location requestUpdateFromProvider(String strProvider, String strError) {

        Location objLocation = null;

        if (objLocationManager.isProviderEnabled(strProvider)) {

            objLocationManager.requestLocationUpdates(strProvider, 1000, 10, objLocationListener);
            objLocation = objLocationManager.getLastKnownLocation(strProvider);

        } else {
            Toast.makeText(MarkerDetailActivity.this, strError, Toast.LENGTH_SHORT).show();
        }

        return objLocation;
    }

    public final android.location.LocationListener objLocationListener = new android.location.LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            myLatTextView.setText(String.format("%.7f", location.getLatitude()));
            myLngTextView.setText(String.format("%.7f", location.getLongitude()));

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void getLocation() {

        objLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        objCriteria = new Criteria();
        objCriteria.setAccuracy(Criteria.ACCURACY_FINE);
        objCriteria.setAltitudeRequired(false);
        objCriteria.setBearingRequired(false);

    }   //Get Location

    private void getValueFromSQlite() {

        String[] strMyResult = null;
        titleString = getIntent().getStringExtra("Title");

        try {

            CountryTABLE objCountryTABLE = new CountryTABLE(this);
            strMyResult = objCountryTABLE.searchName(titleString);
            descriptionString = strMyResult[3];
            latString = strMyResult[4];
            lngString = strMyResult[5];
            pictureString = strMyResult[6];

            Log.d("aec", "Descrip ==>>>" + descriptionString);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }   //getValueFromSQlite

    private void showview() {
        //Show Title

        titleTextView.setText(titleString);

        //show image
        Picasso.with(MarkerDetailActivity.this)
                .load(pictureString)
                .resize(200, 200)
                .into(markerImageView);

        // Show Detail
        detailTextView.setText(descriptionString);


    }   //show view

    private void bindWidget() {
        titleTextView =(TextView) findViewById(R.id.textView14);
        markerImageView = (ImageView) findViewById(R.id.imageView12);
        detailTextView = (TextView) findViewById(R.id.textView15);
        myLatTextView = (TextView) findViewById(R.id.textView17);
        myLngTextView = (TextView) findViewById(R.id.textView18);
        distantTextView = (TextView) findViewById(R.id.textView19);
    }
}   //Main Class
