package com.ly2314.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
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

		private ListView _listView;
		
		private final static String[] NAMES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			_listView = (ListView) rootView.findViewById(R.id.listView1);
			_listView.setOnItemClickListener(new OnItemClickListener()
			{
				@Override
				public void onItemClick(AdapterView<?> listView, View view,
				int position, long id)
				{
					String name = NAMES[position];
					Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT)
					.show();
				}
				});

			String[] text = new String[] { "1", "2", "3", "4", "5", "6", "7",
					"8", "9" };

			int[] imageIds = new int[] { R.drawable.sample_photo_00, R.drawable.sample_photo_01,
			R.drawable.sample_photo_02, R.drawable.sample_photo_03, R.drawable.sample_photo_04,
			R.drawable.sample_photo_05, R.drawable.sample_photo_06, R.drawable.sample_photo_07,
			R.drawable.sample_photo_08 };

			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

			for (int i = 0; i < text.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
				item.put("text", text[i]);
				item.put("image", imageIds[i]);
				data.add(item);
			}

			String[] from = new String[] { "text", "image" };
			int[] to = new int[] { R.id.textView1, R.id.imageView1 };

			SimpleAdapter adapter = new SimpleAdapter(getActivity(), data,
			R.layout.list_item, from, to);
			
			_listView.setAdapter(adapter);
			return rootView;
		}
	}

}
