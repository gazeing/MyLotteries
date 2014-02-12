package com.sydney.mylotteries;

import android.content.Context;

import com.sydney.mylotteries.DataManager;
import com.sydney.mylotteries.Preference;
import com.crazybean.framework.UiPage;
import com.crazybean.utils.Telephony;
import com.sydney.mylotteries.R;

public class AppPage extends UiPage		
{
	/**
	* Create a new Instance AppPage.  
	*  
	* @param nLayoutId
	 */
	protected AppPage(int nLayoutId)
	{
		super(nLayoutId);
		setCanRotate(false);
		setAnimation();
	}
	
	/**
	* Create a new Instance AppPage.  
	*  
	* @param nLayoutId
	* @param bAnimating
	 */
	protected AppPage(int nLayoutId, boolean bAnimating)
	{
		super(nLayoutId, bAnimating);
		setCanRotate(false);
		setAnimation();
	}

	/**
	* Create a new Instance AppPage.  
	*  
	* @param nLayoutId
	* @param bAnimating
	* @param bResetFocus
	 */
	protected AppPage(int nLayoutId, boolean bAnimating, boolean bFullScreen)
	{
		super(nLayoutId, bAnimating, bFullScreen);
		setCanRotate(false);
		setAnimation();
	}
	
	/**
	* method Name:onCreate    
	* method Description:     
	* void  
	* @exception   
	* @since  1.0.0
	 */
	@Override
	protected void onCreate()
	{
		super.onCreate();
		
		// Initialize the instance.
		doInit();
	}
	
	/**
	* method Name:onActivate    
	* method Description:     
	* void  
	* @exception   
	* @since  1.0.0
	 */
	@Override
	protected void onActivate()
	{	
		// Call the base implementation.
		super.onActivate();
	}

	/**
	* method Name:checkNetwork    
	* method Description:  
	* @return   
	* boolean  
	* @exception   
	* @since  1.0.0
	 */	
	protected boolean checkNetwork()
	{
		// Check whether network is available.
		final boolean bAvailable = Telephony.isNetworkAvailable(getContext());
		if ( !bAvailable )
		{
			// TODO: Show the error message for network.
		}
		
		return bAvailable;
	}
	
	/**
	 * onButtonClick
	 */
	@Override
	protected void onButtonClick(int nButtonId)
	{
		switch ( nButtonId )
		{
		case KWirelessSetting:
			Telephony.startWirelessSetting(getContext());
			break;
		case KExitYes:
			{
				// Exit the application.
				exitApp();
			}
			break;
		default:
			super.onButtonClick(nButtonId);
			break;
		}
	}
	
	/**
	 * setAnimation
	 */
	private void setAnimation()
	{
		// Set default animations.
		this.setForwardAnimIds(R.anim.in_rightleft, R.anim.out_rightleft);
		this.setBackwardAnimIds(R.anim.in_leftright, R.anim.out_leftright);
	}
	
	/**
	* method Name:doInit    
	* method Description:     
	* void  
	* @exception   
	* @since  1.0.0
	 */
	private void doInit()
	{
		DataManager pManager = DataManager.getInstance();
		if ( (null == pManager) || (pManager.initialized()) )
			return ;
		
		// Load the preference content.
		Context pContext = getContext();
		Preference.getInstance(pContext);
		
		// Set the flag.
		pManager.setInitialized(true);
	}
	
	@Override
	protected void handleMessage(int nMessageId, Object aObject)
	{
		switch (nMessageId)
		{
		case UiPage.KShowInputMethod:
			super.showInputMethod();
			break;
		default:
			break;
		}
	}
	
	// Constants definition for wireless settings.
	protected static final int KWirelessSetting = 0x800;
	
	protected static final int KAppMessageIdBase    = (KUiMessageIdUser + 0x100); // User defined message start offset.
	protected static final int KAppMessageIdUser    = (KUiMessageIdUser + 0x200); // User defined message start offset.
	
	//Menu Id
	private static final int   KMenuBase 	= 0x1000;
	protected static final int KMenuExit  = (KMenuBase + 1);
	protected static final int KMenuMore  = (KMenuBase + 2);
	protected static final int KMenuHome  = (KMenuBase + 3);
	protected static final int KMenuDownload  = (KMenuBase + 4);
	
	
	//Button Id
	private static final int   KButtonBase 	= 0x2000;
	protected static final int KExitYes =  KButtonBase + 1;
	protected static final int KExitNo  =  KButtonBase + 2;
}
