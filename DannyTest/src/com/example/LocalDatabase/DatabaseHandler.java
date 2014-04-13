package com.example.LocalDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
	
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_NAME = "android_api";
	
	
	private static final String TABLE_ROOM = "room";
	private static final String KEY_ROOMID = "roomID";
	private static final String KEY_BEZEICHNUNG = "bezeichnung";
	private static final String KEY_ETAGE = "etage";
	private static final String KEY_TIMESTAMP = "timeStamp";
	
	

	
	public DatabaseHandler(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public void onCreate(SQLiteDatabase db) 
    {
        String CREATE_ROOM_TABLE = "CREATE TABLE " + TABLE_ROOM + "("
                + KEY_ROOMID + " TEXT PRIMARY KEY,"
                + KEY_BEZEICHNUNG + " TEXT,"
                + KEY_TIMESTAMP + " TEXT,"
                + KEY_ETAGE + " TEXT" + ")";
        db.execSQL(CREATE_ROOM_TABLE);

    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	}
