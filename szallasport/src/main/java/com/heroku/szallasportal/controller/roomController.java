package com.heroku.szallasportal.controller;

import com.heroku.szallasportal.entities.Foglalas;
import com.heroku.szallasportal.entities.Hotel;
import com.heroku.szallasportal.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.heroku.szallasportal.DAO.roomDAO;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class roomController {
    @Autowired
    roomDAO roomDAO;

    @PostMapping(value = "/szobak")
    public String szoba(String felhasznalonev, String sza_nev, Model model, Model modelb){


        if(roomDAO.Listrooms(sza_nev).isEmpty()){

            modelb.addAttribute("szalloda",roomDAO.listSzallodanev(sza_nev));
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsmegszoba";
        }
        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("rooms",roomDAO.Listrooms(sza_nev));
        return "szobak";
    }

    @PostMapping(value = "/ujszoba")
    public String ujszoba(int va_szobaszam, int kapacitas, int arperfo, String agytipus, boolean konyha, String leiras, @RequestParam("url") File url, String szallodanev, String felhasznalonev, Model model, Model modelb) {
        if (url.getName().endsWith("jpg") || url.getName().endsWith("JPG") || url.getName().endsWith("png") || url.getName().endsWith("PNG") || url.getName().endsWith("jpeg") || url.getName().endsWith("JPEG") || url.getName().endsWith("BMP") || url.getName().endsWith("bmp") || url.getName().endsWith("gif") || url.getName().endsWith("GIF")) {
            String urldb = "https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/" + url.getName();
            boolean szabad = true;
            Room room = new Room(szallodanev, kapacitas, arperfo, szabad, agytipus, konyha, leiras, urldb, va_szobaszam);
            roomDAO.insertRoom(room);
            modelb.addAttribute("felh", felhasznalonev);
            model.addAttribute("rooms", roomDAO.Listrooms(szallodanev));
            return "szobak";
        } else {
            modelb.addAttribute("felh", felhasznalonev);
            model.addAttribute("rooms", szallodanev);
            return "hibasfajl";
        }
    }

    @PostMapping(value="/editszoba")
    public String editszoba(@RequestParam(required = false, name = "szobaszam") int szobaszam, @RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, Model model, Model modelb){


        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("rooms",roomDAO.Listroomsbyid(szobaszam));
        return "updateszoba";
    }

    @PostMapping(value = "/updateszoba")
    public String updateSzoba(@RequestParam(required = false, name = "va_szobaszam") int va_szobaszam, @RequestParam(required = false, name = "kapacitas") int kapacitas, @RequestParam(required = false, name = "arperfo") int arperfo, @RequestParam(required = false, name = "agytipus") String agytipus,@RequestParam(required = false, name = "konyha") boolean konyha, @RequestParam(required = false, name = "leiras") String leiras, @RequestParam(required = false, name = "url") File url, @RequestParam(required = false, name = "szallodanev") String szallodanev, @RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, @RequestParam(required = false, name = "szobaszam") int szobaszam, @RequestParam(required = false, name = "szo_url") String szo_url, Model model, Model modelb) {
        String urldb;

        if (url.getName().isEmpty()){
            urldb=szo_url;
        }else{
            if (url.getName().endsWith("jpg") || url.getName().endsWith("JPG") || url.getName().endsWith("png") || url.getName().endsWith("PNG") || url.getName().endsWith("jpeg") || url.getName().endsWith("JPEG") || url.getName().endsWith("BMP") || url.getName().endsWith("bmp") || url.getName().endsWith("gif") || url.getName().endsWith("GIF")) {
                urldb = "https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/" + url.getName();
            }else{
                modelb.addAttribute("felh", felhasznalonev);
                model.addAttribute("rooms", szallodanev);
                return "hibasfajl";
            }
        }

        Room room= new Room(szobaszam, szallodanev,kapacitas,arperfo,true, agytipus, konyha, leiras, urldb, va_szobaszam);
        roomDAO.updateSzoba(room);

        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("rooms",roomDAO.Listrooms(szallodanev));
        return "szobak";
    }

    @PostMapping(value = "/deleteszoba")
    String deleteSzoba(int szobaszam, String felhasznalonev, String sza_nev, Model model, Model modelb) throws ParseException {
        List<Hotel> hotelek = roomDAO.listSzalloda(felhasznalonev);

        for(int i=0; i<hotelek.size(); i++){
        List<Foglalas> foglalasok=roomDAO.listFoglalasAdatok(hotelek.get(i).getSza_nev());
            for(int j=0; j<foglalasok.size(); j++){
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(foglalasok.get(j).getErkezes());
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(foglalasok.get(j).getTavozas());
                Date date = new Date();
                if(foglalasok.get(j).getSzobaszam()==szobaszam) {
                    if (date1.after(date) || date2.after(date)) {
                        modelb.addAttribute("szalloda", roomDAO.listSzallodanev(sza_nev));
                        modelb.addAttribute("felh", felhasznalonev);
                        return "nemtorolhetoszoba";
                    }
                }
            }
        }

        roomDAO.deleteSzoba(szobaszam);

        if(roomDAO.Listrooms(sza_nev).isEmpty()){
            modelb.addAttribute("szalloda",roomDAO.listSzallodanev(sza_nev));
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsmegszoba";
        }else{
            modelb.addAttribute("felh", felhasznalonev);
            model.addAttribute("rooms",roomDAO.Listrooms(sza_nev));
            return "szobak";
        }

    }
}
