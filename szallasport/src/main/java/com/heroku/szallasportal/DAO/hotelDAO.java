package com.heroku.szallasportal.DAO;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import com.heroku.szallasportal.entities.Foglalas;
import com.heroku.szallasportal.entities.Hotel;
import com.heroku.szallasportal.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository

public class hotelDAO extends JdbcDaoSupport{
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
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

    public List<Hotel> listSzalloda(String felhasznalo){
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

    public List<Hotel> listSzalloda(){
        String sql = "select * from szalloda";
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
            hotel.setTipus((String)row.get("tipus"));
            hotel.setSza_url((String)row.get("sza_url"));
            hotel.setLetrehozta((String)row.get("letrehozta"));
            result.add(hotel);
        }

        return result;
    }

    public void insertHotel(Hotel hotel) {
        String sql = "INSERT INTO szalloda(sza_nev, iranyitoszam, varos, utca, hazszam, telefon, email, mobil, ertekeles, tipus, sza_url, letrehozta, ert_szam) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                hotel.getSza_nev(), hotel.getIranyitoszam(), hotel.getVaros(), hotel.getUtca(), hotel.getHazszam(), hotel.getTelefon(), hotel.getEmail(), hotel.getMobil(), 0.0, hotel.getTipus(), hotel.getSza_url(), hotel.getLetrehozta(), 0
        });
    }

    public List<Hotel> listSzallodaAdat(String sza_nev){
        String sql = "select * from szalloda where sza_nev='"+sza_nev+"'";
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

    public void updateSzalloda(Hotel hotel){
        String sql = "UPDATE szalloda SET iranyitoszam=?, varos=?, utca=?, hazszam=?, telefon=?, email=?, mobil=?, tipus=?, sza_url=? WHERE sza_nev='"+hotel.getSza_nev()+"'";
        getJdbcTemplate().update(sql, new Object[]{
                hotel.getIranyitoszam(), hotel.getVaros(),  hotel.getUtca(), hotel.getHazszam(), hotel.getTelefon(), hotel.getEmail(), hotel.getMobil(), hotel.getTipus(), hotel.getSza_url()
        });
    }

    public void ertekelSzalloda(float ertekeles, int db, String szallodanev, int azon){
        String sql = "UPDATE szalloda SET ertekeles=?, ert_szam=? WHERE sza_nev='"+szallodanev+"'";
        getJdbcTemplate().update(sql, new Object[]{
                ertekeles, db
        });
        String sqlb = "UPDATE foglalas SET ertekelt=? WHERE azon=?";
        getJdbcTemplate().update(sqlb, new Object[]{
                true, azon
        });
    }

    public List<Foglalas> listFoglalasok(String felhasznalonev){
        String sqls = "select * from (( szoba inner join szalloda on szoba.szallodanev=szalloda.sza_nev)inner join foglalas on szoba.szobaszam=foglalas.szobaszam) where foglalas.felhasznalonev='"+felhasznalonev+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sqls);

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
            foglalas.setSza_url((String)row.get("sza_url"));
            foglalas.setUrl((String)row.get("url"));
            foglalas.setVa_szobaszam((Integer)row.get("va_szobaszam"));
            foglalas.setErtekeles((Float)row.get("ertekeles"));
            foglalas.setErt_szam((Integer)row.get("ert_szam"));

            result.add(foglalas);
        }

        return result;
    }

    public List<Foglalas> listFoglalasbyid(int azon){
        String sql = "select * from (( szoba inner join szalloda on szoba.szallodanev=szalloda.sza_nev)inner join foglalas on szoba.szobaszam=foglalas.szobaszam) where foglalas.azon='"+azon+"'";
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
            foglalas.setSza_url((String)row.get("sza_url"));
            foglalas.setUrl((String)row.get("url"));
            foglalas.setVa_szobaszam((Integer)row.get("va_szobaszam"));
            foglalas.setErtekeles((Float)row.get("ertekeles"));
            foglalas.setErt_szam((Integer)row.get("ert_szam"));
            foglalas.setErtekelt((Boolean)row.get("ertekelt"));

            result.add(foglalas);
        }

        return result;
    }
}
