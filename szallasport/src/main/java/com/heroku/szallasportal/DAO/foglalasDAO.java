package com.heroku.szallasportal.DAO;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import com.heroku.szallasportal.entities.Foglalas;
import com.heroku.szallasportal.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository

public class foglalasDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    public void insertFoglalas(Foglalas foglalas) {
        String sql = "INSERT INTO foglalas(felhasznalonev, szobaszam, erkezes, tavozas, ertekelt) VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                foglalas.getFelhasznalonev(), foglalas.getSzobaszam(), foglalas.getErkezes(), foglalas.getTavozas(), false
        });
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

    public List<Foglalas> listFoglalas(String felhasznalonev){
        String sql = "select * from (( szoba inner join szalloda on szoba.szallodanev=szalloda.sza_nev)inner join foglalas on szoba.szobaszam=foglalas.szobaszam) where foglalas.felhasznalonev='"+felhasznalonev+"' order by foglalas.azon";
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

    public void deleteUser(String azon){
        String sql = "DELETE FROM foglalas WHERE azon='"+azon+"'";
        getJdbcTemplate().update(sql);
    }

    public List<Foglalas> listFoglalasAdat(String szallodanev){
        String sql = "select * from ( (foglalas inner join felhasznalo on foglalas.felhasznalonev=felhasznalo.felhasznalonev)inner join szoba on szoba.szobaszam=foglalas.szobaszam)where szallodanev='"+szallodanev+"' order by foglalas.azon";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Foglalas> result = new ArrayList<Foglalas>();
        for(Map<String, Object> row:rows){
            Foglalas foglalas = new Foglalas();
            foglalas.setAzon((Integer)row.get("azon"));
            foglalas.setFelhasznalonev((String)row.get("felhasznalonev"));
            foglalas.setSzobaszam((Integer)row.get("szobaszam"));
            foglalas.setErkezes((String)row.get("erkezes"));
            foglalas.setTavozas((String)row.get("tavozas"));
            foglalas.setSzallodanev((String)row.get("szallodanev"));;
            foglalas.setIranyitoszam((Integer)row.get("iranyitoszam"));
            foglalas.setVaros((String)row.get("varos"));
            foglalas.setUtca((String)row.get("utca"));
            foglalas.setHazszam((String)row.get("hazszam"));
            foglalas.setTelefonszam((Integer)row.get("telefonszam"));
            foglalas.setEmail((String)row.get("email"));
            foglalas.setKeresztnev((String)row.get("keresztnev"));
            foglalas.setVezeteknev((String)row.get("vezeteknev"));
            foglalas.setVa_szobaszam((Integer)row.get("va_szobaszam"));

            result.add(foglalas);
        }

        return result;
    }
    public void deletefoglal(String azon){
        String sql = "DELETE FROM foglalas WHERE azon='"+azon+"'";
        getJdbcTemplate().update(sql);
    }
}
