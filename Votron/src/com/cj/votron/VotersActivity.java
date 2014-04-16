package com.cj.votron;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VotersActivity extends Activity {
	
  private ListView votersListView ;  
  private ArrayAdapter<String> listAdapter ; 	  
  private Config.Voters voters;

  @Override  
  public void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState); 
    Log.i(this.getClass().getName(),":onCreate");
    setContentView(R.layout.activity_voters); 
    	      
    voters = Config.getInstance().getVoters();
    voters.updateVoters();  
	      
    // Shave the yak.  
    votersListView = (ListView) findViewById( R.id.votersListView );  	    
    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, (voters.getVotersList()));  
    votersListView.setAdapter( listAdapter );        
  }  		
}
