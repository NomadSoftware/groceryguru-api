package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);

	@Test
	public void test_serialize() throws Exception {
		Item i = new Item(1L);
		// TODO
		String json = mapper.writeValueAsString(i);
		assertThat(json, is(fixture("fixtures/item.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Item i = mapper.readValue(fixture("fixtures/item.json"), Item.class);
		assertThat(i.getId(), is(1L));
		// TODO
	}

}
