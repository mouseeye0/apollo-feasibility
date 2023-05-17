package me.mouseeye.fetchers;


import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import me.mouseeye.apis.ProductApi;
import me.mouseeye.domain.Product;

import java.util.List;

@DgsComponent
public class ProductFetcher {

    private final ProductApi productApi;

    public ProductFetcher(ProductApi productApi) {
        this.productApi = productApi;
    }

    @DgsQuery
    public List<Product> products(@InputArgument List<Integer> filteredIds) {
        return productApi.getAll();
    }
}
