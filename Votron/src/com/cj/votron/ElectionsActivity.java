/**
 * 
 */
package com.cj.votron;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author gvamos
 *
 */
public class ElectionsActivity extends Activity {
	
	  private ListView electionListView ;  
	  private ArrayAdapter<String> listAdapter ; 	  
	  private Config.Elections elections;
	
	  @Override  
	  public void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState); 
	    Log.i(this.getClass().getName(),":onCreate");
	    setContentView(R.layout.activity_elections); 
	    	      
	    elections = Config.getInstance().getElections();
	    elections.updateElections();  
  	      
	    // Shave the yak.  
	    electionListView = (ListView) findViewById( R.id.electionsListView );  	    
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, (elections.getElectionsList()));  
	    electionListView.setAdapter( listAdapter );        
	  }  		
}
