package com.heroku.szallasportal.controller;
import com.heroku.szallasportal.entities.Foglalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.heroku.szallasportal.DAO.foglalasDAO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;

@Controller
public class foglalasController {
    @Autowired
    foglalasDAO foglalasDAO;

    @PostMapping(value = "/lefoglal")
    public String lefoglal(@RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, @RequestParam(required = false, name = "szobaszam") int szobaszam,@RequestParam(required = false, name = "erkezes") String erkezes,@RequestParam(required = false, name = "tavozas") String tavozas, Model model ) throws ParseException {
    Foglalas foglalas= new Foglalas(felhasznalonev, szobaszam, erkezes, tavozas);
        foglalasDAO.insertFoglalas(foglalas);
        model.addAttribute("users", foglalasDAO.loginAccept(felhasznalonev));
        return "loginindex";
    }

    @PostMapping(value = "/foglalas")
    public String foglalas(@RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, Model model, Model modelb){
        model.addAttribute("foglalas", foglalasDAO.listFoglalas(felhasznalonev));
        if(foglalasDAO.listFoglalas(felhasznalonev).isEmpty()){
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsmegfoglalas";
        }else {
            return "foglalasok";
        }
    }

    @PostMapping(value = "/deletefoglalas")
    public String delete(@RequestParam(required = false, name = "azon") String azon, @RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, Model model, Model modelb) {
        foglalasDAO.deleteUser(azon);
        if(foglalasDAO.listFoglalas(felhasznalonev).isEmpty()){
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsmegfoglalas";
        }
        model.addAttribute("foglalas", foglalasDAO.listFoglalas(felhasznalonev));
        return "foglalasok";
    }

    @PostMapping(value = "/vissza")
    public String vissza( @RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, Model model){
        model.addAttribute("users", foglalasDAO.loginAccept(felhasznalonev));
        return "loginindex";
    }

    @PostMapping(value = "/beerkezettfoglalas")
    public String beerkezett(String szallodanev, String felhasznalonev, Model model, Model modelb){
        foglalasDAO.listFoglalasAdat(szallodanev);

        if(foglalasDAO.listFoglalasAdat(szallodanev).isEmpty()){
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsszallodafoglalas";
        }

        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("foglalas", foglalasDAO.listFoglalasAdat(szallodanev));
        return "szallodafoglalasok";
    }
    @PostMapping(value = "/foglalastorlese")
    public String foglalastorles(String azon, String felhasznalonev, String szallodanev, Model model, Model modelb){

        foglalasDAO.deletefoglal(azon);

        if(foglalasDAO.listFoglalasAdat(szallodanev).isEmpty()){
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsszallodafoglalas";
        }
        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("foglalas", foglalasDAO.listFoglalasAdat(szallodanev));
        return "szallodafoglalasok";
    }


}
