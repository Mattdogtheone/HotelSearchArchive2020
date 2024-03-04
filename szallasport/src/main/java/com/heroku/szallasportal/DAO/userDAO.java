package com.heroku.szallasportal.DAO;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import com.heroku.szallasportal.entities.Foglalas;
import com.heroku.szallasportal.entities.Hotel;
import com.heroku.szallasportal.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.heroku.szallasportal.entities.User;

@Repository
public class userDAO extends JdbcDaoSupport  {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO felhasznalo(keresztnev, vezeteknev, felhasznalonev, email, jelszo, telefonszam, iranyitoszam, varos, utca, hazszam) VALUES (?, ?, ?, ?, ? ,?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                user.getKeresztnev(), user.getVezeteknev(), user.getFelhasznalonev(), user.getEmail(), user.getJelszo(), user.getTelefonszam(), user.getIranyitoszam(), user.getVaros(), user.getUtca(), user.getHazszam()
        });
    }

    public List<User> listUsers(){
        String sql = "select * from felhasznalo";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> result = new ArrayList<User>();
        for(Map<String, Object> row:rows){
            User user = new User();
            user.setKeresztnev((String)row.get("keresztnev"));
            user.setVezeteknev((String)row.get("vezeteknev"));
            user.setFelhasznalonev((String)row.get("felhasznalonev"));
            user.setEmail((String)row.get("email"));
            user.setJelszo((String)row.get("jelszo"));
            user.setTelefonszam((Integer)row.get("telefonszam"));
            user.setIranyitoszam((Integer) row.get("iranyitoszam"));
            user.setVaros((String)row.get("varos"));
            user.setUtca((String)row.get("utca"));
            user.setHazszam((String)row.get("hazszam"));
            result.add(user);
        }

        return result;
    }

    public User getUserById(String felhasznalonev){
        String sql = "select * from felhasznalo where felhasznalonev='"+felhasznalonev+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> result = new ArrayList<User>();
        for(Map<String, Object> row:rows){
            User user = new User();
            user.setKeresztnev((String)row.get("keresztnev"));
            user.setVezeteknev((String)row.get("vezeteknev"));
            user.setFelhasznalonev((String)row.get("felhasznalonev"));
            user.setEmail((String)row.get("email"));
            user.setJelszo((String)row.get("jelszo"));
            user.setTelefonszam((Integer)row.get("telefonszam"));
            user.setIranyitoszam((Integer) row.get("iranyitoszam"));
            user.setVaros((String)row.get("varos"));
            user.setUtca((String)row.get("utca"));
            user.setHazszam((String)row.get("hazszam"));
            result.add(user);
        }

        return result.get(0);
    }
    public List<User> loginAccept(String felhasznalo){
        String sql = "select * from felhasznalo where felhasznalonev='"+felhasznalo+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> result = new ArrayList<User>();
        for(Map<String, Object> row:rows){
            User user = new User();
            user.setKeresztnev((String)row.get("keresztnev"));
            user.setVezeteknev((String)row.get("vezeteknev"));
            user.setFelhasznalonev((String)row.get("felhasznalonev"));
            user.setEmail((String)row.get("email"));
            user.setJelszo((String)row.get("jelszo"));
            user.setTelefonszam((Integer)row.get("telefonszam"));
            user.setIranyitoszam((Integer) row.get("iranyitoszam"));
            user.setVaros((String)row.get("varos"));
            user.setUtca((String)row.get("utca"));
            user.setHazszam((String)row.get("hazszam"));
            result.add(user);
        }

        return result;
    }

    public void deleteUser(String felhasznalonev){
        String sql = "DELETE FROM felhasznalo WHERE felhasznalonev='"+felhasznalonev+"'";
        getJdbcTemplate().update(sql);
    }

    public void updateUser(User user){
        String sql = "UPDATE felhasznalo SET keresztnev=?, vezeteknev=?, email=?, jelszo=?, telefonszam=?, iranyitoszam=?, varos=?, utca=?, hazszam=? WHERE felhasznalonev='"+user.getFelhasznalonev()+"'";
        getJdbcTemplate().update(sql, new Object[]{
                user.getKeresztnev(), user.getVezeteknev(),  user.getEmail(), user.getJelszo(), user.getTelefonszam(), user.getIranyitoszam(), user.getVaros(), user.getUtca(), user.getHazszam()
        });
    }

    public List<Foglalas> listFoglalasok(String felhasznalonev){
        String sql = "select * from (( szoba inner join szalloda on szoba.szallodanev=szalloda.sza_nev)inner join foglalas on szoba.szobaszam=foglalas.szobaszam) where foglalas.felhasznalonev='"+felhasznalonev+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Foglalas> result = new ArrayList<Foglalas>();
        for(Map<String, Object> row:rows){
            Foglalas foglalas = new Foglalas();
            foglalas.setAzon((Integer)row.get("azon"));
            foglalas.setFelhasznalonev((String)row.get("felhasznalonev"));
            foglalas.setSzobaszam((Integer)row.get("szobaszam"));
            foglalas.setErkezes((String)row.get("erkezes"));
            foglalas.setTavozas((String)row.get("tavozas"));
            foglalas.setSzallodanev((String)row.get("szallodanev"));
            foglalas.setKapacitas((Integer) row.get("kapacitas"));
            foglalas.setArperfo((Integer)row.get("arperfo"));
            foglalas.setAgytipus((String)row.get("agytipus"));
            foglalas.setKonyha((Boolean)row.get("konyha"));
            foglalas.setIranyitoszam((Integer)row.get("iranyitoszam"));
            foglalas.setVaros((String)row.get("varos"));
            foglalas.setUtca((String)row.get("utca"));
            foglalas.setHazszam((String)row.get("hazszam"));
            foglalas.setTelefon((Integer)row.get("telefon"));
            foglalas.setEmail((String)row.get("email"));
            foglalas.setErtekeles((Float)row.get("ertekeles"));
            foglalas.setErt_szam((Integer)row.get("ert_szam"));
            foglalas.setSza_url((String)row.get("sza_url"));
            foglalas.setUrl((String)row.get("url"));
            foglalas.setVa_szobaszam((Integer)row.get("va_szobaszam"));

            result.add(foglalas);
        }

        return result;
    }

    public List<Hotel> listSzallodak(String felhasznalo){
        String sql = "select * from szalloda where letrehozta='"+felhasznalo+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Hotel> result = new ArrayList<Hotel>();
        for(Map<String, Object> row:rows){
            Hotel hotel = new Hotel();
            hotel.setSza_nev((String)row.get("sza_nev"));
            hotel.setIranyitoszam((Integer) row.get("iranyitoszam"));
            hotel.setVaros((String)row.get("varos"));
            hotel.setUtca((String)row.get("utca"));
            hotel.setHazszam((String)row.get("hazszam"));
            hotel.setTelefon((Integer)row.get("telefon"));
            hotel.setEmail((String) row.get("email"));
            hotel.setMobil((Integer) row.get("mobil"));
            hotel.setErtekeles((Float)row.get("ertekeles"));
            hotel.setErt_szam((Integer)row.get("ert_szam"));
            hotel.setTipus((String)row.get("tipus"));
            hotel.setSza_url((String)row.get("sza_url"));
            hotel.setLetrehozta((String)row.get("letrehozta"));
            result.add(hotel);
        }

        return result;
    }

    public List<Room> Listrooms(String sza_nev) {
        String sql = "select * from szoba where szallodanev='"+sza_nev+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Room> result = new ArrayList<Room>();
        for (Map<String, Object> row : rows) {
            Room room = new Room();
            room.setSzobaszam((Integer) row.get("szobaszam"));
            room.setSzallodanev((String) row.get("szallodanev"));
            room.setKapacitas((Integer) row.get("kapacitas"));
            room.setArperfo((Integer) row.get("arperfo"));
            room.setSzabad((Boolean) row.get("szabad"));
            room.setAgytipus((String) row.get("agytipus"));
            room.setKonyha((Boolean) row.get("konyha"));
            room.setLeiras((String) row.get("leiras"));
            room.setUrl((String) row.get("url"));
            room.setVaros((String)row.get("varos"));
            room.setVa_szobaszam((Integer)row.get("va_szobaszam"));

            result.add(room);
        }

        return result;

    }

}
