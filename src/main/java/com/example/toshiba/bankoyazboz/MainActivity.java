package com.example.toshiba.bankoyazboz;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity {

    ArrayList list_oyuncu1 = new ArrayList();
    ArrayList list_oyuncu2 = new ArrayList();
    ArrayList list_oyuncu3 = new ArrayList();
    ArrayList list_oyuncu4 = new ArrayList();

    ArrayAdapter<String> adapter1;

    EditText sonuc_text;

    Button btn_banko_islemleri_kapat, btn_banko_yaz, btn_banko_oldur, btn_banko_iptal, btn_banko, btn_hesap_makinesi_kapat, btn_sil, btn_carpma, btn_esittir, btn_yazboza_ekle, btn_oyuncu_ekle, btn_oyun, btn_okey, btn_tur, btn_gosterge;

    FrameLayout banko_islemleri_frame, hesap_makinesi_ekrani_frame, oyuncu_isim_frame, yazboz_ekranı_frame;

    TextView son_iki_kisi_fark, txt_banko_islem_bilgileri, txt_el_sayisi, oyuncu_1_yazboz, oyuncu_2_yazboz, oyuncu_3_yazboz, oyuncu_4_yazboz, oyuncuadi, o1, o2, o3, o4, hesap_sonucu1, hesap_sonucu2, hesap_sonucu3, hesap_sonucu4;

    int sayi1 = 0, sayi2 = 0, islemsonucu = 0;

    LinearLayout liste1, liste2, liste3, liste4;

    ListView lt1, lt2, lt3, lt4;

    //MediaPlayer ses_asa_sende_kalsin_dayi, ses_aha;

    String sesli_komut = "kapali";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hesap_makinesi_ekrani_frame = (FrameLayout) findViewById(R.id.hesapmakinesiekrani);
        oyuncu_isim_frame = (FrameLayout) findViewById(R.id.oyuncu_isim_frame);
        yazboz_ekranı_frame = (FrameLayout) findViewById(R.id.yazbozekrani);
        banko_islemleri_frame = (FrameLayout) findViewById(R.id.banko_islemleri_frm);


        btn_hesap_makinesi_kapat = (Button) findViewById(R.id.layout_kapat);
        btn_sil = (Button) findViewById(R.id.sil);
        btn_carpma = (Button) findViewById(R.id.carpma_islemi);
        btn_esittir = (Button) findViewById(R.id.esittir);
        btn_yazboza_ekle = (Button) findViewById(R.id.yazboza_ekle);
        btn_oyuncu_ekle = (Button) findViewById(R.id.oyuncu_ekle);
        btn_oyun = (Button) findViewById(R.id.button_oyun);
        btn_okey = (Button) findViewById(R.id.button_okey);
        btn_tur = (Button) findViewById(R.id.button_tur);
        btn_gosterge = (Button) findViewById(R.id.button_gosterge);
        btn_banko = (Button) findViewById(R.id.buton_banko);
        btn_banko_yaz = (Button) findViewById(R.id.buton_banko_yaz);
        btn_banko_oldur = (Button) findViewById(R.id.buton_banko_oldur);
        btn_banko_iptal = (Button) findViewById(R.id.buton_banko_iptalet);
        btn_banko_islemleri_kapat = (Button) findViewById(R.id.buton_banko_islemleri_kapat);

        oyuncu_1_yazboz = (TextView) findViewById(R.id.oyumcu_1);
        oyuncu_2_yazboz = (TextView) findViewById(R.id.oyumcu_2);
        oyuncu_3_yazboz = (TextView) findViewById(R.id.oyumcu_3);
        oyuncu_4_yazboz = (TextView) findViewById(R.id.oyumcu_4);
        oyuncuadi = (TextView) findViewById(R.id.oyuncu_adi);
        o1 = (TextView) findViewById(R.id.o_1);
        o2 = (TextView) findViewById(R.id.o_2);
        o3 = (TextView) findViewById(R.id.o_3);
        o4 = (TextView) findViewById(R.id.o_4);
        hesap_sonucu1 = (TextView) findViewById(R.id.hesap_sonucu1);
        hesap_sonucu2 = (TextView) findViewById(R.id.hesap_sonucu2);
        hesap_sonucu3 = (TextView) findViewById(R.id.hesap_sonucu3);
        hesap_sonucu4 = (TextView) findViewById(R.id.hesap_sonucu4);
        txt_el_sayisi = (TextView) findViewById(R.id.txt_elsayisi);
        txt_banko_islem_bilgileri = (TextView) findViewById(R.id.text_banko_islem_bilgileri);
        son_iki_kisi_fark = (TextView) findViewById(R.id.txt_soniki_fark);


        liste1 = (LinearLayout) findViewById(R.id.liste1);
        liste2 = (LinearLayout) findViewById(R.id.liste2);
        liste3 = (LinearLayout) findViewById(R.id.liste3);
        liste4 = (LinearLayout) findViewById(R.id.liste4);

        sonuc_text = (EditText) findViewById(R.id.sonuc_text);

        lt1 = (ListView) findViewById(R.id.lt1);
        lt2 = (ListView) findViewById(R.id.lt2);
        lt3 = (ListView) findViewById(R.id.lt3);
        lt4 = (ListView) findViewById(R.id.lt4);

        //ses_aha = MediaPlayer.create(this, R.raw.aha);
       // ses_asa_sende_kalsin_dayi = MediaPlayer.create(this, R.raw.asa_sende_kalsin);


        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_Sari)));

