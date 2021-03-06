/**
 *****************************************************************************
 Copyright (c) 2015-16 IBM Corporation and other Contributors.
 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 which accompanies this distribution, and is available at
 http://www.eclipse.org/legal/epl-v10.html
 Contributors:
 Mike Tran - Initial Contribution
 Sathiskumar Palaniappan - Initial Contribution
 Mike Robertson
 *****************************************************************************
 *
 */

package com.ibm.internal.iotf.devicemgmt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.iotf.devicemgmt.CustomAction;

/**
 * This class encapsulates a custom action defined within a device management extension.
 * 
 */
public class ConcreteCustomAction implements CustomAction {
	
	public static final String CUSTOM_ACTION_STATUS_UPDATE = "ListenerStatusUpdate";
	
	private Status status;
	private String message;
	private String bundleId;
	private String actionId;
	private String reqId;
	private String typeId;
	private String deviceId;
	private JsonElement parameters;

	public ConcreteCustomAction(String typeId, String deviceId) {
		this.typeId = typeId;
		this.deviceId = deviceId;
	}
	
	public String getBundleId() {
		return bundleId;
	}
	
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}
	
	public String getActionId() {
		return actionId;
	}
	
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	
	public String getReqId() {
		return reqId;
	}
	
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getTypeId() {
		return typeId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * <p>Set the failure status of the current custom action
	 * <br>
	 * The Custom Action handler must use this method to report 
	 * the failure status back to IBM Watson IoT Platform whenever
	 * there is a failure.</p>
	 * 
	 * @param status Failure status of the current custom action
	 */
	public void setStatus(Status status) {
		this.status = status;
		this.fireEvent(CUSTOM_ACTION_STATUS_UPDATE);
	}
	
	/**
	 * <p>Set the failure status of the current custom action
	 * <br>
	 * The Custom Action handler must use this method to report 
	 * the failure status back to IBM Watson IoT Platform whenever
	 * there is a failure.</p>
	 * 
	 * @param status Failure status of the current custom action
	 */
	public void setStatus(Status status, String message) {
		this.status = status;
		this.message = message;
		this.fireEvent(CUSTOM_ACTION_STATUS_UPDATE);
	}
	
	public String getMessage() {
		return this.message;
	}
		
		
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	/**
	 * Trigger the notification message - This method should only be used by the library code
	 * @param event event to be fired
	 */
	public void fireEvent(String event) {
		pcs.firePropertyChange(event, null, this);
	}
		
	/**
	 * Add a new listener to be notified when custom action status is changed. 
	 * 
	 * @param listener PropertyChangeListener
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(CUSTOM_ACTION_STATUS_UPDATE, listener);
	}
	
	public synchronized void clearListener() {
		PropertyChangeListener[] listener = pcs.getPropertyChangeListeners(CUSTOM_ACTION_STATUS_UPDATE);
		for(int i = 0; i < listener.length; i++) {
			pcs.removePropertyChangeListener(listener[i]);
		}
	}
	
	/**
	 * Return the <code>JsonObject</code> representation of the <code>Listener Response</code> object.
	 * @return JsonObject object
	 */
	public JsonObject toJsonObject() {
		JsonObject o = new JsonObject();
		if (this.status != null) {
			o.add("rc", new JsonPrimitive(this.status.get()));
		}
		if (this.message != null) {
			o.add("message", new JsonPrimitive(message));
		}
		if (this.reqId != null) {
			o.add("reqId", new JsonPrimitive(reqId));
		}
		return o;
	}
	
	/**
	 * Return the JSON string of the <code>Listener Response</code> object.
	 */
	public String toString() {
		return toJsonObject().toString();
	}

	public int getStatus() {
		return this.status.get();
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}
	
	public JsonElement getParameters() {
		return parameters;
	}
	
	public void setParameters(JsonElement parameters) {
		this.parameters = parameters;
	}
}
