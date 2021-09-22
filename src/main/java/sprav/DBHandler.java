package sprav;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.charset.Charset;
import java.sql.*;

public class DBHandler {

    private Connection conn;
    private Statement stmt;
    //private ResultSet rs;

    public DBHandler() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String username=System.getProperty("user.name");
            String password="Infundibulum89";
            conn = DriverManager.getConnection("jdbc:ucanaccess://TS1.accdb;jackcessOpener=sprav.CryptCodecOpener", username, password);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ObservableList<Subscriber> selectAllPhonesInBase(){
        ObservableList<Subscriber> subscriberObservableList = FXCollections.observableArrayList();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM UFSB_po_habarovskomu_krau");
            while (rs.next()) {
                subscriberObservableList.add(new Subscriber(
                        rs.getInt("Код"),
                        rs.getString("FIO"),
                        rs.getString("Podrazdelenie"),
                        rs.getString("Kabinet"),
                        rs.getString("NS"),
                        rs.getString("ZS"),
                        rs.getString("PM"),
                        rs.getString("OtherTEL"),
                        rs.getString("Dopolnitel"),
                        rs.getString("OrganBezopasnosti"),
                        rs.getString("StrukturnoePodrazdelenie")
                ));
            }
            //int i = stmt.executeUpdate("INSERT INTO phones ('fio', 'doljnost', 'phone') VALUES ('fio','qwe','123')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subscriberObservableList;
    }

    public ObservableList<Subscriber> searchPhones(String searchText){
        ObservableList<Subscriber> subscriberObservableList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM UFSB_po_habarovskomu_krau WHERE LOWER(fio) like LOWER(?) ");
            ps.setString(1, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println(rs.getInt("id"));
                //System.out.println(rs.getString("fio"));
                subscriberObservableList.add(new Subscriber(
                        rs.getInt("Код"),
                        rs.getString("FIO"),
                        rs.getString("Podrazdelenie"),
                        rs.getString("Kabinet"),
                        rs.getString("NS"),
                        rs.getString("ZS"),
                        rs.getString("PM"),
                        rs.getString("OtherTEL"),
                        rs.getString("Dopolnitel"),
                        rs.getString("OrganBezopasnosti"),
                        rs.getString("StrukturnoePodrazdelenie")
                ));
            }
            //int i = stmt.executeUpdate("INSERT INTO phones ('fio', 'doljnost', 'phone') VALUES ('fio','qwe','123')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subscriberObservableList;

    }

    public void disconnect(){
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
            System.out.println("Закрыто соединение с БД");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
