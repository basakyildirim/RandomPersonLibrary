package net.paket;
import java.io.IOException;
import java.util.Random;

public class kisi {
    //siniflar cagirilir
    public static RastgeleKisi isimsoyisim;
    public static int yas;
    public static KimlikNo kimlik;
    public static Telefon tel;
    public static IMEINo imeino;
    
    public String kisiyaz() throws IOException{   
        Random rn =new Random();      
        int yas=rn.nextInt(100);//0-100 arasi rastgele yass olusturuldu
        //kisi yan yana metodlar cagirilarak stringe ataniyor
        String kisiolus=kimlik.Tostring(kimlik.tcuret())+" "+isimsoyisim.kisi()+" "+yas+" "+tel.IntArrayToString(tel.tel())+" ("+imeino.Stringcevir(imeino.imeiolus())+")";
        return kisiolus;
    }
    

}
