package com.heroku.szallasportal.controller;

import com.heroku.szallasportal.entities.Foglalas;
import com.heroku.szallasportal.entities.Hotel;
import com.heroku.szallasportal.entities.Room;
import com.heroku.szallasportal.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.heroku.szallasportal.DAO.userDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class userController {
    @Autowired
    private userDAO userDAO;


    @GetMapping(value = "/")
    public String listUser(Model model) {
        model.addAttribute("users", userDAO.listUsers());

        return "index";
    }

    @GetMapping(value = "/bejelentkezes")
    public String login() {
        return "loginForm";
    }

    @GetMapping(value = "/regisztracio")
    public String regisztracio() {
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String addDoge(@RequestParam(required = false, name = "keresztnev") String keresztnev, @RequestParam(required = false, name = "vezeteknev") String vezeteknev,@RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, @RequestParam(required = false, name = "email") String email,@RequestParam(required = false, name = "jelszo") String jelszo,@RequestParam(required = false, name = "telefonszam") int telefonszam, @RequestParam(required = false, name = "iranyitoszam") int iranyitoszam, @RequestParam(required = false, name = "varos") String varos, @RequestParam(required = false, name = "utca") String utca, @RequestParam(required = false, name = "hazszam") String hazszam) {
        User user = new User(keresztnev, vezeteknev, felhasznalonev, email, jelszo, telefonszam, iranyitoszam, varos, utca, hazszam);
        int szamlalo=0;
        for (int i = 0; i < userDAO.listUsers().size(); i++) {

            if (userDAO.listUsers().get(i).getFelhasznalonev().equals(felhasznalonev)) {
                szamlalo++;
            }
        }
        if(szamlalo==0) {
            userDAO.insertUser(user);
            return "index";
        }else{
            return "foglalt";
        }
    }
    @PostMapping(value = "/login")
    public String login(@RequestParam(required = false, name = "felhasznalonev") String felhasznalonev,@RequestParam(required = false, name = "jelszo") String jelszo, Model model){
        int szamlalo=0;
        for(int i=0; i<userDAO.loginAccept(felhasznalonev).size(); i++){
            if(userDAO.loginAccept(felhasznalonev).get(i).getJelszo().equals(jelszo)){
                szamlalo++;
            }
        }
        if(szamlalo==0){
            return "hibas";
        }else{
            model.addAttribute("users", userDAO.loginAccept(felhasznalonev));
            return "loginindex";
        }
    }

    @PostMapping(value = "/delete")
    public String deleteUsers(@RequestParam("felh") String felh, Model model) throws ParseException {
        List<Foglalas> foglalas = userDAO.listFoglalasok(felh);
        for(int i=0; i<foglalas.size(); i++) {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(foglalas.get(i).getErkezes());
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(foglalas.get(i).getTavozas());
            Date date = new Date();
            if (date1.after(date) || date2.after(date)) {
                model.addAttribute("users", userDAO.loginAccept(felh));
                return "nemtorolhetofelhasznalo";
            }
        }
        List<Hotel> hotelek = userDAO.listSzallodak(felh);
        for(int i=0; i<hotelek.size(); i++){
            List<Room> szobak = userDAO.Listrooms(hotelek.get(i).getSza_nev());
                if (!szobak.isEmpty()) {
                    model.addAttribute("users", userDAO.loginAccept(felh));
                    return "nemtorolhetofelhasznaloszallodafoglalas";
                }
        }

        userDAO.deleteUser(felh);

        return "index";
    }

    @PostMapping(value = "/edit")
    public String editUser(@RequestParam("felhasznalonev") String felhasznalonev, Model model) {
        User user = userDAO.getUserById(felhasznalonev);
        model.addAttribute("user", user);

        return "updateuser";
    }

    @PostMapping(value = "/deleteuser")
    public String deleteUser(@RequestParam("felh") String felh, Model model) {
        User user = userDAO.getUserById(felh);
        model.addAttribute("user", user);

        return "megerosites";
    }


    @PostMapping(value = "/updateuser")
    public String updateUser(@RequestParam(required = false, name = "keresztnev") String keresztnev, @RequestParam(required = false, name = "vezeteknev") String vezeteknev,@RequestParam(required = false, name = "felhasznalonev") String felhasznalonev, @RequestParam(required = false, name = "email") String email,@RequestParam(required = false, name = "jelszo") String jelszo,@RequestParam(required = false, name = "telefonszam") int telefonszam, @RequestParam(required = false, name = "iranyitoszam") int iranyitoszam, @RequestParam(required = false, name = "varos") String varos, @RequestParam(required = false, name = "utca") String utca, @RequestParam(required = false, name = "hazszam") String hazszam, Model model){
        User user = new User(keresztnev, vezeteknev, felhasznalonev, email, jelszo, telefonszam, iranyitoszam, varos, utca, hazszam);
        userDAO.updateUser(user);
        model.addAttribute("users", userDAO.loginAccept(felhasznalonev));
        return "loginindex";
    }

}

