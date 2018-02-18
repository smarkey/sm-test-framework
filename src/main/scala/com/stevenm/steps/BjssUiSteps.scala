package com.stevenm.steps

import com.stevenm.pages.BjssLoginPage
import com.stevenm.utils.SeleniumCucumberTest

class BjssUiSteps extends SeleniumCucumberTest {

  val username = "za2337474@mvrht.net"
  val password = "BJSSTest" //TODO: move this to an encrypted file using kdbx

  Given("""^the customer logs in$"""){ () =>
    val page = new BjssLoginPage
    go to page
  }

	When("""^the customer navigates to the 'T-shirts' page$"""){ () =>
    ???
  }

	When("""^the customer quick views the 'Faded Short Sleeve T-Shirts'$"""){ () =>
    ???
  }

	Then("""^the customer is on the 'Quick View' page$"""){ () =>
    ???
  }

	When("""^the customer changes the product size$"""){ () =>
    ???
  }

	When("""^the customer adds the item to the cart$"""){ () =>
    ???
  }

	Then("""^the customer receives confirmation that an item has been added to the car$"""){ () =>
    ???
  }

	When("""^the customer chooses to 'Continue shopping'$"""){ () =>
    ???
  }

	When("""^the customer navigates to 'Women > Blouses'$"""){ () =>
    ???
  }

	When("""^the customer quick views the 'Blouse'$"""){ () =>
    ???
  }

	When("""^the customer chooses to 'Proceed to checkout'$"""){ () =>
    ???
  }

	Then("""^the Summary displays the correct sizes, prices, number of items and total including shipping$"""){ () =>
    ???
  }

	Then("""^the customer proceeds to the 'Address' step of checkout$"""){ () =>
    ???
  }

	Then("""^the customer proceeds to the 'Shipping' step of checkout$"""){ () =>
    ???
  }

	Then("""^the customer agrees to the Terms of Service$"""){ () =>
    ???
  }

	Then("""^the customer proceeds to the 'Payment' step of checkout$"""){ () =>
    ???
  }

	Then("""^the customer chooses to 'Pay by bank wire'$"""){ () =>
    ???
  }

	Then("""^the customer confirms the order$"""){ () =>
    ???
  }

	Then("""^the order confirmation displays the correct amount$"""){ () =>
    ???
  }

	Then("""^the customer logs out$"""){ () =>
    ???
  }

	When("""^the customer navigates to the 'Order History And Details' page$"""){ () =>
    ???
  }

	When("""^the customer selects the last order$"""){ () =>
    ???
  }

	When("""^the customer selects the 'Blouse' item$"""){ () =>
    ???
  }

	When("""^the customer adds the comment 'Is this blouse available in XXL\?'$"""){ () =>
    ???
  }

	Then("""^the comment is displayed in the Messages section of the order$"""){ () =>
    ???
  }

	Then("""^the first order reference is 'NONEXISTENTREF'$"""){ () =>
    ???
  }

}
