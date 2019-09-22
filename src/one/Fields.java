package one;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fields {
private String name;
private String fathersName;
private String address;
private String dateOfBirth;
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getFathersName() {
return fathersName;
}
public void setFathersName(String fathersName) {
this.fathersName = fathersName;
}
public String getAddress() {
return address;
}
public void setAddress(String address) {
this.address = address;
}
public String getDateOfBirth() {
	
	DateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
    Date date = null;
	try {
		date = format1.parse(dateOfBirth);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    DateFormat format2 = new SimpleDateFormat("dd MMMMM yyyy");
    String dateString = format2.format(date);
    
	
	
return dateOfBirth+" ("+dateString+")";
}
public void setDateOfBirth(String age) {
this.dateOfBirth = age;
}

}
