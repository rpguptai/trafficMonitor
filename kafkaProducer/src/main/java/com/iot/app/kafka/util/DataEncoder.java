package com.iot.app.kafka.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.app.kafka.vo.EventData;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;


public class DataEncoder implements Encoder<EventData> {
	
	private static final Logger logger = Logger.getLogger(DataEncoder.class);	
	private static ObjectMapper objectMapper = new ObjectMapper();		
	public DataEncoder(VerifiableProperties verifiableProperties) {

    }
	public byte[] toBytes(EventData iotEvent) {
		try {
			String msg = objectMapper.writeValueAsString(iotEvent);
			logger.info(msg);
			return msg.getBytes();
		} catch (JsonProcessingException e) {
			logger.error("Error in Serialization", e);
		}
		return null;
	}
}
