package com.ly2314.linearlayoutgenerationbycode;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
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

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            //View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //return rootView;
        	LinearLayout rootView = new LinearLayout(getActivity());
        	rootView.setOrientation(LinearLayout.VERTICAL);
        	
        	EditText _to = new EditText(getActivity());
        	_to.setHint("To");
        	
        	EditText _subject = new EditText(getActivity());
        	_subject.setHint("Subject");
        	
        	EditText _message = new EditText(getActivity());
        	_message.setHint("Message");
        	_message.setGravity(Gravity.TOP);
        	
        	LinearLayout _buttons = new LinearLayout(getActivity());
        	_buttons.setOrientation(LinearLayout.HORIZONTAL);
        	
        	Button _send = new Button(getActivity());
        	_send.setText("Send");
        	
        	Button _cancel = new Button(getActivity());
        	_cancel.setText("Cancel");
        	
        	_buttons.addView(_send);
        	_buttons.addView(_cancel);
        	
        	rootView.addView(_to);
        	rootView.addView(_subject);
        	rootView.addView(_message);
        	rootView.addView(_buttons);
        	
        	LinearLayout.LayoutParams _message_layout = (LinearLayout.LayoutParams)_message.getLayoutParams();
        	_message_layout.height = 0;
        	_message_layout.weight = 1;
        	
        	LinearLayout.LayoutParams _buttons_layout = (LinearLayout.LayoutParams)_buttons.getLayoutParams();
        	_buttons_layout.width = LayoutParams.WRAP_CONTENT;
        	_buttons_layout.gravity = Gravity.RIGHT;
        	        	
        	return rootView;
        }
    }

}
