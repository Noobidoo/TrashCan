/*     */ package me.cain.commandbin.commands;
/*     */ 
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.PluginCommand;
/*     */ 
/*     */ public class CommandRegistration
/*     */ {
/*     */   public static void SetupCommands()
/*     */   {
/*  13 */     CommandExecutor TeleporterCommands = new PlayerCommands();
/*  14 */     CommandBin.plugin.getCommand("tp").setExecutor(TeleporterCommands);
/*  15 */     CommandBin.plugin.getCommand("tphere").setExecutor(TeleporterCommands);
/*  16 */     CommandBin.plugin.getCommand("tpall").setExecutor(TeleporterCommands);
/*  17 */     CommandBin.plugin.getCommand("tp2p").setExecutor(TeleporterCommands);
/*  18 */     CommandBin.plugin.getCommand("put").setExecutor(TeleporterCommands);
/*  19 */     CommandBin.plugin.getCommand("tpworld").setExecutor(TeleporterCommands);
/*  20 */     CommandBin.plugin.getCommand("spawn").setExecutor(TeleporterCommands);
/*  21 */     CommandBin.plugin.getCommand("setspawn").setExecutor(TeleporterCommands);
/*     */ 
/*  25 */     CommandExecutor WorldCommands = new WorldCommands();
/*  26 */     CommandBin.plugin.getCommand("createworld").setExecutor(WorldCommands);
/*  27 */     CommandBin.plugin.getCommand("unloadworld").setExecutor(WorldCommands);
/*     */ 
/*  31 */     CommandExecutor AdminCommands = new AdministrationCommands();
/*  32 */     CommandBin.plugin.getCommand("shutdown").setExecutor(AdminCommands);
/*  33 */     CommandBin.plugin.getCommand("cmdbin").setExecutor(AdminCommands);
/*     */ 
/*  37 */     CommandExecutor FakeJL = new FakeJoinLeaveCommands();
/*  38 */     CommandBin.plugin.getCommand("join").setExecutor(FakeJL);
/*  39 */     CommandBin.plugin.getCommand("leave").setExecutor(FakeJL);
/*     */ 
/*  43 */     CommandExecutor Debug = new DebugCommands();
/*  44 */     CommandBin.plugin.getCommand("ping").setExecutor(Debug);
/*     */ 
/*  48 */     CommandExecutor GM = new GameModeCommands();
/*  49 */     CommandBin.plugin.getCommand("creative").setExecutor(GM);
/*  50 */     CommandBin.plugin.getCommand("survival").setExecutor(GM);
/*     */ 
/*  54 */     CommandExecutor WeatherControl = new WeatherCommands();
/*  55 */     CommandBin.plugin.getCommand("rain").setExecutor(WeatherControl);
/*  56 */     CommandBin.plugin.getCommand("sun").setExecutor(WeatherControl);
/*     */ 
/*  60 */     CommandExecutor PlayerCommands = new PlayerCommands();
/*  61 */     CommandBin.plugin.getCommand("shoot").setExecutor(PlayerCommands);
/*  62 */     CommandBin.plugin.getCommand("strike").setExecutor(PlayerCommands);
/*  63 */     CommandBin.plugin.getCommand("heal").setExecutor(PlayerCommands);
/*  64 */     CommandBin.plugin.getCommand("feed").setExecutor(PlayerCommands);
/*  65 */     CommandBin.plugin.getCommand("god").setExecutor(PlayerCommands);
/*  66 */     CommandBin.plugin.getCommand("facepalm").setExecutor(PlayerCommands);
/*  67 */     CommandBin.plugin.getCommand("explode").setExecutor(PlayerCommands);
/*  68 */     CommandBin.plugin.getCommand("light").setExecutor(PlayerCommands);
/*  69 */     CommandBin.plugin.getCommand("roll").setExecutor(PlayerCommands);
/*  70 */     CommandBin.plugin.getCommand("smoke").setExecutor(PlayerCommands);
/*  71 */     CommandBin.plugin.getCommand("explosionstick").setExecutor(PlayerCommands);
/*  72 */     CommandBin.plugin.getCommand("lightningstick").setExecutor(PlayerCommands);
/*  73 */     CommandBin.plugin.getCommand("slap").setExecutor(PlayerCommands);
/*  74 */     CommandBin.plugin.getCommand("msg").setExecutor(PlayerCommands);
/*  75 */     CommandBin.plugin.getCommand("clear").setExecutor(PlayerCommands);
/*  76 */     CommandBin.plugin.getCommand("kill").setExecutor(PlayerCommands);
/*  77 */     CommandBin.plugin.getCommand("i").setExecutor(PlayerCommands);
/*  78 */     CommandBin.plugin.getCommand("time").setExecutor(PlayerCommands);
/*  79 */     CommandBin.plugin.getCommand("nick").setExecutor(PlayerCommands);
/*  80 */     CommandBin.plugin.getCommand("setxp").setExecutor(PlayerCommands);
/*  81 */     CommandBin.plugin.getCommand("up").setExecutor(PlayerCommands);
/*  82 */     CommandBin.plugin.getCommand("unlimited").setExecutor(PlayerCommands);
/*  83 */     CommandBin.plugin.getCommand("delunlimited").setExecutor(PlayerCommands);
/*  84 */     CommandBin.plugin.getCommand("mytime").setExecutor(PlayerCommands);
/*  85 */     CommandBin.plugin.getCommand("armour").setExecutor(PlayerCommands);
/*  86 */     CommandBin.plugin.getCommand("me").setExecutor(PlayerCommands);
/*  87 */     CommandBin.plugin.getCommand("more").setExecutor(PlayerCommands);
/*     */ 
/*  91 */     CommandExecutor SnowmanCommands = new SnowmanCommands();
/*  92 */     CommandBin.plugin.getCommand("snowman").setExecutor(SnowmanCommands);
/*  93 */     CommandBin.plugin.getCommand("unsnowman").setExecutor(SnowmanCommands);
/*     */ 
/*  97 */     CommandExecutor ModCommands = new ModerationCommands();
/*  98 */     CommandBin.plugin.getCommand("kick").setExecutor(ModCommands);
/*  99 */     CommandBin.plugin.getCommand("ban").setExecutor(ModCommands);
/* 100 */     CommandBin.plugin.getCommand("unban").setExecutor(ModCommands);
/* 101 */     CommandBin.plugin.getCommand("freeze").setExecutor(ModCommands);
/* 102 */     CommandBin.plugin.getCommand("unfreeze").setExecutor(ModCommands);
/* 103 */     CommandBin.plugin.getCommand("handicap").setExecutor(ModCommands);
/* 104 */     CommandBin.plugin.getCommand("unhandicap").setExecutor(ModCommands);
/* 105 */     CommandBin.plugin.getCommand("mute").setExecutor(ModCommands);
/* 106 */     CommandBin.plugin.getCommand("unmute").setExecutor(ModCommands);
/* 107 */     CommandBin.plugin.getCommand("who").setExecutor(ModCommands);
/* 108 */     CommandBin.plugin.getCommand("paid").setExecutor(ModCommands);
/* 109 */     CommandBin.plugin.getCommand("banip").setExecutor(ModCommands);
/* 110 */     CommandBin.plugin.getCommand("unbanip").setExecutor(ModCommands);
/*     */ 
/* 114 */     CommandExecutor MobCommands = new MobCommands();
/* 115 */     CommandBin.plugin.getCommand("spawnmob").setExecutor(MobCommands);
/*     */ 
/* 119 */     CommandExecutor HomeCommands = new HomeCommands();
/* 120 */     CommandBin.plugin.getCommand("home").setExecutor(HomeCommands);
/* 121 */     CommandBin.plugin.getCommand("sethome").setExecutor(HomeCommands);
/*     */ 
/* 125 */     CommandExecutor WarpCommands = new WarpCommands();
/* 126 */     CommandBin.plugin.getCommand("warp").setExecutor(WarpCommands);
/* 127 */     CommandBin.plugin.getCommand("setwarp").setExecutor(WarpCommands);
/* 128 */     CommandBin.plugin.getCommand("delwarp").setExecutor(WarpCommands);
/*     */ 
/* 132 */     CommandExecutor tb = new TorchBowCommands();
/* 133 */     CommandBin.plugin.getCommand("torchbow").setExecutor(tb);
/*     */ 
/* 137 */     CommandExecutor help = new HelpCommands();
/* 138 */     CommandBin.plugin.getCommand("cbhelp").setExecutor(help);
/*     */ 
/* 142 */     CommandExecutor ex = new ExplosionBowCommands();
/* 143 */     CommandBin.plugin.getCommand("explosionbow").setExecutor(ex);
/*     */ 
/* 147 */     CommandExecutor cb = new CrossBowCommands();
/* 148 */     CommandBin.plugin.getCommand("crossbow").setExecutor(cb);
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.CommandRegistration
 * JD-Core Version:    0.6.0
 */