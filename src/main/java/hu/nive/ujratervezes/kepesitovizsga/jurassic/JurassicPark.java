package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    public static final String GET_OVERPOLATION_BREED_SQL = "SELECT breed FROM dinosaur WHERE actual > expected order " +
                                                              "by breed";
    private final DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (Connection conn = dataSource.getConnection()){
            return getListFromDb(conn);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database");
        }
    }

    public List<String> getListFromDb(Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement(GET_OVERPOLATION_BREED_SQL)){
            ResultSet rs = ps.executeQuery();
            return getListFromResultSet(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute query");
        }
    }

    private List<String> getListFromResultSet(ResultSet rs) {
        try (rs) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("breed"));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Result set error");
        }
    }
}

//Adatbázis
//Az adatbázis egyetlen táblát tartalmaz, dinosaur néven, az alábbi oszlopokkal:
//
//breed varchar (elsődleges kulcs)
//expected int
//actual int
//Például:
//
//breed	expected	actual
//Tyrannosaurus rex	2	2
//Maiasaurus	21	22
//Stegosaurus	4	4
//Velociraptor	8	37
//Hypsilophodontida	33	34
//Java alkalmazás
//Hozd létre a JurassicPark osztályt, ami konstruktor paraméterben kapja meg az adatbáziseléréshez szükséges DataSource példányt.
//
//Az osztályban egyetlen publikus metódus van, checkOverpopulation néven, ami térjen vissza azoknak a fajtáknak a nevével, amiknél a valós létszám magasabb, mint az elvárt (a fenti példában a Maiasaurus, a Velociraptor és a Hypsilophodontida), ABC szerint növekvő sorrendben.
//
//Ha az adatbázis üres, akkor a metódus térjen vissza üres listával.
