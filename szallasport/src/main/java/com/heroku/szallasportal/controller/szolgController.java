package com.heroku.szallasportal.controller;

import com.heroku.szallasportal.DAO.szolgDAO;
import com.heroku.szallasportal.entities.Szolgaltatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class szolgController {

    @Autowired
    szolgDAO szolgDao;

    @PostMapping(value = "/szolgaltatasok")
    public String szolglista(String szallodanev, String felhasznalonev, Model model, Model modelb){

        if (szolgDao.listSzolgaltatas(szallodanev).isEmpty()) {
            modelb.addAttribute("felh", felhasznalonev);
            return "nincsszolgaltatas";
        }

        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("szolg", szolgDao.listSzolgaltatas(szallodanev));
        return "szolglista";

    }
    @PostMapping(value = "/szolgaltatasokszalloda")
    public String szolglistaszalloda(String szallodanev, String felhasznalonev, Model model, Model modelb){

        if (szolgDao.listSzolgaltatas(szallodanev).isEmpty()) {
            List<String> adat = new ArrayList<>();
            adat.add(felhasznalonev);
            adat.add(szallodanev);
            modelb.addAttribute("felh", adat);
            return "nincsszolgaltatasszalloda";
        }

        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("szolg", szolgDao.listSzolgaltatas(szallodanev));
        return "szolglistaszalloda";

    }

    @PostMapping(value = "/addszolg")
    public String addszolg(String tipus, int szolg_ar, String felhasznalonev, String szallodanev, Model model, Model modelb){
        Szolgaltatas szolgaltatas = new Szolgaltatas(tipus,szallodanev, szolg_ar);
        szolgDao.insertSzolg(szolgaltatas);
        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("szolg", szolgDao.listSzolgaltatas(szallodanev));
        return "szolglistaszalloda";
    }

    @PostMapping(value="/szolgtorol")
    public String szolgTorol(String szallodanev, int azon, String felhasznalonev, Model model, Model modelb){
        szolgDao.deleteSzolg(azon);

        if (szolgDao.listSzolgaltatas(szallodanev).isEmpty()) {
            List<String> adat = new ArrayList<>();
            adat.add(felhasznalonev);
            adat.add(szallodanev);
            modelb.addAttribute("felh", adat);
            return "nincsszolgaltatasszalloda";
        }

        modelb.addAttribute("felh", felhasznalonev);
        model.addAttribute("szolg", szolgDao.listSzolgaltatas(szallodanev));
        return "szolglistaszalloda";
    }
}
