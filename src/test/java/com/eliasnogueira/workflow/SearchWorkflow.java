package com.eliasnogueira.workflow;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWorkflow {

    @Test(description = "Execute search workflow")
    public void executeSearch() {

        System.out.println("Executing Search Workflow");

        String searchTerm = "Business Room";
        int resultsFound = 5;

        System.out.println("Searching for: " + searchTerm);
        System.out.println("Results found: " + resultsFound);

        Assert.assertNotNull(searchTerm, "Search term must not be null");
        Assert.assertTrue(resultsFound > 0, "No results found");

        System.out.println("Search workflow executed successfully");
    }
}
