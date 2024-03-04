package com.heroku.szallasportal.controller;

import com.heroku.szallasportal.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.heroku.szallasportal.DAO.hotelDAO;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Controller

public class hotelController {
    public static String uploadDirectory = System.getProperty("user.home")+"/";
    @Autowired
    hotelDAO hotelDAO;

    @PostMapping(value = "/szalloda")
    public String szalloda(String felhasznalonev, Model model, Model modelb){
        hotelDAO.listSzalloda(felhasznalonev);

        if(hotelDAO.listSzalloda(felhasznalonev).isEmpty()){
            hotelDAO.loginAccept(felhasznalonev);
            modelb.addAttribute("user",hotelDAO.loginAccept(felhasznalonev));
            return "nincsmegszalloda";
        }
        model.addAttribute("szalloda",hotelDAO.listSzalloda(felhasznalonev));
        return "sajatszalloda";

    }

    @PostMapping(value = "/ujszalloda")
    public String ujszalloda(String szallodanev, int iranyitoszam, String varos, String utca, String hazszam, int telefonszam, String email, int mobil, String tipus, @RequestParam("url") File url, String letrehozta, Model model, Model modelb) throws IOException {
        if (url.getName().endsWith("jpg") || url.getName().endsWith("JPG") || url.getName().endsWith("png") || url.getName().endsWith("PNG") || url.getName().endsWith("jpeg") || url.getName().endsWith("JPEG") || url.getName().endsWith("BMP") || url.getName().endsWith("bmp") || url.getName().endsWith("gif") || url.getName().endsWith("GIF")) {
            String urldb = "https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/" + url.getName();
            Hotel hotel = new Hotel(szallodanev, iranyitoszam, varos, utca, hazszam, telefonszam, email, mobil, tipus, urldb, letrehozta);
            List<Hotel> hotelek = hotelDAO.listSzalloda();

            for (int i = 0; i < hotelek.size(); i++) {
                if (hotelek.get(i).getSza_nev().equals(szallodanev)) {

                    hotelDAO.loginAccept(letrehozta);
                    modelb.addAttribute("user", hotelDAO.loginAccept(letrehozta));
                    return "foglaltszallodanev";
                }
            }
            hotelDAO.insertHotel(hotel);
            model.addAttribute("szalloda", hotelDAO.listSzalloda(letrehozta));
            return "sajatszalloda";
        }else{
            model.addAttribute("felh", letrehozta);
            return "hibasfajlszalloda";
        }
    }

    @PostMapping(value = "/editSzalloda")
    public String editSzalloda(@RequestParam(required = false, name = "sza_nev") String sza_nev, Model model) {

       model.addAttribute("hotel", hotelDAO.listSzallodaAdat(sza_nev));

        return "updatehotel";
    }

    @PostMapping(value = "/updateszalloda")
    public String updateSzalloda(@RequestParam(required = false, name = "iranyitoszam") int iranyitoszam, @RequestParam(required = false, name = "varos") String varos, @RequestParam(required = false, name = "utca") String utca, @RequestParam(required = false, name = "hazszam") String hazszam,@RequestParam(required = false, name = "telefon") int telefon, @RequestParam(required = false, name = "email") String email,@RequestParam(required = false, name = "mobil") int mobil,@RequestParam(required = false, name = "tipus") String tipus, @RequestParam(required = false, name = "url") File url, @RequestParam(required = false, name = "sza_url") String sza_url, @RequestParam(required = false, name = "letrehozta") String letrehozta, @RequestParam(required = false, name = "sza_nev") String sza_nev, Model model) {
        String urldb;

        if (url.getName().isEmpty()){
            urldb=sza_url;
        }else{
            if (url.getName().endsWith("jpg") || url.getName().endsWith("JPG") || url.getName().endsWith("png") || url.getName().endsWith("PNG") || url.getName().endsWith("jpeg") || url.getName().endsWith("JPEG") || url.getName().endsWith("BMP") || url.getName().endsWith("bmp") || url.getName().endsWith("gif") || url.getName().endsWith("GIF")) {
                urldb = "https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/" + url.getName();
            }else{
                model.addAttribute("felh", letrehozta);
                return "hibasfajlszalloda";
            }
        }


        Hotel hotel= new Hotel(sza_nev,iranyitoszam,varos, utca, hazszam, telefon, email, mobil, tipus, urldb, letrehozta);
        hotelDAO.updateSzalloda(hotel);
        model.addAttribute("szalloda",hotelDAO.listSzalloda(letrehozta));
        return "sajatszalloda";
    }

    @PostMapping(value = "/ertekel")
    public String ertkeles(String szallodanev, String felhasznalonev, int azon, Model model, Model modelb){
        List<String> data = new ArrayList<>();
        List<Integer> id = new ArrayList<>();
        id.add(azon);
        data.add(szallodanev);
        data.add(felhasznalonev);

        if(hotelDAO.listFoglalasbyid(azon).get(0).isErtekelt()){
            model.addAttribute("adat", data);
            return "ertekelesvolt";
        }

        model.addAttribute("adat", data);
        modelb.addAttribute("azon", id);
        return "ertekel";

    }

    @PostMapping(value = "/szallodaertekel")
    public String szallodaErtekeles(int ertekeles,String felhasznalo, String sza_nev, int azon, Model model){
        List<Hotel> adat =hotelDAO.listSzallodaAdat(sza_nev);

        float atlag = 0;
        int ertdb;
        atlag = ((adat.get(0).getErtekeles()*adat.get(0).getErt_szam()) + ertekeles)/(adat.get(0).getErt_szam()+1);
        ertdb=adat.get(0).getErt_szam()+1;
        atlag= (float) ((float) Math.round(atlag * 100d) / 100d);
        hotelDAO.ertekelSzalloda(atlag, ertdb, sza_nev, azon);

        model.addAttribute("foglalas", hotelDAO.listFoglalasok(felhasznalo));
        return "foglalasok";
    }

}
