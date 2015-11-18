package appewtc.masterung.aectrips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Atom on 11/18/2015.
 */
public class CommunityTABLE {

    //Explicit ประกาศตัวแปร
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String COMMUNITY_TABLE = "communityTABLE";
    public static final String COLUMN_ID_COMMUNITY = "_id";
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

    // Read All Data การอ่านค่าใน TABLE
    public String[] readAllData(int intColumn) {

        String[] strResult = null;

        Cursor objCursor = readSqLiteDatabase.query(COMMUNITY_TABLE,
                new String[]{COLUMN_ID_COMMUNITY, COLUMN_THWORD, COLUMN_THSOUND,
                        COLUMN_LAWORD, COLUMN_LASOUND, COLUMN_VNWORD, COLUMN_VNSOUND, COLUMN_SGWORD, COLUMN_SGSOUND,
                        COLUMN_PHWORD, COLUMN_PHSOUND, COLUMN_MMWORD, COLUMN_MMSOUND, COLUMN_IDWORD, COLUMN_IDSOUND,
                        COLUMN_CBWORD, COLUMN_CBSOUND, COLUMN_BNWORD, COLUMN_BNSOUND, COLUMN_MYWORD, COLUMN_MYSOUND},
                null, null, null, null, null);

        if (objCursor != null) {

            strResult = new String[objCursor.getCount()];
            objCursor.moveToFirst();

            for (int i = 0; i < objCursor.getCount(); i++) {

                switch (intColumn) {
                    case 1:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_THWORD));
                        break;
                    case 2:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_THSOUND));
                        break;
                    case 3:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LAWORD));
                        break;
                    case 4:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LASOUND));
                        break;
                    case 5:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_VNWORD));
                        break;
                    case 6:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_VNSOUND));
                        break;
                    case 7:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SGWORD));
                        break;
                    case 8:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SGSOUND));
                        break;
                    case 9:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PHWORD));
                        break;
                    case 10:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PHSOUND));
                        break;
                    case 11:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MMWORD));
                        break;
                    case 12:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MMSOUND));
                        break;
                    case 13:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_IDWORD));
                        break;
                    case 14:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_IDSOUND));
                        break;
                    case 15:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_CBWORD));
                        break;
                    case 16:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_CBSOUND));
                        break;
                    case 17:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_BNWORD));
                        break;
                    case 18:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_BNSOUND));
                        break;
                    case 19:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MYWORD));
                        break;
                    case 20:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_MYSOUND));
                        break;
                }   // swift

                objCursor.moveToNext();
            }   // for

        }   //if

        return strResult;
    }


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
