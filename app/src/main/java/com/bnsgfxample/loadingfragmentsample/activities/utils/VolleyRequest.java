package com.bnsgfxample.loadingfragmentsample.activities.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * volley get post请求
 * @author wenjundu 2015-07-03
 */
public class VolleyRequest {

	RequestQueue requestQueue = null;

	public static void GetRequest(Context context,String url,final HttpRequestCallBack callback){

		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.GET, url, null,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						if(callback!=null)
							callback.onSuccess(response);
					}
				}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				if(callback!=null)
					callback.onFailure(error.toString());
			}

		});
		VolleyRequest.getInstance().requestQueue.add(jsonObjectRequest);
	}

	static VolleyRequest instance;

	public static VolleyRequest getInstance() {
		if (instance == null) {
			instance = new VolleyRequest();
		}
		return instance;
	}
	//volley get操作 保证cookie一致




	public interface  HttpRequestCallBack {
		public void onSuccess(JSONObject jsonObject);
		public  void onFailure(String fail);
	}


}
