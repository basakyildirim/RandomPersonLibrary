package net.paket;
import java.util.Random;


public class Telefon {
    public static int[]tel(){
        Random rn = new Random();
        //uygun alan kodlari 
        String []alankodu={"501","505","506","507","551","552","553","554","555","559","530","531","532","533","534","535","536","537","538","539","561","540","541","542","543","544","545","546","547","548","549"};
        int no=rn.nextInt(alankodu.length);//alan kodundan rastgele inte atama yapiliyor
        int []tel=new int[9];
        tel[0]=0;//ilk eleman her zaman 0 olacak
        tel[1]=Integer.parseInt(alankodu[no]);//inte atanan rastgele alan kodlarindan biri aliniyor
        for(int i=2;i<tel.length;i++){
            tel[i]=rn.nextInt(9);//geri kalan rastgele 0-9 arasinda getiriliyor
        }       
        return tel;
    }
    public static String IntArrayToString(int[] tel) { //int diziyi stringe ceviriyoruz
        String telno="";
        for(int i : tel) {
            telno+=Integer.toString(i);
        }
        return telno;
    }

    
}
