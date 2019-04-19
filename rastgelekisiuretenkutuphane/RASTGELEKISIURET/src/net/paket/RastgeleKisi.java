package net.paket;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;



public class RastgeleKisi {
    public static String kisi() throws FileNotFoundException, IOException{
        Random rn = new Random();
        FileInputStream fs= new FileInputStream("random_isimler.txt");//random_isimler dosyasi okunuyor
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ArrayList<String> array = new ArrayList<>();//string listesi olusturuluyor
        String satir;
        while((satir = br.readLine()) != null)//satir satir okuma yapiliyor
        array.add(satir);//satirlar diziye ataniyor
        int random_isim = rn.nextInt(array.size());//
        String randkisi=array.get(random_isim);//sira sayisi random gelecek sekilde isimler aliniyor
         return randkisi;         
        }
     
    }

