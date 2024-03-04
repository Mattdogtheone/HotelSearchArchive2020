package com.heroku.szallasportal.DAO;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import com.heroku.szallasportal.entities.Foglalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.heroku.szallasportal.entities.Room;

@Repository
public class searchDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public List<Room> varoskeres(String varos) {
        String sql = "select * from szoba inner join szalloda on szoba.szallodanev=szalloda.sza_nev and szalloda.varos='" + varos + "' order  by szoba.szobaszam";
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
            room.setErtekeles((Float)row.get("ertekeles"));
            room.setUtca((String)row.get("utca"));
            room.setSza_url((String)row.get("sza_url"));

            result.add(room);
        }

        return result;

    }

    public List<Room> varoskeres() {
        String sql = "select * from szoba inner join szalloda on szoba.szallodanev=szalloda.sza_nev order by szobaszam";
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
            room.setErtekeles((Float)row.get("ertekeles"));
            room.setUtca((String)row.get("utca"));
            room.setSza_url((String)row.get("sza_url"));

            result.add(room);
        }

        return result;

    }
    public List<Foglalas> foglalaskereso(){
        String sql = "select * from foglalas";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Foglalas> result = new ArrayList<Foglalas>();
        for(Map<String, Object> row:rows){
            Foglalas reserved= new Foglalas();
            reserved.setAzon((Integer)row.get("azon"));
            reserved.setFelhasznalonev((String)row.get("felhasznalonev"));
            reserved.setSzobaszam((Integer)row.get("szobaszam"));
            reserved.setErkezes((String) row.get("erkezes"));
            reserved.setTavozas((String) row.get("tavozas"));

            result.add(reserved);
        }

            return result;

    }
}
