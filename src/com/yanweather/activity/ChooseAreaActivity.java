package com.yanweather.activity;

import java.util.ArrayList;
import java.util.List;

import com.yanweather.app.R;
import com.yanweather.model.City;
import com.yanweather.model.State;
import com.yanweather.model.YanWeatherDB;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChooseAreaActivity extends Activity {
	public static final int LEVEL_STATE = 0;
	public static final int LEVEL_CITY = 1;
	private TextView titleText;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private YanWeatherDB yanWeatherDB;
	private List<String> dataList = new ArrayList<String>();
	private List<State> stateList;
	private List<City> cityList;
	private State selectedState;
	private City selectedCity;
	private int currentLevel;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		if (prefs.getBoolean("city_seleted", false)) {
			System.out.println("++++" );
		//	Log.d("ChooseActivity", "onCreate");
			Intent intent = new Intent(this, WeatherActivity.class);
			startActivity(intent);
			finish();
			return;
		}
		System.out.println("aaaaa" );
		Log.d("ChooseActivity", "onCreate");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_area);
		listView = (ListView) findViewById(R.id.list_view);
		titleText = (TextView) findViewById(R.id.title_text);
		adapter = new ArrayAdapter<String>(ChooseAreaActivity.this, android.R.layout.simple_list_item_1, dataList);
		listView.setAdapter(adapter);
		yanWeatherDB = YanWeatherDB.getInstance(ChooseAreaActivity.this);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {
				if (currentLevel == LEVEL_STATE) {
					selectedState = stateList.get(index);
					System.out.println("***********" );
					queryCities();
				} else if (currentLevel == LEVEL_CITY) {
					selectedCity = cityList.get(index);
					String cityName = cityList.get(index).getCityName();
					System.out.println("***********" + cityName);
					Intent intent = new Intent(ChooseAreaActivity.this, WeatherActivity.class);
					intent.putExtra("city_name", cityName);
					Log.d("cityName - chooseArea", cityName);
					startActivity(intent);
					finish();
				}
			}
		});

		queryStates();
	}

	private void queryStates() {
		stateList = yanWeatherDB.loadStates();

		dataList.clear();
		for (State state : stateList) {
			dataList.add(state.getStateName());
			
		}
		adapter.notifyDataSetChanged();
		listView.setSelection(0);
		titleText.setText("United State");
		currentLevel = LEVEL_STATE;
	}

	private void queryCities() {
		cityList = yanWeatherDB.loadCities(selectedState.getStateCode());
		dataList.clear();
		for (City city : cityList) {
			dataList.add(city.getCityName());
		}
		adapter.notifyDataSetChanged();
		listView.setSelection(0);
		titleText.setText(selectedState.getStateName());
		currentLevel = LEVEL_CITY;
	}

	public void onBackPressed() {
		if (currentLevel == LEVEL_STATE) {
			queryCities();
		} else if (currentLevel == LEVEL_CITY) {
			queryStates();
		} else {
			finish();
		}
	}
}
