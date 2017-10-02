package me.xhsun.guildwars2wrapper;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test all utility functions
 *
 * @author xhsun
 * @since 2017-06-29
 */
public class GuildWars2UtilityTest {

	@Test
	public void testGetRootIDValidInput() throws Exception {
		assertEquals(26, GuildWars2Utility.getRootID("26-20"));
	}

	@Test
	public void testGetRootIDInputValidFormat() throws Exception {
		assertEquals(22, GuildWars2Utility.getRootID("22-a"));
	}

	@Test
	public void testGetRootIDInputIsNumber() throws Exception {
		assertEquals(-1, GuildWars2Utility.getRootID("25"));
	}

	@Test
	public void testGetRootIDInputIsString() throws Exception {
		assertEquals(-1, GuildWars2Utility.getRootID("at this"));
	}

	@Test
	public void testGetRootIDInputInvalidFormat() throws Exception {
		assertEquals(-1, GuildWars2Utility.getRootID("a-a"));
		assertEquals(-1, GuildWars2Utility.getRootID("a-23"));
	}

	@Test
	public void testParseCoinsValidInput() throws Exception {
		assertArrayEquals(new long[]{0, 1, 99}, GuildWars2Utility.parseCoins(199));
	}

	@Test
	public void testParseCoinsInvalidInput() throws Exception {
		assertArrayEquals(new long[3], GuildWars2Utility.parseCoins(-1));
	}

	@Test
	public void testParseCoinsMaxCoin() throws Exception {
		assertArrayEquals(new long[]{200000, 0, 0}, GuildWars2Utility.parseCoins(2000000000));
	}

	@Test
	public void testParseCoinsCopperOnly() throws Exception {
		assertArrayEquals(new long[]{0, 0, 99}, GuildWars2Utility.parseCoins(99));
	}

	@Test
	public void testParseCoinsSliverOnly() throws Exception {
		assertArrayEquals(new long[]{0, 3, 0}, GuildWars2Utility.parseCoins(300));
	}

	@Test
	public void testParseCoinsGoldOnly() throws Exception {
		assertArrayEquals(new long[]{6, 0, 0}, GuildWars2Utility.parseCoins(60000));
	}

	@Test
	public void testParseCoinsCombinedValue() throws Exception {
		assertArrayEquals(new long[]{9, 99, 99}, GuildWars2Utility.parseCoins(99999));
	}

	@Test
	public void testRemoveHTMLTagInvalidInput() throws Exception {
		assertEquals("", GuildWars2Utility.removeHTMLTag(null));
	}

	@Test
	public void testRemoveHTMLTagValidInput() throws Exception {
		assertEquals("this, that", GuildWars2Utility.removeHTMLTag("<a>this</a>, that"));
	}

	@Test
	public void testRemoveHTMLTagNoTag() throws Exception {
		assertEquals("this, that", GuildWars2Utility.removeHTMLTag("this, that"));
	}

	@Test
	public void testRemoveHTMLTagNoClosingSign() throws Exception {
		assertEquals("this < 1, that", GuildWars2Utility.removeHTMLTag("<a>this < 1, that"));
	}

	@Test
	public void testRemoveHTMLTagNoStartSign() throws Exception {
		assertEquals("1 > this, that", GuildWars2Utility.removeHTMLTag("1 > this, that"));
	}

	@Test
	public void testRemoveHTMLInvalidInput() throws Exception {
		assertEquals("", GuildWars2Utility.removeSimpleHTML(null));
	}

	@Test
	public void testRemoveHTMLValidInput() throws Exception {
		assertEquals(", that", GuildWars2Utility.removeSimpleHTML("<a>this</a>, that"));
	}

	@Test
	public void testRemoveHTMLNotSurroundByTags() throws Exception {
		assertEquals("this, that", GuildWars2Utility.removeSimpleHTML("<a>this, that"));
	}

	@Test
	public void testRemoveHTMLNoClosingSign() throws Exception {
		assertEquals("this</a, that", GuildWars2Utility.removeSimpleHTML("<a>this</a, that"));
	}

	@Test
	public void testRemoveHTMLNoStartSign() throws Exception {
		assertEquals("a>this, that", GuildWars2Utility.removeSimpleHTML("a>this</a>, that"));
	}

	@Test
	public void testRemoveHTMLSurroundByTag() throws Exception {
		assertEquals("that,this, that", GuildWars2Utility.removeSimpleHTML("that,<br/>this,<br/> that"));
	}

	@Test
	public void testRemoveHTMLTagBeforeEnclosed() throws Exception {
		assertEquals("that, that", GuildWars2Utility.removeSimpleHTML("that,<br/><sub>this,</sub> that"));
	}

	@Test
	public void testRemoveHTMLTagAfterEnclosed() throws Exception {
		assertEquals("that, that", GuildWars2Utility.removeSimpleHTML("that,<sub>this,</sub><br/> that"));
	}

	@Test
	public void testChatLinkToIDInvalidInput() throws Exception {
		assertEquals(GuildWars2Utility.CHAT_LINK_ERROR, GuildWars2Utility.chatLinkToID(null));
	}

	@Test
	public void testChatLinkToIDInvalidFormat() throws Exception {
		assertEquals(GuildWars2Utility.CHAT_LINK_ERROR, GuildWars2Utility.chatLinkToID("&AQAAAAA=]"));
	}

	@Test
	public void testChatLinkToIDNotSupportedLink() throws Exception {
		assertEquals(GuildWars2Utility.CHAT_LINK_NOT_SUPPORTED_ERROR, GuildWars2Utility.chatLinkToID("[&AdsnAAA=]"));
	}

	@Test
	public void testChatLinkToIDItemLink() throws Exception {
		assertEquals(46762, GuildWars2Utility.chatLinkToID("[&AgGqtgAA]"));
	}

	@Test
	public void testChatLinkToIDComplexItemLink() throws Exception {
		assertEquals(46762, GuildWars2Utility.chatLinkToID("[&AgGqtgDgfQ4AAP9fAAAnYAAA]"));
	}

	@Test
	public void testChatLinkToIDMapLink() throws Exception {
		assertEquals(56, GuildWars2Utility.chatLinkToID("[&BDgAAAA=]"));
	}

	@Test
	public void testChatLinkToIDSkillLink() throws Exception {
		assertEquals(5491, GuildWars2Utility.chatLinkToID("[&BnMVAAA=]"));
	}

	@Test
	public void testChatLinkToIDTraitLink() throws Exception {
		assertEquals(1896, GuildWars2Utility.chatLinkToID("[&B2gHAAA=]"));
	}

	@Test
	public void testChatLinkToIDRecipeLink() throws Exception {
		assertEquals(7, GuildWars2Utility.chatLinkToID("[&CQcAAAA=]"));
	}

	@Test
	public void testChatLinkToIDWardrobeLink() throws Exception {
		assertEquals(732, GuildWars2Utility.chatLinkToID("[&CtwCAAA=]"));
	}

	@Test
	public void testChatLinkToIDOutfitLink() throws Exception {
		assertEquals(12, GuildWars2Utility.chatLinkToID("[&CwwAAAA=]"));
	}
}
