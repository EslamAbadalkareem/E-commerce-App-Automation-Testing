@smoke
Feature: F07_followUs | users could open followUs links
 Scenario Outline: user opens <social> link
  When user opens <social> link
  Then <social> page is opened in new tab
   Examples:
   |social|
   |facebook|
   |twitter |
   |rss     |
   |youtube |
