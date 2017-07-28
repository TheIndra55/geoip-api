package eu.theindra.geoip.api;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.bukkit.entity.Player;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.timeZone;

import eu.theindra.geoip.Main;

public class GeoPlayer {
	
	public String countryCode;
	public String countryName;
	public String region;
	public String city;
	public String postalCode;
	public float latitude;
	public float longitude;
	public int dma_code;
	public int area_code;
	public int metro_code;
	public String time_zone;
	
	private Location loc;
	
	public GeoPlayer(Player player){
		InetSocketAddress address = player.getAddress();
		Location loc = Main.geoip.getLocation(address.getAddress());
		
		this.countryCode = loc.countryCode;
		this.countryName = loc.countryName;
		this.region = loc.region;
		this.city = loc.city;
		this.postalCode = loc.postalCode;
		this.latitude = loc.latitude;
		this.longitude = loc.longitude;
		this.dma_code = loc.dma_code;
		this.area_code = loc.area_code;
		this.metro_code = loc.metro_code;
		
		this.time_zone = timeZone.timeZoneByCountryAndRegion(loc.countryName, loc.region);
		this.loc = loc;
	}
	
	public Location getMaxmindLocationClass(){
		return loc;
	}
	
	public LookupService getMaxmindLookupService(){
		return Main.geoip;
	}
	
}
