package me.xhsun.guildwars2wrapper;

import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that contains some utility functions
 *
 * @author xhsun
 * @since 2017-06-28
 */
public class GuildWars2Utility {
	private static final String TAG = "<[^>]*>";
	private static final String FORMAT = "(?<=\\[)(&*)([^\\]]+)(?=\\])";
	private static final int ITEM_INDEX = 0;
	private static final byte TERMINAL = 0x00;
	//Chat link header supported: item, map, skill, trait, recipe, wardrobe, outfit
	private static final byte[] HEADER = new byte[]{0x02, 0x04, 0x06, 0x07, 0x09, 0x0A, 0x0B};

	public static final int CHAT_LINK_ERROR = -1;
	public static final int CHAT_LINK_NOT_SUPPORTED_ERROR = -2;
	/**
	 * get first id in a combined id, ie, get 7 from 7-54<br/>
	 *
	 * useful for getting wvw map id from wvw objective id, or
	 * getting back story question id from back story answer id
	 *
	 * @param id combined id in the form of [0-9]+-\b+
	 * @return root id | -1 for invalid input
	 */
	public static int getRootID(String id) {
		if (id == null || id.equals("")) return -1;
		String[] strIds;
		if (id.contains("-")) strIds = id.split("-");
		else return -1;
		try {
			return Integer.parseInt(strIds[0]);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	/**
	 * parse given coin value into number of gold, sliver, and copper
	 *
	 * @param value coin value
	 * @return results in array: index 0 is number of gold, index 1 is number of sliver, index 2 is number of copper
	 */
	public static long[] parseCoins(long value) {
		long[] result = new long[3];
		if (value < 0) return result;

		long temp = value;
		result[2] = temp % 100;
		temp = temp / 100;
		result[1] = temp % 100;
		result[0] = temp / 100;
		return result;
	}

	/**
	 * Remove HTML tag(s) and the string enclosed by HTML tags
	 * (ie, {@literal "<a>this</a>, that"} becomes ", that")<br/>
	 *
	 * @param value string to remove HTML from
	 * @return string without HTML
	 */
	public static String removeSimpleHTML(String value) {
		String rex = "<^[>]+/>|" + TAG + "[^<]*</[^>]*>|" + TAG;
		if (value == null || value.equals("")) return "";
		return value.replaceAll(rex, "");
	}

	/**
	 * remove HTML tag(s) from given string<br/>
	 * ie, "<a>this</a>, that" becomes "this, that"
	 *
	 * @param value string to strip HTML tag from
	 * @return string without HTML tag
	 */
	public static String removeHTMLTag(String value) {
		if (value == null || value.equals("")) return "";
		return value.replaceAll(TAG, "");
	}


	/**
	 * extract id from given chat link<br/>
	 * Currently supported chat link type:
	 * item, map, skill, trait, recipe, wardrobe, outfit
	 *
	 * @param chat_link chat link
	 * @return id |
	 * {@link GuildWars2Utility#CHAT_LINK_ERROR} if something is wrong with the given chat link |
	 * {@link GuildWars2Utility#CHAT_LINK_NOT_SUPPORTED_ERROR} if given chat link isn't supported
	 */
	public static int chatLinkToID(String chat_link) {
		String striped;
		byte[] decoded, id = new byte[4];
		int i, j = 3;
		boolean isFind = false;
		if (chat_link == null || chat_link.equals("")) return CHAT_LINK_ERROR;

		//strip Base64 string from chat link
		Pattern pattern = Pattern.compile(FORMAT);
		Matcher matcher = pattern.matcher(chat_link);
		if (matcher.find()) striped = matcher.group(2);
		else return CHAT_LINK_ERROR;

		try {//decode the Base64 string
			decoded = _decode(striped.getBytes());
			if (decoded == null) return CHAT_LINK_ERROR;
		} catch (IllegalArgumentException e) {
			return CHAT_LINK_ERROR;
		}

		//see if the chat link is the one supported
		for (i = 0; i < HEADER.length; i++) {
			if (HEADER[i] == decoded[0]) {
				isFind = true;
				break;
			}
		}
		if (!isFind) return CHAT_LINK_NOT_SUPPORTED_ERROR;

		//extract id
		for (i = (i == ITEM_INDEX) ? 2 : 1; i < decoded.length; i++) {
			if (decoded[i] == TERMINAL || j < 0) break;
			id[j--] = decoded[i];
		}

		return ByteBuffer.wrap(id).getInt();
	}

	/**
	 * This method come from <a href="https://github.com/karlroberts/base64">this</a> library<br/>
	 * Which is released under <a href="https://github.com/karlroberts/base64/blob/master/LICENSE">BSD 3-clause "New" or "Revised" License</a>:<br/>
	 *
	 * Copyright 2005-2013 Karl Roberts &lt;karl.roberts@owtelse.com&gt;
	 *
	 * All rights reserved.
	 *
	 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
	 * following conditions are met:
	 *
	 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
	 * disclaimer.
	 *
	 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
	 * following disclaimer in the documentation and/or other materials provided with the distribution.
	 *
	 * 3. Neither the name of the author nor the names of his contributors may be used to endorse or promote products
	 * derived from this software without specific prior written permission.
	 *
	 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
	 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
	 * ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHORS OR CONTRIBUTORS BE LIABLE
	 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
	 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
	 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
	 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
	 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
	 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
	 * SUCH DAMAGE.
	 *
	 * I use this method to decoding Base64 string, so that I don't have to relying on javax library or android library
	 * @param byteData Base64 string in byte array
	 * @return decoded byte array
	 * @throws IllegalArgumentException invalid input
	 */
	private static byte[] _decode(byte[] byteData) throws IllegalArgumentException {
	      /* If we received a null argument, exit this method. */
		if (byteData == null) {
			throw new IllegalArgumentException("byteData cannot be null");
		}

        /*
         * Declare working variables including an array of bytes that will
         * contain the decoded data to be returned to the caller. Note that the
         * decoded array is about 3/4 smaller than the input. This is because
         * every group of 4 bytes is being encoded into 3 bytes.
         */
		int iSrcIdx; // index into source (byteData)
		int reviSrcIdx; // index from end of the src array (byteData)
		int iDestIdx; // index into destination (byteDest)
		byte[] byteTemp = new byte[byteData.length];

        /*
         * remove any '=' chars from the end of the byteData they would have
         * been padding to make it up to groups of 4 bytes note that I don't
         * need to remove it just make sure that when progressing throug array
         * we don't go past reviSrcIdx ;-)
         */
		for (reviSrcIdx = byteData.length; reviSrcIdx - 1 > 0 && byteData[reviSrcIdx - 1] == '='; reviSrcIdx--) {
			// do nothing. I'm just interested in value of reviSrcIdx
		}

        /* sanity check */
		if (reviSrcIdx - 1 == 0) {
			return null; /* ie all padding */
		}

        /*
         * Set byteDest, this is smaller than byteData due to 4 -> 3 byte munge.
         * Note that this is an integer division! This fact is used in the logic
         * l8r. to make sure we don't fall out of the array and create an
         * OutOfBoundsException and also in handling the remainder
         */
		byte byteDest[] = new byte[((reviSrcIdx * 3) / 4)];

        /*
         * Convert from Base64 alphabet to encoded data (The Base64 alphabet is
         * completely documented in RFC 1521.) The order of the testing is
         * important as I use the '<' operator which looks at the hex value of
         * these ASCII chars. So convert from the smallest up
         *
         * do all of this in a new array so as not to edit the original input
         */
		for (iSrcIdx = 0; iSrcIdx < reviSrcIdx; iSrcIdx++) {
			if (byteData[iSrcIdx] == '+')
				byteTemp[iSrcIdx] = 62;
			else if (byteData[iSrcIdx] == '/')
				byteTemp[iSrcIdx] = 63;
			else if (byteData[iSrcIdx] < '0' + 10)
				byteTemp[iSrcIdx] = (byte) (byteData[iSrcIdx] + 52 - '0');
			else if (byteData[iSrcIdx] < ('A' + 26))
				byteTemp[iSrcIdx] = (byte) (byteData[iSrcIdx] - 'A');
			else if (byteData[iSrcIdx] < 'a' + 26)
				byteTemp[iSrcIdx] = (byte) (byteData[iSrcIdx] + 26 - 'a');
		}

        /*
         * 4bytes -> 3bytes munge Walk through the input array, 32 bits at a
         * time, converting them from 4 groups of 6 to 3 groups of 8 removing
         * the two unset most significant bits of each sorce byte as this was
         * filler, as per Base64 spec. stop before potential buffer overun on
         * byteDest, remember that byteDest is 3/4 (integer division) the size
         * of input and won't necessary divide exactly (ie iDestIdx must be <
         * (integer div byteDest.length / 3)*3 see
         * http://www.javaworld.com/javaworld/javatips/jw-javatip36-p2.html for
         * example
         */
		for (iSrcIdx = 0, iDestIdx = 0; iSrcIdx < reviSrcIdx
				&& iDestIdx < ((byteDest.length / 3) * 3); iSrcIdx += 4) {
			byteDest[iDestIdx++] = (byte) ((byteTemp[iSrcIdx] << 2) & 0xFC | (byteTemp[iSrcIdx + 1] >>> 4) & 0x03);
			byteDest[iDestIdx++] = (byte) ((byteTemp[iSrcIdx + 1] << 4) & 0xF0 | (byteTemp[iSrcIdx + 2] >>> 2) & 0x0F);
			byteDest[iDestIdx++] = (byte) ((byteTemp[iSrcIdx + 2] << 6) & 0xC0 | byteTemp[iSrcIdx + 3] & 0x3F);
		}

        /*
         * tidy up any remainders if iDestIdx >= ((byteDest.length / 3)*3) but
         * iSrcIdx < reviSrcIdx then we have at most 2 extra destination bytes
         * to fill and posiblr 3 input bytes yet to process
         */
		if (iSrcIdx < reviSrcIdx) {
			if (iSrcIdx < reviSrcIdx - 2) {
				// "3 input bytes left"
				byteDest[iDestIdx++] = (byte) ((byteTemp[iSrcIdx] << 2) & 0xFC | (byteTemp[iSrcIdx + 1] >>> 4) & 0x03);
				byteDest[iDestIdx++] = (byte) ((byteTemp[iSrcIdx + 1] << 4) & 0xF0 | (byteTemp[iSrcIdx + 2] >>> 2) & 0x0F);
			} else if (iSrcIdx < reviSrcIdx - 1) {
				// "2 input bytes left"
				byteDest[iDestIdx++] = (byte) ((byteTemp[iSrcIdx] << 2) & 0xFC | (byteTemp[iSrcIdx + 1] >>> 4) & 0x03);
			}
	          /*
             * wont have just one input byte left (unless input wasn't base64
             * encoded ) due to the for loop steps and array sizes, after "="
             * pad removed, but for compleatness
             */
			else {
				throw new IllegalArgumentException("Warning: 1 input bytes left to process. This was not Base64 input");
			}
		}
		return byteDest;
	}
}
