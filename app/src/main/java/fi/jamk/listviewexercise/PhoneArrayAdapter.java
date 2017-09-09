package fi.jamk.listviewexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jere on 9.9.2017.
 */

public class PhoneArrayAdapter extends ArrayAdapter<String> {
    // get app context
    private Context context;

    //phone name data
    private ArrayList<String> phones;

    // get app context and phone data to adapter
    public PhoneArrayAdapter(Context context, ArrayList<String> phones) {
        super(context, R.layout.rowlayout, R.id.textView1, phones);
        this.context = context;
        this.phones = phones;
    }

    // populate ListView rows
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        // get row
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        // show phone name
        TextView textView = (TextView) rowView.findViewById(R.id.textView1);
        textView.setText(phones.get(position));
        // show phone icon
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        switch (phones.get(position)) {
            case "Android": imageView.setImageResource(R.drawable.android); break;
            case "iPhone": imageView.setImageResource(R.drawable.ios); break;
            case "Windows Mobile": imageView.setImageResource(R.drawable.windows); break;
            case "Blackberry": imageView.setImageResource(R.drawable.blackberry); break;
            case "WebOS": imageView.setImageResource(R.drawable.webos); break;
            case "Ubuntu": imageView.setImageResource(R.drawable.ubuntu); break;
        }
        // return row view
        return rowView;
    }
}
