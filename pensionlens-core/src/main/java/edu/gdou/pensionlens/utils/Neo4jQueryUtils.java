package edu.gdou.pensionlens.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Neo4jQueryUtils {
    @Autowired
    private Neo4jClient neo4jClient;


    /**
     * @Author: Jackie
     * @Time: 2024-04-22 20:54
     * @Description: Execute the cypher query and return the result
     * @Example:
     * cypherQuery = "MATCH (n:Person {name: {name}}) RETURN n";
     * Map<String, Object> parameters = new HashMap<>();
     * parameters.put("name", "Alice");
     * List<Map<String, Object>> result = neo4jQueryUtils.executeCypherQuery(cypherQuery, parameters, Map. Class);
     * */
    public <T> List<T> executeCypherQuery(String cypherQuery, Map<String, Object> parameters, Class<T> returnType) {
        return (List<T>) neo4jClient.query(cypherQuery).bindAll(parameters).fetchAs(returnType).all();
    }
}