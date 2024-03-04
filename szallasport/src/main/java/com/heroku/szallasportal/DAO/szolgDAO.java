package com.heroku.szallasportal.DAO;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import com.heroku.szallasportal.entities.Szolgaltatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository

public class szolgDAO extends JdbcDaoSupport{
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public List<Szolgaltatas> listSzolgaltatas(String szallodanev){
        String sql = "select * from sza_szolg where szallodanev='"+szallodanev+"'";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Szolgaltatas> result = new ArrayList<Szolgaltatas>();
        for(Map<String, Object> row:rows){
            Szolgaltatas szolg = new Szolgaltatas();
            szolg.setAzon((Integer)row.get("azon"));
            szolg.setTipus((String)row.get("tipus"));
            szolg.setSzallodanev((String)row.get("szallodanev"));
            szolg.setSzolg_ar((Integer) row.get("szolg_ar"));
            result.add(szolg);
        }

        return result;
    }

    public void insertSzolg(Szolgaltatas szolgaltatas) {
        String sql = "INSERT INTO sza_szolg(tipus, szallodanev, szolg_ar) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                szolgaltatas.getTipus(), szolgaltatas.getSzallodanev(), szolgaltatas.getSzolg_ar()
        });
    }

    public void deleteSzolg(int azon){
        String sql = "DELETE FROM sza_szolg WHERE azon='"+azon+"'";
        getJdbcTemplate().update(sql);
    }
}
