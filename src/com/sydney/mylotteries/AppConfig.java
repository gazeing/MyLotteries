package com.sydney.mylotteries;

import com.crazybean.framework.UiConfig;
import com.crazybean.framework.UiPage;

public final class AppConfig  
{ 
	// State table.
	public static final int KStateTable[][] =
	{
		{UiConfig.KStateChaos,    UiConfig.KEventInit,         AppConfig.KSplashPage},
		{UiConfig.KStateAny,      UiConfig.KEventBack,         UiConfig.KStatePrev},
		
		{UiConfig.KStateAny,      AppConfig.KShowMain,         AppConfig.KMainPage},
//		{AppConfig.KMainPage,     UiConfig.KEventBack,         UiConfig.KStateChaos},
//		
//		{UiConfig.KStateAny,      AppConfig.KViewUser,         AppConfig.KMyInfoPage},
//		{UiConfig.KStateAny,      AppConfig.KViewPack,         AppConfig.KPackPage},
//		{UiConfig.KStateAny,      AppConfig.KTranList,         AppConfig.KTranListPage},
//		{UiConfig.KStateAny,      AppConfig.KLogout,           AppConfig.KLoginPage},
//		
//		{AppConfig.KTranListPage, AppConfig.KTranInfo,         AppConfig.KTranInfoPage},
//		{AppConfig.KTranInfoPage, AppConfig.KViewUser,         AppConfig.KUserInfoPage},
	};
	
	// States
	private static final int KSplashPage       = (UiConfig.KStateUser + 1);
	private static final int KMainPage         = (UiConfig.KStateUser + 2);
//	private static final int KMyInfoPage       = (UiConfig.KStateUser + 3);
//	private static final int KPackPage         = (UiConfig.KStateUser + 4);
//	private static final int KTranListPage     = (UiConfig.KStateUser + 5);
//	private static final int KTranInfoPage     = (UiConfig.KStateUser + 6);
//	private static final int KUserInfoPage     = (UiConfig.KStateUser + 7);
//	
//	// Event IDs
	public static final int KShowMain          = (UiConfig.KEventUser + 1);
//	public static final int KViewUser          = (UiConfig.KEventUser + 2);
//	public static final int KViewPack          = (UiConfig.KEventUser + 3);
//	public static final int KTranList          = (UiConfig.KEventUser + 4);
//	public static final int KTranInfo          = (UiConfig.KEventUser + 5);
//	public static final int KLogout            = (UiConfig.KEventUser + 6);
	
	/**
	 * getPage
	 */
	public static UiPage getPage(int nState)
	{
		UiPage pPage = null;
		switch ( nState )
		{
		case AppConfig.KSplashPage:
			pPage = new SplashPage();
			break;
			
		case AppConfig.KMainPage:
			pPage = new MainPage();
			break;
			
//		case AppConfig.KMyInfoPage:
//		case AppConfig.KUserInfoPage:
////			pPage = new UserPage();
//			break;
//			
//		case AppConfig.KPackPage:
////			pPage = new PackPage();
//			break;
//			
//		case AppConfig.KTranListPage:
////			pPage = new TranListPage();
//			break;
//			
//		case AppConfig.KTranInfoPage:
////			pPage = new TranInfoPage();
//			break;
			
		default:
			break;
		}
		
		return pPage;
	}
}
