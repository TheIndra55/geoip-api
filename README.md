# geoip-api
https://www.spigotmc.org/resources/api-geoip.28015/

**What does it?**

With this api you can get the location of an ip/player, it uses GeoLite data created by MaxMind http://www.maxmind.com. The api will automatically download the database from the maxmind mirror!


**How to use?**

    
    //Get the ip from a player
    InetAddress ip = player.getAddress().getAddress();
    
    //Check if the ip is not null
    if(ip == null){
       return;
    }
     
    //Check if the ip is not local    
    if(ip.isAnyLocalAddress() || ip.isLoopbackAddress()){
       return;
    }
    
    //get the country, city & timezone of the user
    GeoIP geo = new GeoIP(ip);
    geo.countryName;
    geo.city;
    // etc
    


**Plugin.yml**

add this to your plugin.yml
```yaml
depend: [GeoipAPI]
```
