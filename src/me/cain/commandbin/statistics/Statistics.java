package me.cain.commandbin.statistics;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import me.cain.commandbin.CommandBin;

public class Statistics
{
  public static void StartStats()
  {
    String url = String.format("http://cain.donaghey.x10.mx/usage/counter.php", new Object[0]);

    System.out.println(CommandBin.plugin.Plugin + "[Stats] Starting up CommandBin has been logged online!");
    try
    {
      new URL(url).openConnection().getInputStream();
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}