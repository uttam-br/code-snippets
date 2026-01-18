package in.uttamrabari.elasticsearchdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregate;
import co.elastic.clients.elasticsearch._types.aggregations.StringTermsAggregate;
import co.elastic.clients.elasticsearch._types.aggregations.StringTermsBucket;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

@SpringBootApplication
public class ElasticSearchDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ElasticSearchDemoApplication.class, args);

        Path caCertificatePath = Paths.get("/Users/uttambr/Desktop/learning/elasticsearch/http_ca.crt");

        CertificateFactory factory = CertificateFactory.getInstance("X.509");

        Certificate trustedCa;

        try (InputStream is = Files.newInputStream(caCertificatePath)) {
            trustedCa = factory.generateCertificate(is);
        }

        KeyStore trustStore = KeyStore.getInstance("pkcs12");
        trustStore.load(null, null);
        trustStore.setCertificateEntry("ca", trustedCa);

        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(trustStore, null)
                .build();

        final BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "DcltyaCXqWjsEwnGZPwu")
        );

        RestClient restClient = RestClient
                .builder(new HttpHost("localhost", 9200, "https"))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setSSLContext(sslContext)
                        .setDefaultCredentialsProvider(credsProvider)
                )
                .build();

        JacksonJsonpMapper jsonpMapper = new JacksonJsonpMapper();
        ElasticsearchTransport transport = new RestClientTransport(restClient, jsonpMapper);

        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        String searchText = "search analytics";

        SearchResponse<Product> response = esClient.search(s -> s
                        .index("products") // The index to search in
                        .query(q -> q      // Start building the query
                                .match(m -> m   // Use a 'match' query
                                        .field("description")
                                        .query(searchText)
                                )
                        ),
                Product.class // The class to map the JSON 'hit' to
        );

        for (Hit<Product> hit : response.hits().hits()) {
            Product p = hit.source();
            if (p == null) {
                continue;
            }
            System.out.println("Found product " + p.getName() + " with score : " + hit.score());
        }

        // aggregation
        String aggName = "products_by_tag";

        SearchResponse<Void> aggResponse = esClient.search(s -> s
                        .index("products")
                        .size(0) // We don't care about the search hits, just the agg results
                        .aggregations(aggName, a -> a // Start 'aggregations' block
                                .terms(t -> t // We want a 'terms' (bucket) aggregation
                                        .field("tags") // On the 'tags' (keyword) field
                                )
                        ),
                Void.class // We are ignoring the source documents
        );

        Aggregate agg = aggResponse.aggregations().get(aggName);

        StringTermsAggregate tagsAgg = agg.sterms();

        for (StringTermsBucket bucket : tagsAgg.buckets().array()) {
            System.out.println("Tag: " + bucket.key().stringValue() + " | Count: " + bucket.docCount());
        }

    }

}
