package com.yanweather.model;

import java.util.ArrayList;
import java.util.List;

import com.yanweather.db.YanWeatherOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class YanWeatherDB {
	public static final String DB_NAME = "yan_weather";
	public static final int VERSION=1;
	private static YanWeatherDB yanWeatherDB;
	private SQLiteDatabase db;
	
	private YanWeatherDB(Context context){
		YanWeatherOpenHelper dbHelper = new YanWeatherOpenHelper(context, DB_NAME,null, VERSION);
		db = dbHelper.getWritableDatabase();
		
	}
	public SQLiteDatabase getDB(){
		return db;
	}
	
	public synchronized static YanWeatherDB getInstance(Context context){
		if(yanWeatherDB == null) {
			yanWeatherDB =  new YanWeatherDB(context);
		}
		return yanWeatherDB;
	}
	
	public void saveState(State state){
		if (state != null){
			ContentValues values = new ContentValues();
			values.put("state_name", state.getStateName());
			values.put("state_code", state.getStateCode());
			db.insert("State", null, values);
			
		}
	}
	
	public List<State> loadStates(){
		List<State> list = new ArrayList<State>();
		Cursor cursor = db.query("State", null, null,  null, null,  null, null);
		if(cursor.moveToFirst()){
			do{
				State state = new State();
				state.setId(cursor.getInt(cursor.getColumnIndex("id")));
				state.setProvinceName(cursor.getString(cursor.getColumnIndex("state_name")));
				state.setProvinceCode(cursor.getString(cursor.getColumnIndex("state_code")));
				list.add(state);
			}while(cursor.moveToNext());
		}if(cursor != null){
			cursor.close();
		}
		return list;
	}
	
	public void saveCity(City city){
		if(city != null){
			ContentValues values = new ContentValues();
			values.put("city_name",city.getCityName());
			values.put("state_code", city.getStateCode());
			db.insert("City", null, values);
		}
	}
	
	public List<City> loadCities (String stateCode) {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City ", null, "state_code=?",new String[]{stateCode},null,null,null);
		if(cursor.moveToFirst()){
			do{
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setStateCode(stateCode);
				list.add(city);
		}while(cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;
	}
}
