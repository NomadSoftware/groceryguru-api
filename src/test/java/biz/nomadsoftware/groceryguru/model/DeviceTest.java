package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);

	@Test
	public void test_serialize() throws Exception {
		Device d = new Device(1L);
		// TODO
		String json = mapper.writeValueAsString(d);
		assertThat(json, is(fixture("fixtures/device.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Device d = mapper.readValue(fixture("fixtures/device.json"), Device.class);
		assertThat(d.getId(), is(1L));
		// TODO
	}

}
