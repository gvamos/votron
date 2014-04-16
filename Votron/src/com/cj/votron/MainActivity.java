package com.cj.votron;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
        //getMenuInflater().inflate(R.menu.main, menu);
    	getMenuInflater().inflate(R.menu.actions, menu);
    	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        System.out.println("DBG: onOptionsItemSelected:" + id);
        Intent intent = null;
        switch (id) {
            case R.id.action_settings:
                break;
            case R.id.voters:
            	System.out.println("DBG: Voters Activity");
            	intent = new Intent(this, VotersActivity.class);
              break;
            case R.id.elections:
            	intent = new Intent(this, ElectionsActivity.class);
              break;
            case R.id.debug:
            	intent = new Intent(this, DebugActivity.class);
              break;
            default:
            	Log.i(this.getClass().getName(),":onOptionsItemSelected default:" + id);
                return super.onOptionsItemSelected(item);
        }
        if (null != intent){
        	System.out.println("DBG: intent action=" + intent.getAction());
        	startActivity(intent);
        }
        return true;
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
