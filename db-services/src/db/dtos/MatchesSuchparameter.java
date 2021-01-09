package db.dtos;

import java.util.Optional;

public class MatchesSuchparameter {

	Optional<String> gesuchterSpieltag;
	Optional<String> gesuchtesTeam;
	Optional<String> gesuchtesTurnier;

	public MatchesSuchparameter(Optional<String> gesuchterSpieltag, Optional<String> gesuchtesTeam, Optional<String> gesuchtesTurnier) {
		super();
		this.gesuchterSpieltag = gesuchterSpieltag;
		this.gesuchtesTeam = gesuchtesTeam;
		this.gesuchtesTurnier = gesuchtesTurnier;
	}

	public Optional<String> getGesuchterSpieltag() {
		return gesuchterSpieltag;
	}

	public Optional<String> getGesuchtesTeam() {
		return gesuchtesTeam;
	}

	public Optional<String> getGesuchtesTurnier() {
		return gesuchtesTurnier;
	}

	

}
