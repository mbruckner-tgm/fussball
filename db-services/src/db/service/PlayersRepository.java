package db.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.connection.PSQLConnectorService;
import db.entity.Player;

public class PlayersRepository {
	
	public List<Player> selectAllPlayers() {
		PSQLConnectorService psqlConnectorService = new PSQLConnectorService();
		List<Player> players = new ArrayList<>();
		String selectAllFromPlayers = "SELECT * FROM players";
		
		try (Connection connection = psqlConnectorService.createConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(selectAllFromPlayers)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player();
				player.setPlayerId(resultSet.getString("player_id"));
				player.setPlayerName(resultSet.getString("player_name"));
				players.add(player);
			}
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return players;
	}
	
	
	public static void main(String[] args) {
		PlayersRepository playersRepository = new PlayersRepository();
		List<Player> players = playersRepository.selectAllPlayers();
		players.forEach(entry -> System.out.println(entry.toString()));
	}
	
}
