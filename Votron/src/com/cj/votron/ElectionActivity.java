/**
 * 
 */
package com.cj.votron;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author gvamos
 *
 */
public class ElectionActivity extends Activity {
	  private ListView electionListView ;  
	  private ArrayAdapter<String> listAdapter ;  
	
	  @Override  
	  public void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_elections);  
	      
	    // Find the ListView resource.   
	    electionListView = (ListView) findViewById( R.id.electionsListView );  
	  
	    // Create and populate a List of planet names.  
	    String[] planets = new String[] { "London", "Paris", "Chatsworth" };    
	    ArrayList<String> planetList = new ArrayList<String>();  
	    planetList.addAll( Arrays.asList(planets) );  
	      
	    // Create ArrayAdapter using the planet list.  
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);  
	      
	    // Add more planets. If you passed a String[] instead of a List<String>   
	    // into the ArrayAdapter constructor, you must not add more items.   
	    // Otherwise an exception will occur.  
	    listAdapter.add( "Foo" );  
	    listAdapter.add( "Bar" );  
	    listAdapter.add( "Baz" );  
  
	      
	    // Set the ArrayAdapter as the ListView's adapter.  
	    electionListView.setAdapter( listAdapter );        
	  }  	
	
}
