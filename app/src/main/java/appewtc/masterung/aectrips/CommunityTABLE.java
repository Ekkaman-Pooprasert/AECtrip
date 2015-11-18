package appewtc.masterung.aectrips;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Atom on 11/18/2015.
 */
public class CommunityTABLE {

    //Explicit ประกาศตัวแปร
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String COMMUNITY_TABLE = "communityTABLE";
    public static final String COLUMN_THWORD = "THword";
    public static final String COLUMN_THSOUND = "THsound";
    public static final String COLUMN_LAWORD = "LAword";
    public static final String COLUMN_LASOUND = "LAsound";
    public static final String COLUMN_VNWORD = "VNword";
    public static final String COLUMN_VNSOUND = "VNsound";
    public static final String COLUMN_SGWORD = "SGword";
    public static final String COLUMN_SGSOUND = "SGsound";
    public static final String COLUMN_PHWORD = "PHword";
    public static final String COLUMN_PHSOUND = "PHsound";
    public static final String COLUMN_MMWORD = "MMword";
    public static final String COLUMN_MMSOUND = "MMsound";
    public static final String COLUMN_IDWORD = "IDword";
    public static final String COLUMN_IDSOUND = "IDsound";
    public static final String COLUMN_CBWORD = "CBword";
    public static final String COLUMN_CBSOUND = "CBsound";
    public static final String COLUMN_BNWORD = "BNword";
    public static final String COLUMN_BNSOUND = "BNsound";
    public static final String COLUMN_MYWORD = "MYword";
    public static final String COLUMN_MYSOUND = "MYsound";

    public CommunityTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor เชื่อมต่อกับฐานข้อมูล

    public long addCommunity(String thword, String thsound,
                             String laword, String lasound,
                             String vnword, String vnsound,
                             String sgword, String sgsound,
                             String phword, String phsound,
                             String mmword, String mmsound,
                             String idword, String idsound,
                             String cbword, String cbsound,
                             String bnword, String bnsound,
                             String myword, String mysound) {
        //หิ้ว String ทั้ง20ตัวเข้าไปใน TABLE
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_THWORD, thword);
        objContentValues.put(COLUMN_THSOUND, thsound);
        objContentValues.put(COLUMN_LAWORD, laword);
        objContentValues.put(COLUMN_LASOUND, lasound);
        objContentValues.put(COLUMN_VNWORD, vnword);
        objContentValues.put(COLUMN_VNSOUND, vnsound);
        objContentValues.put(COLUMN_SGWORD, sgword);
        objContentValues.put(COLUMN_SGSOUND, sgsound);
        objContentValues.put(COLUMN_PHWORD, phword);
        objContentValues.put(COLUMN_PHSOUND, phsound);
        objContentValues.put(COLUMN_MMWORD, mmword);
        objContentValues.put(COLUMN_MMSOUND, mmsound);
        objContentValues.put(COLUMN_IDWORD, idword);
        objContentValues.put(COLUMN_IDSOUND, idsound);
        objContentValues.put(COLUMN_CBWORD, cbword);
        objContentValues.put(COLUMN_CBSOUND, cbsound);
        objContentValues.put(COLUMN_BNWORD, bnword);
        objContentValues.put(COLUMN_BNSOUND, bnsound);
        objContentValues.put(COLUMN_MYWORD, myword);
        objContentValues.put(COLUMN_MYSOUND, mysound);

        return writeSqLiteDatabase.insert(COMMUNITY_TABLE, null, objContentValues);
    }

}   //Main Class กำหนดขอบเขตคลาสหลัก
