package com.SCMXPert.sbmongodb.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CopyAddEvent")
public class CopyAddEvent {

	@Id
	private ObjectId id;
	private String Event_Id;
	private String BpId;
	private String EventName;
	private String DateTime;

	public void setEvent_Id(String event_Id) {
		Event_Id = event_Id;
	}

	public String getEvent_Id() {
		return Event_Id;
	}

	public String getBpId() {
		return BpId;
	}

	public void setBpId(String bpId) {
		BpId = bpId;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

}
