package ir.ninjacoder.prograsssheet.interfaces;

public interface MediaPlayerListener {

  void isPlaying(int currentDuration);

  void onPause();

  void onStart();
}
