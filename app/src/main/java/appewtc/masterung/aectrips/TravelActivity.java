package appewtc.masterung.aectrips;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TravelActivity extends AppCompatActivity {

    //Explicit
    private ListView communityListView;
    private int indexAnInt, forExtraAnInt, indexSoundAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        //Bind Widget
        communityListView = (ListView) findViewById(R.id.listView);

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        indexAnInt = getIntent().getIntExtra("index", 0);

        int[] iconInts = new int[10];
        iconInts[0] = R.drawable.thailand48;
        iconInts[1] = R.drawable.laos48;
        iconInts[2] = R.drawable.vietnam48;
        iconInts[3] = R.drawable.singapore48;
        iconInts[4] = R.drawable.philippines48;
        iconInts[5] = R.drawable.myanmar48;
        iconInts[6] = R.drawable.indonesia48;
        iconInts[7] = R.drawable.cambodia48;
        iconInts[8] = R.drawable.brunei48;
        iconInts[9] = R.drawable.malaysia48;

        CommunityTABLE objCommunityTABLE = new CommunityTABLE(this);

        String[] thaiStrings = objCommunityTABLE.readAllData(1);

        String[] wordStrings = objCommunityTABLE.readAllData(forExtra(indexAnInt));

        final String[] soundString = objCommunityTABLE.readAllData(forSound(indexAnInt));

        MyAdapter objMyAdapter = new MyAdapter(TravelActivity.this, iconInts[indexAnInt], thaiStrings, wordStrings);
        communityListView.setAdapter(objMyAdapter);

        communityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                indexSoundAnInt = soundEffect(indexAnInt, soundString[position]);

                MediaPlayer soundPlayer = MediaPlayer.create(getBaseContext(), indexSoundAnInt);
                soundPlayer.start();

                soundPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

            }   // event On Click
        });

    }   //Create ListView

    private int soundEffect(int indexAnInt, String soundString) {

        int intResult = R.raw.no1;

        switch (indexAnInt) {
            case 0:
                intResult = soundThai(soundString);
                break;
            case 1:
                intResult = soundLaos(soundString);
                break;
            case 2:
                intResult = soundVeitnam(soundString);
                break;
            case 3:
                intResult = soundSingapore(soundString);
                break;
            case 4:
                intResult = soundPhilippines(soundString);
                break;
            case 5:
                intResult = soundMyanmar(soundString);
                break;
            case 6:
                intResult = soundIndonesia(soundString);
                break;
            case 7:
                intResult = soundCombodia(soundString);
                break;
            case 8:
                intResult = soundBrunei(soundString);
                break;
            case 9:
                intResult = soundMalaysia(soundString);
                break;
        }   //switch

        return intResult;
    }   // soundEffect เสียงประเทศ

    private int soundMalaysia(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("my1")) {
            intResult = R.raw.my1;
        } else if (soundString.equals("my2")) {
            intResult = R.raw.my2;
        } else if (soundString.equals("my3")) {
            intResult = R.raw.my3;
        } else if (soundString.equals("my4")) {
            intResult = R.raw.my4;
        } else if (soundString.equals("my5")) {
            intResult = R.raw.my5;
        } else if (soundString.equals("my6")) {
            intResult = R.raw.my6;
        } else if (soundString.equals("my7")) {
            intResult = R.raw.my7;
        } else if (soundString.equals("my8")) {
            intResult = R.raw.my8;
        } else if (soundString.equals("my9")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("my10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("my11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("my12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("my13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }// มาเลเซีย

        return intResult;
    }

    private int soundBrunei(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("bu1")) {
            intResult = R.raw.bn1;
        } else if (soundString.equals("bn2")) {
            intResult = R.raw.bn2;
        } else if (soundString.equals("bn3")) {
            intResult = R.raw.bn3;
        } else if (soundString.equals("bn4")) {
            intResult = R.raw.bn4;
        } else if (soundString.equals("bn5")) {
            intResult = R.raw.bn5;
        } else if (soundString.equals("bn6")) {
            intResult = R.raw.bn6;
        } else if (soundString.equals("bn7")) {
            intResult = R.raw.bn7;
        } else if (soundString.equals("bn8")) {
            intResult = R.raw.bn8;
        } else if (soundString.equals("bn9")) {
            intResult = R.raw.bn9;
        } else if (soundString.equals("bn10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("bn11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("bn12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("bn13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }// บรุไน

        return intResult;
    }

    private int soundCombodia(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("cb1")) {
            intResult = R.raw.cb1;
        } else if (soundString.equals("cb2")) {
            intResult = R.raw.cb2;
        } else if (soundString.equals("cb3")) {
            intResult = R.raw.cb3;
        } else if (soundString.equals("cb4")) {
            intResult = R.raw.cb4;
        } else if (soundString.equals("cb5")) {
            intResult = R.raw.cb5;
        } else if (soundString.equals("cb6")) {
            intResult = R.raw.cb6;
        } else if (soundString.equals("cb7")) {
            intResult = R.raw.cb7;
        } else if (soundString.equals("cb8")) {
            intResult = R.raw.cb8;
        } else if (soundString.equals("cb9")) {
            intResult = R.raw.cb9;
        } else if (soundString.equals("cb10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("cb11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("cb12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("cb13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }//กัมพูชา

        return intResult;
    }

    private int soundIndonesia(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("id1")) {
            intResult = R.raw.id1;
        } else if (soundString.equals("id8")) {
            intResult = R.raw.id8;
        } else if (soundString.equals("id10")) {
            intResult = R.raw.no1;
        } else if (soundString.equals("id11")) {
            intResult = R.raw.no1;
        } else {
            intResult = R.raw.no1;
        }//อินโดนีเซีย

        return intResult;
    }

    private int soundMyanmar(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("mm1")) {
            intResult = R.raw.mm1;
        } else if (soundString.equals("mm2")) {
            intResult = R.raw.mm2;
        } else if (soundString.equals("mm3")) {
            intResult = R.raw.mm3;
        } else if (soundString.equals("mm4")) {
            intResult = R.raw.mm4;
        } else if (soundString.equals("mm5")) {
            intResult = R.raw.mm5;
        } else if (soundString.equals("mm6")) {
            intResult = R.raw.mm6;
        } else if (soundString.equals("mm7")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("mm8")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("mm9")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("mm10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("mm11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("mm12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("mm13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }//เมียนม่า

        return intResult;
    }

    private int soundPhilippines(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("ph1")) {
            intResult = R.raw.ph1;
        } else if (soundString.equals("ph2")) {
            intResult = R.raw.ph2;
        } else if (soundString.equals("ph3")) {
            intResult = R.raw.ph3;
        } else if (soundString.equals("ph4")) {
            intResult = R.raw.ph4;
        } else if (soundString.equals("ph6")) {
            intResult = R.raw.ph6;
        } else if (soundString.equals("ph9")) {
            intResult = R.raw.ph9;
        } else if (soundString.equals("ph5")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("ph7")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("ph8")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("ph10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("ph11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("ph12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("ph13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }//ฟิลิปปิน

        return intResult;
    }

    private int soundSingapore(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("sg1")) {
            intResult = R.raw.sg1;
        } else if (soundString.equals("sg2")) {
            intResult = R.raw.sg2;
        } else if (soundString.equals("sg3")) {
            intResult = R.raw.sg3;
        } else if (soundString.equals("sg4")) {
            intResult = R.raw.sg4;
        } else if (soundString.equals("sg5")) {
            intResult = R.raw.sg5;
        } else if (soundString.equals("sg6")) {
            intResult = R.raw.sg6;
        } else if (soundString.equals("sg7")) {
            intResult = R.raw.sg7;
        } else if (soundString.equals("sg8")) {
            intResult = R.raw.sg8;
        } else if (soundString.equals("sg9")) {
            intResult = R.raw.sg9;
        } else if (soundString.equals("sg10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("sg11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("sg12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("sg13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }//สิงคโปร์

        return intResult;
    }

    private int soundVeitnam(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("vn1")) {
            intResult = R.raw.vn1;
        } else if (soundString.equals("vn2")) {
            intResult = R.raw.vn2;
        } else if (soundString.equals("vn3")) {
            intResult = R.raw.vn3;
        } else if (soundString.equals("vn4")) {
            intResult = R.raw.vn4;
        } else if (soundString.equals("vn5")) {
            intResult = R.raw.vn5;
        } else if (soundString.equals("vn6")) {
            intResult = R.raw.vn6;
        } else if (soundString.equals("vn7")) {
            intResult = R.raw.vn7;
        } else if (soundString.equals("vn8")) {
            intResult = R.raw.vn8;
        } else if (soundString.equals("vn9")) {
            intResult = R.raw.vn9;
        } else if (soundString.equals("vn10")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("vn11")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("vn12")) {
            intResult = R.raw.no1;//
        } else if (soundString.equals("vn13")) {
            intResult = R.raw.no1;//
        } else {
            intResult = R.raw.no1;
        }//เวียดนาม

        return intResult;
    }

    private int soundLaos(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("la2")) {
            intResult = R.raw.la2;
        } else if (soundString.equals("la3")) {
            intResult = R.raw.la3;
        } else if (soundString.equals("la4")) {
            intResult = R.raw.la4;
        } else if (soundString.equals("la5")) {
            intResult = R.raw.la5;
        } else if (soundString.equals("la6")) {
            intResult = R.raw.la6;
        } else if (soundString.equals("la8")) {
            intResult = R.raw.la8;
        } else if (soundString.equals("la9")) {
            intResult = R.raw.la9;
        } else if (soundString.equals("la10")) {
            intResult = R.raw.la10;
        } else if (soundString.equals("la11")) {
            intResult = R.raw.no1;
        } else if (soundString.equals("la12")) {
            intResult = R.raw.la12;
        } else if (soundString.equals("la7")) {
            intResult = R.raw.la7;
        } else if (soundString.equals("la1")) {
            intResult = R.raw.la1;
        } else if (soundString.equals("la13")) {
            intResult = R.raw.la13;
        } else {
            intResult = R.raw.no1;
        }//ลาว

        return intResult;
    }

    private int soundThai(String soundString) {
        int intResult = R.raw.no1;

        if (soundString.equals("th1")) {
            intResult = R.raw.th1;
        } else if (soundString.equals("th2")) {
            intResult = R.raw.th2;
        } else if (soundString.equals("th3")) {
            intResult = R.raw.th3;
        } else if (soundString.equals("th4")) {
            intResult = R.raw.th4;
        } else if (soundString.equals("th6")) {
            intResult = R.raw.th6;
        } else if (soundString.equals("th12")) {
            intResult = R.raw.th12;
        } else if (soundString.equals("th5")) {
            intResult = R.raw.th5;
        } else if (soundString.equals("th7")) {
            intResult = R.raw.th7;
        } else if (soundString.equals("th8")) {
            intResult = R.raw.th8;
        } else if (soundString.equals("th9")) {
            intResult = R.raw.th9;
        } else if (soundString.equals("th10")) {
            intResult = R.raw.th10;
        } else if (soundString.equals("th11")) {
            intResult = R.raw.th11;
        } else if (soundString.equals("th13")) {
            intResult = R.raw.th13;
        } else {
            intResult = R.raw.no1;
        }//ไทย

        return intResult;
    }

    private int forSound(int indexAnInt) {

        int intSound = 0;
        switch (indexAnInt) {
            case 0:
                intSound = 2;
                break;
            case 1:
                intSound = 4;
                break;
            case 2:
                intSound = 6;
                break;
            case 3:
                intSound = 8;
                break;
            case 4:
                intSound = 10;
                break;
            case 5:
                intSound = 12;
                break;
            case 6:
                intSound = 14;
                break;
            case 7:
                intSound = 16;
                break;
            case 8:
                intSound = 18;
                break;
            case 9:
                intSound = 20;
                break;
        }   // switch

        return intSound;
    }

    private int forExtra(int indexAnInt) {

        int intExtra = 0;
        switch (indexAnInt) {
            case 0:
                intExtra = 1;
                break;
            case 1:
                intExtra = 3;
                break;
            case 2:
                intExtra = 5;
                break;
            case 3:
                intExtra = 7;
                break;
            case 4:
                intExtra = 9;
                break;
            case 5:
                intExtra = 11;
                break;
            case 6:
                intExtra = 13;
                break;
            case 7:
                intExtra = 15;
                break;
            case 8:
                intExtra = 17;
                break;
            case 9:
                intExtra = 19;
                break;
        }

        return intExtra;
    }

}   // Main Class
