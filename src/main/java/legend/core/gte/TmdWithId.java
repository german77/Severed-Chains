package legend.core.gte;

import legend.game.unpacker.FileData;

public class TmdWithId {
  public final long id;
  public final Tmd tmd;

  public TmdWithId(final FileData data) {
    this.id = data.readInt(0x0);
    this.tmd = new Tmd(data.slice(0x4));
  }
}
