package legend.game.scripting;

import legend.game.SMap;
import legend.game.Scus94491BpeSegment_8006;
import legend.game.Scus94491BpeSegment_800b;
import legend.game.combat.Bttl_800c;
import legend.game.combat.types.BattleStructEF4.SpecialEffects20;

public class GameVarArrayParam extends Param {
  private final int varIndex;
  private final int arrIndex;

  public GameVarArrayParam(final int varIndex, final int arrIndex) {
    this.varIndex = varIndex;
    this.arrIndex = arrIndex;
  }

  @Override
  public int get() {
    return switch(this.varIndex) {
      case 17 -> Scus94491BpeSegment_800b.gameState_800babc8.charIndex_88.get(this.arrIndex).get();
      case 32 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_e0c[this.arrIndex];
      case 34 -> Scus94491BpeSegment_8006._8006e398.charBobjIndices_e40[this.arrIndex];
      case 36 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_e50[this.arrIndex];
      case 41 -> Scus94491BpeSegment_800b.itemsDroppedByEnemies_800bc928.get(this.arrIndex).get();
      case 45 -> this.readCombatVar(this.arrIndex);
      case 46 -> Bttl_800c.intRef_800c6718.get(this.arrIndex).get();
      case 48 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_e78[this.arrIndex];
      case 50 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_eac[this.arrIndex];
      case 52 -> Scus94491BpeSegment_8006._8006e398.enemyBobjIndices_ebc[this.arrIndex];
      case 64 -> SMap.sobjIndices_800c6880.get(this.arrIndex).get();
      case 73 -> SMap._800c6970.get(this.arrIndex).get();
      case 112 -> Scus94491BpeSegment_800b.gameState_800babc8._15c.get(this.arrIndex).get();
      case 113 -> Scus94491BpeSegment_800b.gameState_800babc8._17c.get(this.arrIndex).get();
      case 114 -> Scus94491BpeSegment_800b.gameState_800babc8.dragoonSpirits_19c.get(this.arrIndex).get();
      case 126 -> Scus94491BpeSegment_800b.gameState_800babc8._1a4.get(this.arrIndex).get();
      case 127 -> Scus94491BpeSegment_800b.gameState_800babc8.chestFlags_1c4.get(this.arrIndex).get();
      case 128 -> this.readSpecialEffectVar(0, this.arrIndex);
      case 129 -> this.readSpecialEffectVar(1, this.arrIndex);
      case 130 -> this.readSpecialEffectVar(2, this.arrIndex);
      case 131 -> this.readSpecialEffectVar(3, this.arrIndex);
      case 132 -> this.readSpecialEffectVar(4, this.arrIndex);
      case 133 -> this.readSpecialEffectVar(5, this.arrIndex);
      case 134 -> this.readSpecialEffectVar(6, this.arrIndex);
      case 135 -> this.readSpecialEffectVar(7, this.arrIndex);
      case 136 -> this.readSpecialEffectVar(8, this.arrIndex);
      case 137 -> this.readSpecialEffectVar(9, this.arrIndex);

      default -> throw new IllegalArgumentException("Unknown game data index " + this.varIndex);
    };
  }

  @Override
  public Param set(final int val) {
    switch(this.varIndex) {
      case 17 -> Scus94491BpeSegment_800b.gameState_800babc8.charIndex_88.get(this.arrIndex).set(val);
      case 32 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_e0c[this.arrIndex] = val;
      case 34 -> Scus94491BpeSegment_8006._8006e398.charBobjIndices_e40[this.arrIndex] = val;
      case 36 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_e50[this.arrIndex] = val;
      case 41 -> Scus94491BpeSegment_800b.itemsDroppedByEnemies_800bc928.get(this.arrIndex).set(val);
      case 45 -> this.writeCombatVar(this.arrIndex, val);
      case 46 -> Bttl_800c.intRef_800c6718.get(this.arrIndex).set(val);
      case 48 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_e78[this.arrIndex] = val;
      case 50 -> Scus94491BpeSegment_8006._8006e398.bobjIndices_eac[this.arrIndex] = val;
      case 52 -> Scus94491BpeSegment_8006._8006e398.enemyBobjIndices_ebc[this.arrIndex] = val;
      case 64 -> SMap.sobjIndices_800c6880.get(this.arrIndex).set(val);
      case 73 -> SMap._800c6970.get(this.arrIndex).set(val);
      case 112 -> Scus94491BpeSegment_800b.gameState_800babc8._15c.get(this.arrIndex).set(val);
      case 113 -> Scus94491BpeSegment_800b.gameState_800babc8._17c.get(this.arrIndex).set(val);
      case 114 -> Scus94491BpeSegment_800b.gameState_800babc8.dragoonSpirits_19c.get(this.arrIndex).set(val);
      case 126 -> Scus94491BpeSegment_800b.gameState_800babc8._1a4.get(this.arrIndex).set(val);
      case 127 -> Scus94491BpeSegment_800b.gameState_800babc8.chestFlags_1c4.get(this.arrIndex).set(val);
      case 128 -> this.writeSpecialEffectVar(0, this.arrIndex, val);
      case 129 -> this.writeSpecialEffectVar(1, this.arrIndex, val);
      case 130 -> this.writeSpecialEffectVar(2, this.arrIndex, val);
      case 131 -> this.writeSpecialEffectVar(3, this.arrIndex, val);
      case 132 -> this.writeSpecialEffectVar(4, this.arrIndex, val);
      case 133 -> this.writeSpecialEffectVar(5, this.arrIndex, val);
      case 134 -> this.writeSpecialEffectVar(6, this.arrIndex, val);
      case 135 -> this.writeSpecialEffectVar(7, this.arrIndex, val);
      case 136 -> this.writeSpecialEffectVar(8, this.arrIndex, val);
      case 137 -> this.writeSpecialEffectVar(9, this.arrIndex, val);

      default -> throw new IllegalArgumentException("Unknown game data index " + this.varIndex);
    }

    return this;
  }

  @Override
  public Param array(final int index) {
    return new GameVarArrayParam(this.varIndex, this.arrIndex + index);
  }

  @Override
  public String toString() {
    return "GameVar[%d][%d] %d".formatted(this.varIndex, this.arrIndex, this.get());
  }

