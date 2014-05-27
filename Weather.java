import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/*
 *
 * Project: Yahoo Weather for Processing
 * Author: delvedor
 * Twitter: @delvedor
 * License: GNU GPLv2
 * GitHub: https://github.com/delvedor/YahooWeatherProcessing
 *
 */

class Weather {

  private XML root;
  private XML channel;
  private boolean reachable;
  private int code;
  private String tempUnit;
  private final static String  URL = "https://weather.yahooapis.com";
  private final static int TIMEOUT = 5000;

  public Weather(int code, String tempUnit) {
    this.code = code;
    this.tempUnit = tempUnit;
    reachable = checkConnection();
    
    if (reachable) {
      root = loadXML("http://weather.yahooapis.com/forecastrss?w="+code+"&u="+tempUnit);
    } else {
      root = loadXML("error.xml");
    }
    
    channel = root.getChild("channel");
  }
  
  /*
   * General methods
   */
  public boolean checkConnection() {
    try {
      HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
      connection.setConnectTimeout(TIMEOUT);
      connection.setReadTimeout(TIMEOUT);
      connection.setRequestMethod("HEAD");
      int responseCode = connection.getResponseCode();
      return (200 <= responseCode && responseCode <= 399);
    } catch (IOException exception) {
      return false;
    }
  }
  
  public void update() {
    reachable = checkConnection();
    
    if (reachable) {
      root = loadXML("http://weather.yahooapis.com/forecastrss?w="+code+"&u="+tempUnit);
    } else {
      root = loadXML("error.xml");
    }
    
    channel = root.getChild("channel");
  }
  
  public String lastUpdate(){
    Date date = new Date();
    return date.toString();
  }

  /*
   * Today
   */
  public String getCityName() {
    return channel.getChild("yweather:location").getString("city");
  }
  
  public String getCountryName() {
    return channel.getChild("yweather:location").getString("country");
  }
  
  public String getWeatherCondition() {
    return channel.getChild("item").getChild("yweather:condition").getString("text");
  }
  
  public String getSunrise() {
    return channel.getChild("yweather:astronomy").getString("sunrise");
  }
  
  public String getSunset() {
    return channel.getChild("yweather:astronomy").getString("sunset");
  }
  
  public float getPressure() {
    return channel.getChild("yweather:atmosphere").getFloat("pressure");
  }
  
  public int getHumidity() {
    return channel.getChild("yweather:atmosphere").getInt("humidity");
  }
  
  public int getTemperature() {
    return channel.getChild("item").getChild("yweather:condition").getInt("temp");
  }
  
  public int getWeatherConditionCode() {
    return channel.getChild("item").getChild("yweather:condition").getInt("code");
  }
  
  /*
   * Tomorrow
   */
  public int getTemperatureLowTomorrow() {
    return channel.getChild("item").getChild(17).getInt("low");
  }
  
  public int getTemperatureHighTomorrow() {
    return channel.getChild("item").getChild(17).getInt("high");
  }
  
  
  public String getWeatherConditionTomorrow() {
    return channel.getChild("item").getChild(17).getString("text");
  }
  
  public int getWeatherConditionCodeTomorrow(){
    return channel.getChild("item").getChild(17).getInt("code");
  }
  
  
  public String getWeekdayTomorrow() {
    return channel.getChild("item").getChild(17).getString("day");
  }
  
  /*
   * Day After Tomorrow
   */
  public int getTemperatureLowDayAfterTomorrow() {
    return channel.getChild("item").getChild(19).getInt("low");
  }
  
  public int getTemperatureHighDayAfterTomorrow() {
    return channel.getChild("item").getChild(19).getInt("high");
  }
  
  
  public String getWeatherConditionDayAfterTomorrow() {
    return channel.getChild("item").getChild(19).getString("text");
  }
  
  public int getWeatherConditionCodeDayAfterTomorrow(){
    return channel.getChild("item").getChild(19).getInt("code");
  }
  
  
  public String getWeekdayDayAfterTomorrow() {
    return channel.getChild("item").getChild(19).getString("day");
  }

}