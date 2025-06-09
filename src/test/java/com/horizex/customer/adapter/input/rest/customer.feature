Feature: API Tests for Customer

  Scenario: Create a Customer
    Given url 'http://localhost:8080/horizex/customers'
    And request { "firstName": "jane1", "middleName": "quincy", "lastName": "doe1", "emailAddress": "jane1.doe1@gmail.com", "phoneNumber": "17038675309" }
    When method post
    Then status 201
    And match response == { id: '#notnull', firstName: 'jane1', middleName:"quincy", lastName:"doe1", emailAddress:"jane1.doe1@gmail.com", phoneNumber:"17038675309" }
    # Assert Location header exists and contains new resource URI for the Customer
    And match responseHeaders['Location'][0] contains '/customers/'

    # Get the created Customer
    Given path response.id
    When method get
    Then status 200
    And match response == { id: '#notnull', firstName: 'jane1', middleName:"quincy", lastName:"doe1", emailAddress:"jane1.doe1@gmail.com", phoneNumber:"17038675309" }

    # Delete created Customer
    Given path response.id
    When method delete
    Then status 204

  Scenario: Get non-existent Customer
    Given url 'http://localhost:8080/horizex/customers/550e8400-e29b-41d4-a716-446655440000'
    When method get
    Then status 404

  Scenario: Get all 3 customers created by Flyway to initializae the database with test data
    Given url 'http://localhost:8080/horizex/customers'
    When method get
    Then status 200
    And match response == '#[3]'
