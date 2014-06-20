package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import io.dropwizard.jackson.Jackson;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelTestUtil {

	static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);
	static final DateTime dt = DateTime.parse("1972-02-07T12:34:56.789Z");

}
