package me.mouseeye.fetchers;


import com.netflix.graphql.dgs.*;
import me.mouseeye.domain.Pdd;
import me.mouseeye.domain.Product;

import java.time.LocalDateTime;
import java.util.Map;

@DgsComponent
public class PddFetcher {

    @DgsEntityFetcher(name = "Product")
    public Product product(Map<String, Object> values) {
        return new Product((String) values.get("id"), null);
    }

    @DgsData(parentType = "Product")
    public Pdd pdd(DgsDataFetchingEnvironment environment) {
        Product product = environment.getSource();
        return new Pdd(LocalDateTime.now().toString());
    }
}
