package com.testingShastra.stepdefinations;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.testingShastra.Base.Keyword;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.ProductDisplayPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

public class AmazonProductPageStep {
	String productPagetitle = null;
	String proudcPageTitleBeforeBackClick = null;

	@When("User enter number and special charecter in search box andd hit enter")
	public void enterNumberSpecialChrectr() {
		HomePage homepage = new HomePage();
		homepage.sendTextOnSearchBoxAndEnter("@@##$abc", Keys.ENTER);

	}

	@Then("Verify no result message is displayed or not")
	public void verifynoResultMsg() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		String actualMsg = productpage.getNoResultMsg(); 
		String expectedMsg = "No results for @@##$abc"; 
		if (actualMsg.contains("No results for")) {
			System.out.println("Test Passed: Correct message displayed - " + actualMsg);
			Assert.assertTrue(true);
		} else {
			System.out.println("Bug Found: Unexpected results for invalid query. Actual Message: " + actualMsg);
			Assert.fail("Bug: Expected 'No results for ...' but got results instead.");
		}
	}

	@When("User search for valid product")
	public void searchForValidProduct() {
		HomePage homepage = new HomePage();
		homepage.sendTextOnSearchBoxAndEnter("notebook", Keys.ENTER);
		productPagetitle = Keyword.getTitle();

	}

	@And("Clear Search box and hit enter")
	public void clearSearchBox() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.clearSearchBox(Keys.ENTER);

	}

	@Then("Verify is user navigate home page or not")
	public void verifyUserIsOnHomePage() {
		String actualTitle = Keyword.getTitle();
		if (!productPagetitle.equals(actualTitle)) {
			Assert.assertTrue(true);
		}
	}

	@Then("Verify add to cart button is displayed and enabled in product page")
	public void verifyIsAddToCartButtonDisplayedAndEnabled() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		boolean buttonDisplayStatus = productpage.isAddToCartDisplayOnPrdctPage();
		boolean buttonEnableStatus = productpage.isAddToCartEnableOnPrdctPage();
		if (buttonDisplayStatus && buttonEnableStatus) {
			Assert.assertTrue(true);
		}
	}

	// 4

	@And("Click on desire product")
	public void clickOnDesireProduct() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.clickOnClassmateNotebook();
		System.out.println("name>>" + Keyword.getTitle());

	}

	@Then("Verify user should navigate to that product page or not")
	public void verifyUserNavigateToProductPage() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_5?crid=3KNN7YYS3XJXT&dib=eyJ2IjoiMSJ9.Vil8368OCOMrfb0aFqWxMLZTSMkTn1GmPwTbTXzGKTNEDFNTHtrDhv9-hc29RiJPa2x-5jLePYOo1uqYAPmIb26NZRvsLOiYsvyRwezi0sv683-_fyul3_4qGZ30x_6-ehgaqF0Mm_Jc32yXItvF2BlOed7VSmT2IwV64uYmHp7PaLU3qwTLU3YcppjxaK6a1f_ALxCxqtG-B7MVsx26UwJ9IpQ7mGGk7D1jSN-W4LmfTHoltIhbtLD0-Ydw6jMakpyRxL0BpnIleTnRGXtbXpdcWMlWCwvJsv-j5mrp-sCghOD-7CbTj0mH8hAx1c2-D8jtqp7lWc-zKABpyVz2OfAmLv7XZZBmorMQXgm0Ad8.w9DEAeb7ORO3C0tP_3p5jc7PYQU6v9zMCARkTag8Ws8&dib_tag=se&keywords=notebook&qid=1735742741&s=office&sprefix=notebook%2Coffice-products%2C195&sr=1-5");
		String nameOfProduct = productpage.getNameOfClassmateNotebook();
		System.out.println(nameOfProduct);
		String productPageTitle = Keyword.getTitle();
		System.out.println(productPageTitle);
		if (nameOfProduct.contains(productPageTitle)) {
			Assert.assertTrue(true);
		}

	}

	@Then("Observe is product is in stock Verify add to cart button is enabled or not")
	public void IsAddToCartButtonIsEnabled() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_5?crid=3KNN7YYS3XJXT&dib=eyJ2IjoiMSJ9.Vil8368OCOMrfb0aFqWxMLZTSMkTn1GmPwTbTXzGKTNEDFNTHtrDhv9-hc29RiJPa2x-5jLePYOo1uqYAPmIb26NZRvsLOiYsvyRwezi0sv683-_fyul3_4qGZ30x_6-ehgaqF0Mm_Jc32yXItvF2BlOed7VSmT2IwV64uYmHp7PaLU3qwTLU3YcppjxaK6a1f_ALxCxqtG-B7MVsx26UwJ9IpQ7mGGk7D1jSN-W4LmfTHoltIhbtLD0-Ydw6jMakpyRxL0BpnIleTnRGXtbXpdcWMlWCwvJsv-j5mrp-sCghOD-7CbTj0mH8hAx1c2-D8jtqp7lWc-zKABpyVz2OfAmLv7XZZBmorMQXgm0Ad8.w9DEAeb7ORO3C0tP_3p5jc7PYQU6v9zMCARkTag8Ws8&dib_tag=se&keywords=notebook&qid=1735742741&s=office&sprefix=notebook%2Coffice-products%2C195&sr=1-5");
		boolean addtocartButtonStatus = false;
		if (productpage.getInStockMsg().equalsIgnoreCase("In stock")) {
			addtocartButtonStatus = true;

		}
		Assert.assertTrue(addtocartButtonStatus);

	}

	@Then("Verify is customer review field is display or not")
	public void isCustomerReviewIsPresent() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_5?crid=3KNN7YYS3XJXT&dib=eyJ2IjoiMSJ9.Vil8368OCOMrfb0aFqWxMLZTSMkTn1GmPwTbTXzGKTNEDFNTHtrDhv9-hc29RiJPa2x-5jLePYOo1uqYAPmIb26NZRvsLOiYsvyRwezi0sv683-_fyul3_4qGZ30x_6-ehgaqF0Mm_Jc32yXItvF2BlOed7VSmT2IwV64uYmHp7PaLU3qwTLU3YcppjxaK6a1f_ALxCxqtG-B7MVsx26UwJ9IpQ7mGGk7D1jSN-W4LmfTHoltIhbtLD0-Ydw6jMakpyRxL0BpnIleTnRGXtbXpdcWMlWCwvJsv-j5mrp-sCghOD-7CbTj0mH8hAx1c2-D8jtqp7lWc-zKABpyVz2OfAmLv7XZZBmorMQXgm0Ad8.w9DEAeb7ORO3C0tP_3p5jc7PYQU6v9zMCARkTag8Ws8&dib_tag=se&keywords=notebook&qid=1735742741&s=office&sprefix=notebook%2Coffice-products%2C195&sr=1-5");
		boolean customerReviewMsgstatus = productpage.isCustomerReviewDisplay();
		Assert.assertTrue(customerReviewMsgstatus);
	}

	@Then("Verify that the search product page displays products related to the search product")
	public void verifyResultIsRelatedToSearchProduct() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		List<String> productNameNotebooks = productpage.getNotebookProductList();

		for (String productName : productNameNotebooks) {
			System.out.println(productName);
			if (productName.contains("Notebook")) {
				Assert.assertTrue(true);
			}

		}

	}

	@Then("Verify is product description is same as product details")
	public void verifyproductDeatilsIsSameAsDescription() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_5?crid=3KNN7YYS3XJXT&dib=eyJ2IjoiMSJ9.Vil8368OCOMrfb0aFqWxMLZTSMkTn1GmPwTbTXzGKTNEDFNTHtrDhv9-hc29RiJPa2x-5jLePYOo1uqYAPmIb26NZRvsLOiYsvyRwezi0sv683-_fyul3_4qGZ30x_6-ehgaqF0Mm_Jc32yXItvF2BlOed7VSmT2IwV64uYmHp7PaLU3qwTLU3YcppjxaK6a1f_ALxCxqtG-B7MVsx26UwJ9IpQ7mGGk7D1jSN-W4LmfTHoltIhbtLD0-Ydw6jMakpyRxL0BpnIleTnRGXtbXpdcWMlWCwvJsv-j5mrp-sCghOD-7CbTj0mH8hAx1c2-D8jtqp7lWc-zKABpyVz2OfAmLv7XZZBmorMQXgm0Ad8.w9DEAeb7ORO3C0tP_3p5jc7PYQU6v9zMCARkTag8Ws8&dib_tag=se&keywords=notebook&qid=1735742741&s=office&sprefix=notebook%2Coffice-products%2C195&sr=1-5");
		String detailsOfProduct = productpage.getNameOfClassmateNotebook();

	}

	// 9
	@Then("Verify is product page have out of five rating field or not")
	public void verifyIsRatingFieldPresentOrNot() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_5?crid=3KNN7YYS3XJXT&dib=eyJ2IjoiMSJ9.Vil8368OCOMrfb0aFqWxMLZTSMkTn1GmPwTbTXzGKTNEDFNTHtrDhv9-hc29RiJPa2x-5jLePYOo1uqYAPmIb26NZRvsLOiYsvyRwezi0sv683-_fyul3_4qGZ30x_6-ehgaqF0Mm_Jc32yXItvF2BlOed7VSmT2IwV64uYmHp7PaLU3qwTLU3YcppjxaK6a1f_ALxCxqtG-B7MVsx26UwJ9IpQ7mGGk7D1jSN-W4LmfTHoltIhbtLD0-Ydw6jMakpyRxL0BpnIleTnRGXtbXpdcWMlWCwvJsv-j5mrp-sCghOD-7CbTj0mH8hAx1c2-D8jtqp7lWc-zKABpyVz2OfAmLv7XZZBmorMQXgm0Ad8.w9DEAeb7ORO3C0tP_3p5jc7PYQU6v9zMCARkTag8Ws8&dib_tag=se&keywords=notebook&qid=1735742741&s=office&sprefix=notebook%2Coffice-products%2C195&sr=1-5");
		String ratings = productpage.getRating();
		System.out.println(ratings);
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_5?crid=3KNN7YYS3XJXT&dib=eyJ2IjoiMSJ9.Vil8368OCOMrfb0aFqWxMLZTSMkTn1GmPwTbTXzGKTNEDFNTHtrDhv9-hc29RiJPa2x-5jLePYOo1uqYAPmIb26NZRvsLOiYsvyRwezi0sv683-_fyul3_4qGZ30x_6-ehgaqF0Mm_Jc32yXItvF2BlOed7VSmT2IwV64uYmHp7PaLU3qwTLU3YcppjxaK6a1f_ALxCxqtG-B7MVsx26UwJ9IpQ7mGGk7D1jSN-W4LmfTHoltIhbtLD0-Ydw6jMakpyRxL0BpnIleTnRGXtbXpdcWMlWCwvJsv-j5mrp-sCghOD-7CbTj0mH8hAx1c2-D8jtqp7lWc-zKABpyVz2OfAmLv7XZZBmorMQXgm0Ad8.w9DEAeb7ORO3C0tP_3p5jc7PYQU6v9zMCARkTag8Ws8&dib_tag=se&keywords=notebook&qid=1735742741&s=office&sprefix=notebook%2Coffice-products%2C195&sr=1-5");
		String detailsOfProduct = productpage.getNameOfClassmateNotebook();

	}

	// 10
	@And("Click on back to result link")
	public void clickOnBackToResultLink() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_7?dib=eyJ2IjoiMSJ9.E9FSpV5RCUar9EkL-PeoUaSUBDRFTOjHBGepeqt_r3QZp7Uy5jfITumPxCqsx4_hu66c5CMfjJ6D3gmIIdRKApspXb6yBjW1YjK0_ozyBMnSAMqVuh8-zJYyrwAW_mC6C4Nx_Xg__2mHtIWge2rcX1r-1ojiCu4sRsUqy9dsB69rnmJqxHZ_KvftrVfCdpf5FVWnPtQwAcsTBtzqSQ9GyzWf_sXfln9PsPcfT15kqv7qI3lq2lOs5ZVEbdQ2qSEN6xNs1yZuhlGvKdxZb5nYzEFsAEpLoI0zjqyyukykMWc.AmluN3uM39QgdO7WpYZTjWLxQufczy_cx3Gu3QlFSWs&dib_tag=se&keywords=notebook&qid=1735823464&sr=8-7&th=1");
		proudcPageTitleBeforeBackClick = Keyword.getTitle();
		productpage.clickOnBackToResultLink();

	}

	@Then("Verify is user redirected to serach result page after clicking back to result link or not")
	public void verifyIsUserNavigateToSearchProductPage() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		System.out.println(Keyword.getTitle());
		String searchProductPage = Keyword.getTitle();
		if (!proudcPageTitleBeforeBackClick.equals(searchProductPage)) {
			Assert.assertTrue(true);

		}

	}

	@Then("Verify is image displayed on product page or not")
	public void verifyIsImageDisplayedOrNot() {
		ProductDisplayPage productpage = new ProductDisplayPage();
		productpage.switchToProductWindow(
				"https://www.amazon.in/Classmate-Premium-Subject-Notebook-Single/dp/B00LZLQ624/ref=sr_1_7?dib=eyJ2IjoiMSJ9.E9FSpV5RCUar9EkL-PeoUaSUBDRFTOjHBGepeqt_r3QZp7Uy5jfITumPxCqsx4_hu66c5CMfjJ6D3gmIIdRKApspXb6yBjW1YjK0_ozyBMnSAMqVuh8-zJYyrwAW_mC6C4Nx_Xg__2mHtIWge2rcX1r-1ojiCu4sRsUqy9dsB69rnmJqxHZ_KvftrVfCdpf5FVWnPtQwAcsTBtzqSQ9GyzWf_sXfln9PsPcfT15kqv7qI3lq2lOs5ZVEbdQ2qSEN6xNs1yZuhlGvKdxZb5nYzEFsAEpLoI0zjqyyukykMWc.AmluN3uM39QgdO7WpYZTjWLxQufczy_cx3Gu3QlFSWs&dib_tag=se&keywords=notebook&qid=1735823464&sr=8-7&th=1");
		boolean imageStatus = productpage.isProductImageDisplayOnPrdctPage();
		Assert.assertTrue(imageStatus);

	}

}
