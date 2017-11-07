package me.xhsun.guildwars2wrapper.v1;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import me.xhsun.guildwars2wrapper.*;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v1.*;
import me.xhsun.guildwars2wrapper.request.*;

/**
 * Test all supported API:1 endpoints and print out result from each endpoint
 *
 * @author xhsun
 * @since 2017-06-30
 */
public class GuildWars2V1URLTest {
	private SynchronousRequest s = GuildWars2.getInstance().getSynchronous();

	//TODO remove comment to set language
//	@Before
//	public void setUp() throws Exception {
//		GuildWars2.setLanguage(GuildWars2.LanguageSelect.Spanish);
//	}

	@Test
	public void getAllEventDetailedInfo() throws Exception {
		try {
			for (Map.Entry<String, EventDetail.Event> e : s.getAllEventDetailedInfo().getEvents().entrySet()) {
				EventDetail.Event event = e.getValue();
				EventDetail.EventLocation loc = event.getLocation();
				System.out.println("ID (" + e.getKey() + "): " + "Event{" +
						"name='" + event.getName() + '\'' +
						", level=" + event.getLevel() +
						", map_id=" + event.getMapId() +
						", flags=" + event.getFlags() +
						", location=" + "EventLocation{" +
						"type=" + loc.getType() +
						", center=" + Arrays.toString(loc.getCenter()) +
						", z_range=" + Arrays.toString(loc.getZRange()) +
						", points=" + Arrays.toString(loc.getPoints()) +
						", height=" + loc.getHeight() +
						", radius=" + loc.getRadius() +
						", rotation=" + loc.getRotation() +
						'}' + '}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getEventDetailedInfo() throws Exception {
		try {
			s.getEventDetailedInfo("a");//TODO comment out if want to see single value
			for (Map.Entry<String, EventDetail.Event> e : s.getEventDetailedInfo("EED8A79F-B374-4AE6-BA6F-B7B98D9D7142").getEvents().entrySet()) {
				EventDetail.Event event = e.getValue();
				EventDetail.EventLocation loc = event.getLocation();
				System.out.println("ID (" + e.getKey() + "): " + "Event{" +
						"name='" + event.getName() + '\'' +
						", level=" + event.getLevel() +
						", map_id=" + event.getMapId() +
						", flags=" + event.getFlags() +
						", location=" + "EventLocation{" +
						"type=" + loc.getType() +
						", center=" + Arrays.toString(loc.getCenter()) +
						", z_range=" + Arrays.toString(loc.getZRange()) +
						", points=" + Arrays.toString(loc.getPoints()) +
						", height=" + loc.getHeight() +
						", radius=" + loc.getRadius() +
						", rotation=" + loc.getRotation() +
						'}' + '}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllMapNames() throws Exception {
		try {
			System.out.println(s.getAllMapNames());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllWorldNames() throws Exception {
		try {
			System.out.println(s.getAllWorldNames());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllWvWMatchOverview() throws Exception {
		try {
			for (AllWvWMatchOverview.MatchOverview m : s.getAllWvWMatchOverview().getWvWMatches()) {
				System.out.println("MatchOverview{" +
						"wvw_match_id='" + m.getWvWMatchId() + '\'' +
						", start_time='" + m.getStartTime() + '\'' +
						", end_time='" + m.getEndTime() + '\'' +
						", red_world_id=" + m.getRedWorldId() +
						", blue_world_id=" + m.getBlueWorldId() +
						", green_world_id=" + m.getGreenWorldId() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllWvWObjectiveNames() throws Exception {
		try {
			System.out.println(s.getAllWvWObjectiveNames());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	private void handleException(GuildWars2Exception e) {
		switch (e.getErrorCode()) {
			case Limit:
			case Network:
				fail("Check your network connection");
				break;
			case Server:
				fail("Wrong URL");
			case Other:
				if (e.getMessage().matches("Endpoint not available"))
				fail("Disabled Endpoint");
		default:
			fail("Wrong error code");
		}
	}
}
