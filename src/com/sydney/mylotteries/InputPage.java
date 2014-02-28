package com.sydney.mylotteries;

import android.view.View;
import android.widget.EditText;

import com.sydney.mylotteries.input.InputFactory;
import com.sydney.mylotteries.model.InputResult;

public class InputPage extends AppPage {

	protected InputPage() {
		super(R.layout.page_input, false);
	}
	
	@Override
	protected void onCreate() {
		super.onCreate();
		
		mGroup1 = (EditText)findViewById(R.id.input_group_1);
		this.addOnClick(R.id.input_okay);
	}
	
	@Override
	protected void onViewClick(View aView, int nViewId) {
		switch(nViewId) {
		case R.id.input_okay:
			String strText = mGroup1.getText().toString().trim();
			InputResult result = new InputResult(strText);
			result.mType = InputFactory.TYPE_NEW_PAGE;
			//Gson gson = new Gson();
			//String strJson = gson.toJson(result);
			InputFactory.setResult(result);
			this.handleBack();
			break;
		}
	}
	
	private EditText mGroup1;
}
