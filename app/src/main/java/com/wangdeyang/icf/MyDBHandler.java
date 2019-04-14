package com.wangdeyang.icf;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.sql.SQLInput;

public class MyDBHandler extends SQLiteOpenHelper{
    // informatino of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "patientDB.db";
    public static final String TABLE_NAME = "Patient";
    public static final String COLUMN_ID = "ResearchID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_RESULT = "Result";
    public static final String COLUMN_DECISION = "Decision";

    // Initialize DB
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    // Create the Patient table
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARYKEY, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_RESULT + " TEXT, "
                + COLUMN_DECISION + " BIT );";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    // Get all data from Patient table
    public String loadHandler() {
        // Result store in string format
        String result = "";

        String query = "SELECT * FROM " + TABLE_NAME;    // Select all
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        /*
        * Cursor:
        * 0 - int research ID
        * 1 - string name
        * 2 - wrongs
        * 3 - bit(int) decision
        * */

        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0); // Research id
            String result_1 = cursor.getString(1); // name
            String result_2 = cursor.getString(2); // wrong answers
            int result_3 = cursor.getInt(3); // decision

            result += String.valueOf(result_0) + " " + result_1 + " " + result_2 + " " + String.valueOf(result_3)
                    + System.getProperty("line.separator");
        }

        cursor.close();
        db.close();
        return result;
    }

    // Add a patient to the DB
    public void addHandler(Patient patient) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, patient.getID());
        values.put(COLUMN_NAME, patient.getName());
        values.put(COLUMN_RESULT, patient.getWrongs());
        values.put(COLUMN_DECISION, patient.getDecisoin());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Find a patient according to his research ID
    public Patient findHandler(int _researchID) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "='" + String.valueOf(_researchID) + "';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Patient patient = new Patient();
        if (cursor.moveToFirst()) {
            patient.setID(Integer.parseInt(cursor.getString(0)));
            patient.setName(cursor.getString(1));
            patient.setWrongs(cursor.getString(2));
            patient.setDecision(Integer.parseInt(cursor.getString(3)));

            cursor.close();
        } else {
            patient = null;
        }

        db.close();
        return patient;
    }

    // Delete a patient from db
    public boolean deleteHandler(int _researchID) {
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "='" + String.valueOf(_researchID) + "';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Patient patient = new Patient();
        if (cursor.moveToFirst()) {
            patient.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[] {
                    String.valueOf(patient.getID())
            });
            cursor.close();
            result = true;
        }

        db.close();
        return result;
    }

    // Update teach back result for a specific patient
    // Return success or not
    public boolean teachbackHandler(int _researchID, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        Patient patient = findHandler(_researchID);

        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, patient.getID());
        args.put(COLUMN_NAME, patient.getName());
        args.put(COLUMN_RESULT, answer); // update here
        args.put(COLUMN_DECISION, patient.getDecisoin());

        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + _researchID, null) > 0;
    }

    // Update decision for a specific patient
    // Return success or not
    public boolean decisionHandler(int _researchID, int _decision) {
        SQLiteDatabase db = this.getWritableDatabase();
        Patient patient = findHandler(_researchID);

        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, patient.getID());
        args.put(COLUMN_NAME, patient.getName());
        args.put(COLUMN_RESULT, patient.getWrongs()); // update here
        args.put(COLUMN_DECISION, _decision);

        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + _researchID, null) > 0;
    }
}
