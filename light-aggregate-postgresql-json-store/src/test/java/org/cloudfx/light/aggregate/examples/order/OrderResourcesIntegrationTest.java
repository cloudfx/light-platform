package org.cloudfx.light.aggregate.examples.order;

import org.cloudfx.light.aggregate.examples.ResourceIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class OrderResourcesIntegrationTest extends ResourceIntegrationTest {

    @Test
    void exposesOrdersResourceViaRootResource() throws Exception {
        mvc.perform(get("/")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk()).
                andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON)).
                andExpect(jsonPath("$._links.restbucks:orders.href", notNullValue()));
    }
}