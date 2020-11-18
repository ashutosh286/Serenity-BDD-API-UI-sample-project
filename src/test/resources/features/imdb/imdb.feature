Feature: search imdb

  Background:
    Given the 'imdb' application is running

  @imdb
  Scenario: search imdb by title
    When I search for
      | s                 | type  |
      | lord of the rings | movie |
    Then verify response to keep only movies with titles
      | The Lord of the Rings: The Fellowship of the Ring |
      | The Lord of the Rings: The Return of the King     |
      | The Lord of the Rings: The Two Towers             |

    And open the imdb url
    Then Search for 'lord of the rings' in lookup input
    And Click on Movie in Category Search box
    Then check that Displaying results table contains movie titles from filtered response