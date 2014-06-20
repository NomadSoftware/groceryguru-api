package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);
	private static final DateTime dt = DateTime.parse("1972-02-07T12:34:56.789Z");

	@Test
	public void test_serialize() throws Exception {
		Item i = new Item(1L);
		i.setAisleId(2L);
		i.setCreated(dt);
		i.setUpdated(dt);
		i.setVersion(3);
		String json = mapper.writeValueAsString(i);
		assertThat(json, is(fixture("fixtures/item.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Item i = mapper.readValue(fixture("fixtures/item.json"), Item.class);
		assertThat(i.getId(), is(1L));
		assertThat(i.getAisleId(), is(2L));
		assertThat(i.getCreated().getMillis(), is(dt.getMillis()));
		assertThat(i.getUpdated().getMillis(), is(dt.getMillis()));
		assertThat(i.getVersion(), is(3));
	}

}
