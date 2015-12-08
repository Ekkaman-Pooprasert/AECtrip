package appewtc.masterung.aectrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MarkerDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView, myLatTextView, myLngTextView, distantTextView;
    private String titleString, descriptionString, latString, lngString, pictureString;
    private ImageView markerImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_detail);

        //Bind Widget
        bindWidget();

        //Get Value From SQLite
        getValueFromSQlite();

        //Show View
        showview();

    }   // Main Method

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
