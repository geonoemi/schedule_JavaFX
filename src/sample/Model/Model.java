package sample.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
    Database db = new Database("localhost", "menetrend_javafx", "root", "");

    public ArrayList<String[]> getLineNumLetter() throws SQLException {
        ArrayList<String[]> result = new ArrayList<>();
        ResultSet queryResult = db.query("SELECT vonalSzam, vonalBetujel FROM vonal WHERE vonalSorszam%2=0 ORDER BY vonalSzam, vonalBetujel ASC;");
        while (queryResult.next()) {
            result.add(new String[]{queryResult.getString("vonalSzam"), queryResult.getString("vonalBetujel")});
        }
        return result;
    }
    public ArrayList getStationName(String lineNum, String lineLetter) throws SQLException {
        ArrayList<String> stations = new ArrayList<>();

        ResultSet result = db.query("SELECT allomas.nev" +
                "    FROM erint\n" +
                "    INNER JOIN vonal ON erint.vonalSorszam = vonal.vonalSorszam\n" +
                "    INNER JOIN allomas ON erint.allomasSorszam = allomas.allomasSorszam\n" +
                "    WHERE\n" +
                "    vonal.vonalSzam LIKE '"+ lineNum + "' AND vonal.vonalBetujel LIKE '" + lineLetter + "' AND vonal.vonalSorszam%2=0");

        while (result.next()) {
            stations.add(result.getString("nev"));
        }
        return stations;
    }
     public ArrayList getWayList(String line, String letter, String stationName) throws SQLException {
        ArrayList<String> ways = new ArrayList<>();

         ResultSet result = db.query("SELECT\n" +
                 "A.nev,\n" +
                 "V1.vonalSzam,\n" +
                 "V1.vonalSorszam,\n" +
                 "V1.kezdoAllomasSorszam,\n" +
                 "V1.vegAllomasSorszam\n" +
                 "FROM allomas AS A\n" +
                 "INNER JOIN vonal AS V1 ON A.allomasSorszam = V1.kezdoAllomasSorszam\n" +
                 "\n" +
                 "WHERE V1.vonalSzam LIKE '"+ line+"' AND V1.vonalBetujel='" + letter + "';" );


         while(result.next()) {
            ways.add(result.getString("nev"));

        }
        return ways;
     }

    public ArrayList getDisabledVehicleTimesFromStations(String linenum, String lineLetter, String stationName) throws SQLException {
        ArrayList<String> times = new ArrayList<>();
        ResultSet result = db.query("SELECT jarat.indulasiIdo,jarat.rokkantHelyekSzama,jarat.alacsonyPadlos FROM vonal  \n" +
                "            INNER JOIN jarat ON vonal.vonalSorszam = jarat.vonalSorszam \n" +
                "            WHERE \n" +
                "            vonal.vonalSzam LIKE '"+linenum+"'  AND vonal.vonalBetujel LIKE '"+lineLetter+"'\n" +
                "            AND vonal.vegAllomasSorszam IN ( SELECT allomas.allomasSorszam \n" +
                "               FROM allomas WHERE allomas.nev LIKE '"+stationName +"');");
        while (result.next()) {
            times.add(result.getString("indulasiIdo")+" "+ result.getString("rokkantHelyekSzama")+" "+
                      result.getString("alacsonyPadlos"));
        }
        return times;
    }
}
