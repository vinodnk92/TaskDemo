@Automation
Feature: www.saucedemo.com Automation
	Scenario: www.saucedemo.com Automation
	Given hit the www.saucedemo.com url
	When enter username
	And enter password
	Then Click on login button
	And Verify home page
	And Sort the items (Lowest Price sort) 
	And Add two or more items to the shopping cart
	And Visit the shopping cart
	And Assert that the items that you added are in the cart
	And Remove an item and then continue shopping
	And Add another item
	And Assert you are purchasing the correct items
	And Assert the total price
	And Finish checkout
	
	