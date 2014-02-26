package com.sydney.mylotteries.input;

import com.google.gson.Gson;

public abstract class InputImpl {
	/**
	 * Interface to get the type of the implementation. 
	 * @return
	 */
	public abstract int getType();
	
	/**
	 * API to cancel the input.
	 */
	public final void doCancel() {
		if( null != mDelegate ) {
			mDelegate.onCancel();
		}
	}
	
	/**
	 * notify result to delegate
	 * @param aResult
	 */
	public final void notifyResult(Gson aResult) {
		if( null != mDelegate ) {
			mDelegate.onResult(aResult);
		}
		
		// Reset the delegate to null after notification.
		mDelegate = null;
	}
	
	/**
	 * Set the delegate instance.
	 * @param aDelegate
	 */
	public final void setDelegate(InputDelegate aDelegate) {
		mDelegate = aDelegate;
	}
	
	/**
	 * Member instances.
	 */
	private InputDelegate mDelegate;
}
