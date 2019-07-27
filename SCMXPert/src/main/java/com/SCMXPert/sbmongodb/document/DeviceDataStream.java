package com.SCMXPert.sbmongodb.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
 
@Document(collection = "DeviceDataStream")
public class DeviceDataStream {

    @Id
    private ObjectId id;
    
    @Field(value = "Device_Id")
    private String Device_Id;
    
    @Field(value = "Speed")
    private String Speed;
    
    @Field(value = "Sensor_id")
    private String Sensor_id;
    
    @Field(value = "Temp_Measurment")
    private String Temp_Measurment;
    
    @Field(value = "UTC")
    private String UTC;
    
    @Field(value = "Report_Status_data")
    private String Report_Status_data;
    
    @Field(value = "Time")
    private String Time;
    
    @Field(value = "Latitude")
    private String Latitude;
    
    @Field(value = "No_of_tags")
    private String No_of_tags;
    
    @Field(value = "Longitude")
    private String Longitude;
    
    @Field(value = "Date")
    private String Date;
    
    @Field(value = "Message_Number")
    private String Message_Number;
    
    @Field(value = "Report_type")
    private String Report_type;
    
    @Field(value = "Signal")
    private String Signal;
    
    @Field(value = "Internal_temperature")
    private String Internal_temperature;
    
    @Field(value = "Modem_Registration_status")
    private String Modem_Registration_status;
    
    @Field(value = "BAT")
    private String BAT;
    
    
    @Field(value = "Modem_IMEI")
    private String Modem_IMEI;
    
    @Field(value = "Course")
    private String Course;
    
    @Field(value = "Tag_Life_Time")
    private String Tag_Life_Time;
    
    @Field(value = "MessageType")
    private String MessageType;
    
    @Field(value = "Distance")
    private String Distance;
    
    @Field(value = "Altitude")
    private String Altitude;
    
    @Field(value = "Extended_power_report")
    private String Extended_power_report;

	public String getDevice_Id() {
		return Device_Id;
	}

	public void setDevice_Id(String device_Id) {
		Device_Id = device_Id;
	}

	public String getSpeed() {
		return Speed;
	}

	public void setSpeed(String speed) {
		Speed = speed;
	}

	public String getSensor_id() {
		return Sensor_id;
	}

	public void setSensor_id(String sensor_id) {
		Sensor_id = sensor_id;
	}

	public String getTemp_Measurment() {
		return Temp_Measurment;
	}

	public void setTemp_Measurment(String temp_Measurment) {
		Temp_Measurment = temp_Measurment;
	}

	public String getUTC() {
		return UTC;
	}

	public void setUTC(String uTC) {
		UTC = uTC;
	}

	public String getReport_Status_data() {
		return Report_Status_data;
	}

