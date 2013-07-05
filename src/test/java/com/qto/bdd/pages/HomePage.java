package com.qto.bdd.pages;

import junit.framework.AssertionFailedError;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class HomePage extends Page {

	@Override
	public void textIsVisible(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		super.textIsVisible(text);
	}

	@Override
	public void textIsVisible(String text, String locator) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		super.textIsVisible(text, locator);
	}

	public HomePage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}

	public void open() {
		open("http://localhost:9001/web/portada");
	}

	public void verifyPage() {
		textIsVisible("Hello world!");
	}

	public void buttonIsNotVisible(String text) {

		try{
			clickButton(text);
		}catch (Exception e) {
			return;
		}		
		throw new RuntimeException("Existe el Boton");
	}

	public void buttonIsVisible(String text) {
		try{
			clickButton(text);
		}catch (Exception e) {
			throw new RuntimeException("No Existe el Boton");
		}		
		return;
	}

	public void textIsNoVisibleThisSystem(String text){

		try{
			textIsVisible(text);
		}catch (Exception e) {
			return;
		}catch (AssertionFailedError e) {
			return;
		}
		throw new RuntimeException("Existe el text: " + text);
	}

	public void logout() {
		clickLink("Logout");
	}

	@Override
	public void click(String locator) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		super.click(locator);
	}

	@Override
	public void clickButton(String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		// TODO Auto-generated method stub
		super.clickButton(name);
	}

	@Override
	public void clickLink(String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		// TODO Auto-generated method stub
		super.clickLink(name);
	}
	
	

}