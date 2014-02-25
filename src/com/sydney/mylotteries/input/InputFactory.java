package com.sydney.mylotteries.input;

import java.util.ArrayList;
import java.util.List;

import com.crazybean.framework.UiStorage;
import com.google.gson.Gson;

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
	 * Start the input method.
	 * @param nType
	 * @param aParam
	 * @param aDelegate
	 * @return
	 */
	public static boolean startInput(int nType, Gson aParam, InputDelegate aDelegate) throws ClassNotFoundException {
		InputFactory factory = InputFactory.getInstance();
		return factory.tryStart(nType, aParam, aDelegate);
	}
	
	/**
	 * Try to start the implementation.
	 * @param nType
	 * @param aParam
	 * @param aDelegate
	 * @return
	 * @throws ClassNotFoundException 
	 */
	private boolean tryStart(int nType, Gson aParam, InputDelegate aDelegate) throws ClassNotFoundException {
		if( (TYPE_NONE == nType) || (nType >= TYPE_UNKNOWN) || (null == aDelegate) )
			return false;
		
		final int nSize = mImpls.size();
		InputImpl impl = null;
		for( int nIdx = 0; nIdx < nSize; nIdx++ ) {
			InputImpl entity = mImpls.get(nIdx);
			if( entity.getType() == nType ) {
				impl = entity;
				break;
			}
		}
		
		if( null == impl )
			throw (new ClassNotFoundException());
		
		impl.setDelegate(aDelegate);
		return impl.doStart(aParam);
	}
	
	private synchronized static InputFactory getInstance()  
	{
		InputFactory pFactory = null;
		Object pObject = UiStorage.getEntity(InputFactory.class);
		if ( null == pObject ) {
			pFactory = new InputFactory();
			pFactory.initialize();
			UiStorage.setEntity(pFactory);
		} else {
			pFactory = (InputFactory)pObject;
		}
		
		return pFactory;
	}
	
	@Override
	public void doFinalize() {
		if( null != mImpls ) {
			for( InputImpl impl : mImpls ) {
				impl.doCancel();
			}
			
			// Clean up.
			mImpls.clear();
			mImpls = null;
		}
	}
	
	/**
	 * Load all available implementation for input approaches.
	 */
	private void initialize() {
		// Load all available implements to array.
		mImpls = new ArrayList<InputImpl>();
	}
	
	private InputFactory() {
	}
	
	private List<InputImpl>  mImpls;
}
