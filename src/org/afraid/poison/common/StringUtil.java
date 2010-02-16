/*
 * Some utilities for strings
 */
package org.afraid.poison.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.afraid.poison.common.string.StringOccurrence;

/**
 *
 * @author poison
 */
public class StringUtil {

	public static final CharSequence EMTPY="";

	private StringUtil() {
	}

	/**
	 * repeat passed string specified number of times
	 *
	 * @param string the string to repeat
	 * @param times number of times to repeat the string
	 * @return the repeated string
	 */
	public static String repeat(String string, int times) {
		StringBuilder str=new StringBuilder();
		for (int i=0; i<times; ++i) {
			str.append(string);
		}
		return str.toString();
	}

	/**
	 * pad passed string with passed padchar until the total length reaches the passed length
	 *
	 * @param string the string to pad
	 * @param padchar the string with which to pad
	 * @param length the desired total length of the string
	 * @return the padded string
	 */
	public static String padLeft(String string, String padchar, int length) {
		int spaces=length-string.length();
		StringBuilder str=new StringBuilder(repeat(padchar, spaces));
		str.append(string);
		return str.toString();
	}

	/**
	 * pad passed string with passed padchar until the total length reaches the passed length
	 *
	 * @param i the int to pad
	 * @param padchar the string with which to pad
	 * @param length the desired total length of the string
	 * @return the padded string
	 */
	public static String padLeft(int i, String padchar, int length) {
		return padLeft(Integer.toString(i), padchar, length);
	}

	/**
	 * pad passed string with passed padchar until the total length reaches the passed length
	 *
	 * @param l the long to pad
	 * @param padchar the string with which to pad
	 * @param length the desired total length of the string
	 * @return the padded string
	 */
	public static String padLeft(long l, String padchar, int length) {
		return padLeft(Long.toString(l), padchar, length);
	}

	/**
	 * pad passed string with passed padchar until the total length reaches the passed length
	 *
	 * @param string the string to pad
	 * @param padchar the string with which to pad
	 * @param length the desired total length of the string
	 * @return the padded string
	 */
	public static String padRight(String string, String padchar, int length) {
		int spaces=length-string.length();
		StringBuilder str=new StringBuilder(string);
		str.append(repeat(padchar, spaces));
		return str.toString();
	}

	/**
	 * pad passed string with passed padchar until the total length reaches the passed length
	 *
	 * @param i the int to pad
	 * @param padchar the string with which to pad
	 * @param length the desired total length of the string
	 * @return the padded string
	 */
	public static String padRight(int i, String padchar, int length) {
		return padRight(Integer.toString(i), padchar, length);
	}

	/**
	 * pad passed string with passed padchar until the total length reaches the passed length
	 *
	 * @param l the long to pad
	 * @param padchar the string with which to pad
	 * @param length the desired total length of the string
	 * @return the padded string
	 */
	public static String padRight(long l, String padchar, int length) {
		return padRight(Long.toString(l), padchar, length);
	}

	/**
	 * split up string at specified lengths
	 *
	 * @param str the string to split
	 * @param len the length
	 * @return the splitted string
	 */
	public static Collection<String> splitToLength(String str, int len) {
		List<String> res=new ArrayList<String>();
		int slen=str.length();
		for (int spos=0; spos<=slen; spos+=len) {
			res.add(
					str.substring(
					spos,
					spos+len>slen ? slen : len));
		}
		return res;
	}

	/**
	 * make first character if the string uppercase and the rest lowercase
	 *
	 * @param str the string to capitalize
	 * @return the capitalized string
	 */
	public static String capitalize(String str) {
		return firstCharToUpperCase(str.toLowerCase());
	}

	/**
	 * make first character uppercase
	 *
	 * @param str the string to work on
	 * @return the resulting string
	 */
	public static String firstCharToUpperCase(String str) {
		if (0==str.length()) {
			return str;
		}
		return new StringBuilder(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
	}

	/**
	 * make first character lowercase
	 *
	 * @param str the string to work on
	 * @return the resulting string
	 */
	public static String firstCharToLowerCase(String str) {
		if (0==str.length()) {
			return str;
		}
		return new StringBuilder(str.substring(0, 1).toLowerCase()).append(str.substring(1)).toString();
	}

	/**
	 * searches for occurrences and returns StringOccurrence#s so the position is known
	 * @param needle the string to search for
	 * @param haystack the string to search input
	 * @return the found occurrences
	 */
	public static Set<StringOccurrence> findOccurrences(String needle, String haystack) {
		Set<StringOccurrence> occurrences=new HashSet<StringOccurrence>();
		int lastEnd=0;
		int pos;
		StringOccurrence so;
		while (-1!=(pos=haystack.indexOf(needle, lastEnd))) {
			so=new StringOccurrence(needle, pos);
			occurrences.add(so);
			lastEnd=so.getEnd();
		}
		return occurrences;
	}

	public static CharSequence notNull(CharSequence cs) {
		if (null==cs) {
			return EMTPY;
		}
		return cs;
	}

	/**
	 * replace all keys from input with values from input
	 *
	 * @param input the input string
	 * @param replacements the replacements
	 * @return string with all occurrences replaced
	 */
	public static CharSequence replace(Object input, Map<?, ?> replacements) {
		String s=input.toString();
		for (Map.Entry<?, ?> e : replacements.entrySet()) {
			s=s.replace(e.getKey().toString(), e.getValue().toString());
		}
		return s;
	}

	/**
	 * Splits the needle by its upper case characters
	 * and checks if the parts are contained in the haystack in the same order.
	 *
	 * @param needle
	 * @param haystack
	 * @param requireBeginning if the haystack string has to start with the needle string part
	 * @return
	 */
	private static final boolean matchesCamelCase(String needle, String haystack, boolean requireBeginning) {
		//System.err.println("---------------");
		//System.err.println(needle);
		//System.err.println(haystack);
		String[] needleParts=needle.replaceAll("[A-Z0-9]", " $0").trim().split("\\s+"); // TODO: quick & dirty, implement splitPreserveDelimiter
		//String[] needleParts=needle.replaceAll("([A-Z]+)([^A-Z]|$)", " $1 $2").trim().split("\\s+"); // TODO: quick & dirty, implement splitPreserveDelimiter
		//System.err.println(CollectionUtil.fromArray(needleParts));
		int lastEnd=0;
		int pos=0;
		boolean allowSkip=false;
		for (String needlePart : needleParts) {
			pos=haystack.indexOf(needlePart, lastEnd);
			if (-1==pos) {
				return false;
			}
			if (requireBeginning && 0==lastEnd && 0!=pos) {
				return false;
			}
			//System.err.println("haystackPart: " + haystack.substring(lastEnd, pos));
			if (!allowSkip && haystack.substring(lastEnd, pos).matches("[^A-Z0-9]+[A-Z0-9]+[^A-Z0-9]+")) {
				return false;
			}
			lastEnd=pos+needlePart.length();
		}
		return true;
	}
}
