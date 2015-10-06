package com.Zxing.Activity;

import com.example.zxingtest.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private TextView tvResult=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		tvResult=(TextView) findViewById(R.id.tv_result);
		
		String result=getIntent().getStringExtra("resultStr");
		
		tvResult.setText(result);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

}
