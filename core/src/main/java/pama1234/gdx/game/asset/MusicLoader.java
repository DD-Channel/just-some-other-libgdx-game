package pama1234.gdx.game.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;

public class MusicLoader{
  public static Music //
  alsoSprachZarathustra,
    moonlightSonata;
  public static void load_0002(AssetManager manager) {
    load_init();
    load_0001(manager);
  }
  public static void load_init() {
    alsoSprachZarathustra=load("Also-sprach-Zarathustra.mp3");
  }
  public static void load_0001(AssetManager manager) {
    // moonlightSonata=load("Beethoven-Moonlight-Sonata.mp3");
    manager.load("music/Beethoven-Moonlight-Sonata.mp3",Music.class);
  }
  public static void put_0001(AssetManager manager) {
    moonlightSonata=manager.get("music/Beethoven-Moonlight-Sonata.mp3");
  }
  //----------------------------------------------------
  public static Music load(String in) {
    return Gdx.audio.newMusic(Gdx.files.internal("music/"+in));
  }
}
