package com.sydney.mylotteries;



import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainPage extends AppPage {

	
	protected MainPage() {
		super(R.layout.page_main);
		
	}
	
	

	@Override
	protected void onButtonClick(int nButtonId) {
		// TODO Auto-generated method stub
		super.onButtonClick(nButtonId);
		
		switch(nButtonId) 
		{
		case R.id.button1:
			{
				// Start input activity.
				// Save the info.
				Log.d("test","button1");
				Bundle pBundle = new Bundle();
				// Show main page.
				this.postEvent(AppConfig.KInput, pBundle);
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
				Bundle pBundle = new Bundle();
				// Show main page.
				this.postEvent(AppConfig.KInput, pBundle);
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
	
	
}
