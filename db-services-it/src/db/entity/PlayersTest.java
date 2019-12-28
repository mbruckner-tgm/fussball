package db.entity;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import db.service.PlayersRepository;


@RunWith(Arquillian.class)
public class PlayersTest {
	
	@Inject
	PlayersRepository playersRepository;
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(PlayersRepository.class).addAsManifestResource(EmptyAsset.INSTANCE,
				"beans.xml");
	}

	@Test
	public void should_create_greeting() {
		List<Player> players =  playersRepository.selectAllPlayers();
		Assert.assertNotNull(players);
		System.out.println(players);
	}
}
