Feature: Exemplary feature

  Background:
    Given Go to page http://automationpractice.com/index.php

  Scenario Outline: Searching by a word
    Then [AUTOMATION PRACTICE][MAIN PAGE] main page is displayed
    When [AUTOMATION PRACTICE][MAIN PAGE] search for <searched_text>

    Examples:
      | searched_text |
      | blouse        |
      | dress         |