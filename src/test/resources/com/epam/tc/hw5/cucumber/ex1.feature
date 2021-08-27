Feature: Different Elements Page

  Scenario: Checking the operation of basic interactive elements
    Given I open JDI-testing site
    When I login as user 'Roman Iovlev'
    Then user 'Roman Iovlev' logged in
    When I open through the header menu Service -> Different Elements Page
    And I select checkboxes
    Then 'Water' and 'Wind' elements checked
    When I select 'Selen' radio
    Then 'Selen' element checked
    When I select 'Yellow' in dropdown
    Then 'Yellow' element selected
    And log rows are displayed, with values corresponding to the selected