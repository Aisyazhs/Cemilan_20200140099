/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMY.IT.CEMILAN_20200140099;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AISYAH SUHERMAN
 */
@Controller
public class SayuurController 
{
    @RequestMapping("/sayur")
    //@ResponseBody
    public String inputdata(HttpServletRequest dt, Model sayur){
        hitung proses = new hitung();
        
        String namasayuran = dt.getParameter("namasayur");
        String hargakilo = dt.getParameter("hargaperkilo");
        String jumlah = dt.getParameter("jumlahbeli");
        String uangcustomer = dt.getParameter("uangcustomer");
        
        Double price = proses.harga(hargakilo);
        Double jumlahsayur = proses.jumlahbeli(jumlah);
        Double jumlahbayar = proses.jumlahbayar(price, jumlahsayur);
        String disk = proses.Diskon(jumlahbayar);
        Double jumlahdiskon = proses.JumDiskon(jumlahbayar, Integer.valueOf(disk));
        Double totabayar = proses.tobayar(jumlahbayar, jumlahdiskon);
        proses.HasilDiskon(totabayar, jumlahbayar, jumlahdiskon, Integer.valueOf(disk));
        String uangkembalian = proses.UangCust(Double.valueOf(uangcustomer), totabayar);
        
        
        sayur.addAttribute("getnama",  namasayuran);
        sayur.addAttribute("getharga", "Rp " + hargakilo);
        sayur.addAttribute("getjumbeli", jumlah + "  kg");
        sayur.addAttribute("getuang", "Rp " + uangcustomer);
        sayur.addAttribute("getawal", "Rp" + jumlahbayar);
        sayur.addAttribute("getdisc", disk + "%");
        sayur.addAttribute("getjumdisk", "Rp " + jumlahdiskon);
        sayur.addAttribute("gettotal", "Rp" + totabayar);
        sayur.addAttribute("kembalian", uangkembalian);
      
        return "tampil";
    }
}
