package db.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.dtos.SpielerStatisitkDB;
import db.entity.Tournament;

@Transactional
@Repository("spielerTabelleRepository")
public class SpielerTabelleRepository {

	private static final String QUERY_STATISTIK_SINGLE_SPIELER = "SELECT COUNT(betting_pick_id) "
			+ " AS gespielteWetten, COUNT(betting_pick_result) AS gewonnenePunkte FROM betting_picks  "
			+ " WHERE user_name = ?";

	@PersistenceContext
	private EntityManager entityManager;


	private Connection getConnection() throws SQLException {
		String url= "jdbc:postgresql://localhost:5432/betting_db";
		String username = "michl";
		String password = "michl";
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	
	
	public SpielerStatisitkDB findeSpielerStatisitikenZuUsername(String username) {
		try (Connection connection = getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_STATISTIK_SINGLE_SPIELER);){
			
			preparedStatement.setString(1, username);
			SpielerStatisitkDB spielerStatistik = new  SpielerStatisitkDB();
			try (ResultSet rs = preparedStatement.executeQuery();) {
		        while (rs.next()) {
		        	spielerStatistik.setAnzahlErhaltenePunkte(rs.getInt("gewonnenePunkte"));
		        	spielerStatistik.setAnzahlGespielteWetten(rs.getInt("gespielteWetten"));
		        	return spielerStatistik;
		        }
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public	List<Tournament> findAllTournaments(){
		return entityManager.createNamedQuery("Tournament.findAll").getResultList();
	}
	
}
