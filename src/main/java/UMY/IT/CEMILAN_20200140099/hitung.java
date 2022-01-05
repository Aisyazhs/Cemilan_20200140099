/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMY.IT.CEMILAN_20200140099;

/**
 *
 * @author AISYAH SUHERMAN
 */
public class hitung
{
    public Double harga(String HarSayur)
    {
        Double price = Double.valueOf(HarSayur);
        return price;
    }
    public Double jumlahbeli(String JumBeli)
    {
        Double jumlahsayur= Double.valueOf(JumBeli);
        return jumlahsayur;
    }
    public Double tobayar(Double JumBayar, Double Diskon)
    {
        Double tobayar = JumBayar - Diskon;
        return tobayar;
    }
    public Double jumlahbayar(Double HarSayur, Double JumBeli)
    {
        Double jumlahbayar = HarSayur * JumBeli;
        return jumlahbayar;
    }
    public String Diskon (Double jumlahbayar){
    
        String Diskon = null;
        
        if (jumlahbayar < 16000) {
            Diskon = "0";
        }else if (jumlahbayar < 25000){
            Diskon = "10";
        }else{
            Diskon = "15";
        }
        return Diskon;
    }
    public Double JumDiskon(Double jumlahbayar, Integer Diskon){
        
        Double JumDiskon = jumlahbayar * Diskon/100;
    
        return JumDiskon;
    }
    public void HasilDiskon (Double tobayar, Double jumbayar, Double JumDiskon, Integer Diskon)
    {
        
        if(jumbayar < 16000){
            Diskon = 0;
            tobayar = jumbayar - (jumbayar*Diskon/100);
            JumDiskon = jumbayar*Diskon/100;
            
        }else if( jumbayar < 25000){
            Diskon = 10;
            tobayar = jumbayar - (jumbayar*Diskon/100);
            JumDiskon = jumbayar*Diskon/100;
        }else {
            Diskon = 15;
            tobayar = jumbayar - (jumbayar*Diskon/100);
            JumDiskon = jumbayar*Diskon/100;
        }
    }
    
    public String UangCust (Double uang, Double tobayar)
    {
        Double kembalian = uang - tobayar;
        return " Rp "+kembalian;
        
    }
}