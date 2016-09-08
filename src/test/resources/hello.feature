Feature: Hello Cukes
	
Scenario: Run rules
	Given I have a HelloCukes object with id of 1 and myString value of 'leet'
	When I run the rules
	Then the HelloCukes object with id 1 will have myInteger value of 1337
	
Scenario: Run rules process
	Given I have a HelloCukes object with id of 2 and myString value of 'leet'
	When I run the rules via the BPMN process
	Then the HelloCukes object with id 2 will have myInteger value of 1337