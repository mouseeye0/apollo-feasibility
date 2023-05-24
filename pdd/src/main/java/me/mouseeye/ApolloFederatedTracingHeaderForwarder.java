package me.mouseeye;

import com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation;
import com.netflix.graphql.dgs.context.GraphQLContextContributor;
import com.netflix.graphql.dgs.internal.DgsRequestData;
import graphql.GraphQLContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApolloFederatedTracingHeaderForwarder implements GraphQLContextContributor {
    @Override
    public void contribute(@NotNull GraphQLContext.Builder builder, @Nullable Map<String, ?> extensions, @Nullable DgsRequestData dgsRequestData) {
        if (dgsRequestData == null || dgsRequestData.getHeaders() == null) {
            return;
        }

        final HttpHeaders headers = dgsRequestData.getHeaders();

        // if the header exists, we should just forward it.
        if (headers.containsKey(FederatedTracingInstrumentation.FEDERATED_TRACING_HEADER_NAME)) {
            builder.put(
                    FederatedTracingInstrumentation.FEDERATED_TRACING_HEADER_NAME,
                    headers
                            .get(FederatedTracingInstrumentation.FEDERATED_TRACING_HEADER_NAME)
                            .stream()
                            .findFirst()
                            .get()
            );
        }  else {
            //otherwise, place a value != "ftv1" so when it gets checked for == ftv1 it fails
            // and trace does not happen.
            builder.put(FederatedTracingInstrumentation.FEDERATED_TRACING_HEADER_NAME, "DO_NOT_TRACE");
        }
    }
}