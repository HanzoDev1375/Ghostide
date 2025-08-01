package com.ninjacoder.jgit.childer;

import com.itsaky.androidide.fuzzysearch.FuzzySearch;
import java.util.Locale;

/**
 * @author Akash Yadav
 * tnks for Android ide by FuzzySearch
 */
public class StringUtils {

  public static boolean matchesFuzzy(CharSequence candidate, CharSequence partialName) {
    return matchesFuzzy(candidate, partialName, false);
  }

  public static boolean matchesFuzzy(
      CharSequence candidate, CharSequence partialName, boolean allLower) {
    return fuzzySearchRatio(candidate, partialName, allLower) > 0;
  }

  public static int fuzzySearchRatio(
      CharSequence candidate, CharSequence partial, boolean allLower) {
    return fuzzySearchRatio(candidate, partial, allLower, true);
  }

  public static int fuzzySearchRatio(
      CharSequence candidate, CharSequence partialName, boolean allLower, boolean partial) {

    if (candidate == null || partialName == null || candidate.length() < partialName.length()) {
      return 0;
    }

    var first = candidate.toString();
    var second = partialName.toString();

    if (allLower) {
      first = first.toLowerCase(Locale.ROOT);
      second = first.toLowerCase(Locale.ROOT);
    }

    if (partial) {
      return FuzzySearch.partialRatio(first, second);
    } else {
      return FuzzySearch.ratio(first, second);
    }
  }

  public static int fuzzySearchTokenSortPartialRatio(
      CharSequence candidate, CharSequence partialName, boolean allLower) {
    if (candidate == null || partialName == null || candidate.length() < partialName.length()) {
      return 0;
    }

    var first = candidate.toString();
    var second = partialName.toString();

    if (allLower) {
      first = first.toLowerCase(Locale.ROOT);
      second = first.toLowerCase(Locale.ROOT);
    }
    return FuzzySearch.tokenSetPartialRatio(first, second);
  }

  public static boolean matchesPartialName(String name, String partialName) {
    return matchesPartialName(name, partialName, false);
  }

  public static boolean matchesPartialName(
      CharSequence candidate, CharSequence partialName, boolean allLower) {
    if (candidate == null || partialName == null || candidate.length() < partialName.length()) {
      return false;
    }

    for (int i = 0; i < partialName.length(); i++) {
      char char1 = candidate.charAt(i);
      char char2 = partialName.charAt(i);

      // Match by keeping the first character of the partial name and candidate as is
      // Then make all the characters lower case
      // So if the first character is upper case, we could assume that the user is expecting a
      // class name
      // Otherwise a variable name
      if (allLower || i != 0) {
        char1 = Character.toLowerCase(char1);
        char2 = Character.toLowerCase(char2);
      }

      if (char1 != char2) {
        return false;
      }
    }
    return true;
  }
}
