package Resources;

import java.util.ArrayList;
import java.util.List;
import Pojo.Location;
import Pojo.PlaceInfo;

public class Payload {
	
	public static PlaceInfo getPayload(String name, String address, String language){
	PlaceInfo pi =	new PlaceInfo();
	pi.setAccuracy("50");
	pi.setAddress(address);
	pi.setName(name);
	pi.setWebsite("http://google.com");
	pi.setLanguage(language);
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
