package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);
	private static final DateTime dt = DateTime.parse("1972-02-07T12:34:56.789Z");

	@Test
	public void test_serialize() throws Exception {
		Device d = new Device(1L);
		d.setAccountId(2L);
		d.setCreated(dt);
		d.setUpdated(dt);
		d.setVersion(3);
		String json = mapper.writeValueAsString(d);
		assertThat(json, is(fixture("fixtures/device.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Device d = mapper.readValue(fixture("fixtures/device.json"), Device.class);
		assertThat(d.getId(), is(1L));
		assertThat(d.getAccountId(), is(2L));
		assertThat(d.getCreated().getMillis(), is(dt.getMillis()));
		assertThat(d.getUpdated().getMillis(), is(dt.getMillis()));
		assertThat(d.getVersion(), is(3));
	}

}
