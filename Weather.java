/*
 * Project: Yahoo Weather for Processing
 * Author: delvedor
 * GitHub: https://github.com/delvedor
 */

class Weather {

  private XML root;
  private XML channel;

  public Weather(int code) {
    root = loadXML("http://weather.yahooapis.com/forecastrss?w="+code+"&u=c");
    channel = root.getChild("channel");
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