  private int readCombatVar(final int index) {
    return switch(index) {
      case 0 -> Scus94491BpeSegment_8006._8006e398._180;
      case 1 -> Scus94491BpeSegment_8006._8006e398._184;
      case 2 -> Scus94491BpeSegment_8006._8006e398._188;
      case 3 -> Scus94491BpeSegment_8006._8006e398._18c;
      case 4 -> Scus94491BpeSegment_8006._8006e398._190;
      case 5 -> Scus94491BpeSegment_8006._8006e398._194;
      case 6 -> Scus94491BpeSegment_8006._8006e398._198;
      case 7 -> Scus94491BpeSegment_8006._8006e398._19c;
      case 8 -> Scus94491BpeSegment_8006._8006e398._1a0;
      case 9 -> Scus94491BpeSegment_8006._8006e398._1a4;
      case 10 -> Scus94491BpeSegment_8006._8006e398._1a8;
      case 11 -> Scus94491BpeSegment_8006._8006e398._1ac;
      case 12 -> Scus94491BpeSegment_8006._8006e398._1b0;
      case 13 -> Scus94491BpeSegment_8006._8006e398._1b4;
      case 14 -> Scus94491BpeSegment_8006._8006e398._1b8;
      case 15 -> Scus94491BpeSegment_8006._8006e398._1bc;
      case 16 -> Scus94491BpeSegment_8006._8006e398._1c0;
      case 17 -> Scus94491BpeSegment_8006._8006e398._1c4;
      case 18 -> Scus94491BpeSegment_8006._8006e398._1c8;
      case 19 -> Scus94491BpeSegment_8006._8006e398._1cc;
      case 20 -> Scus94491BpeSegment_8006._8006e398._1d0;
      case 21 -> Scus94491BpeSegment_8006._8006e398._1d4;
      case 22 -> Scus94491BpeSegment_8006._8006e398._1d8;
      case 23 -> Scus94491BpeSegment_8006._8006e398._1dc;
      case 24 -> Scus94491BpeSegment_8006._8006e398._1e0;
      case 25 -> Scus94491BpeSegment_8006._8006e398._1e4;
      case 26 -> Scus94491BpeSegment_8006._8006e398._1e8;
      case 27 -> Scus94491BpeSegment_8006._8006e398._1ec;
      case 28 -> Scus94491BpeSegment_8006._8006e398._1f0;
      case 29 -> Scus94491BpeSegment_8006._8006e398._1f4;
      case 30 -> Scus94491BpeSegment_8006._8006e398._1f8;
      case 31 -> Scus94491BpeSegment_8006._8006e398._1fc;
      case 32 -> Scus94491BpeSegment_8006._8006e398._200;
      case 33 -> Scus94491BpeSegment_8006._8006e398._204;
      case 34 -> Scus94491BpeSegment_8006._8006e398._208;
      case 35 -> Scus94491BpeSegment_8006._8006e398._20c;
      case 36 -> Scus94491BpeSegment_8006._8006e398._210;
      case 37 -> Scus94491BpeSegment_8006._8006e398._214;
      case 38 -> Scus94491BpeSegment_8006._8006e398._218;
      case 39 -> Scus94491BpeSegment_8006._8006e398._21c;
      case 40 -> Scus94491BpeSegment_8006._8006e398._220;
      case 41 -> Scus94491BpeSegment_8006._8006e398._224;
      case 42 -> Scus94491BpeSegment_8006._8006e398._228;
      case 43 -> Scus94491BpeSegment_8006._8006e398._22c;
      case 44 -> Scus94491BpeSegment_8006._8006e398._230;
      case 45 -> Scus94491BpeSegment_8006._8006e398._234;
      case 46 -> Scus94491BpeSegment_8006._8006e398._238;
      case 47 -> Scus94491BpeSegment_8006._8006e398._23c;
      case 48 -> Scus94491BpeSegment_8006._8006e398._240;
      case 49 -> Scus94491BpeSegment_8006._8006e398._244;
      case 50 -> Scus94491BpeSegment_8006._8006e398._248;
      case 51 -> Scus94491BpeSegment_8006._8006e398._24c;
      case 52 -> Scus94491BpeSegment_8006._8006e398._250;
      case 53 -> Scus94491BpeSegment_8006._8006e398._254;
      case 54 -> Scus94491BpeSegment_8006._8006e398._258;
      case 55 -> Scus94491BpeSegment_8006._8006e398._25c;
      case 56 -> Scus94491BpeSegment_8006._8006e398._260;
      case 57 -> Scus94491BpeSegment_8006._8006e398._264;
      case 58 -> Scus94491BpeSegment_8006._8006e398._268;
      case 59 -> Scus94491BpeSegment_8006._8006e398._26c;
      case 60 -> Scus94491BpeSegment_8006._8006e398._270;
      case 61 -> Scus94491BpeSegment_8006._8006e398._274;
      case 62 -> Scus94491BpeSegment_8006._8006e398._278;
      case 63 -> Scus94491BpeSegment_8006._8006e398._27c;
      case 64 -> Scus94491BpeSegment_8006._8006e398.dAttackValue_280;
      case 65 -> Scus94491BpeSegment_8006._8006e398._284;
      case 66 -> Scus94491BpeSegment_8006._8006e398._288;
      case 67 -> Scus94491BpeSegment_8006._8006e398._28c;
      case 68 -> Scus94491BpeSegment_8006._8006e398._290;
      case 69 -> Scus94491BpeSegment_8006._8006e398._294;
      case 70 -> Scus94491BpeSegment_8006._8006e398._298;
      case 71 -> Scus94491BpeSegment_8006._8006e398._29c;
      case 72 -> Scus94491BpeSegment_8006._8006e398._2a0;
      case 73 -> Scus94491BpeSegment_8006._8006e398._2a4;
      case 74 -> Scus94491BpeSegment_8006._8006e398._2a8;
      case 75 -> Scus94491BpeSegment_8006._8006e398._2ac;
      case 76 -> Scus94491BpeSegment_8006._8006e398.specialFlag_2b0;
      case 77 -> Scus94491BpeSegment_8006._8006e398._2b4;
      case 78 -> Scus94491BpeSegment_8006._8006e398._2b8;
      case 79 -> Scus94491BpeSegment_8006._8006e398._2bc;
      case 80 -> Scus94491BpeSegment_8006._8006e398._2c0;
      case 81 -> Scus94491BpeSegment_8006._8006e398._2c4;
      case 82 -> Scus94491BpeSegment_8006._8006e398._2c8;
      case 83 -> Scus94491BpeSegment_8006._8006e398._2cc;
      case 84 -> Scus94491BpeSegment_8006._8006e398._2d0;
      case 85 -> Scus94491BpeSegment_8006._8006e398._2d4;
      case 86 -> Scus94491BpeSegment_8006._8006e398._2d8;
      case 87 -> Scus94491BpeSegment_8006._8006e398._2dc;
      case 88 -> Scus94491BpeSegment_8006._8006e398._2e0;
      case 89 -> Scus94491BpeSegment_8006._8006e398._2e4;
      case 90 -> Scus94491BpeSegment_8006._8006e398._2e8;
      case 91 -> Scus94491BpeSegment_8006._8006e398._2ec;
      case 92 -> Scus94491BpeSegment_8006._8006e398._2f0;
      case 93 -> Scus94491BpeSegment_8006._8006e398._2f4;
      case 94 -> Scus94491BpeSegment_8006._8006e398._2f8;
      case 95 -> Scus94491BpeSegment_8006._8006e398._2fc;
      case 96 -> Scus94491BpeSegment_8006._8006e398._300;
      case 97 -> Scus94491BpeSegment_8006._8006e398._304;
      case 98 -> Scus94491BpeSegment_8006._8006e398._308;
      case 99 -> Scus94491BpeSegment_8006._8006e398._30c;
      case 100 -> Scus94491BpeSegment_8006._8006e398._310;
      case 101 -> Scus94491BpeSegment_8006._8006e398._314;
      case 102 -> Scus94491BpeSegment_8006._8006e398._318;
      case 103 -> Scus94491BpeSegment_8006._8006e398._31c;
      case 104 -> Scus94491BpeSegment_8006._8006e398._320;
      case 105 -> Scus94491BpeSegment_8006._8006e398._324;
      case 106 -> Scus94491BpeSegment_8006._8006e398._328;
      case 107 -> Scus94491BpeSegment_8006._8006e398._32c;
      case 108 -> Scus94491BpeSegment_8006._8006e398._330;
      case 109 -> Scus94491BpeSegment_8006._8006e398._334;
      case 110 -> Scus94491BpeSegment_8006._8006e398._338;
      case 111 -> Scus94491BpeSegment_8006._8006e398._33c;
      case 112 -> Scus94491BpeSegment_8006._8006e398._340;
      case 113 -> Scus94491BpeSegment_8006._8006e398._344;
      case 114 -> Scus94491BpeSegment_8006._8006e398._348;
      case 115 -> Scus94491BpeSegment_8006._8006e398._34c;
      case 116 -> Scus94491BpeSegment_8006._8006e398._350;
      case 117 -> Scus94491BpeSegment_8006._8006e398._354;
      case 118 -> Scus94491BpeSegment_8006._8006e398._358;
      case 119 -> Scus94491BpeSegment_8006._8006e398._35c;
      case 120 -> Scus94491BpeSegment_8006._8006e398._360;
      case 121 -> Scus94491BpeSegment_8006._8006e398._364;
      case 122 -> Scus94491BpeSegment_8006._8006e398._368;
      case 123 -> Scus94491BpeSegment_8006._8006e398._36c;
      case 124 -> Scus94491BpeSegment_8006._8006e398._370;
      case 125 -> Scus94491BpeSegment_8006._8006e398._374;
      case 126 -> Scus94491BpeSegment_8006._8006e398._378;
      case 127 -> Scus94491BpeSegment_8006._8006e398._37c;
      case 128 -> Scus94491BpeSegment_8006._8006e398._380;
      case 129 -> Scus94491BpeSegment_8006._8006e398.status_384[0].pack();
      case 130 -> Scus94491BpeSegment_8006._8006e398.status_384[1].pack();
      case 131 -> Scus94491BpeSegment_8006._8006e398.status_384[2].pack();
      case 132 -> Scus94491BpeSegment_8006._8006e398.status_384[3].pack();
      case 133 -> Scus94491BpeSegment_8006._8006e398.status_384[4].pack();
      case 134 -> Scus94491BpeSegment_8006._8006e398.status_384[5].pack();
      case 135 -> Scus94491BpeSegment_8006._8006e398.status_384[6].pack();
      case 136 -> Scus94491BpeSegment_8006._8006e398.status_384[7].pack();
      case 137 -> Scus94491BpeSegment_8006._8006e398._3a4;
      case 138 -> Scus94491BpeSegment_8006._8006e398._3a8;
      case 139 -> Scus94491BpeSegment_8006._8006e398._3ac;
      case 140 -> Scus94491BpeSegment_8006._8006e398._3b0;
      case 141 -> Scus94491BpeSegment_8006._8006e398._3b4;
      case 142 -> Scus94491BpeSegment_8006._8006e398._3b8;
      case 143 -> Scus94491BpeSegment_8006._8006e398._3bc;
      case 144 -> Scus94491BpeSegment_8006._8006e398._3c0;
      case 145 -> Scus94491BpeSegment_8006._8006e398._3c4;
      case 146 -> Scus94491BpeSegment_8006._8006e398._3c8;
      case 147 -> Scus94491BpeSegment_8006._8006e398._3cc;
      case 148 -> Scus94491BpeSegment_8006._8006e398._3d0;
      case 149 -> Scus94491BpeSegment_8006._8006e398._3d4;
      case 150 -> Scus94491BpeSegment_8006._8006e398._3d8;
      case 151 -> Scus94491BpeSegment_8006._8006e398._3dc;
      case 152 -> Scus94491BpeSegment_8006._8006e398._3e0;
      case 153 -> Scus94491BpeSegment_8006._8006e398._3e4;
      case 154 -> Scus94491BpeSegment_8006._8006e398._3e8;
      case 155 -> Scus94491BpeSegment_8006._8006e398._3ec;
      case 156 -> Scus94491BpeSegment_8006._8006e398._3f0;
      case 157 -> Scus94491BpeSegment_8006._8006e398._3f4;
      case 158 -> Scus94491BpeSegment_8006._8006e398._3f8;
      case 159 -> Scus94491BpeSegment_8006._8006e398._3fc;
      case 160 -> Scus94491BpeSegment_8006._8006e398._400;
      case 161 -> Scus94491BpeSegment_8006._8006e398._404;
      case 162 -> Scus94491BpeSegment_8006._8006e398._408;
      case 163 -> Scus94491BpeSegment_8006._8006e398._40c;
      case 164 -> Scus94491BpeSegment_8006._8006e398._410;
      case 165 -> Scus94491BpeSegment_8006._8006e398._414;
      case 166 -> Scus94491BpeSegment_8006._8006e398._418;
      case 167 -> Scus94491BpeSegment_8006._8006e398._41c;
      case 168 -> Scus94491BpeSegment_8006._8006e398._420;
      case 169 -> Scus94491BpeSegment_8006._8006e398._424;
      case 170 -> Scus94491BpeSegment_8006._8006e398._428;
      case 171 -> Scus94491BpeSegment_8006._8006e398._42c;
      case 172 -> Scus94491BpeSegment_8006._8006e398._430;
      case 173 -> Scus94491BpeSegment_8006._8006e398._434;
      case 174 -> Scus94491BpeSegment_8006._8006e398._438;
      case 175 -> Scus94491BpeSegment_8006._8006e398._43c;
      case 176 -> Scus94491BpeSegment_8006._8006e398._440;
      case 177 -> Scus94491BpeSegment_8006._8006e398._444;
      case 178 -> Scus94491BpeSegment_8006._8006e398._448;
      case 179 -> Scus94491BpeSegment_8006._8006e398._44c;
      case 180 -> Scus94491BpeSegment_8006._8006e398._450;
      case 181 -> Scus94491BpeSegment_8006._8006e398._454;
      case 182 -> Scus94491BpeSegment_8006._8006e398._458;
      case 183 -> Scus94491BpeSegment_8006._8006e398._45c;
      case 184 -> Scus94491BpeSegment_8006._8006e398._460;
      case 185 -> Scus94491BpeSegment_8006._8006e398._464;
      case 186 -> Scus94491BpeSegment_8006._8006e398._468;
      case 187 -> Scus94491BpeSegment_8006._8006e398._46c;
      case 188 -> Scus94491BpeSegment_8006._8006e398._470;
      case 189 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[0].pack();
      case 190 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[1].pack();
      case 191 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[2].pack();
      case 192 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[3].pack();
      case 193 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[4].pack();
      case 194 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[5].pack();
      case 195 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[6].pack();
      case 196 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[7].pack();
      case 197 -> Scus94491BpeSegment_8006._8006e398._494;
      case 198 -> Scus94491BpeSegment_8006._8006e398._498;
      case 199 -> Scus94491BpeSegment_8006._8006e398._49c;
      case 200 -> Scus94491BpeSegment_8006._8006e398._4a0;
      case 201 -> Scus94491BpeSegment_8006._8006e398._4a4;
      case 202 -> Scus94491BpeSegment_8006._8006e398._4a8;
      case 203 -> Scus94491BpeSegment_8006._8006e398._4ac;
      case 204 -> Scus94491BpeSegment_8006._8006e398._4b0;
      case 205 -> Scus94491BpeSegment_8006._8006e398._4b4;
      case 206 -> Scus94491BpeSegment_8006._8006e398._4b8;
      case 207 -> Scus94491BpeSegment_8006._8006e398._4bc;
      case 208 -> Scus94491BpeSegment_8006._8006e398._4c0;
      case 209 -> Scus94491BpeSegment_8006._8006e398._4c4;
      case 210 -> Scus94491BpeSegment_8006._8006e398._4c8;
      case 211 -> Scus94491BpeSegment_8006._8006e398._4cc;
      case 212 -> Scus94491BpeSegment_8006._8006e398._4d0;
      case 213 -> Scus94491BpeSegment_8006._8006e398._4d4;
      case 214 -> Scus94491BpeSegment_8006._8006e398._4d8;
      case 215 -> Scus94491BpeSegment_8006._8006e398._4dc;
      case 216 -> Scus94491BpeSegment_8006._8006e398._4e0;
      case 217 -> Scus94491BpeSegment_8006._8006e398._4e4;
      case 218 -> Scus94491BpeSegment_8006._8006e398._4e8;
      case 219 -> Scus94491BpeSegment_8006._8006e398._4ec;
      case 220 -> Scus94491BpeSegment_8006._8006e398._4f0;
      case 221 -> Scus94491BpeSegment_8006._8006e398._4f4;
      case 222 -> Scus94491BpeSegment_8006._8006e398._4f8;
      case 223 -> Scus94491BpeSegment_8006._8006e398._4fc;
      case 224 -> Scus94491BpeSegment_8006._8006e398._500;
      case 225 -> Scus94491BpeSegment_8006._8006e398._504;
      case 226 -> Scus94491BpeSegment_8006._8006e398._508;
      case 227 -> Scus94491BpeSegment_8006._8006e398._50c;
      case 228 -> Scus94491BpeSegment_8006._8006e398._510;
      case 229 -> Scus94491BpeSegment_8006._8006e398._514;
      case 230 -> Scus94491BpeSegment_8006._8006e398._518;
      case 231 -> Scus94491BpeSegment_8006._8006e398._51c;
      case 232 -> Scus94491BpeSegment_8006._8006e398._520;
      case 233 -> Scus94491BpeSegment_8006._8006e398._524;
      case 234 -> Scus94491BpeSegment_8006._8006e398._528;
      case 235 -> Scus94491BpeSegment_8006._8006e398._52c;
      case 236 -> Scus94491BpeSegment_8006._8006e398._530;
      case 237 -> Scus94491BpeSegment_8006._8006e398._534;
      case 238 -> Scus94491BpeSegment_8006._8006e398._538;
      case 239 -> Scus94491BpeSegment_8006._8006e398._53c;
      case 240 -> Scus94491BpeSegment_8006._8006e398._540;
      case 241 -> Scus94491BpeSegment_8006._8006e398._544;
      case 242 -> Scus94491BpeSegment_8006._8006e398._548;
      case 243 -> Scus94491BpeSegment_8006._8006e398._54c;
      case 244 -> Scus94491BpeSegment_8006._8006e398.dragonBlockStaff_550;
      case 245 -> Scus94491BpeSegment_8006._8006e398._554;
      case 246 -> Scus94491BpeSegment_8006._8006e398._558;
      case 247 -> Scus94491BpeSegment_8006._8006e398._55c;
      case 248 -> Scus94491BpeSegment_8006._8006e398._560;
      case 249 -> Scus94491BpeSegment_8006._8006e398._564;
      case 250 -> Scus94491BpeSegment_8006._8006e398._568;
      case 251 -> Scus94491BpeSegment_8006._8006e398._56c;
      case 252 -> Scus94491BpeSegment_8006._8006e398._570;
      case 253 -> Scus94491BpeSegment_8006._8006e398._574;
      case 254 -> Scus94491BpeSegment_8006._8006e398._578;
      case 255 -> Scus94491BpeSegment_8006._8006e398._57c;

      default -> throw new IllegalArgumentException("Unknown combat var index " + index);
    };
  }