//        Listview1 e tıklama. 1. oyuncunun sayılarına tıklama
        lt1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                alertdiyalog("1", position);
                return false;
            }
        });

        //Listview2 e tıklama. 2. oyuncunun sayılarına tıklama
        lt2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                alertdiyalog("2", position);
                return false;
            }
        });

        //Listview3 e tıklama. 3. oyuncunun sayılarına tıklama
        lt3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                alertdiyalog("3", position);
                return false;
            }
        });

        //Listview4 e tıklama. 4. oyuncunun sayılarına tıklama
        lt4.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                alertdiyalog("4", position);
                return false;
            }
        });


        btn_banko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banko_islemleri_frame.setVisibility(View.VISIBLE);
                acik_kapali_kontrol();
            }
        });
        btn_banko_yaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sira1 = txt_banko_islem_bilgileri.getText().toString().substring(0, 1).toString();
                if (sira1.equals("1")) {
                    oyuncu_1_yazboz.setBackground(getDrawable(R.drawable.bankoyaz_drawable));
                } else if (sira1.equals("2")) {
                    oyuncu_2_yazboz.setBackground(getDrawable(R.drawable.bankoyaz_drawable));
                } else if (sira1.equals("3")) {
                    oyuncu_3_yazboz.setBackground(getDrawable(R.drawable.bankoyaz_drawable));
                } else {
                    oyuncu_4_yazboz.setBackground(getDrawable(R.drawable.bankoyaz_drawable));
                }
                banko_islemleri_frame.setVisibility(View.INVISIBLE);
                acik_kapali_kontrol();

            }
        });

        btn_banko_oldur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sira1 = txt_banko_islem_bilgileri.getText().toString().substring(0, 1).toString();
                if (sira1.equals("1")) {
                    oyuncu_1_yazboz.setBackground(getDrawable(R.drawable.banko_oldur_drawable));
                } else if (sira1.equals("2")) {
                    oyuncu_2_yazboz.setBackground(getDrawable(R.drawable.banko_oldur_drawable));
                } else if (sira1.equals("3")) {
                    oyuncu_3_yazboz.setBackground(getDrawable(R.drawable.banko_oldur_drawable));
                } else {
                    oyuncu_4_yazboz.setBackground(getDrawable(R.drawable.banko_oldur_drawable));
                }
                banko_islemleri_frame.setVisibility(View.INVISIBLE);
                acik_kapali_kontrol();
            }
        });
        btn_banko_iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sira1 = txt_banko_islem_bilgileri.getText().toString().substring(0, 1).toString();
                if (sira1.equals("1")) {
                    oyuncu_1_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                } else if (sira1.equals("2")) {
                    oyuncu_2_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                } else if (sira1.equals("3")) {
                    oyuncu_3_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                } else {
                    oyuncu_4_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                }
                banko_islemleri_frame.setVisibility(View.INVISIBLE);
                acik_kapali_kontrol();
            }
        });
        btn_banko_islemleri_kapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banko_islemleri_frame.setVisibility(View.INVISIBLE);
                acik_kapali_kontrol();
            }
        });
        btn_yazboza_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sonuc_text.getText().length() > 0) {
                    if (sonuc_text.getText().toString().contains("X")) {
                        Toast.makeText(getApplicationContext(), "eşittire basın veya çarpıyı silin !", Toast.LENGTH_SHORT).show();
                    } else {
                        metot_yazboza_ekle(sonuc_text.getText().toString());
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "İŞLEM GİRİNİZ !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_oyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metot_yazboza_ekle("-100");
            }
        });

        btn_okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metot_yazboza_ekle("-200");
            }
        });

        btn_tur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metot_yazboza_ekle("-400");
            }
        });

        btn_gosterge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metot_yazboza_ekle("-50");
            }
        });

        btn_oyuncu_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (o1.length() > 0) oyuncu_1_yazboz.setText("1" + o1.getText());
                else oyuncu_1_yazboz.setText("1." + o1.getHint());

                if (o2.length() > 0) oyuncu_2_yazboz.setText("2" + o2.getText());
                else oyuncu_2_yazboz.setText("2." + o2.getHint());


                if (o3.length() > 0) oyuncu_3_yazboz.setText("3" + o3.getText());
                else oyuncu_3_yazboz.setText("3." + o3.getHint());

                if (o4.length() > 0) oyuncu_4_yazboz.setText("4" + o4.getText());
                else oyuncu_4_yazboz.setText("4." + o4.getHint());

                oyuncu_isim_frame.setVisibility(View.INVISIBLE);
                yazboz_ekranı_frame.setVisibility(View.VISIBLE);
                acik_kapali_kontrol();
            }
        });

        btn_sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = sonuc_text.getText().length();
                if (length > 0) {
                    sonuc_text.getText().delete(length - 1, length);
                    if (number.length() > 0) {
                        number = number.substring(0, number.length() - 1);
                    }
                }
            }
        });

        btn_carpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sonuc_text.length() > 0) {
                    number = number + "X";
                    sonuc_text.setText(number);
                } else {
                    Toast.makeText(getApplicationContext(), "Lütfen Önce Sayı Giriniz !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sonuc_text.length() > 0 && sonuc_text.getText().toString().indexOf("X") > 0 && sonuc_text.getText().toString().substring(sonuc_text.getText().toString().indexOf("X") + 1, sonuc_text.length()).length() > 0) {
                    int a = sonuc_text.getText().toString().indexOf("X");
                    sayi1 = Integer.parseInt(sonuc_text.getText().toString().substring(0, a).toString());
                    sayi2 = Integer.parseInt(sonuc_text.getText().toString().substring(a + 1, sonuc_text.length()).toString());
                    islemsonucu = sayi1 * sayi2;
                    sonuc_text.setText(String.valueOf(islemsonucu).toString());
                    number = String.valueOf(islemsonucu).toString();
                } else {
                    Toast.makeText(getApplicationContext(), "Önce İşlemleri Giriniz !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_hesap_makinesi_kapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesap_makinesi_ekrani_frame.setVisibility(View.INVISIBLE); // hesap makinesini kapat
                acik_kapali_kontrol();
            }
        });

        oyuncu_1_yazboz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesap_makinesi_ekrani_frame.setVisibility(View.VISIBLE); // hesap makinesini aç
                oyuncuadi.setText(oyuncu_1_yazboz.getText().toString());
                txt_banko_islem_bilgileri.setText(oyuncu_1_yazboz.getText().toString() + " BANKO İŞLEMLERİ");
                acik_kapali_kontrol();
            }
        });
        oyuncu_2_yazboz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesap_makinesi_ekrani_frame.setVisibility(View.VISIBLE); // hesap makinesini aç
                oyuncuadi.setText(oyuncu_2_yazboz.getText().toString());
                txt_banko_islem_bilgileri.setText(oyuncu_2_yazboz.getText().toString() + " BANKO İŞLEMLERİ");
                acik_kapali_kontrol();
            }
        });
        oyuncu_3_yazboz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesap_makinesi_ekrani_frame.setVisibility(View.VISIBLE); // hesap makinesini aç
                oyuncuadi.setText(oyuncu_3_yazboz.getText().toString());
                txt_banko_islem_bilgileri.setText(oyuncu_3_yazboz.getText().toString() + " BANKO İŞLEMLERİ");
                acik_kapali_kontrol();
            }
        });
        oyuncu_4_yazboz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesap_makinesi_ekrani_frame.setVisibility(View.VISIBLE); // hesap makinesini aç
                oyuncuadi.setText(oyuncu_4_yazboz.getText().toString());
                txt_banko_islem_bilgileri.setText(oyuncu_4_yazboz.getText().toString() + " BANKO İŞLEMLERİ");
                acik_kapali_kontrol();
            }
        });
    }

    public void hesapla() {
        int toplam1 = 0, toplam2 = 0, toplam3 = 0, toplam4 = 0;
        for (int i = 0; i < list_oyuncu1.size(); i++) {
            toplam1 += Integer.parseInt(list_oyuncu1.get(i).toString());
        }
        for (int i = 0; i < list_oyuncu2.size(); i++) {
            toplam2 += Integer.parseInt(list_oyuncu2.get(i).toString());
        }
        for (int i = 0; i < list_oyuncu3.size(); i++) {
            toplam3 += Integer.parseInt(list_oyuncu3.get(i).toString());
        }
        for (int i = 0; i < list_oyuncu4.size(); i++) {
            toplam4 += Integer.parseInt(list_oyuncu4.get(i).toString());
        }
        hesap_sonucu1.setText(String.valueOf(toplam1));
        hesap_sonucu2.setText(String.valueOf(toplam2));
        hesap_sonucu3.setText(String.valueOf(toplam3));
        hesap_sonucu4.setText(String.valueOf(toplam4));
    }

    String number = null;

    public void numbersClick(View view) {

        if (number == null) {
            number = view.getTag().toString();
        } else {
            number = number + view.getTag().toString();
        }
        sonuc_text.setText(number);
    }

    public void metot_yazboza_ekle(final String yazilacak_veri) {

        if (oyuncuadi.getText().length() > 0) {

            String sira = oyuncuadi.getText().toString().substring(0, 1).toString();

            if (sira.equals("1")) {

                list_oyuncu1.add(yazilacak_veri.toString());
                arrayadapterekle1();
            } else if (sira.equals("2")) {
                list_oyuncu2.add(yazilacak_veri.toString());
                arrayadapterekle2();
            } else if (sira.equals("3")) {
                list_oyuncu3.add(yazilacak_veri.toString());
                arrayadapterekle3();
            } else {
                list_oyuncu4.add(yazilacak_veri.toString());
                arrayadapterekle4();
            }
            hesapla();
            sonuc_text.setText("");
            hesap_makinesi_ekrani_frame.setVisibility(View.INVISIBLE);
            number = null;
            //sesli komut kapatıldı
//            if (sesli_komut.equals("acik")) {
//                if (Integer.parseInt(yazilacak_veri.toString()) > 1000) {
//                    ses_aha.start();
//                }
//            }

            acik_kapali_kontrol();
            el_sayisi_hesapla_ve_son_ikiyi_bildir();
        } else

        {
            Toast.makeText(getApplicationContext(), "OYUNCU SEÇİN !", Toast.LENGTH_SHORT).show();
        }
    }

    public void el_sayisi_hesapla_ve_son_ikiyi_bildir() {

        int oyuncu_el_sayisi1 = 0, oyuncu_el_sayisi2 = 0, oyuncu_el_sayisi3 = 0, oyuncu_el_sayisi4 = 0;
        for (int i = 0; i < list_oyuncu1.size(); i++) {
            if (list_oyuncu1.get(i).toString() != "-50".toString()) {
                oyuncu_el_sayisi1++;
            }
        }
        for (int i = 0; i < list_oyuncu2.size(); i++) {
            if (list_oyuncu2.get(i).toString() != "-50".toString()) {
                oyuncu_el_sayisi2++;
            }
        }
        for (int i = 0; i < list_oyuncu3.size(); i++) {
            if (list_oyuncu3.get(i).toString() != "-50".toString()) {
                oyuncu_el_sayisi3++;
            }
        }
        for (int i = 0; i < list_oyuncu4.size(); i++) {
            if (list_oyuncu4.get(i).toString() != "-50".toString()) {
                oyuncu_el_sayisi4++;
            }
        }
        ArrayList oyuncuelsayilari = new ArrayList();
        oyuncuelsayilari.add(String.valueOf(oyuncu_el_sayisi1));
        oyuncuelsayilari.add(String.valueOf(oyuncu_el_sayisi2));
        oyuncuelsayilari.add(String.valueOf(oyuncu_el_sayisi3));
        oyuncuelsayilari.add(String.valueOf(oyuncu_el_sayisi4));

        Collections.sort(oyuncuelsayilari);
// En son kalan 2 kişiyi bulan formül
        if (oyuncuelsayilari.get(3).equals(oyuncuelsayilari.get(0))) {
            txt_el_sayisi.setText("Oynanan El Sayısı : " + oyuncu_el_sayisi1);
            ArrayList<Integer> list_toplam_sayilar = new ArrayList<Integer>();
            list_toplam_sayilar.add(Integer.parseInt(hesap_sonucu1.getText().toString()));
            list_toplam_sayilar.add(Integer.parseInt(hesap_sonucu2.getText().toString()));
            list_toplam_sayilar.add(Integer.parseInt(hesap_sonucu3.getText().toString()));
            list_toplam_sayilar.add(Integer.parseInt(hesap_sonucu4.getText().toString()));
            Collections.sort(list_toplam_sayilar);
            son_iki_kisi_fark.setText("Aradaki Fark : " + String.valueOf((list_toplam_sayilar.get(3) - list_toplam_sayilar.get(2))));

            if (hesap_sonucu1.getText().toString().equals(list_toplam_sayilar.get(3).toString()) || hesap_sonucu1.getText().toString().equals(list_toplam_sayilar.get(2).toString())) {
                hesap_sonucu1.setTextColor(getColor(R.color.colorRed));
            } else {
                hesap_sonucu1.setTextColor(getColor(R.color.siyah));
            }
            if (hesap_sonucu2.getText().toString().equals(list_toplam_sayilar.get(3).toString()) || hesap_sonucu2.getText().toString().equals(list_toplam_sayilar.get(2).toString())) {
                hesap_sonucu2.setTextColor(getColor(R.color.colorRed));
            } else {
                hesap_sonucu2.setTextColor(getColor(R.color.siyah));
            }
            if (hesap_sonucu3.getText().toString().equals(list_toplam_sayilar.get(3).toString()) || hesap_sonucu3.getText().toString().equals(list_toplam_sayilar.get(2).toString())) {
                hesap_sonucu3.setTextColor(getColor(R.color.colorRed));
            } else {
                hesap_sonucu3.setTextColor(getColor(R.color.siyah));
            }
            if (hesap_sonucu4.getText().toString().equals(list_toplam_sayilar.get(3).toString()) || hesap_sonucu4.getText().toString().equals(list_toplam_sayilar.get(2).toString())) {
                hesap_sonucu4.setTextColor(getColor(R.color.colorRed));
            } else {
                hesap_sonucu4.setTextColor(getColor(R.color.siyah));
            }
            liste1.setBackgroundColor(getColor(R.color.color_arkaplan));
            liste1.setBackground(getDrawable(R.drawable.kenalik));

            liste2.setBackgroundColor(getColor(R.color.color_arkaplan));
            liste2.setBackground(getDrawable(R.drawable.kenalik));

            liste3.setBackgroundColor(getColor(R.color.color_arkaplan));
            liste3.setBackground(getDrawable(R.drawable.kenalik));

            liste4.setBackgroundColor(getColor(R.color.color_arkaplan));
            liste4.setBackground(getDrawable(R.drawable.kenalik));


        } else {
            if (oyuncu_el_sayisi1 == Integer.parseInt(oyuncuelsayilari.get(3).toString())) {
                liste1.setBackground(getDrawable(R.drawable.liste1_arkaplan));

            } else {
                liste1.setBackgroundColor(getColor(R.color.color_arkaplan));
                liste1.setBackground(getDrawable(R.drawable.kenalik));
            }
            if (oyuncu_el_sayisi2 == Integer.parseInt(oyuncuelsayilari.get(3).toString())) {
                liste2.setBackground(getDrawable(R.drawable.liste1_arkaplan));

            } else {
                liste2.setBackgroundColor(getColor(R.color.color_arkaplan));
                liste2.setBackground(getDrawable(R.drawable.kenalik));
            }
            if (oyuncu_el_sayisi3 == Integer.parseInt(oyuncuelsayilari.get(3).toString())) {
                liste3.setBackground(getDrawable(R.drawable.liste1_arkaplan));

            } else {
                liste3.setBackgroundColor(getColor(R.color.color_arkaplan));
                liste3.setBackground(getDrawable(R.drawable.kenalik));
            }
            if (oyuncu_el_sayisi4 == Integer.parseInt(oyuncuelsayilari.get(3).toString())) {
                liste4.setBackground(getDrawable(R.drawable.liste1_arkaplan));

            } else {
                liste4.setBackgroundColor(getColor(R.color.color_arkaplan));
                liste4.setBackground(getDrawable(R.drawable.kenalik));
            }

        }
    }

    public void arrayadapterekle1() {
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.test_list_item, list_oyuncu1) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position, convertView, parent);
                item.setHeight(90);
                item.setGravity(Gravity.CENTER);
                item.setTextColor(Color.BLACK);
                item.setTextSize(18);
                if (item.getText() == "-100" || item.getText() == "-200" || item.getText() == "-400" || item.getText() == "-50") {
                    item.setTextColor(Color.RED);
                }
                return item;
            }
        };
        lt1.setAdapter(adapter1);
    }

    public void arrayadapterekle2() {
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.test_list_item, list_oyuncu2) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position, convertView, parent);
                item.setHeight(90);
                item.setGravity(Gravity.CENTER);
                item.setTextColor(Color.BLACK);
                item.setTextSize(18);
                if (item.getText() == "-100" || item.getText() == "-200" || item.getText() == "-400" || item.getText() == "-50") {
                    item.setTextColor(Color.RED);
                }
                return item;
            }
        };
        lt2.setAdapter(adapter1);
    }

    public void arrayadapterekle3() {
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.test_list_item, list_oyuncu3) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position, convertView, parent);
                item.setHeight(90);
                item.setGravity(Gravity.CENTER);
                item.setTextColor(Color.BLACK);
                item.setTextSize(18);
                if (item.getText() == "-100" || item.getText() == "-200" || item.getText() == "-400" || item.getText() == "-50") {
                    item.setTextColor(Color.RED);
                }
                return item;
            }
        };
        lt3.setAdapter(adapter1);
    }

    public void arrayadapterekle4() {
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.test_list_item, list_oyuncu4) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position, convertView, parent);
                item.setHeight(90);
                item.setGravity(Gravity.CENTER);
                item.setTextColor(Color.BLACK);
                item.setTextSize(18);
                if (item.getText() == "-100" || item.getText() == "-200" || item.getText() == "-400" || item.getText() == "-50") {
                    item.setTextColor(Color.RED);
                }
                return item;
            }
        };
        lt4.setAdapter(adapter1);
    }

    String silineceksayi;

    public void alertdiyalog(final String hangioyuncudansilinecek, final int position) {

        String oyuncu_adi = "";
        if (hangioyuncudansilinecek.equals("1")) {
            oyuncu_adi = oyuncu_1_yazboz.getText().toString();
            silineceksayi = list_oyuncu1.get(position).toString();

        } else if (hangioyuncudansilinecek.equals("2")) {
            oyuncu_adi = oyuncu_2_yazboz.getText().toString();
            silineceksayi = list_oyuncu2.get(position).toString();

        } else if (hangioyuncudansilinecek.equals("3")) {
            oyuncu_adi = oyuncu_3_yazboz.getText().toString();
            silineceksayi = list_oyuncu3.get(position).toString();

        } else {
            oyuncu_adi = oyuncu_4_yazboz.getText().toString();
            silineceksayi = list_oyuncu4.get(position).toString();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(oyuncu_adi + " 'dan " + silineceksayi + " sayısını silmek ister misiniz ?");
        builder.setNegativeButton("Hayır", null);
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (hangioyuncudansilinecek == "1") {
                    list_oyuncu1.remove(position);
                    hesapla();
                    arrayadapterekle1();

                } else if (hangioyuncudansilinecek == "2") {
                    list_oyuncu2.remove(position);
                    hesapla();
                    arrayadapterekle2();

                } else if (hangioyuncudansilinecek == "3") {
                    list_oyuncu3.remove(position);
                    hesapla();
                    arrayadapterekle3();

                } else {
                    list_oyuncu4.remove(position);
                    hesapla();
                    arrayadapterekle4();
                }
                if (silineceksayi.toString() != "-50") {
                    el_sayisi_hesapla_ve_son_ikiyi_bildir();
                }
            }
        });

        builder.create().show();
    }

    public void acik_kapali_kontrol() {
        if (oyuncu_isim_frame.getVisibility() == View.VISIBLE) {
            yazboz_ekranı_frame.setVisibility(View.INVISIBLE);
            hesap_makinesi_ekrani_frame.setVisibility(View.INVISIBLE);
            banko_islemleri_frame.setVisibility(View.INVISIBLE);
        }
        if (yazboz_ekranı_frame.getVisibility() == View.VISIBLE) {
            oyuncu_isim_frame.setVisibility(View.INVISIBLE);
            lt1.setEnabled(true);
            lt2.setEnabled(true);
            lt3.setEnabled(true);
            lt4.setEnabled(true);
        }
        if (hesap_makinesi_ekrani_frame.getVisibility() == View.VISIBLE) {
            oyuncu_isim_frame.setVisibility(View.INVISIBLE);
            lt1.setEnabled(false);
            lt2.setEnabled(false);
            lt3.setEnabled(false);
            lt4.setEnabled(false);

        }
        if (banko_islemleri_frame.getVisibility() == View.VISIBLE) {
            oyuncu_isim_frame.setVisibility(View.INVISIBLE);
            hesap_makinesi_ekrani_frame.setVisibility(View.INVISIBLE);
            lt1.setEnabled(false);
            lt2.setEnabled(false);
            lt3.setEnabled(false);
            lt4.setEnabled(false);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.yenioyun:
                oyuncu_isim_frame.setVisibility(View.VISIBLE);
                acik_kapali_kontrol();
                list_oyuncu1.clear();
                list_oyuncu2.clear();
                list_oyuncu3.clear();
                list_oyuncu4.clear();

                hesap_sonucu1.setText("0");
                hesap_sonucu2.setText("0");
                hesap_sonucu3.setText("0");
                hesap_sonucu4.setText("0");
                o1.setText("");
                o2.setText("");
                o3.setText("");
                o4.setText("");
                arrayadapterekle1();
                arrayadapterekle2();
                arrayadapterekle3();
                arrayadapterekle4();
                el_sayisi_hesapla_ve_son_ikiyi_bildir();
                oyuncu_1_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                oyuncu_2_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                oyuncu_3_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));
                oyuncu_4_yazboz.setBackground(getDrawable(R.drawable.banko_iptal_drawable));

                return false;

            case R.id.isimdegistir:
                oyuncu_isim_frame.setVisibility(View.VISIBLE);
                acik_kapali_kontrol();
                return false;

            case R.id.sesli_tepki:
                if (item.isChecked()) {
                    sesli_komut = "kapali";
                    item.setChecked(false);
                } else {
                    Toast.makeText(getApplicationContext(), "Sesli komut açıkken herhangi bir oyuncu 1000'den fazla sayı yer ise uyarı verilir.", Toast.LENGTH_LONG).show();
                    sesli_komut = "acik";
                    item.setChecked(true);
                }
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
