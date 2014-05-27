Yahoo Weather Processing
======================

A lightweight Yahoo Weather library for processing.
Soon there will be the package.jar.

Easy to use:
Create a new .pde file and paste the content of *Weather.java* into it.
After that, in the main *.pde* file use this:

    Weather weather = new Weather(code, "unit");

For use the methods, do:

    weather.method();
    
At the moment there's not a method to change the WOEID code, will be implemented soon.

You can get the code [here](http://woeid.rosselliot.co.nz/).

If there's not internet connection the library load automatically the *error.xml* file, who is a copy without data of the Yahoo Weather XML .

List of methods:

*General methods:*
+ Weather(int code, String tempUnit)
+ boolean checkConnection()
+ void update()
+ String lastUpdate()

*Today:*
+ String getCityName()
+ String getCountryName()
+ String getWeatherCondition()
+ String getSunrise()
+ String getSunset()
+ float getPressure()
+ int getHumidity()
+ int getTemperature()
+ int getWeatherConditionCode()

*Tomorrow:*
+ int getTemperatureLowTomorrow()
+ int getTemperatureHighTomorrow()
+ String getWeatherConditionTomorrow()
+ int getWeatherConditionCodeTomorrow()
+ String getWeekdayTomorrow()

*Day After Tomorrow:*
+ int getTemperatureLowDayAfterTomorrow()
+ int getTemperatureHighDayAfterTomorrow()
+ String getWeatherConditionDayAfterTomorrow()
+ int getWeatherConditionCodeDayAfterTomorrow()
+ String getWeekdayDayAfterTomorrow()

Here you can find the [Yahoo Weather API](https://developer.yahoo.com/weather/).

______________________________________________________________________________________________________________________

The library is released under the GNU GPLv2 license.

The software is provided "as is", without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the software.

