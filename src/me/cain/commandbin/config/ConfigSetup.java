/*     */ package me.cain.commandbin.config;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*     */ 
/*     */ public class ConfigSetup
/*     */ {
/*     */   public static void start()
/*     */   {
/*  13 */     CommandBin.plugin.getConfig().options().header(
/*  14 */       "###############################\nDefault Configuration File for CommandBin \nCommandBin was created by CainFoool\nAll the values generated below are default and are fully editable.\nFeel free to edit them as you plead.\nEvery time this plugin starts up, this text\nWill be generated every time (sorry :p)\n\nCainFoool\n###############################\n");
/*     */ 
/*  25 */     if (CommandBin.plugin.getConfig().getString("settings.shutdownmessage", null) == null)
/*     */     {
/*  27 */       CommandBin.plugin.getConfig().set("settings.shutdownmessage", "The server is going down for shutdown!");
/*  28 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default shutdown message");
/*  29 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  32 */     if (CommandBin.plugin.getConfig().get("settings.broadcastkick") == null)
/*     */     {
/*  34 */       CommandBin.plugin.getConfig().set("settings.broadcastkick", Boolean.valueOf(true));
/*  35 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default broadcast on kick");
/*  36 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  39 */     if (CommandBin.plugin.getConfig().get("settings.broadcastban") == null)
/*     */     {
/*  41 */       CommandBin.plugin.getConfig().set("settings.broadcastban", Boolean.valueOf(true));
/*  42 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default broadcast on ban");
/*  43 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  46 */     if (CommandBin.plugin.getConfig().getString("settings.playerismuted", null) == null)
/*     */     {
/*  48 */       CommandBin.plugin.getConfig().set("settings.playerismuted", "You are muted, shh!");
/*  49 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Player is Muted message");
/*  50 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  53 */     if (CommandBin.plugin.getConfig().getString("settings.playercannotusecommands", null) == null)
/*     */     {
/*  55 */       CommandBin.plugin.getConfig().set("settings.playercannotusecommands", "You cannot use commands. Stop trying!");
/*  56 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default player cannot use commands message");
/*  57 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  60 */     if (CommandBin.plugin.getConfig().getString("settings.joinmessage", null) == null)
/*     */     {
/*  62 */       CommandBin.plugin.getConfig().set("settings.joinmessage", "has joined the game");
/*  63 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Join Message");
/*  64 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  67 */     if (CommandBin.plugin.getConfig().getString("settings.leavemessage", null) == null)
/*     */     {
/*  69 */       CommandBin.plugin.getConfig().set("settings.leavemessage", "has left the game");
/*  70 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Leave Message");
/*  71 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  74 */     if (CommandBin.plugin.getConfig().get("settings.dropxpondeath") == null)
/*     */     {
/*  76 */       CommandBin.plugin.getConfig().set("settings.dropxpondeath", Boolean.valueOf(false));
/*  77 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Drop XP on Death");
/*  78 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  81 */     if (CommandBin.plugin.getConfig().getString("settings.craftbukkitversion", null) == null)
/*     */     {
/*  83 */       CommandBin.plugin.getConfig().set("settings.craftbukkitversion", Bukkit.getServer().getVersion().toString());
/*  84 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Craftbukkit Version");
/*  85 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  88 */     if (CommandBin.plugin.getConfig().get("settings.spawn-mob-max-amount") == null)
/*     */     {
/*  90 */       CommandBin.plugin.getConfig().set("settings.spawn-mob-max-amount", Integer.valueOf(100));
/*  91 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default /spawnmob max amount");
/*  92 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/*  95 */     if (CommandBin.plugin.getConfig().get("settings.endermangriefing") == null)
/*     */     {
/*  97 */       CommandBin.plugin.getConfig().set("settings.endermangriefing", Boolean.valueOf(false));
/*  98 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Enderman can grief to false");
/*  99 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 102 */     if (CommandBin.plugin.getConfig().get("settings.block-placing-tnt") == null)
/*     */     {
/* 104 */       CommandBin.plugin.getConfig().set("settings.block-placing-tnt", Boolean.valueOf(true));
/* 105 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default block placing of tnt");
/* 106 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 109 */     if (CommandBin.plugin.getConfig().get("settings.block-placing-lava") == null)
/*     */     {
/* 111 */       CommandBin.plugin.getConfig().set("settings.block-placing-lava", Boolean.valueOf(true));
/* 112 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default block placing of lava");
/* 113 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 116 */     if (CommandBin.plugin.getConfig().get("settings.teleportonthrowegg") == null)
/*     */     {
/* 118 */       CommandBin.plugin.getConfig().set("settings.teleportonthrowegg", Boolean.valueOf(false));
/* 119 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default teleport on throw egg");
/* 120 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 123 */     if (CommandBin.plugin.getConfig().get("settings.blockcreeperexplosions") == null)
/*     */     {
/* 125 */       CommandBin.plugin.getConfig().set("settings.blockcreeperexplosions", Boolean.valueOf(false));
/* 126 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default block creeper explosions");
/* 127 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 130 */     if (CommandBin.plugin.getConfig().get("settings.orebroadcast.coalore") == null)
/*     */     {
/* 132 */       CommandBin.plugin.getConfig().set("settings.orebroadcast.coalore", Boolean.valueOf(true));
/* 133 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast coal");
/* 134 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 137 */     if (CommandBin.plugin.getConfig().get("settings.orebroadcast.ironore") == null)
/*     */     {
/* 139 */       CommandBin.plugin.getConfig().set("settings.orebroadcast.ironore", Boolean.valueOf(true));
/* 140 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast iron");
/* 141 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 144 */     if (CommandBin.plugin.getConfig().get("settings.orebroadcast.goldore") == null)
/*     */     {
/* 146 */       CommandBin.plugin.getConfig().set("settings.orebroadcast.goldore", Boolean.valueOf(true));
/* 147 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast gold");
/* 148 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 151 */     if (CommandBin.plugin.getConfig().get("settings.orebroadcast.diamondore") == null)
/*     */     {
/* 153 */       CommandBin.plugin.getConfig().set("settings.orebroadcast.diamondore", Boolean.valueOf(true));
/* 154 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast diamond");
/* 155 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 158 */     if (CommandBin.plugin.getConfig().get("settings.orebroadcast.redstoneore") == null)
/*     */     {
/* 160 */       CommandBin.plugin.getConfig().set("settings.orebroadcast.redstoneore", Boolean.valueOf(true));
/* 161 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast redstone");
/* 162 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 165 */     if (CommandBin.plugin.getConfig().get("settings.orebroadcast.lapislazuliore") == null)
/*     */     {
/* 167 */       CommandBin.plugin.getConfig().set("settings.orebroadcast.lapislazuliore", Boolean.valueOf(true));
/* 168 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast lapis lazuli");
/* 169 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 172 */     if (CommandBin.plugin.getConfig().get("settings.mineablemobspawners") == null)
/*     */     {
/* 174 */       CommandBin.plugin.getConfig().set("settings.mineablemobspawners", Boolean.valueOf(true));
/* 175 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default mineable mob spawners");
/* 176 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 179 */     if (CommandBin.plugin.getConfig().get("settings.opscanseepms") == null)
/*     */     {
/* 181 */       CommandBin.plugin.getConfig().set("settings.opscanseepms", Boolean.valueOf(true));
/* 182 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ops can see pms");
/* 183 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 186 */     if (CommandBin.plugin.getConfig().getString("settings.message-of-the-day") == null)
/*     */     {
/* 188 */       CommandBin.plugin.getConfig().set("settings.message-of-the-day", "Please Modify This! [MOTD]");
/* 189 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default message of the day");
/* 190 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 193 */     if (CommandBin.plugin.getConfig().get("settings.customchat") == null)
/*     */     {
/* 195 */       CommandBin.plugin.getConfig().set("settings.customchat", Boolean.valueOf(true));
/* 196 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default custom chat");
/* 197 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 200 */     if (CommandBin.plugin.getConfig().get("settings.bowexplosionradius") == null)
/*     */     {
/* 202 */       CommandBin.plugin.getConfig().set("settings.bowexplosionradius", Integer.valueOf(3));
/* 203 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default bow explosion radius");
/* 204 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 207 */     if (CommandBin.plugin.getConfig().get("settings.spawn-enderdragon-on-hitting-enderegg") == null)
/*     */     {
/* 209 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Enderegg");
/* 210 */       CommandBin.plugin.getConfig().set("settings.spawn-enderdragon-on-hitting-enderegg", Boolean.valueOf(true));
/* 211 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 214 */     if (CommandBin.plugin.getConfig().get("settings.multihomesupport") == null)
/*     */     {
/* 216 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting Multi Home Support");
/* 217 */       CommandBin.plugin.getConfig().set("settings.multihomesupport", Boolean.valueOf(true));
/* 218 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */ 
/* 221 */     if (CommandBin.plugin.getConfig().get("settings.lightningonjoin") == null)
/*     */     {
/* 223 */       System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default lightning on join");
/* 224 */       CommandBin.plugin.getConfig().set("settings.lightningonjoin", Boolean.valueOf(true));
/* 225 */       CommandBin.plugin.saveConfig();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.config.ConfigSetup
 * JD-Core Version:    0.6.0
 */