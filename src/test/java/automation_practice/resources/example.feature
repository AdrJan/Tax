Feature: Exemplary feature

  Background:
    Given Go to page "http://automationpractice.com/index.php"

  Scenario Outline: Searching by a word
    When [AUTOMATION PRACTICE][MAIN PAGE] search for <searched_text>
    Examples:
      | searched_text |
      | blouse        |
      | dress         |