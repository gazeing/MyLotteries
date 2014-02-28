package com.sydney.mylotteries.input;

import com.google.gson.Gson;
import com.sydney.mylotteries.model.InputResult;

public interface InputDelegate {
	/**
	 * Interface to start a new Input delegate
	 * @param aParam Gson param to initialize the delegate
	 * @return
	 */
	public boolean onStart(Gson aParam);
	
	/**
	 * Interface when new result responses.
	 * @param aParam
	 */
	public void onResult(InputResult aResult);
	
	/**
	 * Interface when input approach giveup
	 */
	public void onGiveup();
}
