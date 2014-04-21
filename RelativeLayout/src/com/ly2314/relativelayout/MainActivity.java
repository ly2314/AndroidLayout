package com.ly2314.relativelayout;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

    	private Spinner _month;
    	private Spinner _date;
    	private final static int[] LIMITS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            _month = (Spinner)rootView.findViewById(R.id.month);
            String[] l = getResources().getStringArray(R.array.Month);
            ArrayAdapter<String> _a = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, l);
            _month.setAdapter(_a);
        	_month.setOnItemSelectedListener(new OnItemSelectedListener() {

        		@Override
        		public void onItemSelected(AdapterView<?> adpaterView, View view,
        		int position, long id)
        		{
        			setDateSpinner(LIMITS[position]);
        		}

        		@Override
        		public void onNothingSelected(AdapterView<?> arg0) {
        		// TODO Auto-generated method stub
        		}
        	});

            _date = (Spinner)rootView.findViewById(R.id.date);
            
            return rootView;
        }

		private void setDateSpinner(int limit) {
			String[] d = new String[limit];
            for (int i = 0; i < limit; ++i)
            {
            	d[i] = String.valueOf(i + 1);
            }
            ArrayAdapter<String> _a2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, d);
            _date.setAdapter(_a2);
		}
    }

}
