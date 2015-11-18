package appewtc.masterung.aectrips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Atom on 11/18/2015.
 */
public class MyAdapter extends BaseAdapter{

    // Explicit
    private Context objContext;
    private int iconAnInt;
    private String[] thwordStrings;
    private String[] wordStrings;

    public MyAdapter(Context objContext, int iconAnInt, String[] thwordStrings, String[] wordStrings) {
        this.objContext = objContext;
        this.iconAnInt = iconAnInt;
        this.thwordStrings = thwordStrings;
        this.wordStrings = wordStrings;
    }   // Contructor

    @Override
    public int getCount() {
        return thwordStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.country_listview, parent, false);

        // Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView11);
        iconImageView.setImageResource(iconAnInt);

        //Thai Word
        TextView thaiTextView = (TextView) objView1.findViewById(R.id.textView12);
        thaiTextView.setText(thwordStrings[position]);

        //คำศัพท์ต่างประเทศ
        TextView wordTextView = (TextView) objView1.findViewById(R.id.textView13);
        wordTextView.setText(wordStrings[position]);

        return objView1;
    }
}   //Main Class
