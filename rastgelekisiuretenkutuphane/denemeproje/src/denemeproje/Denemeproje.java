/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package denemeproje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import net.paket.*; //Kendi olusturduğum kutuphanemi ekledim
import java.util.Scanner;


public class Denemeproje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        
      kisi Kisi=new kisi();  //kutuphaneden nesne oluşturuldu
      KimlikNo kimlk=new KimlikNo();
      IMEINo im=new IMEINo();
      Scanner scan=new Scanner(System.in);
      int secim;
      //cikis secilene kadar tekrar menu gelmesi icin kullanıldı
      do{
          //menudekiler olusturuldu
          System.out.println("1-Rastgele Kisi Uret");
          System.out.println("2-Uretilmis Dosya Kontrol Et");
          System.out.println("3-Cikis");
          System.out.print("Secim:");
          secim=scan.nextInt();
        switch(secim){
          case 1:
              System.out.print("Olusturulacak kisi sayisi:");
              int yaz=scan.nextInt(); //kac kisi olusturulmak istendigi disardan aliniyor
              File file = new File("kisiler.txt"); 
              if (!file.exists()) { //dosya olup olmadigi kontrol ediliyor yoksa yeni dosya olusturuluyor
                file.createNewFile();
              }            
              //dosya yazma modunda aciliyor
              FileWriter fileWriter = new FileWriter(file,true);
              BufferedWriter bWriter = new BufferedWriter(fileWriter);
              
              //girilen kisi sayisi kadar dosyaya kisi olusturuluyor
              for(int i=0;i<yaz;i++){ 
                bWriter.write(Kisi.kisiyaz());//kutuphane sayesinde txt dosyasina yazdiriliyor
                bWriter.newLine();//alt alta yazmasini sagliyor
              }
              bWriter.close(); 
              break;
         
          case 2:
              FileInputStream fstream = new FileInputStream("kisiler.txt"); //kisiler.txt aciliyor
              BufferedReader br = new BufferedReader(new InputStreamReader(fstream));//yazma modu
              String satir; 
              int sayac=0;
              int sayac2=0;
              int sayac3=0;
              int sayac4=0;
              while((satir=br.readLine())!=null){//satir satir okuma yapiliyor
                  String tckimlik = satir.substring(0, satir.indexOf(" "));//ilk sirada olan tc leri almak icin bosluga kadar okunuyor
                  if(kimlk.kimlikDogrula(tckimlik)==true){//kimlik kontrol metodu kullaniliyor
                      sayac++;   //dogru ise sayac attiriliyor                  
                  }
                  else
                      sayac2++;//yanlis ise sayac attiriliyor
                
                  String [] imeinumara=satir.split(" ");//bosluklara ayrilip diziye atiliyor 
                  String imei=imeinumara[5].substring(1, 16);//imei nonun oldugu diziden ( ) ın ici aliniyor
                  if(im.imeiDogrula(imei)){//imeino kontrol metodu kullaniliyor
                      sayac3++;//dogru ise sayac attiriliyor 
                      
                  }
                  else 
                      sayac4++;//yanlis ise sayac attiriliyor
                  
                 }
              //ekrana gecerli gecersiz sayisi bastiriliyor
              System.out.println("T.C. Kimlik Kontrol ");
              System.out.println(sayac+" Geçerli");
              System.out.println(sayac2+" Geçersiz");
              System.out.println("IMEI  Kontrol");
              System.out.println(sayac3+" Geçerli");
              System.out.println(sayac4+" Geçersiz");
             br.close();
              break;
          case 3:
              
              break;
                 default:
                    System.out.println("Hatali secim");

        }
      }while(secim!=3);//3 e basilinca cikis yapiyor
      
    }
    
}
