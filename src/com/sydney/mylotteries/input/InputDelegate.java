package com.sydney.mylotteries.input;

import com.google.gson.Gson;

public interface InputDelegate {
	/**
	 * Interface when new result responses.
	 * @param aParam
	 */
	public void onResult(Gson aResult);
	
	/**
	 * Interface when input approach canceled
	 */
	public void onCancel();
}
