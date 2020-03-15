package betting.main.webapp;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import betting.main.data.PlayerDTO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(PlayerService playerService) {
		return (args) -> {
			List<PlayerDTO> players = playerService.getListOfPlayers();
			for (PlayerDTO player : players) {
				System.out.println("PlayerID: " + player.getPlayerId() + " - PlayerName: " + player.getPlayerName());
			}
		};
	}
}