  private void writeCombatVar(final int index, final int val) {
    switch(index) {
      case 0 -> Scus94491BpeSegment_8006._8006e398._180 = val;
      case 1 -> Scus94491BpeSegment_8006._8006e398._184 = val;
      case 2 -> Scus94491BpeSegment_8006._8006e398._188 = val;
      case 3 -> Scus94491BpeSegment_8006._8006e398._18c = val;
      case 4 -> Scus94491BpeSegment_8006._8006e398._190 = val;
      case 5 -> Scus94491BpeSegment_8006._8006e398._194 = val;
      case 6 -> Scus94491BpeSegment_8006._8006e398._198 = val;
      case 7 -> Scus94491BpeSegment_8006._8006e398._19c = val;
      case 8 -> Scus94491BpeSegment_8006._8006e398._1a0 = val;
      case 9 -> Scus94491BpeSegment_8006._8006e398._1a4 = val;
      case 10 -> Scus94491BpeSegment_8006._8006e398._1a8 = val;
      case 11 -> Scus94491BpeSegment_8006._8006e398._1ac = val;
      case 12 -> Scus94491BpeSegment_8006._8006e398._1b0 = val;
      case 13 -> Scus94491BpeSegment_8006._8006e398._1b4 = val;
      case 14 -> Scus94491BpeSegment_8006._8006e398._1b8 = val;
      case 15 -> Scus94491BpeSegment_8006._8006e398._1bc = val;
      case 16 -> Scus94491BpeSegment_8006._8006e398._1c0 = val;
      case 17 -> Scus94491BpeSegment_8006._8006e398._1c4 = val;
      case 18 -> Scus94491BpeSegment_8006._8006e398._1c8 = val;
      case 19 -> Scus94491BpeSegment_8006._8006e398._1cc = val;
      case 20 -> Scus94491BpeSegment_8006._8006e398._1d0 = val;
      case 21 -> Scus94491BpeSegment_8006._8006e398._1d4 = val;
      case 22 -> Scus94491BpeSegment_8006._8006e398._1d8 = val;
      case 23 -> Scus94491BpeSegment_8006._8006e398._1dc = val;
      case 24 -> Scus94491BpeSegment_8006._8006e398._1e0 = val;
      case 25 -> Scus94491BpeSegment_8006._8006e398._1e4 = val;
      case 26 -> Scus94491BpeSegment_8006._8006e398._1e8 = val;
      case 27 -> Scus94491BpeSegment_8006._8006e398._1ec = val;
      case 28 -> Scus94491BpeSegment_8006._8006e398._1f0 = val;
      case 29 -> Scus94491BpeSegment_8006._8006e398._1f4 = val;
      case 30 -> Scus94491BpeSegment_8006._8006e398._1f8 = val;
      case 31 -> Scus94491BpeSegment_8006._8006e398._1fc = val;
      case 32 -> Scus94491BpeSegment_8006._8006e398._200 = val;
      case 33 -> Scus94491BpeSegment_8006._8006e398._204 = val;
      case 34 -> Scus94491BpeSegment_8006._8006e398._208 = val;
      case 35 -> Scus94491BpeSegment_8006._8006e398._20c = val;
      case 36 -> Scus94491BpeSegment_8006._8006e398._210 = val;
      case 37 -> Scus94491BpeSegment_8006._8006e398._214 = val;
      case 38 -> Scus94491BpeSegment_8006._8006e398._218 = val;
      case 39 -> Scus94491BpeSegment_8006._8006e398._21c = val;
      case 40 -> Scus94491BpeSegment_8006._8006e398._220 = val;
      case 41 -> Scus94491BpeSegment_8006._8006e398._224 = val;
      case 42 -> Scus94491BpeSegment_8006._8006e398._228 = val;
      case 43 -> Scus94491BpeSegment_8006._8006e398._22c = val;
      case 44 -> Scus94491BpeSegment_8006._8006e398._230 = val;
      case 45 -> Scus94491BpeSegment_8006._8006e398._234 = val;
      case 46 -> Scus94491BpeSegment_8006._8006e398._238 = val;
      case 47 -> Scus94491BpeSegment_8006._8006e398._23c = val;
      case 48 -> Scus94491BpeSegment_8006._8006e398._240 = val;
      case 49 -> Scus94491BpeSegment_8006._8006e398._244 = val;
      case 50 -> Scus94491BpeSegment_8006._8006e398._248 = val;
      case 51 -> Scus94491BpeSegment_8006._8006e398._24c = val;
      case 52 -> Scus94491BpeSegment_8006._8006e398._250 = val;
      case 53 -> Scus94491BpeSegment_8006._8006e398._254 = val;
      case 54 -> Scus94491BpeSegment_8006._8006e398._258 = val;
      case 55 -> Scus94491BpeSegment_8006._8006e398._25c = val;
      case 56 -> Scus94491BpeSegment_8006._8006e398._260 = val;
      case 57 -> Scus94491BpeSegment_8006._8006e398._264 = val;
      case 58 -> Scus94491BpeSegment_8006._8006e398._268 = val;
      case 59 -> Scus94491BpeSegment_8006._8006e398._26c = val;
      case 60 -> Scus94491BpeSegment_8006._8006e398._270 = val;
      case 61 -> Scus94491BpeSegment_8006._8006e398._274 = val;
      case 62 -> Scus94491BpeSegment_8006._8006e398._278 = val;
      case 63 -> Scus94491BpeSegment_8006._8006e398._27c = val;
      case 64 -> Scus94491BpeSegment_8006._8006e398.dAttackValue_280 = val;
      case 65 -> Scus94491BpeSegment_8006._8006e398._284 = val;
      case 66 -> Scus94491BpeSegment_8006._8006e398._288 = val;
      case 67 -> Scus94491BpeSegment_8006._8006e398._28c = val;
      case 68 -> Scus94491BpeSegment_8006._8006e398._290 = val;
      case 69 -> Scus94491BpeSegment_8006._8006e398._294 = val;
      case 70 -> Scus94491BpeSegment_8006._8006e398._298 = val;
      case 71 -> Scus94491BpeSegment_8006._8006e398._29c = val;
      case 72 -> Scus94491BpeSegment_8006._8006e398._2a0 = val;
      case 73 -> Scus94491BpeSegment_8006._8006e398._2a4 = val;
      case 74 -> Scus94491BpeSegment_8006._8006e398._2a8 = val;
      case 75 -> Scus94491BpeSegment_8006._8006e398._2ac = val;
      case 76 -> Scus94491BpeSegment_8006._8006e398.specialFlag_2b0 = val;
      case 77 -> Scus94491BpeSegment_8006._8006e398._2b4 = val;
      case 78 -> Scus94491BpeSegment_8006._8006e398._2b8 = val;
      case 79 -> Scus94491BpeSegment_8006._8006e398._2bc = val;
      case 80 -> Scus94491BpeSegment_8006._8006e398._2c0 = val;
      case 81 -> Scus94491BpeSegment_8006._8006e398._2c4 = val;
      case 82 -> Scus94491BpeSegment_8006._8006e398._2c8 = val;
      case 83 -> Scus94491BpeSegment_8006._8006e398._2cc = val;
      case 84 -> Scus94491BpeSegment_8006._8006e398._2d0 = val;
      case 85 -> Scus94491BpeSegment_8006._8006e398._2d4 = val;
      case 86 -> Scus94491BpeSegment_8006._8006e398._2d8 = val;
      case 87 -> Scus94491BpeSegment_8006._8006e398._2dc = val;
      case 88 -> Scus94491BpeSegment_8006._8006e398._2e0 = val;
      case 89 -> Scus94491BpeSegment_8006._8006e398._2e4 = val;
      case 90 -> Scus94491BpeSegment_8006._8006e398._2e8 = val;
      case 91 -> Scus94491BpeSegment_8006._8006e398._2ec = val;
      case 92 -> Scus94491BpeSegment_8006._8006e398._2f0 = val;
      case 93 -> Scus94491BpeSegment_8006._8006e398._2f4 = val;
      case 94 -> Scus94491BpeSegment_8006._8006e398._2f8 = val;
      case 95 -> Scus94491BpeSegment_8006._8006e398._2fc = val;
      case 96 -> Scus94491BpeSegment_8006._8006e398._300 = val;
      case 97 -> Scus94491BpeSegment_8006._8006e398._304 = val;
      case 98 -> Scus94491BpeSegment_8006._8006e398._308 = val;
      case 99 -> Scus94491BpeSegment_8006._8006e398._30c = val;
      case 100 -> Scus94491BpeSegment_8006._8006e398._310 = val;
      case 101 -> Scus94491BpeSegment_8006._8006e398._314 = val;
      case 102 -> Scus94491BpeSegment_8006._8006e398._318 = val;
      case 103 -> Scus94491BpeSegment_8006._8006e398._31c = val;
      case 104 -> Scus94491BpeSegment_8006._8006e398._320 = val;
      case 105 -> Scus94491BpeSegment_8006._8006e398._324 = val;
      case 106 -> Scus94491BpeSegment_8006._8006e398._328 = val;
      case 107 -> Scus94491BpeSegment_8006._8006e398._32c = val;
      case 108 -> Scus94491BpeSegment_8006._8006e398._330 = val;
      case 109 -> Scus94491BpeSegment_8006._8006e398._334 = val;
      case 110 -> Scus94491BpeSegment_8006._8006e398._338 = val;
      case 111 -> Scus94491BpeSegment_8006._8006e398._33c = val;
      case 112 -> Scus94491BpeSegment_8006._8006e398._340 = val;
      case 113 -> Scus94491BpeSegment_8006._8006e398._344 = val;
      case 114 -> Scus94491BpeSegment_8006._8006e398._348 = val;
      case 115 -> Scus94491BpeSegment_8006._8006e398._34c = val;
      case 116 -> Scus94491BpeSegment_8006._8006e398._350 = val;
      case 117 -> Scus94491BpeSegment_8006._8006e398._354 = val;
      case 118 -> Scus94491BpeSegment_8006._8006e398._358 = val;
      case 119 -> Scus94491BpeSegment_8006._8006e398._35c = val;
      case 120 -> Scus94491BpeSegment_8006._8006e398._360 = val;
      case 121 -> Scus94491BpeSegment_8006._8006e398._364 = val;
      case 122 -> Scus94491BpeSegment_8006._8006e398._368 = val;
      case 123 -> Scus94491BpeSegment_8006._8006e398._36c = val;
      case 124 -> Scus94491BpeSegment_8006._8006e398._370 = val;
      case 125 -> Scus94491BpeSegment_8006._8006e398._374 = val;
      case 126 -> Scus94491BpeSegment_8006._8006e398._378 = val;
      case 127 -> Scus94491BpeSegment_8006._8006e398._37c = val;
      case 128 -> Scus94491BpeSegment_8006._8006e398._380 = val;
      case 129 -> Scus94491BpeSegment_8006._8006e398.status_384[0].unpack(val);
      case 130 -> Scus94491BpeSegment_8006._8006e398.status_384[1].unpack(val);
      case 131 -> Scus94491BpeSegment_8006._8006e398.status_384[2].unpack(val);
      case 132 -> Scus94491BpeSegment_8006._8006e398.status_384[3].unpack(val);
      case 133 -> Scus94491BpeSegment_8006._8006e398.status_384[4].unpack(val);
      case 134 -> Scus94491BpeSegment_8006._8006e398.status_384[5].unpack(val);
      case 135 -> Scus94491BpeSegment_8006._8006e398.status_384[6].unpack(val);
      case 136 -> Scus94491BpeSegment_8006._8006e398.status_384[7].unpack(val);
      case 137 -> Scus94491BpeSegment_8006._8006e398._3a4 = val;
      case 138 -> Scus94491BpeSegment_8006._8006e398._3a8 = val;
      case 139 -> Scus94491BpeSegment_8006._8006e398._3ac = val;
      case 140 -> Scus94491BpeSegment_8006._8006e398._3b0 = val;
      case 141 -> Scus94491BpeSegment_8006._8006e398._3b4 = val;
      case 142 -> Scus94491BpeSegment_8006._8006e398._3b8 = val;
      case 143 -> Scus94491BpeSegment_8006._8006e398._3bc = val;
      case 144 -> Scus94491BpeSegment_8006._8006e398._3c0 = val;
      case 145 -> Scus94491BpeSegment_8006._8006e398._3c4 = val;
      case 146 -> Scus94491BpeSegment_8006._8006e398._3c8 = val;
      case 147 -> Scus94491BpeSegment_8006._8006e398._3cc = val;
      case 148 -> Scus94491BpeSegment_8006._8006e398._3d0 = val;
      case 149 -> Scus94491BpeSegment_8006._8006e398._3d4 = val;
      case 150 -> Scus94491BpeSegment_8006._8006e398._3d8 = val;
      case 151 -> Scus94491BpeSegment_8006._8006e398._3dc = val;
      case 152 -> Scus94491BpeSegment_8006._8006e398._3e0 = val;
      case 153 -> Scus94491BpeSegment_8006._8006e398._3e4 = val;
      case 154 -> Scus94491BpeSegment_8006._8006e398._3e8 = val;
      case 155 -> Scus94491BpeSegment_8006._8006e398._3ec = val;
      case 156 -> Scus94491BpeSegment_8006._8006e398._3f0 = val;
      case 157 -> Scus94491BpeSegment_8006._8006e398._3f4 = val;
      case 158 -> Scus94491BpeSegment_8006._8006e398._3f8 = val;
      case 159 -> Scus94491BpeSegment_8006._8006e398._3fc = val;
      case 160 -> Scus94491BpeSegment_8006._8006e398._400 = val;
      case 161 -> Scus94491BpeSegment_8006._8006e398._404 = val;
      case 162 -> Scus94491BpeSegment_8006._8006e398._408 = val;
      case 163 -> Scus94491BpeSegment_8006._8006e398._40c = val;
      case 164 -> Scus94491BpeSegment_8006._8006e398._410 = val;
      case 165 -> Scus94491BpeSegment_8006._8006e398._414 = val;
      case 166 -> Scus94491BpeSegment_8006._8006e398._418 = val;
      case 167 -> Scus94491BpeSegment_8006._8006e398._41c = val;
      case 168 -> Scus94491BpeSegment_8006._8006e398._420 = val;
      case 169 -> Scus94491BpeSegment_8006._8006e398._424 = val;
      case 170 -> Scus94491BpeSegment_8006._8006e398._428 = val;
      case 171 -> Scus94491BpeSegment_8006._8006e398._42c = val;
      case 172 -> Scus94491BpeSegment_8006._8006e398._430 = val;
      case 173 -> Scus94491BpeSegment_8006._8006e398._434 = val;
      case 174 -> Scus94491BpeSegment_8006._8006e398._438 = val;
      case 175 -> Scus94491BpeSegment_8006._8006e398._43c = val;
      case 176 -> Scus94491BpeSegment_8006._8006e398._440 = val;
      case 177 -> Scus94491BpeSegment_8006._8006e398._444 = val;
      case 178 -> Scus94491BpeSegment_8006._8006e398._448 = val;
      case 179 -> Scus94491BpeSegment_8006._8006e398._44c = val;
      case 180 -> Scus94491BpeSegment_8006._8006e398._450 = val;
      case 181 -> Scus94491BpeSegment_8006._8006e398._454 = val;
      case 182 -> Scus94491BpeSegment_8006._8006e398._458 = val;
      case 183 -> Scus94491BpeSegment_8006._8006e398._45c = val;
      case 184 -> Scus94491BpeSegment_8006._8006e398._460 = val;
      case 185 -> Scus94491BpeSegment_8006._8006e398._464 = val;
      case 186 -> Scus94491BpeSegment_8006._8006e398._468 = val;
      case 187 -> Scus94491BpeSegment_8006._8006e398._46c = val;
      case 188 -> Scus94491BpeSegment_8006._8006e398._470 = val;
      case 189 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[0].unpack(val);
      case 190 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[1].unpack(val);
      case 191 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[2].unpack(val);
      case 192 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[3].unpack(val);
      case 193 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[4].unpack(val);
      case 194 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[5].unpack(val);
      case 195 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[6].unpack(val);
      case 196 -> Scus94491BpeSegment_8006._8006e398.additionExtra_474[7].unpack(val);
      case 197 -> Scus94491BpeSegment_8006._8006e398._494 = val;
      case 198 -> Scus94491BpeSegment_8006._8006e398._498 = val;
      case 199 -> Scus94491BpeSegment_8006._8006e398._49c = val;
      case 200 -> Scus94491BpeSegment_8006._8006e398._4a0 = val;
      case 201 -> Scus94491BpeSegment_8006._8006e398._4a4 = val;
      case 202 -> Scus94491BpeSegment_8006._8006e398._4a8 = val;
      case 203 -> Scus94491BpeSegment_8006._8006e398._4ac = val;
      case 204 -> Scus94491BpeSegment_8006._8006e398._4b0 = val;
      case 205 -> Scus94491BpeSegment_8006._8006e398._4b4 = val;
      case 206 -> Scus94491BpeSegment_8006._8006e398._4b8 = val;
      case 207 -> Scus94491BpeSegment_8006._8006e398._4bc = val;
      case 208 -> Scus94491BpeSegment_8006._8006e398._4c0 = val;
      case 209 -> Scus94491BpeSegment_8006._8006e398._4c4 = val;
      case 210 -> Scus94491BpeSegment_8006._8006e398._4c8 = val;
      case 211 -> Scus94491BpeSegment_8006._8006e398._4cc = val;
      case 212 -> Scus94491BpeSegment_8006._8006e398._4d0 = val;
      case 213 -> Scus94491BpeSegment_8006._8006e398._4d4 = val;
      case 214 -> Scus94491BpeSegment_8006._8006e398._4d8 = val;
      case 215 -> Scus94491BpeSegment_8006._8006e398._4dc = val;
      case 216 -> Scus94491BpeSegment_8006._8006e398._4e0 = val;
      case 217 -> Scus94491BpeSegment_8006._8006e398._4e4 = val;
      case 218 -> Scus94491BpeSegment_8006._8006e398._4e8 = val;
      case 219 -> Scus94491BpeSegment_8006._8006e398._4ec = val;
      case 220 -> Scus94491BpeSegment_8006._8006e398._4f0 = val;
      case 221 -> Scus94491BpeSegment_8006._8006e398._4f4 = val;
      case 222 -> Scus94491BpeSegment_8006._8006e398._4f8 = val;
      case 223 -> Scus94491BpeSegment_8006._8006e398._4fc = val;
      case 224 -> Scus94491BpeSegment_8006._8006e398._500 = val;
      case 225 -> Scus94491BpeSegment_8006._8006e398._504 = val;
      case 226 -> Scus94491BpeSegment_8006._8006e398._508 = val;
      case 227 -> Scus94491BpeSegment_8006._8006e398._50c = val;
      case 228 -> Scus94491BpeSegment_8006._8006e398._510 = val;
      case 229 -> Scus94491BpeSegment_8006._8006e398._514 = val;
      case 230 -> Scus94491BpeSegment_8006._8006e398._518 = val;
      case 231 -> Scus94491BpeSegment_8006._8006e398._51c = val;
      case 232 -> Scus94491BpeSegment_8006._8006e398._520 = val;
      case 233 -> Scus94491BpeSegment_8006._8006e398._524 = val;
      case 234 -> Scus94491BpeSegment_8006._8006e398._528 = val;
      case 235 -> Scus94491BpeSegment_8006._8006e398._52c = val;
      case 236 -> Scus94491BpeSegment_8006._8006e398._530 = val;
      case 237 -> Scus94491BpeSegment_8006._8006e398._534 = val;
      case 238 -> Scus94491BpeSegment_8006._8006e398._538 = val;
      case 239 -> Scus94491BpeSegment_8006._8006e398._53c = val;
      case 240 -> Scus94491BpeSegment_8006._8006e398._540 = val;
      case 241 -> Scus94491BpeSegment_8006._8006e398._544 = val;
      case 242 -> Scus94491BpeSegment_8006._8006e398._548 = val;
      case 243 -> Scus94491BpeSegment_8006._8006e398._54c = val;
      case 244 -> Scus94491BpeSegment_8006._8006e398.dragonBlockStaff_550 = val;
      case 245 -> Scus94491BpeSegment_8006._8006e398._554 = val;
      case 246 -> Scus94491BpeSegment_8006._8006e398._558 = val;
      case 247 -> Scus94491BpeSegment_8006._8006e398._55c = val;
      case 248 -> Scus94491BpeSegment_8006._8006e398._560 = val;
      case 249 -> Scus94491BpeSegment_8006._8006e398._564 = val;
      case 250 -> Scus94491BpeSegment_8006._8006e398._568 = val;
      case 251 -> Scus94491BpeSegment_8006._8006e398._56c = val;
      case 252 -> Scus94491BpeSegment_8006._8006e398._570 = val;
      case 253 -> Scus94491BpeSegment_8006._8006e398._574 = val;
      case 254 -> Scus94491BpeSegment_8006._8006e398._578 = val;
      case 255 -> Scus94491BpeSegment_8006._8006e398._57c = val;

      default -> throw new IllegalArgumentException("Unknown combat var index " + index);
    }
  }

