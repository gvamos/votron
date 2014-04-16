package com.cj.votron;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class DebugActivity extends Activity {

	Button dbg1Button;
	Button dbg2Button;
	Button dbg3Button;
	
	EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debug);

		initialize();

	}

	
	void initialize(){
		
		
		editText = (EditText)findViewById(R.id.display);
		
		dbg1Button = (Button) findViewById(R.id.debug1);
		dbg1Button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				String result = Config.getInstance().debug1("foo");
				editText.setText(result);
			}
		});

		dbg2Button = (Button) findViewById(R.id.debug2);
		dbg2Button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				String result = Config.getInstance().debug2("bar");
				editText.setText(result);
			}
		});

		dbg3Button = (Button) findViewById(R.id.debug3);
		dbg3Button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				String result = Config.getInstance().debug3("When kingship from heaven was lowered\nthe kingship was in Eridu ");
				editText.setText(result);
			}
		});
	}
	
}