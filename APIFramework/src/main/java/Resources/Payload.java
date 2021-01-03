package Resources;

import java.util.ArrayList;
import java.util.List;
import Pojo.Location;
import Pojo.PlaceInfo;

public class Payload {
	
	public static PlaceInfo getPayload(){
	PlaceInfo pi =	new PlaceInfo();
	pi.setAccuracy("50");
	pi.setAddress("29, side layout, cohen 09");
	pi.setName("Frontline house");
	pi.setWebsite("http://google.com");
	pi.setLanguage("French-IN");
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	pi.setLocation(l);
	pi.setPhone_number("(+91) 983 893 3937");
	List <String> li = new ArrayList<String>();
	li.add("shoe park");
	li.add("shop");
	pi.setTypes(li);
	return pi;
	}
}
