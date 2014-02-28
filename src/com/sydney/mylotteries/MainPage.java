package com.sydney.mylotteries;



import com.google.gson.Gson;
import com.sydney.mylotteries.input.InputDelegate;
import com.sydney.mylotteries.input.InputFactory;
import com.sydney.mylotteries.model.InputResult;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainPage extends AppPage implements InputDelegate {
	
	protected MainPage() {
		super(R.layout.page_main);
		
	}
	

	@Override
	protected void onCreate() {
		
		super.onCreate();
		addOnClick(R.id.button1);
		addOnClick(R.id.button2);
		addOnClick(R.id.button3);
		addOnClick(R.id.button4);
		
	}


	@Override
	protected void onViewClick(View aView, int nViewId) {
		// TODO Auto-generated method stub
		super.onViewClick(aView, nViewId);
		
		switch(nViewId) 
		{
		case R.id.button1:
			{
				// Start input activity.
				// Save the info.
				Log.d("test","button1");
				
				InputFactory.startInput(null, this);
			}
			break;
			
		case R.id.button2:
		{
			// Start history activity.
			// Save the info.
			Bundle pBundle = new Bundle();
			// Show main page.
			this.postEvent(AppConfig.KHistory, pBundle);
		}
		break;
		
		
		case R.id.button3:
		{
			// Start generate activity.
			// Save the info.
			Bundle pBundle = new Bundle();
			// Show main page.
			this.postEvent(AppConfig.KGenerate, pBundle);
		}
		break;
		
		case R.id.button4:
		{
			// Start dividends activity.
			// Save the info.
			Bundle pBundle = new Bundle();
			// Show main page.
			this.postEvent(AppConfig.KDividend, pBundle);
		}
		break;
		}
	}
	
	@Override
	public boolean onStart(Gson aParam) {
		Bundle pBundle = new Bundle();
		// Show main page.
		this.postEvent(AppConfig.KInput, pBundle);
		
		return true;
	}


	@Override
	public void onResult(InputResult aResult) {
	}


	@Override
	public void onGiveup() {
		// TODO Auto-generated method stub
		
	}
}
