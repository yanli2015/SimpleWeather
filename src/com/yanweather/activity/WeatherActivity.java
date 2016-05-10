package com.yanweather.activity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yanweather.app.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


public class WeatherActivity extends Activity {

	private LinearLayout weatherInfoLayout;
	private TextView cityNameText;
	private TextView publishText;
	private TextView weatherDespText;
	private TextView temp1Text;
	private TextView temp2Text;
	private TextView pressText;
	private TextView humidityText;
	private TextView currentDateText;
	private String key = "a33fcb817d8e8886f94acaea51c12e89";
	private String temp1;
	private String temp2;
	private String press;
	private String humidity;
	private String weatherDesp;
	private String currentDate;
	private String cityName;
	public static final int UPDATE_TEXT=1;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch(msg.what){
			case UPDATE_TEXT:
				temp1Text.setText(temp1);
				temp2Text.setText(temp2);
				pressText.setText("pressure: "+press);
				humidityText.setText("humidity: "+humidity);
				weatherDespText.setText(weatherDesp);
				 publishText.setText("city ");
				currentDateText.setText("today:"+currentDate);
				Log.d("4444", "4444");
				break;
				
			default:
				break;
			}
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
		cityNameText = (TextView) findViewById(R.id.city_name);
		publishText = (TextView) findViewById(R.id.publish_text);
		weatherDespText = (TextView) findViewById(R.id.weather_desp);
		temp1Text = (TextView) findViewById(R.id.temp1);
		temp2Text = (TextView) findViewById(R.id.temp2);
		pressText = (TextView) findViewById(R.id.press);
		humidityText = (TextView) findViewById(R.id.humidity);
		currentDateText = (TextView) findViewById(R.id.current_date);
//		weatherInfoLayout.setVisibility(View.VISIBLE);
//		cityNameText.setVisibility(View.VISIBLE);
		Intent intent = getIntent();
		String cityName = intent.getStringExtra("city_name");
		
		Log.d("cityName", cityName);
		queryWeatherInfoByCity(cityName);

	}

	private void queryWeatherInfoByzip(String zipcode) {

		String address = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipcode + ",us&APPID=" + key;
		queryFromServer(address, "zipcode");
	}

	private void queryWeatherInfoByCity(String cityName) {
		String address = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",us&APPID=" + key;
		queryFromServer(address, "cityName");

	}

	private void queryFromServer(final String address, final String type) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Log.d("11111111111", "iiiiiiii");
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(address);
					HttpResponse httpResponse;
					httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity, "utf-8");
						parseJSONWithJSONObject(response);
						Message message = new Message();
						message.what = UPDATE_TEXT;
						handler.sendMessage(message);					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}).start();

	}

	private void parseJSONWithJSONObject(String response) throws JSONException {
		Log.d("2222", "2222");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
		currentDate=sdf.format(new Date());
		
		JSONObject obj = new JSONObject(response);
		 JSONObject child=obj.getJSONObject("main");
		  temp1 = child.getString("temp_min");
		 temp2 =  child.getString("temp_max");
		  press = child.getString("pressure");
	     humidity =  child.getString("humidity");
	     JSONArray jsonArray=obj.getJSONArray("weather");
         for(int i=0;i<jsonArray.length();i++)
         {
             JSONObject wether=jsonArray.getJSONObject(i);
             weatherDesp= wether.getString("main");
         }
	     
//         JSONObject child3=obj.getJSONObject("name");
//        		cityName = child3.toString();
//	
			Log.d("3333", "3333");
			
			
		}
		
		
		
			
		
			//String cityName = reader.getString("name");
			
			//cityNameText.setText(cityName);
			
			
		}
		
		
		// currentDateText.setText(prefs.getString("current_date", ""));
		

	
	// public static void sendHttpRequest(final String address, final
	// HttpCallbackListener listener){
	// new Thread(new Runnable(){
	// public void run(){
	// HttpURLConnection connection = null;
	// try{
	// URL url = new URL(address);
	// connection = (HttpURLConnection)url.openConnection();
	// connection.setRequestMethod("GET");
	// connection.setConnectTimeout(10000);
	// connection.setReadTimeout(10000);
	// InputStream in = connection.getInputStream();
	// BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	// StringBuilder response = new StringBuilder();
	// String line;
	// while((line = reader.readLine()) != null ) {
	// response.append(line);
	// Log.d("myHttp", line);
	// }
	// if(listener != null ){
	// listener.onFinish(response.toString());
	// }
	//
	// }catch(Exception e){
	// if(listener != null){
	// listener.onError(e);
	// }
	// }finally{
	// if (connection != null){
	// connection.disconnect();
	// }
	// }
	// }
	// }).start();
	// }

