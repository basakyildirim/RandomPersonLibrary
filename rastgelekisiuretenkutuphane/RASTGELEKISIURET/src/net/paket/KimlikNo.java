package net.paket;
import java.util.Random;
 

public class KimlikNo {
public static int[]tcuret(){
Random rn = new Random();
int d1 = rn.nextInt(9) + 1;//ilk eleman 0 hariç random atanir 1-9 arasi
//geri kalan 8 eleman rastgele
int d2 = rn.nextInt(9);
int d3 = rn.nextInt(9);
int d4 = rn.nextInt(9);
int d5 = rn.nextInt(9);
int d6 = rn.nextInt(9);
int d7 = rn.nextInt(9);
int d8 = rn.nextInt(9);
int d9 = rn.nextInt(9);
int d10=((d1+d3+d5+d7+d9)*7-(d2+d4+d6+d8))%10; //algoritmaya uygun 10. eleman
int d11=(d1+d2+d3+d4+d5+d6+d7+d8+d9+d10)%10; //algoritmaya uygun 11. eleman
int [ ] tc= {d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11}; //diziye atanir
return tc;    
}
 public static String Tostring(int[] tcuret) { //int diziyi stringe ceviriyoruz
        String tc2="";
        for(int i : tcuret) {
            tc2+=Integer.toString(i);
        }
        return tc2;
    }
public boolean kimlikDogrula(String tc3) { //algoritmanin olusumunu,boyutunu if komutlarıyla kontrol edip string halinde dondurur
     if (tc3.length() != 11)
          return false;
     int[] hane = new int[11];
     int toplam = 0;
     char deger[]=tc3.toCharArray(); //gelen stringi char seklinde ayirir
     for (int i = 0; i < 11; i++) {
          hane[i] = Integer.parseInt(deger[i]+""); //char degerler inte cevrilir
          toplam += hane[i];
     }
     toplam -= hane[10];
     if ((toplam % 10) != hane[10])
          return false;
     if (((hane[0] + hane[2] + hane[4] + hane[6] + hane[8]) * 7 - (hane[1] + hane[3] + hane[5] + hane[7])) % 10 != hane[9])
          return false;
     if (((hane[0] +hane[1] +hane[2] + hane[3] + hane[4] +hane[5] + hane[6] +hane[7] + hane[8]+hane[9] )) % 10 != hane[10])
          return false;
     return true;
}
}



