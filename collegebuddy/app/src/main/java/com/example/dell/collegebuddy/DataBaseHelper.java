package com.example.dell.collegebuddy;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Schedule";

    public static final String TABLE_NAME_MONDAY = "timetable_monday";
    public static final String TABLE_NAME_TUESDAY = "timetable_tuesday";
    public static final String TABLE_NAME_WEDNESDAY = "timetable_wednesday";
    public static final String TABLE_NAME_THURSDAY = "timetable_thursday";
    public static final String TABLE_NAME_FRIDAY = "timetable_friday";
    public static final String TABLE_NAME_SATURDAY = "timetable_saturday";
    public static final String TABLE_NAME_SUNDAY = "timetable_sunday";

    public static String COL_1 = "ID";
    public static final String COL_2 = "Subject";
    public static final String COL_3 = "Start_Time";
    public static final String COL_4 = "End_Time";

    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME , null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME_MONDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME_TUESDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME_WEDNESDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME_THURSDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME_FRIDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME_SATURDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME_SUNDAY + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR);");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MONDAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TUESDAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_WEDNESDAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_THURSDAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FRIDAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SATURDAY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SUNDAY);
        onCreate(db);
    }


    // to check table for monday

    public boolean isEmptyMonday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_MONDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    // to check table for tuesday

    public boolean isEmptyTuesday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_TUESDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    // to check table for wednesday

    public boolean isEmptyWednesday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_WEDNESDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    // to check table for thursday

    public boolean isEmptyThursday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_THURSDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    // to check table for fridayday

    public boolean isEmptyFriday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_FRIDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    // to check table for saturday

    public boolean isEmptySaturday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_SATURDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    // to check table for sunday

    public boolean isEmptySunday() {
        boolean flag;
        String query = ("Select " + COL_1 + " from " + TABLE_NAME_SUNDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        if (count == 0) {
            flag = false;
        } else flag = true;

        return flag;
    }

    //Here ALL the things are related to the insertion of the data


    //first the data for insertion in table monday.

    public boolean insertDataMonday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_MONDAY, null, contentValues);
        return true;
    }

    public int returnidnoMonday()
    {
     //String query = "SELECT"+COL_1+"FROM"+TABLE_NAME_MONDAY+"WHERE"+COL_1+"IS MAX"   ;
       // COL_1=COL_1+1;
        //return COL_1;

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_MONDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public boolean insertDataTuesday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_TUESDAY, null, contentValues);
        return true;
    }

    public int returnidnoTuesday()
    {
        //String query = "SELECT"+COL_1+"FROM"+TABLE_NAME_MONDAY+"WHERE"+COL_1+"IS MAX"   ;
        // COL_1=COL_1+1;
        //return COL_1;

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_TUESDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public int returnidnoWednesday()
    {
        //String query = "SELECT"+COL_1+"FROM"+TABLE_NAME_MONDAY+"WHERE"+COL_1+"IS MAX"   ;
        // COL_1=COL_1+1;
        //return COL_1;

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_WEDNESDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public int returnidnoThursday()
    {
        //String query = "SELECT"+COL_1+"FROM"+TABLE_NAME_MONDAY+"WHERE"+COL_1+"IS MAX"   ;
        // COL_1=COL_1+1;
        //return COL_1;

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_THURSDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public int returnidnoFriday()
    {
        //String query = "SELECT"+COL_1+"FROM"+TABLE_NAME_MONDAY+"WHERE"+COL_1+"IS MAX"   ;
        // COL_1=COL_1+1;
        //return COL_1;

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_FRIDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public int returnidnoSaturday()
    {
        //String query = "SELECT"+COL_1+"FROM"+TABLE_NAME_MONDAY+"WHERE"+COL_1+"IS MAX"   ;
        // COL_1=COL_1+1;
        //return COL_1;

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_SATURDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public int returnidnoSunday()
    {

        String query = ("Select " + COL_1 + " from " + TABLE_NAME_SUNDAY);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        int id = cursor.getInt(0);

        return (id+1);
    }

    public boolean insertDataWednesday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_WEDNESDAY, null, contentValues);
        return true;
    }

    public boolean insertDataThursday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_THURSDAY, null, contentValues);
        return true;
    }

    public boolean insertDataFriday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_FRIDAY, null, contentValues);
        return true;
    }

    public boolean insertDataSaturday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_SATURDAY, null, contentValues);
        return true;
    }

    public boolean insertDataSunday(String subject, String starttime, String endtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, subject);
        contentValues.put(COL_3, starttime);
        contentValues.put(COL_4, endtime);
        long result = db.insert(TABLE_NAME_SUNDAY, null, contentValues);
        return true;
    }


    //here all the things are related to linking to the list
    //first monday.


    public List<DatabaseModel> getAllData() {
        List<DatabaseModel> modelList = new ArrayList<DatabaseModel>();
        String query = "select * from " + TABLE_NAME_MONDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModel model = new DatabaseModel();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }

    //now Tuesday
    public List<DatabaseModelTuesday> getAllDataTuesday() {
        List<DatabaseModelTuesday> modelList = new ArrayList<DatabaseModelTuesday>();
        String query = "select * from " + TABLE_NAME_TUESDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelTuesday model = new DatabaseModelTuesday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }

    //now wednesday
    public List<DatabaseModelWednesday> getAllDataWednesday() {
        List<DatabaseModelWednesday> modelList = new ArrayList<DatabaseModelWednesday>();
        String query = "select * from " + TABLE_NAME_WEDNESDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelWednesday model = new DatabaseModelWednesday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }

    //Thursday
    public List<DatabaseModelThursday> getAllDataThursday() {
        List<DatabaseModelThursday> modelList = new ArrayList<DatabaseModelThursday>();
        String query = "select * from " + TABLE_NAME_THURSDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelThursday model = new DatabaseModelThursday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }

    //Friday
    public List<DatabaseModelFriday> getAllDataFriday() {
        List<DatabaseModelFriday> modelList = new ArrayList<DatabaseModelFriday>();
        String query = "select * from " + TABLE_NAME_FRIDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelFriday model = new DatabaseModelFriday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }

    //saturday
    public List<DatabaseModelSaturday> getAllDataSaturday() {
        List<DatabaseModelSaturday> modelList = new ArrayList<DatabaseModelSaturday>();
        String query = "select * from " + TABLE_NAME_SATURDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelSaturday model = new DatabaseModelSaturday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }

    //sunday
    public List<DatabaseModelSunday> getAllDataSunday() {
        List<DatabaseModelSunday> modelList = new ArrayList<DatabaseModelSunday>();
        String query = "select * from " + TABLE_NAME_SUNDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelSunday model = new DatabaseModelSunday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("student data", modelList.toString());
        return modelList;
    }


    //here every thing is related to extract the data from respective database and table name
    //first monday
    public List<DatabaseModel> getDataFromDB() {
        List<DatabaseModel> modelList = new ArrayList<DatabaseModel>();
        String query = "select * from " + TABLE_NAME_MONDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModel model = new DatabaseModel();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }

    //tuesday
    public List<DatabaseModelTuesday> getDataFromDBTuesday() {
        List<DatabaseModelTuesday> modelList = new ArrayList<DatabaseModelTuesday>();
        String query = "select * from " + TABLE_NAME_TUESDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelTuesday model = new DatabaseModelTuesday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }

    //wednesday
    public List<DatabaseModelWednesday> getDataFromDBWednesday() {
        List<DatabaseModelWednesday> modelList = new ArrayList<DatabaseModelWednesday>();
        String query = "select * from " + TABLE_NAME_WEDNESDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelWednesday model = new DatabaseModelWednesday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }

    //thursday
    public List<DatabaseModelThursday> getDataFromDBThursday() {
        List<DatabaseModelThursday> modelList = new ArrayList<DatabaseModelThursday>();
        String query = "select * from " + TABLE_NAME_THURSDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelThursday model = new DatabaseModelThursday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }

    //friday
    public List<DatabaseModelFriday> getDataFromDBFriday() {
        List<DatabaseModelFriday> modelList = new ArrayList<DatabaseModelFriday>();
        String query = "select * from " + TABLE_NAME_FRIDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelFriday model = new DatabaseModelFriday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }

    //saturday
    public List<DatabaseModelSaturday> getDataFromDBSaturday() {
        List<DatabaseModelSaturday> modelList = new ArrayList<DatabaseModelSaturday>();
        String query = "select * from " + TABLE_NAME_SATURDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelSaturday model = new DatabaseModelSaturday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }

    //sunday
    public List<DatabaseModelSunday> getDataFromDBSunday() {
        List<DatabaseModelSunday> modelList = new ArrayList<DatabaseModelSunday>();
        String query = "select * from " + TABLE_NAME_SUNDAY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseModelSunday model = new DatabaseModelSunday();
                model.setId(cursor.getString(0));
                model.setSubject_name(cursor.getString(1));
                model.setStarting_time(cursor.getString(2));
                model.setEnd_time(cursor.getString(3));

                modelList.add(model);
            } while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());

        return modelList;
    }


    public Integer deleteDataMonday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_MONDAY, "ID = ?", new String[]{id});

    }

    public Integer deleteDataTuesday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_TUESDAY, "ID = ?", new String[]{id});

    }

    public Integer deleteDataWednesday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_WEDNESDAY, "ID = ?", new String[]{id});
    }

    public Integer deleteDataThursday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_THURSDAY, "ID = ?", new String[]{id});
    }

    public Integer deleteDataFriday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_FRIDAY, "ID = ?", new String[]{id});
    }

    public Integer deleteDataSaturday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_SATURDAY, "ID = ?", new String[]{id});
    }

    public Integer deleteDataSunday(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_SUNDAY, "ID = ?", new String[]{id});
    }


    public boolean updateDataMonday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_MONDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }


    public boolean updateDataTuesday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_TUESDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public boolean updateDataWednesday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_WEDNESDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public boolean updateDataThursday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_THURSDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public boolean updateDataFriday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_FRIDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public boolean updateDataSaturday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_SATURDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public boolean updateDataSunday(String id,String subject,String starttime,String endtime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,starttime);
        contentValues.put(COL_4,endtime);
        db.update(TABLE_NAME_SUNDAY,contentValues,"ID = ?",new String[]{id});
        return true;
    }

}

