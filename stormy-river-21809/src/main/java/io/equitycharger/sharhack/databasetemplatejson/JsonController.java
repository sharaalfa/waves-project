package io.equitycharger.sharhack.databasetemplatejson;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class JsonController {
    private static final Log log = LogFactory.getLog(JsonController.class);
    private final JdbcTemplate jdbcTemplate;

    public JsonController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @RequestMapping(value = "/id")
    @CrossOrigin(origins = "http://localhost:4200")
    public List getTuples(@RequestParam("id") String id) throws FileNotFoundException, IOException {
        List<String> hyposisList = new ArrayList<>();;

        List<Txs4> list =  jdbcTemplate.query("SELECT * FROM txs_4 where recipient=? and asset_id='WAVES'", new Object[] { id }, new Txs4RowMapper());
        File file = new File("/home/sharhack/Загрузки/waves/notes4.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {

            for (Txs4 txs4: list) {
                if(st.equalsIgnoreCase(txs4.getSender()))
                    hyposisList.add(txs4.getSender());
            }
        }
        return hyposisList;
        //return null;//.stream()
        //.map(Map::values)
        //.collect(Collectors.toList());
    }



    private String path (String image) {
        String path = "";
        String parts[] = image.split("%2F");
        for (String part : parts) {
            path += "/" + part;
        }
        return path;
    }
}
