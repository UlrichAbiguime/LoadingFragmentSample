package com.bnsgfxample.loadingfragmentsample.activities;

import android.os.Environment;

/**
 *
 * 存储常量
 * @author wenjundu 2015-07-03
 *
 */
public class Constants {

	private final static String BASE_URL="http://192.168.i1.47:8082";

	// 首页路径
	public static final String IMAGE_URL = BASE_URL+"/App/Home";

	// 搜索路径
	public static final String SEARCH_URL =  BASE_URL+"/App/ProductList/PageList?";

	// 产品详情路径
	public static final String PRODUCTDETAIL_URL =  BASE_URL+"/App/PageDetail?";

	// 筛选路径
	public static final String SEARCH_FILTERCLASS_URL =  BASE_URL+"/App/FilterClassType";

	// 更多分类路径
	public static final String MORECLASSIFY_URL =  BASE_URL+"/App/CategoryList";

	// 商品规格选择路径
	public static final String CUSTOM_MADE_URL =  BASE_URL+"/App/CustomMade?";

	// 未登陆购物篮路径
	public static final String SHOP_CART_URL =  BASE_URL+"/App/CartView/Temp";




	// 保存参数文件夹名称
	public static final String SHARED_PREFERENCE_NAME = "mstar_store_prefs";

	// SDCard路径
	public static final String SD_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath();

	// 图片存储路径
	public static final String BASE_PATH = SD_PATH + "/mstar/store/";

	// 缓存图片路径
	public static final String BASE_IMAGE_CACHE = BASE_PATH + "cache/images/";

	// 需要分享的图片
	public static final String SHARE_FILE = BASE_PATH + "QrShareImage.png";

}
