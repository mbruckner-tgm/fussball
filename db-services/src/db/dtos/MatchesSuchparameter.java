package db.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MatchesSuchparameter {

	Optional<Date> gesuchterSpieltag;
	Optional<String> gesuchtesTeam;
	Optional<String> gesuchtesTurnier;
	Optional<Date> stichtag;

	public MatchesSuchparameter(String gesuchterSpieltag, String gesuchtesTeam, String gesuchtesTurnier,
			String stichtag) throws ParseException {
		super();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.gesuchterSpieltag = Optional
				.ofNullable(gesuchterSpieltag.isEmpty() ?  null : dateFormat.parse(gesuchterSpieltag) );
		this.gesuchtesTeam = Optional.ofNullable(gesuchtesTeam);
		this.gesuchtesTurnier = Optional.ofNullable(gesuchtesTurnier);
		if (gesuchterSpieltag.isEmpty() && gesuchtesTeam.isEmpty() && gesuchtesTurnier.isEmpty()) {
			this.stichtag = Optional
					.ofNullable(stichtag.isEmpty() ? new Date(System.currentTimeMillis()) : dateFormat.parse(stichtag));
		}
	}

	public Optional<Date> getGesuchterSpieltag() {
		return gesuchterSpieltag;
	}

	public Optional<String> getGesuchtesTeam() {
		return gesuchtesTeam;
	}

	public Optional<String> getGesuchtesTurnier() {
		return gesuchtesTurnier;
	}

	public Optional<Date> getStichtag() {
		return stichtag;
	}

	@Override
	public String toString() {
		return "MatchesSuchparameter [gesuchterSpieltag=" + gesuchterSpieltag + ", gesuchtesTeam=" + gesuchtesTeam
				+ ", gesuchtesTurnier=" + gesuchtesTurnier + ", stichtag=" + stichtag + "]";
	}

}