  private int readSpecialEffectVar(final int effectIndex, final int varIndex) {
    final SpecialEffects20 effect = Scus94491BpeSegment_8006._8006e398.specialEffect_00[effectIndex];

    return switch(varIndex) {
      case 0 -> effect._00;
      case 1 -> effect._04;
      case 2 -> effect._08;
      case 3 -> effect._0c;
      case 4 -> effect._10;
      case 5 -> effect._14;
      case 6 -> effect.menuBlockFlag_18;
      case 7 -> (effect.unknown_1f & 0xff) << 24 | (effect.chargingSpirit_1e & 0xff) << 16 | (effect.pandemoniumTurns_1d & 0xff) << 8 | effect.shieldsSigStoneCharmTurns_1c & 0xff;

      default -> throw new IllegalArgumentException("Unknown special effect var index " + varIndex);
    };
  }

  private void writeSpecialEffectVar(final int effectIndex, final int varIndex, final int val) {
    final SpecialEffects20 effect = Scus94491BpeSegment_8006._8006e398.specialEffect_00[effectIndex];

    switch(varIndex) {
      case 0 -> effect._00 = val;
      case 1 -> effect._04 = val;
      case 2 -> effect._08 = val;
      case 3 -> effect._0c = val;
      case 4 -> effect._10 = val;
      case 5 -> effect._14 = val;
      case 6 -> effect.menuBlockFlag_18 = val;
      case 7 -> {
        effect.shieldsSigStoneCharmTurns_1c = val & 0xff;
        effect.pandemoniumTurns_1d = val >>> 8 & 0xff;
        effect.chargingSpirit_1e = val >>> 16 & 0xff;
        effect.unknown_1f = val >>> 24 & 0xff;
      }

      default -> throw new IllegalArgumentException("Unknown special effect var index " + varIndex);
    }
  }
}
