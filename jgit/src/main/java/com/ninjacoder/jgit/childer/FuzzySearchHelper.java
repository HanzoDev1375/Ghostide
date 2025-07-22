package com.ninjacoder.jgit.childer;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class FuzzySearchHelper {

  public static boolean isFuzzyMatch(String input, String target) {
    if (input == null || target == null) return false;
    return StringUtils.matchesFuzzy(input, target);
  }
}
