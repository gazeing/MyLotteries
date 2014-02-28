package com.sydney.mylotteries.input;

import com.crazybean.framework.UiStorage;
import com.google.gson.Gson;
import com.sydney.mylotteries.model.InputResult;

public final class InputFactory implements UiStorage.Entity {
	/**
	 * Type definition.
	 */
	private static final int TYPE_NONE    = 0;
	public static final int TYPE_CUR_PAGE = (TYPE_NONE + 1);
	public static final int TYPE_NEW_PAGE = (TYPE_NONE + 2);
	public static final int TYPE_ACTIVITY = (TYPE_NONE + 3);
	public static final int TYPE_UNKNOWN  = (TYPE_NONE + 4);
	
	/**
	 * Key definition of Gson.
	 */
	public static final String KEY_TYPE  = "type";
	public static final String KEY_VALUE = "value";
	
	/**
	 * Start the input method.
	 * @param nType
	 * @param aParam
	 * @param aDelegate
	 * @return
	 */
	public static boolean startInput(Gson aParam, InputDelegate aDelegate) {
		InputFactory factory = InputFactory.getInstance();
		return factory.tryStart(aParam, aDelegate);
	}
	
	public static void setResult(InputResult aResult) {
		InputFactory factory = InputFactory.getInstance();
		if( null != factory.mCurrent ) {
			factory.mCurrent.onResult(aResult);
			factory.mCurrent = null;
		}
	}
	
	/**
	 * Try to start the implementation.
	 * @param nType
	 * @param aParam
	 * @param aDelegate
	 * @return
	 * @throws ClassNotFoundException 
	 */
	private boolean tryStart(Gson aParam, InputDelegate aDelegate) {
		if( null == aDelegate )
			return false;
		
		return aDelegate.onStart(aParam);
	}
	
	private synchronized static InputFactory getInstance()  
	{
		InputFactory pFactory = null;
		Object pObject = UiStorage.getEntity(InputFactory.class);
		if ( null == pObject ) {
			pFactory = new InputFactory();
			UiStorage.setEntity(pFactory);
		} else {
			pFactory = (InputFactory)pObject;
		}
		
		return pFactory;
	}
	
	@Override
	public void doFinalize() {
		if( null != mCurrent ) {
			mCurrent.onGiveup();
		}
	}
	
	private InputFactory() {
	}
	
	private InputDelegate mCurrent;
}
