package com.ninjacoder.jgit;

import java.time.Duration;
import org.eclipse.jgit.lib.BatchingProgressMonitor;

public class Test extends BatchingProgressMonitor {

  private String[] param;

  public Test(String[] param) {
    this.param = param;
  }

  @Override
  protected void onUpdate(String taskName, int workCurr, Duration arg2) {}

  @Override
  protected void onEndTask(String taskName, int workCurr, Duration arg2) {}

  @Override
  protected void onUpdate(
      String taskName, int workCurr, int workTotal, int percentDone, Duration arg4) {}

  @Override
  protected void onEndTask(
      String taskName, int workCurr, int workTotal, int percentDone, Duration arg4) {}
}
