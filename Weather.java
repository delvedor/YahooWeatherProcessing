import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Project: Yahoo Weather for Processing
 * Author: delvedor
 * GitHub: https://github.com/delvedor
 * License: GNU GPLv2
 */

class Weather {

  private XML root;
  private XML channel;
  private boolean reachable;

  public Weather(int code, String tempUnit) {
    reachable = checkConnection("http://weather.yahooapis.com", 5000);
    
    if (reachable) {
      root = loadXML("http://weather.yahooapis.com/forecastrss?w="+code+"&u="+tempUnit);
    } else {
      root = loadXML("error.xml");
    }
    
    channel = root.getChild("channel");
  }
  
  /*
   * Check if the called host is available.
   */
  public boolean checkConnection(String url, int timeout) {
    url = url.replaceFirst("https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.
    try {
      HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setConnectTimeout(timeout);
      connection.setReadTimeout(timeout);
      connection.setRequestMethod("HEAD");
      int responseCode = connection.getResponseCode();
      return (200 <= responseCode && responseCode <= 399);
    } catch (IOException exception) {
      return false;
    }
  }
  
  /*
   * Current Day
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