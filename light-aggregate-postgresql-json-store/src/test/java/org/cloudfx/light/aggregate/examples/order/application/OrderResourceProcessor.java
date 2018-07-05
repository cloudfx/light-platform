package org.cloudfx.light.aggregate.examples.order.application;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cloudfx.light.aggregate.examples.order.domain.Order;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class OrderResourceProcessor implements ResourceProcessor<Resource<Order>> {

    private static final String CANCEL = "cancel";
    private static final String UPDATE = "update";
    private final @NonNull
    EntityLinks links;


    @Override
    public Resource<Order> process(Resource<Order> resource) {
        Order order = resource.getContent();

        if (!order.isPaid()) {
            resource.add(links.linkForSingleResource(order).withRel(CANCEL));
            resource.add(links.linkForSingleResource(order).withRel(UPDATE));
        }

        return resource;
    }

}
