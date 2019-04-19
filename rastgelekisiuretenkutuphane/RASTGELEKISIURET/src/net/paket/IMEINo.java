package net.paket;
import java.util.Random;

 

public class IMEINo {
    public static int []imeiolus(){
        Random rn = new Random();
       int toplam=0;
       int imei[]=new int[15];//boyutu 15 olan dizi olusturulur
       int carp=1;
       for(int i=0;i<14;i++){ //ilk 14 deger random atanir
           imei[i]=rn.nextInt(9);
         
       }
       for(int i=1;i<14;i+=2){ //cift sirada olan sayilari alir
          
              carp=imei[i]*2; //2 ile carpar
              toplam+=(carp/10)+(carp%10); //10 a bolumden kalan ve 10 a modunu toplayip toplam degiskenine ekler          
          
       }
       for(int i=0;i<13;i+=2){
            toplam+=imei[i]; //tek siradaki sayilari toplama ekler
       }
       imei[14]=(10-(toplam%10))%10;//son elemanin degerini bulur
       
       return imei;
    }
     public static String Stringcevir(int[] imeiolus) { //int diziiyi stringe cevirir
        String imei2="";
        for(int i : imeiolus) {
            imei2+=Integer.toString(i);
        }
        return imei2;
    }
     public boolean imeiDogrula(String imeiNo) { //olusan imei nolari string modunda alir boyut ve algoritmaya gore kontrol eder
        
     if (imeiNo.length() != 15){
          return false;
     }
     int toplam = 0;
     int[] imeikontrol = new int[15];
     int carpkontrol=1;
     char deger2[]=imeiNo.toCharArray(); //gelen stringi char seklinde ayirir
     for (int i = 0; i < 14; i++) {
          imeikontrol[i] = Integer.parseInt(deger2[i]+"");
          
     }
      for(int i=1;i<14;i+=2){
         
              carpkontrol=imeikontrol[i]*2;
              toplam+=(carpkontrol/10)+(carpkontrol%10);           
            
       }
      for(int i=0;i<13;i+=2){
            toplam+=imeikontrol[i];
       }
       imeikontrol[14]=Integer.parseInt(deger2[14]+""); //txt dosyasindaki 15. degeri burdaki 15. degere atar
       if(  imeikontrol[14]!=(10-(toplam%10))%10) //olusmasi gereken degerle ayni mi kontrol eder
          return false;
 
       return true;
    }
}
