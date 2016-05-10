package com.yanweather.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class Utility {
	
	public static void handleWeatherResponse(Context context, String response) {
		try {
			
			JSONObject reader = new JSONObject(response);
			JSONObject sys = reader.getJSONObject("weather");
			String weatherDesp =sys.getString("description");
			JSONObject main = reader.getJSONObject("main");
			String temp1 = main.getString("temp_min");
			String temp2 = main.getString("temp_max");
			String press =  main.getString("pressure");
			String humidity = main.getString("humidity");
			String cityName = reader.getString("name");
			saveWeatherInfo(context, cityName, temp1, temp2, weatherDesp,  press, humidity);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public static void saveWeatherInfo(Context context, String cityName, String temp1, String temp2, String weatherDesp,
			 String press, String humidity) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putBoolean("city_selected", true);
		editor.putString("city_name", cityName);
		editor.putString("temp1", temp1);
		editor.putString("temp2", temp2);
		editor.putString("weather_desp", weatherDesp);
		editor.putString("press", press);
		editor.putString("humidity", humidity);
		editor.putString("current_data", sdf.format(new Date()));
		editor.commit();
		Log.d("##########","################");

	}

}
