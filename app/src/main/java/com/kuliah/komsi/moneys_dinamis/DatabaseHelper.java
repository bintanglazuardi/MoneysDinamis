package com.kuliah.komsi.moneys_dinamis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_transaksi.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "transaksi_table";
    public static final String COL_ID = "ID";
    public static final String COL_NAMA = "NAMA";
    public static final String COL_NOMINAL = "NOMINAL";
    public static final String COL_TANGGAL = "TANGGAL";
    public static final String COL_KATEGORI = "KATEGORI";
//    public static final String COL_CATATAN = "CATATAN";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAMA + " TEXT, " +
                COL_NOMINAL + " TEXT, " +
                COL_TANGGAL + " TEXT, " +
                COL_KATEGORI + " TEXT )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addTransaksi(Transaksi transaksi){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAMA, transaksi.getNama());
        contentValues.put(COL_NOMINAL, transaksi.getNominal());
        contentValues.put(COL_TANGGAL, transaksi.getTanggal());
        contentValues.put(COL_KATEGORI, transaksi.getPhoto());
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllTransaksis(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
    }

    public boolean updateTransaksi(Transaksi transaksi, int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAMA, transaksi.getNama());
        contentValues.put(COL_NOMINAL, transaksi.getNominal());
        contentValues.put(COL_TANGGAL, transaksi.getTanggal());
        contentValues.put(COL_KATEGORI, transaksi.getPhoto());

        int update = sqLiteDatabase.update(TABLE_NAME, contentValues, COL_ID + " = ? ",
                new String[]{String.valueOf(id)} );
        if (update != 1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getTransaksiID(Transaksi transaksi){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME  +
                " WHERE " + COL_NAMA + " = '" + transaksi.getNama() + "'" +
                " AND " + COL_NOMINAL + " = '" + transaksi.getNominal() + "'";
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public Integer deleteTransaksi(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[] {String.valueOf(id)});
    }
}
