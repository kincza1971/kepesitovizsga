package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    public static final String GET_OVERPOPULATION_BREED_SQL = "SELECT breed FROM dinosaur WHERE actual > expected order " +
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
        try (PreparedStatement ps = conn.prepareStatement(GET_OVERPOPULATION_BREED_SQL)){
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


