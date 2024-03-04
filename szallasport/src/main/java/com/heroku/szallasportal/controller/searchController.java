package com.heroku.szallasportal.controller;

import com.heroku.szallasportal.DAO.searchDAO;
import com.heroku.szallasportal.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class searchController {
    @Autowired
    searchDAO searchDAO;

    @PostMapping(value = "/kereses")
    public String kereso(@RequestParam(required = false, name = "varos") String varos, @RequestParam(required = false, name = "erkezes") String erkezes, @RequestParam(required = false, name = "tavozas") String tavozas, Model model) throws ParseException {

        model.addAttribute("rooms", searchDAO.varoskeres(varos));
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(erkezes);
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(tavozas);
        List<Room> alma=searchDAO.varoskeres(varos);
        int szamlalo=0;

        Date dNow = new Date( );
        if(date2.before(date1) || date1.before(dNow) || date2.before(dNow)){
            return "rosszdatum";
        }
        if(varos.isEmpty()){
            alma=searchDAO.varoskeres();
            for(int i=0; i<searchDAO.varoskeres().size(); i++){
                for(int j=0; j<searchDAO.foglalaskereso().size();j++){

                    Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getErkezes());
                    Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getTavozas());

                    if(searchDAO.varoskeres().get(i).getSzobaszam()==searchDAO.foglalaskereso().get(j).getSzobaszam()){
                        if(date1.after(date4) && date2.after(date4)){
                            model.addAttribute("rooms", alma);
                        }else if(date1.before(date3)&&date2.before(date3)){
                            model.addAttribute("rooms", alma);
                        }else{
                            alma.remove(i-szamlalo);
                            szamlalo++;
                            if(alma.isEmpty()){

                                return "nincstalalat";
                            }
                        }
                    }
                }
            }

            model.addAttribute("rooms", alma);
            return "keresesieredmeny";
        }else {
            if(searchDAO.varoskeres(varos).isEmpty()){
                return "nincstalalat";
            }
            for (int i = 0; i < searchDAO.varoskeres(varos).size(); i++) {
                for (int j = 0; j < searchDAO.foglalaskereso().size(); j++) {

                    Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getErkezes());
                    Date date4 = new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getTavozas());

                    if (searchDAO.varoskeres(varos).get(i).getSzobaszam() == searchDAO.foglalaskereso().get(j).getSzobaszam()) {
                        if (date1.after(date4) && date2.after(date4)) {
                            model.addAttribute("rooms", alma);
                        } else if (date1.before(date3) && date2.before(date3)) {
                            model.addAttribute("rooms", alma);
                        } else {
                            alma.remove(i - szamlalo);
                            szamlalo++;
                            if(alma.isEmpty()){

                                return "nincstalalat";
                            }
                        }
                    }
                }
            }
        }
        model.addAttribute("rooms", alma);
        return "keresesieredmeny";
    }

    @PostMapping(value = "/keresesem")
    public String keresom(@RequestParam(required = false, name = "varos") String varos, @RequestParam(required = false, name = "erkezes") String erkezes, @RequestParam(required = false, name = "tavozas") String tavozas, @RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, Model model, Model models) throws ParseException {

        model.addAttribute("rooms", searchDAO.varoskeres(varos));
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(erkezes);
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(tavozas);
        List<Room> alma=searchDAO.varoskeres(varos);
        int szamlalo=0;


        Date dNow = new Date( );
        if(date2.before(date1) || date1.before(dNow) || date2.before(dNow)){
            List<String> attribute = new ArrayList<>();
            attribute.add(0,felhasznalonev);
            models.addAttribute("attribute", attribute);
            return "rosszdatumbelepve";
        }

        if(varos.isEmpty()){
            alma=searchDAO.varoskeres();
            for(int i=0; i<searchDAO.varoskeres().size(); i++){
                for(int j=0; j<searchDAO.foglalaskereso().size();j++){

                    Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getErkezes());
                    Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getTavozas());

                    if(searchDAO.varoskeres().get(i).getSzobaszam()==searchDAO.foglalaskereso().get(j).getSzobaszam()){
                        if(date1.after(date4) && date2.after(date4)){
                            model.addAttribute("rooms", alma);
                        }else if(date1.before(date3)&&date2.before(date3)){
                            model.addAttribute("rooms", alma);
                        }else{
                            alma.remove(i-szamlalo);
                            szamlalo++;
                            if(alma.isEmpty()){
                                List<String> attribute = new ArrayList<>();
                                attribute.add(0, felhasznalonev);
                                models.addAttribute("attribute", attribute);
                                return "nincstalalatbelepve";
                            }
                        }
                    }
                }
            }
            List<String> attribute = new ArrayList<>();
            attribute.add(0,erkezes);
            attribute.add(1, tavozas);
            attribute.add(2, felhasznalonev);

            models.addAttribute("attribute", attribute);
            model.addAttribute("rooms", alma);
            return "keresesieredmenybelepve";
        }else {
            if(searchDAO.varoskeres(varos).isEmpty()){
                List<String> attribute = new ArrayList<>();
                attribute.add(0, felhasznalonev);
                models.addAttribute("attribute", attribute);
                return "nincstalalatbelepve";
            }
            for (int i = 0; i < searchDAO.varoskeres(varos).size(); i++) {
                for (int j = 0; j < searchDAO.foglalaskereso().size(); j++) {

                    Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getErkezes());
                    Date date4 = new SimpleDateFormat("yyyy-MM-dd").parse(searchDAO.foglalaskereso().get(j).getTavozas());

                    if (searchDAO.varoskeres(varos).get(i).getSzobaszam() == searchDAO.foglalaskereso().get(j).getSzobaszam()) {
                        if (date1.after(date4) && date2.after(date4)) {
                            model.addAttribute("rooms", alma);
                        } else if (date1.before(date3) && date2.before(date3)) {
                            model.addAttribute("rooms", alma);
                        } else {
                            alma.remove(i - szamlalo);
                            szamlalo++;
                            if(alma.isEmpty()){
                                List<String> attribute = new ArrayList<>();
                                attribute.add(0, felhasznalonev);
                                models.addAttribute("attribute", attribute);
                                return "nincstalalatbelepve";
                            }
                        }
                    }
                }
            }
        }
        List<String> attribute = new ArrayList<>();
        attribute.add(0,erkezes);
        attribute.add(1, tavozas);
        attribute.add(2, felhasznalonev);

        models.addAttribute("attribute", attribute);
        model.addAttribute("rooms", alma);
        return "keresesieredmenybelepve";
    }
}
