package com.yanweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class YanWeatherOpenHelper extends SQLiteOpenHelper {
	
	public static final String CREATE_STATE="create table State("
			+"id integer primary key autoincrement,"
			+"state_name text, "
			+"state_code text)";
	
	public static final String CREATE_CITY="create table City("
			+"id integer primary key autoincrement,"
			+"city_name text, "
			+" state_code text,"
			+ "FOREIGN KEY(state_code) REFERENCES State(state_code))";

	public YanWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String stateName = "state_name";
		String stateCode = "state_code";
		String cityName = "city_name";
		
		// TODO Auto-generated method stub
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_STATE);
		ContentValues values = new ContentValues();
		values.put(stateName,"Alaska");
		values.put( stateCode, "AK");
		db.insert("State", null,values);
		Log.d("YanWeatherOpenHelper_addState", "Alaska");
		values.clear();
		values.put(stateName,"Alabama");
		values.put( stateCode, "AL");
		db.insert("State", null,values);
		Log.d("YanWeatherOpenHelper_addState", "Alabama");
		values.clear();
		values.put(stateName,"California");
		values.put( stateCode, "CA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Arkansas");
		values.put( stateCode, "AR");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Arizona");
		values.put( stateCode, "AZ");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Virginia");
		values.put( stateCode, "VA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Vermont");
		values.put( stateCode, "VT");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Arkansas");
		values.put( stateCode, "AR");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Washington");
		values.put( stateCode, "WA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Wisconsin");
		values.put( stateCode, "WI");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"West Virginia");
		values.put( stateCode, "WV");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Wyoming");
		values.put( stateCode, "WY");
		db.insert("State", null,values);
		
		values.clear();
		values.put(stateName,"Colorado");
		values.put( stateCode, "CO");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Connecticut");
		values.put( stateCode, "CT");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"District of Columbia");
		values.put( stateCode, "DC");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Delaware");
		values.put( stateCode, "DE");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Florida");
		values.put( stateCode, "FL");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Georgia");
		values.put( stateCode, "GA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"New York");
		values.put( stateCode, "NY");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Maryland");
		values.put( stateCode, "MD");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Massachusetts");
		values.put( stateCode, "MA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Hawaii");
		values.put( stateCode, "HI");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Iowa");
		values.put( stateCode, "IA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Idaho");
		values.put( stateCode, "ID");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Illinois");
		values.put( stateCode, "IL");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Indiana");
		values.put( stateCode, "IN");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Kansas");
		values.put( stateCode, "KS");
		db.insert("State", null,values);
		//
		values.clear();
		values.put(stateName,"Kentucky");
		values.put( stateCode, "KY");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Louisiana");
		values.put( stateCode, "LA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Maine");
		values.put( stateCode, "ME");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Michigan");
		values.put( stateCode, "MI");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Minnesota");
		values.put( stateCode, "MN");
		db.insert("State", null,values);
		//
		values.clear();
		values.put(stateName,"Missouri");
		values.put( stateCode, "MO");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Mississippi");
		values.put( stateCode, "MS");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Montana");
		values.put( stateCode, "MI");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Minnesota");
		values.put( stateCode, "MT");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"North Carolina");
		values.put( stateCode, "NC");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"North Dakota");
		values.put( stateCode, "ND");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Nebraska");
		values.put( stateCode, "NE");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"New Hampshire");
		values.put( stateCode, "NH");
		db.insert("State", null,values);
		//
		values.clear();
		values.put(stateName,"New Jersey");
		values.put( stateCode, "NJ");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"New Mexico");
		values.put( stateCode, "NM");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Nevada");
		values.put( stateCode, "NV");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Ohio");
		values.put( stateCode, "OH");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Oklahoma");
		values.put( stateCode, "OK");
		db.insert("State", null,values);
		
		//
		values.clear();
		values.put(stateName,"Oregon");
		values.put( stateCode, "OR");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Pennsylvania");
		values.put( stateCode, "PA");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Rhode Island");
		values.put( stateCode, "RI");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"South Carolina");
		values.put( stateCode, "SC");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"South Dakota");
		values.put( stateCode, "SD");
		db.insert("State", null,values);
		//
		values.clear();
		values.put(stateName,"Tennessee");
		values.put( stateCode, "TN");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Texas");
		values.put( stateCode, "TX");
		db.insert("State", null,values);
		values.clear();
		values.put(stateName,"Utah");
		values.put( stateCode, "UT");
		db.insert("State", null,values);
		
	
		//add city
		ContentValues values2 = new ContentValues();
		values2.put(cityName,"Alpine");
		values2.put( stateCode, "CA");
		db.insert("City", null,values2);
		Log.d("YanWeatherOpenHelper_addState__________city", "Alpine");
		values2.clear();
		values2.put(cityName,"Alta");
		values2.put( stateCode, "CA");
		db.insert("City", null,values2);
		Log.d("YanWeatherOpenHelper_addState__________city", "Alta");
		values2.clear();
		values2.put(cityName,"Altadena");
		values2.put( stateCode, "CA");
		db.insert("City", null,values2);
		Log.d("YanWeatherOpenHelper_addState__________city", "Altadena");
		values2.clear();
		values2.put(cityName,"Anderson");
		values2.put( stateCode, "CA");
		db.insert("City", null,values2);
		values2.clear();
		values2.put(cityName,"Fairfax");
		values2.put( stateCode, "VA");
		db.insert("City", null,values2);
		values2.clear();
		values2.put(cityName,"Sterling");
		values2.put( stateCode, "VA");
		db.insert("City", null,values2);
		values2.clear();
		values2.put(cityName,"Manassa");
		values2.put( stateCode, "VA");
		db.insert("City", null,values2);
		values2.clear();
		values2.put(cityName,"Reston");
		values2.put( stateCode, "VA");
		db.insert("City", null,values2);
		values2.clear();
		values2.put(cityName,"Gainsville");
		values2.put( stateCode, "VA");
		db.insert("City", null,values2);
		values2.clear();
		values2.put(cityName,"Woodbridge");
		values2.put( stateCode, "VA");
		db.insert("City", null,values2);
		values2.clear();
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
