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

@Repository

public class roomDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public List<Room> Listrooms(String sza_nev) {
        String sql = "select * from szoba where szallodanev='"+sza_nev+"' order by va_szobaszam";
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
            hotel.setTipus((String)row.get("tipus"));
            hotel.setSza_url((String)row.get("sza_url"));
            hotel.setLetrehozta((String)row.get("letrehozta"));
            result.add(hotel);
        }

        return result;
    }

    public List<Hotel> listSzallodanev(String sza_nev){
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
            hotel.setTipus((String)row.get("tipus"));
            hotel.setSza_url((String)row.get("sza_url"));
            hotel.setLetrehozta((String)row.get("letrehozta"));
            result.add(hotel);
        }

        return result;
    }

    public void insertRoom(Room room) {
        String sql = "INSERT INTO szoba(szallodanev, kapacitas, arperfo, szabad, agytipus, konyha, leiras, url, va_szobaszam) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                room.getSzallodanev(), room.getKapacitas(), room.getArperfo(), room.isSzabad(), room.getAgytipus(), room.isKonyha(), room.getLeiras(), room.getUrl(), room.getVa_szobaszam()
        });
    }

    public List<Room> Listroomsbyid(int szobaszam) {
        String sql = "select * from szoba where szobaszam='"+szobaszam+"'";
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

    public void updateSzoba(Room room){
        String sql = "UPDATE szoba SET szallodanev=?, kapacitas=?, arperfo=?, szabad=?, agytipus=?, konyha=?, leiras=?, url=?, va_szobaszam=? WHERE szobaszam='"+room.getSzobaszam()+"'";
        getJdbcTemplate().update(sql, new Object[]{
                room.getSzallodanev(), room.getKapacitas(), room.getArperfo(), room.isSzabad(), room.getAgytipus(), room.isKonyha(), room.getLeiras(), room.getUrl(), room.getVa_szobaszam()
        });
    }

    public void deleteSzoba(int szobaszam){
        String sql = "DELETE FROM szoba WHERE szobaszam='"+szobaszam+"'";
        getJdbcTemplate().update(sql);
    }

    public List<Foglalas> listFoglalasAdatok(String szallodanev){
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
}