	public void setReport_Status_data(String report_Status_data) {
		Report_Status_data = report_Status_data;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getNo_of_tags() {
		return No_of_tags;
	}

	public void setNo_of_tags(String no_of_tags) {
		No_of_tags = no_of_tags;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getMessage_Number() {
		return Message_Number;
	}

	public void setMessage_Number(String message_Number) {
		Message_Number = message_Number;
	}

	public String getReport_type() {
		return Report_type;
	}

	public void setReport_type(String report_type) {
		Report_type = report_type;
	}

	public String getSignal() {
		return Signal;
	}

	public void setSignal(String signal) {
		Signal = signal;
	}

	public String getInternal_temperature() {
		return Internal_temperature;
	}

	public void setInternal_temperature(String internal_temperature) {
		Internal_temperature = internal_temperature;
	}

	public String getModem_Registration_status() {
		return Modem_Registration_status;
	}

	public void setModem_Registration_status(String modem_Registration_status) {
		Modem_Registration_status = modem_Registration_status;
	}

	public String getBAT() {
		return BAT;
	}

	public void setBAT(String bAT) {
		BAT = bAT;
	}

	public String getModem_IMEI() {
		return Modem_IMEI;
	}

	public void setModem_IMEI(String modem_IMEI) {
		Modem_IMEI = modem_IMEI;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public String getTag_Life_Time() {
		return Tag_Life_Time;
	}

	public void setTag_Life_Time(String tag_Life_Time) {
		Tag_Life_Time = tag_Life_Time;
	}

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public String getDistance() {
		return Distance;
	}

	public void setDistance(String distance) {
		Distance = distance;
	}

	public String getAltitude() {
		return Altitude;
	}

	public void setAltitude(String altitude) {
		Altitude = altitude;
	}

	public String getExtended_power_report() {
		return Extended_power_report;
	}

	public void setExtended_power_report(String extended_power_report) {
		Extended_power_report = extended_power_report;
	}

	@Override
	public String toString() {
		return "DeviceDataStream [Device_Id=" + Device_Id + ", Speed=" + Speed + ", Sensor_id=" + Sensor_id
				+ ", Temp_Measurment=" + Temp_Measurment + ", UTC=" + UTC + ", Report_Status_data=" + Report_Status_data
				+ ", Time=" + Time + ", Latitude=" + Latitude + ", No_of_tags=" + No_of_tags + ", Longitude="
				+ Longitude + ", Date=" + Date + ", Message_Number=" + Message_Number + ", Report_type=" + Report_type
				+ ", Signal=" + Signal + ", Internal_temperature=" + Internal_temperature
				+ ", Modem_Registration_status=" + Modem_Registration_status + ", BAT=" + BAT + ", Modem_IMEI="
				+ Modem_IMEI + ", Course=" + Course + ", Tag_Life_Time=" + Tag_Life_Time + ", MessageType="
				+ MessageType + ", Distance=" + Distance + ", Altitude=" + Altitude + ", Extended_power_report="
				+ Extended_power_report + ", getDevice_Id()=" + getDevice_Id() + ", getSpeed()=" + getSpeed()
				+ ", getSensor_id()=" + getSensor_id() + ", getTemp_Measurment()=" + getTemp_Measurment()
				+ ", getUTC()=" + getUTC() + ", getReport_Status_data()=" + getReport_Status_data() + ", getTime()="
				+ getTime() + ", getLatitude()=" + getLatitude() + ", getNo_of_tags()=" + getNo_of_tags()
				+ ", getLongitude()=" + getLongitude() + ", getDate()=" + getDate() + ", getMessage_Number()="
				+ getMessage_Number() + ", getReport_type()=" + getReport_type() + ", getSignal()=" + getSignal()
				+ ", getInternal_temperature()=" + getInternal_temperature() + ", getModem_Registration_status()="
				+ getModem_Registration_status() + ", getBAT()=" + getBAT() + ", getModem_IMEI()=" + getModem_IMEI()
				+ ", getCourse()=" + getCourse() + ", getTag_Life_Time()=" + getTag_Life_Time() + ", getMessageType()="
				+ getMessageType() + ", getDistance()=" + getDistance() + ", getAltitude()=" + getAltitude()
				+ ", getExtended_power_report()=" + getExtended_power_report() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    


    

    
}


/*

@Indexed(unique = true)
@Field(value = "Sensor_id")
private String sensorid;
public String getSensorid() {
	return sensorid;
}



@Field(value = "Speed")
private String Speed;
public String getSpeed() {
	return Speed;
}

@Field(value = "Temp_Measurment")
private String Temp_Measurment;
public String getTempMeasurment() {
	return Temp_Measurment;
}
@Field(value = "UTC")
private String UTC;
public String getUTC() {
	return UTC;
}
@Field(value = "Report_Status_data")
private String Report_Status_data;
public String getReportStatusdata() {
	return Report_Status_data;
}
@Field(value = "Time")
private String Time;
public String getTime() {
	return Time;
}
@Field(value = "Latitude")
private String Latitude;
public String getLatitude() {
	return Latitude;
}
@Field(value = "No_of_tags")
private String No_of_tags;
public String getNooftags() {
	return No_of_tags;
}
@Field(value = "Message_Number")
private String Message_Number;
public String getMessageNumber() {
	return Message_Number;
}
@Field(value = "Longitude")
private String Longitude;
public String getLongitude() {
	return Longitude;
}
@Field(value = "Date")
private String Date;
public String getDate() {
	return Date;
}
@Field(value = "Report_type")
private String Report_type;
public String getReporttype() {
	return Report_type;
}
@Field(value = "Signal")
private String Signal;
public String getSignal() {
	return Signal;
}
@Field(value = "Internal_temperature")
private String Internal_temperature;
public String getInternaltemperature() {
	return Internal_temperature;
}
@Field(value = "Modem_Registration_status")
private String Modem_Registration_status;
public String getModemRegistrationstatus() {
	return Modem_Registration_status;
}
@Field(value = "BAT")
private String BAT;
public String getBAT() {
	return BAT;
}
@Field(value = "Modem_IMEI")
private String Modem_IMEI;
public String getModemIMEI() {
	return Modem_IMEI;
}
@Field(value = "Course")
private String Course;
public String getCourse() {
	return Course;
}
@Field(value = "Tag_Life_Time")
private String Tag_Life_Time;
public String getTag_LifeTime() {
	return Tag_Life_Time;
}
@Field(value = "MessageType")
private String MessageType;
public String getMessageType() {
	return MessageType;
}
@Field(value = "Distance")
private String Distance;
public String getDistance() {
	return Distance;
}
@Field(value = "Altitude")
private String Altitude;
public String getAltitude() {
	return Altitude;
}
@Field(value = "Extended_power_report")
private String Extended_power_report;
public String getExtendedpowerreport() {
	return Extended_power_report;
}

@Override
public String toString() {
	return "id:" + this._id + ", Speed: " + this.Speed+", Sensor_id: " + this.sensorid + ", Temp_Measurment: " + this.Temp_Measurment + ", UTC: "
			+ this.UTC+  ", Report_Status_data: " + this.Report_Status_data +  ", Time: " + this.Time  +
			", Latitude: " + this.Latitude +  ", No_of_tags: " + this.No_of_tags+", Message_Number: " + this.Message_Number+
			", Longitude: " + this.Longitude+", Date: " + this.Date +", Report_type: " + this.Report_type+ ", Signal: "+this.Signal +", Internal_temperature: " + this.Internal_temperature 
			+", Modem_Registration_status: " + this.Modem_Registration_status+", BAT: " + this.BAT+", Modem_IMEI: " + this.Modem_IMEI+", Course: " + this.Course
			+", Tag_Life_Time: " + this.Tag_Life_Time+", Report_type: " + this.Report_type+", MessageType: " + this.MessageType+", Distance: " + this.Distance
			+", Altitude: " + this.Altitude+", Extended_power_report: " + this.Extended_power_report;
}*/