package io.github.rosemoe.sora.langs.internal;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Identifiers {
  private static final Object SIGN = new Object();
  private final List<String> identifiers = new ArrayList<>();
  private HashMap<String, Object> cache;

  public void addIdentifier(String identifier) {
    if (cache == null) {
      throw new IllegalStateException("begin() has not been called");
    }
    if (cache.put(identifier, SIGN) == SIGN) {
      return;
    }
    identifiers.add(identifier);
  }

  public void begin() {
    cache = new HashMap<>();
  }

  public void finish() {
    cache.clear();
    cache = null;
  }

  public List<String> getIdentifiers() {
    return identifiers;
  }
}
